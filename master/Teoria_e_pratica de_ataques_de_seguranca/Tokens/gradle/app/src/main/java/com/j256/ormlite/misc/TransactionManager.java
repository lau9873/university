package com.j256.ormlite.misc;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.p134db.DatabaseType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class TransactionManager {
    public static final String SAVE_POINT_PREFIX = "ORMLITE";
    public static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
    public static AtomicInteger savePointCounter = new AtomicInteger();
    public ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", savepointName);
        }
    }

    public static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", savepointName);
        }
    }

    public <T> T callInTransaction(Callable<T> callable) {
        return (T) callInTransaction(this.connectionSource, callable);
    }

    public void initialize() {
        if (this.connectionSource != null) {
            return;
        }
        throw new IllegalStateException("dataSource was not set on " + TransactionManager.class.getSimpleName());
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public <T> T callInTransaction(String str, Callable<T> callable) {
        return (T) callInTransaction(str, this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) {
        return (T) callInTransaction((String) null, connectionSource, callable);
    }

    public static <T> T callInTransaction(String str, ConnectionSource connectionSource, Callable<T> callable) {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            return (T) callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) {
        return (T) callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[Catch: all -> 0x0074, Exception -> 0x0078, SQLException -> 0x008b, TRY_LEAVE, TryCatch #7 {SQLException -> 0x008b, Exception -> 0x0078, blocks: (B:22:0x0060, B:24:0x0066), top: B:47:0x0060, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r6, boolean r7, com.j256.ormlite.p134db.DatabaseType r8, java.util.concurrent.Callable<T> r9) {
        /*
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            r1 = 0
            java.lang.String r2 = "restored auto-commit to true"
            r3 = 0
            r4 = 1
            if (r7 != 0) goto L12
            boolean r7 = r8.isNestedSavePointsSupported()     // Catch: java.lang.Throwable -> L98
            if (r7 == 0) goto L10
            goto L12
        L10:
            r7 = 0
            goto L60
        L12:
            boolean r7 = r6.isAutoCommitSupported()     // Catch: java.lang.Throwable -> L98
            if (r7 == 0) goto L2e
            boolean r7 = r6.isAutoCommit()     // Catch: java.lang.Throwable -> L98
            if (r7 == 0) goto L2e
            r6.setAutoCommit(r3)     // Catch: java.lang.Throwable -> L98
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L2a
            java.lang.String r8 = "had to set auto-commit to false"
            r7.debug(r8)     // Catch: java.lang.Throwable -> L2a
            r3 = 1
            goto L2e
        L2a:
            r7 = move-exception
            r3 = 1
            goto L99
        L2e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            r7.<init>()     // Catch: java.lang.Throwable -> L98
            java.lang.String r8 = "ORMLITE"
            r7.append(r8)     // Catch: java.lang.Throwable -> L98
            java.util.concurrent.atomic.AtomicInteger r8 = com.j256.ormlite.misc.TransactionManager.savePointCounter     // Catch: java.lang.Throwable -> L98
            int r8 = r8.incrementAndGet()     // Catch: java.lang.Throwable -> L98
            r7.append(r8)     // Catch: java.lang.Throwable -> L98
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L98
            java.sql.Savepoint r1 = r6.setSavePoint(r7)     // Catch: java.lang.Throwable -> L98
            if (r1 != 0) goto L53
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L98
            java.lang.String r8 = "started savePoint transaction"
            r7.debug(r8)     // Catch: java.lang.Throwable -> L98
            goto L5e
        L53:
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L98
            java.lang.String r8 = "started savePoint transaction {}"
            java.lang.String r5 = r1.getSavepointName()     // Catch: java.lang.Throwable -> L98
            r7.debug(r8, r5)     // Catch: java.lang.Throwable -> L98
        L5e:
            r7 = r3
            r3 = 1
        L60:
            java.lang.Object r8 = r9.call()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L78 java.sql.SQLException -> L8b
            if (r3 == 0) goto L69
            commit(r6, r1)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L78 java.sql.SQLException -> L8b
        L69:
            if (r7 == 0) goto L73
            r6.setAutoCommit(r4)
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger
            r6.debug(r2)
        L73:
            return r8
        L74:
            r8 = move-exception
            r3 = r7
            r7 = r8
            goto L99
        L78:
            r8 = move-exception
            if (r3 == 0) goto L84
            rollBack(r6, r1)     // Catch: java.lang.Throwable -> L74 java.sql.SQLException -> L7f
            goto L84
        L7f:
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L74
            r9.error(r8, r0)     // Catch: java.lang.Throwable -> L74
        L84:
            java.lang.String r9 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r9, r8)     // Catch: java.lang.Throwable -> L74
            throw r8     // Catch: java.lang.Throwable -> L74
        L8b:
            r8 = move-exception
            if (r3 == 0) goto L97
            rollBack(r6, r1)     // Catch: java.lang.Throwable -> L74 java.sql.SQLException -> L92
            goto L97
        L92:
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L74
            r9.error(r8, r0)     // Catch: java.lang.Throwable -> L74
        L97:
            throw r8     // Catch: java.lang.Throwable -> L74
        L98:
            r7 = move-exception
        L99:
            if (r3 == 0) goto La3
            r6.setAutoCommit(r4)
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger
            r6.debug(r2)
        La3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }
}
