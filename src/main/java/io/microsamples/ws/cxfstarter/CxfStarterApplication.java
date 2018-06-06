package io.microsamples.ws.cxfstarter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CxfStarterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CxfStarterApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
