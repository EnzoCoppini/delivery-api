package com.deliverytech.delivery_api.model;
import jakarta.persistence.*;
import java.util.List;

    @Entity
    public class Restaurante {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String categoria;

        private boolean ativo;

        private double avaliacao;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCategoria(){
            return categoria;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }

        public double getAvaliacao() {
            return avaliacao;
        }

        public void setAvaliacao(double avaliacao) {
            this.avaliacao = avaliacao;
        }

        public void setCategoria(String categoria){
            this.categoria= categoria;
        }



}
