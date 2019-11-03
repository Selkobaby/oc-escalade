package org.escalade.consumer.contract.dao;

import org.escalade.model.bean.Compte;
import org.escalade.model.bean.ResaTopo;
import org.escalade.model.bean.Topo;

import java.util.List;

public interface TopoDao {

        List<Topo> topos();

        void addTopo(Topo topo, Compte compte);

        Topo topo(Integer id);

        void delTopo(Integer id);

        void upTopo(Topo topo);

        Topo recoversTopoForIdDao(Compte compte, Topo topo);

        List<Topo> topoByAccountDao(Compte compte);

        List<Topo> toposByResaTopoDao(ResaTopo resaTopo);
}
