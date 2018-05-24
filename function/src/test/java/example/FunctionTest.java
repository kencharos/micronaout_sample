package example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

    @Test
    public void testExampleFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        ExampleFunctionClient client = server.getApplicationContext().getBean(ExampleFunctionClient.class);


        assertEquals(client.example().blockingGet().message, "hello");
        server.stop();
    }
}
