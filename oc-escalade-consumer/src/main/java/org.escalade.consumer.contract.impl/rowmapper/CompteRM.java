package org.escalade.consumer.contract.impl.rowmapper;

import org.escalade.model.bean.Compte;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompteRM {

    public RowMapper<Compte> getvCompteRowMapper() {
        return vCompteRowMapper;
    }

    RowMapper<Compte> vCompteRowMapper = new RowMapper<Compte>() {
        @Override
        public Compte mapRow(ResultSet pRs, int rowNum) throws SQLException {
            Compte vCompte = new Compte();
            vCompte.setId(pRs.getInt("id"));
            vCompte.setNom(pRs.getString("nom"));
            vCompte.setPrenom(pRs.getString("prenom"));
            vCompte.setMail(pRs.getString("mail"));
            vCompte.setMot_de_passe(pRs.getString("mot_de_passe"));
            return vCompte;
        }
    };
}
