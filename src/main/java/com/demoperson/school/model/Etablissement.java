package com.demoperson.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Etablissement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true, nullable = false)
    public String libelle;
    @Column(unique = true, nullable = false)
    private String logo;
    @Column(unique = true, nullable = true)
    public String email;
    @Column(unique = true, nullable = false)
    public String number;
    @Column(unique = false, nullable = false)
    public String adresse;
}
