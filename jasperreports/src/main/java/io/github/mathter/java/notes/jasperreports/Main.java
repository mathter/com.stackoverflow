package io.github.mathter.java.notes.jasperreports;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
