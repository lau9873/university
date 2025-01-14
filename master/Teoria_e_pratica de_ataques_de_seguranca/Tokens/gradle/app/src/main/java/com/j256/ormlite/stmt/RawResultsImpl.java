package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RawResultsImpl<T> implements GenericRawResults<T> {
    public final String[] columnNames;
    public SelectIterator<T, Void> iterator;

    public RawResultsImpl(ConnectionSource connectionSource, DatabaseConnection databaseConnection, String str, Class<?> cls, CompiledStatement compiledStatement, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) {
        this.iterator = new SelectIterator<>(cls, null, genericRowMapper, connectionSource, databaseConnection, compiledStatement, str, objectCache);
        this.columnNames = this.iterator.getRawResults().getColumnNames();
    }

    @Override // com.j256.ormlite.dao.GenericRawResults, com.j256.ormlite.dao.CloseableWrappedIterable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SelectIterator<T, Void> selectIterator = this.iterator;
        if (selectIterator != null) {
            selectIterator.close();
            this.iterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return this.iterator;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public T getFirstResult() {
        try {
            if (this.iterator.hasNextThrow()) {
                return this.iterator.nextThrow();
            }
            return null;
        } finally {
            IOUtils.closeThrowSqlException(this, "raw results iterator");
        }
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public int getNumberColumns() {
        return this.columnNames.length;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public List<T> getResults() {
        ArrayList arrayList = new ArrayList();
        while (this.iterator.hasNext()) {
            try {
                arrayList.add(this.iterator.next());
            } finally {
                IOUtils.closeThrowSqlException(this, "raw results iterator");
            }
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return this.iterator;
    }
}
