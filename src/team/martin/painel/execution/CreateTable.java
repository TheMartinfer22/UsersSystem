package team.martin.painel.execution;

import team.martin.painel.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    /*
     * Instanciando essa classe ela realizará a criação da tabela caso não existir.
     */
    public CreateTable() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement statement = connection.createStatement();
        statement.execute(
                """
                
                CREATE TABLE IF NOT EXISTS usuarios (
                    id          SERIAL PRIMARY KEY,
                    user_nick   VARCHAR(50),
                    user_pass   VARCHAR(50));
                  
                    """);
    }
}
