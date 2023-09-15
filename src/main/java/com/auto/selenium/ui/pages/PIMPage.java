package com.auto.selenium.ui.pages;

import static com.auto.selenium.ui.enums.ExecutionOptions.*;
import static com.auto.selenium.ui.enums.PIMPageNavOptions.*;

import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.entity.EmployeeDetails;
import com.auto.selenium.ui.pages.components.PIMPageNavComponent;
import org.openqa.selenium.By;

public class PIMPage {
  private final IDriver driver;
  private final By FIRST_NAME = By.name("firstName");
  private final By MIDDLE_NAME = By.name("middleName");
  private final By LAST_NAME = By.name("lastName");
  private final By EMPLOYEE_ID =
      By.xpath(".//label[text()='Employee Id']/parent::div/parent::div/div/input");
  private final By IMAGE_BUTTON = By.xpath("//input[@type='file']");
  private final By SAVE_BUTTON =
      By.xpath(".//p[text()='Create Login Details']/ancestor::form/div[2]/button[2]");
  private final By SUCCESS_MSG =
      By.xpath(
          ".//*/text()[contains(normalize-space(translate(string(.), '\t\n\r\u00a0', '    ')), 'Success')]/parent::*");
  private final PIMPageNavComponent pimPageNavComponent;

  public PIMPage(IDriver driver) {
    this.pimPageNavComponent = new PIMPageNavComponent(driver);
    this.driver = driver;
  }

  public PIMPage addNewEmployee(final EmployeeDetails employeeDetails) {
    pimPageNavComponent.selectNavOptionFromPIMPage(ADD_EMPLOYEE);
    driver.searchElement(FIRST_NAME).typeText(NORMAL, employeeDetails.getFirstName());
    driver.searchElement(MIDDLE_NAME).typeText(NORMAL, employeeDetails.getMiddleName());
    driver.searchElement(LAST_NAME).typeText(NORMAL, employeeDetails.getLastName());
    driver
        .searchElement(EMPLOYEE_ID)
        .typeText(NORMAL, Integer.toString(employeeDetails.getEmployeeId()));
    driver
        .searchElement(IMAGE_BUTTON)
        .uploadImage(
            "C:\\Users\\Public\\Documents\\SeleniumUIFramework\\src\\test\\resources\\images\\Google.png");
    driver.searchElement(SAVE_BUTTON).click(NORMAL);
    return this;
  }

  public void verifyEmployeeSuccessfullyCreated() throws InterruptedException {
    driver.searchElement(SUCCESS_MSG).shouldBeVisible();
  }
}
