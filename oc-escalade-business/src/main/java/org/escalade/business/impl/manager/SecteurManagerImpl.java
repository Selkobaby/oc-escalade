package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.SecteurManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Secteur;
import org.escalade.model.bean.Site;
import org.escalade.model.bean.Voie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecteurManagerImpl extends AbstractManagerImpl implements SecteurManager {

    @Override
    public void addSecteur(Secteur secteur, Integer site_id) {

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#addSecteur(Secteur, Integer) */
        getDaoFactory().getSecteurDao().addSecteur(secteur, site_id);
    }

    @Override
    public Secteur secteur(Integer id) {

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#secteur(Integer) */
        Secteur secteur = getDaoFactory().getSecteurDao().secteur(id);

        /**@see org.escalade.consumer.contact.impl.dao.VoieImpl#voies(Integer)*/
        List<Voie> voies = getDaoFactory().getVoieDao().voies(id);

        secteur.setListVoies(voies);

        return secteur;
    }

    @Override
    public void delSecteur(Integer id) {

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#delSecteur(Integer)*/
        getDaoFactory().getSecteurDao().delSecteur(id);
    }

    @Override
    public void upSecteur(Secteur secteur) {

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#upSecteur(Secteur)*/
        getDaoFactory().getSecteurDao().upSecteur(secteur);
    }

    /**
     * Recherche le secteur en correspondance avec le mot-clé saisi par l'utilisateur.
     * @param motCleRecherche
     * @return secteurs
     */
    public List<Secteur> secteurBySimpleSearch(String motCleRecherche){

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#secteurBySimpleSearchDao(String) */
        List<Secteur> secteurs = getDaoFactory().getSecteurDao().secteurBySimpleSearchDao(motCleRecherche);

        return secteurs;
    }

    /**
     * Renvoie le(s) secteur(s) correspondant aux voies trouver lors de la recherche,
     * dans la "barre de recherche" du navigateur.
     * @param voies
     * @return secteurs
     */
    public List<Secteur> rechercheSecteurParVoie(List<Voie> voies){

        List<Secteur> secteurs = new ArrayList<>();
        Set<Integer> voieSecteur_id = new HashSet<>();

        for (Voie voie: voies){
            voieSecteur_id.add(voie.getSecteur_id());
        }

        for (Integer secteur_id: voieSecteur_id){
            /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#rechercheSecteurParVoie(Integer)*/
            List<Secteur> secteursParVoie = getDaoFactory().getSecteurDao().rechercheSecteurParVoie(secteur_id);
            secteurs.addAll(secteursParVoie);
        }

        return secteurs;
    }

    public List<Secteur> listSecteurByAccount(Compte compte){

        /**@see org.escalade.consumer.contact.impl.dao.SecteurImpl#listSecteurByAccountDao(Compte) */
       List<Secteur> vSecteurs = getDaoFactory().getSecteurDao().listSecteurByAccountDao(compte);
       return vSecteurs;
    }

    /**
     * Ajoute le site  dscalade du Workflow
     * @param secteur
     * @param site
     * @return le Secteur du Workflow pour transmettre l'id du secteur à la voie
     */
    public Secteur addSecteurWorkflow (Secteur secteur, Site site){

        getDaoFactory().getSecteurDao().addSecteur(secteur, site.getId());

        /** @see org.escalade.consumer.contact.impl.dao.SecteurImpl#recoversSecteurWorkflowDao(Secteur, Site)*/
        Secteur vSecteur = getDaoFactory().getSecteurDao().recoversSecteurWorkflowDao(secteur, site);

        return vSecteur;
    }
}
