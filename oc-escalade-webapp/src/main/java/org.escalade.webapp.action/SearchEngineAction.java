package org.escalade.webapp.action;
import com.opensymphony.xwork2.ActionSupport;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import org.escalade.model.bean.Voie;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchEngineAction extends ActionSupport  {

    // ============ Eléments en entrée  ============

    private String motCleRecherche;
    private String regionSelect;
    private String typeVoieSelect;
    private String cotationVoieSelect;

    // ============ Eléments en sortie ============

    private List<String> listRegions = new ArrayList(Arrays.asList("Ile-de-France", "Champagne-Ardenne", "Picardie",
            "Haute-Normandie", "Centre", "Basse-Normandie", "Bourgogne", "Nord-Pas-de-Calais", "Lorraine", "Alsace",
            "Franche-Comté", "Pays de la Loire", "Bretagne", "Poitou-Charentes", "Aquitaine", "Midi-Pyrénées",
            "Limousin", "Rhône-Alpes", "Auvergne", "Languedoc-Roussillon", "Provence-Alpes-Côte d'Azur",
            "Corse", "Guadeloupe", "Martinique", "Guyane", "La Réunion", "Mayotte"));

    // Liste de sélection de la difficulté par ordre croissant de 3 à 9 des listVoies.
    private List<String> listCotations = new ArrayList(Arrays.asList("1", "2", "3", "4", "5a", "5b", "5c", "6a", "6a+", "6b",
            "6b+", "6c", "6c+", "7a", "7a+", "7b", "7b+", "7c", "7c+", "8a", "8a+", "8b", "8b+", "8c", "8c+", "9a", "9a+",
            "9b", "9b+", "9c"));

    // Liste de sélection, listVoies équipée ou non équipée.
    private  List<String> listTypesVoie = new ArrayList(Arrays.asList("Non équipée", "Equipée"));

    private List<Site> listSites;
    private List<Voie> listVoies;
    private List<Secteur> listSecteurs;

    private Site site;
    private Secteur secteur;
    private Voie voie;

    private List<Site> secteursRefSite;
    private List<Secteur> voiesRefSecteur;
    private List<Site> voiesRefSecteurRefSite;

    @Inject
    private ManagerFactory managerFactory;

    // ============ Getters/Setters ============

    public String getRegionSelect() {
        return regionSelect;
    }

    public void setRegionSelect(String regionSelect) {
        this.regionSelect = regionSelect;
    }

    public List<Site> getListSites() {
        return listSites;
    }

    public void setListSites(List<Site> listSites) {
        this.listSites = listSites;
    }

    public String getMotCleRecherche() {
        return motCleRecherche;
    }

    public void setMotCleRecherche(String motCleRecherche) {
        this.motCleRecherche = motCleRecherche;
    }

    public List<String> getListRegions() {
        return listRegions;
    }

    public void setListRegions(List<String> listRegions) {
        this.listRegions = listRegions;
    }

    public List<String> getListCotations() {
        return listCotations;
    }

    public void setListCotations(List<String> listCotations) {
        this.listCotations = listCotations;
    }

    public List<String> getListTypesVoie() {
        return listTypesVoie;
    }

    public void setListTypesVoie(List<String> listTypesVoie) {
        this.listTypesVoie = listTypesVoie;
    }

    public String getTypeVoieSelect() {
        return typeVoieSelect;
    }

    public void setTypeVoieSelect(String typeVoieSelect) {
        this.typeVoieSelect = typeVoieSelect;
    }

    public String getCotationVoieSelect() {
        return cotationVoieSelect;
    }

    public void setCotationVoieSelect(String cotationVoieSelect) {
        this.cotationVoieSelect = cotationVoieSelect;
    }

    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }

    public List<Voie> getListVoies() {
        return listVoies;
    }

    public void setListVoies(List<Voie> listVoies) {
        this.listVoies = listVoies;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public List<Site> getSecteursRefSite() {
        return secteursRefSite;
    }

    public void setSecteursRefSite(List<Site> secteursRefSite) {
        this.secteursRefSite = secteursRefSite;
    }

    public List<Secteur> getVoiesRefSecteur() {
        return voiesRefSecteur;
    }

    public void setVoiesRefSecteur(List<Secteur> voiesRefSecteur) {
        this.voiesRefSecteur = voiesRefSecteur;
    }

    public List<Site> getVoiesRefSecteurRefSite() {
        return voiesRefSecteurRefSite;
    }

    public void setVoiesRefSecteurRefSite(List<Site> voiesRefSecteurRefSite) {
        this.voiesRefSecteurRefSite = voiesRefSecteurRefSite;
    }

    // =============== Méthodes ================

    /**
     * Action qui retourne la liste des listSites correspondant à la région sélectionnée
     * au type de la voie (équpée ou non) et à la difficultée de la voie.
     * @return success
     */
    public String doAdvancedSearch(){

        String vResult = ActionSupport.INPUT;

        try {

            if (this.regionSelect != null){
                /**@see org.escalade.business.impl.manager.SiteManagerImpl#sitesByAdvancedSearch(String, String, String)*/
                listSites = managerFactory.getSiteManager().sitesByAdvancedSearch(regionSelect, typeVoieSelect, cotationVoieSelect);
                vResult = ActionSupport.SUCCESS;
            }

        } catch (Exception pEX){

        }

        return vResult;
    }

    public String doSimpleSearch(){

        try {

            /**@see org.escalade.business.impl.manager.SiteManagerImpl#siteBySimpleSearch(String) */
            listSites = managerFactory.getSiteManager().siteBySimpleSearch(motCleRecherche);

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#secteurBySimpleSearch(String) */
            listSecteurs = managerFactory.getSecteurManager().secteurBySimpleSearch(motCleRecherche);

            if (!listSecteurs.isEmpty()){
                /**@see org.escalade.business.impl.manager.SiteManagerImpl#searchSiteBySector(List)*/
                secteursRefSite = managerFactory.getSiteManager().searchSiteBySector(listSecteurs);
            }

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#rechercheSimpleParVoie(String)*/
            listVoies = managerFactory.getVoieManager().rechercheSimpleParVoie(motCleRecherche);

            if (!listVoies.isEmpty()){
                /**@see org.escalade.business.impl.manager.SecteurManagerImpl#rechercheSecteurParVoie(List)*/
                voiesRefSecteur = managerFactory.getSecteurManager().rechercheSecteurParVoie(listVoies);
                /**@see org.escalade.business.impl.manager.SiteManagerImpl#searchSiteBySector(List)*/
                voiesRefSecteurRefSite = managerFactory.getSiteManager().searchSiteBySector(voiesRefSecteur);
            }

            if (listSites.isEmpty() && listSecteurs.isEmpty() && listVoies.isEmpty()){
                this.addActionMessage("Désolé ! Aucun site ne correspond à votre recherche : " + motCleRecherche + " !");
            }

        } catch (IndexOutOfBoundsException pEx) {
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return ActionSupport.SUCCESS;
    }

}
