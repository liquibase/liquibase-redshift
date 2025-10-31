package liquibase.ext.redshift.snapshot

import liquibase.database.core.PostgresDatabase
import liquibase.database.jvm.JdbcConnection
import liquibase.ext.redshift.database.RedshiftDatabase
import liquibase.snapshot.SnapshotGenerator
import liquibase.snapshot.jvm.ColumnSnapshotGenerator
import liquibase.structure.core.Column
import liquibase.structure.core.Relation
import spock.lang.Specification

class RedshiftColumnSnapshotGeneratorTest extends Specification {

    private RedshiftColumnSnapshotGenerator generator

    void setup() {
        generator = new RedshiftColumnSnapshotGenerator()
    }

    def "getPriority returns PRIORITY_DATABASE for RedshiftDatabase"() {
        given:
        def database = Mock(RedshiftDatabase)

        when:
        def priority = generator.getPriority(Column.class, database)

        then:
        priority == SnapshotGenerator.PRIORITY_DATABASE
    }

    def "getPriority returns PRIORITY_NONE for non-Redshift databases"() {
        given:
        def database = Mock(PostgresDatabase)

        when:
        def priority = generator.getPriority(Column.class, database)

        then:
        priority == SnapshotGenerator.PRIORITY_NONE
    }

    def "replaces returns parent ColumnSnapshotGenerator class"() {
        when:
        def replacedClasses = generator.replaces()

        then:
        replacedClasses.length == 1
        replacedClasses[0] == ColumnSnapshotGenerator.class
    }

    def "setAutoIncrementDetails returns early when autoIncrementInformation is null"() {
        given:
        def column = new Column()
        column.setAutoIncrementInformation(null)
        def database = Mock(RedshiftDatabase)

        when:
        generator.setAutoIncrementDetails(column, database, null)

        then:
        // Should return early without throwing exception
        notThrown(Exception)
        column.getAutoIncrementInformation() == null
    }

    def "setAutoIncrementDetails returns early when connection is null"() {
        given:
        def column = new Column()
        column.setAutoIncrementInformation(new Column.AutoIncrementInformation())
        def database = Mock(RedshiftDatabase) {
            getConnection() >> null
        }

        when:
        generator.setAutoIncrementDetails(column, database, null)

        then:
        // Should return early without attempting query
        notThrown(Exception)
    }

    def "setAutoIncrementDetails returns early when relation is null"() {
        given:
        def column = new Column()
        column.setAutoIncrementInformation(new Column.AutoIncrementInformation())
        column.setRelation(null)
        def database = Mock(RedshiftDatabase) {
            getConnection() >> Mock(JdbcConnection)
        }

        when:
        generator.setAutoIncrementDetails(column, database, null)

        then:
        // Should return early without attempting query
        notThrown(Exception)
    }

    def "setAutoIncrementDetails returns early when schema is null"() {
        given:
        def column = new Column()
        column.setAutoIncrementInformation(new Column.AutoIncrementInformation())
        def relation = Mock(Relation) {
            getName() >> "test_table"
            getSchema() >> null
        }
        column.setRelation(relation)
        def database = Mock(RedshiftDatabase) {
            getConnection() >> Mock(JdbcConnection)
        }

        when:
        generator.setAutoIncrementDetails(column, database, null)

        then:
        // Should return early without attempting query
        notThrown(Exception)
    }
}