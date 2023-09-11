package com.auto.selenium.ui.element;

import com.auto.selenium.ui.config.IEnvConfig;
import java.time.Duration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCoreElement implements IWebElement {
  private final IEnvConfig config = ConfigFactory.create(IEnvConfig.class);
  private final By by;
  private WebElement webElement;
  private WebDriver webDriver;
  private WebDriverWait webDriverWait;

  public WebCoreElement(final WebDriver webDriver, final WebElement webElement, final By by) {
    this.webElement = webElement;
    this.by = by;
    this.webDriver = webDriver;
    webDriverWait =
        new WebDriverWait(webDriver, Duration.ofMillis(Integer.parseInt(config.waitTime())));
  }

  @Override
  public void typeText(final String userInput) {
    webDriverWait.until(
        ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
    webElement.clear();
    webElement.sendKeys(userInput);
  }

  @Override
  public void click() {
    webDriverWait.until(
        ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
    webElement.click();
  }

  @Override
  public boolean shouldBeDisplayed() {
    webDriverWait.until(
        ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
    return webElement.isDisplayed();
  }
}
