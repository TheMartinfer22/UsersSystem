package team.martin.painel.service;

import team.martin.painel.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser {
    /*
     * Deleta um usuário pela função delete que recebe um int.
     */
    public void delete(int id){
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE from usuarios where id=" + id);
            System.out.println("Usuário deletado com sucesso");

        } catch (SQLException e){
            System.out.println("Ocorreu um erro ao conectar no banco de dados.");
            e.printStackTrace();
        }
    }
}
