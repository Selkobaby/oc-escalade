package org.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.business.contract.ManagerFactory;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Messagerie;
import org.escalade.model.bean.ResaTopo;
import org.escalade.model.bean.Topo;

import javax.inject.Inject;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ResaTopoAction extends ActionSupport implements SessionAware {

    // ======================== Attributs =======================

    // ===== Paramètres en entrée =====

    private Integer topo_id;
    private Integer resa_id;
    private Messagerie messagerie;
    private ResaTopo resaTopo;
    private String statutResa;

    // ===== Paramètres en sortie =====

    private Topo topo;
    private List<ResaTopo> applicantResaTopoList;
    private List<Compte> applicantListAccount;
    private List<ResaTopo> myResaTopoListRequests;
    private List<Compte> ownerListAccount;
    private List<Topo> ownerTopoList;
    private List<Topo> myTopoListApplicant;
    private List<Messagerie> messageList;
    private Compte compte;

    // ----- Eléments Struts
    private Map<String, Object> session;

    @Inject
    private ManagerFactory managerFactory;

    // ==================== Getters/Setters =====================

    public Integer getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(Integer topo_id) {
        this.topo_id = topo_id;
    }

    public Integer getResa_id() {
        return resa_id;
    }

    public void setResa_id(Integer resa_id) {
        this.resa_id = resa_id;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Messagerie getMessagerie() {
        return messagerie;
    }

    public void setMessagerie(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    public ResaTopo getResaTopo() {
        return resaTopo;
    }

    public void setResaTopo(ResaTopo resaTopo) {
        this.resaTopo = resaTopo;
    }

    public List<ResaTopo> getApplicantResaTopoList() {
        return applicantResaTopoList;
    }

    public void setApplicantResaTopoList(List<ResaTopo> applicantResaTopoList) {
        this.applicantResaTopoList = applicantResaTopoList;
    }

    public List<Compte> getApplicantListAccount() {
        return applicantListAccount;
    }

    public void setApplicantListAccount(List<Compte> applicantListAccount) {
        this.applicantListAccount = applicantListAccount;
    }

    public List<ResaTopo> getMyResaTopoListRequests() {
        return myResaTopoListRequests;
    }

    public void setMyResaTopoListRequests(List<ResaTopo> myResaTopoListRequests) {
        this.myResaTopoListRequests = myResaTopoListRequests;
    }

    public List<Compte> getOwnerListAccount() {
        return ownerListAccount;
    }

    public void setOwnerListAccount(List<Compte> ownerListAccount) {
        this.ownerListAccount = ownerListAccount;
    }

    public List<Topo> getOwnerTopoList() {
        return ownerTopoList;
    }

    public void setOwnerTopoList(List<Topo> ownerTopoList) {
        this.ownerTopoList = ownerTopoList;
    }

    public List<Topo> getMyTopoListApplicant() {
        return myTopoListApplicant;
    }

    public void setMyTopoListApplicant(List<Topo> myTopoListApplicant) {
        this.myTopoListApplicant = myTopoListApplicant;
    }

    public List<Messagerie> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Messagerie> messageList) {
        this.messageList = messageList;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getStatutResa() {
        return statutResa;
    }

    public void setStatutResa(String statutResa) {
        this.statutResa = statutResa;
    }


    // ======================== Méthodes ========================

    /**
     * Cette méthode permet d'envoyé vers la Jsp les éléments à afficher pour le formulaire de réservation et;
     * de récupérer les informations renvoyé par utilisateur pour la réserver le topo.
     * @return
     */
    public String resaTopo(){

        String vResult = ActionSupport.INPUT;


        try {

            topo = (Topo) this.session.get("topo");

            resaTopo.setTopo_id(topo.getId());
            resaTopo.setProprietaire_topo(topo.getCompte_id());

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#addResaTopo(ResaTopo, Compte) */
            ResaTopo resaTopoRecovers = managerFactory.getResaTopoManager().addResaTopo(resaTopo, (Compte) this.session.get("user"));

            topo.setStatut("reserver");
            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#upResaTopo(ResaTopo)*/
            managerFactory.getTopoManager().upTopo(topo);

            Date date = new Date();
            messagerie.setDate_message(date);

            messagerie.setResa_topo_id(resaTopoRecovers.getId());

            /**@see org.escalade.business.impl.manager.MessagerieManagerImpl#addMessage(Messagerie, Compte)*/
            managerFactory.getMessagerieManager().addMessage(messagerie, (Compte) this.session.get("user"));

            vResult = ActionSupport.SUCCESS;

        } catch (NullPointerException pEX){

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#topo(Integer)*/
            topo = managerFactory.getTopoManager().topo(topo_id);
            this.session.put("topo", topo);

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String gestionResa(){

        String vResult = ActionSupport.INPUT;

        try {

            /**
             * On récupère ici les réservation appartenant aux utilisateurs
             * pour la partie "Demande de réservations" de la JSP.
             * @see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopoListByTopoAccount(Compte)
             */
            applicantResaTopoList = managerFactory.getResaTopoManager().resaTopoListByTopoAccount((Compte) this.session.get("user"));
            this.session.put("applicantResaTopoList", applicantResaTopoList);

            /**
             * On récupère ici les comptes appartenant aux utilisateurs qui ont envoyé une demande
             * pour la partie "demande de réservations" de la JSP.
             * @see org.escalade.business.impl.manager.CompteManagerImpl#compteByResaTopo(List)
             */
            applicantListAccount = managerFactory.getCompteManager().compteByResaTopo(applicantResaTopoList);
            this.session.put("applicantListAccount", applicantListAccount);

            /**
             * On récupère ici les réservation appartenant à l'utilisateur en session
             * pour la partie "Mes demandes de réservations" de la JSP.
             * @see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopoListByAccount(Compte)
             */
            myResaTopoListRequests = managerFactory.getResaTopoManager().resaTopoListByAccount((Compte) this.session.get("user"));
            this.session.put("myResaTopoListRequests", myResaTopoListRequests);

            /**
             * On récupère ici les comptes appartenant des utilisateurs propriétaires des topos
             * pour la partie "Mes demandes de réservations" de la JSP.
             * @see org.escalade.business.impl.manager.CompteManagerImpl#ownerAccountByResaTopo(List)
             */
            ownerListAccount = managerFactory.getCompteManager().ownerAccountByResaTopo(myResaTopoListRequests);
            this.session.put("ownerListAccount", ownerListAccount);
            
        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String messageResaTopo(){

        String vResult = ActionSupport.INPUT;

        try {

            Date date = new Date();
            messagerie.setDate_message(date);

            managerFactory.getMessagerieManager().addMessage(messagerie, (Compte) this.session.get("user"));

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){

            applicantResaTopoList = (List<ResaTopo>) this.session.get("applicantResaTopoList");
            applicantListAccount = (List<Compte>) this.session.get("applicantListAccount");
            myResaTopoListRequests = (List<ResaTopo>) this.session.get("myResaTopoListRequests");
            ownerListAccount = (List<Compte>) this.session.get("ownerListAccount");
        }

        return vResult;
    }

    public String annulerResaTopo(){

        String vResult = null;

        try {

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopo(Integer)*/
            resaTopo = managerFactory.getResaTopoManager().resaTopo(resaTopo.getId());

            resaTopo.setStatut("annuler");

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#upResaTopo(ResaTopo)*/
            managerFactory.getResaTopoManager().upResaTopo(resaTopo);


            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String delResaTopo(){

        String vResult = null;

        try {

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopo(Integer)*/
            resaTopo = managerFactory.getResaTopoManager().resaTopo(resaTopo.getId());

            /**@see org.escalade.business.impl.manager.CompteManagerImpl#compte(Integer) */
            compte = managerFactory.getCompteManager().compte(resaTopo.getCompte_id());

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#topo(Integer)*/
            topo = managerFactory.getTopoManager().topo(resaTopo.getTopo_id());

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#delReasaTopo(Integer)*/
            managerFactory.getResaTopoManager().delReasaTopo(resaTopo.getId());

            topo.setStatut("libre");

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#upTopo(Topo)*/
            managerFactory.getTopoManager().upTopo(topo);


            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }
        return vResult;
    }

    public String refuseOuRenduResaTopo(){

        String vResult = null;

        try {

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopo(Integer)*/
            resaTopo = managerFactory.getResaTopoManager().resaTopo(resaTopo.getId());

            resaTopo.setStatut(statutResa);

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#upResaTopo(ResaTopo)*/
            managerFactory.getResaTopoManager().upResaTopo(resaTopo);

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#topo(Integer)*/
            topo = managerFactory.getTopoManager().topo(resaTopo.getTopo_id());

            topo.setStatut("libre");

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#upTopo(Topo)*/
            managerFactory.getTopoManager().upTopo(topo);

            vResult = ActionSupport.SUCCESS;

        } catch (Exception pEX){
            this.addActionError("Une erreur s'est produite, veuillez réessayer plus tard!");
        }

        return vResult;
    }

    public String acceptResaTopo(){

        String vResult = null;

        try {

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#resaTopo(Integer)*/
            resaTopo = managerFactory.getResaTopoManager().resaTopo(resaTopo.getId());

            resaTopo.setStatut("accepter");

            /**@see org.escalade.business.impl.manager.ResaTopoManagerImpl#upResaTopo(ResaTopo)*/
            managerFactory.getResaTopoManager().upResaTopo(resaTopo);

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#topo(Integer)*/
            topo = managerFactory.getTopoManager().topo(resaTopo.getTopo_id());

            topo.setStatut("reserver");

            /**@see org.escalade.business.impl.manager.TopoManagerImpl#upTopo(Topo)*/
            managerFactory.getTopoManager().upTopo(topo);

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
