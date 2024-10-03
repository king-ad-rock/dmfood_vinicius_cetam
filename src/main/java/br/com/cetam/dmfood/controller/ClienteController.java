package br.com.cetam.dmfood.controller;

import br.com.cetam.dmfood.domain.cliente.Cliente;
import br.com.cetam.dmfood.domain.cliente.DadosCadastroCliente;
import br.com.cetam.dmfood.domain.cliente.DadosListaCliente;
import br.com.cetam.dmfood.domain.cliente.DadosUpdateCliente;
import br.com.cetam.dmfood.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ibc/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente (@RequestBody DadosCadastroCliente dados){
        Cliente novoCliente = clienteService.criarCliente(dados);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DadosListaCliente>> listaClientes(){
        List<DadosListaCliente> clientes = clienteService.listaCliente();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return  cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody DadosUpdateCliente dadosAtualizados) {
        Cliente cliente = clienteService.atualizarCliente(id, dadosAtualizados);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
