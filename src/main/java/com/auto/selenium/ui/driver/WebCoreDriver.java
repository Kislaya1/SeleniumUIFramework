package com.auto.selenium.ui.driver;

import static com.auto.selenium.ui.driver.DriverManager.*;

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
  @Override
  public void start(final String browser) {
    if (Objects.isNull(getDriver())) {
      switch (browser.toLowerCase()) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          setDriver(new ChromeDriver());
          break;
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          setDriver(new FirefoxDriver());
          break;
        case "edge":
          WebDriverManager.edgedriver().setup();
          setDriver(new EdgeDriver());
          break;
        default:
          throw new IllegalArgumentException("Browser " + browser.toLowerCase() + " is not valid");
      }
      getDriver().manage().window().maximize();
      getDriver().navigate().to(config.webUrl());
    }
  }

  @Override
  public IWebElement searchElement(By by) {
    waitTillElementPresentIsPresent(by);
    WebElement webElement = getDriver().findElement(by);
    return new WebCoreElement(webElement, getDriver());
  }

  @Override
  public List<IWebElement> searchElements(By by) {
    waitTillElementPresentIsPresent(by);
    List<WebElement> webElementList = getDriver().findElements(by);
    return webElementList.stream()
        .map(element -> new WebCoreElement(element, getDriver()))
        .collect(Collectors.toList());
  }

  @Override
  public void quit() {
    if (Objects.nonNull(getDriver())) {
      getDriver().quit();
      unload();
    }
  }

  private void waitTillElementPresentIsPresent(By by) {
    WebDriverWait wait =
        new WebDriverWait(getDriver(), Duration.ofMillis(Integer.parseInt(config.waitTime())));
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
  }
}
