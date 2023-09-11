package com.auto.selenium.ui.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.auto.selenium.ui.entity.EmployeeDetails;

public class EmployeeDetailsTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(EmployeeDetails.class).addTemplate("valid", new Rule() {{
            add("firstName", firstName());
            add("middleName", lastName());
            add("lastName", lastName());
            add("employeeId", uniqueRandom(1000, 9999));
        }});
    }
}
