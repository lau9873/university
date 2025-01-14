package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.Closeable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;

/* loaded from: classes.dex */
public interface DatabaseResults extends Closeable {
    void closeQuietly();

    int findColumn(String str);

    boolean first();

    BigDecimal getBigDecimal(int i);

    InputStream getBlobStream(int i);

    boolean getBoolean(int i);

    byte getByte(int i);

    byte[] getBytes(int i);

    char getChar(int i);

    int getColumnCount();

    String[] getColumnNames();

    double getDouble(int i);

    float getFloat(int i);

    int getInt(int i);

    long getLong(int i);

    Object getObject(int i);

    ObjectCache getObjectCacheForRetrieve();

    ObjectCache getObjectCacheForStore();

    short getShort(int i);

    String getString(int i);

    Timestamp getTimestamp(int i);

    boolean last();

    boolean moveAbsolute(int i);

    boolean moveRelative(int i);

    boolean next();

    boolean previous();

    boolean wasNull(int i);
}
