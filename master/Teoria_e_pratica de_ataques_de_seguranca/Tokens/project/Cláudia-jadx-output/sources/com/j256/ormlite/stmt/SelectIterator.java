package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.io.IOException;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class SelectIterator<T, ID> implements CloseableIterator<T> {
    public static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
    public boolean alreadyMoved;
    public final Dao<T, ID> classDao;
    public boolean closed;
    public final CompiledStatement compiledStmt;
    public final DatabaseConnection connection;
    public final ConnectionSource connectionSource;
    public final Class<?> dataClass;
    public boolean first = true;
    public T last;
    public final DatabaseResults results;
    public int rowC;
    public final GenericRowMapper<T> rowMapper;
    public final String statement;

    public SelectIterator(Class<?> cls, Dao<T, ID> dao, GenericRowMapper<T> genericRowMapper, ConnectionSource connectionSource, DatabaseConnection databaseConnection, CompiledStatement compiledStatement, String str, ObjectCache objectCache) {
        this.dataClass = cls;
        this.classDao = dao;
        this.rowMapper = genericRowMapper;
        this.connectionSource = connectionSource;
        this.connection = databaseConnection;
        this.compiledStmt = compiledStatement;
        this.results = compiledStatement.runQuery(objectCache);
        this.statement = str;
        if (str != null) {
            logger.debug("starting iterator @{} for '{}'", Integer.valueOf(hashCode()), str);
        }
    }

    private T getCurrent() {
        this.last = this.rowMapper.mapRow(this.results);
        this.alreadyMoved = false;
        this.rowC++;
        return this.last;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.compiledStmt.close();
        this.closed = true;
        this.last = null;
        if (this.statement != null) {
            logger.debug("closed iterator @{} after {} rows", Integer.valueOf(hashCode()), Integer.valueOf(this.rowC));
        }
        try {
            this.connectionSource.releaseConnection(this.connection);
        } catch (SQLException e2) {
            throw new IOException("could not release connection", e2);
        }
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T current() {
        if (this.closed) {
            return null;
        }
        if (this.first) {
            return first();
        }
        return getCurrent();
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T first() {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.first()) {
            return getCurrent();
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public DatabaseResults getRawResults() {
        return this.results;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            return hasNextThrow();
        } catch (SQLException e2) {
            this.last = null;
            closeQuietly();
            throw new IllegalStateException("Errors getting more results of " + this.dataClass, e2);
        }
    }

    public boolean hasNextThrow() {
        boolean next;
        if (this.closed) {
            return false;
        }
        if (this.alreadyMoved) {
            return true;
        }
        if (this.first) {
            this.first = false;
            next = this.results.first();
        } else {
            next = this.results.next();
        }
        if (!next) {
            IOUtils.closeThrowSqlException(this, "iterator");
        }
        this.alreadyMoved = true;
        return next;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T moveRelative(int i2) {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.moveRelative(i2)) {
            return getCurrent();
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public void moveToNext() {
        this.last = null;
        this.first = false;
        this.alreadyMoved = false;
    }

    @Override // java.util.Iterator
    public T next() {
        T nextThrow;
        try {
            nextThrow = nextThrow();
        } catch (SQLException e2) {
            e = e2;
        }
        if (nextThrow != null) {
            return nextThrow;
        }
        e = null;
        this.last = null;
        closeQuietly();
        throw new IllegalStateException("Could not get next result for " + this.dataClass, e);
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T nextThrow() {
        boolean next;
        if (this.closed) {
            return null;
        }
        if (!this.alreadyMoved) {
            if (this.first) {
                this.first = false;
                next = this.results.first();
            } else {
                next = this.results.next();
            }
            if (!next) {
                this.first = false;
                return null;
            }
        }
        this.first = false;
        return getCurrent();
    }

    @Override // com.j256.ormlite.dao.CloseableIterator
    public T previous() {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.previous()) {
            return getCurrent();
        }
        return null;
    }

    @Override // java.util.Iterator
    public void remove() {
        try {
            removeThrow();
        } catch (SQLException e2) {
            closeQuietly();
            throw new IllegalStateException("Could not delete " + this.dataClass + " object " + this.last, e2);
        }
    }

    public void removeThrow() {
        T t = this.last;
        if (t != null) {
            Dao<T, ID> dao = this.classDao;
            if (dao != null) {
                try {
                    dao.delete((Dao<T, ID>) t);
                    return;
                } finally {
                    this.last = null;
                }
            }
            throw new IllegalStateException("Cannot remove " + this.dataClass + " object because classDao not initialized");
        }
        throw new IllegalStateException("No last " + this.dataClass + " object to remove. Must be called after a call to next.");
    }
}
