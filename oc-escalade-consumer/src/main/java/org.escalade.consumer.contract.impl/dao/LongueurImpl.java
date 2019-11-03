package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.LongueurDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.LongueurRM;
import org.escalade.model.bean.Longueur;
import org.escalade.model.bean.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class LongueurImpl extends AbstractDataImpl implements LongueurDao {

    @Override
    public List<Longueur> longueurs(Integer voie_id) {

        String vSql = "SELECT * FROM public.longueur"
                    + " WHERE voie_id = " + voie_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        LongueurRM vLongueurRM = new LongueurRM();

        List<Longueur> vListLongueur = vJdbcTemplate.query(vSql, vLongueurRM.getvLongueurRowMapper());
        return vListLongueur;
    }

    @Override
    public void addLongueur(Longueur longueur, Voie voie) {

        String vSql = "INSERT INTO public.longueur (num_longueur, num_relai, hauteur, cotation, voie_id) VALUES "
                    + " (:num_longueur, :num_relai, :hauteur, :cotation, :voie_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("num_longueur", longueur.getNum_longueur());
        vParams.addValue("num_relai", longueur.getNum_relai());
        vParams.addValue("hauteur", longueur.getHauteur());
        vParams.addValue("cotation", longueur.getCotation());
        vParams.addValue("voie_id", voie.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    @Override
    public Longueur longueur(Integer id) {
        return null;
    }

    /**
     * Supprimer une longueur d'une voie
     * @param id
     * @return un message de confirmation
     */
    @Override
    public void delLongueur(Integer id) {

        String vSql = "DELETE FROM  public.longueur"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Mettre à jour une longueur et un relai d'une voie
     * @param longueur
     */
    @Override
    public void upLongueur(Longueur longueur) {

        String vSql = "UPDATE public.longueur SET"
                    + " hauteur = :hauteur, cotation = :cotation, num_relai = :num_relai"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("hauteur", longueur.getHauteur());
        vParams.addValue("cotation", longueur.getCotation());
        vParams.addValue("num_relai", longueur.getNum_relai());
        vParams.addValue("id", longueur.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    public List<Longueur> listLongueursByVoieDao(Voie voie){

        String vSql = "SELECT longueur.* FROM public.longueur"
                    + " INNER JOIN voie ON voie.id = " + voie.getId()
                    + " WHERE longueur.voie_id = voie.id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        LongueurRM vLongueurRM = new LongueurRM();

        List<Longueur> listLongueur = vJdbcTemplate.query(vSql, vLongueurRM.getvLongueurRowMapper());
        return listLongueur;
    }

//    public List<Longueur> recoversLongueurWorkflowDao(Longueur longueur, Voie voie){
//
//        String vSql = "SELECT * FROM public.longueur_relai"
//                    + " WHERE num_longueur = " + longueur.getNum_longueur()
//                    + " AND  cotation = '" + longueur.getCotation() + "'"
//                    + " AND  hauteur = '" + longueur.getHauteur() + "'"
//                    + " AND  voie_id = " + voie.getId();
//
//        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
//        LongueurRM vLongueurRM = new LongueurRM();
//
//        List<Longueur> vListLongueur = vJdbcTemplate.query(vSql, vLongueurRM.getvLongueurRowMapper());
//        return vListLongueur;
//    }
}
