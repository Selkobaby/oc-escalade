package org.escalade.business.contract.manager;

import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Topo;

import java.util.List;

public interface CommentaireManager {

    void addCommentaireSite(Commentaire commentaire, Compte compte);

    void addCommentaireTopo(Commentaire commentaire, Compte compte);

    Commentaire commentaire(Integer site_id, Integer topo_id);

    String delCommentaire(Integer id);

    List<Commentaire> commentairesByTopo(List<Topo> topoList);
}
