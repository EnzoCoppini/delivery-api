package com.deliverytech.delivery_api.repository;
import com.deliverytech.delivery_api.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByNomeContainingIgnoreCase(String nome);

    List<Restaurante> findByCategoriaId(Long categoriaId);

    List<Restaurante> findByAtivoTrue();

    List<Restaurante> findAllByAtivoTrue(Sort sort);

    // Exemplo com @Query (JPQL)
    @Query("SELECT r FROM Restaurante r WHERE r.nome LIKE %:nome% AND r.ativo = true ORDER BY r.avaliacao DESC")
    List<Restaurante> buscarPorNomeAtivoOrdenadoPorAvaliacao(String nome);
}
