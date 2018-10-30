package example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(produces = TEXT_PLAIN_VALUE)
    public String hello() {
        return "Hello world !";
    }

}
