package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.MessagerieDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.MessagerieRM;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Messagerie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class MessagerieImpl extends AbstractDataImpl implements MessagerieDao {

    /**
     * Cette méthode ajoute un message d'un utilisateur lié à la fonctionnalité de la réservation d'un topo.
     * @param message
     */
    public void addMessage(Messagerie message, Compte compte){

        String vSql = "INSERT INTO public.messagerie (resa_topo_id, date_message, message, compte_id) VALUES"
                    + " (:resa_topo_id, :date_message, :message, :compte_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("resa_topo_id", message.getResa_topo_id());
        vParams.addValue("date_message", message.getDate_message());
        vParams.addValue("message", message.getMessage());
        vParams.addValue("compte_id", compte.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    public List<Messagerie> messageListResaTopoDao(Integer resa_id){

        String vSql = "SELECT * FROM public.messagerie"
                    + " WHERE resa_topo_id = " + resa_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        MessagerieRM vMessagerieRM = new MessagerieRM();

        List<Messagerie> vMessagerieList = vJdbcTemplate.query(vSql, vMessagerieRM.getvMessagerieRowMapper());
        return vMessagerieList;
    }
}
