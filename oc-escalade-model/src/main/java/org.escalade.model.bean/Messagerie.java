package org.escalade.model.bean;

import java.util.Date;

public class Messagerie {

    private Integer id;
    private Date date_message;
    private String message;
    private Integer resa_topo_id;
    private Integer compte_id;

    public Messagerie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_message() {
        return date_message;
    }

    public void setDate_message(Date date_message) {
        this.date_message = date_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResa_topo_id() {
        return resa_topo_id;
    }

    public void setResa_topo_id(Integer resa_topo_id) {
        this.resa_topo_id = resa_topo_id;
    }

    public Integer getCompte_id() {
        return compte_id;
    }

    public void setCompte_id(Integer compte_id) {
        this.compte_id = compte_id;
    }

}
