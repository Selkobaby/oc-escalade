package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.LongueurManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.consumer.contract.impl.dao.LongueurImpl;
import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Voie;

import java.util.List;

public class LongueurManagerImpl extends AbstractManagerImpl implements LongueurManager {

    @Override
    public void addLongueur(Longueur longueur, Voie voie) {

        /**@see LongueurImpl#addLongueur(Longueur, Voie)*/
        getDaoFactory().getLongueurDao().addLongueur(longueur, voie);
    }

    @Override
    public Longueur longueur(Integer id) {

        /**@see LongueurImpl#longueur(Integer)*/
        return getDaoFactory().getLongueurDao().longueur(id);
    }

    @Override
    public void delLongueur(Integer id) {

        /**@see LongueurImpl#delLongueur(Integer)*/
        getDaoFactory().getLongueurDao().delLongueur(id);
    }

    @Override
    public void upLongueur(List<Longueur> longueurs) {

        for (Longueur longueur : longueurs){
            /**@see LongueurImpl#upLongueur(Longueur)*/
            getDaoFactory().getLongueurDao().upLongueur(longueur);
        }
    }

    public List<Longueur> listLongueursByVoie(Voie voie){

        /**@see LongueurImpl#listLongueursByVoieDao(Voie)*/
        List<Longueur> longueurList = getDaoFactory().getLongueurDao().listLongueursByVoieDao(voie);
        return longueurList;
    }

    /**
     * Cette méthode transmet à la couche consumer les longueurs une à une pour les ajouter à la base de données.
     * @param longueurs
     * @param voie
     */
    public void addLongueurWorkflow(List<Longueur> longueurs, Voie voie) {

        for (Longueur longueur : longueurs){

            /**@see LongueurImpl#addLongueur(Longueur, Voie)*/
            getDaoFactory().getLongueurDao().addLongueur(longueur, voie);
        }
    }
}
