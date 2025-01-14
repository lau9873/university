package com.j256.ormlite.support;

import com.j256.ormlite.p134db.DatabaseType;
import java.io.Closeable;

/* loaded from: classes.dex */
public interface ConnectionSource extends Closeable {
    void clearSpecialConnection(DatabaseConnection databaseConnection);

    void closeQuietly();

    DatabaseType getDatabaseType();

    DatabaseConnection getReadOnlyConnection(String str);

    DatabaseConnection getReadWriteConnection(String str);

    DatabaseConnection getSpecialConnection(String str);

    boolean isOpen(String str);

    boolean isSingleConnection(String str);

    void releaseConnection(DatabaseConnection databaseConnection);

    boolean saveSpecialConnection(DatabaseConnection databaseConnection);
}
