package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante cadastrar(Restaurante restaurante) {
        restaurante.setAtivo(true);
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listarAtivos() {
        return restauranteRepository.findByAtivoTrue();
    }

    public void alterarStatus(Long id, boolean ativo) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        restaurante.setAtivo(ativo);
        restauranteRepository.save(restaurante);
    }
}
