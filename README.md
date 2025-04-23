# Gerenciador de Contatos - Aplicação de Terminal

## Descrição do Projeto

Este é um aplicativo simples de gerenciamento de contatos desenvolvido em Java para ser executado diretamente no terminal. O objetivo principal é permitir que o usuário realize operações básicas de Cadastro, Leitura, Atualização e Exclusão (CRUD) de informações de contato de forma interativa através de um menu textual.

## Funcionalidades

O programa oferece as seguintes funcionalidades:

* **Adicionar Contato:** Permite ao usuário inserir os dados de um novo contato, como nome, sobrenome, telefone e e-mail, que serão armazenados no banco de dados.
* **Listar Contatos:** Exibe todos os contatos cadastrados no banco de dados, mostrando suas informações básicas.
* **Pesquisar Contatos:** (Funcionalidade em destaque) Permite ao usuário buscar contatos com base em um ou mais critérios (por exemplo, nome, sobrenome ou parte do telefone/e-mail), facilitando a localização de informações específicas.
* **Deletar Contatos:** Permite ao usuário remover um contato existente do banco de dados, geralmente identificando-o pelo seu ID.

## Entidades

O sistema gerencia uma única entidade principal:

### Contato

A entidade `Contato` representa uma pessoa ou organização da qual desejamos armazenar informações. Cada contato possui os seguintes atributos:

* **id (Integer - Chave Primária):** Um identificador único para cada contato no sistema. Este campo é gerado automaticamente pelo banco de dados.
* **nome (VARCHAR):** O primeiro nome do contato.
* **sobrenome (VARCHAR):** O sobrenome do contato.
* **telefone (VARCHAR):** O número de telefone do contato.
* **email (VARCHAR):** O endereço de e-mail do contato.

Estes atributos são persistidos na tabela `contatos` do banco de dados PostgreSQL.

## Pré-requisitos

* **Java Development Kit (JDK):** Certifique-se de ter o JDK instalado no seu sistema para poder compilar e executar o programa Java.
* **PostgreSQL:** Um servidor PostgreSQL deve estar instalado e em execução.
* **pgAdmin (Opcional):** Uma ferramenta de administração gráfica para PostgreSQL, útil para visualizar e gerenciar o banco de dados.
* **Driver JDBC do PostgreSQL:** A biblioteca JDBC do PostgreSQL deve estar incluída no projeto Java para permitir a comunicação com o banco de dados.

## Como Executar

1.  **Compile o código Java:** Utilize um compilador Java (como o `javac` incluído no JDK) para compilar os arquivos `.java` do projeto. Se você estiver usando uma IDE como IntelliJ IDEA, o processo de build e execução geralmente é automatizado.
2.  **Execute o programa:** Abra o terminal, navegue até a pasta onde os arquivos compilados estão localizados e execute o programa Java utilizando o comando `java <nome_da_classe_principal>`.
3.  **Interaja com o menu:** O programa exibirá um menu de opções no terminal. Digite o número correspondente à ação que você deseja realizar e siga as instruções.

## Próximos Passos

* Implementar a lógica detalhada para cada uma das funcionalidades do menu (Adicionar, Listar, Pesquisar, Deletar).
* Criar a classe `ConexaoJDBC` para estabelecer a comunicação com o banco de dados PostgreSQL.
* Implementar as classes de acesso a dados (DAOs) para realizar as operações CRUD na tabela `contatos`.
* Desenvolver a interface de menu no terminal para interação do usuário.
* Implementar a funcionalidade de pesquisa de contatos com diferentes critérios.

---

Este README fornece uma visão geral do projeto "Gerenciador de Contatos" para terminal, descrevendo suas funcionalidades, a entidade principal e os próximos passos para o desenvolvimento. Lembre-se de substituir o placeholder da imagem da tabela pela imagem real.
