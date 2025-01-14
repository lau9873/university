package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class DateTimeType extends BaseDataType {
    public static final DateTimeType singleTon = new DateTimeType();
    public static Class<?> dateTimeClass = null;
    public static Method getMillisMethod = null;
    public static Constructor<?> millisConstructor = null;
    public static final String[] associatedClassNames = {"org.joda.time.DateTime"};

    public DateTimeType() {
        super(SqlType.LONG);
    }

    private Object createInstance(Long l) {
        try {
            if (millisConstructor == null) {
                millisConstructor = getDateTimeClass().getConstructor(Long.TYPE);
            }
            return millisConstructor.newInstance(l);
        } catch (Exception e2) {
            throw SqlExceptionUtil.create("Could not use reflection to construct a Joda DateTime", e2);
        }
    }

    private Long extractMillis(Object obj) {
        try {
            if (getMillisMethod == null) {
                getMillisMethod = getDateTimeClass().getMethod("getMillis", new Class[0]);
            }
            if (obj == null) {
                return null;
            }
            return (Long) getMillisMethod.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            throw SqlExceptionUtil.create("Could not use reflection to get millis from Joda DateTime: " + obj, e2);
        }
    }

    private Class<?> getDateTimeClass() {
        if (dateTimeClass == null) {
            dateTimeClass = Class.forName("org.joda.time.DateTime");
        }
        return dateTimeClass;
    }

    public static DateTimeType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public String[] getAssociatedClassNames() {
        return associatedClassNames;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        try {
            return getDateTimeClass();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return extractMillis(obj);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return createInstance(Long.valueOf(currentTimeMillis));
        }
        if (currentTimeMillis == extractMillis(obj).longValue()) {
            return createInstance(Long.valueOf(currentTimeMillis + 1));
        }
        return createInstance(Long.valueOf(currentTimeMillis));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e2) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default DateTime value: " + str, e2);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        return Long.valueOf(databaseResults.getLong(i2));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        return createInstance((Long) obj);
    }

    public DateTimeType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
