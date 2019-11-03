package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.Secteur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecteurRM {

    public RowMapper<Secteur> getvSecteurRowMapper() {
        return vSecteurRowMapper;
    }

    RowMapper<Secteur> vSecteurRowMapper = new RowMapper<Secteur>() {
        @Override
        public Secteur mapRow(ResultSet pRs, int rowNum) throws SQLException {
            Secteur vSecteur = new Secteur();
            vSecteur.setId(pRs.getInt("id"));
            vSecteur.setNom(pRs.getString("nom"));
            vSecteur.setDescription(pRs.getString("description"));
            vSecteur.setSite_id(pRs.getInt("site_id"));
            return vSecteur;
        }
    };
}
