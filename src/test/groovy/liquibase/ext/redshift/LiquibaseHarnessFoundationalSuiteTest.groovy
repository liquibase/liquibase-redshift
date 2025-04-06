package liquibase.ext.redshift

import liquibase.harness.FoundationalHarnessSuite
import liquibase.database.DatabaseFactory
import liquibase.ext.redshift.database.RedshiftDatabase
import org.junit.BeforeClass

class LiquibaseHarnessFoundationalSuiteTest extends FoundationalHarnessSuite {

    @BeforeClass
    static void setupRedshiftTests() {
        // Register Redshift database implementation with highest priority
        DatabaseFactory.getInstance().clearRegistry()
        DatabaseFactory.getInstance().register(new RedshiftDatabase())
        
        // Force the use of Redshift database implementation
        System.setProperty("liquibase.ext.redshift.force", "true")
    }
}