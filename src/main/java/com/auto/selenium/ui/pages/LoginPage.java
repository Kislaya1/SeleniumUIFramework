package com.auto.selenium.ui.pages;

import com.auto.selenium.ui.config.IEnvConfig;
import com.auto.selenium.ui.driver.IDriver;
import java.util.Objects;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;

public class LoginPage {
  private static LoginPage loginPage;
  private final IEnvConfig config = ConfigFactory.create(IEnvConfig.class);
  private final By USERNAME = By.name("username");
  private final By PASSWORD = By.name("password");
  private final By LOGIN_BUTTON = By.cssSelector("[type='submit']");
  private final IDriver driver;

  private LoginPage(final IDriver driver) {
    this.driver = driver;
  }

  public static synchronized LoginPage getInstance(final IDriver driver) {
    if (Objects.isNull(loginPage)) loginPage = new LoginPage(driver);
    return loginPage;
  }

  public HomePage loginToApplication() {
    driver.findElement(USERNAME).typeText(config.username());
    driver.findElement(PASSWORD).typeText(config.password());
    driver.findElement(LOGIN_BUTTON).click();
    return new HomePage(driver);
  }
}
