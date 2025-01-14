package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public interface Dao<T, ID> extends CloseableIterable<T> {

    /* loaded from: classes.dex */
    public static class CreateOrUpdateStatus {
        public boolean created;
        public int numLinesChanged;
        public boolean updated;

        public CreateOrUpdateStatus(boolean z, boolean z2, int i) {
            this.created = z;
            this.updated = z2;
            this.numLinesChanged = i;
        }

        public int getNumLinesChanged() {
            return this.numLinesChanged;
        }

        public boolean isCreated() {
            return this.created;
        }

        public boolean isUpdated() {
            return this.updated;
        }
    }

    /* loaded from: classes.dex */
    public interface DaoObserver {
        void onChange();
    }

    void assignEmptyForeignCollection(T t, String str);

    <CT> CT callBatchTasks(Callable<CT> callable);

    void clearObjectCache();

    void closeLastIterator();

    void commit(DatabaseConnection databaseConnection);

    long countOf();

    long countOf(PreparedQuery<T> preparedQuery);

    int create(T t);

    int create(Collection<T> collection);

    T createIfNotExists(T t);

    CreateOrUpdateStatus createOrUpdate(T t);

    int delete(PreparedDelete<T> preparedDelete);

    int delete(T t);

    int delete(Collection<T> collection);

    DeleteBuilder<T, ID> deleteBuilder();

    int deleteById(ID id);

    int deleteIds(Collection<ID> collection);

    void endThreadConnection(DatabaseConnection databaseConnection);

    int executeRaw(String str, String... strArr);

    int executeRawNoArgs(String str);

    ID extractId(T t);

    FieldType findForeignFieldType(Class<?> cls);

    ConnectionSource getConnectionSource();

    Class<T> getDataClass();

    <FT> ForeignCollection<FT> getEmptyForeignCollection(String str);

    ObjectCache getObjectCache();

    RawRowMapper<T> getRawRowMapper();

    GenericRowMapper<T> getSelectStarRowMapper();

    String getTableName();

    CloseableWrappedIterable<T> getWrappedIterable();

    CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> preparedQuery);

    boolean idExists(ID id);

    boolean isAutoCommit(DatabaseConnection databaseConnection);

    boolean isTableExists();

    boolean isUpdatable();

    @Override // java.lang.Iterable
    CloseableIterator<T> iterator();

    CloseableIterator<T> iterator(int i);

    CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery);

    CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i);

    T mapSelectStarRow(DatabaseResults databaseResults);

    void notifyChanges();

    String objectToString(T t);

    boolean objectsEqual(T t, T t2);

    List<T> query(PreparedQuery<T> preparedQuery);

    QueryBuilder<T, ID> queryBuilder();

    List<T> queryForAll();

    List<T> queryForEq(String str, Object obj);

    List<T> queryForFieldValues(Map<String, Object> map);

    List<T> queryForFieldValuesArgs(Map<String, Object> map);

    T queryForFirst(PreparedQuery<T> preparedQuery);

    T queryForId(ID id);

    List<T> queryForMatching(T t);

    List<T> queryForMatchingArgs(T t);

    T queryForSameId(T t);

    <UO> GenericRawResults<UO> queryRaw(String str, DatabaseResultsMapper<UO> databaseResultsMapper, String... strArr);

    <UO> GenericRawResults<UO> queryRaw(String str, RawRowMapper<UO> rawRowMapper, String... strArr);

    <UO> GenericRawResults<UO> queryRaw(String str, DataType[] dataTypeArr, RawRowObjectMapper<UO> rawRowObjectMapper, String... strArr);

    GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr);

    GenericRawResults<String[]> queryRaw(String str, String... strArr);

    long queryRawValue(String str, String... strArr);

    int refresh(T t);

    void registerObserver(DaoObserver daoObserver);

    void rollBack(DatabaseConnection databaseConnection);

    void setAutoCommit(DatabaseConnection databaseConnection, boolean z);

    void setObjectCache(ObjectCache objectCache);

    void setObjectCache(boolean z);

    void setObjectFactory(ObjectFactory<T> objectFactory);

    DatabaseConnection startThreadConnection();

    void unregisterObserver(DaoObserver daoObserver);

    int update(PreparedUpdate<T> preparedUpdate);

    int update(T t);

    UpdateBuilder<T, ID> updateBuilder();

    int updateId(T t, ID id);

    int updateRaw(String str, String... strArr);
}
