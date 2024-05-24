package com.api.hanami.blog.controller;

import java.util.Date;
import java.util.List;
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
}

	

