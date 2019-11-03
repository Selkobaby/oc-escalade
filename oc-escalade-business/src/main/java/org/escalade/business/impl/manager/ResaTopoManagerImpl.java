package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.ResaTopoManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Messagerie;
import org.escalade.model.bean.ResaTopo;
import org.escalade.model.bean.Topo;

import java.util.ArrayList;
import java.util.List;

public class ResaTopoManagerImpl extends AbstractManagerImpl implements ResaTopoManager {

    @Override
    public List<ResaTopo> resaTopos(Integer topo_id) {

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#resaTopos(Integer)*/
        return getDaoFactory().getResaTopoDao().resaTopos(topo_id);
    }

    @Override
    public ResaTopo addResaTopo(ResaTopo resaTopo, Compte compte) {

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#addResaTopo(ResaTopo, Compte)*/
        getDaoFactory().getResaTopoDao().addResaTopo(resaTopo, compte);

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#recoversIdResaTopoDao(ResaTopo, Compte)*/
        ResaTopo resaTopoRecovers = getDaoFactory().getResaTopoDao().recoversIdResaTopoDao(resaTopo, compte);

        return resaTopoRecovers;
    }

    public void upResaTopo(ResaTopo resaTopo){

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#upResaTopoDao(ResaTopo)*/
        getDaoFactory().getResaTopoDao().upResaTopoDao(resaTopo);
    }

    @Override
    public ResaTopo resaTopo(Integer resa_topo_id) {

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#resaTopo(Integer)*/
        return getDaoFactory().getResaTopoDao().resaTopo(resa_topo_id);
    }

    @Override
    public void delReasaTopo(Integer resa_topo_id) {

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#delResaTopo(Integer)*/
        getDaoFactory().getResaTopoDao().delResaTopo(resa_topo_id);
    }

    /**
     * Cette méthode récupère les demandes de réservation envoyer au propriétaire du topo.
     * @param compte
     * @return
     */
    public List<ResaTopo> resaTopoListByTopoAccount(Compte compte){

        List<ResaTopo> vResaTopoList = new ArrayList<>();

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#resaTopoListByTopoAccountDao(Compte)*/
        List<ResaTopo> vResaTopoListTemp = getDaoFactory().getResaTopoDao().resaTopoListByTopoAccountDao(compte);

        for (ResaTopo resaTopo : vResaTopoListTemp){
            /**
             * On récupère les messages appartenant à la réservation émise par un utilisateur
             * pour la partie "Demande de réservations" de la JSP.
             * @see org.escalade.consumer.contact.impl.dao.MessagerieImpl#messageListResaTopoDao(Integer)
             */
            List<Messagerie> messagerieList = getDaoFactory().getMessagerieDao().messageListResaTopoDao(resaTopo.getId());

            /**
             * On récupère les topos appartenant à la réservation émise par un utilisateur
             * pour la partie "Demande de réservations" de la JSP.
             * @see org.escalade.consumer.contact.impl.dao.TopoImpl#toposByResaTopoDao(ResaTopo)
             */
            List<Topo> topoList = getDaoFactory().getTopoDao().toposByResaTopoDao(resaTopo);

            resaTopo.setTopoList(topoList);
            resaTopo.setMessagerieList(messagerieList);

            vResaTopoList.add(resaTopo);
        }
        return vResaTopoList;
    }

    /**
     * Cette méthode récupère les demandes de réservation que l'on a émises (Utilisateur en session).
     * @param compte
     * @return
     */
    public List<ResaTopo> resaTopoListByAccount(Compte compte){

        List<ResaTopo> vResaTopoList = new ArrayList<>();

        /**@see org.escalade.consumer.contact.impl.dao.ResaTopoImpl#resaTopoListByAccountDao(Compte)*/
        List<ResaTopo> resaTopoListTemp = getDaoFactory().getResaTopoDao().resaTopoListByAccountDao(compte);

        for (ResaTopo resaTopo : resaTopoListTemp) {

            /**
             * On récupère les messages appartenant à la réservation émise par un utilisateur en session
             * pour la partie "Mes demandes de réservations" de la JSP.
             * @see org.escalade.consumer.contact.impl.dao.MessagerieImpl#messageListResaTopoDao(Integer)
             */
            List<Messagerie> messagerieList = getDaoFactory().getMessagerieDao().messageListResaTopoDao(resaTopo.getId());

            /**
             * On récupère les topos appartenant à la réservation émise par un utilisateur en session
             * pour la partie "Mes demandes de réservations" de la JSP.
             * @see org.escalade.consumer.contact.impl.dao.TopoImpl#toposByResaTopoDao(ResaTopo)
             */
            List<Topo> topoList = getDaoFactory().getTopoDao().toposByResaTopoDao(resaTopo);
            
            resaTopo.setMessagerieList(messagerieList);
            resaTopo.setTopoList(topoList);
            
            vResaTopoList.add(resaTopo);
        }
        return vResaTopoList;
    }
}
