# Pedido - Microservice
### Introduction 

This is a practical academic exercise to incentive the study of DevOps and Software Architecture.

### Objectives
* Understanding motivations to break a monolith
* Using a scientific approach to detail architectural changes
* Promoting the adoption of tests during development step
* Promoting the knowledge of Deployment Pipeline
* Sharing tactics to support deployability, availability and scalability

### Steps 
1. Decompose SOA-Monolith (this repository) in **PEDIDO service** and **CLIENTE service**, and documenting the Architectural Design Decisions;
2. Write the verification of **Cliente** during recording of a new **Pedido**;
3. Write automated tests (Unit Tests);
4. Pass tests trough pipeline (https://circleci.com/ or Jenkins) using docker;
5. Deploy Services on Google Cloud or Amazon AWS;
6. Monitor the the record of new **pedidos** with Elastic Search;
7. Replicate PEDIDO service (>2 instances) and support availability of ecosystem;

### Teacher acceptance tests

* Step 1.a: The presentation of 2 repositories with the source code of microservices components;
* Step 1.b: The Technical Documentation of architectural decisions;
* Step 2: The presentation of the verification at runtime;
* Step 3: The presentation of source code of Unit Tests;
* Step 4 & 5: Execution of pipeline until deployment;
* Step 6: Show kibana monitoring the recording of new **pedidos**
* Step 7: "simulate" a **PEDIDO service** (>2 instances) problem and the automated execution of the selfhealing; 

### Running Pedido

```sh
 $ mvn clean package
 $ mvn spring-boot:run

```

### Examples 

```sh
#Adicionando um pedido
$ curl -H "Content-Type: application/json" -X POST -d '{"idPedido": 1,"idCliente": 1,"item" : {"idProduto":1,"quantidade":1}}' http://localhost:8081/pedidorest/item/adiciona

#Consultado todos os pedidos
$ curl http://localhost:8081/pedidorest/

#Efetivando pedido (mudar o status para concluido
$ curl -X PUT http://localhost:8081/pedidorest/pedido/1

```
