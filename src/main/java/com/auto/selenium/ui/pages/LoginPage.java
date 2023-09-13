package com.auto.selenium.ui.pages;

import static com.auto.selenium.ui.enums.ExecutionOptions.NORMAL;

import com.auto.selenium.ui.config.IEnvConfig;
import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.driver.WebCoreDriver;
import java.util.Objects;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;

public class LoginPage {
  private static LoginPage loginPage;
  private final IDriver driver;
  private final IEnvConfig config = ConfigFactory.create(IEnvConfig.class);
  private final By USERNAME = By.name("username");
  private final By PASSWORD = By.name("password");
  private final By LOGIN_BUTTON = By.cssSelector("[type='submit']");

  private LoginPage() {
    driver = new WebCoreDriver();
  }

  public static synchronized LoginPage getInstance() {
    if (Objects.isNull(loginPage)) loginPage = new LoginPage();
    return loginPage;
  }

  public HomePage loginToApplication() {
    driver.searchElement(USERNAME).typeText(NORMAL, config.username());
    driver.searchElement(PASSWORD).typeText(NORMAL, config.password());
    driver.searchElement(LOGIN_BUTTON).click(NORMAL);
    return new HomePage(driver);
  }
}
