package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class BaseDateType extends BaseDataType {
    public static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");

    /* loaded from: classes.dex */
    public static class DateStringFormatConfig {
        public final String dateFormatStr;
        public final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() { // from class: com.j256.ormlite.field.types.BaseDateType.DateStringFormatConfig.1
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                return new SimpleDateFormat(DateStringFormatConfig.this.dateFormatStr);
            }
        };

        public DateStringFormatConfig(String str) {
            this.dateFormatStr = str;
        }

        public DateFormat getDateFormat() {
            return this.threadLocal.get();
        }

        public String toString() {
            return this.dateFormatStr;
        }
    }

    public BaseDateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static DateStringFormatConfig convertDateStringConfig(FieldType fieldType, DateStringFormatConfig dateStringFormatConfig) {
        DateStringFormatConfig dateStringFormatConfig2;
        return (fieldType == null || (dateStringFormatConfig2 = (DateStringFormatConfig) fieldType.getDataTypeConfigObj()) == null) ? dateStringFormatConfig : dateStringFormatConfig2;
    }

    public static String normalizeDateString(DateStringFormatConfig dateStringFormatConfig, String str) {
        DateFormat dateFormat = dateStringFormatConfig.getDateFormat();
        return dateFormat.format(dateFormat.parse(str));
    }

    public static Date parseDateString(DateStringFormatConfig dateStringFormatConfig, String str) {
        return dateStringFormatConfig.getDateFormat().parse(str);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return new Date(currentTimeMillis);
        }
        if (currentTimeMillis == ((Date) obj).getTime()) {
            return new Date(currentTimeMillis + 1);
        }
        return new Date(currentTimeMillis);
    }

    public BaseDateType(SqlType sqlType) {
        super(sqlType);
    }
}
