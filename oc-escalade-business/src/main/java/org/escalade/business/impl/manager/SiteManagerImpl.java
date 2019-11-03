package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.SiteManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.consumer.contract.impl.dao.LongueurImpl;
import org.escalade.consumer.contract.impl.dao.SiteImpl;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import org.escalade.model.bean.Voie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SiteManagerImpl extends AbstractManagerImpl implements SiteManager {

    /**
     * Cette méthode permet de récupérer tous les sites d'escalade.
     * @return
     */
    @Override
    public List<Site> sites() {

        /** @see SiteImpl#sites()*/
        return getDaoFactory().getSiteDao().sites();
    }

    /**
     * C'est méthode permet d'ajouter un nouveau site d'escalade.
     * @param site
     * @param compte
     */
    @Override
    public void addSite(Site site, Compte compte) {

        /** @see org.escalade.consumer.contact.impl.dao.SiteImpl#addSite(Site, Compte)*/
        getDaoFactory().getSiteDao().addSite(site, compte);
    }

    /**
     * Renvoie le detail du site d'escalade sélectionné (Secteurs, Voies, Relais, Longueurs).
     * @param site_id
     * @return site
     */
    @Override
    public Site site(Integer site_id){

        /**@see org.escalade.consumer.contact.impl.dao.SiteImpl#site(Integer)*/
        Site site = getDaoFactory().getSiteDao().site(site_id);

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#secteursBySiteId(Integer)  */
        List<Secteur> secteurs = getDaoFactory().getSecteurDao().secteursBySiteId(site_id);

        /**@see org.escalade.consumer.contact.impl.dao.CommentaireImpl#commentaires(Integer, Integer)*/
        List<Commentaire> commentaires = getDaoFactory().getCommentaireDao().commentaires(site_id, null);
        site.setCommentaires(commentaires);

        for(Secteur secteur: secteurs){

            /**@see org.escalade.consumer.impl.dao.VoieImpl#voies(Integer)*/
            List<Voie> voies = getDaoFactory().getVoieDao().voies(secteur.getId());

            for(Voie voie: voies){
                /**@see LongueurImpl#longueurs(Integer)*/
                List<Longueur> longueurList = getDaoFactory().getLongueurDao().longueurs(voie.getId());
                voie.setLongueursRelais(longueurList);
            }
            secteur.setListVoies(voies);
        }
        site.setListSecteurs(secteurs);
        return site;
    }

    @Override
    public void delSite(Integer id) {

        /**@see org.escalade.consumer.contact.impl.dao.SiteImpl#delSite(Integer)*/
        getDaoFactory().getSiteDao().delSite(id);
    }

    /**
     * Cette méthode permet de mettre à jour un site d'escalade
     * @param site
     */
    @Override
    public void upSite(Site site) {

        /**@see org.escalade.consumer.contact.impl.dao.SiteImpl#upSite(Site)*/
        getDaoFactory().getSiteDao().upSite(site);
    }

    /**
     * La méthode récupère tous les sites correspondant à la région, le type de voie
     * (équipée ou non) et sa difficulté.
     * @param regionSelect
     * @return sitesRegionSelect
     */
    public List<Site> sitesByAdvancedSearch(String regionSelect, String typeVoieSelect, String cotationVoieSelect){

        /**@see org.escalade.consumer.contact.impl.dao.SiteImpl#sitesByAdvancedSearchDao(String, String, String) */
        List<Site> sites = getDaoFactory().getSiteDao().sitesByAdvancedSearchDao(regionSelect, typeVoieSelect, cotationVoieSelect);

        return sites;
    }

    /**
     * Recherche dans la base de données un site d'escalade qui a une correspondance avec le mot-clé de recherche
     * saisi par l'utilisateur.
     * @param motCleRecherche
     * @return sites
     */
    @Override
    public List<Site> siteBySimpleSearch(String motCleRecherche) {

        /** @see org.escalade.consumer.contact.impl.dao.SiteImpl#siteBySimpleSearchDao(String)*/
        List<Site> sites = getDaoFactory().getSiteDao().siteBySimpleSearchDao(motCleRecherche);
        return sites;
    }

    /**
     * Renvoie le site correspondant aux secteurs trouver lors de la recherche dans la "barre de recherche" du navigateur.
     * @param secteurs
     * @return sites
     */
    public List<Site> searchSiteBySector(List<Secteur> secteurs) {

        List<Site> sites = new ArrayList<>();
        Set<Integer> secteurSite_id = new HashSet<>();

        for (Secteur secteur: secteurs){
            secteurSite_id.add(secteur.getSite_id());
        }

        for (Integer site_id : secteurSite_id){
            /** @see org.escalade.consumer.contact.impl.dao.SiteImpl#searchSiteBySectorDao */
            List<Site> siteParSecteur = getDaoFactory().getSiteDao().searchSiteBySectorDao(site_id);
            sites.addAll(siteParSecteur);
        }

        return sites;
    }

    /**
     * @param compte
     * @return les sites d'escalade correspondant au compte de l'utilisateur.
     */
    @Override
    public List<Site> listSitesByAccount(Compte compte) {

        /** @see org.escalade.consumer.contact.impl.dao.SiteImpl#listSitesByAccountDao(Compte) */
        return getDaoFactory().getSiteDao().listSitesByAccountDao(compte);
    }

    /**
     * Cette métode permet d'ajouter le site d'escalade du Workflow et de le récupèrer pour transmettre l'id du site
     * pour le secteur.
     * @param site
     * @param compte

     * @return le site du Workflow pour transmettre l'id du site au secteur.
     */
    public Site addSiteWorkflow (Site site, Compte compte){

        /** @see org.escalade.consumer.contact.impl.dao.SiteImpl#addSite(Site, Compte) */
        getDaoFactory().getSiteDao().addSite(site, compte);

        /** @see org.escalade.consumer.contat.impl.dao.SiteImpl#recoversSiteWorkflowDao(Site, Compte) */
        Site vSite = getDaoFactory().getSiteDao().recoversSiteWorkflowDao(site, compte);

        return vSite;
    }
}
