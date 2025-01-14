package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class BigIntegerType extends BaseDataType {
    public static int DEFAULT_WIDTH = 255;
    public static final BigIntegerType singleTon = new BigIntegerType();

    public BigIntegerType() {
        super(SqlType.STRING, new Class[]{BigInteger.class});
    }

    public static BigIntegerType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object convertIdNumber(Number number) {
        return BigInteger.valueOf(number.longValue());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidGeneratedType() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((BigInteger) obj).toString();
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        if (obj == null) {
            return BigInteger.ONE;
        }
        return ((BigInteger) obj).add(BigInteger.ONE);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        try {
            return new BigInteger(str).toString();
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default BigInteger string '" + str + "'", e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) {
        return databaseResults.getString(i);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        try {
            return new BigInteger((String) obj);
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with column " + i + " parsing BigInteger string '" + obj + "'", e);
        }
    }

    public BigIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
