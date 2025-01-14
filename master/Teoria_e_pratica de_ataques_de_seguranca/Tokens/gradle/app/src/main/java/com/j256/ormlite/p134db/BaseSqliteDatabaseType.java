package com.j256.ormlite.p134db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.p134db.BaseDatabaseType;
import java.util.List;

/* renamed from: com.j256.ormlite.db.BaseSqliteDatabaseType */
/* loaded from: classes.dex */
public abstract class BaseSqliteDatabaseType extends BaseDatabaseType {
    public static final FieldConverter booleanConverter = new BaseDatabaseType.BooleanNumberFieldConverter();

    /* renamed from: com.j256.ormlite.db.BaseSqliteDatabaseType$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C14611 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public void appendInsertNoColumns(StringBuilder sb) {
        sb.append("DEFAULT VALUES");
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType
    public void appendLongType(StringBuilder sb, FieldType fieldType, int i) {
        if (fieldType.getSqlType() == SqlType.LONG && fieldType.isGeneratedId()) {
            sb.append("INTEGER");
        } else {
            sb.append("BIGINT");
        }
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType
    public void configureGeneratedId(String str, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        if (fieldType.getSqlType() != SqlType.INTEGER && fieldType.getSqlType() != SqlType.LONG) {
            throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
        }
        sb.append("PRIMARY KEY AUTOINCREMENT ");
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType
    public boolean generatedIdSqlAtEnd() {
        return false;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public FieldConverter getFieldConverter(DataPersister dataPersister, FieldType fieldType) {
        int i = C14611.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return super.getFieldConverter(dataPersister, fieldType);
            }
            return BigDecimalStringType.getSingleton();
        }
        return booleanConverter;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public boolean isCreateIfNotExistsSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public boolean isCreateTableReturnsZero() {
        return false;
    }

    @Override // com.j256.ormlite.p134db.BaseDatabaseType, com.j256.ormlite.p134db.DatabaseType
    public boolean isVarcharFieldWidthSupported() {
        return false;
    }
}
