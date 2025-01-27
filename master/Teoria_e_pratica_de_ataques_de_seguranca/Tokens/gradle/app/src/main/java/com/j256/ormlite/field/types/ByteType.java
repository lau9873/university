package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes.dex */
public class ByteType extends ByteObjectType {
    public static final ByteType singleTon = new ByteType();

    public ByteType() {
        super(SqlType.BYTE, new Class[]{Byte.TYPE});
    }

    public static ByteType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public ByteType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
