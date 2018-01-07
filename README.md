# ms-demos-expertus
This repository will contain a brief demonstration for the company Expertus

This project contains two microservices and based on the architecture cqrs.

I used in memory store functionnality due to the lack of a free time :).

First of all ,you have to launch the service discrovery Eureka,which is under expertus-ms-services (expertus-eureka).

Once the service discovery is up and running,you only need to register zuul as a gateway under expertus-ms-services.

Now you have the pre-required services.

Run the stack elk (elastic search ,logstash , kibana ) over dockers containers 

docker run -d -it --name es -p 9200:9200 -p 9300:9300 elasticsearch
docker run -d -it --name kibana --link es:elasticsearch -p 5601:5601 kibana
docker ps -a to fetch the container id of elastic search
docker inspect {container id of elastic search} then search for the value "IPAddress": "172.17.0.2" like mine and replace it over the next command.
docker run -d -it --name logstash -p 5000:5000 logstash -e 'input { tcp { port => 5000 codec => "json" } } output { elasticsearch { hosts => ["ip address of elastic search"] index => "micro-%{serviceName}"} }'

Once the logstash is up and running retrieve its up addresse and replace it inside the logback.xml for each micro services
e.g. : <destination>172.17.0.4:5000</destination> cause the logs are shipped to logstash and then elastic search.
you can view the logs after calling the services over kibana at http://172.17.0.3:5601 

Launch your microservices ms-account-query under ms-account in addition to the ms-customer-query (ms-customer).
Browse to http://localhost:8089/swagger-ui.html view available resources for the microservice customer.
The same as well for the microservice account http://localhost:8087/swagger-ui.html 

Still to come,once a free time comes out :
NoSql db
OAuth
Mustachifier
Docker
Jenkins
Tdd,Bdd
Swagger ui
Validator framework
Try framework
...


Here you go :)

Let me know ,if you need something.
