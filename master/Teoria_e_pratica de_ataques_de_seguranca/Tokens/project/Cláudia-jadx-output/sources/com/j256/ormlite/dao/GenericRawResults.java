package com.j256.ormlite.dao;

import java.util.List;
/* loaded from: classes.dex */
public interface GenericRawResults<T> extends CloseableWrappedIterable<T> {
    @Override // com.j256.ormlite.dao.CloseableWrappedIterable, java.io.Closeable, java.lang.AutoCloseable
    void close();

    String[] getColumnNames();

    T getFirstResult();

    int getNumberColumns();

    List<T> getResults();
}
