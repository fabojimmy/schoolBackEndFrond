package com.demoperson.school.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoperson.school.model.Niveau;

@Repository
public interface NiveauRes extends JpaRepository<Niveau,Long>{
    
}
