package com.auto.selenium.ui.element;

public interface IWebElement {
  void typeText(final String userInput);
  void click();
  boolean shouldBeDisplayed();
}
