package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;

/* loaded from: classes.dex */
public interface RawRowObjectMapper<T> {
    T mapRow(String[] strArr, DataType[] dataTypeArr, Object[] objArr);
}
