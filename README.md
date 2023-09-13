# <span style="font-family: Calibri; font-size: 2.8em;"> Auto Selenide UI Framework </span>

## <span style="font-family: Calibri; font-size: 2.8em;"> Introduction </span>

Hi All, I created this UI Framework in order to automate a Web Application

## <span style="font-family: Calibri; font-size: 2.8em;"> Application Under Test </span>

[Orange HRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) - Dummy UI Application for UI Testing

## <span style="font-family: Calibri; font-size: 2.8em;"> Pre-Requisite </span>

1. Java 11 - as the language of choice for writing this test framework.
2. Maven 3.8.2 - for project dependency management.
3. Any of your favorite IDEs (I prefer IntelliJ, but code is independent of any IDEs)

## <span style="font-family: Calibri; font-size: 2.8em;"> Core Features </span>

- [x] Use [Selenide](https://selenide.org/) as an automation framework.
- [x] Use [Allure Reporting](https://docs.qameta.io/allure/) in order to generate beautiful reports.
- [x] Use [PODAM](http://mtedone.github.io/podam/) library to autofill Java POJOs with random fake data.
- [x] Use [Fixture Factory Library](https://github.com/six2six/fixture-factory) in order to build and organize fake
  objects for tests using template format. For
  further understanding check out
  the [EmployeeDetailsTemplate](https://github.com/Kislaya1/AutoSelenideUIFramework/blob/master/src/main/java/com/auto/selenide/ui/templates/EmployeeDetailsTemplate.java)
  file inside the project.
- [x] Use [Owner Library](https://matteobaccan.github.io/owner/) in order to fetch properties file data using a simple
  Annotation-Based Approach. The user is not required to code for loading, converting, and managing of properties files.
- [x] Use [Junit 5](https://reflectoring.io/tutorial-junit5-parameterized-tests/) in order to Parameterize the Tests.
- [x] Use Parallel Execution for which configuration is available under junit-platform.properties.:

## <span style="font-family: Calibri; font-size: 2.8em;"> Challenges Faced </span>

- [x] Selenide had overcome most of the challenges which we face generally using Selenium.
  It is a beautiful framework created as Wrapper to Selenium. It provides various advantages over Selenium,
  some of which can be mentioned are: — a) Powerful Selectors, b) Simple Configuration, c) Fluent APIs for tests, d)
  In-build Assertions.
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
4. [Selenide](https://selenide.org/) - in order to test and validate UI application in Java.

## <span style="font-family: Calibri; font-size: 2.8em;"> Steps to Execute </span>

1. Use the below maven command in order to execute test cases

```
mvn clean test -Denv=<environment> -D<environment>_username=<username> -D<environment>_password=<password>
```

Here :<br />
a) environment: It will be based
on [env.properties](https://github.com/Kislaya1/AutoSelenideUIFramework/blob/master/src/test/resources/env.properties)
file (currently it is either PROD / QA but user can add multiple as required)<br />
b) Username and Password: It can be fetched
from [Testing Site](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)<br />

For eg :

```
mvn clean test -Denv=prod -Dprod_username=Admin -Dprod_password=admin123
```

2. Use the below command in order to generate Allure reports.

In order to generate a report, you just need to execute below command

```
mvn allure:report
```

3. In IntelliJ IDEA, you can access the report by opening below HTML file in the Web Browser.

```
target/site/allure-maven-plugin/index.html
```
