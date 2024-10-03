package br.com.cetam.dmfood.service;

import br.com.cetam.dmfood.domain.cliente.Cliente;
import br.com.cetam.dmfood.domain.cliente.DadosCadastroCliente;
import br.com.cetam.dmfood.domain.cliente.DadosListaCliente;
import br.com.cetam.dmfood.domain.cliente.DadosUpdateCliente;
import br.com.cetam.dmfood.domain.endereco.Endereco;
import br.com.cetam.dmfood.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(DadosCadastroCliente dados) {
        Cliente cliente = new Cliente(dados);
        return clienteRepository.save(cliente);
    }

    public List<DadosListaCliente> listaCliente() {
        return clienteRepository.findAll().stream()
                .map(DadosListaCliente::new)
                .collect(Collectors.toList());
    }
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
    public Cliente atualizarCliente(Long id, DadosUpdateCliente dados) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        cliente.setCpf(dados.cpf());
        cliente.setRg(dados.rg());
        cliente.setNome(dados.nome());
        cliente.setEmail(dados.email());
        cliente.setTelefone(dados.telefone());
        cliente.setEndereco(new Endereco(dados.endereco()));
        cliente.setAtivo(true);

        return clienteRepository.save(cliente);
    }
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
