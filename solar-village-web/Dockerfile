FROM java:8
EXPOSE 8080
ADD target/permit-1.0.jar permit-1.0.jar 
ENTRYPOINT ["java", "-jar", "permit-1.0.jar", "--context-path=electric"]

