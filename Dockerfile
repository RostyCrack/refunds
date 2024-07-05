FROM amazoncorretto:17.0.10-al2023-headless
ADD target/hardtech-refund-service.jar hardtech-refund-service.jar

ENTRYPOINT java -jar hardtech-refund-service.jar
