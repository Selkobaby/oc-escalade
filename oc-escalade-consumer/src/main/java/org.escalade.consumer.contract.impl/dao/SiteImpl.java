package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.SiteDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.SiteRM;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;


public class SiteImpl extends AbstractDataImpl implements SiteDao {

    /**
     * Renvoie la liste des sites demandés
     * @return les {@link Site}
     */
    @Override
    public List<Site> sites() {
        String vSql = "SELECT * FROM public.site";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();

        List<Site> vListSite = vJdbcTemplate.query(vSql, siteRM.getvSiteRowMapper());
        return vListSite;
    }

    /**
     * Ajouter un site
     * @param site
     * @return un message de confirmation
     */
    @Override
    public void addSite(Site site, Compte compte) {

        String vSql = "INSERT INTO public.site (compte_id, nom, region, description) VALUES"
                    + " (:compte_id, :nom, :region, :description)";


        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("compte_id", compte.getId());
        vParams.addValue("nom", site.getNom());
        vParams.addValue("region", site.getRegion());
        vParams.addValue("description", site.getDescription());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie le site demandé
     * @param site_id
     * @return le site correspondant à son id
     */
    @Override
    public Site site(Integer site_id) {

        String vSql = "SELECT * FROM public.site"
                    + " WHERE id = " + site_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM vSiteRM = new SiteRM();

        List<Site> vSiteDetail = vJdbcTemplate.query(vSql, vSiteRM.getvSiteRowMapper());
        return  vSiteDetail.get(0);
    }

    /**
     * Supprimer un site
     * @param id
     * @return un message de confirmation
     */
    @Override
    public void delSite(Integer id) {

        String vSql = "DELETE FROM public.site WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }


    /**
     * Cette méthode permet de mettre à jour un site d'escalade.
     * @param site
     */
    @Override
    public void upSite(Site site) {
        String vSql = "UPDATE public.site SET"
                    + " nom = :nom, region = :region, description = :description"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", site.getId());
        vParams.addValue("nom", site.getNom());
        vParams.addValue("region", site.getRegion());
        vParams.addValue("description", site.getDescription());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie la liste des sites correspondant à la région sélectionnée, au type de voie et la cotation de la voie.
     * @return vListSites
     */
    public List<Site> sitesByAdvancedSearchDao(String regionSelect, String typeVoieSelect, String cotationVoieSelect){

        String vSql = "SELECT distinct site.* FROM site "
                    + " INNER JOIN secteur ON site.id = secteur.site_id\n"
                    + " INNER JOIN voie ON secteur.id = voie.secteur_id\n"
                    + " WHERE voie.type_voie = "+ "'" + typeVoieSelect + "'"
                    + " AND voie.cotation = " + "'" + cotationVoieSelect + "'"
                    + " AND site.region = " + "'"+ regionSelect + "'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM vSiteRM = new SiteRM();

        List<Site> vListSites = vJdbcTemplate.query(vSql, vSiteRM.getvSiteRowMapper());

        return vListSites;
    }

    /**
     * Recherche dans la table "site" une correspondance
     * dans la colonne "nom" ou "region" avec la saissi de l'utilisateur.
     * @param motCleRecherche
     * @return vListSite
     */
    @Override
    public List<Site> siteBySimpleSearchDao(String motCleRecherche) {

        String vSql = "SELECT * FROM public.site"
                    + " WHERE CONCAT(nom, region) LIKE " + "'" + "%" + motCleRecherche + "%" + "'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM vSiteRM = new SiteRM();

        List<Site> vListSite = vJdbcTemplate.query(vSql, vSiteRM.getvSiteRowMapper());
        return vListSite;
    }

    /**
     * Renvoie le site correspondant a site_id du secteur
     * @param site_id
     * @return sites
     */
    public List<Site> searchSiteBySectorDao(Integer site_id){

        String vSql = "SELECT * FROM public.site"
                    + " WHERE id = " + site_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM vSiteRM = new SiteRM();

        List<Site> vListSites = vJdbcTemplate.query(vSql, vSiteRM.getvSiteRowMapper());
        return vListSites;
    }

    @Override
    public List<Site> listSitesByAccountDao(Compte compte) {

        String vSql = "SELECT * FROM public.site"
                    + " WHERE compte_id = " + compte.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM vSiteRM = new SiteRM();

        List<Site> vListSites = vJdbcTemplate.query(vSql, vSiteRM.getvSiteRowMapper());
        return vListSites;
    }

    public Site recoversSiteWorkflowDao(Site site, Compte compte){

        String vSql = "SELECT * FROM public.site"
                     + " WHERE nom = '" + site.getNom() + "'"
                     + " AND region = '" + site.getRegion() + "'"
                     + " AND description = '" + site.getDescription() + "'"
                     + " AND compte_id = " + compte.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM vSiteRM = new SiteRM();

        List<Site> vSite = vJdbcTemplate.query(vSql, vSiteRM.getvSiteRowMapper());
        return  vSite.get(0);
    }

}
