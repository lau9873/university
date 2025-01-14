package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class StringBytesType extends BaseDataType {
    public static final String DEFAULT_STRING_BYTES_CHARSET_NAME = "Unicode";
    public static final StringBytesType singleTon = new StringBytesType();

    public StringBytesType() {
        super(SqlType.BYTE_ARRAY);
    }

    private String getCharsetName(FieldType fieldType) {
        return (fieldType == null || fieldType.getFormat() == null) ? DEFAULT_STRING_BYTES_CHARSET_NAME : fieldType.getFormat();
    }

    public static StringBytesType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return String.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        String str = (String) obj;
        String charsetName = getCharsetName(fieldType);
        try {
            return str.getBytes(charsetName);
        } catch (UnsupportedEncodingException e2) {
            throw SqlExceptionUtil.create("Could not convert string with charset name: " + charsetName, e2);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(getCharsetName(fieldType));
        } catch (UnsupportedEncodingException e2) {
            throw SqlExceptionUtil.create("Could not convert default string: " + str, e2);
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i2) {
        throw new SQLException("String-bytes type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        return databaseResults.getBytes(i2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        byte[] bArr = (byte[]) obj;
        String charsetName = getCharsetName(fieldType);
        try {
            return new String(bArr, charsetName);
        } catch (UnsupportedEncodingException e2) {
            throw SqlExceptionUtil.create("Could not convert string with charset name: " + charsetName, e2);
        }
    }

    public StringBytesType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
