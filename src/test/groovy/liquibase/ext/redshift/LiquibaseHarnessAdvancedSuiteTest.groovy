package liquibase.ext.redshift

import liquibase.harness.AdvancedHarnessSuite
import liquibase.harness.config.TestConfig
import liquibase.harness.generateChangelog.GenerateChangelogTest
import liquibase.harness.snapshot.SnapshotObjectTests

class LiquibaseHarnessAdvancedSuiteTest extends SnapshotObjectTests {
    static {
        //extensions don't distribute their files. Only we store them in src/main/resources.
        TestConfig.instance.outputResourcesBase = "src/main/resources"
    }
}