package org.escalade.consumer.contract.impl;

import org.escalade.consumer.contract.DaoFactory;
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

public class DaoFactoryImpl implements DaoFactory {

    private CommentaireDao commentaireDao;
    private CompteDao compteDao;
    private LongueurDao longueurDao;
    private ResaTopoDao resaTopoDao;
    private SecteurDao secteurDao;
    private SiteDao siteDao;
    private TopoDao topoDao;
    private VoieDao voieDao;
    private PhotoDao photoDao;
    private MessagerieDao messagerieDao;

    @Override
    public CommentaireDao getCommentaireDao() {
        return commentaireDao;
    }

    @Override
    public void setCommentaireDao(CommentaireDao commentaireDao) {
        this.commentaireDao = commentaireDao;
    }

    @Override
    public CompteDao getCompteDao() {
        return compteDao;
    }

    @Override
    public void setCompteDao(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

    @Override
    public LongueurDao getLongueurDao() {
        return longueurDao;
    }

    @Override
    public void setLongueurDao(LongueurDao longueurDao) {
        this.longueurDao = longueurDao;
    }

    @Override
    public ResaTopoDao getResaTopoDao() {
        return resaTopoDao;
    }

    @Override
    public void setResaTopoDao(ResaTopoDao resaTopoDao) {
        this.resaTopoDao = resaTopoDao;
    }

    @Override
    public SecteurDao getSecteurDao() {
        return secteurDao;
    }

    @Override
    public void setSecteurDao(SecteurDao secteurDao) {
        this.secteurDao = secteurDao;
    }

    @Override
    public SiteDao getSiteDao() {
        return siteDao;
    }

    @Override
    public void setSiteDao(SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    @Override
    public TopoDao getTopoDao() {
        return topoDao;
    }

    @Override
    public void setTopoDao(TopoDao topoDao) {
        this.topoDao = topoDao;
    }

    @Override
    public VoieDao getVoieDao() {
        return voieDao;
    }

    @Override
    public void setVoieDao(VoieDao voieDao) {
        this.voieDao = voieDao;
    }

    @Override
    public PhotoDao getPhotoDao() {
        return photoDao;
    }

    @Override
    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public MessagerieDao getMessagerieDao() {
        return messagerieDao;
    }

    @Override
    public void setMessagerieDao(MessagerieDao messagerieDao) {
        this.messagerieDao = messagerieDao;
    }
}
