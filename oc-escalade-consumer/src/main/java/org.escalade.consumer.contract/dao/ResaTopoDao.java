package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;
import java.util.List;

public interface ResaTopoDao {

        List <ResaTopo> resaTopos(Integer topo_id);

        void addResaTopo(ResaTopo resaTopo, Compte compte);

        void upResaTopoDao(ResaTopo resaTopo);

        ResaTopo resaTopo(Integer resa_topo_id);

        void delResaTopo(Integer resa_topo_id);

        List<ResaTopo> resaTopoListByTopoAccountDao(Compte compte);

        List<ResaTopo> resaTopoListByAccountDao(Compte compte);

        ResaTopo recoversIdResaTopoDao(ResaTopo resaTopo, Compte compte);
}
