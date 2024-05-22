package com.api.hanami.blog.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.hanami.blog.dto.PublicacaoDTO;
import com.api.hanami.blog.model.Publicacao;
import com.api.hanami.blog.service.PublicacaoService;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    private PublicacaoService publicacaoService;

    @PostMapping
    public ResponseEntity<Publicacao> createPublicacao(@RequestBody PublicacaoDTO publicacaoDTO) {
        // Crie uma nova instância de Publicacao
        Publicacao publicacao = new Publicacao();
        
        // Configure os campos com base nos dados recebidos no DTO
        publicacao.setEmail(publicacaoDTO.getEmail());
        publicacao.setTitulo(publicacaoDTO.getTitulo());
        publicacao.setConteudo(publicacaoDTO.getConteudo());
        
        // Obtenha a data atual do sistema
        Date currentDate = new Date();
        
        // Defina a data atual na publicação
        publicacao.setData(currentDate);
        
        // Salve a publicação usando o serviço
        Publicacao savedPublicacao = publicacaoService.save(publicacao);
        
        // Retorne a resposta com a publicação salva e status HTTP 200 (OK)
        return ResponseEntity.ok(savedPublicacao);
    }

}
