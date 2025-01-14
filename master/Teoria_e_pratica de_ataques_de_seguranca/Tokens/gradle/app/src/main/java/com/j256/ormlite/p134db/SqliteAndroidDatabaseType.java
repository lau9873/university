package com.j256.ormlite.p134db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.SqlDateStringType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.TimeStampStringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

/* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType */
/* loaded from: classes.dex */
public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType {

    /* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C14621 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i) {
        appendShortType(sb, fieldType, i);
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i) {
        appendStringType(sb, fieldType, i);
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public void appendEscapedEntityName(StringBuilder sb, String str) {
        sb.append('`');
        sb.append(str);
        sb.append('`');
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) {
        return DatabaseTableConfigUtil.fromClass(connectionSource, cls);
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType) {
        if (dataPersister == null) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        if (C14621.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()] != 1) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        if (dataPersister instanceof TimeStampType) {
            return TimeStampStringType.getSingleton();
        }
        if (dataPersister instanceof SqlDateType) {
            return SqlDateStringType.getSingleton();
        }
        return DateStringType.getSingleton();
    }

    @Override // com.j256.ormlite.p134db.DatabaseType
    public String getDatabaseName() {
        return "Android SQLite";
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType
    public String getDriverClassName() {
        return null;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public boolean isBatchUseTransaction() {
        return true;
    }

    @Override // com.j256.ormlite.p134db.DatabaseType
    public boolean isDatabaseUrlThisType(String str, String str2) {
        return true;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public boolean isNestedSavePointsSupported() {
        return false;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public void loadDriver() {
    }
}
