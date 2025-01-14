package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.p134db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    public String dataClassName;
    public final String queryNextSequenceStmt;
    public int versionFieldTypeIndex;

    /* loaded from: classes.dex */
    public static class KeyHolder implements GeneratedKeyHolder {
        public Number key;

        public KeyHolder() {
        }

        @Override // com.j256.ormlite.support.GeneratedKeyHolder
        public void addKey(Number number) {
            if (this.key == null) {
                this.key = number;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", now set to " + number);
        }

        public Number getKey() {
            return this.key;
        }
    }

    public MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i;
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) {
        this.idField.assignIdValue(t, number, objectCache);
        if (BaseMappedStatement.logger.isLevelEnabled(Log.Level.DEBUG)) {
            BaseMappedStatement.logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        BaseMappedStatement.logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(queryForLong), this.queryNextSequenceStmt);
        if (queryForLong != 0) {
            assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
            return;
        }
        throw new SQLException("Should not have returned 0 for stmt: " + this.queryNextSequenceStmt);
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        FieldType[] fieldTypes;
        FieldType[] fieldTypes2;
        StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        BaseMappedStatement.appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        int i = 0;
        int i2 = -1;
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i2 = i;
                }
                i++;
            }
        }
        FieldType[] fieldTypeArr = new FieldType[i];
        if (i == 0) {
            databaseType.appendInsertNoColumns(sb);
        } else {
            sb.append('(');
            boolean z = true;
            int i3 = 0;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType2)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    BaseMappedStatement.appendFieldColumnName(databaseType, sb, fieldType2, null);
                    fieldTypeArr[i3] = fieldType2;
                    i3++;
                }
            }
            sb.append(") VALUES (");
            boolean z2 = true;
            for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType3)) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append('?');
                }
            }
            sb.append(')');
        }
        return new MappedCreate<>(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i2);
    }

    public static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        String generatedIdSequence;
        if (fieldType == null || (generatedIdSequence = fieldType.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) {
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.extractJavaFieldValue(obj) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection() || fieldType.isReadOnly()) {
            return false;
        }
        return (databaseType.isIdSequenceNeeded() && databaseType.isSelectSequenceBeforeInsert()) || !fieldType.isGeneratedId() || fieldType.isSelfGeneratedId() || fieldType.isAllowGeneratedIdInsert();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[Catch: SQLException -> 0x0136, TryCatch #1 {SQLException -> 0x0136, blocks: (B:27:0x005a, B:29:0x0062, B:31:0x006c, B:39:0x0088, B:34:0x0075, B:36:0x007b, B:38:0x0085, B:40:0x008b, B:42:0x0093, B:44:0x0099, B:48:0x00b5, B:50:0x00ca, B:53:0x00d3, B:55:0x00de, B:57:0x00e4, B:59:0x00ee, B:60:0x00f4, B:61:0x00fb, B:62:0x00fc, B:63:0x0103, B:65:0x0106, B:67:0x0112, B:70:0x011f, B:72:0x0130, B:73:0x0135, B:47:0x00ad), top: B:79:0x005a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[Catch: SQLException -> 0x0136, TryCatch #1 {SQLException -> 0x0136, blocks: (B:27:0x005a, B:29:0x0062, B:31:0x006c, B:39:0x0088, B:34:0x0075, B:36:0x007b, B:38:0x0085, B:40:0x008b, B:42:0x0093, B:44:0x0099, B:48:0x00b5, B:50:0x00ca, B:53:0x00d3, B:55:0x00de, B:57:0x00e4, B:59:0x00ee, B:60:0x00f4, B:61:0x00fb, B:62:0x00fc, B:63:0x0103, B:65:0x0106, B:67:0x0112, B:70:0x011f, B:72:0x0130, B:73:0x0135, B:47:0x00ad), top: B:79:0x005a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int insert(com.j256.ormlite.p134db.DatabaseType r11, com.j256.ormlite.support.DatabaseConnection r12, T r13, com.j256.ormlite.dao.ObjectCache r14) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.MappedCreate.insert(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.support.DatabaseConnection, java.lang.Object, com.j256.ormlite.dao.ObjectCache):int");
    }
}
