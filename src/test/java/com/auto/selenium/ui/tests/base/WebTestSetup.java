package com.auto.selenium.ui.tests.base;

import com.auto.selenium.ui.config.IEnvConfig;
import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.driver.WebCoreDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebTestSetup extends BaseTestSetup {
  private final IEnvConfig config = ConfigFactory.create(IEnvConfig.class);
  protected IDriver driver;

  @BeforeEach
  void setUp() {
    driver = new WebCoreDriver();
    driver.start(config.browser());
  }

  @AfterEach
  void cleanUp() {
    driver.quit();
  }
}
