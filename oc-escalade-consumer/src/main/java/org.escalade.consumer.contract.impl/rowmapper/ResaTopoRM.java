package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.ResaTopo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResaTopoRM {

    public RowMapper<ResaTopo> getvResaTopoRowMapper() {
        return vResaTopoRowMapper;
    }

    private RowMapper<ResaTopo> vResaTopoRowMapper = new RowMapper<ResaTopo>() {
        @Override
        public ResaTopo mapRow(ResultSet pRs, int rowNum) throws SQLException {
           ResaTopo vResaTopo = new ResaTopo();
           vResaTopo.setId(pRs.getInt("id"));
           vResaTopo.setStatut(pRs.getString("statut"));
           vResaTopo.setDate_debut(pRs.getDate("date_debut"));
           vResaTopo.setDate_fin(pRs.getDate("date_fin"));
           vResaTopo.setProprietaire_topo(pRs.getInt("proprietaire_topo"));
           vResaTopo.setCompte_id(pRs.getInt("compte_id"));
           vResaTopo.setTopo_id(pRs.getInt("topo_id"));
           return vResaTopo;
        }
    };

}
