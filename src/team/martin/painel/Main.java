package team.martin.painel;

import team.martin.painel.execution.CreateTable;
import team.martin.painel.service.CreateUser;
import team.martin.painel.service.DeleteUser;
import team.martin.painel.service.ReadUser;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        new CreateTable();
        ReadUser readUser = new ReadUser();
        DeleteUser deleteUser = new DeleteUser();

        CreateUser createUser = new CreateUser("teste", "teste");

        readUser.search("teste");
        readUser.search(1);
        deleteUser.delete(1);

    }
}
