package com.j256.ormlite.dao;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface CloseableWrappedIterable<T> extends CloseableIterable<T>, Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
