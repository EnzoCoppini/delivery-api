package com.deliverytech.delivery_api.repository;
import com.deliverytech.delivery_api.model.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByStatus(String status);

    List<Pedido> findByDataPedidoBetween(LocalDate start, LocalDate end);

    // Combinação de filtros
    List<Pedido> findByClienteIdAndStatusAndDataPedidoBetween(Long clienteId, String status, LocalDate start, LocalDate end);

    // Exemplo de relatório - pedidos agrupados por status
    @Query("SELECT p.status, COUNT(p) FROM Pedido p GROUP BY p.status")
    List<Object[]> contarPedidosPorStatus();
}

