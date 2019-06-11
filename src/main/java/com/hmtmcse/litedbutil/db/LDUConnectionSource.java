package com.hmtmcse.litedbutil.db;

import com.hmtmcse.litedbutil.common.LDUException;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class LDUConnectionSource {

    public static final String H2_MEM = "H2_MEM";
    public static final String H2_FILE= "H2_FILE";
    public static final String SQ_LITE = "SQ_LITE";
    public static final String SQ_LITE_MEMORY = "SQ_LITE_MEMORY";

    private String getDatabaseURL(LDUConnectionData lduConnectionData, String type){
        switch (type){
            case H2_MEM:
                return "jdbc:h2:mem:" + lduConnectionData.databaseName;
            case H2_FILE:

                return "jdbc:h2:" + lduConnectionData.databaseName;
            case SQ_LITE:
                return "jdbc:sqlite:" + lduConnectionData.databaseName;
            case SQ_LITE_MEMORY:
                return "jdbc:sqlite::memory";
        }
        return null;
    }


    public ConnectionSource getConnectionSource(LDUConnectionData lduConnectionData, String type) throws LDUException {
        String databaseUrl = getDatabaseURL(lduConnectionData, type);
        try {
            if (databaseUrl == null){
                throw new LDUException("Database URL should not be null");
            }
            return new JdbcConnectionSource(databaseUrl);
        } catch (SQLException e) {
            throw new LDUException(e.getMessage());
        }
    }

    public static ConnectionSource connection(LDUConnectionData lduConnectionData, String type) throws LDUException {
        return new LDUConnectionSource().getConnectionSource(lduConnectionData, type);
    }

    public static ConnectionSource connection(String databaseName, String type) throws LDUException {
        return new LDUConnectionSource().getConnectionSource(new LDUConnectionData(databaseName), type);
    }

}
