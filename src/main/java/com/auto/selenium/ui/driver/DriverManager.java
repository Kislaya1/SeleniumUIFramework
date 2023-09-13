package com.auto.selenium.ui.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class DriverManager {
  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  private DriverManager() {}

  public static WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  public static void setDriver(WebDriver webDriver) {
    if (Objects.nonNull(webDriver)) driverThreadLocal.set(webDriver);
  }

  public static void unload() {
    driverThreadLocal.remove();
  }
}
