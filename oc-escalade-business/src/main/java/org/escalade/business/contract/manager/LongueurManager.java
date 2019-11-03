package org.escalade.business.contract.manager;

import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Voie;

import java.util.List;

public interface LongueurManager {

    void addLongueur(Longueur longueur, Voie voie);

    Longueur longueur(Integer id);

    void delLongueur(Integer id);

    void upLongueur(List<Longueur> longueurs) ;

    List<Longueur> listLongueursByVoie(Voie voie);

    void addLongueurWorkflow(List<Longueur> longueur, Voie voie);
}
