package org.escalade.business.contract.manager;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;

import java.util.List;

public interface ResaTopoManager {

    List<ResaTopo> resaTopos(Integer topo_id);

    ResaTopo addResaTopo(ResaTopo resaTopo, Compte compte);

    void upResaTopo(ResaTopo resaTopo);

    ResaTopo resaTopo(Integer resa_topo_id);

    void delReasaTopo(Integer id);

    List<ResaTopo> resaTopoListByTopoAccount(Compte compte);

    List<ResaTopo> resaTopoListByAccount(Compte compte);
}
