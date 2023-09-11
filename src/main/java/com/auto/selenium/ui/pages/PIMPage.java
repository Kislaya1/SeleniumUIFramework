package com.auto.selenium.ui.pages;

import static com.auto.selenium.ui.enums.PIMPageNavOptions.*;

import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.entity.EmployeeDetails;
import com.auto.selenium.ui.pages.components.PIMPageNavComponent;
import org.openqa.selenium.By;

public class PIMPage {
  private final By FIRST_NAME = By.name("firstName");
  private final By MIDDLE_NAME = By.name("middleName");
  private final By LAST_NAME = By.name("lastName");
  private final By EMPLOYEE_ID =
      By.xpath(".//label[text()='Employee Id']/parent::div/parent::div/div/input");
  private final By IMAGE_BUTTON = By.xpath("//input[@type='file']");
  private final By SAVE_BUTTON =
      By.xpath(
          ".//*/text()[contains(normalize-space(translate(string(.), '\t\n\r\u00a0', '    ')), 'Save')]/parent::*");
  private final By SUCCESS_MSG =
      By.xpath(
          ".//*/text()[contains(normalize-space(translate(string(.), '\t\n\r\u00a0', '    ')), 'Success')]/parent::*");
  private final IDriver driver;
  private final PIMPageNavComponent pimPageNavComponent;

  public PIMPage(final IDriver driver) {
    this.driver = driver;
    this.pimPageNavComponent = new PIMPageNavComponent(driver);
  }

  public PIMPage addNewEmployee(final EmployeeDetails employeeDetails) {
    pimPageNavComponent.selectNavOptionFromPIMPage(ADD_EMPLOYEE);
    driver.findElement(FIRST_NAME).typeText(employeeDetails.getFirstName());
    driver.findElement(MIDDLE_NAME).typeText(employeeDetails.getMiddleName());
    driver.findElement(LAST_NAME).typeText(employeeDetails.getLastName());
    driver.findElement(EMPLOYEE_ID).typeText(Integer.toString(employeeDetails.getEmployeeId()));
    driver
        .findElement(IMAGE_BUTTON)
        .typeText(
            "C:\\Users\\Public\\Documents\\SeleniumUIFramework\\src\\test\\resources\\images\\Google.png");
    return this;
  }
}
