package org.escalade.model.bean;

public class Longueur {

    private Integer id;
    private String cotation;
    private Float hauteur;
    private int num_longueur;
    private int num_relai;
    private Integer voie_id;

    public Longueur() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public Float getHauteur() {
        return hauteur;
    }

    public void setHauteur(Float hauteur) {
        this.hauteur = hauteur;
    }

    public int getNum_longueur() {
        return num_longueur;
    }

    public void setNum_longueur(int num_longueur) {
        this.num_longueur = num_longueur;
    }

    public int getNum_relai() {
        return num_relai;
    }

    public void setNum_relai(int num_relai) {
        this.num_relai = num_relai;
    }

    public Integer getVoie_id() {
        return voie_id;
    }

    public void setVoie_id(Integer voie_id) {
        this.voie_id = voie_id;
    }
}

