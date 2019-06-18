package org.acme.quickstart;

import org.apache.camel.builder.RouteBuilder;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CamelRoute extends RouteBuilder {

    static final String MESSAGE = "I'm alive !";

    @Override
    public void configure() {
        from("timer:keep-alive")
                .id("timer")
                .setBody().constant(MESSAGE)
                .to("log:keep-alive");
    }
}
