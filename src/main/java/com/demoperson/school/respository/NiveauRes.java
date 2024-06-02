package com.demoperson.school.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoperson.school.model.Niveau;

@Repository
public interface NiveauRes extends JpaRepository<Niveau,Long>{


    @Query("SELECT n FROM Niveau n WHERE n.id=:id")
    public Niveau findNiveau(@Param("id") Long id);
    
}
