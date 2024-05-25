package com.api.hanami.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.hanami.blog.model.Publicacao;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {
	// add por Denise
		Optional<Publicacao> findById(Integer publiId);
		
		// Método para excluir uma publicação por ID add Denise
		void deleteById(Integer id); 
		
	}
