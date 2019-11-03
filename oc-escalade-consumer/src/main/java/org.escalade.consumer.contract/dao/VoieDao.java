package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Voie;
import java.util.List;

public interface VoieDao {

    List<Voie> voies(Integer secteur_id);

    void addVoie(Voie voie, Secteur secteur);

    Voie voie(Integer id);

    void delVoie(Integer id);

    void upVoie(Voie voie);

    List<Voie> SimpleSearchByClimbingRoute(String motCleRecherche);

    List<Voie> listVoiesByAccountDao(Compte compte);

    Voie recoversVoieWorkflowDao(Voie voie, Secteur secteur);
}
