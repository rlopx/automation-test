# Automation Testing Project

Welcome to the Automation Testing Project! This repository is to learn and test automation testing using Selenium with Java, Cucumber for behavior-driven development (BDD), and API testing.

## Introduction

This project serves as a hands-on learning experience for automation testing. It includes examples of UI testing with Selenium, BDD scenarios with Cucumber, and API testing. The goal is to provide a comprehensive understanding of automation testing concepts and practices.

## Technologies Used

- **Java**: The primary programming language for writing test scripts.
- **Selenium**: A framework for automating web applications for testing purposes.
- **Cucumber**: A tool for running automated tests written in plain language.
- **TestNG**: Testing framework for running and managing tests.
- **RestAssured**: A Java library for testing RESTful APIs.
- **Maven**: A build automation tool used for managing project dependencies.

## Project Structure
/automation-testing-project
│
├── /src
│   ├── /main
│   │   └── /java
│   │       ├── /driver
│   │       │    └── (driver factory for driver & browser setup)
│   │       ├── /pages
│   │       │    └── (pages & elements to be tested)
│   │       └── /properties
│   │            └── (testing project configs)
│   └── /test
│       ├── /java
│       │   ├── /stepDefinitions
│       │   │   ├── /base
│       │   │   │   └── (Hooks)
│       │   │   └── (tests step definitions)
│       │   ├── /runners
│       │   └── /apiTests
│       └── /resources
│           └── /features
│               └── (Cucumber feature files)
│
├── pom.xml
└── README.md

## Contributing
I am not really looking for contributions, but you are welcome to send suggestions for improvements or new features, please create an issue or send a message!
