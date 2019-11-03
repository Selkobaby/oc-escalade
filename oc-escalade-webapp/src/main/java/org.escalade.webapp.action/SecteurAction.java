package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class SecteurAction extends ActionSupport implements SessionAware {

    // ======================== Attributs =======================
    // ----- Eléments en entrée -----
    private Integer site_id;
    private Integer secteur_id;
    private Secteur secteur;
    private Compte compte;
    private String siteNomRegion;
    private Secteur modifiedSecteur;

    // ----- Eléments en sortie -----
    private List<Site> listSites;
    private List<Secteur> listSecteurs;
    private List<String> listNomsSites;

    // ----- Eléments Struts
    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    // ============ Getters/Setters ============

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Site> getListSites() {
        return listSites;
    }

    public void setListSites(List<Site> listSites) {
        this.listSites = listSites;
    }

    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }

    public String getSiteNomRegion() {
        return siteNomRegion;
    }

    public void setSiteNomRegion(String siteNomRegion) {
        this.siteNomRegion = siteNomRegion;
    }

    public Integer getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(Integer secteur_id) {
        this.secteur_id = secteur_id;
    }

    public Secteur getModifiedSecteur() {
        return modifiedSecteur;
    }

    public void setModifiedSecteur(Secteur modifiedSecteur) {
        this.modifiedSecteur = modifiedSecteur;
    }

    // =============== Méthodes ================


    public String datailSecteur(){
        String vResult = ActionSupport.INPUT;

        try{
            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#secteur(Integer)*/
            secteur = managerFactory.getSecteurManager().secteur(secteur.getId());
            vResult = ActionSupport.SUCCESS;
        } catch (Exception pEX){

        }
        return vResult;
    }

    public String doCreate(){

        String vResult = ActionSupport.INPUT;

        try{

            String [] vTabNomRegion = siteNomRegion.split(" - ", 2);

            String vNom = null; String vRegion = null;

            for (int i = 0; i < vTabNomRegion.length; i++) {
                vNom = vTabNomRegion[i];
                i++;
                vRegion = vTabNomRegion[i];
            }

            listSites = (List<Site>) this.session.get("site");

            for (Site vSite: listSites){
                if (vSite.getNom().contains(vNom) && vSite.getRegion().contains(vRegion)){
                    site_id = vSite.getId();
                }
            }

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#addSecteur(Secteur, Integer) */
            managerFactory.getSecteurManager().addSecteur(secteur, site_id);
            vResult = ActionSupport.SUCCESS;

            this.addActionMessage("Secteur " + secteur.getNom() + " a été ajouté avec succè");

        } catch (NullPointerException pEX){
            /**@see org.escalade.business.impl.manager.SiteManagerImpl#listSitesByAccount(Compte) */
            listSites = managerFactory.getSiteManager().listSitesByAccount((Compte) this.session.get("user"));
            this.session.put("site", listSites);

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, votre secteur n'a pas pu être ajouté !");

        }

        return vResult;
    }

    public String modifiedSecteur(){
        String vResult = ActionSupport.INPUT;

        try{

            secteur = (Secteur) this.session.get("secteur");
            modifiedSecteur.setId(secteur.getId());

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#upSecteur(Secteur)*/
            managerFactory.getSecteurManager().upSecteur(modifiedSecteur);

            vResult = ActionSupport.SUCCESS;

            this.addActionMessage("Modifications effectuées !");

        }catch (NullPointerException pEX){
            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#secteur(Integer)*/
            secteur = managerFactory.getSecteurManager().secteur(secteur_id);
            this.session.put("secteur", secteur);

        } catch (Exception pEX){
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String secteursByAccount() {

        String vResult = ActionSupport.INPUT;

        try {

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#listSecteurByAccount(Compte)*/
            listSecteurs =  managerFactory.getSecteurManager().listSecteurByAccount((Compte) this.session.get("user"));
            /**@see org.escalade.business.impl.manager.SiteManagerImpl#listSitesByAccount(Compte)*/
            listSites = managerFactory.getSiteManager().listSitesByAccount((Compte) this.session.get("user"));

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX) {
            this.addActionError("Une erreur technique s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String delSecteur(){
        String vResult = ActionSupport.INPUT;

        try {

            /**@see org.escalade.business.impl.manager.SecteurManagerImpl#delSecteur(Integer) */
            managerFactory.getSecteurManager().delSecteur(secteur.getId());

            vResult = ActionSupport.SUCCESS;

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
