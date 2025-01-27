package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class TableUtils {
    public static Logger logger = LoggerFactory.getLogger(TableUtils.class);
    public static final FieldType[] noFieldTypes = new FieldType[0];

    public static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        FieldType[] fieldTypes;
        String indexName;
        HashMap hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (z2) {
                indexName = fieldType.getUniqueIndexName();
            } else {
                indexName = fieldType.getIndexName();
            }
            if (indexName != null) {
                List list2 = (List) hashMap.get(indexName);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(indexName, list2);
                }
                list2.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry entry : hashMap.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), tableInfo.getTableName());
            sb.append("CREATE ");
            if (z2) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    public static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }

    public static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        FieldType[] fieldTypes;
        HashSet<String> hashSet = new HashSet();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", str, tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    public static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(fieldType, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType.upCaseEntityName(extractTableName);
        }
        return clearTable(connectionSource, extractTableName);
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) {
        return doCreateTable(DaoManager.createDao(connectionSource, cls), false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) {
        return doCreateTable(DaoManager.createDao(connectionSource, cls), true);
    }

    public static <T, ID> int doCreateTable(Dao<T, ID> dao, boolean z) {
        if (dao instanceof BaseDaoImpl) {
            return doCreateTable(dao.getConnectionSource(), ((BaseDaoImpl) dao).getTableInfo(), z);
        }
        return doCreateTable(dao.getConnectionSource(), new TableInfo(dao.getConnectionSource(), (BaseDaoImpl) null, dao.getDataClass()), z);
    }

    public static int doCreateTestQueries(DatabaseConnection databaseConnection, DatabaseType databaseType, List<String> list) {
        CompiledStatement compileStatement;
        int i2 = 0;
        for (String str : list) {
            CompiledStatement compiledStatement = null;
            try {
                try {
                    compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
                } catch (SQLException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                DatabaseResults runQuery = compileStatement.runQuery(null);
                int i3 = 0;
                for (boolean first = runQuery.first(); first; first = runQuery.next()) {
                    i3++;
                }
                logger.info("executing create table after-query got {} results: {}", Integer.valueOf(i3), str);
                IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
                i2++;
            } catch (SQLException e3) {
                e = e3;
                compiledStatement = compileStatement;
                throw SqlExceptionUtil.create("executing create table after-query failed: " + str, e);
            } catch (Throwable th2) {
                th = th2;
                compiledStatement = compileStatement;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                throw th;
            }
        }
        return i2;
    }

    public static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) {
        logger.info("dropping table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(tableInfo.getTableName());
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int doStatements(com.j256.ormlite.support.DatabaseConnection r14, java.lang.String r15, java.util.Collection<java.lang.String> r16, boolean r17, boolean r18, boolean r19) {
        /*
            r1 = r15
            java.lang.String r2 = "compiled statement"
            java.util.Iterator r3 = r16.iterator()
            r4 = 0
            r5 = 0
        L9:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto Lb1
            java.lang.Object r0 = r3.next()
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            r13 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r8 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch: java.lang.Throwable -> L35 java.sql.SQLException -> L38
            com.j256.ormlite.field.FieldType[] r9 = com.j256.ormlite.table.TableUtils.noFieldTypes     // Catch: java.lang.Throwable -> L35 java.sql.SQLException -> L38
            r10 = -1
            r11 = 0
            r6 = r14
            r7 = r12
            com.j256.ormlite.support.CompiledStatement r13 = r6.compileStatement(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L35 java.sql.SQLException -> L38
            int r6 = r13.runExecute()     // Catch: java.lang.Throwable -> L35 java.sql.SQLException -> L38
            com.j256.ormlite.logger.Logger r0 = com.j256.ormlite.table.TableUtils.logger     // Catch: java.sql.SQLException -> L33 java.lang.Throwable -> L35
            java.lang.String r7 = "executed {} table statement changed {} rows: {}"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch: java.sql.SQLException -> L33 java.lang.Throwable -> L35
            r0.info(r7, r15, r8, r12)     // Catch: java.sql.SQLException -> L33 java.lang.Throwable -> L35
            goto L43
        L33:
            r0 = move-exception
            goto L3a
        L35:
            r0 = move-exception
            goto Lad
        L38:
            r0 = move-exception
            r6 = 0
        L3a:
            if (r17 == 0) goto L97
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.table.TableUtils.logger     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = "ignoring {} error '{}' for statement: {}"
            r7.info(r8, r15, r0, r12)     // Catch: java.lang.Throwable -> L35
        L43:
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r13, r2)
            if (r6 >= 0) goto L6f
            if (r18 == 0) goto L4b
            goto L93
        L4b:
            java.sql.SQLException r0 = new java.sql.SQLException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SQL statement "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = " updated "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " rows, we were expecting >= 0"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L6f:
            if (r6 <= 0) goto L93
            if (r19 != 0) goto L74
            goto L93
        L74:
            java.sql.SQLException r0 = new java.sql.SQLException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SQL statement updated "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " rows, we were expecting == 0: "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L93:
            int r5 = r5 + 1
            goto L9
        L97:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r1.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = "SQL statement failed: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L35
            r1.append(r12)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L35
            java.sql.SQLException r0 = com.j256.ormlite.misc.SqlExceptionUtil.create(r1, r0)     // Catch: java.lang.Throwable -> L35
            throw r0     // Catch: java.lang.Throwable -> L35
        Lad:
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r13, r2)
            throw r0
        Lb1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doStatements(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.util.Collection, boolean, boolean, boolean):int");
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) {
        return dropTable(DaoManager.createDao(connectionSource, cls), z);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), false);
    }

    public static int createTable(Dao<?, ?> dao) {
        return doCreateTable(dao, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        return doCreateTable(DaoManager.createDao(connectionSource, databaseTableConfig), true);
    }

    public static <T, ID> int dropTable(Dao<T, ID> dao, boolean z) {
        ConnectionSource connectionSource = dao.getConnectionSource();
        Class<T> dataClass = dao.getDataClass();
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (dao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) dao).getTableInfo(), z);
        }
        return doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, dataClass), z);
    }

    public static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) {
        boolean z2;
        int i2;
        int i3;
        FieldType[] fieldTypeArr;
        StringBuilder sb = new StringBuilder(256);
        sb.append("CREATE TABLE ");
        if (z && databaseType.isCreateIfNotExistsSupported()) {
            sb.append("IF NOT EXISTS ");
        }
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(" (");
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        boolean z3 = true;
        int i4 = 0;
        while (i4 < length) {
            FieldType fieldType = fieldTypes[i4];
            if (fieldType.isForeignCollection()) {
                i2 = i4;
                i3 = length;
                fieldTypeArr = fieldTypes;
            } else {
                if (z3) {
                    z2 = false;
                } else {
                    sb.append(", ");
                    z2 = z3;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    i2 = i4;
                    i3 = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    i2 = i4;
                    i3 = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ');
                    sb.append(columnDefinition);
                    sb.append(' ');
                }
                z3 = z2;
            }
            i4 = i2 + 1;
            length = i3;
            fieldTypes = fieldTypeArr;
        }
        databaseType.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        databaseType.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        for (String str : arrayList) {
            sb.append(", ");
            sb.append(str);
        }
        sb.append(") ");
        databaseType.appendCreateTableSuffix(sb);
        list.addAll(arrayList2);
        list.add(sb.toString());
        list.addAll(arrayList3);
        addCreateIndexStatements(databaseType, tableInfo, list, z, false);
        addCreateIndexStatements(databaseType, tableInfo, list, z, true);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        return doCreateTable(DaoManager.createDao(connectionSource, databaseTableConfig), false);
    }

    public static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(tableInfo.getTableName());
        try {
            return doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), false);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, String str) {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder sb = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            sb.append("TRUNCATE TABLE ");
        } else {
            sb.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(sb, str);
        String sb2 = sb.toString();
        logger.info("clearing table '{}' with '{}", str, sb2);
        CompiledStatement compiledStatement = null;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            compiledStatement = readWriteConnection.compileStatement(sb2, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1, false);
            return compiledStatement.runExecute();
        } finally {
            IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, (BaseDaoImpl) null, databaseTableConfig), z);
    }
}
