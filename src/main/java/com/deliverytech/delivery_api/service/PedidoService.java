package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criar(Pedido pedido) {
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus("PENDENTE");
        // Cálculo de valores se necessário (ex: somar preços dos produtos)
        return pedidoRepository.save(pedido);
    }

    public Pedido alterarStatus(Long id, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }
}
