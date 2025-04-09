package liquibase.ext.redshift.snapshot;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.snapshot.DatabaseSnapshot;
import liquibase.snapshot.InvalidExampleException;
import liquibase.snapshot.SnapshotGenerator;
import liquibase.structure.DatabaseObject;
import liquibase.ext.redshift.database.RedshiftDatabase;

public class IndexSnapshotGenerator extends liquibase.snapshot.jvm.IndexSnapshotGenerator {
    @Override
    public int getPriority(Class<? extends DatabaseObject> objectType, Database database) {
        if (database instanceof RedshiftDatabase) {
            return PRIORITY_DATABASE;
        }
        return PRIORITY_NONE;
    }

    @Override
    protected void addTo(DatabaseObject foundObject, DatabaseSnapshot snapshot) throws DatabaseException, InvalidExampleException {
        //Redshift does not support indexes
    }

    @Override
    public Class<? extends SnapshotGenerator>[] replaces() {
        return new Class[] { liquibase.snapshot.jvm.IndexSnapshotGenerator.class} ;
    }

    @Override
    protected DatabaseObject snapshotObject(DatabaseObject example, DatabaseSnapshot snapshot) throws DatabaseException, InvalidExampleException {
        return null; //Redshift does not support indexes
    }
}