package org.escalade.model.bean;

import java.util.Date;
import java.util.List;

public class Topo {

    private Integer id;
    private String nom;
    private String statut;
    private Date date_upload;
    private String description;
    private Integer compte_id;
    private List<Commentaire> commentaires;
    private List<ResaTopo> resaTopos;
    private List<Photo> photos;

    public Topo() {
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_upload() {
        return date_upload;
    }

    public void setDate_upload(Date date_upload) {
        this.date_upload = date_upload;
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

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<ResaTopo> getResaTopos() {
        return resaTopos;
    }

    public void setResaTopos(List<ResaTopo> resaTopos) {
        this.resaTopos = resaTopos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
