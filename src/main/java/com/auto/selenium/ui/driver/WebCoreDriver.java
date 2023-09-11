package com.auto.selenium.ui.driver;

import com.auto.selenium.ui.config.IEnvConfig;
import com.auto.selenium.ui.element.IWebElement;
import com.auto.selenium.ui.element.WebCoreElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCoreDriver implements IDriver {
  private final IEnvConfig config = ConfigFactory.create(IEnvConfig.class);
  private WebDriverWait webDriverWait;

  public WebCoreDriver() {}

  @Override
  public void start(final String browser) {
    if (Objects.isNull(DriverManager.getDriver())) {
      switch (browser.toLowerCase()) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          DriverManager.setDriver(new ChromeDriver());
          break;
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          DriverManager.setDriver(new FirefoxDriver());
          break;
        case "edge":
          WebDriverManager.edgedriver().setup();
          DriverManager.setDriver(new EdgeDriver());
          break;
      }
    }
    webDriverWait =
        new WebDriverWait(
            DriverManager.getDriver(), Duration.ofMillis(Long.parseLong(config.waitTime())));
    DriverManager.getDriver().manage().window().maximize();
    DriverManager.getDriver().navigate().to(config.webUrl());
  }

  @Override
  public IWebElement findElement(By locator) {
    WebElement nativeWebElement =
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    return new WebCoreElement(DriverManager.getDriver(), nativeWebElement, locator);
  }

  @Override
  public List<IWebElement> findElements(By locator) {
    List<WebElement> webElementList =
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    return webElementList.stream()
        .map(
            nativeWebElement ->
                new WebCoreElement(DriverManager.getDriver(), nativeWebElement, locator))
        .collect(Collectors.toList());
  }

  @Override
  public void quit() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  }
}
