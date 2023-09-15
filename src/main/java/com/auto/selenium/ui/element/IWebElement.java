package com.auto.selenium.ui.element;

import com.auto.selenium.ui.enums.common.ExecutionOptions;

public interface IWebElement {
  void typeText(String userData);

  void click(ExecutionOptions executionOptions);

  void uploadImage(String fileName);

  void shouldBeVisible();
}
