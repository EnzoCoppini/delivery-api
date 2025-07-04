package com.deliverytech.delivery_api.service;

import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrar(Produto produto) {
        if (produto.getPreco() <= 0) {
            throw new RuntimeException("Preço inválido");
        }
        produto.setDisponivel(true);
        return produtoRepository.save(produto);
    }

    public List<Produto> listarPorRestaurante(Long restauranteId) {
        return produtoRepository.findByRestauranteId(restauranteId);
    }

    public void alterarDisponibilidade(Long produtoId, boolean disponivel) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setDisponivel(disponivel);
        produtoRepository.save(produto);
    }
}
