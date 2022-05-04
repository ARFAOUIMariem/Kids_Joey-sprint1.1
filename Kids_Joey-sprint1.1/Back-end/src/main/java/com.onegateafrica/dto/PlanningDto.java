package com.onegateafrica.dto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanningDto {
    private long id;
    private LocalDate dateariveplanning;
    private LocalDate datedepartplanning;

    public long getPlanningDtoId(){
        return getId();
    }


    public PlanningDto(long id, String datearr, String datedep) {
        this.id = id;
        this.dateariveplanning= dateariveplanning;
        this.dateariveplanning = datedepartplanning;
    }

    public PlanningDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateariveplanning() {
        return dateariveplanning;
    }

    public void setDateariveplanning(LocalDate dateariveplanning) {
        this.dateariveplanning = dateariveplanning;
    }

    public LocalDate getDatedepartplanning() {
        return datedepartplanning;
    }

    public void setDatedepartplanning(LocalDate datedepartplanning) {
        this.datedepartplanning = datedepartplanning;
    }
}
