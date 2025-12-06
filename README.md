# RestAssured API Testing Framework

A skeleton project demonstrating API test automation using RestAssured framework with Java and TestNG.

## Overview

This is a lightweight, modular API testing framework built with RestAssured that demonstrates best practices for API test automation. The project uses the [ReqRes](https://reqres.in) API as a sample target for demonstration purposes.

## Features

- ✅ Modular architecture with separation of concerns
- ✅ RestAssured for API testing
- ✅ TestNG for test execution and data-driven testing
- ✅ Jackson and Gson for JSON serialization/deserialization
- ✅ Lombok for reducing boilerplate code
- ✅ JavaFaker for test data generation
- ✅ Properties-based configuration
- ✅ Custom request handler for HTTP methods
- ✅ POJO-based request and response models

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

The framework follows a layered architecture:

1. **Core Layer**: Contains the foundation classes like `RequestHandler` and `IServiceEndpoint` interface
2. **Endpoint Layer**: Implements specific API endpoints with URL, method, headers, and body
3. **Model Layer**: Client classes that orchestrate API calls
4. **Request/Response Layer**: POJO classes for API requests and responses
5. **Test Layer**: TestNG test classes with data providers

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

- **RestAssured 5.4.0**: API testing framework
- **TestNG 7.10.0**: Testing framework
- **Lombok 1.18.32**: Reduces boilerplate code
- **Jackson 2.17.0**: JSON processing
- **Gson 2.10.1**: JSON serialization/deserialization
- **JavaFaker 1.0.2**: Test data generation

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

Pritesh Patel

## Acknowledgments

- [RestAssured](https://rest-assured.io/) - API testing framework
- [ReqRes](https://reqres.in) - Free API for testing
- [TestNG](https://testng.org/) - Testing framework
