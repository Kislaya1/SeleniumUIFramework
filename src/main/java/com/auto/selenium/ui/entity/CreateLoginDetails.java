package com.auto.selenium.ui.entity;

import lombok.Data;

@Data
public class CreateLoginDetails {
  private String username;
  private String password;
  private String confirmPassword;
}
