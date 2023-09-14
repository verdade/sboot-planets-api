# sboot-planets-api

Microservice responsável por cadasdrar e listar planetas.
## Requirements
1. Java 11.x.x
2. Lombok plugin - 1.x.x

## Steps to Setup
**1. Executando o docker-compose**
* Na raiz do projeto tem o docker-compose, que deve ser executado com o comando: docker-compose up -d
* será levantado uma base mysql e o phpMyadmin na URI >> http://localhost:8081/
* CREDENCIAIS PARA O PHPMYADMIN:  server=db, user=root, password=root


**2. Clone the application**
```bash
git clone >>>
```
* 

**3. Configuration to Run the App**

![img.png](src/main/resources/configuration.png)

**4. Run Application**
* Rodando pelas configurações

![img.png](src/main/resources/run.png)

* Rodando pelo terminal
```bash
gradlew bootRun -Dspring.profiles.active=local
```

**5 . Usando o recurso para filtrar os planetas**


## Running tests
O projeto contempla testes unitários que podem ser rodados utilizando o comando `gradlew test`.