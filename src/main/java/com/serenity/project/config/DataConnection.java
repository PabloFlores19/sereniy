package com.serenity.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataConnection {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String URL =  "jdbc:postgresql://localhost:5433/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "";


}
