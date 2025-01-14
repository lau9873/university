package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

/* loaded from: classes.dex */
public class LongObjectType extends BaseDataType {
    public static final LongObjectType singleTon = new LongObjectType();

    public LongObjectType() {
        super(SqlType.LONG, new Class[]{Long.class});
    }

    public static LongObjectType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object convertIdNumber(Number number) {
        return Long.valueOf(number.longValue());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidGeneratedType() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        if (obj == null) {
            return 1L;
        }
        return Long.valueOf(((Long) obj).longValue() + 1);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Long.valueOf(Long.parseLong(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) {
        return Long.valueOf(databaseResults.getLong(i));
    }

    public LongObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
