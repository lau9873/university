package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
/* loaded from: classes.dex */
public abstract class BaseDaoEnabled<T, ID> {
    public transient Dao<T, ID> dao;

    private void checkForDao() {
        if (this.dao != null) {
            return;
        }
        throw new SQLException("Dao has not been set on " + BaseDaoEnabled.class + " object: " + this);
    }

    public int create() {
        checkForDao();
        return this.dao.create((Dao<T, ID>) this);
    }

    public int delete() {
        checkForDao();
        return this.dao.delete((Dao<T, ID>) this);
    }

    public ID extractId() {
        checkForDao();
        return this.dao.extractId(this);
    }

    public Dao<T, ID> getDao() {
        return this.dao;
    }

    public String objectToString() {
        try {
            checkForDao();
            return this.dao.objectToString(this);
        } catch (SQLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public boolean objectsEqual(T t) {
        checkForDao();
        return this.dao.objectsEqual(this, t);
    }

    public int refresh() {
        checkForDao();
        return this.dao.refresh(this);
    }

    public void setDao(Dao<T, ID> dao) {
        this.dao = dao;
    }

    public int update() {
        checkForDao();
        return this.dao.update((Dao<T, ID>) this);
    }

    public int updateId(ID id) {
        checkForDao();
        return this.dao.updateId(this, id);
    }
}
