# <span style="font-family: Calibri; font-size: 2.8em;"> Auto Selenium UI Framework </span>

## <span style="font-family: Calibri; font-size: 2.8em;"> Introduction </span>

Hi All, I created this UI Framework in order to automate Web Applications.

## <span style="font-family: Calibri; font-size: 2.8em;"> Application Under Test </span>

[Orange HRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) - Dummy UI Application for UI Testing

## <span style="font-family: Calibri; font-size: 2.8em;"> Pre-Requisite </span>

1. Java 11 - as the language of choice for writing this test framework.
2. Maven 3.8.2 - for project dependency management.
3. Any of your favorite IDEs (I prefer IntelliJ, but code is independent of any IDEs)

## <span style="font-family: Calibri; font-size: 2.8em;"> Core Features </span>

- [x] Can Automate UI, irrespective of any Application under Test.
  Had implemented this by Encapsulating Driver and WebElement features
  under [IDriver](https://github.com/Kislaya1/SeleniumUIFramework/blob/master/src/main/java/com/auto/selenium/ui/driver/IDriver.java)
  and [IWebElement](https://github.com/Kislaya1/SeleniumUIFramework/blob/master/src/main/java/com/auto/selenium/ui/element/IWebElement.java)
  interfaces.
  Moreover,
  user can implement Logging for Driver and WebElement feature
  using [Decorator Pattern](https://www.baeldung.com/java-decorator-pattern) using the above-mentioned Interfaces.
- [x] Use [Thread Local](https://www.baeldung.com/java-threadlocal) for WebDriver so that while running automation in parallel, each Thread can use different driver instances.
- [x] Users can provide a Browser Name to be used for executing test cases under [env.properties](https://github.com/Kislaya1/SeleniumUIFramework/blob/master/src/test/resources/env.properties) file.
By default, browser used is Chrome. But user can change the value at runtime to any other. 
If no value is specified, then by default browser is Chrome, but in case you need to override the value, please use as
  <b>browser=firefox</b> under env.properties.
- [x] Use [Selenium](https://www.selenium.dev/) in order to automate browser.
- [x] Use [Junit5 Reporting](https://howtodoinjava.com/junit5/junit-html-report/).
- [x] Use [PODAM](http://mtedone.github.io/podam/) library to autofill Java POJOs with random fake data.
- [x] Use [Fixture Factory Library](https://github.com/six2six/fixture-factory) in order to build and organize fake
  objects for tests using template format. For further understanding check out
  the [EmployeeDetailsTemplate](https://github.com/Kislaya1/AutoSelenideUIFramework/blob/master/src/main/java/com/auto/selenide/ui/templates/EmployeeDetailsTemplate.java)
  file inside the project.
- [x] Use [Owner Library](https://matteobaccan.github.io/owner/) in order to fetch properties file data using a simple
  Annotation-Based Approach. The user is not required to code for loading, converting, and managing of properties files.
- [x] Use [Junit 5](https://reflectoring.io/tutorial-junit5-parameterized-tests/) in order to Parameterize the Tests.
- [x] Use Parallel Execution for which configuration is available under junit-platform.properties.:

## <span style="font-family: Calibri; font-size: 2.8em;"> Challenges Faced </span>

- [x] Encapsulated Driver Related Functionalities (like start a driver, quit a driver, findElement/s) inside [Driver Interface](https://github.com/Kislaya1/SeleniumUIFramework/blob/master/src/main/java/com/auto/selenium/ui/driver/IDriver.java) to hide complexities from different other modules like Page Layers.
- [x] Encapsulated WebElement Functionalities (like sendKeys, click an element, upload Images etc.) inside [WebElement Interface](https://github.com/Kislaya1/SeleniumUIFramework/blob/master/src/main/java/com/auto/selenium/ui/element/IWebElement.java) to hide complexities from different other modules like Page Layers.
- [x] While searching for any element we face issues like Element is not present/ visible / enabled, in order to overcome this we use Explicit waits but it becomes too noisy to use to each and every place.
  <b>Solution</b>: Whenever a user tries to find an element under WebPage, Explicit Waits are added which are present as low-level design so that user does not need to take care of it additionally, and they can just call (driver.searchElement(By by))
- [x] While executing test cases in parallel we face issue that each thread tries to modify or use same instance of WebDriver and since WebDriver is not Thread-safe we face un-expected behaviours.
  <b>Solution</b>: Implemented [Thread Local](https://www.baeldung.com/java-threadlocal), for WebDriver so that while running automation in parallel, each Thread can use different driver instances.
- [x] Segregating Page Layers
  <b>Solution</b>: Used [Page Object Model](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html) design pattern for this.
- [x] It becomes very difficult to create and maintain POJOs.<br />
  <b>Solution</b>: Used PODAM library for same, it autofills POJOs with random fake data.
- [x] There is a lot of boilerplate code involved when trying to fetch data with a property file in Java.<br />
  <b>Solution</b>: Used Owner Library in order to fetch properties file data using a simple Annotation-Based Approach.
- [x] How to provide Parameterize test with random data into it.<br />
  <b>Solution</b>: Used Junit5 in combination with a Fixture Factory library in order to create random parameterized
  data.

## <span style="font-family: Calibri; font-size: 2.8em;"> Tools Set </span>

1. [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) - as language of choice for
   writing this test framework.
2. [Junit5](https://junit.org/junit5/) - as a testing framework for the Java programming language.
3. [Maven 3.8.2+](https://maven.apache.org/) - for project dependency management.
4. [Selenium](https://www.selenium.dev/) - in order to automate browser.

## <span style="font-family: Calibri; font-size: 2.8em;"> Steps to Execute </span>

1. Use the below maven command in order to execute test cases

```
mvn clean test -Denv=<environment> -D<environment>_username=<username> -D<environment>_password=<password>
```

Here :<br />
a) environment: It will be based
on [env.properties](https://github.com/Kislaya1/SeleniumUIFramework/blob/master/src/test/resources/env.properties)
file (currently it is either PROD / QA but user can add multiple as required)<br />
b) Username and Password: It can be fetched
from [Testing Site](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)<br />

For eg :

```
mvn clean test -Denv=prod -Dprod_username=Admin -Dprod_password=admin123
```

2. Use the below command in order to generate a Junit HTML report.

In order to generate a report, you just need to add 'site' at the end of mvn clean test command as below :

```
mvn clean test -Denv=<environment> -D<environment>_username=<username> -D<environment>_password=<password> site
```

3. Report will be generated under below directory structure, you can open the report in any browser of your choice

```
target/site/index.html
```