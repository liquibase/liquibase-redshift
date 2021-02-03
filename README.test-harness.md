# Using the Liquibase Test Harness in the Redshift Extension
The liquibase-redshift extension now comes with integration test support via the liquibase-test-harness.
This Liquibase test framework is designed to *also* make it easy for you to test your extensions.

### Configuring your project

#### Configuring your connections

- We have provided a `harness-config.yml` file in `src/test/resources` directory.
This file should contain the connection information for all the databases you want the Redshift extension to be tested against.

- Use `harness.initScript.sql` file to create and populate test database for harness integration tests

#### Executing the tests
- From your IDE, right click on the `LiquibaseHarnessSuiteTest` test class present in `src/test/groovy` directory.
  - Doing so, will allow you to execute all the standard change object tests in the liquibase-test-harness as well as the
Redshift specific change objects tests created exclusively to test this extension (These test files will be located in the
`src/test/resources/liquibase/harness/changelogs/redshift` directory. If the directory does not already exist, please create
    it and add the test files that you would like tested).

#### Troubleshooting notes
- If IDE doesn't allow you to run LiquibaseHarnessSuiteTest as test class, mark test/groovy folder as test classes folder in your IDE