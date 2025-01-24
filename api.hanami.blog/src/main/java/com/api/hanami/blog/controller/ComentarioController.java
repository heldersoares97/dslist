package com.api.hanami.blog.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hanami.blog.dto.ComentarioDTO;
import com.api.hanami.blog.model.Comentario;
import com.api.hanami.blog.repository.ComentarioRepository;
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

	@GetMapping("/{publicacaoId}/comentarios")
	public ResponseEntity<List<Comentario>> getAllComentariosByPublicacaoId(@PathVariable Integer publicacaoId) {
		List<Comentario> comentarios = comentarioService.findAllByPublicacao_Id(publicacaoId);
		return ResponseEntity.ok(comentarios);
	}

	@Autowired
	private ComentarioRepository comentarioRepository;

	@GetMapping("/comentario/{id}")
	public ResponseEntity<Comentario> getComentarioById(@PathVariable Integer id) {
		return comentarioRepository.findById(id).map(comentario -> ResponseEntity.ok(comentario))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/comentarios/{comentarioId}")
	public ResponseEntity<Void> deleteComentario(@PathVariable Integer comentarioId) {
		comentarioService.deleteComment(comentarioId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/comentarios/{id}")
	public ResponseEntity<Comentario> updateComentario(@PathVariable Integer id,
			@Valid @RequestBody ComentarioDTO comentarioDTO) {
		Comentario updatedComment = comentarioService.updateComentario(id, comentarioDTO);
		if (updatedComment != null) {
			return ResponseEntity.ok(updatedComment);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
