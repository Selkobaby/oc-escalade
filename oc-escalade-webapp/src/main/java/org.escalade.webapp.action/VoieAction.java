package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Voie;

import javax.inject.Inject;
import java.util.*;

public class VoieAction extends ActionSupport implements SessionAware {

    // =============== Attributs ===============
    private Integer secteur_id;
    private Integer voie_id;
    private String hauteur;
    private Secteur secteur;

    // ----- Eléments en sortie -----
    private List<Voie> listVoies;
    private Voie voie;
    private Voie modifiedVoie;
    private List<Secteur> listSecteurs;
    private List<Longueur> listLongueurs;

    private List<String> cotations = new ArrayList(Arrays.asList("1", "2", "3", "4", "5a", "5b", "5c", "6a", "6a+", "6b",
            "6b+", "6c", "6c+", "7a", "7a+", "7b", "7b+", "7c", "7c+", "8a", "8a+", "8b", "8b+", "8c", "8c+", "9a", "9a+",
            "9b", "9b+", "9c"));

    private  List<String> listTypesVoie = new ArrayList(Arrays.asList("Non équipée", "Equipée"));

    // ----- Eléments Struts
    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    // ============ Getters/Setters ============

    public Integer getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(Integer secteur_id) {
        this.secteur_id = secteur_id;
    }

    public Integer getVoie_id() {
        return voie_id;
    }

    public void setVoie_id(Integer voie_id) {
        this.voie_id = voie_id;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Voie> getListVoies() {
        return listVoies;
    }

    public void setListVoies(List<Voie> listVoies) {
        this.listVoies = listVoies;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }

    public List<String> getCotations() {
        return cotations;
    }

    public void setCotations(List<String> cotations) {
        this.cotations = cotations;
    }

    public List<String> getListTypesVoie() {
        return listTypesVoie;
    }

    public void setListTypesVoie(List<String> listTypesVoie) {
        this.listTypesVoie = listTypesVoie;
    }

    public List<Longueur> getListLongueurs() {
        return listLongueurs;
    }

    public void setListLongueurs(List<Longueur> listLongueurs) {
        this.listLongueurs = listLongueurs;
    }

    public Voie getModifiedVoie() {
        return modifiedVoie;
    }

    public void setModifiedVoie(Voie modifiedVoie) {
        this.modifiedVoie = modifiedVoie;
    }

    // =============== Méthodes ================

    /**
     * Action listant les {@link Voie}
     * @return success
     */
    public String doList() {
        listVoies = managerFactory.getVoieManager().voies(secteur_id);
        return ActionSupport.SUCCESS;
    }

    public String doDetail(){

        if (voie_id == null) {
            this.addActionError("Vous devez indiquer un id de voie");
        } else {
            try{
                /**@see org.escalade.business.impl.manager.VoieManagerImpl#voie(Integer)*/
                voie = managerFactory.getVoieManager().voie(voie_id);
            } catch (Exception e){
                System.out.println(e);
                this.addActionError("Voie non trouvé. ID = " + voie_id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate(){

        String vResult = ActionSupport.INPUT;

        try {

            voie.setHauteur( Float.parseFloat(hauteur));

            listSecteurs = (List<Secteur>) this.session.get("listSecteurs");
            for (Secteur vSecteur : listSecteurs){

                if (vSecteur.getNom().contains(secteur.getNom())){
                    secteur.setId(vSecteur.getId());
                }
            }

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#addVoie(Voie, Secteur)*/
            managerFactory.getVoieManager().addVoie(voie, secteur);

            vResult = ActionSupport.SUCCESS;

        } catch (NullPointerException pEX){

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#listSecteurByAccount(Compte) */
            listSecteurs = managerFactory.getSecteurManager().listSecteurByAccount((Compte) this.session.get("user"));
            this.session.put("listSecteurs", listSecteurs);

        } catch (Exception pEX){

            this.addActionError("Une erreur technique s'est produite, votre voie n'a pas pu être ajouté !");
        }

        return vResult;
    }

    public String modifiedVoie(){
        String vResult = ActionSupport.INPUT;

        try {

            modifiedVoie.setHauteur((Float.parseFloat(hauteur)));

            voie = (Voie) this.session.get("voie");
            modifiedVoie.setId(voie.getId());

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#upVoie(Voie)*/
            managerFactory.getVoieManager().upVoie(modifiedVoie);

            vResult = ActionSupport.SUCCESS;

            this.addActionMessage("Les modifications de la voie on bien étaient effectuées !");

        } catch (NullPointerException pEX) {

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#voie(Integer)*/
            voie = managerFactory.getVoieManager().voie(voie_id);
            this.session.put("voie", voie);

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String delVoie(){

        String vResult = ActionSupport.INPUT;

        try{

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#delVoie(Integer)*/
            managerFactory.getVoieManager().delVoie(voie.getId());

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String voiesByAccount(){
        String vResult = ActionSupport.SUCCESS;

        try {

            /**@see org.escalade.business.impl.manager.VoieManagerImpl#listVoiesByAccount(Compte)*/
            listVoies = managerFactory.getVoieManager().listVoiesByAccount((Compte) this.session.get("user"));

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#listSecteurByAccount(Compte)*/
            listSecteurs = managerFactory.getSecteurManager().listSecteurByAccount((Compte) this.session.get("user"));

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
}
