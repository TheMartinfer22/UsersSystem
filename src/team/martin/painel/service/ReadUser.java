package team.martin.painel.service;

import team.martin.painel.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadUser {
    /*
     * Realiza a leitura de um usuário por meio da função search com int ou String
     * Que estão com sobrecarga.
     */
    public void search(int id) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM usuarios where id=" + id);
            getResult(statement);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao conectar no banco de dados.");
            e.printStackTrace();
        }
    }

    public void search(String user_nick) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(" SELECT * FROM usuarios where user_nick= '" + user_nick + "'");
            getResult(statement);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao conectar no banco de dados.");
            e.printStackTrace();
        }
    }

    private void getResult(Statement statement) throws SQLException {
        ResultSet resultSet = statement.getResultSet();
        System.out.println("------------");
        while (resultSet.next()){
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("USER: " + resultSet.getString("user_nick"));
            System.out.println("PASS: " + resultSet.getString("user_pass"));
            System.out.println("------------");
        }
    }
}
