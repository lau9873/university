package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedQuery<T>, PreparedDelete<T>, PreparedUpdate<T> {
    public final ArgumentHolder[] argHolders;
    public final boolean cacheStore;
    public final Long limit;
    public final StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, Long l, StatementBuilder.StatementType statementType, boolean z) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = l;
        this.type = statementType;
        this.cacheStore = z;
    }

    private CompiledStatement assignStatementArguments(CompiledStatement compiledStatement) {
        SqlType sqlType;
        try {
            if (this.limit != null) {
                compiledStatement.setMaxRows(this.limit.intValue());
            }
            Object[] objArr = null;
            if (BaseMappedStatement.logger.isLevelEnabled(Log.Level.TRACE) && this.argHolders.length > 0) {
                objArr = new Object[this.argHolders.length];
            }
            for (int i2 = 0; i2 < this.argHolders.length; i2++) {
                Object sqlArgValue = this.argHolders[i2].getSqlArgValue();
                FieldType fieldType = this.argFieldTypes[i2];
                if (fieldType == null) {
                    sqlType = this.argHolders[i2].getSqlType();
                } else {
                    sqlType = fieldType.getSqlType();
                }
                compiledStatement.setObject(i2, sqlArgValue, sqlType);
                if (objArr != null) {
                    objArr[i2] = sqlArgValue;
                }
            }
            BaseMappedStatement.logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(this.argHolders.length));
            if (objArr != null) {
                BaseMappedStatement.logger.trace("prepared statement arguments: {}", (Object) objArr);
            }
            return compiledStatement;
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(compiledStatement, "statement");
            throw th;
        }
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) {
        return compile(databaseConnection, statementType, -1);
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public String getStatement() {
        return this.statement;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public StatementBuilder.StatementType getType() {
        return this.type;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public void setArgumentHolderValue(int i2, Object obj) {
        if (i2 >= 0) {
            ArgumentHolder[] argumentHolderArr = this.argHolders;
            if (argumentHolderArr.length > i2) {
                argumentHolderArr[i2].setValue(obj);
                return;
            }
            throw new SQLException("argument holder index " + i2 + " is not valid, only " + this.argHolders.length + " in statement (index starts at 0)");
        }
        throw new SQLException("argument holder index " + i2 + " must be >= 0");
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i2) {
        if (this.type == statementType) {
            return assignStatementArguments(databaseConnection.compileStatement(this.statement, statementType, this.argFieldTypes, i2, this.cacheStore));
        }
        throw new SQLException("Could not compile this " + this.type + " statement since the caller is expecting a " + statementType + " statement.  Check your QueryBuilder methods.");
    }
}
