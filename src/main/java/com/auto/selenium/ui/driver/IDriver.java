package com.auto.selenium.ui.driver;


import com.auto.selenium.ui.element.IWebElement;
import java.util.List;
import org.openqa.selenium.By;

public interface IDriver {
  void start(final String browser);

  IWebElement searchElement(By by);

  List<IWebElement> searchElements(By by);

  void quit();
}
