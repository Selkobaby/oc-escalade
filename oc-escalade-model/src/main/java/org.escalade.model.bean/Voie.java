package org.escalade.model.bean;

import java.util.List;

public class Voie {

    private Integer id;
    private String nom;
    private String type_voie;
    private String cotation;
    private float hauteur;
    private String description;
    private List<Longueur> longueursRelais;
    private Integer secteur_id;


    public Voie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType_voie() {
        return type_voie;
    }

    public void setType_voie(String type_voie) {
        this.type_voie = type_voie;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Longueur> getLongueursRelais() {
        return longueursRelais;
    }

    public void setLongueursRelais(List<Longueur> longueursRelais) {
        this.longueursRelais = longueursRelais;
    }

    public Integer getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(Integer secteur_id) {
        this.secteur_id = secteur_id;
    }
}
