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
* Na execução do projeto já está dando uma carga no banco com 6 registros para teste via postman


**2. Clone the application**
```bash
git clone https://github.com/verdade/sboot-planets-api.git
```
* Ao startar o projeto você verá o swagger no link: http://localhost:8080/swagger-ui/
* Coloquei uma collection do postman na pasta src/main/resources/PLANETS.postman_collection.json


**3. Débitos e considerações**

* O projeto foi iniciado como contract first, então o codegen que gera as classes de apresentação através do arquivo swagger
* A integração com a api swapi, foi feita com o FeignClient
* Não tive o tempo suficiente para fazer todo coverage, mas na classe PlanetControllerTest foi meu start.  No final tive um conflito para fazer os testes com mocks ou usar a base criada.
* Faltou tratar exceção com o FeignClient
* Na inclusão do Planet, coloquei o id como obrigatório para fazer sentido em buscar o planeta correto na api swapi. Acabou que usei o Id incremental, não é o ideal. Eu usaria em outra coluna e não o Id da tabela.
* Usei o QueryDsl para fazer a busca, poderia ser um query params mas usei essa estratégia pela simplicidade.
* Na paginação faltou um pequeno ajuste no contrato.
* Na busca dos planets não tratei como 404 quando não traz registros, faltou isso.


