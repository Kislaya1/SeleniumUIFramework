package com.auto.selenium.ui.pages.components;

import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.enums.PIMPageNavOptions;
import java.util.function.Function;
import org.openqa.selenium.By;

public class PIMPageNavComponent {
  private final String navLinkOptions = ".//a[text()='NAV_OPTION']";
  private final IDriver driver;
  private Function<PIMPageNavOptions, By> PIM_NAV_OPTION =
      (pimPageNav) -> By.xpath(navLinkOptions.replaceAll("NAV_OPTION", pimPageNav.getOptions()));

  public PIMPageNavComponent(IDriver driver) {
    this.driver = driver;
  }

  public PIMPageNavComponent selectNavOptionFromPIMPage(final PIMPageNavOptions pimPageNavOptions) {
    driver.findElement(PIM_NAV_OPTION.apply(pimPageNavOptions)).click();
    return this;
  }
}
