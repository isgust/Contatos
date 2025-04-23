package com.gustavo.contatos.database;
import java.sql.*;

public class ConnectDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/Contato";
    private static final String User = "postgres";
    private static final String Password = "123";

    //Metodo de conexão com o banco de dados
    public static Connection conectar(){
        Connection conexao = null; //Irá armazenar conexão com o banco de dados
        try{
            conexao = DriverManager.getConnection(URL, User, Password);
            System.out.println("Conexão realizada com sucesso!");
        }catch (SQLException e){
            //Tratamento de erro no conector
            System.err.println("Erro: Falha ao conectar ao banco de dados!");
            System.err.println(e.getMessage());
        }
        return conexao;
    }
}