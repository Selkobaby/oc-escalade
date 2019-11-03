package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.TopoManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.consumer.contract.impl.dao.TopoImpl;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;
import org.escalade.model.bean.Topo;

import java.util.List;

public class TopoManagerImpl extends AbstractManagerImpl implements TopoManager {

    @Override
    public List<Topo> topos() {

        /**@see TopoImpl#topos() */
        return getDaoFactory().getTopoDao().topos();
    }

    @Override
    public void addTopo(Topo topo, Compte compte) {

        /**@see org.escalade.consumer.impl.dao.TopoImpl#addTopo(Topo, Compte)*/
        getDaoFactory().getTopoDao().addTopo(topo, compte);
    }

    @Override
    public Topo topo(Integer topo_id) {

        /**@see org.escalade.consumer.impl.dao.TopoImpl#topo(Integer)*/
        Topo topo = getDaoFactory().getTopoDao().topo(topo_id);

        /**@see org.escalade.consumer.impl.dao.CommentaireImpl#commentaires(Integer, Integer)*/
        List<Commentaire> commentaires = getDaoFactory().getCommentaireDao().commentaires(null, topo.getId());
        topo.setCommentaires(commentaires);

        /**@see org.escalade.consumer.impl.dao.ResaTopoImpl#resaTopos(Integer, Integer)*/
        List<ResaTopo> resaTopos = getDaoFactory().getResaTopoDao().resaTopos(topo.getId());
        topo.setResaTopos(resaTopos);

        return topo;
    }

    @Override
    public void delTopo(Integer id) {

        /**@see org.escalade.consumer.impl.dao.TopoImpl#delTopo(Integer)*/
        getDaoFactory().getTopoDao().delTopo(id);
    }

    @Override
    public void upTopo(Topo topo) {

        /**@see org.escalade.consumer.impl.dao.TopoImpl#upTopo(Topo) */
        getDaoFactory().getTopoDao().upTopo(topo);

    }

    public Topo recoversTopoForId(Compte compte, Topo topo){

        /**@see org.escalade.consumer.impl.dao.TopoImpl#recoversTopoForIdDao(Compte, Topo)*/
        topo = getDaoFactory().getTopoDao().recoversTopoForIdDao(compte, topo);

        return topo;
    }

    public List<Topo> topoByAccount(Compte compte){

        /**@see org.escalade.consumer.impl.dao.TopoImpl#topoByAccountDao(Compte)*/
        List<Topo> topoList = getDaoFactory().getTopoDao().topoByAccountDao(compte);

        for (Topo topo : topoList){
            List<Commentaire> commentaireList = getDaoFactory().getCommentaireDao().commentaires(null, topo.getId());
            topo.setCommentaires(commentaireList);
        }

        return topoList;
    }

}
