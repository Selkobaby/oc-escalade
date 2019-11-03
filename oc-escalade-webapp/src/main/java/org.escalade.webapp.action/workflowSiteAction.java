package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.business.impl.manager.LongueurManagerImpl;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import org.escalade.model.bean.Voie;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class workflowSiteAction extends ActionSupport implements SessionAware, ServletRequestAware {

    // ======================== Attributs =======================

    // ===== Paramètres en entrée =====
    private String configSelectForm;
    private Site site;
    private Secteur secteur;
    private Voie voie;
    private Longueur longueur;
    private List<Longueur> longueursRelais = new ArrayList<>();

    /**
     * Stock la hauteur de la voie ou de la longueur
     */
    private String hauteur;
    private Integer initNumLongueur;

    // ===== Paramètres en sortie =====
    private List<String> listRegions = new ArrayList(Arrays.asList("Ile-de-France", "Champagne-Ardenne", "Picardie",
            "Haute-Normandie", "Centre", "Basse-Normandie", "Bourgogne", "Nord-Pas-de-Calais", "Lorraine", "Alsace",
            "Franche-Comté", "Pays de la Loire", "Bretagne", "Poitou-Charentes", "Aquitaine", "Midi-Pyrénées",
            "Limousin", "Rhône-Alpes", "Auvergne", "Languedoc-Roussillon", "Provence-Alpes-Côte d'Azur",
            "Corse", "Guadeloupe", "Martinique", "Guyane", "La Réunion", "Mayotte"));

    private  List<String> listTypesVoie = new ArrayList(Arrays.asList("Non équipée", "Equipée"));

    private List<String> cotations = new ArrayList(Arrays.asList("1", "2", "3", "4", "5a", "5b", "5c", "6a", "6a+", "6b",
            "6b+", "6c", "6c+", "7a", "7a+", "7b", "7b+", "7c", "7c+", "8a", "8a+", "8b", "8b+", "8c", "8c+", "9a", "9a+",
            "9b", "9b+", "9c"));


    // ----- Eléments Struts

    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Getters/Setters =====================

    public String getConfigSelectForm() {
        return configSelectForm;
    }

    public void setConfigSelectForm(String configSelectForm) {
        this.configSelectForm = configSelectForm;
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

    public Longueur getLongueur() {
        return longueur;
    }

    public void setLongueur(Longueur longueur) {
        this.longueur = longueur;
    }

    public List<String> getListRegions() {
        return listRegions;
    }

    public void setListRegions(List<String> listRegions) {
        this.listRegions = listRegions;
    }

    public List<String> getListTypesVoie() {
        return listTypesVoie;
    }

    public void setListTypesVoie(List<String> listTypesVoie) {
        this.listTypesVoie = listTypesVoie;
    }

    public List<String> getCotations() {
        return cotations;
    }

    public void setCotations(List<String> cotations) {
        this.cotations = cotations;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }

    public Integer getInitNumLongueur() {
        return initNumLongueur;
    }

    public void setInitNumLongueur(Integer initNumLongueur) {
        this.initNumLongueur = initNumLongueur;
    }

    public List<Longueur> getLongueursRelais() {
        return longueursRelais;
    }

    public void setLongueursRelais(List<Longueur> longueursRelais) {
        this.longueursRelais = longueursRelais;
    }

    // ======================== Méthodes ========================

    /**
     * Cette méthode permet d'ajouter un site dans la session "site" ou de la modifier.
     * @return
     */
    public String completeCreationClimbingSite(){

        String vResult = ActionSupport.INPUT;

        try {

            if (site != null){
                this.session.put("site", site);
                configSelectForm = "formSecteur";
            } else {
                configSelectForm = "formSite";
            }
        } catch (NullPointerException pEX){

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }
        return vResult;
    }

    /**
     * Cette méthode permet d'ajouter un secteur dans la session "secteur" ou de le modifier.
     * @return
     */
    public String completeCreationClimbingSecteur(){
        String vResult = ActionSupport.INPUT;

        try{
            this.session.put("secteur", secteur);
            configSelectForm = "formVoie";
        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    /**
     * Cette méthode permet d'ajouter une voie dans la session "voie" ou de la modifier.
     * On initialise dans cette méthode le numéro de la première longueur à 1 que l'on ajoute
     * à la session "initNumLongueur" pour la transmettre au formulaire pour ajouter les longueurs.
     * @return
     */
    public String completeCreationClimbingVoie(){
        String vResult = ActionSupport.INPUT;

        try{
            voie.setHauteur(Float.parseFloat(hauteur));
            this.session.put("voie", voie);

            initNumLongueur  = (Integer) this.session.get("initNumLongueur");

            if (initNumLongueur == null) {
                initNumLongueur = 1;
            }

            this.session.put("initNumLongueur", initNumLongueur);

            /* Si l'utilisateur après avoir ajouté des longueurs revient en arrière pour modifier la voie on récupère
            les longueurs sauvegardées en session pour les transmettre au formulaire des longueurs */
            longueursRelais = (List<Longueur>) this.session.get("listLongueurs");

            configSelectForm = "formLongueur";
        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    /**
     * Cette méthode permet d'ajouter les longueurs d'une voie d'escalade
     * @return
     */
    public String completeCreationClimbingLongueur(){

        String vResult = ActionSupport.INPUT;

        try{
            longueur.setHauteur(Float.parseFloat(hauteur));

            // On récupère le numéro de la longueur en cours sauvegardée dans la session "initNumLongueur"
            initNumLongueur = (Integer) this.session.get("initNumLongueur");
            longueur.setNum_longueur(initNumLongueur);

            /**
             * Si c'est la première longueur à être ajouter on execute le "if".
             * Si il y a déja des longueurs sauvegardées on execute le "else" et on récupère la liste des longueurs.
             */

            if (longueur.getNum_longueur() == 1){
                longueursRelais.add(longueur);
                this.session.put("listLongueurs", longueursRelais);
            } else {

                longueursRelais = (List<Longueur>) this.session.get("listLongueurs");

                if (longueur.getNum_relai() != 0){
                    List<Longueur> longueurListReverse = new ArrayList<>(longueursRelais);
                    Collections.reverse(longueurListReverse);

                    for (Longueur relais: longueurListReverse){
                        if (relais.getNum_relai() > 0){
                            int numRelai = relais.getNum_relai();
                            longueur.setNum_relai(numRelai + 1);
                            break;
                        }
                    }
                }

                longueursRelais.add(longueur);
                this.session.put("listLongueurs", longueursRelais);
            }

            initNumLongueur = initNumLongueur + 1;
            this.session.put("initNumLongueur", initNumLongueur);

            configSelectForm = "formLongueur";

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }
        return vResult;
    }

    /**
     * Cette méthode permet de modifier une logueur
     * @return
     */
    public String modifiedLongueur(){
        String vResult = ActionSupport.INPUT;

        try {

            longueursRelais = (List<Longueur>) this.session.get("listLongueurs");
            longueur.setHauteur(Float.parseFloat(hauteur));

            for (Longueur vLongueur : longueursRelais){
                Integer numLongueur = vLongueur.getNum_longueur();

                if (numLongueur.equals(longueur.getNum_longueur())){
                    vLongueur.setHauteur(longueur.getHauteur());
                    vLongueur.setCotation(longueur.getCotation());

                    if (longueur.getNum_relai() != 0){
                        // On récupère la liste des longueurs que l'on inverse.
                        List<Longueur> longueurListReverse = new ArrayList<>(longueursRelais);
                        Collections.reverse(longueurListReverse);

                        for (Longueur relais: longueurListReverse){
                            if (relais.getNum_relai() > 0){
                                int numRelai = relais.getNum_relai();
                                vLongueur.setNum_relai(numRelai + 1);
                                break;
                            }
                        }

                    } else {
                        vLongueur.setNum_relai(longueur.getNum_relai());
                        this.session.put("listLongueurs", vLongueur);
                    }
                }
            }

            Integer i = 1;

            for (Longueur relai: longueursRelais) {

                if (relai.getNum_relai() > 0) {
                    relai.setNum_relai(i);
                    i++;
                }

                this.session.put("listLongueurs", longueursRelais);
            }

            configSelectForm = "formLongueur";

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    /**
     * Envoie le formulaire vers la base de donnée
     * @return
     */
    public String validationForm(){
        String vResult = ActionSupport.SUCCESS;

        try {

            /**@see org.escalade.business.impl.manager.SiteManagerImpl#addSiteWorkflow(Site, Compte)*/
            Site site = managerFactory.getSiteManager().addSiteWorkflow((Site) this.session.get("site"), (Compte) this.session.get("user"));

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#addSecteurWorkflow(Secteur, Site)*/
            Secteur secteur = managerFactory.getSecteurManager().addSecteurWorkflow((Secteur) this.session.get("secteur"), site);

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#addVoieWorkflow(Voie, Secteur)*/
            Voie voie = managerFactory.getVoieManager().addVoieWorkflow((Voie) this.session.get("voie"), secteur);

            /**@see LongueurManagerImpl#addLongueurWorkflow(List, Voie)*/
            longueursRelais = (List<Longueur>) this.session.get("listLongueurs");
            managerFactory.getLongueurManager().addLongueurWorkflow(longueursRelais, voie);

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }


        return vResult;
    }

    // ======================== Session =========================

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }


}
