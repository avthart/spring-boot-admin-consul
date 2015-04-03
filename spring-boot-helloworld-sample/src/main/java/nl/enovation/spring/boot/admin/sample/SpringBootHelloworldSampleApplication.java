package nl.enovation.spring.boot.admin.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootHelloworldSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloworldSampleApplication.class, args);
    }
    
    @RequestMapping("/hello")
    public String hello() {
    	return "World";
    }
}
