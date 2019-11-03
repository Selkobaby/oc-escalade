package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Photo;
import org.escalade.model.bean.Topo;

import java.util.List;

public interface PhotoDao {

    void addPhotoTopo(Topo topo, String nomPhoto, String url_image);

    List<Photo> listPhotosOneTopoDao(Integer topo_id);

    void delPhotoTopoDao(Integer id);

    void upPhotoDao(Photo photo);

    List<Photo> listPhotosByToposDao(Topo topo);

    Photo photoByTopo(Topo topo);

}
