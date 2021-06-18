package team.martin.painel.service;

import team.martin.painel.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUser {
    /*
     * Irá criar um usuário pelo seu construtor.
     */
    public CreateUser(String user_nick, String user_pass) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();

        statement.execute("INSERT INTO usuarios (user_nick, user_pass) VALUES ('" + user_nick + "' , '" + user_pass + "')", Statement.RETURN_GENERATED_KEYS);
        ResultSet resultKey = statement.getGeneratedKeys();

        while (resultKey.next()){
            int id = resultKey.getInt("id");
            System.out.println("Usuário criado com sucesso!");;
            System.out.println("------------");
            System.out.println( System.lineSeparator() +
                    "Identificação: " + id + System.lineSeparator() +
                    "Usuário: " + user_nick + System.lineSeparator() +
                    "Senha: " + user_pass);
            System.out.println("------------");
        }
    }
}
