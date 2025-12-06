# RestAssured API Testing Framework

![Java](https://img.shields.io/badge/Java-11%2B-orange)
![RestAssured](https://img.shields.io/badge/RestAssured-5.4.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.10.0-red)
![Gradle](https://img.shields.io/badge/Gradle-8.5-blue)

A skeleton project demonstrating API test automation using RestAssured framework with Java and TestNG. This repository provides a production-ready template for REST API testing, integration testing, and continuous delivery workflows.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Dependencies](#dependencies)
- [Usage Examples](#usage-examples)
- [Extending the Framework](#extending-the-framework)
- [Contributing](#contributing)

## Overview

This is a lightweight, modular API testing framework built with RestAssured that demonstrates best practices for REST API test automation, HTTP testing, and API integration testing. The project uses the [ReqRes](https://reqres.in) API as a sample target for demonstration purposes, making it ideal for learning API automation, functional testing, and continuous integration testing.

## Features

- ✅ **Modular Architecture**: Clean separation of concerns with layered design
- ✅ **RestAssured Integration**: Powerful REST API testing capabilities
- ✅ **TestNG Framework**: Advanced test execution, parallel testing, and data-driven testing
- ✅ **JSON Support**: Jackson and Gson for JSON parsing and serialization
- ✅ **Lombok Integration**: Reduced boilerplate code with annotations
- ✅ **Test Data Generation**: JavaFaker for dynamic test data
- ✅ **Configuration Management**: Properties-based configuration for multiple environments
- ✅ **HTTP Methods Support**: GET, POST, PUT, PATCH, DELETE operations
- ✅ **POJO Models**: Type-safe request and response handling

## Prerequisites

- Java 11 or higher
- Gradle 8.5 or higher (wrapper included)

## Project Structure

```
restAssuredDemo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── core/                 # Core framework components
│   │   │   │   ├── BaseResponse.java
│   │   │   │   ├── HttpMethod.java
│   │   │   │   ├── IServiceEndpoint.java
│   │   │   │   └── RequestHandler.java
│   │   │   ├── endpoints/            # API endpoint definitions
│   │   │   │   ├── CreateUserEndPoint.java
│   │   │   │   └── GetSingleUserEndPoint.java
│   │   │   ├── helpers/              # Utility classes
│   │   │   │   └── PropertiesReader.java
│   │   │   ├── model/                # API client models
│   │   │   │   └── ReqResClient.java
│   │   │   ├── properties/           # Configuration properties
│   │   │   │   └── ReqResProperties.java
│   │   │   ├── requests/             # Request POJO models
│   │   │   │   └── CreateUserRequest.java
│   │   │   └── responses/            # Response POJO models
│   │   │       ├── CreateUserResponse.java
│   │   │       └── GetSingleUserResponse.java
│   │   └── resources/
│   │       └── env.properties        # Environment configuration
│   └── test/
│       ├── java/
│       │   ├── Tests.java            # Base test class
│       │   ├── UserTests.java        # User-related test cases
│       │   └── datprovider/          # TestNG data providers
│       │       └── UserDataProvider.java
│       └── resources/
│           └── env.properties
├── build.gradle
└── settings.gradle
```

## Architecture

The framework follows a clean, maintainable layered architecture pattern for API test automation:

1. **Core Layer**: Foundation classes including `RequestHandler` for HTTP operations and `IServiceEndpoint` interface for endpoint contracts
2. **Endpoint Layer**: API endpoint implementations with URL mapping, HTTP methods, headers, and request bodies
3. **Model Layer**: Client classes (ReqResClient) that orchestrate API calls and handle responses
4. **Request/Response Layer**: POJO models for type-safe API request and response handling
5. **Test Layer**: TestNG test suites with data providers for parameterized testing

### Key Components

- **RequestHandler**: Handles HTTP requests for all supported methods (GET, POST, PUT, PATCH, DELETE)
- **IServiceEndpoint**: Interface that defines the contract for API endpoints
- **ReqResClient**: High-level client for ReqRes API operations
- **BaseResponse**: Base class for all response objects

## Getting Started

### Installation

1. Clone the repository:
```bash
git clone https://github.com/pritesh1991/restAssuredDemo.git
cd restAssuredDemo
```

2. Build the project:
```bash
./gradlew clean build
```

### Configuration

Update the `src/main/resources/env.properties` file with your API configuration:

```properties
baseUrl=https://reqres.in
```

### Running Tests

Execute all tests:
```bash
./gradlew test
```

Execute tests with detailed output:
```bash
./gradlew test --info
```

## Dependencies

This REST API testing framework uses the following technologies:

- **RestAssured 5.4.0**: Industry-standard REST API testing library for Java
- **TestNG 7.10.0**: Powerful testing framework with advanced features
- **Lombok 1.18.32**: Annotation processor to reduce Java boilerplate
- **Jackson 2.17.0**: High-performance JSON processor
- **Gson 2.10.1**: Google's JSON serialization library
- **JavaFaker 1.0.2**: Fake data generator for realistic test data

## Usage Examples

### Creating a Test

```java
public class UserTests extends Tests {
    
    @Test
    public void createUserTest() {
        String name = "John Doe";
        String job = "QA Engineer";
        CreateUserResponse user = reqResClient.createUser(name, job);
        Assert.assertEquals(user.getStatusCode(), 201);
    }
}
```

### Using Data Providers

```java
@Test(dataProvider = "userdata", dataProviderClass = UserDataProvider.class)
public void getUserDetailsTest(String userId, String firstName, String lastName, String email) {
    GetSingleUserResponse user = reqResClient.getUser(userId);
    Assert.assertEquals(user.getData().getFirstName(), firstName);
    Assert.assertEquals(user.getData().getLastName(), lastName);
    Assert.assertEquals(user.getData().getEmail(), email);
}
```

### Creating a New Endpoint

1. Implement `IServiceEndpoint` interface:
```java
public class YourEndpoint implements IServiceEndpoint {
    @Override
    public String url() { return YOUR_URL; }
    
    @Override
    public HttpMethod method() { return HttpMethod.GET; }
    
    @Override
    public Map<String, String> headers() { return null; }
    
    @Override
    public String body() { return null; }
}
```

2. Add the endpoint to your client model
3. Create corresponding response POJOs
4. Write tests

## Extending the Framework

### Adding New API Endpoints

1. Create endpoint class in `endpoints/` package
2. Define request/response POJOs in respective packages
3. Add endpoint to client model
4. Write test cases

### Adding New Test Suites

1. Create test class extending `Tests` base class
2. Add test methods with TestNG annotations
3. Use data providers for data-driven testing
4. Assert responses using TestNG assertions

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is open source and available for educational purposes.

## Author

**Pritesh Patel** - [GitHub Profile](https://github.com/pritesh1991)

## Acknowledgments

- [RestAssured](https://rest-assured.io/) - Leading REST API testing framework for Java
- [ReqRes](https://reqres.in) - Free hosted REST API for testing and prototyping
- [TestNG](https://testng.org/) - Testing framework inspired by JUnit and NUnit
