package com.onegateafrica.repository;



import com.onegateafrica.entity.Factpaie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactpaieRepository extends JpaRepository<Factpaie, Integer> {
}