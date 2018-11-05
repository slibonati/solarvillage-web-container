
java -jar target/permit-0.0.1-SNAPSHOT.jar --context-path=electric --server.port=9090

java -jar target/permit-0.0.1-SNAPSHOT.jar --context-path=structural --server.port=9091




curl -d '{"firstName":"Steve","lastName":"Libonati","email":"steve.libonati@redhat.com","projectDescription":"new solar installation 1100 Princeton Drive Indian Land SC 29707"}' -H "Content-Type: application/json" -X POST http://localhost:9090/electric/permits