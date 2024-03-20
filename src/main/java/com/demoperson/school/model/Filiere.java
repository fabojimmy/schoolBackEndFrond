package com.demoperson.school.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SuperBuilder
@Builder

public class Filiere {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    public Long id;

    @Column(unique=true)
    public String libelle;

    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL)
    public List<Specialite> specialite;
}
