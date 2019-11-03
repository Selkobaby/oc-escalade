package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.CommentaireManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Topo;

import java.util.ArrayList;
import java.util.List;

public class CommentaireManagerImpl extends AbstractManagerImpl implements CommentaireManager {

    @Override
    public void addCommentaireSite(Commentaire commentaire, Compte compte) {

        /**@see org.escalade.consumer.contact.impl.dao.CommentaireImpl#addCommentaireSiteDao(Commentaire, Compte)*/
         getDaoFactory().getCommentaireDao().addCommentaireSiteDao(commentaire, compte);
    }

    public void addCommentaireTopo(Commentaire commentaire, Compte compte){

         /**@see org.escalade.consumer.contact.impl.dao.CommentaireImpl#addCommentaireTopoDao(Commentaire, Compte)*/
        getDaoFactory().getCommentaireDao().addCommentaireTopoDao(commentaire, compte);
    }

    @Override
    public Commentaire commentaire(Integer site_id, Integer topo_id) {

        /**@see org.escalade.consumer.contact.impl.dao.CommentaireImpl#commentaire(Integer, Integer)*/
        return getDaoFactory().getCommentaireDao().commentaire(site_id, topo_id);
    }

    @Override
    public String delCommentaire(Integer id) {

        /**@see org.escalade.consumer.contact.impl.dao.CommentaireImpl#delCommentaire(Integer)*/
        return getDaoFactory().getCommentaireDao().delCommentaire(id);
    }

    public List<Commentaire> commentairesByTopo(List<Topo> topoList){

        List<Commentaire> commentaireList = new ArrayList<>();

        for (Topo topo : topoList){
            /**@see org.escalade.consumer.contact.impl.dao.CommentaireImpl#commentairesByTopoDao(Topo)*/
            List<Commentaire> commentaireListTemp = getDaoFactory().getCommentaireDao().commentairesByTopoDao(topo);
            commentaireList.addAll(commentaireListTemp);
        }

        return commentaireList;
    }
}
