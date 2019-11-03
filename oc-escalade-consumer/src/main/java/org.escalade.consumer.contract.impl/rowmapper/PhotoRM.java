package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.Photo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoRM {

    public RowMapper<Photo> getvPhotoRowMapper() {
        return vPhotoRowMapper;
    }

    public RowMapper<Photo> vPhotoRowMapper = new RowMapper<Photo>() {
        @Override
        public Photo mapRow(ResultSet pRs, int rowNum) throws SQLException {
           Photo vPhoto = new Photo();
           vPhoto.setId(pRs.getInt("id"));
           vPhoto.setNom(pRs.getString("nom"));
           vPhoto.setUrl_image(pRs.getString("url_image"));
           vPhoto.setTopo_id(pRs.getInt("topo_id"));
           vPhoto.setSite_id(pRs.getInt("site_id"));
            return vPhoto;
        }
    };
}
