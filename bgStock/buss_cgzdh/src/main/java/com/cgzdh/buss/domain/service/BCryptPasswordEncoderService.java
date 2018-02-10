package com.cgzdh.buss.domain.service;

import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("BCryptPasswordEncoderService")
@Scope("singleton")
public class BCryptPasswordEncoderService
  implements PasswordEncoderService
{
  private PasswordEncoder encoder = null;

  public PasswordEncoder build()
  {
    this.encoder = new BCryptPasswordEncoder();
    return this.encoder;
  }

  public String encryptPassword(String password)
  {
    if (this.encoder == null) {
      build();
    }
    return this.encoder.encode(password);
  }

  public boolean matches(String oldPassWord, String password)
  {
    if (this.encoder == null) {
      build();
    }
    return this.encoder.matches(oldPassWord, password);
  }
}