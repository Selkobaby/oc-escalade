package org.escalade.consumer.contract.impl.data;

import javax.sql.DataSource;

public abstract  class AbstractDataImpl {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
