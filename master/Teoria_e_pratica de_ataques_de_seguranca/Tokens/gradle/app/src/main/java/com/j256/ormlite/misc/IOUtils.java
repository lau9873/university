package com.j256.ormlite.misc;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeThrowSqlException(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw SqlExceptionUtil.create("could not close " + str, e);
            }
        }
    }
}
