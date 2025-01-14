package com.j256.ormlite.stmt.query;
/* loaded from: classes.dex */
public class ColumnNameOrRawSql {
    public final String columnName;
    public final String rawSql;

    public ColumnNameOrRawSql(String str, String str2) {
        this.columnName = str;
        this.rawSql = str2;
    }

    public static ColumnNameOrRawSql withColumnName(String str) {
        return new ColumnNameOrRawSql(str, null);
    }

    public static ColumnNameOrRawSql withRawSql(String str) {
        return new ColumnNameOrRawSql(null, str);
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getRawSql() {
        return this.rawSql;
    }

    public String toString() {
        String str = this.rawSql;
        return str == null ? this.columnName : str;
    }
}
