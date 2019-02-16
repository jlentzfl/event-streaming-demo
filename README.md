# Pre-requisites
* [Docker Desktop for Mac/Windows](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/)
* A [mailtrap](https://mailtrap.io) account for sending mail (or your own SMTP server)
* Download the JDBC and File app starters

```
curl -O http://repo.spring.io/milestone/org/springframework/cloud/stream/app/jdbc-source-kafka/2.1.0.RC1/jdbc-source-kafka-2.1.0.RC1.jar
curl -O http://repo.spring.io/milestone/org/springframework/cloud/stream/app/file-sink-kafka/2.1.0.RC1/file-sink-kafka-2.1.0.RC1.jar
```

# Starting Up

Startup at the end first so that your consumers are consuming before messages arrive

1.  Start Kafka and Postgres DB - in the root project folder is a docker-compose.yml run
    ```
    $ docker-compose up -d
    ```
2.  Start the file sink 
    ```
    java -jar file-sink-kafka-2.1.0.RC1.jar \
    --server.port=0 \
    --spring.cloud.stream.bindings.input.destination=order_customers \
    --file.mode=APPEND \
    --file.directory=output \
    --file.name=communications.log 
    ```

3.  Start the cloudstream dg.demo.cloudstream.Application with these extra program arguments `--spring.mail.username=<mailtrap user> --spring.mail.password=<mailtrap password>`

    If you are using a different mail server edit the application.yml to set settings accordingly.

4.  Start the JDBC source
    ```
    java -jar jdbc-source-kafka-2.1.0.RC1.jar \
    --server.port=0 \
    --spring.cloud.stream.bindings.output.destination=order_customers \
    --jdbc.query="select o.order_number,o.customer_email,sa.first_name,last_name,sa.street,sa.city,sa.state,sa.zip from orders o inner join shipping_address sa on o.shipping_address_shipping_address_id = sa.shipping_address_id where o.processed=false" \
    --jdbc.update="update orders set processed=true where order_number in (:order_number)" \
    --spring.datasource.url=jdbc:postgresql://localhost/postgres \
    --spring.datasource.username=postgres \
    --spring.datasource.password=mypassword
    ```
5.  Start the ordersimulator dg.demo.ordersimulator.Application with the extra program argument `--server.port=0` so it runs on a different port than the demo application


