package org.escalade.consumer.contract.dao;
import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Voie;

import java.util.List;

public interface LongueurDao {

        /**
         * Renvoie la liste des longueurs et des relais demandées d'une voie
         *
         * @return les {@link Longueur}
         * */
        List <Longueur> longueurs(Integer voie_id);

        /**
         * Ajouter une longueur et un relai d'une voie
         *
         * @param longueur
         * @return un message de confirmation
         */
        void addLongueur(Longueur longueur, Voie voie);

        /**
         * Renvoie la longueur demandée et les relais de la voie
         *
         * @param id
         * @return la longueur correspondant à son id
         */
        Longueur longueur(Integer id);

        void delLongueur(Integer id);

        void upLongueur(Longueur longueur);

        List<Longueur> listLongueursByVoieDao(Voie voie);

//        List<Longueur> recoversLongueurWorkflowDao(Longueur longueur, Voie voie);
}
