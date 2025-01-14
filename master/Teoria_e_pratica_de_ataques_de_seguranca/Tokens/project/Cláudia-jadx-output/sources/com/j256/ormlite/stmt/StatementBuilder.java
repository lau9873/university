package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class StatementBuilder<T, ID> {
    public static Logger logger = LoggerFactory.getLogger(StatementBuilder.class);
    public boolean addTableName;
    public final Dao<T, ID> dao;
    public final DatabaseType databaseType;
    public final TableInfo<T, ID> tableInfo;
    public final String tableName;
    public StatementType type;
    public Where<T, ID> where = null;

    /* loaded from: classes.dex */
    public static class StatementInfo {
        public final List<ArgumentHolder> argList;
        public final String statement;

        public List<ArgumentHolder> getArgList() {
            return this.argList;
        }

        public String getStatement() {
            return this.statement;
        }

        public StatementInfo(String str, List<ArgumentHolder> list) {
            this.argList = list;
            this.statement = str;
        }
    }

    /* loaded from: classes.dex */
    public enum StatementType {
        SELECT(true, true, false, false),
        SELECT_LONG(true, true, false, false),
        SELECT_RAW(true, true, false, false),
        UPDATE(true, false, true, false),
        DELETE(true, false, true, false),
        EXECUTE(false, false, false, true);
        
        public final boolean okForExecute;
        public final boolean okForQuery;
        public final boolean okForStatementBuilder;
        public final boolean okForUpdate;

        StatementType(boolean z, boolean z2, boolean z3, boolean z4) {
            this.okForStatementBuilder = z;
            this.okForQuery = z2;
            this.okForUpdate = z3;
            this.okForExecute = z4;
        }

        public boolean isOkForExecute() {
            return this.okForExecute;
        }

        public boolean isOkForQuery() {
            return this.okForQuery;
        }

        public boolean isOkForStatementBuilder() {
            return this.okForStatementBuilder;
        }

        public boolean isOkForUpdate() {
            return this.okForUpdate;
        }
    }

    /* loaded from: classes.dex */
    public enum WhereOperation {
        FIRST("WHERE ", null),
        AND("AND (", ") "),
        OR("OR (", ") ");
        
        public final String after;
        public final String before;

        WhereOperation(String str, String str2) {
            this.before = str;
            this.after = str2;
        }

        public void appendAfter(StringBuilder sb) {
            String str = this.after;
            if (str != null) {
                sb.append(str);
            }
        }

        public void appendBefore(StringBuilder sb) {
            String str = this.before;
            if (str != null) {
                sb.append(str);
            }
        }
    }

    public StatementBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao, StatementType statementType) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.tableName = tableInfo.getTableName();
        this.dao = dao;
        this.type = statementType;
        if (statementType.isOkForStatementBuilder()) {
            return;
        }
        throw new IllegalStateException("Building a statement from a " + statementType + " statement is not allowed");
    }

    public abstract void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list);

    public abstract void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list);

    public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) {
        appendStatementStart(sb, list);
        appendWhereStatement(sb, list, WhereOperation.FIRST);
        appendStatementEnd(sb, list);
    }

    public boolean appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, WhereOperation whereOperation) {
        if (this.where == null) {
            return whereOperation == WhereOperation.FIRST;
        }
        whereOperation.appendBefore(sb);
        this.where.appendSql(this.addTableName ? getTableName() : null, sb, list);
        whereOperation.appendAfter(sb);
        return false;
    }

    public String buildStatementString(List<ArgumentHolder> list) {
        StringBuilder sb = new StringBuilder(128);
        appendStatementString(sb, list);
        String sb2 = sb.toString();
        logger.debug("built statement {}", sb2);
        return sb2;
    }

    public FieldType[] getResultFieldTypes() {
        return null;
    }

    public String getTableName() {
        return this.tableName;
    }

    public StatementType getType() {
        return this.type;
    }

    public MappedPreparedStmt<T, ID> prepareStatement(Long l, boolean z) {
        List<ArgumentHolder> arrayList = new ArrayList<>();
        String buildStatementString = buildStatementString(arrayList);
        ArgumentHolder[] argumentHolderArr = (ArgumentHolder[]) arrayList.toArray(new ArgumentHolder[arrayList.size()]);
        FieldType[] resultFieldTypes = getResultFieldTypes();
        FieldType[] fieldTypeArr = new FieldType[arrayList.size()];
        for (int i2 = 0; i2 < argumentHolderArr.length; i2++) {
            fieldTypeArr[i2] = argumentHolderArr[i2].getFieldType();
        }
        if (this.type.isOkForStatementBuilder()) {
            TableInfo<T, ID> tableInfo = this.tableInfo;
            if (this.databaseType.isLimitSqlSupported()) {
                l = null;
            }
            return new MappedPreparedStmt<>(tableInfo, buildStatementString, fieldTypeArr, resultFieldTypes, argumentHolderArr, l, this.type, z);
        }
        throw new IllegalStateException("Building a statement from a " + this.type + " statement is not allowed");
    }

    public StatementInfo prepareStatementInfo() {
        ArrayList arrayList = new ArrayList();
        return new StatementInfo(buildStatementString(arrayList), arrayList);
    }

    public String prepareStatementString() {
        return buildStatementString(new ArrayList());
    }

    public void reset() {
        this.where = null;
    }

    public void setWhere(Where<T, ID> where) {
        this.where = where;
    }

    public boolean shouldPrependTableNameToColumns() {
        return false;
    }

    public FieldType verifyColumnName(String str) {
        return this.tableInfo.getFieldTypeByColumnName(str);
    }

    public Where<T, ID> where() {
        this.where = new Where<>(this.tableInfo, this, this.databaseType);
        return this.where;
    }
}
