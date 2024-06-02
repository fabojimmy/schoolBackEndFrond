package com.demoperson.school.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NamedQuery(name="Filiere.filiereAll",query="SELECT new com.demoperson.school.Wrapper.FiliereWrapper(f.id,f.libelle) from Filiere f")
@NamedQuery(name="Filiere.getByFiliereId",query="Select f from Filiere f WHERE f.id=:id")

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SuperBuilder
@Builder
@Table(name="filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    public Long id;

    @Column(unique=true)
    public String libelle;

    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL)
    public List<Specialite> specialite;
}
