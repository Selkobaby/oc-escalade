package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Compte;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware {

    // ======================== Attributs =======================
    // ===== Paramètres en entrée =====
    private String login;
    private String password;

    // ----- Eléments Struts
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Getters/Setters =====================

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ======================== Méthodes ========================

    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doLogin(){

        String vResult = ActionSupport.INPUT;

        if (!StringUtils.isAllEmpty(login,password)){
            try {
                Compte vUtilisateur = managerFactory.getCompteManager().comptByUtilisateur(login, password);
                vResult = ActionSupport.SUCCESS;

                // Ajout de l'utilisateur en session
                this.session.put("user", vUtilisateur);

            } catch (Exception pEX){
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }

    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     */
    public String doLogout(){
        // Suppression de l'utilisateur en session
        this.servletRequest.getSession().invalidate();
        return ActionSupport.SUCCESS;
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
