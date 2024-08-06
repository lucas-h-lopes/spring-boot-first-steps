## Spring Boot - First Steps 👣

Nesse repositório coloquei em prática todo o aprendizado adquirido durante a seção de Spring Boot do curso de [Programação Orientada a Objetos](https://www.udemy.com/course/java-curso-completo/) em Java, ministrado pelo professor [Nélio Alves](https://www.udemy.com/course/java-curso-completo/?couponCode=ST10MT8624#instructor-1).

## Funcionalidades 🚀

O projeto inclui três rotas principais:
- **/customers**: Gerencia registros de clientes.
- **/products**: Gerencia registros de produtos.
- **/orders**: Gerencia registros de pedidos.

**Endpoints disponíveis**:
- `/products` e `/customers` possuem todas as funcionalidades de persistência de dados: `getAll`, `getById`, `insert`, `updateById`, e `deleteById`.
- `/orders` oferece apenas `getAll` e `getById`.

Foi implementado, também, o banco de dados __em memória__ para testes dos recursos previamente mencionados. A __URL__ de acesso por padrão é jdbc:h2:mem:dbtest, __usuário__ sa e __não possui senha__. Os campos podem ser encontrados e editados no arquivo ``application-test.properties``. 

## Tecnologias utilizadas 💻

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=lightblue)

## Pré-requisitos

Certifique-se que o Maven está instalado em sua máquina para rodar a aplicação por linha de comando. Caso não tenha o Maven instalado, você pode baixá-lo [aqui](https://maven.apache.org/download.cgi). Se preferir não executar por linha de comando, você pode abrir o projeto com sua IDE preferida, e então executar a classe ``SpringbootProjectApplication``.

## Instalação ⚙️

Realize os passos abaixo para rodar localmente este projeto:

1. Clone esse repositório:
``https://github.com/lucas-h-lopes/spring-boot-first-steps.git``

2. No seu terminal, acesse o caminho do projeto com:
``cd caminho_do_projeto``

3. Execute o comando:
``mvn spring-boot:run``

Ao finalizar este procedimento, a aplicação poderá ser encontrada na url padrão localhost:8080.

## Visualização do projeto 👀

Para visualizar os registros no banco de dados h2, acesse ``localhost:8080/h2-console`` e utilize as credenciais configuradas.

### Customers 🧑🏻‍🦱

#### GET

Listagem de todos os Customers:
![img.png](images/img.png)

Listagem de um Customer específico:

![img.png](images/img_1.png)

Tentando listar um Customer que não existe:

![img.png](images/img_2.png)

#### POST

Inserindo um novo Customer:

![img.png](images/img_3.png)

💡 Podemos visualizar o caminho do registro criado em **Headers**
![img](images/img_4.png)

Tentando inserir um Customer sem informar um email (também possuem validações para nome, formato do email, tamanho do nome (3 a 30 caracteres) e obrigatoriedade dos campos):

![img](images/img_5.png)

Tentando inserir um Customer com email duplicado:

![img](images/img_11.png)

#### PUT

Atualizando um registro existente:

![img](images/img_6.png)

Tentando atualizar um registro inexistente:

![img](images/img_7.png)

Tentando atualizar o email de um registro para um email já cadastrado:

![img](images/img_9.png)
 
Tentando atualizar o nome de um registro para um menor que 3 caracteres (possui as mesmas validações de inserção):

![img](images/img_10.png)

#### DELETE

Tentando excluir um registro (tratada a exceção de Violação de Dados):

![img](images/img_12.png)

Tentando excluir um registro que não existe:

![img](images/img_13.png)

### Products 🧽

#### GET

Listagem de todos os Products:

![img](images/img_14.png)

Listagem de um Product específico:

![img](images/img_15.png)

Tentando listar um Product que não existe:

![img](images/img_16.png)

#### POST

Inserindo um novo Product:

![img](images/img_17.png)

💡 Podemos visualizar o caminho do registro criado em **Headers**

![img](images/img_18.png)

Tentando inserir um Product informando um preço menor do que 1 (também possuem validações para tamanho do nome, quantidade em estoque e obrigatoriedade dos campos):

![img](images/img_19.png)

Tentando inserir um Product com nome duplicado:

![img](images/img_20.png)

#### PUT

Atualizando um registro existente:

![img](images/img_21.png)

Tentando atualizar um registro inexistente:

![img](images/img_22.png)

Tentando atualizar o nome de um registro para um nome já cadastrado:

![img](images/img_23.png)

Tentando atualizar a quantidade em estoque de um registro para um valor menor do que 0 (possui as mesmas validações de inserção):

![img](images/img_24.png)

#### DELETE

Tentando excluir um registro (tratada a exceção de Violação de Dados):

![img](images/img_25.png)

Tentando excluir um registro que não existe:

![img](images/img_26.png)

### Orders 📜

### GET

Listagem de todas as Orders:

![img](images/img_27.png)

Listagem de uma Order específica:

![img](images/img_28.png)

Tentando listar uma Order que não existe:

![img](images/img_29.png)


