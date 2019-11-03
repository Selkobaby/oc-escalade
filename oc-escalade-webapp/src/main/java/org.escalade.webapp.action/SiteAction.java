package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  Action de gestion des {@link Site}
 */
public class SiteAction extends ActionSupport implements SessionAware {

    // =============== Attributs ===============
    private Integer site_id;

    // ----- Eléments en sortie -----

    private List<String> listRegions = new ArrayList(Arrays.asList("Ile-de-France", "Champagne-Ardenne", "Picardie",
            "Haute-Normandie", "Centre", "Basse-Normandie", "Bourgogne", "Nord-Pas-de-Calais", "Lorraine", "Alsace",
            "Franche-Comté", "Pays de la Loire", "Bretagne", "Poitou-Charentes", "Aquitaine", "Midi-Pyrénées",
            "Limousin", "Rhône-Alpes", "Auvergne", "Languedoc-Roussillon", "Provence-Alpes-Côte d'Azur",
            "Corse", "Guadeloupe", "Martinique", "Guyane", "La Réunion", "Mayotte"));

    // ----- Eléments en entrée -----
    private List<Site> listSites;
    private Site site;
    private Site modifiedSite;
    private Compte compte;
    private Commentaire commentaire;

    // ----- Eléments Struts
    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    // ============ Getters/Setters ============

    public List<String> getListRegions() {
        return listRegions;
    }

    public void setListRegions(List<String> listRegions) {
        this.listRegions = listRegions;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public List<Site> getListSites() {
        return listSites;
    }

    public void setListSites(List<Site> listSites) {
        this.listSites = listSites;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    //    ===================================

    public Site getModifiedSite() {
        return modifiedSite;
    }

    public void setModifiedSite(Site modifiedSite) {
        this.modifiedSite = modifiedSite;
    }

    // =============== Méthodes ================

    /**
     * Action listant les {@link Site}
     * @return success
     */
    public String doList() {
        listSites = managerFactory.getSiteManager().sites();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action affichant les détails d'un {@link Site}
     * @return success / error
     */
    public String doDetail(){

        String vResult = ActionSupport.INPUT;

            try {
                /**@see org.escalade.business.impl.manager.SiteManagerImpl#site(Integer)*/
                site = managerFactory.getSiteManager().site(site_id);
                this.session.put("site", site);

                vResult = ActionSupport.SUCCESS;

            } catch (Exception e) {
               this.addActionError("Site non trouvé. ID = " + site_id + " " + e);
            }
        return vResult;
    }

    /**
     * Action de création d'un nouveau site
     * @return success / error
     */
    public String doCreate(){

        String vResult = ActionSupport.INPUT;

            try {
                managerFactory.getSiteManager().addSite(site, (Compte) this.session.get("user"));
                vResult =  ActionSupport.SUCCESS;

                this.addActionMessage("Projet "+ site.getNom() + " a été ajouté avec succè");

            } catch (NullPointerException pEX){

            } catch (Exception pEX) {
                this.addActionError("Une erreur technique s'est produite, votre site n'a pas pu être ajouté !");

            }

        return vResult;
    }

    public String sitesByAccount(){
        String vResult = ActionSupport.INPUT;

        try {
            listSites = managerFactory.getSiteManager().listSitesByAccount((Compte) this.session.get("user"));
            vResult = ActionSupport.SUCCESS;

            if (listSites.isEmpty()) {
            vResult = ActionSupport.INPUT;
            this.addActionMessage("Vous n'avez pas encore de listSites d'escalades !");
            }

        } catch (NullPointerException pEX) {

        } catch (Exception pEX) {
            this.addActionError("Une erreur technique s'est produite, votre site n'a pas pu être ajouté !");
        }

        return vResult;
    }

    /**
     * Action pour modifier un site par un client
     * @return success
     */
    public String modifiedSite() {

        String vResult = ActionSupport.INPUT;

            try {

                site = (Site) this.session.get("site");
                modifiedSite.setId(site.getId());

                /**@see org.escalade.business.impl.manager.SiteManagerImpl#upSite(Site)*/
                managerFactory.getSiteManager().upSite(modifiedSite);

                vResult = ActionSupport.SUCCESS;

                this.addActionMessage("Modifications effectuées !");

            } catch (NullPointerException pEX) {

                /**@see org.escalade.business.impl.manager.SiteManagerImpl#site(Integer)*/
                site = managerFactory.getSiteManager().site(site_id);
                this.session.put("site", site);

            } catch (Exception pEX){
                this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
            }

        return vResult;
    }

    /**
     * Cette méthode permet de supprimer un site
     * @return
     */

    public String delSite(){
        String vResult = ActionSupport.INPUT;

        try {
            /**@see org.escalade.business.impl.manager.SiteManagerImpl#delSite(Integer)*/
            managerFactory.getSiteManager().delSite(site_id);
            vResult = ActionSupport.SUCCESS;
        } catch (Exception pEX) {
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String siteCommentaire(){

        String vResult = null;

        try {

            site = (Site) this.session.get("site");
            commentaire.setSite_id(site.getId());

            /**@see org.escalade.business.impl.manager.CommentaireManagerImpl#addCommentaireSite(Commentaire, Compte)*/
            managerFactory.getCommentaireManager().addCommentaireSite(commentaire, (Compte) this.session.get("user"));

            /**@see org.escalade.business.impl.manager.SiteManagerImpl#site(Integer)*/
            site = managerFactory.getSiteManager().site(site.getId());

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    // ======================== Session =========================

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
}
