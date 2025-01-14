package com.j256.ormlite.misc;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.p134db.DatabaseType;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public interface JavaxPersistenceConfigurer {
    DatabaseFieldConfig createFieldConfig(DatabaseType databaseType, Field field);

    String getEntityName(Class<?> cls);
}
