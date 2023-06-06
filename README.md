# spring-boot-micro-services
spring-boot microservices

## Spring cloud Netflix eureka server implementation - 
### Development Steps
1. Create Spring boot project as Microservice (service-registry)
2. Add @EnableEurekaServer annotation
3. Disable Eureka Server as Eureka Client
4. Launch Eureka Server (Demo)
5. Registering Department-Service Microservice as Eureka Client
6. Run department-service Eureka Client (Demo)
7. Registering Employee-Service Microservice as Eureka Client
8. Run employee-service Eureka Client (Demo)
9. Multiple Instances of Department-Service


## API Gateway
1. API Gateway provides a unified interface for a set of microservices so that clients no need to know
   about all the details of microservices internals.
2. API Gateway centralize cross-cutting concerns like security, monitoring, rate limiting etc
3. Spring Cloud provides Spring Cloud Gateway to create API Gateway

### Development Steps
1. Create Spring boot project as Microservice (api gateway)
2. Register API-Gateway as Eureka Client to Eureka Server (Service Registry)
3. Configuring API Gateway Routes and Test using Postman Client
4. Using Spring Cloud Gateway to Automatically Create Routes

## Config Server 
### Development Steps
1. Create Spring boot project as Microservice
   (config-server) ►
2. Register Config-Server as Eureka Client
3. Set up Git Location for Config Server
4. Refactor Department-Service to use Config Server
5. Refactor Employee-Service to use Config Server
6. Refresh Use case
