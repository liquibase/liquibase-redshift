# Using the Liquibase Test Harness in the Redshift Extension
The liquibase-redshift extension now comes with integration test support via the liquibase-test-harness.
This Liquibase test framework is designed to *also* make it easy for you to test your extensions.

### Configuring your project

#### Configuring your connections

- Use the provided `harness-config.yml` file in `src/test/resources` directory.  
- Update this file to add the connection information for all the databases you want the Liquibase Redshift extension to be tested against.
  - *If this config file does not exist, create a new one using this as an example : https://github.com/liquibase/liquibase-test-harness/blob/main/src/test/resources/harness-config.yml*
- Your database under test will need to be created and populated prior to the Harness tests running. 
 - Use `harness.initScript.sql` file located in the same `src/test/resources` directory to do this preparatory step.
 - - *If this script file does not exist, create a new one using this as an example : https://github.com/liquibase/liquibase-test-harness/blob/main/src/test/resources/sqlite/sqlite-init.sql*

#### Executing the Harness Base test
- From your IDE, right click on the `LiquibaseHarnessSuiteIT` test class present in `src/test/groovy` directory.
  - Doing so, will allow you to execute all the standard change object tests in the liquibase-test-harness as well as the
Redshift specific change objects tests created exclusively to test this extension (These test files will be located in the
`src/test/resources/liquibase/harness/changelogs/redshift` directory. 
  - If the directory does not already exist, please create it and add the test files that you would like tested).
    
#### Executing the Harness Foundational test
- From your IDE, right click on the `LiquibaseHarnessFoundationalSuiteTest` test class present in `src/test/groovy/liquibase/ext/redshift` directory.
    - Doing so, will allow you to execute Foundational harness suite. Test data for this test will be located in the
      `src/test/resources/liquibase/harness/compatibility/foundational/expectedResultSet/redshift` directory.
    - If the directory does not already exist, please create it and add the test data files that you would like to be tested.    

#### Executing the Harness Advanced test
- From your IDE, right click on the `LiquibaseHarnessAdvancedSuiteTest` test class present in `src/test/groovy/liquibase/ext/redshift` directory.
    - Doing so, will allow you to execute Advanced harness suite, which includes GenerateChangelog and Snapshot tests. Test data for these tests will be located in the
      `src/main/resources/liquibase/harness/generateChangelog/expectedChangeLog/redshift` and `src/main/resources/liquibase/harness/snapshot/changelogs(expectedSnapshot)/redshift`directories.
    - If the directories do not already exist, please create them and add the test data files that you would like to be tested.

##### Alternative ways to run the Harness test suites
- Using maven by executing next command:
  `mvn -Dtest="TESTSUITE_NAME" -DdbName=redshift -DdbUsername=USERNAME -DdbPassword=PASSWORD -DdbUrl=URL test`
    - where USERNAME, PASSWORD and URL are connection credentials and TESTSUITE_NAME is the name of test suite you want to execute (LiquibaseHarnessAdvancedSuiteTest, LiquibaseHarnessFoundationalSuiteTest)

#### Troubleshooting notes
- If your IDE doesn't allow you to run LiquibaseHarnessSuiteIT as a test class, mark test/groovy folder as test classes folder in your IDE
