package com.auto.selenium.ui.element;

import com.auto.selenium.ui.enums.ExecutionOptions;

public interface IWebElement {
  void typeText(ExecutionOptions executionOptions, String userData);

  void click(ExecutionOptions executionOptions);

  void uploadImage(String filePath);

  void shouldBeVisible();
}
