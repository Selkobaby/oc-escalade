package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.CompteDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.CompteRM;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class CompteImpl extends AbstractDataImpl implements CompteDao {

    /**
     * Renvoie la liste des comptes demandés
     * @return les {@link Compte}
     * */
    @Override
    public List<Compte> comptes() {

        String vSql = "SELECT * FROM public.compte";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CompteRM vCompteRM = new CompteRM();


        List<Compte> vListeCompte = vJdbcTemplate.query(vSql, vCompteRM.getvCompteRowMapper());
        return vListeCompte;
    }

    /**
     * Ajouter un compte
     * @param compte
     * @return un message de confirmation
     */
    @Override
    public void addCompte(Compte compte) {

        String vSql = "INSERT INTO public.compte(nom, prenom, mail, mot_de_passe) VALUES"
                    + " (:nom, :prenom, :mail, :mot_de_passe)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", compte.getNom());
        vParams.addValue("prenom", compte.getPrenom());
        vParams.addValue("mail", compte.getMail());
        vParams.addValue("mot_de_passe", compte.getMot_de_passe());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie le compte demandé
     * @param compte_id
     * @return le compte correspondant à son id
     */
    @Override
    public Compte compte(Integer compte_id) {

        String vSql = "SELECT * FROM public.compte"
                    + " WHERE id = " + compte_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CompteRM vCompteRM = new CompteRM();

        List<Compte> vCompteDetail = vJdbcTemplate.query(vSql, vCompteRM.getvCompteRowMapper());
        return vCompteDetail.get(0);
    }

    /**
     * Supprimer un compte
     * @param id
     * @return un message de confirmation
     */
    @Override
    public void delCompte(Integer id) {

        String vSql = "DELETE FROM public.compte WHERE id = :id";


        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaj = vJdbcTemplate.update(vSql, vParams);

    }

    /**
     * Mettre à jour les informations d'un compte
     * @param compte
     * @return un message de confirmation
     */
    @Override
    public void upCompte(Compte upCompte, Compte compte) {

        String vSql = "UPDATE public.compte SET"
                    + " nom = :nom, prenom = :prenom, mail = :mail, mot_de_passe = :mot_de_passe"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", compte.getId());
        vParams.addValue("nom", upCompte.getNom());
        vParams.addValue("prenom", upCompte.getPrenom());
        vParams.addValue("mail", upCompte.getMail());
        vParams.addValue("mot_de_passe", upCompte.getMot_de_passe());


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie le compte d'un utilisateur
     * @param login
     * @param password
     * @return
     */
    @Override
    public Compte comptByUtilisateur(String login, String password) {
        String vSql = "SELECT * FROM public.compte"
                    + " WHERE mail = " + "'" + login + "'"
                    + " AND mot_de_passe = " + "'" + password + "'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CompteRM vCompteRM = new CompteRM();

        List<Compte> vUtilisateur = vJdbcTemplate.query(vSql, vCompteRM.getvCompteRowMapper());
        return vUtilisateur.get(0);
    }

    public List<Compte> compteByCommentairesDao(Commentaire commentaire){

        String vSql = "SELECT * FROM public.compte"
                    + " WHERE id = " + commentaire.getCompte_id();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CompteRM vCompteRM = new CompteRM();

        List<Compte> compteList = vJdbcTemplate.query(vSql, vCompteRM.getvCompteRowMapper());
        return compteList;
    }

    /**
     * Cette méthode récupère les comptes des utilisateurs qui on fait une demande de réservation de topo.
     * @param compte_id
     * @return
     */
    public List<Compte> compteByResaTopoDao(Integer compte_id){

        String vSql = "SELECT * FROM public.compte"
                    + " WHERE id = " + compte_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CompteRM vCompteRM = new CompteRM();

        List<Compte> compteList = vJdbcTemplate.query(vSql, vCompteRM.getvCompteRowMapper());
        return compteList;
    }

    /**
     * Cette méthode récupère les comptes des propriétaires à qui on a adressé une demande de topo.
     * @param topo_id
     * @return
     */
    public List<Compte> ownerAccountByResaTopoDao(Integer topo_id){

        String vSql = "SELECT compte.* FROM public.compte"
                    + " INNER JOIN topo ON topo.id = " + topo_id
                    + " WHERE compte.id = topo.compte_id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CompteRM vCompteRM = new CompteRM();

        List<Compte> vCompteList = vJdbcTemplate.query(vSql, vCompteRM.getvCompteRowMapper());
        return vCompteList;
    }
}
