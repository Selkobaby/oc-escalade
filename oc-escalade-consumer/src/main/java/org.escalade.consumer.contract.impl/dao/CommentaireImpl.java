package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.CommentaireDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.CommentaireRM;
import org.escalade.model.bean.Commentaire;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class CommentaireImpl extends AbstractDataImpl implements CommentaireDao {

    /**
     * Renvoie la liste des commentaires demandés
     * @return les {@link Commentaire}
     * */
    @Override
    public List<Commentaire> commentaires(Integer site_id, Integer topo_id) {

        String vSql = null;

        if (site_id != null){
            vSql
                    = " SELECT * FROM public.commentaire"
                    + " WHERE site_id = " + site_id;
        }

        if (topo_id != null){
            vSql
                    = "SELECT * FROM public.commentaire"
                    + " WHERE topo_id = " + topo_id;
        }

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CommentaireRM commentaireRM = new CommentaireRM();

        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSql, commentaireRM.getvCommentaireRowMapper());
        return vListCommentaire;
    }

    /**
     * Ajouter un commentaire
     *
     * @param commentaire
     * @return un message de confirmation
     */
    @Override
    public void addCommentaireSiteDao(Commentaire commentaire, Compte compte){

        String vSql = "INSERT INTO public.commentaire (commentaire, site_id, compte_id) VALUES "
                    + " (:commentaire, :site_id, :compte_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("commentaire", commentaire.getCommentaire());
        vParams.addValue("site_id", commentaire.getSite_id());
        vParams.addValue("compte_id", compte.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    public void addCommentaireTopoDao(Commentaire commentaire, Compte compte){

        String vSql = "INSERT INTO public.commentaire (commentaire, topo_id, compte_id) VALUES "
                + " (:commentaire, :topo_id, :compte_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("commentaire", commentaire.getCommentaire());
        vParams.addValue("topo_id", commentaire.getTopo_id());
        vParams.addValue("compte_id", compte.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie le commentaire demandé
     * @param site_id, topo_id
     * @return le commentaire correspondant à son id
     */
    @Override
    public Commentaire commentaire(Integer site_id, Integer topo_id) {
        String vSql = null;

        if (site_id != null){
            vSql
                    = " SELECT * FROM public.commentaire"
                    + " WHERE site_id = " + site_id;
        }

        if (topo_id != null){
            vSql
                    = "SELECT * FROM public.commentaire"
                    + " WHERE topo_id = " + topo_id;
        }

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CommentaireRM commentaireRM = new CommentaireRM();

        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSql, commentaireRM.getvCommentaireRowMapper());
        return vListCommentaire.get(0);
    }

    /**
     * Supprimer un commentaire
     * @param id
     * @return un message de confirmation
     */
    @Override
    public String delCommentaire(Integer id) {
        return null;
    }

    public List<Commentaire> commentairesByTopoDao(Topo topo){

        String vSql = "SELECT * FROM public.commentaire"
                    + " WHERE topo_id = " + topo.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        CommentaireRM vCommentaireRM = new CommentaireRM();

        List<Commentaire> commentaireList = vJdbcTemplate.query(vSql, vCommentaireRM.getvCommentaireRowMapper());
        return commentaireList;
    }
}
