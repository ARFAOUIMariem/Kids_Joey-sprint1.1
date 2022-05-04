package com.onegateafrica.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "planning")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate datedepartplanning;
    private  LocalDate dateariveplanning;



    @Override
    public String toString() {
        return "planning{" +
                "id=" + id +
                ", datedepartplanning='" + datedepartplanning + '\'' +
                ", dateariveplanning='" + dateariveplanning + '\'' +
                '}';
    }
}