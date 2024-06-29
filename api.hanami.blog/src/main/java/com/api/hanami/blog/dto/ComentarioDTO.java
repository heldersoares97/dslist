package com.api.hanami.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public class ComentarioDTO {

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotNull
    private Date date;

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
