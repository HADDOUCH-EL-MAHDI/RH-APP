package org.sii.DemandesAdministratives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdministrativeDocumentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdministrativeDocumentApplication.class,args);
    }
}