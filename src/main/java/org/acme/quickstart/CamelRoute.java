package org.acme.quickstart;

import org.apache.camel.builder.RouteBuilder;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:keep-alive")
                .id("timer")
                .setBody().constant("I'm alive !")
                .to("log:keep-alive");

        from("netty4-http:http://0.0.0.0:8080/hello")
                .transform().constant("Netty Hello World");
    }
}
