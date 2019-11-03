package org.escalade.model.bean;

import java.util.List;

public class Compte {

    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String mot_de_passe;
    private List<ResaTopo> resaTopos;
    private List<Commentaire> commentaires;
    private List<Topo> topos;

    public Compte() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public List<ResaTopo> getResaTopos() {
        return resaTopos;
    }

    public void setResaTopos(List<ResaTopo> resaTopos) {
        this.resaTopos = resaTopos;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }
}
