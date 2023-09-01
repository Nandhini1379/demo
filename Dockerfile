FROM eclipse-temurin:17
COPY target/myapp.jar myapp.jar
CMD [ "java","-jar","myapp.jar" ]