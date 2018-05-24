package example;

import io.micronaut.function.FunctionBean;
import service.HogeService;

import javax.inject.Inject;
import java.util.function.Supplier;

/**
 * Lambda にデプロイする際は、
 * io.micronaut.function.aws.MicronautRequestStreamHandler をハンドラに設定すること。
 *
 * `gradlew shadowJar` でビルドした jar をデプロイする。(約8MB)
 */

@FunctionBean("example")
public class ExampleFunction implements Supplier<Result> {

    @Inject
    HogeService service;

    @Override
    public Result get() {
        Result res = new Result();
        res.message = "hello";
        res.time = service.now();

        return res;
    }
}