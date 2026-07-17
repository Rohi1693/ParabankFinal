# ParaBank Automation Framework

## Overview

This project is an end-to-end automation framework for the ParaBank KATA. It automates both UI and API scenarios using Java, Selenium WebDriver, Rest Assured, Cucumber (BDD), and TestNG.

## Tech Stack

* Java 17
* Selenium WebDriver
* Rest Assured
* Cucumber
* TestNG
* Maven
* GitHub Actions

## Project Structure

```
src/test/java
├── pages
├── stepDefinition
├── runners
├── api
├── payload
├── utils
├── factory

src/test/resources
├── features
├── config.properties
└── testdata
```

## Running the Tests

Run all tests:

```bash
mvn clean test
```

Run tests by tag:

```bash
mvn test -Dcucumber.filter.tags="@UI"
```

```bash
mvn test -Dcucumber.filter.tags="@API"
```

## Test Reports

After execution, the Extent report is generated under:

```
target/test-output.html
```

Open the HTML file in a browser to view the execution summary, passed/failed scenarios, and step details.

## Reporting, Observability and CI/CD

### Test Reports

* Cucumber HTML Report
* Execution summary
* Scenario and step-level results

### Continuous Integration

GitHub Actions is configured to:

* Checkout the repository
* Set up Java 17
* Cache Maven dependencies
* Build the project
* Execute UI and API tests
* Generate the Extent report

Workflow location:

```
.github/workflows/automation.yml
```

## Framework Highlights

* BDD using Cucumber
* Page Object Model (POM)
* Factory Pattern for WebDriver
* API and UI automation
* Externalized configuration
* Reusable utilities
* Data-driven testing

## Author

**Rohini**
