package org.escalade.business.contract;

import org.escalade.business.contract.manager.CommentaireManager;
import org.escalade.business.contract.manager.CompteManager;
import org.escalade.business.contract.manager.LongueurManager;
import org.escalade.business.contract.manager.MessagerieManager;
import org.escalade.business.contract.manager.PhotoManager;
import org.escalade.business.contract.manager.ResaTopoManager;
import org.escalade.business.contract.manager.SecteurManager;
import org.escalade.business.contract.manager.SiteManager;
import org.escalade.business.contract.manager.TopoManager;
import org.escalade.business.contract.manager.VoieManager;

public interface ManagerFactory {

    CommentaireManager getCommentaireManager();

    void setCommentaireManager(CommentaireManager commentaireManager);

    CompteManager getCompteManager();

    void setCompteManager(CompteManager compteManager);

    LongueurManager getLongueurManager();

    void setLongueurManager(LongueurManager longueurManager);

    ResaTopoManager getResaTopoManager();

    void setResaTopoManager(ResaTopoManager resaTopoManager);

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager secteurManager);

    SiteManager getSiteManager();

    void setSiteManager(SiteManager siteManager);

    TopoManager getTopoManager();

    void setTopoManager(TopoManager topoManager);

    VoieManager getVoieManager();

    void setVoieManager(VoieManager voieManager);

    PhotoManager getPhotoManager();

    void setPhotoManager(PhotoManager photoManager);

    MessagerieManager getMessagerieManager();

    void setMessagerieManager(MessagerieManager messagerieManager);
}
