package com.api.hanami.blog.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publicacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int publiId;
	
	@Column (nullable = false)
	private String email;
	
	@Column (nullable = false)
	private String titulo;
	
	@Column (nullable = false)
	private String conteudo;
	
	@Column (nullable = false)
	private Date data;

	public Publicacao() {
	}

	public Publicacao(int publiId, String email, String titulo, String conteudo, Date data) {
		super();
		this.publiId = publiId;
		this.email = email;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.data = data;
	}

	public int getPubliId() {
		return publiId;
	}

	public void setPubliId(int publiId) {
		this.publiId = publiId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(publiId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacao other = (Publicacao) obj;
		return publiId == other.publiId;
	}
	
	public Publicacao orElse(Object object) {
		// TODO Auto-generated method stub add Denise
		return null;
	}

	
}
