FROM java:8
EXPOSE 8081
USER root
ADD /target/Pedido.jar Pedido.jar
ENTRYPOINT ["java", "-jar", "Pedido.jar"]
