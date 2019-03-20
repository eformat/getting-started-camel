package org.acme.quickstart;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import java.net.URI;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class GreetingResourceTest {
    @Test
    public void testRoutes() {
        RestAssured.when().get("/test/routes").then().body(containsString("timer"));
    }

    @Test
    public void testProperties() {
        RestAssured.when().get("/test/property/camel.context.name").then().body(is("getting-started-camel"));
    }

    @Test
    public void testNetty4Http() throws Exception {
        RestAssured.when().get(new URI("http://localhost:8080/hello")).then().body(is("Netty Hello World"));
    }
}
