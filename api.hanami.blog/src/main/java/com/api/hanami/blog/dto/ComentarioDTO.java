package com.api.hanami.blog.dto;

import jakarta.validation.constraints.NotBlank;

public class ComentarioDTO {

    @NotBlank(message = "Content cannot be blank")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
