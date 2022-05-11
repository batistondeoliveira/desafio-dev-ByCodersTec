# Desafio programação - para vaga desenvolvedor


Como executar a aplicação
------------

**Passo 1:** Faça o clone do projeto no diretório de sua preferência. 

**Passo 2:** Vá para o terminal e digite **docker-compose up -d** em seguinta aperte a tecla enter para subir todos os containers do projeto.

**Atenção:** O nginx está programado para responder na porta 8080. Caso a porta 8080 da sua máquina esteja ocupada com outra aplicação, antes de subir os containers, favor editar o docker-compose.yml e mudar a porta do container nginx.

# Documentação da API

1. __Documentação da API:__ [http://localhost:8080/cnab-backend/docs/v3/api-docs](http://localhost:8080/cnab-backend/docs/v3/api-docs)
2. __Documentação Visual da API:__ [http://localhost:8080/cnab-backend/swagger-ui.html](http://localhost:8080/cnab-backend/swagger-ui.html)

# Como acessar o sistema

1. __FrontEnd:__ [http://localhost:8080/cnab-frontend](http://localhost:8080/cnab-frontend)
2. __BackEnd:__ [http://localhost:8080/cnab-backend](http://localhost:8080/cnab-backend)
3. __Sonarqube:__ [http://localhost:8080/sonarqube](http://localhost:8080/sonarqube). O Usuário e Senha configurados são **admin** e **bydecoderstec** respectivamente.
4. __h2-console:__ [http://localhost:8080/h2-console (Somente no profile de test)](http://localhost:8080/h2-console)
5. __Documentação API-DOCS:__ [http://localhost:8080/cnab-backend/docs/v3/api-docs](http://localhost:8080/cnab-backend/docs/v3/api-docs)
6. __Documentação Swagger-UI:__ [http://localhost:8080/cnab-backend/swagger-ui.html](http://localhost:8080/cnab-backend/swagger-ui.html)
7. __Arquivo do Postman:__ Arquivo do postman para importar e consumir a api. Basta selecionar a requisição, ir na página Body e selecionar o arquivo CNAB.txt. [O arquivo pode ser baixado aqui](https://github.com/batistondeoliveira/desafio-dev-ByCodersTec/blob/main/Cnab%20Receive.postman_collection.json)

# Como consumir a API

A api só tem um endpoint e o endereço é [http://localhost:8080/cnab-backend/cnab](http://localhost:8080/cnab-backend/cnab).
Na documentação do swagger está descrito como consumir a API e no [arquivo do postman](https://github.com/batistondeoliveira/desafio-dev-ByCodersTec/blob/main/Cnab%20Receive.postman_collection.json), você pode baixá-lo e importá-lo no postman e selecionar a requisição, ir na página Body e selecionar o arquivo CNAB.txt

# Preparando o ambiente de desenvolvimento

Para o ambiente de desenvolvimento, foram utilizadas bibliotecas do npm para configurar três hooks que são: pre-commit, commit-msg e pre-push (vide detalhes na seção ferramentas utilizadas).
Por conta disso, é interessante **instalar o node** e executar o comando **npm install** para instalar as bibliotecas. Assim, ao executar o comando git commit -m, o sistema irá validar a mensagem do commit de acordo com os padrões do **conventional commits** e também analisar a **qualidade do código** com o sonar automaticamente, evitando commits defeituosos.
No git push, o sistema irá executar todos os testes antes de dar push na branch, evitando assim subir versões com bugs.

**Contra:** Contra essa abordagem é a necessidade de instalar o node na máquina.
**Prós:** Padronização dos commits e validação da qualidade do código evitando commits defeituosos.

Ao meu ver, usando essa abordagem, ganhamos na padronização e qualidade do código. 

**PS:** Não achei nenhuma ferramenta em java que faça o mesmo, caso exista por favor, na devolutiva me de o feedback :)

**Atenção:** Caso queira fazer alterações no fonte e dar commits, é necessário que o container do sonarqube esteja no ar pois a aplicação está configurada para verificar a qualidade do código e gravar os dados no sonarqube. (Essa validação só acontecerá, caso o npm install tenha sido executado, vide seção "Preparando o ambiente de desenvolvimento" para mais detalhes).

# Ferramentas utilizadas

- **@commitlint/config-conventional, @commitlint/cli e husky:** Essas bibliotecas foram adicionadas para configurar a ação de pre-commit onde ao executar o git commit -m "mensagem", o sistema irá validar se a mensagem digitada pelo usuário está no padrão do conventional commits. Além disso, também tenho um hook para verificar a qualidade do código com o sonar. Portanto, toda vez que executar o git commit, antes de executar a ação do commit, automaticamente será validado a qualidade do código (hook pre-commit) e também validado se a mensagem do usuário (hook commit-msg) está no padrão do conventional commits. Assim, evito subir commits defeituosos para o servidor.
No git push, o sistema irá executar automaticamente, os testes do sistema (hook pre-push) evitando subir commits com bugs.

- **sonarqube:** Foi adicionado um submodulo do projeto do desafio-dev-ByCodersTec para armazenar as analises da qualidade do software para depois vocês verificarem. Para isso, após subir os containers, acesse o [sonarqube no link http:localhost:8080/sonarqube](http:localhost:8080/sonarqube). O Usuário e Senha configurados são **admin** e **bydecoderstec** respectivamente.

- **spring-boot-devtools:** Foi adicionado a biblioteca spring-boot-devtools para ter o **live reload** ao alterar os arquivos fontes. Com isso, ganhamos em **produtividade** e não precisamos ficar buildando a aplicação, baixando e subindo o container toda vez que a aplicação mudar.

***Caso queira testar o live reload dentro do container, faça uma nova "Launch Configuration" conforme descrito abaixo:***

## Nova "Lauch Configuration"
Criar uma nova "Launch Configuration" para inicializar o sistema: **Menu - Run > Run Configurations.** Crie uma nova entrada para Java Application, informando os seguintes detalhes:

**Página Main:**
```
Name: remote-cnab-file-api
Project: cnab-file-api
Main class: org.springframework.boot.devtools.RemoteSpringApplication
```

**Página Arguments:**
```
Program arguments: http://localhost:8000/cnab-backend
```

# Desafio programação - para vaga desenvolvedor

Por favor leiam este documento do começo ao fim, com muita atenção.
O intuito deste teste é avaliar seus conhecimentos técnicos em programação.
O teste consiste em parsear [este arquivo de texto(CNAB)](https://github.com/ByCodersTec/desafio-ruby-on-rails/blob/master/CNAB.txt) e salvar suas informações(transações financeiras) em uma base de dados a critério do candidato.
Este desafio deve ser feito por você em sua casa. Gaste o tempo que você quiser, porém normalmente você não deve precisar de mais do que algumas horas.

# Instruções de entrega do desafio

1. Primeiro, faça um fork deste projeto para sua conta no Github (crie uma se você não possuir).
2. Em seguida, implemente o projeto tal qual descrito abaixo, em seu clone local.
3. Por fim, envie via email o projeto ou o fork/link do projeto para seu contato Bycoders_ com cópia para rh@bycoders.com.br.

# Descrição do projeto

Você recebeu um arquivo CNAB com os dados das movimentações finanaceira de várias lojas.
Precisamos criar uma maneira para que estes dados sejam importados para um banco de dados.

Sua tarefa é criar uma interface web que aceite upload do [arquivo CNAB](https://github.com/ByCodersTec/desafio-ruby-on-rails/blob/master/CNAB.txt), normalize os dados e armazene-os em um banco de dados relacional e exiba essas informações em tela.

**Sua aplicação web DEVE:**

1. Ter uma tela (via um formulário) para fazer o upload do arquivo(pontos extras se não usar um popular CSS Framework )
2. Interpretar ("parsear") o arquivo recebido, normalizar os dados, e salvar corretamente a informação em um banco de dados relacional, **se atente as documentações** que estão logo abaixo.
3. Exibir uma lista das operações importadas por lojas, e nesta lista deve conter um totalizador do saldo em conta
4. Ser escrita na sua linguagem de programação de preferência
5. Ser simples de configurar e rodar, funcionando em ambiente compatível com Unix (Linux ou Mac OS X). Ela deve utilizar apenas linguagens e bibliotecas livres ou gratuitas.
6. Git com commits atomicos e bem descritos
7. PostgreSQL, MySQL ou SQL Server
8. Ter testes automatizados
9. Docker compose (Pontos extras se utilizar)
10. Readme file descrevendo bem o projeto e seu setup
11. Incluir informação descrevendo como consumir o endpoint da API

**Sua aplicação web não precisa:**

1. Lidar com autenticação ou autorização (pontos extras se ela fizer, mais pontos extras se a autenticação for feita via OAuth).
2. Ser escrita usando algum framework específico (mas não há nada errado em usá-los também, use o que achar melhor).
3. Documentação da api.(Será um diferencial e pontos extras se fizer)

# Documentação do CNAB

| Descrição do campo  | Inicio | Fim | Tamanho | Comentário
| ------------- | ------------- | -----| ---- | ------
| Tipo  | 1  | 1 | 1 | Tipo da transação
| Data  | 2  | 9 | 8 | Data da ocorrência
| Valor | 10 | 19 | 10 | Valor da movimentação. *Obs.* O valor encontrado no arquivo precisa ser divido por cem(valor / 100.00) para normalizá-lo.
| CPF | 20 | 30 | 11 | CPF do beneficiário
| Cartão | 31 | 42 | 12 | Cartão utilizado na transação 
| Hora  | 43 | 48 | 6 | Hora da ocorrência atendendo ao fuso de UTC-3
| Dono da loja | 49 | 62 | 14 | Nome do representante da loja
| Nome loja | 63 | 81 | 19 | Nome da loja

# Documentação sobre os tipos das transações

| Tipo | Descrição | Natureza | Sinal |
| ---- | -------- | --------- | ----- |
| 1 | Débito | Entrada | + |
| 2 | Boleto | Saída | - |
| 3 | Financiamento | Saída | - |
| 4 | Crédito | Entrada | + |
| 5 | Recebimento Empréstimo | Entrada | + |
| 6 | Vendas | Entrada | + |
| 7 | Recebimento TED | Entrada | + |
| 8 | Recebimento DOC | Entrada | + |
| 9 | Aluguel | Saída | - |

# Avaliação

Seu projeto será avaliado de acordo com os seguintes critérios.

1. Sua aplicação preenche os requerimentos básicos?
2. Você documentou a maneira de configurar o ambiente e rodar sua aplicação?
3. Você seguiu as instruções de envio do desafio?
4. Qualidade e cobertura dos testes unitários.

Adicionalmente, tentaremos verificar a sua familiarização com as bibliotecas padrões (standard libs), bem como sua experiência com programação orientada a objetos a partir da estrutura de seu projeto.

# Referência

Este desafio foi baseado neste outro desafio: https://github.com/lschallenges/data-engineering

---

Boa sorte!
