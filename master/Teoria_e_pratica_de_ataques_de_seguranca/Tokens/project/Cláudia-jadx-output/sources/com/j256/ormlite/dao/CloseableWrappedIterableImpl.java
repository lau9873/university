package com.j256.ormlite.dao;

import com.j256.ormlite.misc.IOUtils;
/* loaded from: classes.dex */
public class CloseableWrappedIterableImpl<T> implements CloseableWrappedIterable<T> {
    public final CloseableIterable<T> iterable;
    public CloseableIterator<T> iterator;

    public CloseableWrappedIterableImpl(CloseableIterable<T> closeableIterable) {
        this.iterable = closeableIterable;
    }

    @Override // com.j256.ormlite.dao.CloseableWrappedIterable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableIterator<T> closeableIterator = this.iterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.iterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        IOUtils.closeQuietly(this);
        this.iterator = this.iterable.closeableIterator();
        return this.iterator;
    }

    @Override // java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return closeableIterator();
    }
}
