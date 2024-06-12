package com.ignek.okta_int.model;

import lombok.*;

import java.util.Collection;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

  private String userId;
  private String accessToken;
  private String refreshToken;
  private long expire_at;
  private Collection<String> authorities;
}
