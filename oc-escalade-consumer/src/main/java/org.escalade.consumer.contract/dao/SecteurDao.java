package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;

import java.util.List;

public interface SecteurDao {

        List <Secteur> secteurs();

        void addSecteur(Secteur secteur, Integer site_id);

        Secteur secteur(Integer id);

        void delSecteur(Integer id);

        void upSecteur(Secteur secteur);

        List<Secteur> secteursBySiteId(Integer site_id);

        List<Secteur> secteurBySimpleSearchDao(String motCleRecherche);

        List<Secteur> rechercheSecteurParVoie(Integer secteur_id);

        List<Secteur> listSecteurByAccountDao(Compte compte);

        Secteur recoversSecteurWorkflowDao(Secteur secteur, Site site);
}
