package com.onegateafrica.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "activity")
public class Activity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;


    private String nameActivite;


    @Lob
    private String imageActivite;


}