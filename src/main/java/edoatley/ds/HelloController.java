package edoatley.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    NumberGenerator numberGenerator;

    @RequestMapping(value = "/hello/{name}", produces = "application/json")
    public String sayHello(@PathVariable String name) {
        return "{\"Hello\": \""+name+"!\", \"num\": \""+ numberGenerator.generate()+ "\"}";
    }

    @RequestMapping(value = "/hello/", produces = "application/json")
    public String sayHello() {
        return "{\"Hello\": \"World!\", \"num\": \""+ numberGenerator.generate()+ "\"}";
    }
}
