package com.ignek.okta_int.controller;


import com.ignek.okta_int.model.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@Slf4j
public class OAuthController {


  /**
   * Login response entity.
   *
   * @param client the client
   * @param user   the user
   * @param model  the model
   * @return the response entity
   */
  @GetMapping("/login")
  public ResponseEntity<AuthResponse> login(
      @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
      @AuthenticationPrincipal OidcUser user, Model model) {
    log.info("User's email id is: {}", user.getEmail());
    AuthResponse authResponse = new AuthResponse();
    authResponse.setUserId(user.getEmail());
    authResponse.setAccessToken(client.getAccessToken().getTokenValue());
    authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
    authResponse.setExpire_at(client.getAccessToken().getExpiresAt().getEpochSecond());

    List<String> authorities = user.getAuthorities().stream().map(grantedAuthority -> {
      return grantedAuthority.getAuthority();
    }).collect(Collectors.toList());

    authResponse.setAuthorities(authorities);
    return new ResponseEntity<>(authResponse, HttpStatus.OK);
  }

}
