package liquibase.ext.redshift.datatype;

import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;

public class DateTimeTypeRedshift extends liquibase.datatype.core.DateTimeType {
    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        return new DatabaseDataType("TIMESTAMP");
    }
}
