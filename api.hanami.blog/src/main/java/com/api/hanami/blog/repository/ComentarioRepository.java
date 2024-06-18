package com.api.hanami.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hanami.blog.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
