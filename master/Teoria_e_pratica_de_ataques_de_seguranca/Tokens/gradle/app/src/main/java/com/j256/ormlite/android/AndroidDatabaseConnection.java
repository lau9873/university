package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;

/* loaded from: classes.dex */
public class AndroidDatabaseConnection implements DatabaseConnection {
    public static final String ANDROID_VERSION = "VERSION__5.0__";
    public final boolean cancelQueriesEnabled;

    /* renamed from: db */
    public final SQLiteDatabase f6342db;
    public final boolean readWrite;
    public static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
    public static final String[] NO_STRING_ARGS = new String[0];

    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C14491 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class OurSavePoint implements Savepoint {
        public String name;

        public OurSavePoint(String str) {
            this.name = str;
        }

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions("VERSION__5.0__");
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) {
        if (objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                SqlType sqlType = fieldTypeArr[i].getSqlType();
                switch (C14491.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(i + 1, obj.toString());
                        continue;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(i + 1, ((Number) obj).longValue());
                        continue;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(i + 1, ((Number) obj).doubleValue());
                        continue;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(i + 1, (byte[]) obj);
                        continue;
                    case 13:
                    case 14:
                    case 15:
                        throw new SQLException("Invalid Android type: " + sqlType);
                    default:
                        throw new SQLException("Unknown sql argument type: " + sqlType);
                }
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f6342db.close();
            logger.trace("{}: db {} closed", this, this.f6342db);
        } catch (android.database.SQLException e) {
            throw new IOException("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) {
        try {
            this.f6342db.setTransactionSuccessful();
            this.f6342db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems commiting transaction", e);
            }
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i, boolean z) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.f6342db, statementType, this.cancelQueriesEnabled, z);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String str, int i) {
        return AndroidCompiledStatement.execSql(this.f6342db, str, str, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.f6342db.compileStatement(str);
                bindArgs(sQLiteStatement, objArr, fieldTypeArr);
                long executeInsert = sQLiteStatement.executeInsert();
                if (generatedKeyHolder != null) {
                    generatedKeyHolder.addKey(Long.valueOf(executeInsert));
                }
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
                return 1;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("inserting to database failed: " + str, e);
            }
        } finally {
            closeQuietly(sQLiteStatement);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() {
        try {
            boolean inTransaction = this.f6342db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() {
        try {
            boolean isOpen = this.f6342db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.f6342db, Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String str) {
        SQLiteDatabase sQLiteDatabase = this.f6342db;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", null);
        try {
            boolean z = rawQuery.getCount() > 0;
            logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
            return z;
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str) {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.f6342db.compileStatement(str);
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(simpleQueryForLong), str);
                return simpleQueryForLong;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e);
            }
        } finally {
            closeQuietly(sQLiteStatement);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) {
        Cursor cursor;
        AndroidDatabaseResults androidDatabaseResults;
        android.database.SQLException e;
        T t = null;
        try {
            cursor = this.f6342db.rawQuery(str, toStrings(objArr));
            try {
                androidDatabaseResults = new AndroidDatabaseResults(cursor, objectCache, true);
            } catch (android.database.SQLException e2) {
                androidDatabaseResults = null;
                e = e2;
            } catch (Throwable th) {
                th = th;
                androidDatabaseResults = null;
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                throw th;
            }
        } catch (android.database.SQLException e3) {
            androidDatabaseResults = null;
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            androidDatabaseResults = null;
        }
        try {
            try {
                logger.trace("{}: queried for one result: {}", this, str);
                if (androidDatabaseResults.first()) {
                    t = genericRowMapper.mapRow(androidDatabaseResults);
                    if (androidDatabaseResults.next()) {
                        Object obj = DatabaseConnection.MORE_THAN_ONE;
                        IOUtils.closeQuietly(androidDatabaseResults);
                        closeQuietly(cursor);
                        return obj;
                    }
                }
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                return t;
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                throw th;
            }
        } catch (android.database.SQLException e4) {
            e = e4;
            throw SqlExceptionUtil.create("queryForOne from database failed: " + str, e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) {
        try {
            this.f6342db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e);
            }
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.f6342db.inTransaction()) {
                this.f6342db.setTransactionSuccessful();
                this.f6342db.endTransaction();
            }
        } else if (this.f6342db.inTransaction()) {
        } else {
            this.f6342db.beginTransaction();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String str) {
        try {
            this.f6342db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction " + str, e);
        }
    }

    public String toString() {
        return AndroidDatabaseConnection.class.getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.f6342db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    private void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) {
        int i;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                SQLiteStatement compileStatement = this.f6342db.compileStatement(str);
                try {
                    bindArgs(compileStatement, objArr, fieldTypeArr);
                    compileStatement.execute();
                    closeQuietly(compileStatement);
                    try {
                        sQLiteStatement = this.f6342db.compileStatement("SELECT CHANGES()");
                        i = (int) sQLiteStatement.simpleQueryForLong();
                    } catch (android.database.SQLException unused) {
                        i = 1;
                    } catch (Throwable th) {
                        closeQuietly(sQLiteStatement);
                        throw th;
                    }
                    closeQuietly(sQLiteStatement);
                    logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(i), str);
                    return i;
                } catch (android.database.SQLException e) {
                    e = e;
                    sQLiteStatement = compileStatement;
                    throw SqlExceptionUtil.create("updating database failed: " + str, e);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteStatement = compileStatement;
                    closeQuietly(sQLiteStatement);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (android.database.SQLException e2) {
            e = e2;
        }
    }

    private void closeQuietly(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.j256.ormlite.android.AndroidDatabaseConnection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.database.Cursor] */
    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) {
        Closeable closeable;
        android.database.SQLException e;
        AndroidDatabaseResults androidDatabaseResults;
        try {
            try {
                objArr = this.f6342db.rawQuery(str, toStrings(objArr));
            } catch (android.database.SQLException e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                objArr = 0;
                closeable = null;
            }
            try {
                androidDatabaseResults = new AndroidDatabaseResults(objArr, null, false);
            } catch (android.database.SQLException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                closeQuietly(objArr);
                IOUtils.closeQuietly(closeable);
                throw th;
            }
            try {
                long j = androidDatabaseResults.first() ? androidDatabaseResults.getLong(0) : 0L;
                logger.trace("{}: query for long raw query returned {}: {}", (Object) this, Long.valueOf(j), str);
                closeQuietly(objArr);
                IOUtils.closeQuietly(androidDatabaseResults);
                return j;
            } catch (android.database.SQLException e4) {
                e = e4;
                throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}