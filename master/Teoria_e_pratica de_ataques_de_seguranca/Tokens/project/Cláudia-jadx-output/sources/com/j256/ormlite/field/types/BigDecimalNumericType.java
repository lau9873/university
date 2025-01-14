package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class BigDecimalNumericType extends BaseDataType {
    public static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

    public BigDecimalNumericType() {
        super(SqlType.BIG_DECIMAL);
    }

    public static BigDecimalNumericType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return BigDecimal.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        try {
            return new BigDecimal(str);
        } catch (IllegalArgumentException e2) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e2);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        return databaseResults.getBigDecimal(i2);
    }

    public BigDecimalNumericType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
