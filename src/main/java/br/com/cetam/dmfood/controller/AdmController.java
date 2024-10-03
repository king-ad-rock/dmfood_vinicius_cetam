package br.com.cetam.dmfood.controller;

import br.com.cetam.dmfood.domain.adm.Adm;
import br.com.cetam.dmfood.domain.adm.DadosCadastroAdm;
import br.com.cetam.dmfood.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ibc/adm")
public class AdmController {

    @Autowired
    private AdmService admService;

    @PostMapping
    public ResponseEntity<Adm> criarAdm (@RequestBody  DadosCadastroAdm dados){
        Adm novoAdm = admService.criarAdm(dados);
        return new ResponseEntity<>(novoAdm, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Adm> excluirAdm (@PathVariable Long id){
        admService.excluirAdm(id);
        return ResponseEntity.noContent().build();
    }
}
