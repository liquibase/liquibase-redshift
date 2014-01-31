package liquibase.ext.redshift.datatype;

import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.TimestampType;
import liquibase.ext.redshift.database.RedshiftDatabase;

public class TimestampTypeRedshift extends TimestampType {

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(Database database) {
        return database instanceof RedshiftDatabase;
    }

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        return new DatabaseDataType("TIMESTAMP");
    }
}
