FROM eclipse-temurin:22
COPY ./target/desafio-estagiario-vehicle-0.0.1-SNAPSHOT.jar desafio.jar
ENTRYPOINT ["java", "-jar", "desafio.jar"]