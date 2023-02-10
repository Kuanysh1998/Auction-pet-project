package kz.auction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestOurProgram {

        @GetMapping("/hello-world")
        public String testOutput() {
            return "hello_world";
    }
}
