package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.Messagerie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagerieRM {

    public RowMapper<Messagerie> getvMessagerieRowMapper() {
        return vMessagerieRowMapper;
    }

    RowMapper<Messagerie> vMessagerieRowMapper = new RowMapper<Messagerie>() {
        @Override
        public Messagerie mapRow(ResultSet pRs, int rowNum) throws SQLException {
            Messagerie vMessagerie = new Messagerie();
            vMessagerie.setId(pRs.getInt("id"));
            vMessagerie.setDate_message(pRs.getDate("date_message"));
            vMessagerie.setMessage(pRs.getString("message"));
            vMessagerie.setResa_topo_id(pRs.getInt("resa_topo_id"));
            vMessagerie.setCompte_id(pRs.getInt("compte_id"));
            return vMessagerie;
        }
    };
}
