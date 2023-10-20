package com.gfelix.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.gfelix.demo.domain.CadastroDTO;
import com.gfelix.demo.repository.CadastroRepository;

@RestController
@RequestMapping("cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository cadastroRepository;
    
    @PostMapping("/new")
    public ResponseEntity cadastro(@RequestBody CadastroDTO cadastro) {
        System.out.println(cadastro);
        cadastroRepository.cadastro(cadastro);
        System.out.println(cadastro);
        return ResponseEntity.ok().build();
    }


}
