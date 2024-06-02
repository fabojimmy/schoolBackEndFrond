package com.demoperson.school.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NamedQuery(name="Specialite.specialiteAll",query="SELECT new com.demoperson.school.Wrapper.SpecialiteWrapper(s.id,s.libelle,s.filiere.id,s.filiere.libelle) FROM Specialite s")
@NamedQuery(name="Specialite.getSpecId",query="SELECT new com.demoperson.school.Wrapper.SpecialiteWrapper(s.id,s.libelle,s.filiere.id,s.filiere.libelle) FROM Specialite s where id=:id")

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SuperBuilder
@Builder
@Table(name = "specialite")
public class Specialite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique=true)
    public String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filiere_id")
    public Filiere filiere;

    @OneToMany(mappedBy = "specialite",cascade = CascadeType.ALL)
    private List<SpecialiteNiveau> specialiteni;

    

}
