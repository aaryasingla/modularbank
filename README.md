# modularbank

modularbank (Software engineer test assignment)

## Getting Started

Import in IDE as maven project.

### Prerequisites

What things you need to install the software and how to install them

```
* JDK 11
* STS
* Postgres 13.2
* Maven 3.5
* RabbitMQ 3.8
```
## SQL Script :
```
CREATE SEQUENCE id_sequence
  start 1000
  increment 1;

CREATE TABLE account (
   id integer primary key  default  nextval('id_sequence'::regclass),
   accountNumber VARCHAR ( 12 ) NOT null unique,
   balance numeric(19, 2) NOT NULL,
   currency smallint NOT NULL,
   country  VARCHAR ( 50 ) NOT NULL,
   customerId VARCHAR ( 12 ) NOT null,
   createdDate timestamp with time zone NOT NULL DEFAULT timezone('UTC'::text, now()),
   constraint balance check (balance >= 0)
);

CREATE TABLE transaction (
   id integer primary key  default  nextval('id_sequence'::regclass),
   accountNumber VARCHAR ( 12 ) NOT NULL,
   amount  numeric(19, 2) NOT NULL,
   curr_balance numeric(19, 2) NOT null,
   currency smallint NOT NULL,
   description text ,
   direction  VARCHAR ( 50 ) NOT NULL,
   createdDate timestamp with time zone NOT NULL DEFAULT timezone('UTC'::text, now()),
   constraint amount check (amount >= 0)

);
ALTER TABLE transaction ADD FOREIGN KEY (accountNumber)
REFERENCES account(accountNumber) ON DELETE CASCADE;
```

Ports:
```
tomcat : 8080
RabbitMQ : 5672

```
## Important links:

POST: http://localhost:8080/account/create

![image](https://user-images.githubusercontent.com/43113212/114313246-65d3df00-9b13-11eb-8601-eb149cdd24ec.png)

GET: http://localhost:8080/account/{accountId}

![image](https://user-images.githubusercontent.com/43113212/114313280-9451ba00-9b13-11eb-9e01-b694179b4e28.png)


POST: http://localhost:8080/account/transaction

Request:        
![image](https://user-images.githubusercontent.com/43113212/114313313-b51a0f80-9b13-11eb-9a2d-bca32b902107.png)

Response:
![image](https://user-images.githubusercontent.com/43113212/114313342-c8c57600-9b13-11eb-8f06-373f40c5e316.png)


## Code Snippet:

![image](https://user-images.githubusercontent.com/43113212/114314174-3a52f380-9b17-11eb-8929-2a5200001ebc.png)

![image](https://user-images.githubusercontent.com/43113212/114313794-a46a9900-9b15-11eb-85eb-0d5daeaaf425.png)

![image](https://user-images.githubusercontent.com/43113212/114313824-c95f0c00-9b15-11eb-8bc8-e70f734a81f9.png)

![image](https://user-images.githubusercontent.com/43113212/114314048-c7497d00-9b16-11eb-9071-417f0947c034.png)

![image](https://user-images.githubusercontent.com/43113212/114313911-2bb80c80-9b16-11eb-8b5c-726f96618df3.png)

![image](https://user-images.githubusercontent.com/43113212/114313930-3d011900-9b16-11eb-958a-3ba18398228a.png)

