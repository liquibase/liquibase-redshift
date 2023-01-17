package liquibase.ext.redshift

import liquibase.harness.FoundationalHarnessSuite
import liquibase.harness.config.TestConfig

class LiquibaseHarnessFoundationalSuiteTest extends FoundationalHarnessSuite {
    static {
        //extensions don't distribute their files. Only we store them in src/main/resources.
        TestConfig.instance.outputResourcesBase = "src/main/resources"
    }
}