package org.escalade.business.impl;

import org.escalade.consumer.contract.DaoFactory;

public abstract class AbstractManagerImpl {

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
