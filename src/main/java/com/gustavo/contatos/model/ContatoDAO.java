package com.gustavo.contatos.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gustavo.contatos.database.ConnectDatabase;


public class ContatoDAO{
    //Metodo para adicionar Contatos
    public void adicionar(Contato contato) throws SQLException{
        Connection conect = null;
        PreparedStatement pstmt = null;

        try{
            conect = ConnectDatabase.conectar();
            String sql = "INSERT INTO Contato(id, nome, telefone, email) VALUES (?,?,?,?)";
            pstmt = conect.prepareStatement(sql);
            pstmt.setInt(1, contato.getId());
            pstmt.setString(2, contato.getNome());
            pstmt.setString(3, contato.getEmail());
            pstmt.setString(4, contato.getTelefone());
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

    //Metodo para Listar contatos
    public List<Contato> listarContatos() throws SQLException{
        Connection conect = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Contato> contatos = new ArrayList<>();

        try {
        conect = ConnectDatabase.conectar();
        String sql = "SELECT id, nome, telefone, email FROM Contato";
        pstmt = conect.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()){
            Contato contato = new Contato();
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));
            contatos.add(contato); // Adiciona os contatos a Lista
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
        return contatos; //Retorna a Lista
    }

    //Metodo para Pesquisar Contatos(Usando o metodo Listar contatos como base)
    public List<Contato> pesquisarContatos(String criterio) throws SQLException{
        List<Contato> todosContatos = listarContatos(); //Chama o metodo com a lista de contatos
        List<Contato> filtrados = new ArrayList<>();

        for (Contato contato: todosContatos){
            if (contato.getNome().toLowerCase().contains(criterio.toLowerCase()) || contato.getTelefone().toLowerCase().contains(criterio.toLowerCase())){
                filtrados.add(contato);
            }
        }
        return filtrados;
    }

    //Metodo de Deletar contatos
    public void deletar(int enterId) throws SQLException{
        Connection conect = null;
        PreparedStatement pstmt = null;
        try{
            conect = ConnectDatabase.conectar();
            String sql = "DELETE FROM Contato WHERE id = ?";
            pstmt = conect.prepareStatement(sql);
            pstmt.setInt(1, enterId);
            pstmt.executeUpdate();
            System.out.println("Contato Excluido com sucesso!");


        }finally {
            if (conect != null){
                conect.close();
            }
            if (pstmt != null){
                pstmt.close();
            }

        }

    }

}
