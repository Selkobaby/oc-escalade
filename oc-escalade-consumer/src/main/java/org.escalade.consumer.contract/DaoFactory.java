package org.escalade.consumer.contract;


import org.escalade.consumer.contract.dao.CommentaireDao;
import org.escalade.consumer.contract.dao.CompteDao;
import org.escalade.consumer.contract.dao.LongueurDao;
import org.escalade.consumer.contract.dao.MessagerieDao;
import org.escalade.consumer.contract.dao.PhotoDao;
import org.escalade.consumer.contract.dao.ResaTopoDao;
import org.escalade.consumer.contract.dao.SecteurDao;
import org.escalade.consumer.contract.dao.SiteDao;
import org.escalade.consumer.contract.dao.TopoDao;
import org.escalade.consumer.contract.dao.VoieDao;

public interface DaoFactory {

    CommentaireDao getCommentaireDao();

    void setCommentaireDao(CommentaireDao commentaireDao);

    CompteDao getCompteDao();

    void setCompteDao(CompteDao compteDao);

    LongueurDao getLongueurDao();

    void setLongueurDao(LongueurDao longueurDao);

    ResaTopoDao getResaTopoDao();

    void setResaTopoDao(ResaTopoDao resaTopoDao);

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao secteurDao);

    SiteDao getSiteDao();

    void setSiteDao(SiteDao siteDao);

    TopoDao getTopoDao();

    void setTopoDao(TopoDao topoDao);

    VoieDao getVoieDao();

    void  setVoieDao(VoieDao voieDao);

    PhotoDao getPhotoDao();

    void setPhotoDao(PhotoDao photoDao);

    MessagerieDao getMessagerieDao();

    void setMessagerieDao(MessagerieDao messagerieDao);
}
