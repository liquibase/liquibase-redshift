package liquibase.ext.redshift

import liquibase.harness.AdvancedHarnessSuite
import liquibase.harness.config.TestConfig

class LiquibaseHarnessAdvancedSuiteTest extends AdvancedHarnessSuite {
    static {
        //extensions don't distribute their files. Only we store them in src/main/resources.
        TestConfig.instance.outputResourcesBase = "src/main/resources"
    }
}