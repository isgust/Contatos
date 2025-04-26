package com.gustavo.contatos.model;
import java.sql.*;
import com.gustavo.contatos.database.ConnectDatabase;


public class ContatoDAO{

    public void adicionar(Contato contato) throws SQLException{
        Connection conect = ConnectDatabase.conectar();
        PreparedStatement pstmt = null;

        try{
            String sql = "INSERT INTO Contato(nome, telefone, email) VALUES (?,?,?)";
            pstmt = conect.prepareStatement(sql);
            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getEmail());
            pstmt.setString(3, contato.getTelefone());
            pstmt.executeUpdate();
            System.out.println("Contato adicionado com sucesso!");
        } finally {
            if(pstmt != null){
                pstmt.close();
            }
            if (conect != null){
                conect.close();
            }
        }
    }

}
