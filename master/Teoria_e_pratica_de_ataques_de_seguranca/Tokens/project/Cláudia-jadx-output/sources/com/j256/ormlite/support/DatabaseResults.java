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

    BigDecimal getBigDecimal(int i2);

    InputStream getBlobStream(int i2);

    boolean getBoolean(int i2);

    byte getByte(int i2);

    byte[] getBytes(int i2);

    char getChar(int i2);

    int getColumnCount();

    String[] getColumnNames();

    double getDouble(int i2);

    float getFloat(int i2);

    int getInt(int i2);

    long getLong(int i2);

    Object getObject(int i2);

    ObjectCache getObjectCacheForRetrieve();

    ObjectCache getObjectCacheForStore();

    short getShort(int i2);

    String getString(int i2);

    Timestamp getTimestamp(int i2);

    boolean last();

    boolean moveAbsolute(int i2);

    boolean moveRelative(int i2);

    boolean next();

    boolean previous();

    boolean wasNull(int i2);
}
