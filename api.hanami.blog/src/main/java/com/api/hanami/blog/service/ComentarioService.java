package com.api.hanami.blog.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.hanami.blog.dto.ComentarioDTO;
import com.api.hanami.blog.model.Comentario;
import com.api.hanami.blog.model.Publicacao;
import com.api.hanami.blog.repository.ComentarioRepository;
import com.api.hanami.blog.repository.PublicacaoRepository;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Transactional
    public Comentario createComment(Integer publicacaoId, ComentarioDTO comentarioDTO) throws AttributeNotFoundException {
        System.out.println("Looking for publication with ID: " + publicacaoId);
        
        Optional<Publicacao> optionalPublicacao = publicacaoRepository.findById(publicacaoId);
        if (!optionalPublicacao.isPresent()) {
            System.out.println("Publication not found with ID: " + publicacaoId);
            throw new AttributeNotFoundException("Publicação não encontrada com o id " + publicacaoId);
        }

        Publicacao publicacao = optionalPublicacao.get();
        System.out.println("Publication found: " + publicacao);

        Comentario comentario = new Comentario();
        comentario.setContent(comentarioDTO.getContent());
        comentario.setPublicacao(publicacao);
        comentario.setDate(new Date());

        Comentario savedComment = comentarioRepository.save(comentario);
        System.out.println("Comment saved: " + savedComment);

        return savedComment;
    }

	public static List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Comentario> findAllByPublicacao_Id(Integer publicacaoId) {
		return comentarioRepository.findAllByPublicacao_PubliId(publicacaoId);
	}
	
	@Transactional
    public void deleteComment(Integer comentarioId) {
        comentarioRepository.deleteById(comentarioId);
    }


}
