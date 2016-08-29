package be.cegeka.vconsult.consult.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@EnableWebMvc
public class CustomApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CustomApp.class).run(args);
    }
}
