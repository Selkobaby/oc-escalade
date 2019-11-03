package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.SecteurDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.SecteurRM;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.util.List;

public class SecteurImpl extends AbstractDataImpl implements SecteurDao {

    /**
     * Renvoie la liste des secteurs demandés
     * @return les {@link Secteur}
     * */
    @Override
    public List<Secteur> secteurs() {

        String vSql = "SELECT * FROM public.secteur";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vListSecteur = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return vListSecteur;
    }

    /**
     * Ajouter un secteur
     * @param secteur
     * @return un message de confirmation
     */
    @Override
    public void addSecteur(Secteur secteur, Integer site_id) {

        String vSql = "INSERT INTO public.secteur (site_id, nom, description) VALUES"
                    + " (:site_id, :nom, :description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("site_id", site_id);
        vParams.addValue("nom", secteur.getNom());
        vParams.addValue("description", secteur.getDescription());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie le secteur demandé
     * @param id
     * @return le secteur correspondant à son id
     */
    @Override
    public Secteur secteur(Integer id) {

        String vSql = "SELECT * FROM public.secteur "
                + " WHERE id = " + id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vSecteurDetail = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return  vSecteurDetail.get(0);
    }

    /**
     * Supprimer un secteur
     * @param id
     * @return un message de confirmation
     */
    @Override
    public void delSecteur(Integer id) {

        String vSql = "DELETE FROM public.secteur WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    /**
     * Mettre à jour un secteur
     * @return un message de confirmation
     */
    @Override
    public void upSecteur(Secteur secteur) {

        String vSql = "UPDATE public.secteur SET"
                    + " nom = :nom, description = :description"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", secteur.getId());
        vParams.addValue("nom", secteur.getNom());
        vParams.addValue("description", secteur.getDescription());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     *Renvoie les secteurs correspondant au site sélectionné
     * @param site_id
     * @return les Secteurs
     */
    public List<Secteur> secteursBySiteId(Integer site_id){

        String vSql = "SELECT * FROM public.secteur "
                    + " WHERE site_id = " + site_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vListScteurs = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return vListScteurs;
    }

    /**
     * Recherche dans la base de données dans la colonne "nom", le "secteur" en correspondance
     * avec la saisie de l'utilisateur.
     * @param motCleRecherche
     * @return vListSecteurs
     */
    @Override
    public List<Secteur> secteurBySimpleSearchDao(String motCleRecherche) {
        String vSql = "SELECT * FROM public.secteur"
                    + " WHERE nom LIKE " + "'" + motCleRecherche + "%" + "'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return vListSecteurs;
    }

    /**
     * Renvoie le secteur correspondant a secteur_id de la voie trouver
     * lors de la recherche.
     * @param secteur_id
     * @return sites
     */
    public List<Secteur> rechercheSecteurParVoie(Integer secteur_id){

        String vSql = "SELECT * FROM public.secteur"
                    + " WHERE id = " + secteur_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return vListSecteurs;
    }

    /**
     * Renvoie les secteurs correspondant à la session en cours
     * @param compte
     * @return
     */
    public List<Secteur> listSecteurByAccountDao(Compte compte){

        String vSql = "SELECT secteur.* FROM public.secteur"
                    + " INNER JOIN site ON site.compte_id = " + compte.getId()
                    + " WHERE secteur.site_id = site.id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return vListSecteurs;
    }

    /**
     * Cette méthode renvoie le secteur précédemment ajouter dans le Workflow pour transmettre l'id de celui-ci
     * a l'action pour ajouter la voie correspondant à ce secteur.
     * @param site
     * @param secteur
     * @return
     */
    public Secteur recoversSecteurWorkflowDao(Secteur secteur, Site site){

        String vSql = "SELECT * FROM public.secteur"
                    + " WHERE nom = '" + secteur.getNom() + "'"
                    + " AND site_id = " + site.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SecteurRM vSecteurRM = new SecteurRM();

        List<Secteur> vSecteur = vJdbcTemplate.query(vSql, vSecteurRM.getvSecteurRowMapper());
        return vSecteur.get(0);
    }

}
