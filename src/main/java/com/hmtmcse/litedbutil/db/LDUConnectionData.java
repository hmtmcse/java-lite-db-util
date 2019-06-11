package com.hmtmcse.litedbutil.db;

public class LDUConnectionData {

    public String hostname = "localhost";
    public String username = "root";
    public String password = "";
    public String databaseName;


    public LDUConnectionData() {}

    public LDUConnectionData(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }



}
