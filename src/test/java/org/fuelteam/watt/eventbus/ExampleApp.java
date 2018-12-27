package org.fuelteam.watt.eventbus;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApp {

    public static void main(final String[] args) {
        SpringApplication app = new SpringApplication(ExampleApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
