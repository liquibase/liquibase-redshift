package liquibase.ext.redshift.sqlgenerator.core;

import liquibase.database.Database;
import liquibase.database.core.*;
import liquibase.sqlgenerator.core.TagDatabaseGenerator;
import liquibase.datatype.DataTypeFactory;
import liquibase.exception.ValidationErrors;
import liquibase.sql.Sql;
import liquibase.sql.UnparsedSql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.SqlGeneratorFactory;
import liquibase.statement.core.TagDatabaseStatement;
import liquibase.statement.core.UpdateStatement;
import liquibase.structure.core.Column;
import liquibase.structure.core.Table;
import liquibase.ext.redshift.database.RedshiftDatabase;

public class RedshiftTagDatabaseGenerator extends TagDatabaseGenerator {

    @Override
    public ValidationErrors validate(TagDatabaseStatement tagDatabaseStatement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        ValidationErrors validationErrors = new ValidationErrors();
        validationErrors.checkRequiredField("tag", tagDatabaseStatement.getTag());
        return validationErrors;
    }

    @Override
    public int getPriority()
    {
        return 6;
    }

    @Override
    public Sql[] generateSql(TagDatabaseStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        if (database instanceof RedshiftDatabase) {
            String tableNameEscaped = database.escapeTableName(database.getLiquibaseCatalogName(), database.getLiquibaseSchemaName(), database.getDatabaseChangeLogTableName());
            String orderColumnNameEscaped = database.escapeObjectName("ORDEREXECUTED", Column.class);
            String dateColumnNameEscaped = database.escapeObjectName("DATEEXECUTED", Column.class);
            String tagColumnNameEscaped = database.escapeObjectName("TAG", Column.class);
            String tagEscaped = DataTypeFactory.getInstance().fromObject(statement.getTag(), database).objectToSql(statement.getTag(), database);

            return new Sql[]{
                    new UnparsedSql(
                            "UPDATE " + tableNameEscaped + " SET " + tagColumnNameEscaped + " = " + tagEscaped +
                                    " FROM (SELECT " + dateColumnNameEscaped + ", " + orderColumnNameEscaped + " FROM " + tableNameEscaped + " ORDER BY " + dateColumnNameEscaped + " DESC, " + orderColumnNameEscaped + " DESC LIMIT 1) AS sub " +
                                    "WHERE " + tableNameEscaped + "." + dateColumnNameEscaped + "=sub." + dateColumnNameEscaped + " AND " + tableNameEscaped + "." + orderColumnNameEscaped + "=sub." + orderColumnNameEscaped)
            };
        
        }


        return super.generateSql(statement, database, sqlGeneratorChain);

    }
}