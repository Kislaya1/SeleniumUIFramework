package com.auto.selenium.ui.pages;

import static com.auto.selenium.ui.enums.common.ExecutionOptions.*;
import static com.auto.selenium.ui.enums.common.FileLocations.EMPLOYEE_PROFILE_IMAGE;
import static com.auto.selenium.ui.enums.pim.LoginLabels.*;
import static com.auto.selenium.ui.enums.pim.PIMPageNavOptions.*;

import com.auto.selenium.ui.driver.IDriver;
import com.auto.selenium.ui.entity.EmployeeDetails;
import com.auto.selenium.ui.enums.pim.LoginLabels;
import com.auto.selenium.ui.pages.components.PIMPageNavComponent;
import java.util.function.Function;
import org.openqa.selenium.By;

public class PIMPage {
  private final IDriver driver;
  private final By FIRST_NAME = By.name("firstName");
  private final By MIDDLE_NAME = By.name("middleName");
  private final By LAST_NAME = By.name("lastName");
  private final By EMPLOYEE_ID =
      By.xpath(".//label[text()='Employee Id']/parent::div/parent::div/div/input");
  private final By IMAGE_BUTTON = By.xpath("//input[@type='file']");
  private final By CREATE_LOGIN_CHECKBOX =
      By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div");
  private final String LOGIN_FIELDS =
      ".//label[text()='LABEL_NAME']/parent::div/following-sibling::div/input";
  private final Function<LoginLabels, By> LOGIN_LABELS =
      (labels) -> By.xpath(LOGIN_FIELDS.replaceAll("LABEL_NAME", labels.getLabels()));
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
    driver.searchElement(FIRST_NAME).typeText(employeeDetails.getFirstName());
    driver.searchElement(MIDDLE_NAME).typeText(employeeDetails.getMiddleName());
    driver.searchElement(LAST_NAME).typeText(employeeDetails.getLastName());
    driver.searchElement(EMPLOYEE_ID).typeText(Integer.toString(employeeDetails.getEmployeeId()));
    driver.searchElement(IMAGE_BUTTON).uploadImage(EMPLOYEE_PROFILE_IMAGE.getLocation());
    driver.searchElement(CREATE_LOGIN_CHECKBOX).click(NORMAL);
    driver
        .searchElement(LOGIN_LABELS.apply(USERNAME))
        .typeText(employeeDetails.getCreateLoginDetails().getUsername());
    driver
        .searchElement(LOGIN_LABELS.apply(PASSWORD))
        .typeText(employeeDetails.getCreateLoginDetails().getPassword());
    driver
        .searchElement(LOGIN_LABELS.apply(CONFIRM_PASSWORD))
        .typeText(employeeDetails.getCreateLoginDetails().getConfirmPassword());
    driver.searchElement(SAVE_BUTTON).click(NORMAL);
    return this;
  }

  public void verifyEmployeeSuccessfullyCreated() {
    driver.searchElement(SUCCESS_MSG).shouldBeVisible();
  }
}
