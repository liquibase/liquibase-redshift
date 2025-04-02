package liquibase.ext.redshift.database

import spock.lang.Specification

class RedshiftDatabaseTest extends Specification {
    
    def "pipeline test is executed"() {
        expect:
        println "====== PIPELINE TEST IS RUNNING SUCCESSFULLY ======"
        println "This test demonstrates that the test framework is working properly."
        println "Test execution count will be 1 in the test report."
        true
    }
    
    def "test get short name"() {
        expect:
        new RedshiftDatabase().getShortName() == "redshift"
    }
}