package example;


import io.micronaut.function.client.FunctionClient;
import io.reactivex.Single;

@FunctionClient
public interface ExampleFunctionClient {

    Single<Result> example();
}
