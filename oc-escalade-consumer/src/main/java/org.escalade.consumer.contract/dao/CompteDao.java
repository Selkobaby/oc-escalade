package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import java.util.List;

public interface CompteDao {

        List<Compte> comptes();

        void addCompte(Compte compte);

        Compte compte(Integer compte_id);

        void delCompte(Integer id);

        void upCompte(Compte upCompte, Compte compte);

        Compte comptByUtilisateur(String login, String password);

        List<Compte> compteByCommentairesDao(Commentaire commentaire);

        List<Compte> compteByResaTopoDao(Integer compte_id);

        List<Compte> ownerAccountByResaTopoDao(Integer topo_id);

}
