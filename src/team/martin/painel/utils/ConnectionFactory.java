package team.martin.painel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    /*
     * Classe responsável por criar uma nova conexão.
     */
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASS = "";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
