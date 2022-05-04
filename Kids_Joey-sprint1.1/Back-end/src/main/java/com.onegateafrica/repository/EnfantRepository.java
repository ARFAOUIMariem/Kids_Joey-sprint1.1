package com.onegateafrica.repository;

import com.onegateafrica.entity.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfantRepository extends  JpaRepository<Enfant,Integer>{

}
