package com.gustavo.contatos.ui;

import com.gustavo.contatos.model.Contato;
import com.gustavo.contatos.model.ContatoDAO;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {
        int n = 0;
        Scanner leitor = new Scanner(System.in);
        Contato contato =  new Contato();
        ContatoDAO contatoDAO = new ContatoDAO();

        while (n < 5){
            System.out.println("MENU");
            System.out.println("1-Adicionar Contato");
            System.out.println("2-Listar Contatos");
            System.out.println("3-Pesquisar Contatos");
            System.out.println("4-Excluir Contatos");
            System.out.println("5-Sair");
            n = leitor.nextInt();
            if (n == 1){
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

            }




        }
    }
}
