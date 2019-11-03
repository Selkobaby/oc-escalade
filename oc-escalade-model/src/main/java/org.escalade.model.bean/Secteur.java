package org.escalade.model.bean;

import java.util.List;

public class Secteur {

    /* ==================== Attributs ==================== */
    private Integer id;
    private String nom;
    private String description;
    private Integer site_id;
    private List<Voie> listVoies;

    /* ==================== Constructeurs ==================== */
    public Secteur() {
    }

    /* ==================== Getters/Setters ==================== */
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public List<Voie> getListVoies() {
        return listVoies;
    }

    public void setListVoies(List<Voie> listVoies) {
        this.listVoies = listVoies;
    }
}
