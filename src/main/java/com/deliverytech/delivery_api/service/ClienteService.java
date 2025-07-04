package com.deliverytech.delivery_api.service;
import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        Optional<Cliente> existente= clienteRepository.findByEmail(cliente.getEmail());
        if (existente.isPresent()){
            throw new RuntimeException("E-mail já cadastrado");
        }else {
            cliente.setAtivo(true);
            return clienteRepository.save(cliente);
        }
    }

   public List<Cliente> findByAtivoTrue(){
            return clienteRepository.findByAtivoTrue();
   }

   public Optional<Cliente>buscarPorId(Long id){
        return clienteRepository.findById(id);
   }

    public Cliente atualizar(Long id, Cliente novosDados) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(novosDados.getNome());
        cliente.setEmail(novosDados.getEmail());
        return clienteRepository.save(cliente);
    }
    public void inativar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }

}
