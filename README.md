# Automation Testing Project

Welcome to the Automation Testing Project! This repository demonstrates comprehensive automation testing using *
*Selenium** with **Java**, **Cucumber** for behavior-driven development (BDD), and **API testing** with REST Assured.

## Introduction

This project serves as a hands-on learning experience for automation testing. It includes practical examples of:

- **UI Testing**: Web application automation using Selenium WebDriver
- **BDD Scenarios**: Feature-driven tests written in Gherkin language
- **API Testing**: RESTful API validation and testing
- **Test Data Management**: Externalized test data handling
- **Reporting**: Comprehensive test execution reports with ExtentReports

The goal is to provide a comprehensive understanding of automation testing concepts and best practices in a real-world
project structure.

## Technologies Used

- **Java 21**: The primary programming language for writing test scripts
- **Selenium 4.30.0**: WebDriver framework for browser automation
- **Cucumber 7.15.0**: BDD framework for behavior-driven testing
- **TestNG 7.11.0**: Testing framework for managing and running tests
- **REST Assured 5.5.6**: Java library for testing RESTful APIs
- **Maven 3.x**: Build automation and dependency management
- **ExtentReports 5.1.1**: Advanced reporting with detailed test metrics
- **WebDriverManager 6.1.1**: Automatic WebDriver binary management

## Project Structure

```
automation-test/
│
├── src/
│   ├── main/java/
│   │   ├── config/
│   │   │   └── Config.java              # Configuration management
│   │   ├── driver/
│   │   │   └── DriverFactory.java       # WebDriver factory and setup
│   │   ├── pages/
│   │   │   ├── BasePage.java            # Base page object class
│   │   │   └── ...                      # Page Object Models
│   │   ├── properties/
│   │   │   └── config.properties        # Configuration and environment variables
│   │   └── utils/
│   │       └── PageUtils.java           # Common page interaction utilities
│   │
│   └── test/java/
│       ├── stepDefinitions/
│       │   ├── base/
│       │   │   └── Hooks.java           # Setup/teardown hooks (before/after scenarios)
│       │   ├── CommonSteps.java         # Shared test steps
│       │   └── ...                      # Feature step definitions
│       ├── runners/
│       │   └── CucumberTestRunnerTest.java # Cucumber test runner
│       ├── context/
│       │   └── ScenarioContext.java     # Scenario-level data sharing
│       └── utils/
│           ├── ApiAssertions.java       # API assertion utilities
│           ├── ApiUtils.java            # REST API helper methods
│           ├── TestDataReader.java      # Test data loading and parsing
│           └── TestUtils.java           # Common test utilities
│
├── src/test/resources/
│   ├── features/
│   │   └── ...                          # Feature scenarios
│   └── testdata/
│       └── users.json                   # Test data for user scenarios
│
├── scripts/
│   └── run-tests.py                     # Interactive test runner script (see below)
│
├── pom.xml                              # Maven configuration and dependencies
└── README.md                            # This file
```

## Features Overview

### 1. **User Authentication**

- Login functionality with email/password
- User registration with validation
- Session management

### 2. **Account Management**

- View accounts and balances
- Account details and transactions
- Account settings

### 3. **Financial Operations**

- Payment processing
- Money transfers between accounts
- Transaction history

### 4. **Test Utilities**

- API testing suite (REST Assured)
- Test data management (JSON-based)
- Common assertion helpers
- Faker-generated dynamic test data

## Prerequisites

- **Java 21** or higher
- **Maven 3.9.x** or higher
- **Python 3.7+** (for running the test script)
- A modern web browser (Chrome, Firefox, Edge, or Safari)
- Git (for cloning the repository)

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/rlopx/automation-test.git
cd automation-test
```

### 2. Install Dependencies

Maven will automatically download all dependencies when you run the tests:

```bash
mvn clean install
```

### 3. Configure Test Environment

Edit `src/main/resources/properties/config.properties` to set:

- Base URL for the application
- Browser type (Chrome, Firefox, etc.)
- Implicit wait times
- API endpoints

## Running Tests

### Option 1: Interactive Python Script (Recommended)

The `scripts/run-tests.py` is designed to be **project-agnostic** and will:

- Auto-discover feature files in your project
- Find the Maven executable automatically
- Work cross-platform (Windows, Mac, Linux)

The script provides an interactive menu for running tests with various options:

**Features:**

- ✅ Run specific feature files (Login, Register, etc.)
- ✅ Run tests by tags or groups
- ✅ Run all tests at once
- ✅ Enable/disable parallel execution
- ✅ Configure thread count for parallel runs
- ✅ User-friendly menu interface

**Run script:**

```bash
python scripts/run-tests.py
```

### Option 2: Maven Command Line

**Run all tests:**

```bash
mvn clean test
```

**Run specific feature:**

```bash
mvn clean test -Dcucumber.features=src/test/resources/features/Login.feature
```

**Run by Cucumber tags:**

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

**Run with parallel execution:**

```bash
mvn clean test -Dparallel=methods -DthreadCount=4
```

## Using This Project Template

You can easily use this project structure in other automation projects by following these steps:

### 1. Copy the `scripts` folder to your project:

```bash
cp -r scripts/ /path/to/your/new/project/
```

### 2. Copy the `src` structure (or use it as a reference)

### 3. Use the Python script in your new project:

```bash
cd /path/to/your/new/project/
python scripts/run-tests.py
```

## Test Reports

After running tests, comprehensive reports are generated:

### Surefire Reports (Maven Default)

```
target/surefire-reports/
├── emailable-report.html      # Email-friendly summary
├── index.html                 # Main test report
└── TEST-*.xml                 # JUnit XML format
```

### ExtentReports (Advanced Reporting)

ExtentReports is integrated for detailed test execution tracking:

- Screenshots on failures
- Step-by-step execution logs
- Test duration metrics
- Pass/fail statistics

Reports are automatically generated after test execution.

## Contributing

I am not really looking for contributions, but you are welcome to send suggestions for improvements or new features.
Please create an issue or send a message!
