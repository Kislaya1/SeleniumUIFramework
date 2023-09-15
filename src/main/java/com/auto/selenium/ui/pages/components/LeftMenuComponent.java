package com.auto.selenium.ui.pages.components;

import static com.auto.selenium.ui.enums.common.ExecutionOptions.NORMAL;

import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.enums.pim.LeftMenuOptions;
import java.util.function.Function;
import org.openqa.selenium.By;

public class LeftMenuComponent {

  private final String menuOptions = ".//span[text()='PIM_MENU_OPTION']";
  private final IDriver driver;
  private Function<LeftMenuOptions, By> PIM_MENU =
      (leftMenuOptions) ->
          By.xpath(menuOptions.replaceAll("PIM_MENU_OPTION", leftMenuOptions.getName()));

  public LeftMenuComponent(IDriver driver) {
    this.driver = driver;
  }

  public LeftMenuComponent selectAMenuFromLeftMenuBar(final LeftMenuOptions leftMenuOptions) {
    driver.searchElement(PIM_MENU.apply(leftMenuOptions)).click(NORMAL);
    return this;
  }
}
