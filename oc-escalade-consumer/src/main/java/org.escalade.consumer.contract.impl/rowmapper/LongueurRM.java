package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.Longueur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LongueurRM {

    public RowMapper<Longueur> getvLongueurRowMapper() {
        return vLongueurRowMapper;
    }

    private RowMapper<Longueur> vLongueurRowMapper = new RowMapper<Longueur>() {
        @Override
        public Longueur mapRow(ResultSet pRs, int rowNum) throws SQLException {
            Longueur vLongueur = new Longueur();
            vLongueur.setId(pRs.getInt("id"));
            vLongueur.setNum_longueur(pRs.getInt("num_longueur"));
            vLongueur.setNum_relai(pRs.getInt("num_relai"));
            vLongueur.setHauteur(pRs.getFloat("hauteur"));
            vLongueur.setCotation(pRs.getString("cotation"));
            vLongueur.setVoie_id(pRs.getInt("voie_id"));
            return vLongueur;
        }
    };
}
