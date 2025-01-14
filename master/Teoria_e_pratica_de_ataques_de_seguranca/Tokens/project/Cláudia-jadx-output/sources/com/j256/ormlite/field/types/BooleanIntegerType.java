package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
/* loaded from: classes.dex */
public class BooleanIntegerType extends BooleanType {
    public static final Integer TRUE_VALUE = 1;
    public static final Integer FALSE_VALUE = 0;
    public static final BooleanIntegerType singleTon = new BooleanIntegerType();

    public BooleanIntegerType() {
        super(SqlType.INTEGER);
    }

    public static BooleanIntegerType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((Boolean) obj).booleanValue() ? TRUE_VALUE : FALSE_VALUE;
    }

    @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i2) {
        if (str.length() == 0) {
            return Boolean.FALSE;
        }
        return sqlArgToJava(fieldType, Integer.valueOf(Integer.parseInt(str)), i2);
    }

    @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        return Integer.valueOf(databaseResults.getInt(i2));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        return ((Integer) obj).intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }
}
