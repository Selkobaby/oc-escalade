package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.PhotoDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.PhotoRM;
import org.escalade.model.bean.Photo;
import org.escalade.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class PhotoImpl extends AbstractDataImpl implements PhotoDao {

    @Override
    public void addPhotoTopo(Topo topo, String nomPhoto, String url_image) {

        String vSql = "INSERT INTO public.photo (nom, url_image, topo_id) VALUES"
                    + " (:nom, :url_image, :topo_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", nomPhoto);
        vParams.addValue("url_image", url_image);
        vParams.addValue("topo_id", topo.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    @Override
    public List<Photo> listPhotosOneTopoDao(Integer topo_id) {

        String vSql = "SELECT * FROM public.photo"
                    + " WHERE topo_id = " + topo_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        PhotoRM vPhotoRM = new PhotoRM();

        List<Photo> photoList = vJdbcTemplate.query(vSql, vPhotoRM.getvPhotoRowMapper());
        return photoList;
    }

    @Override
    public void delPhotoTopoDao(Integer topo_id) {

        String vSql = "DELETE FROM public.photo WHERE topo_id = :topo_id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("topo_id", topo_id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    @Override
    public void upPhotoDao(Photo photo){

        String vSql = "UPDATE public.photo SET"
                    + " nom = :nom, url_image = :url_image"
                    + " WHERE id= :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", photo.getId());
        vParams.addValue("nom", photo.getNom());
        vParams.addValue("url_image", photo.getUrl_image());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    public List<Photo> listPhotosByToposDao(Topo topo){

        String vSql = "SELECT * FROM public.photo"
                    + " WHERE topo_id = " + topo.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        PhotoRM vPhotoRM = new PhotoRM();

        List<Photo> vPhotoList = vJdbcTemplate.query(vSql, vPhotoRM.vPhotoRowMapper);
        return vPhotoList;
    }

    public Photo photoByTopo(Topo topo) {

        String vSql = "SELECT * FROM public.photo"
                    + " WHERE topo_id = " + topo.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        PhotoRM vPhotoRM = new PhotoRM();

        List<Photo> photo = vJdbcTemplate.query(vSql, vPhotoRM.vPhotoRowMapper);
        return photo.get(0);
    }
}
