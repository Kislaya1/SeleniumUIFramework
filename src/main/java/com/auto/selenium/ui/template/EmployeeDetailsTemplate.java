package com.auto.selenium.ui.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.auto.selenium.ui.entity.CreateLoginDetails;
import com.auto.selenium.ui.entity.EmployeeDetails;
import com.github.javafaker.Faker;

public class EmployeeDetailsTemplate implements TemplateLoader {
    @Override
    public void load() {
    Faker faker = new Faker();
    String randomPassword = faker.internet().password(8, 10, true);
    Fixture.of(EmployeeDetails.class)
        .addTemplate(
            "valid",
            new Rule() {
              {
                add("firstName", firstName());
                add("middleName", lastName());
                add("lastName", lastName());
                add("employeeId", uniqueRandom(1000, 9999));
                add("createLoginDetails", one(CreateLoginDetails.class, "valid"));
              }
            });
    Fixture.of(CreateLoginDetails.class)
        .addTemplate(
            "valid",
            new Rule() {
              {
                add("username", uniqueRandom(faker.name().username()));
                add("password", randomPassword);
                add("confirmPassword", randomPassword);
              }
            });
    }
}
