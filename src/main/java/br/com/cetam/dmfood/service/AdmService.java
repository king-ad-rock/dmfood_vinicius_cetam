package br.com.cetam.dmfood.service;

import br.com.cetam.dmfood.domain.adm.Adm;
import br.com.cetam.dmfood.domain.adm.DadosCadastroAdm;
import br.com.cetam.dmfood.domain.adm.DadosListaAdm;
import br.com.cetam.dmfood.domain.adm.DadosUpdateAdm;
import br.com.cetam.dmfood.repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdmService {
    @Autowired
    private AdmRepository admRepository;

    public Adm criarAdm(DadosCadastroAdm dados){
        Adm adm = new Adm(dados);
        return admRepository.save(adm);
    }

    public List<DadosListaAdm> listarAdm(){
        return admRepository.findAll().stream()
                .map(DadosListaAdm::new)
                .collect(Collectors.toList());
    }

    public Optional<Adm> buscarAdmPorId(Long id){ return admRepository.findById(id); }
    public Adm atualizarAdm(Long id, DadosUpdateAdm dados){
        Adm adm = admRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alunão não encontrado"));

        adm.setNomeAdm(dados.nome());
        adm.setEmail(dados.email());

        return admRepository.save(adm);
    }
    public void excluirAdm(Long id){admRepository.deleteById(id);}
}
