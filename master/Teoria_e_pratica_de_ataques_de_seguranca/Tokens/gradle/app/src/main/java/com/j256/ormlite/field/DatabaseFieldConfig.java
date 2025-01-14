package com.j256.ormlite.field;

import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.p134db.DatabaseType;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public class DatabaseFieldConfig {
    public static final boolean DEFAULT_CAN_BE_NULL = true;
    public static final boolean DEFAULT_FOREIGN_COLLECTION_ORDER_ASCENDING = true;
    public static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
    public static final int NO_MAX_FOREIGN_AUTO_REFRESH_LEVEL_SPECIFIED = -1;
    public static JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    public boolean allowGeneratedIdInsert;
    public boolean canBeNull;
    public String columnDefinition;
    public String columnName;
    public DataPersister dataPersister;
    public DataType dataType;
    public String defaultValue;
    public String fieldName;
    public boolean foreign;
    public boolean foreignAutoCreate;
    public boolean foreignAutoRefresh;
    public boolean foreignCollection;
    public String foreignCollectionColumnName;
    public boolean foreignCollectionEager;
    public String foreignCollectionForeignFieldName;
    public int foreignCollectionMaxEagerLevel;
    public boolean foreignCollectionOrderAscending;
    public String foreignCollectionOrderColumnName;
    public String foreignColumnName;
    public DatabaseTableConfig<?> foreignTableConfig;
    public String format;
    public boolean generatedId;
    public String generatedIdSequence;

    /* renamed from: id */
    public boolean f6344id;
    public boolean index;
    public String indexName;
    public int maxForeignAutoRefreshLevel;
    public boolean persisted;
    public Class<? extends DataPersister> persisterClass;
    public boolean readOnly;
    public boolean throwIfNull;
    public boolean unique;
    public boolean uniqueCombo;
    public boolean uniqueIndex;
    public String uniqueIndexName;
    public Enum<?> unknownEnumValue;
    public boolean useGetSet;
    public boolean version;
    public int width;
    public static final Class<? extends DataPersister> DEFAULT_PERSISTER_CLASS = VoidType.class;
    public static final DataType DEFAULT_DATA_TYPE = DataType.UNKNOWN;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) Class.forName("com.j256.ormlite.misc.JavaxPersistenceImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseFieldConfig() {
        this.dataType = DEFAULT_DATA_TYPE;
        this.canBeNull = true;
        this.persisted = true;
        this.maxForeignAutoRefreshLevel = -1;
        this.persisterClass = DEFAULT_PERSISTER_CLASS;
        this.foreignCollectionMaxEagerLevel = 1;
        this.foreignCollectionOrderAscending = true;
    }

    public static Method findGetMethod(Field field, boolean z) {
        Method findMethodFromNames = Locale.ENGLISH.equals(Locale.getDefault()) ? findMethodFromNames(field, true, z, methodFromField(field, "get", null), methodFromField(field, "is", null)) : findMethodFromNames(field, true, z, methodFromField(field, "get", null), methodFromField(field, "get", Locale.ENGLISH), methodFromField(field, "is", null), methodFromField(field, "is", Locale.ENGLISH));
        if (findMethodFromNames == null) {
            return null;
        }
        if (findMethodFromNames.getReturnType() != field.getType()) {
            if (z) {
                throw new IllegalArgumentException("Return type of get method " + findMethodFromNames.getName() + " does not return " + field.getType());
            }
            return null;
        }
        return findMethodFromNames;
    }

    private String findIndexName(String str) {
        if (this.columnName == null) {
            return str + "_" + this.fieldName + "_idx";
        }
        return str + "_" + this.columnName + "_idx";
    }

    public static Enum<?> findMatchingEnumVal(Field field, String str) {
        Enum<?>[] enumArr;
        if (str == null || str.length() == 0) {
            return null;
        }
        for (Enum<?> r3 : (Enum[]) field.getType().getEnumConstants()) {
            if (r3.name().equals(str)) {
                return r3;
            }
        }
        throw new IllegalArgumentException("Unknwown enum unknown name " + str + " for field " + field);
    }

    public static Method findMethodFromNames(Field field, boolean z, boolean z2, String... strArr) {
        NoSuchMethodException noSuchMethodException = null;
        for (String str : strArr) {
            try {
                return z ? field.getDeclaringClass().getMethod(str, new Class[0]) : field.getDeclaringClass().getMethod(str, field.getType());
            } catch (NoSuchMethodException e) {
                if (noSuchMethodException == null) {
                    noSuchMethodException = e;
                }
            }
        }
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find appropriate ");
            sb.append(z ? "get" : "set");
            sb.append(" method for ");
            sb.append(field);
            throw new IllegalArgumentException(sb.toString(), noSuchMethodException);
        }
        return null;
    }

    public static Method findSetMethod(Field field, boolean z) {
        Method findMethodFromNames = Locale.ENGLISH.equals(Locale.getDefault()) ? findMethodFromNames(field, false, z, methodFromField(field, "set", null)) : findMethodFromNames(field, false, z, methodFromField(field, "set", null), methodFromField(field, "set", Locale.ENGLISH));
        if (findMethodFromNames == null) {
            return null;
        }
        if (findMethodFromNames.getReturnType() != Void.TYPE) {
            if (z) {
                throw new IllegalArgumentException("Return type of set method " + findMethodFromNames.getName() + " returns " + findMethodFromNames.getReturnType() + " instead of void");
            }
            return null;
        }
        return findMethodFromNames;
    }

    public static DatabaseFieldConfig fromDatabaseField(DatabaseType databaseType, String str, Field field, DatabaseField databaseField) {
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        databaseFieldConfig.fieldName = field.getName();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            databaseFieldConfig.fieldName = databaseType.upCaseEntityName(databaseFieldConfig.fieldName);
        }
        databaseFieldConfig.columnName = valueIfNotBlank(databaseField.columnName());
        databaseFieldConfig.dataType = databaseField.dataType();
        String defaultValue = databaseField.defaultValue();
        if (!defaultValue.equals(DatabaseField.DEFAULT_STRING)) {
            databaseFieldConfig.defaultValue = defaultValue;
        }
        databaseFieldConfig.width = databaseField.width();
        databaseFieldConfig.canBeNull = databaseField.canBeNull();
        databaseFieldConfig.f6344id = databaseField.m4257id();
        databaseFieldConfig.generatedId = databaseField.generatedId();
        databaseFieldConfig.generatedIdSequence = valueIfNotBlank(databaseField.generatedIdSequence());
        databaseFieldConfig.foreign = databaseField.foreign();
        databaseFieldConfig.useGetSet = databaseField.useGetSet();
        databaseFieldConfig.unknownEnumValue = findMatchingEnumVal(field, databaseField.unknownEnumName());
        databaseFieldConfig.throwIfNull = databaseField.throwIfNull();
        databaseFieldConfig.format = valueIfNotBlank(databaseField.format());
        databaseFieldConfig.unique = databaseField.unique();
        databaseFieldConfig.uniqueCombo = databaseField.uniqueCombo();
        databaseFieldConfig.index = databaseField.index();
        databaseFieldConfig.indexName = valueIfNotBlank(databaseField.indexName());
        databaseFieldConfig.uniqueIndex = databaseField.uniqueIndex();
        databaseFieldConfig.uniqueIndexName = valueIfNotBlank(databaseField.uniqueIndexName());
        databaseFieldConfig.foreignAutoRefresh = databaseField.foreignAutoRefresh();
        if (!databaseFieldConfig.foreignAutoRefresh && databaseField.maxForeignAutoRefreshLevel() == 2) {
            databaseFieldConfig.maxForeignAutoRefreshLevel = -1;
        } else {
            databaseFieldConfig.maxForeignAutoRefreshLevel = databaseField.maxForeignAutoRefreshLevel();
        }
        databaseFieldConfig.persisterClass = databaseField.persisterClass();
        databaseFieldConfig.allowGeneratedIdInsert = databaseField.allowGeneratedIdInsert();
        databaseFieldConfig.columnDefinition = valueIfNotBlank(databaseField.columnDefinition());
        databaseFieldConfig.foreignAutoCreate = databaseField.foreignAutoCreate();
        databaseFieldConfig.version = databaseField.version();
        databaseFieldConfig.foreignColumnName = valueIfNotBlank(databaseField.foreignColumnName());
        databaseFieldConfig.readOnly = databaseField.readOnly();
        return databaseFieldConfig;
    }

    public static DatabaseFieldConfig fromField(DatabaseType databaseType, String str, Field field) {
        DatabaseField databaseField = (DatabaseField) field.getAnnotation(DatabaseField.class);
        if (databaseField != null) {
            if (databaseField.persisted()) {
                return fromDatabaseField(databaseType, str, field, databaseField);
            }
            return null;
        }
        ForeignCollectionField foreignCollectionField = (ForeignCollectionField) field.getAnnotation(ForeignCollectionField.class);
        if (foreignCollectionField != null) {
            return fromForeignCollection(databaseType, field, foreignCollectionField);
        }
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2 = javaxPersistenceConfigurer;
        if (javaxPersistenceConfigurer2 == null) {
            return null;
        }
        return javaxPersistenceConfigurer2.createFieldConfig(databaseType, field);
    }

    public static DatabaseFieldConfig fromForeignCollection(DatabaseType databaseType, Field field, ForeignCollectionField foreignCollectionField) {
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        databaseFieldConfig.fieldName = field.getName();
        if (foreignCollectionField.columnName().length() > 0) {
            databaseFieldConfig.columnName = foreignCollectionField.columnName();
        }
        databaseFieldConfig.foreignCollection = true;
        databaseFieldConfig.foreignCollectionEager = foreignCollectionField.eager();
        databaseFieldConfig.foreignCollectionMaxEagerLevel = foreignCollectionField.maxEagerLevel();
        databaseFieldConfig.foreignCollectionOrderColumnName = valueIfNotBlank(foreignCollectionField.orderColumnName());
        databaseFieldConfig.foreignCollectionOrderAscending = foreignCollectionField.orderAscending();
        databaseFieldConfig.foreignCollectionColumnName = valueIfNotBlank(foreignCollectionField.columnName());
        databaseFieldConfig.foreignCollectionForeignFieldName = valueIfNotBlank(foreignCollectionField.foreignFieldName());
        return databaseFieldConfig;
    }

    public static String methodFromField(Field field, String str, Locale locale) {
        String upperCase;
        String name = field.getName();
        String substring = name.substring(0, 1);
        if (locale == null) {
            upperCase = substring.toUpperCase();
        } else {
            upperCase = substring.toUpperCase(locale);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(upperCase);
        sb.append((CharSequence) name, 1, name.length());
        return sb.toString();
    }

    public static String valueIfNotBlank(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public String getColumnDefinition() {
        return this.columnDefinition;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public DataPersister getDataPersister() {
        DataPersister dataPersister = this.dataPersister;
        return dataPersister == null ? this.dataType.getDataPersister() : dataPersister;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getForeignCollectionColumnName() {
        return this.foreignCollectionColumnName;
    }

    public String getForeignCollectionForeignFieldName() {
        return this.foreignCollectionForeignFieldName;
    }

    public int getForeignCollectionMaxEagerLevel() {
        return this.foreignCollectionMaxEagerLevel;
    }

    public String getForeignCollectionOrderColumnName() {
        return this.foreignCollectionOrderColumnName;
    }

    public String getForeignColumnName() {
        return this.foreignColumnName;
    }

    public DatabaseTableConfig<?> getForeignTableConfig() {
        return this.foreignTableConfig;
    }

    public String getFormat() {
        return this.format;
    }

    public String getGeneratedIdSequence() {
        return this.generatedIdSequence;
    }

    public String getIndexName(String str) {
        if (this.index && this.indexName == null) {
            this.indexName = findIndexName(str);
        }
        return this.indexName;
    }

    public int getMaxForeignAutoRefreshLevel() {
        if (this.foreignAutoRefresh) {
            return this.maxForeignAutoRefreshLevel;
        }
        return -1;
    }

    public Class<? extends DataPersister> getPersisterClass() {
        return this.persisterClass;
    }

    public String getUniqueIndexName(String str) {
        if (this.uniqueIndex && this.uniqueIndexName == null) {
            this.uniqueIndexName = findIndexName(str);
        }
        return this.uniqueIndexName;
    }

    public Enum<?> getUnknownEnumValue() {
        return this.unknownEnumValue;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAllowGeneratedIdInsert() {
        return this.allowGeneratedIdInsert;
    }

    public boolean isCanBeNull() {
        return this.canBeNull;
    }

    public boolean isForeign() {
        return this.foreign;
    }

    public boolean isForeignAutoCreate() {
        return this.foreignAutoCreate;
    }

    public boolean isForeignAutoRefresh() {
        return this.foreignAutoRefresh;
    }

    public boolean isForeignCollection() {
        return this.foreignCollection;
    }

    public boolean isForeignCollectionEager() {
        return this.foreignCollectionEager;
    }

    public boolean isForeignCollectionOrderAscending() {
        return this.foreignCollectionOrderAscending;
    }

    public boolean isGeneratedId() {
        return this.generatedId;
    }

    public boolean isId() {
        return this.f6344id;
    }

    public boolean isIndex() {
        return this.index;
    }

    public boolean isPersisted() {
        return this.persisted;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public boolean isThrowIfNull() {
        return this.throwIfNull;
    }

    public boolean isUnique() {
        return this.unique;
    }

    public boolean isUniqueCombo() {
        return this.uniqueCombo;
    }

    public boolean isUniqueIndex() {
        return this.uniqueIndex;
    }

    public boolean isUseGetSet() {
        return this.useGetSet;
    }

    public boolean isVersion() {
        return this.version;
    }

    public void postProcess() {
        if (this.foreignColumnName != null) {
            this.foreignAutoRefresh = true;
        }
        if (this.foreignAutoRefresh && this.maxForeignAutoRefreshLevel == -1) {
            this.maxForeignAutoRefreshLevel = 2;
        }
    }

    public void setAllowGeneratedIdInsert(boolean z) {
        this.allowGeneratedIdInsert = z;
    }

    public void setCanBeNull(boolean z) {
        this.canBeNull = z;
    }

    public void setColumnDefinition(String str) {
        this.columnDefinition = str;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public void setDataPersister(DataPersister dataPersister) {
        this.dataPersister = dataPersister;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setForeign(boolean z) {
        this.foreign = z;
    }

    public void setForeignAutoCreate(boolean z) {
        this.foreignAutoCreate = z;
    }

    public void setForeignAutoRefresh(boolean z) {
        this.foreignAutoRefresh = z;
    }

    public void setForeignCollection(boolean z) {
        this.foreignCollection = z;
    }

    public void setForeignCollectionColumnName(String str) {
        this.foreignCollectionColumnName = str;
    }

    public void setForeignCollectionEager(boolean z) {
        this.foreignCollectionEager = z;
    }

    public void setForeignCollectionForeignFieldName(String str) {
        this.foreignCollectionForeignFieldName = str;
    }

    public void setForeignCollectionMaxEagerLevel(int i) {
        this.foreignCollectionMaxEagerLevel = i;
    }

    public void setForeignCollectionOrderAscending(boolean z) {
        this.foreignCollectionOrderAscending = z;
    }

    public void setForeignCollectionOrderColumnName(String str) {
        this.foreignCollectionOrderColumnName = str;
    }

    public void setForeignColumnName(String str) {
        this.foreignColumnName = str;
    }

    public void setForeignTableConfig(DatabaseTableConfig<?> databaseTableConfig) {
        this.foreignTableConfig = databaseTableConfig;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setGeneratedId(boolean z) {
        this.generatedId = z;
    }

    public void setGeneratedIdSequence(String str) {
        this.generatedIdSequence = str;
    }

    public void setId(boolean z) {
        this.f6344id = z;
    }

    public void setIndex(boolean z) {
        this.index = z;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public void setMaxForeignAutoRefreshLevel(int i) {
        this.maxForeignAutoRefreshLevel = i;
    }

    public void setPersisted(boolean z) {
        this.persisted = z;
    }

    public void setPersisterClass(Class<? extends DataPersister> cls) {
        this.persisterClass = cls;
    }

    public void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public void setThrowIfNull(boolean z) {
        this.throwIfNull = z;
    }

    public void setUnique(boolean z) {
        this.unique = z;
    }

    public void setUniqueCombo(boolean z) {
        this.uniqueCombo = z;
    }

    public void setUniqueIndex(boolean z) {
        this.uniqueIndex = z;
    }

    public void setUniqueIndexName(String str) {
        this.uniqueIndexName = str;
    }

    public void setUnknownEnumValue(Enum<?> r1) {
        this.unknownEnumValue = r1;
    }

    public void setUseGetSet(boolean z) {
        this.useGetSet = z;
    }

    public void setVersion(boolean z) {
        this.version = z;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public DatabaseFieldConfig(String str) {
        this.dataType = DEFAULT_DATA_TYPE;
        this.canBeNull = true;
        this.persisted = true;
        this.maxForeignAutoRefreshLevel = -1;
        this.persisterClass = DEFAULT_PERSISTER_CLASS;
        this.foreignCollectionMaxEagerLevel = 1;
        this.foreignCollectionOrderAscending = true;
        this.fieldName = str;
    }

    public DatabaseFieldConfig(String str, String str2, DataType dataType, String str3, int i, boolean z, boolean z2, boolean z3, String str4, boolean z4, DatabaseTableConfig<?> databaseTableConfig, boolean z5, Enum<?> r16, boolean z6, String str5, boolean z7, String str6, String str7, boolean z8, int i2, int i3) {
        this.dataType = DEFAULT_DATA_TYPE;
        this.canBeNull = true;
        this.persisted = true;
        this.maxForeignAutoRefreshLevel = -1;
        this.persisterClass = DEFAULT_PERSISTER_CLASS;
        this.foreignCollectionMaxEagerLevel = 1;
        this.foreignCollectionOrderAscending = true;
        this.fieldName = str;
        this.columnName = str2;
        this.dataType = dataType;
        this.defaultValue = str3;
        this.width = i;
        this.canBeNull = z;
        this.f6344id = z2;
        this.generatedId = z3;
        this.generatedIdSequence = str4;
        this.foreign = z4;
        this.foreignTableConfig = databaseTableConfig;
        this.useGetSet = z5;
        this.unknownEnumValue = r16;
        this.throwIfNull = z6;
        this.format = str5;
        this.unique = z7;
        this.indexName = str6;
        this.uniqueIndexName = str7;
        this.foreignAutoRefresh = z8;
        this.maxForeignAutoRefreshLevel = i2;
        this.foreignCollectionMaxEagerLevel = i3;
    }
}
