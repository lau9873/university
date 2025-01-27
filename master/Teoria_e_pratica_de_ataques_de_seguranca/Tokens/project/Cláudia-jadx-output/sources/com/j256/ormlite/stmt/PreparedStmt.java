package com.j256.ormlite.stmt;

import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
/* loaded from: classes.dex */
public interface PreparedStmt<T> extends GenericRowMapper<T> {
    CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType);

    CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i2);

    String getStatement();

    StatementBuilder.StatementType getType();

    void setArgumentHolderValue(int i2, Object obj);
}
