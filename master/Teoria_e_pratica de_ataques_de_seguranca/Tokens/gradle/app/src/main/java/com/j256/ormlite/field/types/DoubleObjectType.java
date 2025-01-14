package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

/* loaded from: classes.dex */
public class DoubleObjectType extends BaseDataType {
    public static final DoubleObjectType singleTon = new DoubleObjectType();

    public DoubleObjectType() {
        super(SqlType.DOUBLE, new Class[]{Double.class});
    }

    public static DoubleObjectType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Double.valueOf(Double.parseDouble(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) {
        return Double.valueOf(databaseResults.getDouble(i));
    }

    public DoubleObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
