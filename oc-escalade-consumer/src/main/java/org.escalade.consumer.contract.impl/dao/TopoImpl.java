package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.TopoDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.TopoRM;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;
import org.escalade.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class TopoImpl extends AbstractDataImpl implements TopoDao {

    /**
     * Renvoie la liste des topos demandés
     * @return les {@link Topo}
     */
    @Override
    public List<Topo> topos() {
        String vSql = "SELECT * FROM public.topo";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM topoRM = new TopoRM();

        List<Topo> vListTopo = vJdbcTemplate.query(vSql, topoRM.getvTopoRowMapper());
        return vListTopo;
    }

    /**
     * Ajouter un Topo
     * @param topo
     * @return un message de confirmation
     */
    @Override
    public void addTopo(Topo topo, Compte compte) {

        String vSql = "INSERT INTO public.topo (nom, statut, description, date_upload, compte_id) VALUES "
                    + " (:nom, :statut, :description, :date_upload, :compte_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", topo.getNom());
        vParams.addValue("statut", topo.getStatut());
        vParams.addValue("description", topo.getDescription());
        vParams.addValue("date_upload", topo.getDate_upload());
        vParams.addValue("compte_id", compte.getId());


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Renvoie le topo demandé
     * @param topo_id
     * @return le topo correspondant à son id
     */
    @Override
    public Topo topo(Integer topo_id) {

        String vSql = "SELECT * FROM public.topo"
                    + " WHERE id = " + topo_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM topoRM = new TopoRM();

        List<Topo> vListTopo = vJdbcTemplate.query(vSql, topoRM.getvTopoRowMapper());
        return vListTopo.get(0);
    }

    /**
     * Supprimer un topo
     * @param id
     * @return un message de confirmation
     */
    @Override
    public void delTopo(Integer id){

        String vSql = "DELETE FROM public.topo WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    /**
     * Mettre à jour un topo
     *
     * @param topo
     * @return un message de confirmation
     */
    @Override
    public void upTopo(Topo topo) {

        String vSql = "UPDATE public.topo SET"
                    + " nom = :nom, statut = :statut, date_upload = :date_upload, description = :description"
                    + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", topo.getId());
        vParams.addValue("nom", topo.getNom());
        vParams.addValue("statut", topo.getStatut());
        vParams.addValue("date_upload", topo.getDate_upload());
        vParams.addValue("description", topo.getDescription());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    public Topo recoversTopoForIdDao(Compte compte, Topo topo){

        String vSql = "SELECT * FROM public.topo"
                    + " WHERE compte_id = " + compte.getId()
                    + " AND nom = '" + topo.getNom() + "'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM vTopoRM = new TopoRM();

        List<Topo> topos = vJdbcTemplate.query(vSql, vTopoRM.getvTopoRowMapper());
        return topos.get(0);
    }

    public List<Topo> topoByAccountDao(Compte compte){

        String vSql = "SELECT * FROM public.topo"
                    + " WHERE compte_id = " + compte.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        TopoRM vTopoRM = new TopoRM();

        List<Topo> topoList = vJdbcTemplate.query(vSql, vTopoRM.getvTopoRowMapper());
        return topoList;
    }

    /**
     * Cette méthode récupère les topos appartenant à la réservation émise.
     * @param resaTopo
     * @return
     */
    public List<Topo> toposByResaTopoDao(ResaTopo resaTopo){

        String vSql = "SELECT * FROM public.topo"
                    + " WHERE id = " + resaTopo.getTopo_id();

        JdbcTemplate vJdbcTemplate =  new JdbcTemplate(getDataSource());
        TopoRM vTopoRM = new TopoRM();

        List<Topo> topoList = vJdbcTemplate.query(vSql, vTopoRM.getvTopoRowMapper());
        return topoList;
    }
}
