# BDD Cucumber Automation Framework

## Project Overview
This is a Behavior-Driven Development (BDD) automation framework built using Java, Cucumber, and Maven. It is designed for API and UI testing, supporting modular, maintainable, and scalable test automation. The framework enables writing human-readable test scenarios and integrates with reporting tools for comprehensive test results.

## Features
- BDD with Cucumber: Write tests in Gherkin syntax for better collaboration.
- Modular Structure: Organized by features, step definitions, runners, and utilities.
- API Testing: Includes reusable API client and assertions.
- Configurable: Centralized configuration management.
- Reporting: Generates detailed HTML reports after test execution.
- Easy Integration: Supports CI/CD pipelines and extensibility.

## Folder Structure
```
pom.xml                  # Maven build configuration
src/
  main/
    java/
      com/testing/framework/
        config/           # Configuration classes (e.g., Config.java)
        core/             # Core framework classes (e.g., ApiClient.java)
        models/           # Data models (e.g., User.java, UserResponse.java)
        utils/            # Utility classes
    resources/            # Main resources
  test/
    java/
      com/testing/framework/
        runners/          # Cucumber runner classes (e.g., TestRunner.java)
        stepdefs/         # Step definition classes (e.g., AuthStepDefs.java)
        utils/            # Test utilities
    resources/
      features/           # Feature files (e.g., login.feature)
target/
  cucumber-report.html    # Generated test reports
```

## Prerequisites
- Java 8 or above
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)
- Git (for version control)

## Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd bddCucumber
   ```
2. **Install dependencies:**
   Maven will automatically resolve dependencies from `pom.xml`.
   ```sh
   mvn clean install
   ```
3. **Configure environment:**
   - Update configuration in `src/main/java/com/testing/framework/config/Config.java` as needed.

## Usage
### Writing Feature Files
- Add new `.feature` files in `src/test/resources/features/`.
- Use Gherkin syntax to describe scenarios.

### Step Definitions
- Implement step definitions in `src/test/java/com/testing/framework/stepdefs/`.
- Map Gherkin steps to Java methods.

### Test Runners
- Use runner classes in `src/test/java/com/testing/framework/runners/` to execute tests.
- Example: `TestRunner.java` for all features, or specific runners for individual features.

## Running Tests
- To run all tests and generate reports:
  ```sh
  mvn test
  ```
- To run a specific runner:
  ```sh
  mvn -Dtest=LoginRunner test
  ```
- Reports will be generated in the `target/` directory (e.g., `cucumber-report.html`).

## Reporting
- After test execution, HTML reports are available in `target/`.
- Reports include scenario status, steps, and error details.
- Example reports:
  - `cucumber-login-report.html`
  - `cucumber-register-report.html`
  - `cucumber-user-report.html`

## Contribution Guidelines
- Fork the repository and create a feature branch.
- Follow Java and Cucumber best practices.
- Write clear, maintainable code and descriptive commit messages.
- Add/modify tests for new features or bug fixes.
- Submit a pull request for review.

## Troubleshooting
- **Build Issues:** Ensure Java and Maven versions are compatible.
- **Test Failures:** Check configuration and feature file syntax.
- **Dependency Problems:** Run `mvn clean install` to resolve.
- **Report Not Generated:** Verify runner and plugin configuration in `pom.xml`.

## License
This project is licensed under the MIT License. See `LICENSE` for details.

---
For questions or support, contact the maintainer or open an issue in the repository.

