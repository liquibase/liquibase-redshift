package liquibase.ext.redshift.sqlgenerator.core

import liquibase.database.core.MSSQLDatabase
import liquibase.database.core.MySQLDatabase
import liquibase.database.core.PostgresDatabase
import liquibase.ext.redshift.database.RedshiftDatabase
import liquibase.sql.Sql
import liquibase.sqlgenerator.SqlGenerator
import liquibase.statement.core.TagDatabaseStatement
import spock.lang.Specification

class RedshiftTagDatabaseGeneratorTest extends Specification {

    private RedshiftTagDatabaseGenerator generator

    void setup() {
        generator = new RedshiftTagDatabaseGenerator()
    }

    def "getPriority returns PRIORITY_DATABASE"() {
        when:
        def priority = generator.getPriority()

        then:
        priority == SqlGenerator.PRIORITY_DATABASE
    }

    def "supports returns true for RedshiftDatabase and false for non-Redshift databases"() {
        given:
        def statement = new TagDatabaseStatement("v1.0")

        expect:
        generator.supports(statement, new RedshiftDatabase())
        !generator.supports(statement, new PostgresDatabase())
        !generator.supports(statement, new MySQLDatabase())
        !generator.supports(statement, new MSSQLDatabase())
    }

    def "generateSql produces correct Redshift UPDATE statement"() {
        given:
        def database = new RedshiftDatabase()
        def statement = new TagDatabaseStatement("v1.0")
        def expectedSql = "UPDATE databasechangelog SET \"TAG\" = 'v1.0'" +
                " FROM (SELECT DATEEXECUTED, ORDEREXECUTED FROM databasechangelog" +
                " ORDER BY DATEEXECUTED DESC, ORDEREXECUTED DESC LIMIT 1) AS sub " +
                "WHERE databasechangelog.DATEEXECUTED=sub.DATEEXECUTED" +
                " AND databasechangelog.ORDEREXECUTED=sub.ORDEREXECUTED"

        when:
        Sql[] result = generator.generateSql(statement, database, null)

        then:
        result.length == 1
        result[0].toSql() == expectedSql
    }
}
