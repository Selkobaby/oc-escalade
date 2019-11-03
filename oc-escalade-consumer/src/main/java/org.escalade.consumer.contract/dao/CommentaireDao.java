package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Topo;

import java.util.List;

public interface CommentaireDao {

        List<Commentaire> commentaires(Integer site_id, Integer topo_id);

        void addCommentaireSiteDao(Commentaire commentaire, Compte compte);

        void addCommentaireTopoDao(Commentaire commentaire, Compte compte);

        Commentaire commentaire(Integer site_id, Integer topo_id);

        String delCommentaire(Integer id);

        List<Commentaire> commentairesByTopoDao(Topo topo);
}
