# getting-started-camel

Local Java 
```
mvn compile quarkus:dev
```

Local Native
```
export GRAALVM_HOME=/opt/graalvm-ce-1.0.0-rc16
mvn package -Pnative -DskipTests -Dnative-image.docker-build=true
./target/getting-started-camel-1.0-SNAPSHOT-runner
```

Local Container native
```
podman build -f Dockerfile -t quarkus-camel .
podman run -i --rm quarkus-camel
``` 

OpenShift using native binary
```
oc new-project quarkus-camel
oc new-build --binary --name=quarkus-camel -l app=quarkus-camel
oc start-build quarkus-camel --from-dir=. --follow
oc new-app quarkus-camel
```

Patch Limits

Memory

```
oc patch --type=strategic dc/quarkus-camel -p '{"spec":{"template":{"spec":{"containers":[{"name":"quarkus-camel","resources":{"limits":{"memory":"30Mi"}}}]}}}}'
```
