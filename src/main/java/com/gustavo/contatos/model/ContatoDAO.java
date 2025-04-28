package com.gustavo.contatos.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gustavo.contatos.database.ConnectDatabase;


public class ContatoDAO{

    public void adicionar(Contato contato) throws SQLException{
        Connection conect = null;
        PreparedStatement pstmt = null;

        try{
            conect = ConnectDatabase.conectar();
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

    public List<Contato> listarContatos() throws SQLException{
        Connection conect = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Contato> contatos = new ArrayList<>();

        try {
        conect = ConnectDatabase.conectar();
        String sql = "SELECT nome, telefone, email FROM Contato";
        pstmt = conect.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()){
            Contato contato = new Contato();
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));
        }

        } finally {
            if(rs != null){
                rs.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
            if (conect != null){
                conect.close();
            }

        }
        return contatos;
    }



}
