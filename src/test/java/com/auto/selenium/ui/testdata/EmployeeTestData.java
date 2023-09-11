package com.auto.selenium.ui.testdata;

import br.com.six2six.fixturefactory.Fixture;
import com.auto.selenium.ui.entity.EmployeeDetails;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class EmployeeTestData implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    List<EmployeeDetails> validEmployeeData = Fixture.from(EmployeeDetails.class).gimme(2, "valid");
    return validEmployeeData.stream().map(Arguments::of);
  }
}
