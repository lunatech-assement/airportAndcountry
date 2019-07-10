FROM java:8

ADD countries-airport-service.jar countries-airport-service.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","countries-airport-service.jar"]