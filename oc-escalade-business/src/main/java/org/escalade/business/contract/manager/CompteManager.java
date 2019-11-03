package org.escalade.business.contract.manager;

import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;

import java.util.List;

public interface CompteManager {

    void addCompte(Compte compte);

    Compte compte(Integer compte_id);

    void delCompte(Compte compte_id);

    void upCompte(Compte upCompte, Compte compte);

    Compte comptByUtilisateur (String login, String password);

    List<Compte> compteByCommentaires(List<Commentaire> commentaireList);

    List<Compte> compteByResaTopo(List<ResaTopo> resaTopoList);

    List<Compte> ownerAccountByResaTopo (List<ResaTopo> resaTopoList);

}
