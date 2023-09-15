package com.auto.selenium.ui.enums.pim;

public enum LoginLabels {
  USERNAME("Username"),
  PASSWORD("Password"),
  CONFIRM_PASSWORD("Confirm Password");

  private String labels;

  LoginLabels(final String labels) {
    this.labels = labels;
  }

  public String getLabels() {
    return this.labels;
  }
}
