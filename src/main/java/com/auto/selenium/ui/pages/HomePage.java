package com.auto.selenium.ui.pages;

import static com.auto.selenium.ui.enums.LeftMenuOptions.PIM;

import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.pages.components.LeftMenuComponent;
import org.openqa.selenium.By;

public class HomePage {
  private final By PROFILE_ICON = By.xpath(".//img[contains(@class,'userdropdown')]");
  private final LeftMenuComponent leftMenuComponent;
  private final IDriver driver;

  public HomePage(final IDriver driver) {
    this.leftMenuComponent = new LeftMenuComponent(driver);
    this.driver = driver;
  }

  public PIMPage navigateToPimPage() {
    driver.searchElement(PROFILE_ICON).shouldBeVisible();
    leftMenuComponent.selectAMenuFromLeftMenuBar(PIM);
    return new PIMPage(driver);
  }
}
