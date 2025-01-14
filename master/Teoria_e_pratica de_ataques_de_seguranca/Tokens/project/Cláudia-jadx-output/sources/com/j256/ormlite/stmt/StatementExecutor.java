package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DatabaseResultsMapper;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
    public static Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
    public static final FieldType[] noFieldTypes = new FieldType[0];
    public String countStarQuery;
    public final Dao<T, ID> dao;
    public final DatabaseType databaseType;
    public FieldType[] ifExistsFieldTypes;
    public String ifExistsQuery;
    public final ThreadLocal<Boolean> localIsInBatchMode = new ThreadLocal<Boolean>() { // from class: com.j256.ormlite.stmt.StatementExecutor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return false;
        }
    };
    public MappedDelete<T, ID> mappedDelete;
    public MappedCreate<T, ID> mappedInsert;
    public MappedQueryForFieldEq<T, ID> mappedQueryForId;
    public MappedRefresh<T, ID> mappedRefresh;
    public MappedUpdate<T, ID> mappedUpdate;
    public MappedUpdateId<T, ID> mappedUpdateId;
    public PreparedQuery<T> preparedQueryForAll;
    public RawRowMapper<T> rawRowMapper;
    public final TableInfo<T, ID> tableInfo;

    /* loaded from: classes.dex */
    public static class ObjectArrayRowMapper implements GenericRowMapper<Object[]> {
        public final DataType[] columnTypes;

        public ObjectArrayRowMapper(DataType[] dataTypeArr) {
            this.columnTypes = dataTypeArr;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public Object[] mapRow(DatabaseResults databaseResults) {
            DataType dataType;
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i2 = 0; i2 < columnCount; i2++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i2 >= dataTypeArr.length) {
                    dataType = DataType.STRING;
                } else {
                    dataType = dataTypeArr[i2];
                }
                objArr[i2] = dataType.getDataPersister().resultToJava(null, databaseResults, i2);
            }
            return objArr;
        }
    }

    /* loaded from: classes.dex */
    public static class UserDatabaseResultsMapper<UO> implements GenericRowMapper<UO> {
        public final DatabaseResultsMapper<UO> mapper;

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) {
            return this.mapper.mapRow(databaseResults);
        }

        public UserDatabaseResultsMapper(DatabaseResultsMapper<UO> databaseResultsMapper) {
            this.mapper = databaseResultsMapper;
        }
    }

    /* loaded from: classes.dex */
    public static class UserRawRowMapper<UO> implements GenericRowMapper<UO> {
        public String[] columnNames;
        public final RawRowMapper<UO> mapper;
        public final GenericRowMapper<String[]> stringRowMapper;

        public UserRawRowMapper(RawRowMapper<UO> rawRowMapper, GenericRowMapper<String[]> genericRowMapper) {
            this.mapper = rawRowMapper;
            this.stringRowMapper = genericRowMapper;
        }

        private String[] getColumnNames(DatabaseResults databaseResults) {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            this.columnNames = databaseResults.getColumnNames();
            return this.columnNames;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) {
            return this.mapper.mapRow(getColumnNames(databaseResults), this.stringRowMapper.mapRow(databaseResults));
        }
    }

    /* loaded from: classes.dex */
    public static class UserRawRowObjectMapper<UO> implements GenericRowMapper<UO> {
        public String[] columnNames;
        public final DataType[] columnTypes;
        public final RawRowObjectMapper<UO> mapper;

        public UserRawRowObjectMapper(RawRowObjectMapper<UO> rawRowObjectMapper, DataType[] dataTypeArr) {
            this.mapper = rawRowObjectMapper;
            this.columnTypes = dataTypeArr;
        }

        private String[] getColumnNames(DatabaseResults databaseResults) {
            String[] strArr = this.columnNames;
            if (strArr != null) {
                return strArr;
            }
            this.columnNames = databaseResults.getColumnNames();
            return this.columnNames;
        }

        @Override // com.j256.ormlite.stmt.GenericRowMapper
        public UO mapRow(DatabaseResults databaseResults) {
            int columnCount = databaseResults.getColumnCount();
            Object[] objArr = new Object[columnCount];
            for (int i2 = 0; i2 < columnCount; i2++) {
                DataType[] dataTypeArr = this.columnTypes;
                if (i2 >= dataTypeArr.length) {
                    objArr[i2] = null;
                } else {
                    objArr[i2] = dataTypeArr[i2].getDataPersister().resultToJava(null, databaseResults, i2);
                }
            }
            return this.mapper.mapRow(getColumnNames(databaseResults), this.columnTypes, objArr);
        }
    }

    public StatementExecutor(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.dao = dao;
    }

    private void assignStatementArguments(CompiledStatement compiledStatement, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            compiledStatement.setObject(i2, strArr[i2], SqlType.STRING);
        }
    }

    private <CT> CT doCallBatchTasks(ConnectionSource connectionSource, Callable<CT> callable) {
        boolean z;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            this.localIsInBatchMode.set(true);
            z = connectionSource.saveSpecialConnection(readWriteConnection);
            try {
                CT ct = (CT) doCallBatchTasks(readWriteConnection, z, callable);
                if (z) {
                    connectionSource.clearSpecialConnection(readWriteConnection);
                }
                connectionSource.releaseConnection(readWriteConnection);
                this.localIsInBatchMode.set(false);
                Dao<T, ID> dao = this.dao;
                if (dao != null) {
                    dao.notifyChanges();
                }
                return ct;
            } catch (Throwable th) {
                th = th;
                if (z) {
                    connectionSource.clearSpecialConnection(readWriteConnection);
                }
                connectionSource.releaseConnection(readWriteConnection);
                this.localIsInBatchMode.set(false);
                Dao<T, ID> dao2 = this.dao;
                if (dao2 != null) {
                    dao2.notifyChanges();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    private void prepareQueryForAll() {
        if (this.preparedQueryForAll == null) {
            this.preparedQueryForAll = new QueryBuilder(this.databaseType, this.tableInfo, this.dao).prepare();
        }
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, int i2, ObjectCache objectCache) {
        prepareQueryForAll();
        return buildIterator(baseDaoImpl, connectionSource, this.preparedQueryForAll, objectCache, i2);
    }

    public <CT> CT callBatchTasks(ConnectionSource connectionSource, Callable<CT> callable) {
        CT ct;
        if (connectionSource.isSingleConnection(this.tableInfo.getTableName())) {
            synchronized (this) {
                ct = (CT) doCallBatchTasks(connectionSource, callable);
            }
            return ct;
        }
        return (CT) doCallBatchTasks(connectionSource, callable);
    }

    public int create(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) {
        if (this.mappedInsert == null) {
            this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo);
        }
        int insert = this.mappedInsert.insert(this.databaseType, databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return insert;
    }

    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        int delete = this.mappedDelete.delete(databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return delete;
    }

    public int deleteById(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) {
        if (this.mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
        }
        int deleteById = this.mappedDelete.deleteById(databaseConnection, id, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteById;
    }

    public int deleteIds(DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) {
        int deleteIds = MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteIds;
    }

    public int deleteObjects(DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) {
        int deleteObjects = MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, databaseConnection, collection, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return deleteObjects;
    }

    public int executeRaw(DatabaseConnection databaseConnection, String str, String[] strArr) {
        logger.debug("running raw execute statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("execute arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1, false);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runExecute();
        } finally {
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        }
    }

    public int executeRawNoArgs(DatabaseConnection databaseConnection, String str) {
        logger.debug("running raw execute statement: {}", str);
        return databaseConnection.executeStatement(str, -1);
    }

    public RawRowMapper<T> getRawRowMapper() {
        if (this.rawRowMapper == null) {
            this.rawRowMapper = new RawRowMapperImpl(this.tableInfo);
        }
        return this.rawRowMapper;
    }

    public GenericRowMapper<T> getSelectStarRowMapper() {
        prepareQueryForAll();
        return this.preparedQueryForAll;
    }

    public boolean ifExists(DatabaseConnection databaseConnection, ID id) {
        if (this.ifExistsQuery == null) {
            QueryBuilder queryBuilder = new QueryBuilder(this.databaseType, this.tableInfo, this.dao);
            queryBuilder.selectRaw("COUNT(*)");
            queryBuilder.where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
            this.ifExistsQuery = queryBuilder.prepareStatementString();
            this.ifExistsFieldTypes = new FieldType[]{this.tableInfo.getIdField()};
        }
        long queryForLong = databaseConnection.queryForLong(this.ifExistsQuery, new Object[]{this.tableInfo.getIdField().convertJavaFieldToSqlArgValue(id)}, this.ifExistsFieldTypes);
        logger.debug("query of '{}' returned {}", this.ifExistsQuery, Long.valueOf(queryForLong));
        return queryForLong != 0;
    }

    public List<T> query(ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache) {
        SelectIterator<T, ID> buildIterator = buildIterator(null, connectionSource, preparedStmt, objectCache, -1);
        try {
            ArrayList arrayList = new ArrayList();
            while (buildIterator.hasNextThrow()) {
                arrayList.add(buildIterator.nextThrow());
            }
            logger.debug("query of '{}' returned {} results", preparedStmt.getStatement(), Integer.valueOf(arrayList.size()));
            return arrayList;
        } finally {
            IOUtils.closeThrowSqlException(buildIterator, "iterator");
        }
    }

    public List<T> queryForAll(ConnectionSource connectionSource, ObjectCache objectCache) {
        prepareQueryForAll();
        return query(connectionSource, this.preparedQueryForAll, objectCache);
    }

    public long queryForCountStar(DatabaseConnection databaseConnection) {
        if (this.countStarQuery == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("SELECT COUNT(*) FROM ");
            this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
            this.countStarQuery = sb.toString();
        }
        long queryForLong = databaseConnection.queryForLong(this.countStarQuery);
        logger.debug("query of '{}' returned {}", this.countStarQuery, Long.valueOf(queryForLong));
        return queryForLong;
    }

    public T queryForFirst(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt, ObjectCache objectCache) {
        DatabaseResults databaseResults;
        CompiledStatement compile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT);
        try {
            compile.setMaxRows(1);
            databaseResults = compile.runQuery(objectCache);
            try {
                if (databaseResults.first()) {
                    logger.debug("query-for-first of '{}' returned at least 1 result", preparedStmt.getStatement());
                    T mapRow = preparedStmt.mapRow(databaseResults);
                    IOUtils.closeThrowSqlException(databaseResults, "results");
                    IOUtils.closeThrowSqlException(compile, "compiled statement");
                    return mapRow;
                }
                logger.debug("query-for-first of '{}' returned at 0 results", preparedStmt.getStatement());
                IOUtils.closeThrowSqlException(databaseResults, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                return null;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(databaseResults, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            databaseResults = null;
        }
    }

    public T queryForId(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) {
        if (this.mappedQueryForId == null) {
            this.mappedQueryForId = MappedQueryForFieldEq.build(this.databaseType, this.tableInfo, null);
        }
        return this.mappedQueryForId.execute(databaseConnection, id, objectCache);
    }

    public long queryForLong(DatabaseConnection databaseConnection, PreparedStmt<T> preparedStmt) {
        CompiledStatement compile = preparedStmt.compile(databaseConnection, StatementBuilder.StatementType.SELECT_LONG);
        try {
            DatabaseResults runQuery = compile.runQuery(null);
            if (runQuery.first()) {
                long j = runQuery.getLong(0);
                IOUtils.closeThrowSqlException(runQuery, "results");
                IOUtils.closeThrowSqlException(compile, "compiled statement");
                return j;
            }
            throw new SQLException("No result found in queryForLong: " + preparedStmt.getStatement());
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(null, "results");
            IOUtils.closeThrowSqlException(compile, "compiled statement");
            throw th;
        }
    }

    public GenericRawResults<String[]> queryRaw(ConnectionSource connectionSource, String str, String[] strArr, ObjectCache objectCache) {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, this, objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }

    public int refresh(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) {
        if (this.mappedRefresh == null) {
            this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo);
        }
        return this.mappedRefresh.executeRefresh(databaseConnection, t, objectCache);
    }

    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) {
        if (this.mappedUpdate == null) {
            this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo);
        }
        int update = this.mappedUpdate.update(databaseConnection, t, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return update;
    }

    public int updateId(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) {
        if (this.mappedUpdateId == null) {
            this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo);
        }
        int execute = this.mappedUpdateId.execute(databaseConnection, t, id, objectCache);
        if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
            this.dao.notifyChanges();
        }
        return execute;
    }

    public int updateRaw(DatabaseConnection databaseConnection, String str, String[] strArr) {
        logger.debug("running raw update statement: {}", str);
        if (strArr.length > 0) {
            logger.trace("update arguments: {}", (Object) strArr);
        }
        CompiledStatement compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1, false);
        try {
            assignStatementArguments(compileStatement, strArr);
            return compileStatement.runUpdate();
        } finally {
            IOUtils.closeThrowSqlException(compileStatement, "compiled statement");
        }
    }

    @Override // com.j256.ormlite.stmt.GenericRowMapper
    public String[] mapRow(DatabaseResults databaseResults) {
        int columnCount = databaseResults.getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i2 = 0; i2 < columnCount; i2++) {
            strArr[i2] = databaseResults.getString(i2);
        }
        return strArr;
    }

    public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> baseDaoImpl, ConnectionSource connectionSource, PreparedStmt<T> preparedStmt, ObjectCache objectCache, int i2) {
        CompiledStatement compiledStatement;
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = preparedStmt.compile(readOnlyConnection, StatementBuilder.StatementType.SELECT, i2);
            try {
                SelectIterator<T, ID> selectIterator = new SelectIterator<>(this.tableInfo.getDataClass(), baseDaoImpl, preparedStmt, connectionSource, readOnlyConnection, compiledStatement, preparedStmt.getStatement(), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return selectIterator;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }

    public int delete(DatabaseConnection databaseConnection, PreparedDelete<T> preparedDelete) {
        CompiledStatement compile = preparedDelete.compile(databaseConnection, StatementBuilder.StatementType.DELETE);
        try {
            int runUpdate = compile.runUpdate();
            if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                this.dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public int update(DatabaseConnection databaseConnection, PreparedUpdate<T> preparedUpdate) {
        CompiledStatement compile = preparedUpdate.compile(databaseConnection, StatementBuilder.StatementType.UPDATE);
        try {
            int runUpdate = compile.runUpdate();
            if (this.dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                this.dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public long queryForLong(DatabaseConnection databaseConnection, String str, String[] strArr) {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for long: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        try {
            compiledStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                DatabaseResults runQuery = compiledStatement.runQuery(null);
                if (runQuery.first()) {
                    long j = runQuery.getLong(0);
                    IOUtils.closeThrowSqlException(runQuery, "results");
                    IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                    return j;
                }
                throw new SQLException("No result found in queryForLong: " + str);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(null, "results");
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, RawRowMapper<UO> rawRowMapper, String[] strArr, ObjectCache objectCache) {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, new UserRawRowMapper(rawRowMapper, this), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }

    private <CT> CT doCallBatchTasks(DatabaseConnection databaseConnection, boolean z, Callable<CT> callable) {
        if (this.databaseType.isBatchUseTransaction()) {
            return (CT) TransactionManager.callInTransaction(databaseConnection, z, this.databaseType, callable);
        }
        boolean z2 = false;
        try {
            if (databaseConnection.isAutoCommitSupported() && databaseConnection.isAutoCommit()) {
                databaseConnection.setAutoCommit(false);
                try {
                    logger.debug("disabled auto-commit on table {} before batch tasks", this.tableInfo.getTableName());
                    z2 = true;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (z2) {
                        databaseConnection.setAutoCommit(true);
                        logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                    }
                    throw th;
                }
            }
            try {
                try {
                    CT call = callable.call();
                    if (z2) {
                        databaseConnection.setAutoCommit(true);
                        logger.debug("re-enabled auto-commit on table {} after batch tasks", this.tableInfo.getTableName());
                    }
                    return call;
                } catch (SQLException e2) {
                    throw e2;
                }
            } catch (Exception e3) {
                throw SqlExceptionUtil.create("Batch tasks callable threw non-SQL exception", e3);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String[] strArr, ObjectCache objectCache) {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, String[].class, compiledStatement, new UserRawRowObjectMapper(rawRowObjectMapper, dataTypeArr), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }

    public GenericRawResults<Object[]> queryRaw(ConnectionSource connectionSource, String str, DataType[] dataTypeArr, String[] strArr, ObjectCache objectCache) {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compiledStatement, new ObjectArrayRowMapper(dataTypeArr), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }

    public <UO> GenericRawResults<UO> queryRaw(ConnectionSource connectionSource, String str, DatabaseResultsMapper<UO> databaseResultsMapper, String[] strArr, ObjectCache objectCache) {
        CompiledStatement compiledStatement;
        logger.debug("executing raw query for: {}", str);
        if (strArr.length > 0) {
            logger.trace("query arguments: {}", (Object) strArr);
        }
        DatabaseConnection readOnlyConnection = connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            compiledStatement = readOnlyConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes, -1, false);
            try {
                assignStatementArguments(compiledStatement, strArr);
                RawResultsImpl rawResultsImpl = new RawResultsImpl(connectionSource, readOnlyConnection, str, Object[].class, compiledStatement, new UserDatabaseResultsMapper(databaseResultsMapper), objectCache);
                IOUtils.closeThrowSqlException(null, "compiled statement");
                return rawResultsImpl;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeThrowSqlException(compiledStatement, "compiled statement");
                if (readOnlyConnection != null) {
                    connectionSource.releaseConnection(readOnlyConnection);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            compiledStatement = null;
        }
    }
}
