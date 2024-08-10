### API Testing Framework with Rest Assured

## Overview
This project is an automated API testing framework built with the following key components:

1. BDD (Behavior Driven Development) with Cucumber: For writing human-readable test scenarios in Gherkin language.
2. Rest Assured: A Java-based library used to test RESTful web services.
3. Jackson Library: For converting JSON responses into Plain Old Java Objects (POJOs) to enable straightforward and type-safe assertions.
4. JSON Path: For extracting data from JSON responses when POJO conversion is not necessary.

  The API being tested is the definitive source for exploring U.S. public data.

## Features

**BDD with Cucumber:** Write test scenarios in plain English using Gherkin, making it easier for non-developers to understand test cases.
**Rest Assured Integration:** Simplifies testing of REST APIs, including sending requests and validating responses.
**Response Validation:** JSON responses are converted into POJOs using the Jackson library, enabling straightforward and type-safe assertions.
**Comprehensive Assertions:** Supports assertions on the response status, headers, and body content.


## Getting Started

**Prerequisites**
Java: Ensure you have JDK 8 or higher installed.
Maven: Make sure Maven is installed for managing project dependencies.

## Setup

1. Clone the Repository:https://github.com/kasthuriChidambaram/APIAutomation-RestAssured.git
2. Install Dependencies:
   Run the following command to install the necessary dependencies:
   [mvn clean install]
3. Run Tests:
   To execute the tests, run the following command:
   [mvn clean test]

### Reporting

Cucumber automatically generates detailed test reports in the target directory after each test run, providing insights into the executed scenarios, steps, and their outcomes.

Additionally, the Masterthought plugin is integrated into the framework to enhance the reporting capabilities. This plugin generates rich, interactive HTML reports that offer a comprehensive view of the test execution.




