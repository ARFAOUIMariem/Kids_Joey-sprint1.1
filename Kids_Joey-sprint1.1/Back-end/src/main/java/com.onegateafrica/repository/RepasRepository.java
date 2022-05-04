package com.onegateafrica.repository;


import com.onegateafrica.entity.repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepasRepository extends JpaRepository<repas, Integer> {


}

