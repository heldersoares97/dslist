package com.api.hanami.blog.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.api.hanami.blog.dto.PublicacaoDTO;
import com.api.hanami.blog.model.Publicacao;
import com.api.hanami.blog.service.PublicacaoService;

@Controller
@RequestMapping("/publicacoes")
public class PublicacaoController {

	@Autowired
	private PublicacaoService publicacaoService;

	@PostMapping
	public String createPublicacao(@ModelAttribute PublicacaoDTO publicacaoDTO) {
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

		// Redireciona para a página index.html
		return "redirect:/";
	}

	// Método GET para listar todas as publicações com ID, título e conteúdo
	@GetMapping
	public ResponseEntity<List<Publicacao>> getAllPublicacoes() {
		List<Publicacao> publicacoes = publicacaoService.findAll();
		return ResponseEntity.ok(publicacoes);
	}

	// Método para obter uma publicação pelo ID add Denise

	@GetMapping("/{id}")
	public ResponseEntity<Publicacao> getPublicacaoById(@PathVariable Integer id) {
		Publicacao publicacao = publicacaoService.findById(id);

		if (publicacao != null) {
			return ResponseEntity.ok(publicacao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Método DELETE para excluir uma publicação por ID add Denise

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePublicacaoById(@PathVariable Integer id) {
		// Verifica se a publicação existe

		if (publicacaoService.findById(id) != null) {
			publicacaoService.deleteById(id); // Chama o método do serviço para excluir a publicação

			return ResponseEntity.noContent().build(); // Retorna resposta de sucesso sem conteúdo

		} else {
			return ResponseEntity.notFound().build(); // Retorna resposta de que a publicação não foi encontrada
		}
	}

	// Método PUT para atualizar uma publicação por ID
	@PutMapping("/{id}")
	public ResponseEntity<Publicacao> updatePublicacao(@PathVariable Integer id, @RequestBody Publicacao publicacao) {
		// Verifica se o título e o conteúdo não estão vazios
		if (publicacao.getTitulo() == null || publicacao.getTitulo().isEmpty() || publicacao.getConteudo() == null
				|| publicacao.getConteudo().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		// Busca a publicação pelo ID
		Publicacao existentePublicacao = publicacaoService.findById(id);
		if (existentePublicacao != null) {
			// Atualiza os campos da publicação
			existentePublicacao.setTitulo(publicacao.getTitulo());
			existentePublicacao.setConteudo(publicacao.getConteudo());

			// Salva a publicação atualizada
			Publicacao updatePublicacao = publicacaoService.save(existentePublicacao);

			// Retorna a resposta com a publicação atualizada e status HTTP 200 (OK)
			return ResponseEntity.ok(updatePublicacao);
		} else {
			// Retorna resposta de que a publicação não foi encontrada
			return ResponseEntity.notFound().build();
		}
	}

}
