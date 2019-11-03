package org.escalade.model.bean;

import java.util.List;

public class Site {

    /* ==================== Attributs ==================== */
    private Integer id;
    private String nom;
    private String region;
    private String description;
    private Integer compte_id;
    private List<Secteur> listSecteurs;
    private List<Photo> photos;
    private List<Commentaire> commentaires;

    /* ==================== Constructeurs ==================== */
    public Site() {

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompte_id() {
        return compte_id;
    }

    public void setCompte_id(Integer compte_id) {
        this.compte_id = compte_id;
    }

    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
