package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.io.Closeable;
import java.util.Iterator;
/* loaded from: classes.dex */
public interface CloseableIterator<T> extends Iterator<T>, Closeable {
    void closeQuietly();

    T current();

    T first();

    DatabaseResults getRawResults();

    T moveRelative(int i2);

    void moveToNext();

    T nextThrow();

    T previous();
}
