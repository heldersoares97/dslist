package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMinDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String shortDescription;
    private String imgUrl;

    public GameMinDTO() {}  // Construtor padrão
    
    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.genre = entity.getGenre();
        this.shortDescription = entity.getShortDescription();
        this.imgUrl = entity.getImgUrl();
    }

    public GameMinDTO(GameMinProjection projection) {  // Novo construtor
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.year = projection.getGameYear();
        this.shortDescription = projection.getShortDescription();
        this.imgUrl = projection.getImgUrl();
    }
    
    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Integer getYear() { return year; }
    public String getShortDescription() { return shortDescription; }
    public String getImgUrl() { return imgUrl; }    
}


