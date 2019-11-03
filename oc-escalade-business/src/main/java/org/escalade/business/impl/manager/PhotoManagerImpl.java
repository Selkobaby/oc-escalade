package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.PhotoManager;
import org.escalade.business.impl.AbstractManagerImpl;
import org.escalade.model.bean.Photo;
import org.escalade.model.bean.Topo;

import java.util.ArrayList;
import java.util.List;

public class PhotoManagerImpl extends AbstractManagerImpl implements PhotoManager {
    
    @Override
    public void addPhoto(Topo topo, String nomPhoto, String url_image) {

        /**@see org.escalade.consumer.contact.impl.dao.PhotoImpl#addPhotoTopo(Topo, String, String)*/
        getDaoFactory().getPhotoDao().addPhotoTopo(topo, nomPhoto, url_image);
    }

    @Override
    public List<Photo> listPhotosOneTopo(Integer topo_id) {

        /**@see org.escalade.consumer.contact.impl.dao.PhotoImpl#listPhotosOneTopoDao(Integer) */
        List<Photo> photoList = getDaoFactory().getPhotoDao().listPhotosOneTopoDao(topo_id);

        return photoList;
    }

    @Override
    public void delPhotoTopo(Integer topo_id) {

        /**@see org.escalade.consumer.contact.impl.dao.PhotoImpl#delPhotoTopoDao(Integer)*/
        getDaoFactory().getPhotoDao().delPhotoTopoDao(topo_id);

    }

    @Override
    public void upPhoto(Photo photo){

        /**@see org.escalade.consumer.contact.impl.dao.PhotoImpl#upPhotoDao(Photo)*/
        getDaoFactory().getPhotoDao().upPhotoDao(photo);

    }

    public List<Photo> listPhotosByTopos(List<Topo> topoList){

        List<Photo> photoList = new ArrayList<>();

        for (Topo topo : topoList){

            /**@see org.escalade.consumer.contact.impl.dao.PhotoImpl#listPhotosByToposDao(Topo)*/
            List<Photo> photoListTemp = getDaoFactory().getPhotoDao().listPhotosByToposDao(topo);
            photoList.addAll(photoListTemp);
        }

        return photoList;
    }

    public Photo photoByTopo (Topo topo){
        /**@see org.escalade.consumer.contact.impl.dao.PhotoImpl#photoByTopo(Topo)*/
        return getDaoFactory().getPhotoDao().photoByTopo(topo);

    }
}
