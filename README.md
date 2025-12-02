# Swag Labs Test Automation Framework – Selenium + TestNG (Java)

This framework is designed for scalable, maintainable, and robust UI test automation.
It is built using Java, Selenium WebDriver, TestNG, Maven, ExtentReports, Log4j, Gson, and Faker for test data creation.

It supports headless execution, data-driven testing, Maven CLI execution, and auto-generation of HTML reports & logs.


## 🚀 About Me
My name is Huzaif Ansari, and I am currently working as a QA Engineer with hands-on experience in both manual and automation testing. Over the past three years at NEC, I’ve worked on multiple projects across domains such as publishing, managing and booking. During this time, I’ve gained strong experience in test case design and execution, along with various testing techniques — including smoke testing to verify basic stability, sanity testing for focused validation, regression testing to ensure new changes don’t affect existing functionality, and exploratory testing to identify hidden or edge-case issues.

On the automation side, my framework is built using Selenium with Java, TestNG, and Maven, following the Page Object Model for clean structure and easy maintenance. 


## Authors

- [@Mohammed-Huzaif](https://github.com/Mohammed-Huzaif)
EmailAddress: 78692huzaif@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Mohammed-Huzaif)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mohammed-huzaif-ansari-73a62722a/)



## Prerequisites

Before running this framework, ensure the following software installed on your sysytem:

- **Java 21** - Make sure Java is installed.
- **Maven** - Ensure Maven is installed.

## Key Features
- **Java + Selenium WebDriver**
Core automation logic using Page Object Model (POM).

- **TestNG for Test Execution**
Supports parallel execution, groups, and test configuration using testng.xml.

- **Maven Surefire Plugin**
Allows running test suites from CLI

- **Headless Execution (Default / Configurable)**
Faster test execution using Chrome/Edge/Firefox headless mode.

- **Data-Driven Testing Using Gson**
Reads JSON test data using Gson library.

- **Fake Data Generation**
Uses Faker to generate randomized names, emails, addresses, etc.

- **Extent Reports**
Generates detailed test report

- **Logging**
Uses Log4j for detailed logs

## Technology Used
- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Gson
- Faker
- Extent Reports
- Log4j2


## Setup Instructions

Install my-project with npm

```bash
  git clone <https://github.com/Mohammed-Huzaif/Swag-Labs-Automation-Project.git>

  cd Swag-Labs-Automation-Project
```
    
**Running Tests on Chrome browser on Local Machine in Headless Mode** 

```bash
 mvn test -Dbrowser=chrome -DisHeadless=true -X
```
        
## Reports & Logs
**Extent Report**

After execution, the HTML report is generated at
./report.html. 
The report includes:

- Test case status (Pass/Fail/Skip)

- Screenshots on failure

**Log4j Logs**

All framework logs are stored under:

./logs/ directory

A new log file is created for every execution.

**Screenshots**

On test failure, screenshots are automatically captured and stored inside:

./screenshots/

These screenshots are also attached inside the Extent report.

## Integrated the project with github actions
This automation framework i integrated with github actions.
The tests will br exectued at 11:30 PM IST every single day.

The reports will be archived on gh-pages branch
You can view the html reports at :
https://mohammed-huzaif.github.io/Swag-Labs-Automation-Project/report.html
