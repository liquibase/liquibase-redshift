package liquibase.ext.redshift.database;

import org.junit.Test;

import static org.junit.Assert.*;

import liquibase.statement.SqlStatement;
import liquibase.statement.core.RawSqlStatement;
import liquibase.structure.core.ForeignKey;
import liquibase.structure.core.Index;

public class RedshiftDatabaseTest {

    @Test
    public void testGetShortName() throws Exception {
        assertEquals("redshift", new RedshiftDatabase().getShortName());
    }

    @Test
    public void testGetConnectionSchemaNameCallStatement() throws Exception {

        SqlStatement sqlStatement = new RedshiftDatabase().getConnectionSchemaNameCallStatement();

        assertEquals(RawSqlStatement.class, sqlStatement.getClass());
        assertEquals("select current_schema()", ((RawSqlStatement)sqlStatement).getSql());
    }

    @Test
    public void testSupportsIndex() throws Exception {
        RedshiftDatabase database = new RedshiftDatabase();
        assertFalse("Redshift should not support indexes", database.supports(Index.class));
    }
    
    @Test
    public void testSupportsForeignKey() {
        RedshiftDatabase database = new RedshiftDatabase();
        assertFalse("Redshift should not support foreign keys", database.supports(ForeignKey.class));
    }

}