# Products CRUD prototype

To run, you need an installed Docker and free local ports 8089 and 5433.
You need to download the contents and run from project root folder:

docker-compose up

It will create 2 containers first with gradle and Java Ap and second with Postgres. 
The database is reset every time the application is started.

After that, Swagger API documentation will become available:

http://localhost:8089/swagger-ui.html#/products-controller 

Products endpoind:
http://localhost:8089/products 

for create one you need to send POST on http://localhost:8089/products/create
 
{
  "name": "first product",
  "price": 3.11
}

for read it - GET http://localhost:8089/products/{returned id} 

for update PUT  http://localhost:8089/products/1 with jSON

{
  "name": "2323",
  "price": 0.1
}

for DELETE http://localhost:8089/products/1 
