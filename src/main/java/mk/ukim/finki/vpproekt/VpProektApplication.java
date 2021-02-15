package mk.ukim.finki.vpproekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class VpProektApplication {

    public static void main(String[] args) {
        SpringApplication.run(VpProektApplication.class, args);
    }

}
