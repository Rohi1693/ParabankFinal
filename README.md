# ParaBank Automation Framework

## Overview
This project is an end-to-end automation framework for the ParaBank KATA. It automates both UI and API test scenarios using Java, Selenium WebDriver, Rest Assured, Cucumber (BDD), and TestNG.

## Tech Stack
- Java 17
- Selenium WebDriver
- Rest Assured
- Cucumber
- TestNG
- Maven
- GitHub Actions

## Project Structure

```
src
├── test
│   ├── java
│   │   ├── api
│   │   ├── factory
│   │   ├── pages
│   │   ├── payload
│   │   ├── runners
│   │   ├── stepDefinition
│   │   └── utils
│   └── resources
│       ├── features
│       ├── config.properties
│       └── testdata
```

## Running the Tests

Run all tests

```bash
mvn clean test
```

Run UI tests

```bash
mvn test -Dcucumber.filter.tags="@UI"
```

Run API tests

```bash
mvn test -Dcucumber.filter.tags="@API"
```

## Test Reports

After execution, the **Extent Report** is generated under:

```
test-output/
```

Open the generated HTML report in a browser to view:

- Execution summary
- Passed and failed scenarios
- Step execution details

## Reporting, Observability and CI/CD

### Reporting
- Extent Report
- Cucumber execution summary
- Scenario and step-level results

### Continuous Integration

GitHub Actions workflow:

```
.github/workflows/automation.yml
```

The workflow performs the following:

- Checkout the repository
- Set up Java 17
- Cache Maven dependencies
- Build the project
- Execute UI and API tests
- Generate the Extent Report

## Framework Highlights

- BDD using Cucumber
- Page Object Model (POM)
- Factory Pattern for WebDriver
- API and UI automation
- Externalized configuration
- Reusable utility classes
- Data-driven testing

## Author

**Rohini**
