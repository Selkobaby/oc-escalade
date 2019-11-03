package org.escalade.model.bean;

import java.util.Date;
import java.util.List;

public class ResaTopo {

    private Integer id;
    private String statut;
    private Date date_debut;
    private Date date_fin;
    private Integer proprietaire_topo;
    private Integer topo_id;
    private Integer compte_id;
    private List<Messagerie> messagerieList;
    private List<Topo> topoList;

    public ResaTopo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Integer getProprietaire_topo() {
        return proprietaire_topo;
    }

    public void setProprietaire_topo(Integer proprietaire_topo) {
        this.proprietaire_topo = proprietaire_topo;
    }

    public Integer getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(Integer topo_id) {
        this.topo_id = topo_id;
    }

    public Integer getCompte_id() {
        return compte_id;
    }

    public void setCompte_id(Integer compte_id) {
        this.compte_id = compte_id;
    }

    public List<Messagerie> getMessagerieList() {
        return messagerieList;
    }

    public void setMessagerieList(List<Messagerie> messagerieList) {
        this.messagerieList = messagerieList;
    }

    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }
}
