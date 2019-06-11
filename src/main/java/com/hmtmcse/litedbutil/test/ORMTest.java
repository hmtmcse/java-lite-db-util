package com.hmtmcse.litedbutil.test;

import com.hmtmcse.litedbutil.common.LDUException;
import com.hmtmcse.litedbutil.db.LDUConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;

public class ORMTest {


    public static void saveAndQuery(String dbType){
        try {
            ConnectionSource connectionSource = LDUConnectionSource.connection("test-db-" + dbType.toLowerCase(), dbType);
            Dao<Account,String> accountDao = DaoManager.createDao(connectionSource, Account.class);
            TableUtils.createTable(connectionSource, Account.class);

            String name = "Touhid Mia";
            Account account = new Account(name, "_secret");
            accountDao.create(account);

            Account account2 = accountDao.queryForId(name);
            System.out.println("Account: " + account2.getPassword());
            connectionSource.close();


        } catch (SQLException | LDUException | IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        saveAndQuery(LDUConnectionSource.H2_FILE);
        saveAndQuery(LDUConnectionSource.H2_MEM);
        saveAndQuery(LDUConnectionSource.SQ_LITE_MEMORY);
        saveAndQuery(LDUConnectionSource.SQ_LITE);
    }
}
