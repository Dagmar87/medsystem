## MedSystem

Esse projeto Spring Boot foi desenvolvido por José Dagmar Florentino da Silva Sobrinho para o Desafio WIPRO. O projeto consiste na criação de um sistema de cadastramento e de consulta de médicos e de suas respectivas especializações, utilizando como serviços de APIs, as operações CRUD (Create, Read, Update e Delete) para funcionamento do sistema.

 As tecnologias usadas nesse projeto foram:

- Linguagem Java (Versão 8)
- Banco de Dados MySQL
- Spring Boot
- Spring Data JPA
- Maven
- Hibernate
- RESTful
- Apache Tomcat
- IDE Eclipse
- Insomnia

### Estrutura do Projeto

 O projeto do MedSystem possui a seguinte estrutura de pacotes e de classes:

- MedSystem(Projeto)

  - MedSystemApplication (Classe)
  - Controller (Pacote)
    - MedicoController (Classe)
    - EspecialidadeController (Classe)
  - Model (Pacote)
    - Medico(Classe)
    - Especialidade(Classe)
  - Repository (Pacote)
    - MedicoRepository (Classe)
    - EspecialidadeRepository (Classe)

  Esse projeto é dividido, como qualquer outro projeto SpringBoot, em 3 pacotes: Controller, Model e Repository. Nesses pacotes contém duas classes para suas respectivas operações: Medico e Especialidade.

### Banco de Dados

Para esse projeto, foram criados duas tabelas no banco de dados MySQL que foram as tabelas Medico, que é tabela primaria do projeto, e Especialidade, que é tabela secundaria que é conectada com a tabela Medico.

A tabela Medico contém os seguintes atributos:

- Id - LONG - PK (Chave Primaria da Tabela) - O numero da id do médico;
- Nome - STRING - O nome do médico;
- Datanascimento - DATE - A data de nascimento do médico;
- Ativo - BOOLEAN -  Se esse médico está ativo ou não na área;
- Especialidade - LONG - FK(Chave Estrangeira da Tabela) - A especialidade em que esse médico trabalha na área e esse campo utilizar a id da tabela Especialidade e é chave estrangeira que conectar as tabelas Medico e Especialidade.

A tabela Especialidade contém os seguintes atributos:

- Id - LONG - PK (Chave Primaria da Tabela) - O numero da id da especialidade;
- Nome - STRING - O nome da especialidade;
- Descricao - STRING - A descrição da especialidade;
- Ativo - BOOLEAN -  Se essa especialidade está ativa ou não na área;

Esses atributos dessas duas tabelas serão espelhados nos atributos das classes do pacote Model do projeto.

### Operações CRUD do Projeto

Nesse projeto foram realizado duas operações CRUD, sendo a primeira as do Medico, que é considerada a operação primaria do sistema, e as da Especialidade, que é considerada a operação secundaria e auxiliar, já que ficam guardados os dados de especialização do medico que serão vitais para a operação primaria (Medico). 

#### Medico

 As operações CRUD do Medico são divididas em 7 operações que são:

- FindAll => Essa operação irá consultar uma lista de todos médicos cadastrados.

URL deste método: http://localhost:8075/medico

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - findAll.png)

- FindById => Essa operação irá consultar um determinado medico cadastrado partir do id deste. 

URL deste método: http://localhost:8075/medico/{id}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - findById.png)

- FindByEsp => Essa operação irá consultar uma lista de médicos cadastrados partir da especialidade destes. 

URL deste método: http://localhost:8075/medico/especialidade/{especialidade}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - findByEsp.png)

- FindByAtivo => Essa operação irá consultar uma lista de médicos cadastrados que são ativos ou inativos. 

URL deste método: http://localhost:8075/medico/tipo/{ativo}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - findByAtivo.png)

- Create => Essa operação irá criar um novo cadastro de um medico. 

URL deste método: http://localhost:8075/medico

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - create.png)

- Update => Essa operação irá atualizar os dados de um medico cadastrado.

URL deste método: http://localhost:8075/medico/{id}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - update.png)

- Delete => Essa operação irá apagar os dados do medico cadastrado.

URL deste método: http://localhost:8075/medico/{id}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - delete.png)

#### Especialidade

As operações CRUD do Especialidade são divididas em 5 operações que são:

- FindAll => Essa operação irá consultar uma lista de todas especialidades cadastradas .

URL deste método: http://localhost:8075/especialidade

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Especialidade - findAll.png)

- FindById => Essa operação irá consultar uma determinada especialidade partir do id deste. 

URL deste método: http://localhost:8075/especialidade/{id}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Especialidade - findById.png)

- Create => Essa operação irá criar um novo cadastro de uma especialidade.

URL deste método: http://localhost:8075/especialidade

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Especialidade - create.png)

- Update => Essa operação irá atualizar os dados de uma especialidade cadastrada .

URL deste método: http://localhost:8075/especialidade/{id}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Especialidade - update.png)

- Delete => Essa operação irá apagar os dados da especialidade cadastrada.

URL deste método: http://localhost:8075/especialidade/{id}

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Especialidade - delete.png)

#### Resultados das Operações no MySQL

 Após realização das operações CRUD, os dados serão enviados e guardados no banco de dados MySQL nas tabelas Medico e Especialidade, como vemos nas duas imagens abaixo:

##### Medico 

![ Resultado das Operações CRUD da classe Medico no MySQL](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Medico - SQL Resultado.png)

​							 					Resultado das Operações CRUD do campo Medico no MySQL

##### Especialidade

![ Resultado das Operações CRUD da classe Especialidade no MySQL](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Extras\Desafio WIPRO\Especialidade - SQL Resultado.png)

​												Resultado das Operações CRUD do campo Especialidade no MySQL