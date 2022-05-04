package com.onegateafrica.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FactpaieDto {
    private long id;
    private String contenu;
    private LocalDate date;

    public long FactpaieDtoId(){
        return getId();
    }

    public FactpaieDto() {
    }

    public FactpaieDto(long id, String contenu, String date) {
        this.id = id;
        this.contenu = contenu;
        this.date = LocalDate.parse(date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
