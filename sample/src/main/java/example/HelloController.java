
package example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import service.AwsFunction;
import service.HogeService;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;

@Controller("/")
@Validated
public class HelloController {

    @Inject private HogeService service;

    @Inject private AwsFunction lambda;

    @Get("/hello{?name}")
    public Single<String> hello(@NotBlank String name) {

        return Single.just(service.greeting(name));
    }

    @Get("/func")
    public Single<Sample> callFunction() {
        return lambda.example();
    }
}
