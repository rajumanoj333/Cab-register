FROM  amazoncorretto:17.0.7-alpine
EXPOSE 8089
ADD target/Cab-register-0.0.1-SNAPSHOT.war Cab-register-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/Cab-register-0.0.1-SNAPSHOT.war" ]