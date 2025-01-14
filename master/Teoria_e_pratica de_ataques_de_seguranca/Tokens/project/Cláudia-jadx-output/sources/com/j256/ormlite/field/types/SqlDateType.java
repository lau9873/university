package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
/* loaded from: classes.dex */
public class SqlDateType extends DateType {
    public static final SqlDateType singleTon = new SqlDateType();
    public static final BaseDateType.DateStringFormatConfig sqlDateFormatConfig = new BaseDateType.DateStringFormatConfig("yyyy-MM-dd");

    public SqlDateType() {
        super(SqlType.DATE, new Class[]{Date.class});
    }

    public static SqlDateType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.DateType
    public BaseDateType.DateStringFormatConfig getDefaultDateFormatConfig() {
        return sqlDateFormatConfig;
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Timestamp(((Date) obj).getTime());
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        return new Date(((Timestamp) obj).getTime());
    }

    public SqlDateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
