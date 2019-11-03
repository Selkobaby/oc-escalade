package org.escalade.consumer.contract.impl.dao;

import org.escalade.consumer.contract.dao.ResaTopoDao;
import org.escalade.consumer.contract.impl.data.AbstractDataImpl;
import org.escalade.consumer.contract.impl.rowmapper.ResaTopoRM;
import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class ResaTopoImpl extends AbstractDataImpl implements ResaTopoDao {

    /**
     * Renvoie la liste des réservations de topos
     *
     * @return les {@link ResaTopo}
     * */
    @Override
    public List<ResaTopo> resaTopos(Integer topo_id) {

        String vSql = "SELECT * FROM public.resa_topo"
                    + " WHERE topo_id = " + topo_id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ResaTopoRM resaTopoRM = new ResaTopoRM();

        List<ResaTopo> vListResaTopo = vJdbcTemplate.query(vSql, resaTopoRM.getvResaTopoRowMapper());
        return vListResaTopo;
    }

    /**
     * Cette méthode permet d'ajouter une nouvelle réservation de topo
     * @param resaTopo
     * @return un message de confirmation
     */
    @Override
    public void addResaTopo(ResaTopo resaTopo, Compte compte){

        String vSql = "INSERT INTO public.resa_topo (statut, date_debut, date_fin, topo_id, proprietaire_topo, compte_id) VALUES"
                + " (:statut, :date_debut, :date_fin, :topo_id, :proprietaire_topo, :compte_id)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("statut", resaTopo.getStatut());
        vParams.addValue("date_debut", resaTopo.getDate_debut());
        vParams.addValue("date_fin", resaTopo.getDate_fin());
        vParams.addValue("topo_id", resaTopo.getTopo_id());
        vParams.addValue("proprietaire_topo", resaTopo.getProprietaire_topo());
        vParams.addValue("compte_id", compte.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    public void upResaTopoDao(ResaTopo resaTopo){

        String vSql = "UPDATE public.resa_topo SET statut = :statut"
                + " WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", resaTopo.getId());
        vParams.addValue("statut", resaTopo.getStatut());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);

    }

    /**
     * Renvoie la réservation du topo demandé
     *
     * @param resa_topo_id
     * @return la réservation du topo correspondant à son id
     */
    @Override
    public ResaTopo resaTopo(Integer resa_topo_id) {


        String vSql = "SELECT * FROM public.resa_topo"
                + " WHERE id = " + resa_topo_id;


        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ResaTopoRM resaTopoRM = new ResaTopoRM();

        List<ResaTopo> vResaTopo = vJdbcTemplate.query(vSql, resaTopoRM.getvResaTopoRowMapper());
        return vResaTopo.get(0);
    }

    /**
     * Supprimer une réservation de topo
     *
     * @param resa_topo_id
     * @return un message de confirmation
     */
    @Override
    public void delResaTopo(Integer resa_topo_id) {

        String vSql = "DELETE FROM public.resa_topo WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", resa_topo_id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSql, vParams);
    }

    /**
     * Cette méthode récupère dans le base de donnée les demandes de réservation envoyer au propriétaire du topo.
     * @param compte
     * @return
     */
    public List<ResaTopo> resaTopoListByTopoAccountDao(Compte compte){

        String vSql = "SELECT resa_topo.* FROM public.resa_topo"
                + " INNER JOIN topo ON topo.compte_id = " + compte.getId()
                + " WHERE resa_topo.topo_id = topo.id";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ResaTopoRM vResaTopoRM = new ResaTopoRM();

        List<ResaTopo> vResaTopoList = vJdbcTemplate.query(vSql, vResaTopoRM.getvResaTopoRowMapper());
        return vResaTopoList;
    }

    /**
     * Cette méthode récupère dans la base de données les demandes de réservation que l'on a émises.
     * @param compte
     * @return
     */
    public List<ResaTopo> resaTopoListByAccountDao(Compte compte){

        String vSql = "SELECT * FROM public.resa_topo"
                + " WHERE compte_id = " + compte.getId();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ResaTopoRM vResaTopoRM = new ResaTopoRM();

        List<ResaTopo> vResaTopoList = vJdbcTemplate.query(vSql, vResaTopoRM.getvResaTopoRowMapper());
        return vResaTopoList;
    }

    public ResaTopo recoversIdResaTopoDao(ResaTopo resaTopo, Compte compte){

        String vSql = "SELECT * FROM public.resa_topo"
                + " WHERE topo_id = " + resaTopo.getTopo_id()
                + " AND compte_id = " + compte.getId()
                + " AND  date_debut = '" + resaTopo.getDate_debut() +"'"
                + " AND date_fin = '" + resaTopo.getDate_fin() +"'"
                + " AND proprietaire_topo = " + resaTopo.getProprietaire_topo();

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ResaTopoRM vResaTopoRM = new ResaTopoRM();

        List<ResaTopo> vResaTopoList = vJdbcTemplate.query(vSql, vResaTopoRM.getvResaTopoRowMapper());
        return vResaTopoList.get(0);
    }
}
