package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.table.TableInfo;
import java.util.List;
/* loaded from: classes.dex */
public class DeleteBuilder<T, ID> extends StatementBuilder<T, ID> {
    public DeleteBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.DELETE);
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) {
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        sb.append("DELETE FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
        sb.append(' ');
    }

    public int delete() {
        return this.dao.delete((PreparedDelete) prepare());
    }

    public PreparedDelete<T> prepare() {
        return super.prepareStatement(null, false);
    }

    @Override // com.j256.ormlite.stmt.StatementBuilder
    public void reset() {
        super.reset();
    }
}
