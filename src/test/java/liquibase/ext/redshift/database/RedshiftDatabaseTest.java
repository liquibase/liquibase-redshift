package liquibase.ext.redshift.database;

import org.junit.Test;

import static org.junit.Assert.*;

public class RedshiftDatabaseTest {

    @Test
    public void testGetShortName() throws Exception {
        assertEquals("redshift", new RedshiftDatabase().getShortName());
    }
}