package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Messagerie;

import java.util.List;

public interface MessagerieDao {

    void addMessage(Messagerie message, Compte compte);

    List<Messagerie> messageListResaTopoDao(Integer resa_id);

}
