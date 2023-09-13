package com.auto.selenium.ui.element;

import static org.assertj.core.api.Assertions.*;

import com.auto.selenium.ui.config.IEnvConfig;
import com.auto.selenium.ui.enums.ExecutionOptions;
import java.time.Duration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCoreElement implements IWebElement {
  private final IEnvConfig config = ConfigFactory.create(IEnvConfig.class);
  private final WebElement webElement;
  private final WebDriver webDriver;

  public WebCoreElement(final WebElement webElement, final WebDriver webDriver) {
    this.webElement = webElement;
    this.webDriver = webDriver;
  }

  @Override
  public void typeText(final ExecutionOptions executionOptions, final String userData) {
    switch (executionOptions) {
      case NORMAL:
        webElement.clear();
        webElement.sendKeys(userData);
        break;
      case USING_JS:
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("arguments[0].value='" + userData + "';", webElement);
        break;
      default:
        throw new IllegalArgumentException(
            "Execution Option" + executionOptions.name() + " is not present.");
    }
  }

  @Override
  public void click(final ExecutionOptions executionOptions) {
    waitForElementToBeClickable();
    switch (executionOptions) {
      case NORMAL:
        webElement.click();
        break;
      case USING_JS:
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webElement);
        break;
      case USING_ACTION:
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).click().build().perform();
        break;
      default:
        throw new IllegalArgumentException(
            "Execution Option" + executionOptions.name() + " is not present.");
    }
  }

  @Override
  public void uploadImage(final String filePath) {
    webElement.sendKeys(filePath);
  }

  @Override
  public void shouldBeVisible() {
    assertThat(webElement.isDisplayed()).as("WebElement is not displayed").isTrue();
  }

  private WebElement waitForElementToBeClickable() {
    WebDriverWait wait =
        new WebDriverWait(webDriver, Duration.ofMillis(Integer.parseInt(config.waitTime())));
    return wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
}
