package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.io.Closeable;

/* loaded from: classes.dex */
public interface CompiledStatement extends Closeable {
    void cancel();

    void closeQuietly();

    int getColumnCount();

    String getColumnName(int i);

    int runExecute();

    DatabaseResults runQuery(ObjectCache objectCache);

    int runUpdate();

    void setMaxRows(int i);

    void setObject(int i, Object obj, SqlType sqlType);

    void setQueryTimeout(long j);
}
