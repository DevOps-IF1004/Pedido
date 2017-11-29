FROM java:8
EXPOSE 8081
VOLUME /dados
USER root
ARG JAR_FILE
ADD ${JAR_FILE} pedido.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pedido.jar"]
