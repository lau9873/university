package com.j256.ormlite.support;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.lang.reflect.Constructor;
/* loaded from: classes.dex */
public class ReflectionDatabaseConnectionProxyFactory implements DatabaseConnectionProxyFactory {
    public final Constructor<? extends DatabaseConnection> constructor;
    public final Class<? extends DatabaseConnection> proxyClass;

    public ReflectionDatabaseConnectionProxyFactory(Class<? extends DatabaseConnection> cls) {
        this.proxyClass = cls;
        try {
            this.constructor = cls.getConstructor(DatabaseConnection.class);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find constructor with DatabaseConnection argument in " + cls);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnectionProxyFactory
    public DatabaseConnection createProxy(DatabaseConnection databaseConnection) {
        try {
            return this.constructor.newInstance(databaseConnection);
        } catch (Exception e2) {
            throw SqlExceptionUtil.create("Could not create a new instance of " + this.proxyClass, e2);
        }
    }
}
