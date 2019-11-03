package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoieRM {

    public RowMapper<Voie> getVoieRowMapper() {
        return voieRowMapper;
    }

    RowMapper<Voie> voieRowMapper = new RowMapper<Voie>() {
        @Override
        public Voie mapRow(ResultSet pRs, int rowNum) throws SQLException {
            Voie vVoie = new Voie();
            vVoie.setId(pRs.getInt("id"));
            vVoie.setNom(pRs.getString("nom"));
            vVoie.setDescription(pRs.getString("description"));
            vVoie.setCotation(pRs.getString("cotation"));
            vVoie.setType_voie(pRs.getString("type_voie"));
            vVoie.setHauteur(pRs.getFloat("hauteur"));
            vVoie.setSecteur_id(pRs.getInt("secteur_id"));
            return vVoie;
        }
    };
}
