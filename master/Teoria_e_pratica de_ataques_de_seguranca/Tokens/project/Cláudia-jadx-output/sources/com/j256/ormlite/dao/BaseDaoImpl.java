package com.j256.ormlite.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
    public static ReferenceObjectCache defaultObjectCache;
    public ConnectionSource connectionSource;
    public Map<Dao.DaoObserver, Object> daoObserverMap;
    public final Class<T> dataClass;
    public DatabaseType databaseType;
    public boolean initialized;
    public CloseableIterator<T> lastIterator;
    public ObjectCache objectCache;
    public ObjectFactory<T> objectFactory;
    public StatementExecutor<T, ID> statementExecutor;
    public DatabaseTableConfig<T> tableConfig;
    public TableInfo<T, ID> tableInfo;
    public static final ThreadLocal<List<BaseDaoImpl<?, ?>>> daoConfigLevelLocal = new ThreadLocal<List<BaseDaoImpl<?, ?>>>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.1
        @Override // java.lang.ThreadLocal
        public List<BaseDaoImpl<?, ?>> initialValue() {
            return new ArrayList(10);
        }
    };
    public static final Object constantObject = new Object();

    public BaseDaoImpl(Class<T> cls) {
        this(null, cls, null);
    }

    public static synchronized void clearAllInternalObjectCaches() {
        synchronized (BaseDaoImpl.class) {
            if (defaultObjectCache != null) {
                defaultObjectCache.clearAll();
                defaultObjectCache = null;
            }
        }
    }

    public static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource, Class<T> cls) {
        return new BaseDaoImpl<T, ID>(connectionSource, cls) { // from class: com.j256.ormlite.dao.BaseDaoImpl.5
            @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao, java.lang.Iterable
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return super.iterator();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloseableIterator<T> createIterator(int i2) {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, i2, this.objectCache);
        } catch (Exception e2) {
            throw new IllegalStateException("Could not build iterator for " + this.dataClass, e2);
        }
    }

    private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T t, String str) {
        FieldType[] fieldTypes;
        checkForInitialized();
        ID extractId = t == null ? null : extractId(t);
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getColumnName().equals(str)) {
                BaseForeignCollection buildForeignCollection = fieldType.buildForeignCollection(t, extractId);
                if (t != null) {
                    fieldType.assignField(t, buildForeignCollection, true, null);
                }
                return buildForeignCollection;
            }
        }
        throw new IllegalArgumentException("Could not find a field named " + str);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void assignEmptyForeignCollection(T t, String str) {
        makeEmptyForeignCollection(t, str);
    }

    @Override // com.j256.ormlite.dao.Dao
    public <CT> CT callBatchTasks(Callable<CT> callable) {
        checkForInitialized();
        return (CT) this.statementExecutor.callBatchTasks(this.connectionSource, callable);
    }

    public void checkForInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void clearObjectCache() {
        ObjectCache objectCache = this.objectCache;
        if (objectCache != null) {
            objectCache.clear(this.dataClass);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void closeLastIterator() {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return iterator(-1);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void commit(DatabaseConnection databaseConnection) {
        databaseConnection.commit(null);
    }

    @Override // com.j256.ormlite.dao.Dao
    public long countOf() {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForCountStar(readOnlyConnection);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int create(T t) {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.create(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T createIfNotExists(T t) {
        if (t == null) {
            return null;
        }
        T queryForSameId = queryForSameId(t);
        if (queryForSameId == null) {
            create((BaseDaoImpl<T, ID>) t);
            return t;
        }
        return queryForSameId;
    }

    @Override // com.j256.ormlite.dao.Dao
    public Dao.CreateOrUpdateStatus createOrUpdate(T t) {
        if (t == null) {
            return new Dao.CreateOrUpdateStatus(false, false, 0);
        }
        ID extractId = extractId(t);
        if (extractId != null && idExists(extractId)) {
            return new Dao.CreateOrUpdateStatus(false, true, update((BaseDaoImpl<T, ID>) t));
        }
        return new Dao.CreateOrUpdateStatus(true, false, create((BaseDaoImpl<T, ID>) t));
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(T t) {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.delete(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public DeleteBuilder<T, ID> deleteBuilder() {
        checkForInitialized();
        return new DeleteBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public int deleteById(ID id) {
        checkForInitialized();
        if (id == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteById(readWriteConnection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int deleteIds(Collection<ID> collection) {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteIds(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void endThreadConnection(DatabaseConnection databaseConnection) {
        this.connectionSource.clearSpecialConnection(databaseConnection);
        this.connectionSource.releaseConnection(databaseConnection);
    }

    @Override // com.j256.ormlite.dao.Dao
    public int executeRaw(String str, String... strArr) {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.executeRaw(readWriteConnection, str, strArr);
            } catch (SQLException e2) {
                throw SqlExceptionUtil.create("Could not run raw execute statement " + str, e2);
            }
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int executeRawNoArgs(String str) {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.executeRawNoArgs(readWriteConnection, str);
            } catch (SQLException e2) {
                throw SqlExceptionUtil.create("Could not run raw execute statement " + str, e2);
            }
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public ID extractId(T t) {
        checkForInitialized();
        FieldType idField = this.tableInfo.getIdField();
        if (idField != null) {
            return (ID) idField.extractJavaFieldValue(t);
        }
        throw new SQLException("Class " + this.dataClass + " does not have an id field");
    }

    @Override // com.j256.ormlite.dao.Dao
    public FieldType findForeignFieldType(Class<?> cls) {
        FieldType[] fieldTypes;
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getType() == cls) {
                return fieldType;
            }
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.Dao
    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    @Override // com.j256.ormlite.dao.Dao
    public Class<T> getDataClass() {
        return this.dataClass;
    }

    @Override // com.j256.ormlite.dao.Dao
    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String str) {
        return makeEmptyForeignCollection(null, str);
    }

    @Override // com.j256.ormlite.dao.Dao
    public ObjectCache getObjectCache() {
        return this.objectCache;
    }

    public ObjectFactory<T> getObjectFactory() {
        return this.objectFactory;
    }

    @Override // com.j256.ormlite.dao.Dao
    public RawRowMapper<T> getRawRowMapper() {
        return this.statementExecutor.getRawRowMapper();
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRowMapper<T> getSelectStarRowMapper() {
        return this.statementExecutor.getSelectStarRowMapper();
    }

    public DatabaseTableConfig<T> getTableConfig() {
        return this.tableConfig;
    }

    public TableInfo<T, ID> getTableInfo() {
        return this.tableInfo;
    }

    @Override // com.j256.ormlite.dao.Dao
    public String getTableName() {
        return this.tableConfig.getTableName();
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableWrappedIterable<T> getWrappedIterable() {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.3
            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(-1);
                } catch (Exception e2) {
                    throw new IllegalStateException("Could not build iterator for " + BaseDaoImpl.this.dataClass, e2);
                }
            }

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return closeableIterator();
            }
        });
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean idExists(ID id) {
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.ifExists(readOnlyConnection, id);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public void initialize() {
        if (this.initialized) {
            return;
        }
        ConnectionSource connectionSource = this.connectionSource;
        if (connectionSource != null) {
            this.databaseType = connectionSource.getDatabaseType();
            if (this.databaseType != null) {
                DatabaseTableConfig<T> databaseTableConfig = this.tableConfig;
                if (databaseTableConfig == null) {
                    this.tableInfo = new TableInfo<>(this.connectionSource, this, this.dataClass);
                } else {
                    databaseTableConfig.extractFieldTypes(this.connectionSource);
                    this.tableInfo = new TableInfo<>(this.databaseType, this, this.tableConfig);
                }
                this.statementExecutor = new StatementExecutor<>(this.databaseType, this.tableInfo, this);
                List<BaseDaoImpl<?, ?>> list = daoConfigLevelLocal.get();
                list.add(this);
                if (list.size() > 1) {
                    return;
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    try {
                        BaseDaoImpl<?, ?> baseDaoImpl = list.get(i2);
                        DaoManager.registerDao(this.connectionSource, baseDaoImpl);
                        try {
                            for (FieldType fieldType : baseDaoImpl.getTableInfo().getFieldTypes()) {
                                fieldType.configDaoInformation(this.connectionSource, baseDaoImpl.getDataClass());
                            }
                            baseDaoImpl.initialized = true;
                        } catch (SQLException e2) {
                            DaoManager.unregisterDao(this.connectionSource, baseDaoImpl);
                            throw e2;
                        }
                    } finally {
                        list.clear();
                        daoConfigLevelLocal.remove();
                    }
                }
                return;
            }
            throw new IllegalStateException("connectionSource is getting a null DatabaseType in " + getClass().getSimpleName());
        }
        throw new IllegalStateException("connectionSource was never set on " + getClass().getSimpleName());
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isAutoCommit(DatabaseConnection databaseConnection) {
        return databaseConnection.isAutoCommit();
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isTableExists() {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return readOnlyConnection.isTableExists(this.tableInfo.getTableName());
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isUpdatable() {
        return this.tableInfo.isUpdatable();
    }

    @Override // com.j256.ormlite.dao.Dao
    public T mapSelectStarRow(DatabaseResults databaseResults) {
        return this.statementExecutor.getSelectStarRowMapper().mapRow(databaseResults);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void notifyChanges() {
        Map<Dao.DaoObserver, Object> map = this.daoObserverMap;
        if (map != null) {
            for (Dao.DaoObserver daoObserver : map.keySet()) {
                daoObserver.onChange();
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public String objectToString(T t) {
        checkForInitialized();
        return this.tableInfo.objectToString(t);
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean objectsEqual(T t, T t2) {
        FieldType[] fieldTypes;
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (!fieldType.getDataPersister().dataIsEqual(fieldType.extractJavaFieldValue(t), fieldType.extractJavaFieldValue(t2))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> query(PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        return this.statementExecutor.query(this.connectionSource, preparedQuery, this.objectCache);
    }

    @Override // com.j256.ormlite.dao.Dao
    public QueryBuilder<T, ID> queryBuilder() {
        checkForInitialized();
        return new QueryBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForAll() {
        checkForInitialized();
        return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForEq(String str, Object obj) {
        return queryBuilder().where().eq(str, obj).query();
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForFieldValues(Map<String, Object> map) {
        return queryForFieldValues(map, false);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForFieldValuesArgs(Map<String, Object> map) {
        return queryForFieldValues(map, true);
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForFirst(PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForFirst(readOnlyConnection, preparedQuery, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForId(ID id) {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.queryForId(readOnlyConnection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForMatching(T t) {
        return queryForMatching(t, false);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForMatchingArgs(T t) {
        return queryForMatching(t, true);
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForSameId(T t) {
        ID extractId;
        checkForInitialized();
        if (t == null || (extractId = extractId(t)) == null) {
            return null;
        }
        return queryForId(extractId);
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRawResults<String[]> queryRaw(String str, String... strArr) {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, strArr, this.objectCache);
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + str, e2);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long queryRawValue(String str, String... strArr) {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.queryForLong(readOnlyConnection, str, strArr);
            } catch (SQLException e2) {
                throw SqlExceptionUtil.create("Could not perform raw value query for " + str, e2);
            }
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int refresh(T t) {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.refresh(readOnlyConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void registerObserver(Dao.DaoObserver daoObserver) {
        if (this.daoObserverMap == null) {
            synchronized (this) {
                if (this.daoObserverMap == null) {
                    this.daoObserverMap = new ConcurrentHashMap();
                }
            }
        }
        this.daoObserverMap.put(daoObserver, constantObject);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void rollBack(DatabaseConnection databaseConnection) {
        databaseConnection.rollback(null);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setAutoCommit(DatabaseConnection databaseConnection, boolean z) {
        databaseConnection.setAutoCommit(z);
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectCache(boolean z) {
        if (z) {
            if (this.objectCache == null) {
                if (this.tableInfo.getIdField() != null) {
                    synchronized (BaseDaoImpl.class) {
                        if (defaultObjectCache == null) {
                            defaultObjectCache = ReferenceObjectCache.makeWeakCache();
                        }
                        this.objectCache = defaultObjectCache;
                    }
                    this.objectCache.registerClass(this.dataClass);
                    return;
                }
                throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
            }
            return;
        }
        ObjectCache objectCache = this.objectCache;
        if (objectCache != null) {
            objectCache.clear(this.dataClass);
            this.objectCache = null;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectFactory(ObjectFactory<T> objectFactory) {
        checkForInitialized();
        this.objectFactory = objectFactory;
    }

    public void setTableConfig(DatabaseTableConfig<T> databaseTableConfig) {
        this.tableConfig = databaseTableConfig;
    }

    @Override // com.j256.ormlite.dao.Dao
    public DatabaseConnection startThreadConnection() {
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        this.connectionSource.saveSpecialConnection(readWriteConnection);
        return readWriteConnection;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void unregisterObserver(Dao.DaoObserver daoObserver) {
        Map<Dao.DaoObserver, Object> map = this.daoObserverMap;
        if (map != null) {
            synchronized (map) {
                this.daoObserverMap.remove(daoObserver);
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int update(T t) {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.update(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public UpdateBuilder<T, ID> updateBuilder() {
        checkForInitialized();
        return new UpdateBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public int updateId(T t, ID id) {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.updateId(readWriteConnection, t, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int updateRaw(String str, String... strArr) {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            try {
                return this.statementExecutor.updateRaw(readWriteConnection, str, strArr);
            } catch (SQLException e2) {
                throw SqlExceptionUtil.create("Could not run raw update statement " + str, e2);
            }
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public BaseDaoImpl(ConnectionSource connectionSource, Class<T> cls) {
        this(connectionSource, cls, null);
    }

    public static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        return new BaseDaoImpl<T, ID>(connectionSource, databaseTableConfig) { // from class: com.j256.ormlite.dao.BaseDaoImpl.6
            @Override // com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.dao.Dao, java.lang.Iterable
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return super.iterator();
            }
        };
    }

    private List<T> queryForFieldValues(Map<String, Object> map, boolean z) {
        checkForInitialized();
        QueryBuilder<T, ID> queryBuilder = queryBuilder();
        Where<T, ID> where = queryBuilder.where();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (z) {
                value = new SelectArg(value);
            }
            where.eq(entry.getKey(), value);
        }
        if (map.size() == 0) {
            return Collections.emptyList();
        }
        where.and(map.size());
        return queryBuilder.query();
    }

    private List<T> queryForMatching(T t, boolean z) {
        FieldType[] fieldTypes;
        checkForInitialized();
        QueryBuilder<T, ID> queryBuilder = queryBuilder();
        Where<T, ID> where = queryBuilder.where();
        int i2 = 0;
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            Object fieldValueIfNotDefault = fieldType.getFieldValueIfNotDefault(t);
            if (fieldValueIfNotDefault != null) {
                if (z) {
                    fieldValueIfNotDefault = new SelectArg(fieldValueIfNotDefault);
                }
                where.eq(fieldType.getColumnName(), fieldValueIfNotDefault);
                i2++;
            }
        }
        if (i2 == 0) {
            return Collections.emptyList();
        }
        where.and(i2);
        return queryBuilder.query();
    }

    @Override // com.j256.ormlite.dao.Dao, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return iterator(-1);
    }

    public BaseDaoImpl(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        this(connectionSource, databaseTableConfig.getDataClass(), databaseTableConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloseableIterator<T> createIterator(PreparedQuery<T> preparedQuery, int i2) {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, preparedQuery, this.objectCache, i2);
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Could not build prepared-query iterator for " + this.dataClass, e2);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.4
            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(preparedQuery, -1);
                } catch (Exception e2) {
                    throw new IllegalStateException("Could not build prepared-query iterator for " + BaseDaoImpl.this.dataClass, e2);
                }
            }

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return closeableIterator();
            }
        });
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(int i2) {
        checkForInitialized();
        this.lastIterator = createIterator(i2);
        return this.lastIterator;
    }

    public BaseDaoImpl(ConnectionSource connectionSource, Class<T> cls, DatabaseTableConfig<T> databaseTableConfig) {
        this.dataClass = cls;
        this.tableConfig = databaseTableConfig;
        if (connectionSource != null) {
            this.connectionSource = connectionSource;
            initialize();
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <GR> GenericRawResults<GR> queryRaw(String str, RawRowMapper<GR> rawRowMapper, String... strArr) {
        checkForInitialized();
        try {
            return (GenericRawResults<GR>) this.statementExecutor.queryRaw(this.connectionSource, str, rawRowMapper, strArr, this.objectCache);
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + str, e2);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long countOf(PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        if (preparedQuery.getType() == StatementBuilder.StatementType.SELECT_LONG) {
            DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableInfo.getTableName());
            try {
                return this.statementExecutor.queryForLong(readOnlyConnection, preparedQuery);
            } finally {
                this.connectionSource.releaseConnection(readOnlyConnection);
            }
        }
        throw new IllegalArgumentException("Prepared query is not of type " + StatementBuilder.StatementType.SELECT_LONG + ", you need to call QueryBuilder.setCountOf(true)");
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(Collection<T> collection) {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.deleteObjects(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) {
        return iterator(preparedQuery, -1);
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i2) {
        checkForInitialized();
        this.lastIterator = createIterator(preparedQuery, i2);
        return this.lastIterator;
    }

    @Override // com.j256.ormlite.dao.Dao
    public <UO> GenericRawResults<UO> queryRaw(String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String... strArr) {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, rawRowObjectMapper, strArr, this.objectCache);
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + str, e2);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int create(final Collection<T> collection) {
        checkForInitialized();
        for (T t : collection) {
            if (t instanceof BaseDaoEnabled) {
                ((BaseDaoEnabled) t).setDao(this);
            }
        }
        final DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return ((Integer) callBatchTasks(new Callable<Integer>() { // from class: com.j256.ormlite.dao.BaseDaoImpl.2
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    int i2 = 0;
                    for (Object obj : collection) {
                        BaseDaoImpl baseDaoImpl = BaseDaoImpl.this;
                        i2 += baseDaoImpl.statementExecutor.create(readWriteConnection, obj, baseDaoImpl.objectCache);
                    }
                    return Integer.valueOf(i2);
                }
            })).intValue();
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int update(PreparedUpdate<T> preparedUpdate) {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.update(readWriteConnection, preparedUpdate);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(PreparedDelete<T> preparedDelete) {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection(this.tableInfo.getTableName());
        try {
            return this.statementExecutor.delete(readWriteConnection, preparedDelete);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr) {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, strArr, this.objectCache);
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + str, e2);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <UO> GenericRawResults<UO> queryRaw(String str, DatabaseResultsMapper<UO> databaseResultsMapper, String... strArr) {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, databaseResultsMapper, strArr, this.objectCache);
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + str, e2);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectCache(ObjectCache objectCache) {
        if (objectCache == null) {
            ObjectCache objectCache2 = this.objectCache;
            if (objectCache2 != null) {
                objectCache2.clear(this.dataClass);
                this.objectCache = null;
                return;
            }
            return;
        }
        ObjectCache objectCache3 = this.objectCache;
        if (objectCache3 != null && objectCache3 != objectCache) {
            objectCache3.clear(this.dataClass);
        }
        if (this.tableInfo.getIdField() != null) {
            this.objectCache = objectCache;
            this.objectCache.registerClass(this.dataClass);
            return;
        }
        throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
    }
}
