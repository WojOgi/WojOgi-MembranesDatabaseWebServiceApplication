package com.mygroup.membranesdatabasewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MembranesDatabaseWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembranesDatabaseWebServiceApplication.class, args);

        //To do list:
        //Upload to GitHub and add Paweł
        //Integrate with an SQL type database - like in the Spring tutorial
        //Add error handling (adding a membrane with the same id etc.)
        //

    }

}
