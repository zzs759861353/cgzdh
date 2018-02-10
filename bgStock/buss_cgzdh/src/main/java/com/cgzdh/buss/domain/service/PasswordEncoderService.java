package com.cgzdh.buss.domain.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public abstract interface PasswordEncoderService
{
  public abstract PasswordEncoder build();

  public abstract String encryptPassword(String paramString);

  public abstract boolean matches(String paramString1, String paramString2);
}