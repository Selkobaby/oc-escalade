package org.escalade.business.contract.manager;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import org.escalade.model.bean.Voie;

import java.util.List;

public interface SecteurManager {

    void addSecteur(Secteur secteur, Integer site_id);

    Secteur secteur(Integer id);

    void delSecteur(Integer id);

    void upSecteur(Secteur secteur);

    List<Secteur> secteurBySimpleSearch(String motCleRecherche);

    List<Secteur> rechercheSecteurParVoie(List<Voie> voies);

    List<Secteur> listSecteurByAccount(Compte compte);

    Secteur addSecteurWorkflow (Secteur secteur, Site site);
}
