package liquibase.ext.redshift

import liquibase.harness.FoundationalHarnessSuite
import liquibase.harness.config.TestConfig
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.SuiteDisplayName

@Suite
@SuiteDisplayName("Liquibase Redshift Foundational Tests")
class LiquibaseHarnessFoundationalSuiteTest extends FoundationalHarnessSuite {
    static {
        //extensions don't distribute their files. Only we store them in src/main/resources.
        TestConfig.instance.outputResourcesBase = "src/main/resources"
    }
}