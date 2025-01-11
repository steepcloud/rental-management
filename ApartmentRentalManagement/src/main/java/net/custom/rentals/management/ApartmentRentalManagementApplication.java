package net.custom.rentals.management;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApartmentRentalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApartmentRentalManagementApplication.class, args);
    }
    
    /**
    @Bean
    public CommandLineRunner run() {
        return args -> {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String rawPassword = "";
            String encodedPassword = passwordEncoder.encode(rawPassword);
            System.out.println("Encrypted password: " + encodedPassword);
        };
    }
    **/
}

@RestController
class HelloController {

    @GetMapping("/ApartmentRentalManagement/")
    public String helloWorld() {
        return "Hello World!";
    }
}
