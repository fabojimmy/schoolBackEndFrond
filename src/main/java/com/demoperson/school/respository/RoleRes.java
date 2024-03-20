package com.demoperson.school.respository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demoperson.school.Wrapper.RoleWrapper;
import com.demoperson.school.model.Role;


@Repository
public interface RoleRes extends JpaRepository<Role,Long> {



    @Query("SELECT r FROM role WHERE r.libelle=:libelle")
    public Role findByLibelle(@Param("libelle")String libelle);

    
}
