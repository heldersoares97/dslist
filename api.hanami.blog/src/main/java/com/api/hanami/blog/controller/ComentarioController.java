package com.api.hanami.blog.controller;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hanami.blog.dto.ComentarioDTO;
import com.api.hanami.blog.model.Comentario;
import com.api.hanami.blog.service.ComentarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/publicacoes")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/{publicacaoId}/comentarios")
    public ResponseEntity<Comentario> createComment(@PathVariable Integer publicacaoId,
                                                 @Valid @RequestBody ComentarioDTO comentarioDTO) throws AttributeNotFoundException {
        Comentario createdComment = comentarioService.createComment(publicacaoId, comentarioDTO);
        return ResponseEntity.ok(createdComment);
    }
}


