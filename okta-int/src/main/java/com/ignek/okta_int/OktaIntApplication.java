package com.ignek.okta_int;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ignek.okta_int.*"})
public class OktaIntApplication {

  public static void main(String[] args) {
    SpringApplication.run(OktaIntApplication.class, args);
  }

}
