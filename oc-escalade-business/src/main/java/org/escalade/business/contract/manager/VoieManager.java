package org.escalade.business.contract.manager;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Voie;

import java.util.List;

public interface VoieManager {

     List<Voie> voies(Integer secteur_id);

     void addVoie(Voie voie, Secteur secteur);

     Voie voie(Integer id);

     void delVoie(Integer id);

     void upVoie(Voie voie );

     List<Voie>  rechercheSimpleParVoie(String motCleRecherche);

     List<Voie> listVoiesByAccount(Compte compte);

     Voie addVoieWorkflow (Voie voie, Secteur secteur);
}
