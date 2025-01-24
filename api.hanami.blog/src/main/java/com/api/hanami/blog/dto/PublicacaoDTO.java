package com.api.hanami.blog.dto;

import java.util.Date;

public class PublicacaoDTO {

    private String email;
    private String titulo;
    private String conteudo;
    private Date data;

    // Construtor padrão
    public PublicacaoDTO() {
    }

    // Construtor com parâmetros
    public PublicacaoDTO(String email, String titulo, String conteudo, Date data) {
        this.email = email;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = new Date();
    }

    // Getters e Setters
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
}
