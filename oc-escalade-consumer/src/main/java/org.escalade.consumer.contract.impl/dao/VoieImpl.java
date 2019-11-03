package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.VoieDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.VoieRM;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class VoieImpl extends AbstractDataImpl implements VoieDao {

    /**
     * Renvoie la liste des voies demandées
     * @return les {@link Voie}
     */
    @Override
    public List<Voie> voies(Integer secteur_id) {

        String vSql = "SELECT * FROM public.voie"
                    + " WHERE secteur_id = " + secteur_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();

        List<Voie> vListVoie = vJdbcTemplate.query(vSql, voieRM.getVoieRowMapper());
        return vListVoie;
    }

    /**
     * Ajouter une voie
     * @param voie
     * @return un message de confirmation
     */
    @Override
    public void addVoie(Voie voie, Secteur secteur) {

        String vSql = "INSERT INTO public.voie (nom, description, type_voie, cotation, hauteur, secteur_id) VALUES"
                    + " (:nom, :description, :type_voie, :cotation, :hauteur, :secteur_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", voie.getNom());
        vParams.addValue("description", voie.getDescription());
        vParams.addValue("type_voie", voie.getType_voie());
        vParams.addValue("cotation", voie.getCotation());
        vParams.addValue("hauteur", voie.getHauteur());
        vParams.addValue("secteur_id", secteur.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie la voie demandée
     * @param id
     * @return la voie correspondant à son id
     */
    @Override
    public Voie voie(Integer id) {

        String vSql = "SELECT * FROM public.voie"
                + " WHERE id = " + id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM vVoieRM = new VoieRM();

        List<Voie> vListVoie = vJdbcTemplate.query(vSql, vVoieRM.getVoieRowMapper());
        return vListVoie.get(0);
    }

    /**
     * Supprimer une voie
     * @param id
     * @return un message de confirmation
     */
    @Override
    public void delVoie(Integer id) {

        String vSql = "DELETE FROM public.voie where id = :id";

        MapSqlParameterSource vParmas = new MapSqlParameterSource();
        vParmas.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParmas);
    }

    /**
     * Mettre à jour une voie
     * @param voie
     * @return un message de confirmation
     */
    @Override
    public void upVoie(Voie voie) {

        String vSql = "UPDATE public.voie SET"
                    + " nom = :nom, description = :description, type_voie = :type_voie, cotation = :cotation, hauteur = :hauteur"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", voie.getId());
        vParams.addValue("nom", voie.getNom());
        vParams.addValue("description", voie.getDescription());
        vParams.addValue("type_voie", voie.getType_voie());
        vParams.addValue("cotation", voie.getCotation());
        vParams.addValue("hauteur", voie.getHauteur());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    /**
     * Recherche dans la table "voie" une correspondance
     * dans la colonne "nom" avec la saissi de l'utilisateur.
     * @param motCleRecherche
     * @return vListVoie
     */
    @Override
    public List<Voie> SimpleSearchByClimbingRoute(String motCleRecherche) {

        String vSql = "SELECT * FROM public.voie"
                + " WHERE nom LIKE " + "'" + motCleRecherche + "%" + "'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM vVoieRM = new VoieRM();

        List<Voie> vListVoie = vJdbcTemplate.query(vSql, vVoieRM.getVoieRowMapper());
        return vListVoie;
    }


    public List<Voie> listVoiesByAccountDao(Compte compte){

        String vSql = "SELECT  voie.* FROM public.voie"
                    + " INNER JOIN site ON site.compte_id = " + compte.getId()
                    + " INNER JOIN secteur ON secteur.site_id = site.id"
                    + " WHERE voie.secteur_id = secteur.id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM vVoieRM = new VoieRM();

        List<Voie> listVoies = vJdbcTemplate.query(vSql, vVoieRM.getVoieRowMapper());
        return listVoies;
    }

    /**
     * Cette méthode renvoie la voie précédemment ajouter dans le Workflow pour transmettre l'id de celle-ci
     * a l'action pour ajouter les longueurs correspondant à cette même voie.
     * @param voie
     * @param secteur
     * @return
     */
    public Voie recoversVoieWorkflowDao(Voie voie, Secteur secteur){

        String vSql = "SELECT * FROM public.voie"
                + " WHERE nom = '" + voie.getNom() + "'"
                + " AND type_voie = '" + voie.getType_voie() + "'"
                + " AND cotation = '" + voie.getCotation() + "'"
                + " AND  hauteur = '" + voie.getHauteur() + "'"
                + " AND secteur_id = " + secteur.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM vVoieRM = new VoieRM();

        List<Voie> vVoie = vJdbcTemplate.query(vSql, vVoieRM.getVoieRowMapper());
        return vVoie.get(0);
    }
}
