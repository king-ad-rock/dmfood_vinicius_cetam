package br.com.cetam.dmfood.service;

import br.com.cetam.dmfood.domain.venda.DadosCadastroVenda;
import br.com.cetam.dmfood.domain.venda.Venda;
import br.com.cetam.dmfood.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public Venda cadastrarVenda(DadosCadastroVenda dados){
        Venda venda = new Venda(dados);
        return vendaRepository.save(venda);
    }

}
