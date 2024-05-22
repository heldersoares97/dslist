package com.api.hanami.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hanami.blog.model.Publicacao;
import com.api.hanami.blog.repository.PublicacaoRepository;

@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public Publicacao save(Publicacao publicacao) {
        return publicacaoRepository.save(publicacao);
    }
}
