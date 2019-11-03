package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Compte;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CompteAction extends ActionSupport implements SessionAware, ServletRequestAware {


    // ======================== Attributs =======================
    // ===== Paramètres en entrée =====
    private Compte upCompte;

    // ===== Paramètres en sortie =====
    private Compte compte;

    // ----- Eléments Struts
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Getters/Setters =====================

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Compte getUpCompte() {
        return upCompte;
    }

    public void setUpCompte(Compte upCompte) {
        this.upCompte = upCompte;
    }

    // ======================== Méthodes ========================

    /**
     * Action de création d'un nouveau compte
     * @return success / error
     */
    public String doCreate(){

        String vResult = ActionSupport.INPUT;

        try {
            managerFactory.getCompteManager().addCompte(compte);
            vResult = ActionSupport.SUCCESS;

        } catch (NullPointerException pEX){

        } catch (Exception pEX) {

            this.addActionError("Cette adresse e-mail est déjà utilisée !");
        }

        return vResult;
    }

    /**
     * Action de mise à jour des informations de compte
     * @return success / error
     */
    public String upCompte(){
        String vResult = ActionSupport.INPUT;

        Compte compteSessionCompar = (Compte) this.session.get("user");

        try {

            if(!upCompte.equals(null) && !upCompte.getMail().equals(compteSessionCompar.getMail())
                    || !upCompte.getMot_de_passe().equals(compteSessionCompar.getMot_de_passe())){

                managerFactory.getCompteManager().upCompte(upCompte, (Compte) this.session.get("user"));

                this.addActionMessage("Vos modifications ont bien été pris en compte, merci de vous reconnecter !");
                vResult = ActionSupport.SUCCESS;

            } else if (!upCompte.equals(null)){
                managerFactory.getCompteManager().upCompte(upCompte, (Compte) this.session.get("user"));
                Compte vUtilisateur = managerFactory.getCompteManager().comptByUtilisateur(upCompte.getMail(), upCompte.getMot_de_passe());

                this.addActionMessage("Vos modifications ont bien été pris en compte !");

                this.session.put("user",vUtilisateur );
                compte = managerFactory.getCompteManager().compte(((Compte) this.session.get("user")).getId());
            }

        } catch (NullPointerException pEX){
            compte = managerFactory.getCompteManager().compte(((Compte) this.session.get("user")).getId());
        } catch (Exception pEX) {
            this.addActionError("Une erreur s'est produite, veuillez réessayer ultérieurement !" );
        }

        return vResult;
    }

    public String supprimerCompteUtilisateur (){
        String vResult = ActionSupport.INPUT;

        try {

            managerFactory.getCompteManager().delCompte((Compte) this.session.get("user"));

            vResult = ActionSupport.SUCCESS;

            this.servletRequest.getSession().invalidate();

            this.addActionMessage("Votre compte à bien été supprimer !");

        } catch (NullPointerException pEX) {
            compte = managerFactory.getCompteManager().compte(((Compte) this.session.get("user")).getId());
        } catch (Exception pEX) {

            this.addActionError("Une erreur s'est produite, veuillez réessayer ultérieurement !");
        }

        return vResult;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }
}
