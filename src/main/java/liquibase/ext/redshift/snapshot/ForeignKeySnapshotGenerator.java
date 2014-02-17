package liquibase.ext.redshift.snapshot;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.snapshot.DatabaseSnapshot;
import liquibase.snapshot.InvalidExampleException;
import liquibase.snapshot.SnapshotGenerator;
import liquibase.structure.DatabaseObject;

public class ForeignKeySnapshotGenerator extends liquibase.snapshot.jvm.ForeignKeySnapshotGenerator {
    @Override
    public int getPriority(Class<? extends DatabaseObject> objectType, Database database) {
        return PRIORITY_DATABASE;
    }

    @Override
    protected void addTo(DatabaseObject foundObject, DatabaseSnapshot snapshot) throws DatabaseException, InvalidExampleException {
        //Redshift does not support calls to MetaData.getIncomingKeys() and doesn't really support FKs anyway
    }

    @Override
    public Class<? extends SnapshotGenerator>[] replaces() {
        return new Class[] { liquibase.snapshot.jvm.ForeignKeySnapshotGenerator.class} ;
    }

    @Override
    protected DatabaseObject snapshotObject(DatabaseObject example, DatabaseSnapshot snapshot) throws DatabaseException, InvalidExampleException {
        return null; //Redshift does not support calls to MetaData.getIncomingKeys() and doesn't really support FKs anyway
    }
}
