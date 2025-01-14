package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    public static final long serialVersionUID = -5158840898186237589L;
    public final transient Dao<T, ID> dao;
    public final transient FieldType foreignFieldType;
    public final transient boolean orderAscending;
    public final transient String orderColumn;
    public final transient Object parent;
    public final transient Object parentId;
    public transient PreparedQuery<T> preparedQuery;

    public BaseForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        this.dao = dao;
        this.foreignFieldType = fieldType;
        this.parentId = obj2;
        this.orderColumn = str;
        this.orderAscending = z;
        this.parent = obj;
    }

    private boolean addElement(T t) {
        if (this.dao == null) {
            return false;
        }
        if (this.parent != null && this.foreignFieldType.getFieldValueIfNotDefault(t) == null) {
            this.foreignFieldType.assignField(t, this.parent, true, null);
        }
        this.dao.create((Dao<T, ID>) t);
        return true;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection, java.util.Collection
    public boolean add(T t) {
        try {
            return addElement(t);
        } catch (SQLException e) {
            throw new IllegalStateException("Could not create data element in dao", e);
        }
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (T t : collection) {
            try {
                if (addElement(t)) {
                    z = true;
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Could not create data elements in dao", e);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        if (this.dao == null) {
            return;
        }
        CloseableIterator<T> closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                closeableIterator.next();
                closeableIterator.remove();
            } finally {
                IOUtils.closeQuietly(closeableIterator);
            }
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public Dao<T, ?> getDao() {
        return (Dao<T, ID>) this.dao;
    }

    public PreparedQuery<T> getPreparedQuery() {
        if (this.dao == null) {
            return null;
        }
        if (this.preparedQuery == null) {
            SelectArg selectArg = new SelectArg();
            selectArg.setValue(this.parentId);
            QueryBuilder<T, ID> queryBuilder = this.dao.queryBuilder();
            String str = this.orderColumn;
            if (str != null) {
                queryBuilder.orderBy(str, this.orderAscending);
            }
            this.preparedQuery = queryBuilder.where().m4256eq(this.foreignFieldType.getColumnName(), selectArg).prepare();
            PreparedQuery<T> preparedQuery = this.preparedQuery;
            if (preparedQuery instanceof MappedPreparedStmt) {
                ((MappedPreparedStmt) preparedQuery).setParentInformation(this.parent, this.parentId);
            }
        }
        return this.preparedQuery;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refresh(T t) {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return 0;
        }
        return dao.refresh(t);
    }

    @Override // java.util.Collection
    public abstract boolean remove(Object obj);

    @Override // java.util.Collection
    public abstract boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        if (this.dao == null) {
            return false;
        }
        CloseableIterator<T> closeableIterator = closeableIterator();
        while (closeableIterator.hasNext()) {
            try {
                if (!collection.contains(closeableIterator.next())) {
                    closeableIterator.remove();
                    z = true;
                }
            } finally {
                IOUtils.closeQuietly(closeableIterator);
            }
        }
        return z;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int update(T t) {
        Dao<T, ID> dao = this.dao;
        if (dao == null) {
            return 0;
        }
        return dao.update((Dao<T, ID>) t);
    }
}
