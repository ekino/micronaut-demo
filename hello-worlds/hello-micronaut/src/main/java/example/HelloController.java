package example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Single;

import static io.micronaut.http.MediaType.TEXT_PLAIN;

@Controller("/hello")
public class HelloController {

    @Get
    @Produces(TEXT_PLAIN)
    public Single<String> hello() {
        return Single.just("Hello world !");
    }
}
