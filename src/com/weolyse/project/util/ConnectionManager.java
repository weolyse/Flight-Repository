package com.weolyse.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    private ConnectionManager() {};

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.getValue(URL_KEY),
                    PropertiesUtil.getValue(USER_KEY),
                    PropertiesUtil.getValue(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
