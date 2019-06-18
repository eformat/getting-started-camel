# getting-started-camel

Local Java 
```
mvn compile quarkus:dev
```

Local Native
```
export GRAALVM_HOME=/opt/graalvm-ce-1.0.0-rc16
mvn package -Pnative -DskipTests
./target/getting-started-camel-1.0-SNAPSHOT-runner
```

Local Container native
```
podman build -f src/main/docker/Dockerfile -t quarkus-camel .
podman run -i --rm -p 8080:8080 quarkus-camel
``` 

OpenShift using native binary
```
cd src/main/docker
oc new-project quarkus-camel
oc new-build --binary --name=quarkuscamel -l app=quarkus-camel
oc start-build quarkus-camel --from-dir=. --follow
oc new-app quarkus-camel
```
