# Gerenciador de Contatos - Aplicação de Terminal

## Descrição do Projeto

Este é um aplicativo simples de gerenciamento de contatos desenvolvido em Java para ser executado diretamente no terminal. O objetivo principal é permitir que o usuário realize operações básicas de Cadastro, Leitura, Pesquisa e Exclusão (CRUD) de informações de contato, persistindo os dados em um banco de dados PostgreSQL. A interação com o usuário é feita através de um menu textual intuitivo.

## Funcionalidades

O programa oferece as seguintes funcionalidades:

* **Adicionar Contato:** Permite ao usuário inserir o nome, telefone e e-mail de um novo contato, que são armazenados no banco de dados.
* **Listar Contatos:** Exibe todos os contatos cadastrados no banco de dados, mostrando seu ID, nome, telefone e e-mail.
* **Pesquisar Contatos:** Permite ao usuário buscar contatos no banco de dados fornecendo um critério (nome ou telefone). O sistema exibirá os contatos que corresponderem ao critério de pesquisa.
* **Deletar Contato:** Permite ao usuário remover um contato existente do banco de dados, identificando-o pelo seu ID. O sistema informa se o contato foi excluído com sucesso ou se o ID não foi encontrado.
* **Sair:** Encerra a aplicação.

## Entidades

O sistema gerencia uma única entidade principal:

### Contato

A entidade `Contato` representa uma pessoa da qual desejamos armazenar informações. Cada contato possui os seguintes atributos, que são persistidos na tabela `contato` do banco de dados PostgreSQL:

* **id (SERIAL - Chave Primária):** Um identificador único para cada contato no sistema. Este campo é gerado automaticamente pelo banco de dados.
* **nome (VARCHAR):** O nome do contato.
* **telefone (VARCHAR):** O número de telefone do contato.
* **email (VARCHAR):** O endereço de e-mail do contato.

## Pré-requisitos

* **Java Development Kit (JDK):** Certifique-se de ter o JDK instalado no seu sistema para poder compilar e executar o programa Java.
* **PostgreSQL:** Um servidor PostgreSQL deve estar instalado e em execução. As informações de conexão (URL, usuário, senha) estão configuradas na classe `com.gustavo.contatos.database.ConnectDatabase`.
* **Driver JDBC do PostgreSQL:** A biblioteca JDBC do PostgreSQL deve estar incluída no projeto Java para permitir a comunicação com o banco de dados. Geralmente, isso é gerenciado por uma ferramenta de build como Maven ou Gradle.

## Como Executar

1.  **Compile o código Java:** Utilize um compilador Java (como o `javac` incluído no JDK) para compilar os arquivos `.java` do projeto. Se você estiver usando uma IDE como IntelliJ IDEA, o processo de build e execução geralmente é automatizado.
2.  **Execute o programa:** Abra o terminal, navegue até a pasta onde os arquivos compilados estão localizados (geralmente dentro de uma pasta `out` ou `target` se você usou uma ferramenta de build) e execute o programa Java utilizando o comando:
    ```bash
    java com.gustavo.contatos.ui.Menu
    ```
    Certifique-se de que o classpath esteja configurado corretamente para incluir o driver JDBC do PostgreSQL.
3.  **Interaja com o menu:** O programa exibirá um menu de opções no terminal. Digite o número correspondente à ação que você deseja realizar e siga as instruções.

## Estrutura do Projeto

O projeto está organizado nas seguintes packages:

* **com.gustavo.contatos.database:** Contém a classe `ConnectDatabase` responsável por estabelecer a conexão com o banco de dados PostgreSQL.
* **com.gustavo.contatos.model:** Contém a classe `Contato` que representa a entidade de contato com seus atributos e métodos de acesso.
* **com.gustavo.contatos.ui:** Contém a classe `Menu` que é a interface principal do usuário no terminal, responsável por exibir o menu e interagir com o usuário.
* **com.gustavo.contatos.model:** Contém a classe `ContatoDAO` (Data Access Object) que lida com a persistência dos dados da entidade `Contato` no banco de dados.

## Próximos Passos (Sugestões de Melhorias)

* **Validação de Entrada:** Implementar validações para os dados inseridos pelo usuário (por exemplo, formato do telefone, e-mail).
* **Tratamento de Erros Mais Detalhado:** Fornecer mensagens de erro mais específicas para diferentes cenários de falha no banco de dados.
* **Atualização de Contatos:** Adicionar a funcionalidade para permitir que o usuário atualize as informações de um contato existente.
* **Interface Mais Amigável:** Considerar o uso de bibliotecas para criar uma interface de terminal mais elaborada ou, eventualmente, migrar para uma interface gráfica (GUI).
* **Testes Unitários:** Implementar testes unitários para garantir a corretude das classes e métodos.

---
