package com.ignek.oauth_int.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type O auth controller.
 */
@RestController
@RequestMapping("api/v1/demo")
public class OAuthController {

  /**
   * Test response entity.
   *
   * @return the response entity
   */
  @GetMapping
  public ResponseEntity<String> test(){
    return ResponseEntity.ok("Hello from secure endpoint");
  }
}
