package com.api.hanami.blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hanami.blog.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	public List<Comentario> findAllByPublicacao_PubliId(Integer publiId);

	    Optional<Comentario> findById(Integer id);
}



