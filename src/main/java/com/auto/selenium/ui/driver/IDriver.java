package com.auto.selenium.ui.driver;

import com.auto.selenium.ui.element.IWebElement;
import java.util.List;
import org.openqa.selenium.By;

public interface IDriver {
  void start(final String browser);

  IWebElement findElement(By locator);

  List<IWebElement> findElements(By locator);

  void quit();
}
