package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.io.Closeable;
/* loaded from: classes.dex */
public interface CompiledStatement extends Closeable {
    void cancel();

    void closeQuietly();

    int getColumnCount();

    String getColumnName(int i2);

    int runExecute();

    DatabaseResults runQuery(ObjectCache objectCache);

    int runUpdate();

    void setMaxRows(int i2);

    void setObject(int i2, Object obj, SqlType sqlType);

    void setQueryTimeout(long j);
}
