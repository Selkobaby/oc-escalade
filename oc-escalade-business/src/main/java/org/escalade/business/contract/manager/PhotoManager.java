package org.escalade.business.contract.manager;

import org.escalade.model.bean.Photo;
import org.escalade.model.bean.Topo;

import java.util.List;

public interface PhotoManager {

    void addPhoto(Topo topo, String nomPhoto, String url_image);

    List<Photo> listPhotosOneTopo(Integer topo_id);

    void delPhotoTopo(Integer id);

    void upPhoto(Photo photo);

    List<Photo> listPhotosByTopos(List<Topo> topoList);

    Photo photoByTopo (Topo topo);
}
