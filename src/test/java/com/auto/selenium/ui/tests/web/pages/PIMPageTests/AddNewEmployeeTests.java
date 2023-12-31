package com.auto.selenium.ui.tests.web.pages.PIMPageTests;

import com.auto.selenium.ui.entity.EmployeeDetails;
import com.auto.selenium.ui.pages.LoginPage;
import com.auto.selenium.ui.testdata.EmployeeTestData;
import com.auto.selenium.ui.tests.base.WebTestSetup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

//Change Readme file...
class AddNewEmployeeTests extends WebTestSetup {
  @ParameterizedTest
  @ArgumentsSource(EmployeeTestData.class)
  void addNewEmployee(final EmployeeDetails employeeDetails) {
    LoginPage.getInstance()
        .loginToApplication()
        .navigateToPimPage()
        .addNewEmployeeWithLoginDetails(employeeDetails)
        .verifyEmployeeSuccessfullyCreated();
  }
}
