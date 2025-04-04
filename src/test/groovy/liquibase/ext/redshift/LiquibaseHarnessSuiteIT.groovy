package liquibase.ext.redshift

import liquibase.harness.BaseHarnessSuite
import liquibase.harness.config.TestConfig
import liquibase.Scope

class LiquibaseHarnessSuiteIT extends BaseHarnessSuite {
    
    def setupSpec() {
        System.setProperty("inputFormat", "xml")
        Scope.getCurrentScope().getUI().sendMessage("Running RedshiftHarnessSuite with input format: ${TestConfig.instance.inputFormat}")
        Scope.getCurrentScope().getUI().sendMessage("Database configuration: ${TestConfig.instance.getFilteredDatabasesUnderTest()}")
    }
}