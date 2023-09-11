package com.auto.selenium.ui.tests.base;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.BeforeAll;

public class BaseTestSetup {
  @BeforeAll
  public static void setUpClass() {
    FixtureFactoryLoader.loadTemplates("com.auto.selenium.ui.template");
  }
}
