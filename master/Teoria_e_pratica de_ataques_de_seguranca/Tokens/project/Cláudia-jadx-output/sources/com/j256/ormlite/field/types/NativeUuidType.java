package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;
/* loaded from: classes.dex */
public class NativeUuidType extends UuidType {
    public static final NativeUuidType singleTon = new NativeUuidType();

    public NativeUuidType() {
        super(SqlType.UUID);
    }

    public static NativeUuidType getSingleton() {
        return singleTon;
    }

    public NativeUuidType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
