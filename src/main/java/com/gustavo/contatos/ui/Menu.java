package com.gustavo.contatos.ui;

import com.gustavo.contatos.model.Contato;
import com.gustavo.contatos.model.ContatoDAO;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {
        int n = 0;
        Scanner leitor = new Scanner(System.in);
        ContatoDAO contatoDAO = new ContatoDAO();

        while (n < 5){
            System.out.println("MENU");
            System.out.println("1-Adicionar Contato");
            System.out.println("2-Listar Contatos");
            System.out.println("3-Pesquisar Contatos");
            System.out.println("4-Excluir Contatos");
            System.out.println("5-Sair");
            n = leitor.nextInt();
            //Condição para adicionar contatos
            if (n == 1){
                Contato contato =  new Contato();
                //Nome Digitado pelo usuário
                System.out.println("Nome: ");
                leitor.nextLine(); //Quebra de linha
                String nomeDigitado = leitor.nextLine();
                contato.setNome(nomeDigitado);

                //Telefone digitado pelo usuário
                System.out.println("Telefone: ");
                String telefoneDigitado = leitor.nextLine();
                contato.setTelefone(telefoneDigitado);

                //Email digitado pelo usuário
                System.out.println("Email: ");
                String emailDigitado = leitor.nextLine();
                contato.setEmail(emailDigitado);

                try {
                    contatoDAO.adicionar(contato);
                } catch (SQLException e) {
                    System.err.println("Erro ao adicionar contato!");
                    e.printStackTrace();
                }
            //Condição para Listar Contatos
            } else if (n == 2) {
                try {
                    List<Contato> contatoMenu = contatoDAO.listarContatos();
                    if (contatoMenu.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        System.out.println("Lista de Contatos");
                        for (Contato contato : contatoMenu) {
                            System.out.println("ID: " + contato.getId());
                            System.out.println("Nome: " + contato.getNome());
                            System.out.println("Telefone: " + contato.getTelefone());
                            System.out.println("Email: " + contato.getEmail());
                            System.out.println("-----------------------------");
                        }

                    }
                }catch (SQLException e){
                    System.err.println("Erro ao listar contatos!");
                    e.printStackTrace();
                }


            } else if (n == 3) {
                System.out.println("Pesquise um contato por nome ou telefone: ");
                leitor.nextLine();
                String criterioPesquisa = leitor.nextLine();

                try{
                    List<Contato> contatosFiltrados = contatoDAO.pesquisarContatos(criterioPesquisa);

                    if (contatosFiltrados.isEmpty()){
                        System.out.println("Nenhum contato encontrado!");
                    } else {
                        System.out.println("Resultados da pesquisa para: " + criterioPesquisa);
                        for (Contato contato : contatosFiltrados){
                            System.out.println("ID: " + contato.getId());
                            System.out.println("Nome: " + contato.getNome());
                            System.out.println("Telefone: " + contato.getTelefone());
                            System.out.println("Email: " + contato.getEmail());
                            System.out.println("------------------");
                        }
                    }
                } catch (SQLException e) {
                    System.err.println("Erro ao pesquisar contatos!");
                    e.printStackTrace();
                }

            }


        }
    }
}
