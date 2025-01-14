package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes.dex */
public class EnumToStringType extends EnumStringType {
    public static final EnumToStringType singleTon = new EnumToStringType();

    public EnumToStringType() {
        super(SqlType.STRING, new Class[]{Enum.class});
    }

    public static EnumToStringType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.EnumStringType
    public String getEnumName(Enum<?> r1) {
        return r1.toString();
    }

    public EnumToStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
