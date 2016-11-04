package liquibase.ext.redshift.database;

import org.junit.Test;

import static org.junit.Assert.*;

import liquibase.statement.SqlStatement;
import liquibase.statement.core.RawSqlStatement;

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

}