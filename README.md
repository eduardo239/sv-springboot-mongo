


### MongoDB Docker Container
Este comando inicia o MongoDB em um container Docker com autenticação habilitada, exigindo credenciais para acessar o banco de dados. Os dados são persistidos no volume local-mongo e o container reinicia automaticamente.
``sudo docker run -dp 27017:27017 -v local-mongo:/data/db --name local-mongo --restart=always mongo:latest
``

### MongoDB Docker Container with Authentication
Este comando inicia o MongoDB em um container Docker com autenticação habilitada, exigindo credenciais para acessar o banco de dados. Os dados são persistidos no volume local-mongo e o container reinicia automaticamente.
``sudo docker run -dp 27017:27017 -v local-mongo:/data/db --name local-mongo --restart=always mongo:latest --auth
``


### MongoDB Shell Commands
MongoDB Shell Commands
Estes comandos demonstram como acessar o banco de dados via shell do MongoDB, inserir um documento na coleção produtos e consultar todos os produtos cadastrados.
``use db-springboot``  
``db.produtos.insertOne({ nome: "Caneta", preco: 2.5 })``  
``db.produtos.find()``  

### API endopoints
Lista os endpoints REST disponíveis para manipulação dos produtos, permitindo operações de consulta, criação, atualização e remoção de registros via HTTP.
``GET /produtos``  
``GET /produtos/{id}``  
``POST /produtos``  
``PUT /produtos/{id}``  
``DELETE /produtos/{id}`` 

### Spring Boot Application
Este comando inicia a aplicação Spring Boot, que se conecta ao MongoDB e expõe os endpoints
REST para manipulação dos produtos. A aplicação é executada na porta 8080.
``mvn spring-boot:run``


mvn deploy -DaltDeploymentRepository=repositoryId::default::https://github.com/eduardo239/sv-springboot-mongo
