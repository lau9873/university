package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
/* loaded from: classes.dex */
public abstract class BaseFieldConverter implements FieldConverter {
    @Override // com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return obj;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToJava(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        Object resultToSqlArg = resultToSqlArg(fieldType, databaseResults, i2);
        if (resultToSqlArg == null) {
            return null;
        }
        return sqlArgToJava(fieldType, resultToSqlArg, i2);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        return obj;
    }
}
