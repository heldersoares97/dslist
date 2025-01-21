package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String shortDescription;
    private String imgUrl;

    // Construtor que inicializa os campos do DTO com os valores da entidade.
    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.genre = entity.getGenre();
        this.shortDescription = entity.getShortDescription();
        this.imgUrl = entity.getImgUrl();
    }

    // Construtor alternativo, caso precise inicializar o DTO diretamente.
    public GameMinDTO(Long id, String title, Integer year, String genre, String shortDescription, String imgUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.shortDescription = shortDescription;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}

