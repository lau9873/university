package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
/* loaded from: classes.dex */
public class SerializableType extends BaseDataType {
    public static final SerializableType singleTon = new SerializableType();

    public SerializableType() {
        super(SqlType.SERIALIZABLE);
    }

    public static SerializableType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            IOUtils.closeQuietly(null);
            return byteArray;
        } catch (Exception e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            throw SqlExceptionUtil.create("Could not write serialized object to byte array: " + obj, e);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            IOUtils.closeQuietly(objectOutputStream2);
            throw th;
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i2) {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        return databaseResults.getBytes(i2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        ObjectInputStream objectInputStream;
        byte[] bArr = (byte[]) obj;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            IOUtils.closeQuietly(objectInputStream);
            return readObject;
        } catch (Exception e3) {
            e = e3;
            objectInputStream2 = objectInputStream;
            throw SqlExceptionUtil.create("Could not read serialized object from byte array: " + Arrays.toString(bArr) + "(len " + bArr.length + ")", e);
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            IOUtils.closeQuietly(objectInputStream2);
            throw th;
        }
    }

    public SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
