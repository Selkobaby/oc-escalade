package org.escalade.business.contract.manager;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.Topo;

import java.util.List;

public interface TopoManager {

    List<Topo> topos();

    void addTopo(Topo topo, Compte compte);

    Topo topo(Integer topo_id);

    void delTopo(Integer id);

    void upTopo(Topo topo);

    Topo recoversTopoForId(Compte compte, Topo topo);

    List<Topo> topoByAccount(Compte compte);

}
