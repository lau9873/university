package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p134db.DatabaseType;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public class FieldType {
    public static boolean DEFAULT_VALUE_BOOLEAN = false;
    public static byte DEFAULT_VALUE_BYTE = 0;
    public static char DEFAULT_VALUE_CHAR = 0;
    public static double DEFAULT_VALUE_DOUBLE = 0.0d;
    public static float DEFAULT_VALUE_FLOAT = 0.0f;
    public static int DEFAULT_VALUE_INT = 0;
    public static long DEFAULT_VALUE_LONG = 0;
    public static short DEFAULT_VALUE_SHORT = 0;
    public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
    public final String columnName;
    public final ConnectionSource connectionSource;
    public DataPersister dataPersister;
    public Object dataTypeConfigObj;
    public Object defaultValue;
    public final Field field;
    public final DatabaseFieldConfig fieldConfig;
    public FieldConverter fieldConverter;
    public final Method fieldGetMethod;
    public final Method fieldSetMethod;
    public BaseDaoImpl<?, ?> foreignDao;
    public FieldType foreignFieldType;
    public FieldType foreignIdField;
    public FieldType foreignRefField;
    public TableInfo<?, ?> foreignTableInfo;
    public final String generatedIdSequence;
    public final boolean isGeneratedId;
    public final boolean isId;
    public MappedQueryForFieldEq<Object, Object> mappedQueryForForeignField;
    public final Class<?> parentClass;
    public final String tableName;
    public static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal<>();
    public static final Logger logger = LoggerFactory.getLogger(FieldType.class);

    /* loaded from: classes.dex */
    public static class LevelCounters {
        public int autoRefreshLevel;
        public int autoRefreshLevelMax;
        public int foreignCollectionLevel;
        public int foreignCollectionLevelMax;

        public LevelCounters() {
        }
    }

    public FieldType(ConnectionSource connectionSource, String str, Field field, DatabaseFieldConfig databaseFieldConfig, Class<?> cls) {
        DataPersister dataPersister;
        String str2;
        this.connectionSource = connectionSource;
        this.tableName = str;
        DatabaseType databaseType = connectionSource.getDatabaseType();
        this.field = field;
        this.parentClass = cls;
        databaseFieldConfig.postProcess();
        Class<?> type = field.getType();
        if (databaseFieldConfig.getDataPersister() == null) {
            Class<? extends DataPersister> persisterClass = databaseFieldConfig.getPersisterClass();
            if (persisterClass != null && persisterClass != VoidType.class) {
                try {
                    try {
                        Object invoke = persisterClass.getDeclaredMethod("getSingleton", new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null) {
                            try {
                                dataPersister = (DataPersister) invoke;
                            } catch (Exception e) {
                                throw SqlExceptionUtil.create("Could not cast result of static getSingleton method to DataPersister from class " + persisterClass, e);
                            }
                        } else {
                            throw new SQLException("Static getSingleton method should not return null on class " + persisterClass);
                        }
                    } catch (InvocationTargetException e2) {
                        throw SqlExceptionUtil.create("Could not run getSingleton method on class " + persisterClass, e2.getTargetException());
                    } catch (Exception e3) {
                        throw SqlExceptionUtil.create("Could not run getSingleton method on class " + persisterClass, e3);
                    }
                } catch (Exception e4) {
                    throw SqlExceptionUtil.create("Could not find getSingleton static method on class " + persisterClass, e4);
                }
            } else {
                dataPersister = DataPersisterManager.lookupForField(field);
            }
        } else {
            dataPersister = databaseFieldConfig.getDataPersister();
            if (!dataPersister.isValidForField(field)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Field class ");
                sb.append(type.getName());
                sb.append(" for field ");
                sb.append(this);
                sb.append(" is not valid for type ");
                sb.append(dataPersister);
                Class<?> primaryClass = dataPersister.getPrimaryClass();
                if (primaryClass != null) {
                    sb.append(", maybe should be " + primaryClass);
                }
                throw new IllegalArgumentException(sb.toString());
            }
        }
        String foreignColumnName = databaseFieldConfig.getForeignColumnName();
        String name = field.getName();
        if (!databaseFieldConfig.isForeign() && !databaseFieldConfig.isForeignAutoRefresh() && foreignColumnName == null) {
            if (databaseFieldConfig.isForeignCollection()) {
                if (type != Collection.class && !ForeignCollection.class.isAssignableFrom(type)) {
                    throw new SQLException("Field class for '" + field.getName() + "' must be of class " + ForeignCollection.class.getSimpleName() + " or Collection.");
                }
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    if (((ParameterizedType) genericType).getActualTypeArguments().length == 0) {
                        throw new SQLException("Field class for '" + field.getName() + "' must be a parameterized Collection with at least 1 type.");
                    }
                } else {
                    throw new SQLException("Field class for '" + field.getName() + "' must be a parameterized Collection.");
                }
            } else if (dataPersister == null && !databaseFieldConfig.isForeignCollection()) {
                if (!byte[].class.isAssignableFrom(type)) {
                    if (Serializable.class.isAssignableFrom(type)) {
                        throw new SQLException("ORMLite does not know how to store " + type + " for field '" + field.getName() + "'.  Use another class, custom persister, or to serialize it use dataType=DataType.SERIALIZABLE");
                    }
                    throw new IllegalArgumentException("ORMLite does not know how to store " + type + " for field " + field.getName() + ". Use another class or a custom persister.");
                }
                throw new SQLException("ORMLite does not know how to store " + type + " for field '" + field.getName() + "'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE");
            }
        } else if (dataPersister != null && dataPersister.isPrimitive()) {
            throw new IllegalArgumentException("Field " + this + " is a primitive class " + type + " but marked as foreign");
        } else {
            if (foreignColumnName == null) {
                str2 = name + FOREIGN_ID_FIELD_SUFFIX;
            } else {
                str2 = name + "_" + foreignColumnName;
            }
            name = str2;
            if (ForeignCollection.class.isAssignableFrom(type)) {
                throw new SQLException("Field '" + field.getName() + "' in class " + type + "' should use the @" + ForeignCollectionField.class.getSimpleName() + " annotation not foreign=true");
            }
        }
        if (databaseFieldConfig.getColumnName() == null) {
            this.columnName = name;
        } else {
            this.columnName = databaseFieldConfig.getColumnName();
        }
        this.fieldConfig = databaseFieldConfig;
        if (databaseFieldConfig.isId()) {
            if (!databaseFieldConfig.isGeneratedId() && databaseFieldConfig.getGeneratedIdSequence() == null) {
                this.isId = true;
                this.isGeneratedId = false;
                this.generatedIdSequence = null;
            } else {
                throw new IllegalArgumentException("Must specify one of id, generatedId, and generatedIdSequence with " + field.getName());
            }
        } else if (databaseFieldConfig.isGeneratedId()) {
            if (databaseFieldConfig.getGeneratedIdSequence() == null) {
                this.isId = true;
                this.isGeneratedId = true;
                if (databaseType.isIdSequenceNeeded()) {
                    this.generatedIdSequence = databaseType.generateIdSequenceName(str, this);
                } else {
                    this.generatedIdSequence = null;
                }
            } else {
                throw new IllegalArgumentException("Must specify one of id, generatedId, and generatedIdSequence with " + field.getName());
            }
        } else if (databaseFieldConfig.getGeneratedIdSequence() != null) {
            this.isId = true;
            this.isGeneratedId = true;
            String generatedIdSequence = databaseFieldConfig.getGeneratedIdSequence();
            this.generatedIdSequence = databaseType.isEntityNamesMustBeUpCase() ? databaseType.upCaseEntityName(generatedIdSequence) : generatedIdSequence;
        } else {
            this.isId = false;
            this.isGeneratedId = false;
            this.generatedIdSequence = null;
        }
        if (this.isId && (databaseFieldConfig.isForeign() || databaseFieldConfig.isForeignAutoRefresh())) {
            throw new IllegalArgumentException("Id field " + field.getName() + " cannot also be a foreign object");
        }
        if (databaseFieldConfig.isUseGetSet()) {
            this.fieldGetMethod = DatabaseFieldConfig.findGetMethod(field, true);
            this.fieldSetMethod = DatabaseFieldConfig.findSetMethod(field, true);
        } else {
            if (!field.isAccessible()) {
                try {
                    this.field.setAccessible(true);
                } catch (SecurityException unused) {
                    throw new IllegalArgumentException("Could not open access to field " + field.getName() + ".  You may have to set useGetSet=true to fix.");
                }
            }
            this.fieldGetMethod = null;
            this.fieldSetMethod = null;
        }
        if (databaseFieldConfig.isAllowGeneratedIdInsert() && !databaseFieldConfig.isGeneratedId()) {
            throw new IllegalArgumentException("Field " + field.getName() + " must be a generated-id if allowGeneratedIdInsert = true");
        } else if (databaseFieldConfig.isForeignAutoRefresh() && !databaseFieldConfig.isForeign()) {
            throw new IllegalArgumentException("Field " + field.getName() + " must have foreign = true if foreignAutoRefresh = true");
        } else if (databaseFieldConfig.isForeignAutoCreate() && !databaseFieldConfig.isForeign()) {
            throw new IllegalArgumentException("Field " + field.getName() + " must have foreign = true if foreignAutoCreate = true");
        } else if (databaseFieldConfig.getForeignColumnName() != null && !databaseFieldConfig.isForeign()) {
            throw new IllegalArgumentException("Field " + field.getName() + " must have foreign = true if foreignColumnName is set");
        } else if (databaseFieldConfig.isVersion() && (dataPersister == null || !dataPersister.isValidForVersion())) {
            throw new IllegalArgumentException("Field " + field.getName() + " is not a valid type to be a version field");
        } else {
            assignDataType(databaseType, dataPersister);
        }
    }

    private void assignDataType(DatabaseType databaseType, DataPersister dataPersister) {
        DataType[] values;
        DataPersister dataPersister2 = databaseType.getDataPersister(dataPersister, this);
        this.dataPersister = dataPersister2;
        if (dataPersister2 == null) {
            if (this.fieldConfig.isForeign() || this.fieldConfig.isForeignCollection()) {
                return;
            }
            throw new SQLException("Data persister for field " + this + " is null but the field is not a foreign or foreignCollection");
        }
        this.fieldConverter = databaseType.getFieldConverter(dataPersister2, this);
        if (this.isGeneratedId && !dataPersister2.isValidGeneratedType()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Generated-id field '");
            sb.append(this.field.getName());
            sb.append("' in ");
            sb.append(this.field.getDeclaringClass().getSimpleName());
            sb.append(" can't be type ");
            sb.append(dataPersister2.getSqlType());
            sb.append(".  Must be one of: ");
            for (DataType dataType : DataType.values()) {
                DataPersister dataPersister3 = dataType.getDataPersister();
                if (dataPersister3 != null && dataPersister3.isValidGeneratedType()) {
                    sb.append(dataType);
                    sb.append(' ');
                }
            }
            throw new IllegalArgumentException(sb.toString());
        } else if (this.fieldConfig.isThrowIfNull() && !dataPersister2.isPrimitive()) {
            throw new SQLException("Field " + this.field.getName() + " must be a primitive if set with throwIfNull");
        } else if (this.isId && !dataPersister2.isAppropriateId()) {
            throw new SQLException("Field '" + this.field.getName() + "' is of data type " + dataPersister2 + " which cannot be the ID field");
        } else {
            this.dataTypeConfigObj = dataPersister2.makeConfigObject(this);
            String defaultValue = this.fieldConfig.getDefaultValue();
            if (defaultValue == null) {
                this.defaultValue = null;
            } else if (!this.isGeneratedId) {
                this.defaultValue = this.fieldConverter.parseDefaultString(this, defaultValue);
            } else {
                throw new SQLException("Field '" + this.field.getName() + "' cannot be a generatedId and have a default value '" + defaultValue + "'");
            }
        }
    }

    public static FieldType createFieldType(ConnectionSource connectionSource, String str, Field field, Class<?> cls) {
        DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(connectionSource.getDatabaseType(), str, field);
        if (fromField == null) {
            return null;
        }
        return new FieldType(connectionSource, str, field, fromField, cls);
    }

    private Object createForeignObject(Object obj, ObjectCache objectCache) {
        LevelCounters levelCounters = threadLevelCounters.get();
        if (levelCounters == null) {
            if (!this.fieldConfig.isForeignAutoRefresh()) {
                return createForeignShell(obj, objectCache);
            }
            levelCounters = new LevelCounters();
            threadLevelCounters.set(levelCounters);
        }
        if (levelCounters.autoRefreshLevel == 0) {
            if (!this.fieldConfig.isForeignAutoRefresh()) {
                return createForeignShell(obj, objectCache);
            }
            levelCounters.autoRefreshLevelMax = this.fieldConfig.getMaxForeignAutoRefreshLevel();
        }
        if (levelCounters.autoRefreshLevel >= levelCounters.autoRefreshLevelMax) {
            return createForeignShell(obj, objectCache);
        }
        if (this.mappedQueryForForeignField == null) {
            this.mappedQueryForForeignField = MappedQueryForFieldEq.build(this.connectionSource.getDatabaseType(), this.foreignDao.getTableInfo(), this.foreignIdField);
        }
        levelCounters.autoRefreshLevel++;
        try {
            DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableName);
            Object execute = this.mappedQueryForForeignField.execute(readOnlyConnection, obj, objectCache);
            this.connectionSource.releaseConnection(readOnlyConnection);
            return execute;
        } finally {
            levelCounters.autoRefreshLevel--;
            if (levelCounters.autoRefreshLevel <= 0) {
                threadLevelCounters.remove();
            }
        }
    }

    private Object createForeignShell(Object obj, ObjectCache objectCache) {
        Object createObject = this.foreignTableInfo.createObject();
        this.foreignIdField.assignField(createObject, obj, false, objectCache);
        return createObject;
    }

    private FieldType findForeignFieldType(Class<?> cls, Class<?> cls2, BaseDaoImpl<?, ?> baseDaoImpl) {
        FieldType[] fieldTypes;
        String foreignCollectionForeignFieldName = this.fieldConfig.getForeignCollectionForeignFieldName();
        for (FieldType fieldType : baseDaoImpl.getTableInfo().getFieldTypes()) {
            if (fieldType.getType() == cls2 && (foreignCollectionForeignFieldName == null || fieldType.getField().getName().equals(foreignCollectionForeignFieldName))) {
                if (fieldType.fieldConfig.isForeign() || fieldType.fieldConfig.isForeignAutoRefresh()) {
                    return fieldType;
                }
                throw new SQLException("Foreign collection object " + cls + " for field '" + this.field.getName() + "' contains a field of class " + cls2 + " but it's not foreign");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Foreign collection class ");
        sb.append(cls.getName());
        sb.append(" for field '");
        sb.append(this.field.getName());
        sb.append("' column-name does not contain a foreign field");
        if (foreignCollectionForeignFieldName != null) {
            sb.append(" named '");
            sb.append(foreignCollectionForeignFieldName);
            sb.append('\'');
        }
        sb.append(" of class ");
        sb.append(cls2.getName());
        throw new SQLException(sb.toString());
    }

    private boolean isFieldValueDefault(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj.equals(getJavaDefaultValueDefault());
    }

    public void assignField(Object obj, Object obj2, boolean z, ObjectCache objectCache) {
        if (logger.isLevelEnabled(Log.Level.TRACE)) {
            logger.trace("assiging from data {}, val {}: {}", obj == null ? "null" : obj.getClass(), obj2 != null ? obj2.getClass() : "null", obj2);
        }
        if (this.foreignRefField != null && obj2 != null) {
            Object extractJavaFieldValue = extractJavaFieldValue(obj);
            if (extractJavaFieldValue != null && extractJavaFieldValue.equals(obj2)) {
                return;
            }
            ObjectCache objectCache2 = this.foreignDao.getObjectCache();
            Object obj3 = objectCache2 == null ? null : objectCache2.get(getType(), obj2);
            if (obj3 != null) {
                obj2 = obj3;
            } else if (!z) {
                obj2 = createForeignObject(obj2, objectCache);
            }
        }
        Method method = this.fieldSetMethod;
        if (method == null) {
            try {
                this.field.set(obj, obj2);
                return;
            } catch (IllegalAccessException e) {
                throw SqlExceptionUtil.create("Could not assign object '" + obj2 + "' of type " + obj2.getClass() + "' to field " + this, e);
            } catch (IllegalArgumentException e2) {
                throw SqlExceptionUtil.create("Could not assign object '" + obj2 + "' of type " + obj2.getClass() + " to field " + this, e2);
            }
        }
        try {
            method.invoke(obj, obj2);
        } catch (Exception e3) {
            throw SqlExceptionUtil.create("Could not call " + this.fieldSetMethod + " on object with '" + obj2 + "' for " + this, e3);
        }
    }

    public Object assignIdValue(Object obj, Number number, ObjectCache objectCache) {
        Object convertIdNumber = this.dataPersister.convertIdNumber(number);
        if (convertIdNumber != null) {
            assignField(obj, convertIdNumber, false, objectCache);
            return convertIdNumber;
        }
        throw new SQLException("Invalid class " + this.dataPersister + " for sequence-id " + this);
    }

    public <FT, FID> BaseForeignCollection<FT, FID> buildForeignCollection(Object obj, FID fid) {
        if (this.foreignFieldType == null) {
            return null;
        }
        BaseDaoImpl<?, ?> baseDaoImpl = this.foreignDao;
        if (!this.fieldConfig.isForeignCollectionEager()) {
            return new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
        }
        LevelCounters levelCounters = threadLevelCounters.get();
        if (levelCounters == null) {
            if (this.fieldConfig.getForeignCollectionMaxEagerLevel() == 0) {
                return new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
            }
            levelCounters = new LevelCounters();
            threadLevelCounters.set(levelCounters);
        }
        if (levelCounters.foreignCollectionLevel == 0) {
            levelCounters.foreignCollectionLevelMax = this.fieldConfig.getForeignCollectionMaxEagerLevel();
        }
        int i = levelCounters.foreignCollectionLevel;
        if (i >= levelCounters.foreignCollectionLevelMax) {
            return new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
        }
        levelCounters.foreignCollectionLevel = i + 1;
        try {
            return new EagerForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
        } finally {
            levelCounters.foreignCollectionLevel--;
        }
    }

    public void configDaoInformation(ConnectionSource connectionSource, Class<?> cls) {
        BaseDaoImpl<?, ?> baseDaoImpl;
        TableInfo<?, ?> tableInfo;
        FieldType idField;
        FieldType fieldTypeByColumnName;
        BaseDaoImpl<?, ?> baseDaoImpl2;
        FieldType fieldType;
        BaseDaoImpl<?, ?> baseDaoImpl3;
        BaseDaoImpl<?, ?> baseDaoImpl4;
        Class<?> type = this.field.getType();
        DatabaseType databaseType = connectionSource.getDatabaseType();
        String foreignColumnName = this.fieldConfig.getForeignColumnName();
        MappedQueryForFieldEq<Object, Object> mappedQueryForFieldEq = null;
        if (!this.fieldConfig.isForeignAutoRefresh() && foreignColumnName == null) {
            if (this.fieldConfig.isForeign()) {
                DataPersister dataPersister = this.dataPersister;
                if (dataPersister != null && dataPersister.isPrimitive()) {
                    throw new IllegalArgumentException("Field " + this + " is a primitive class " + type + " but marked as foreign");
                }
                DatabaseTableConfig<?> foreignTableConfig = this.fieldConfig.getForeignTableConfig();
                if (foreignTableConfig != null) {
                    foreignTableConfig.extractFieldTypes(connectionSource);
                    baseDaoImpl4 = (BaseDaoImpl) DaoManager.createDao(connectionSource, foreignTableConfig);
                } else {
                    baseDaoImpl4 = (BaseDaoImpl) DaoManager.createDao(connectionSource, type);
                }
                tableInfo = baseDaoImpl4.getTableInfo();
                idField = tableInfo.getIdField();
                if (idField != null) {
                    if (isForeignAutoCreate() && !idField.isGeneratedId()) {
                        throw new IllegalArgumentException("Field " + this.field.getName() + ", if foreignAutoCreate = true then class " + type.getSimpleName() + " must have id field with generatedId = true");
                    }
                    baseDaoImpl2 = baseDaoImpl4;
                    fieldTypeByColumnName = idField;
                    fieldType = null;
                } else {
                    throw new IllegalArgumentException("Foreign field " + type + " does not have id field");
                }
            } else {
                if (!this.fieldConfig.isForeignCollection()) {
                    fieldType = null;
                    tableInfo = null;
                    baseDaoImpl2 = null;
                    idField = null;
                } else if (type != Collection.class && !ForeignCollection.class.isAssignableFrom(type)) {
                    throw new SQLException("Field class for '" + this.field.getName() + "' must be of class " + ForeignCollection.class.getSimpleName() + " or Collection.");
                } else {
                    Type genericType = this.field.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                        if (actualTypeArguments.length != 0) {
                            if (actualTypeArguments[0] instanceof TypeVariable) {
                                actualTypeArguments = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();
                            }
                            if (actualTypeArguments[0] instanceof Class) {
                                Class<?> cls2 = (Class) actualTypeArguments[0];
                                DatabaseTableConfig<?> foreignTableConfig2 = this.fieldConfig.getForeignTableConfig();
                                if (foreignTableConfig2 == null) {
                                    baseDaoImpl3 = (BaseDaoImpl) DaoManager.createDao(connectionSource, cls2);
                                } else {
                                    baseDaoImpl3 = (BaseDaoImpl) DaoManager.createDao(connectionSource, foreignTableConfig2);
                                }
                                FieldType findForeignFieldType = findForeignFieldType(cls2, cls, baseDaoImpl3);
                                baseDaoImpl2 = baseDaoImpl3;
                                fieldType = findForeignFieldType;
                                tableInfo = null;
                                idField = null;
                            } else {
                                throw new SQLException("Field class for '" + this.field.getName() + "' must be a parameterized Collection whose generic argument is an entity class not: " + actualTypeArguments[0]);
                            }
                        } else {
                            throw new SQLException("Field class for '" + this.field.getName() + "' must be a parameterized Collection with at least 1 type.");
                        }
                    } else {
                        throw new SQLException("Field class for '" + this.field.getName() + "' must be a parameterized Collection.");
                    }
                }
                fieldTypeByColumnName = idField;
            }
        } else {
            DatabaseTableConfig<?> foreignTableConfig3 = this.fieldConfig.getForeignTableConfig();
            if (foreignTableConfig3 == null) {
                baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, type);
                tableInfo = baseDaoImpl.getTableInfo();
            } else {
                foreignTableConfig3.extractFieldTypes(connectionSource);
                baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, foreignTableConfig3);
                tableInfo = baseDaoImpl.getTableInfo();
            }
            idField = tableInfo.getIdField();
            if (idField != null) {
                if (foreignColumnName == null) {
                    fieldTypeByColumnName = idField;
                } else {
                    fieldTypeByColumnName = tableInfo.getFieldTypeByColumnName(foreignColumnName);
                    if (fieldTypeByColumnName == null) {
                        throw new IllegalArgumentException("Foreign field " + type + " does not have field named '" + foreignColumnName + "'");
                    }
                }
                baseDaoImpl2 = baseDaoImpl;
                fieldType = null;
                mappedQueryForFieldEq = MappedQueryForFieldEq.build(databaseType, tableInfo, fieldTypeByColumnName);
            } else {
                throw new IllegalArgumentException("Foreign field " + type + " does not have id field");
            }
        }
        this.mappedQueryForForeignField = mappedQueryForFieldEq;
        this.foreignTableInfo = tableInfo;
        this.foreignFieldType = fieldType;
        this.foreignDao = baseDaoImpl2;
        this.foreignIdField = idField;
        this.foreignRefField = fieldTypeByColumnName;
        FieldType fieldType2 = this.foreignRefField;
        if (fieldType2 != null) {
            assignDataType(databaseType, fieldType2.getDataPersister());
        }
    }

    public Object convertJavaFieldToSqlArgValue(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.fieldConverter.javaToSqlArg(this, obj);
    }

    public Object convertStringToJavaField(String str, int i) {
        if (str == null) {
            return null;
        }
        return this.fieldConverter.resultStringToJava(this, str, i);
    }

    public <T> int createWithForeignDao(T t) {
        return this.foreignDao.create((BaseDaoImpl<?, ?>) t);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != FieldType.class) {
            return false;
        }
        FieldType fieldType = (FieldType) obj;
        if (this.field.equals(fieldType.field)) {
            Class<?> cls = this.parentClass;
            Class<?> cls2 = fieldType.parentClass;
            if (cls == null) {
                if (cls2 != null) {
                    return false;
                }
            } else if (!cls.equals(cls2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Object extractJavaFieldToSqlArgValue(Object obj) {
        return convertJavaFieldToSqlArgValue(extractJavaFieldValue(obj));
    }

    public Object extractJavaFieldValue(Object obj) {
        Object extractRawJavaFieldValue = extractRawJavaFieldValue(obj);
        FieldType fieldType = this.foreignRefField;
        return (fieldType == null || extractRawJavaFieldValue == null) ? extractRawJavaFieldValue : fieldType.extractRawJavaFieldValue(extractRawJavaFieldValue);
    }

    public <FV> FV extractRawJavaFieldValue(Object obj) {
        Method method = this.fieldGetMethod;
        if (method == null) {
            try {
                return (FV) this.field.get(obj);
            } catch (Exception e) {
                throw SqlExceptionUtil.create("Could not get field value for " + this, e);
            }
        }
        try {
            return (FV) method.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            throw SqlExceptionUtil.create("Could not call " + this.fieldGetMethod + " for " + this, e2);
        }
    }

    public Object generateId() {
        return this.dataPersister.generateId();
    }

    public String getColumnDefinition() {
        return this.fieldConfig.getColumnDefinition();
    }

    public String getColumnName() {
        return this.columnName;
    }

    public DataPersister getDataPersister() {
        return this.dataPersister;
    }

    public Object getDataTypeConfigObj() {
        return this.dataTypeConfigObj;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public Field getField() {
        return this.field;
    }

    public String getFieldName() {
        return this.field.getName();
    }

    public <FV> FV getFieldValueIfNotDefault(Object obj) {
        FV fv = (FV) extractJavaFieldValue(obj);
        if (isFieldValueDefault(fv)) {
            return null;
        }
        return fv;
    }

    public FieldType getForeignIdField() {
        return this.foreignIdField;
    }

    public FieldType getForeignRefField() {
        return this.foreignRefField;
    }

    public String getFormat() {
        return this.fieldConfig.getFormat();
    }

    public String getGeneratedIdSequence() {
        return this.generatedIdSequence;
    }

    public Type getGenericType() {
        return this.field.getGenericType();
    }

    public String getIndexName() {
        return this.fieldConfig.getIndexName(this.tableName);
    }

    public Object getJavaDefaultValueDefault() {
        if (this.field.getType() == Boolean.TYPE) {
            return Boolean.valueOf(DEFAULT_VALUE_BOOLEAN);
        }
        if (this.field.getType() != Byte.TYPE && this.field.getType() != Byte.class) {
            if (this.field.getType() != Character.TYPE && this.field.getType() != Character.class) {
                if (this.field.getType() != Short.TYPE && this.field.getType() != Short.class) {
                    if (this.field.getType() != Integer.TYPE && this.field.getType() != Integer.class) {
                        if (this.field.getType() != Long.TYPE && this.field.getType() != Long.class) {
                            if (this.field.getType() != Float.TYPE && this.field.getType() != Float.class) {
                                if (this.field.getType() == Double.TYPE || this.field.getType() == Double.class) {
                                    return Double.valueOf(DEFAULT_VALUE_DOUBLE);
                                }
                                return null;
                            }
                            return Float.valueOf(DEFAULT_VALUE_FLOAT);
                        }
                        return Long.valueOf(DEFAULT_VALUE_LONG);
                    }
                    return Integer.valueOf(DEFAULT_VALUE_INT);
                }
                return Short.valueOf(DEFAULT_VALUE_SHORT);
            }
            return Character.valueOf(DEFAULT_VALUE_CHAR);
        }
        return Byte.valueOf(DEFAULT_VALUE_BYTE);
    }

    public SqlType getSqlType() {
        return this.fieldConverter.getSqlType();
    }

    public String getTableName() {
        return this.tableName;
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public String getUniqueIndexName() {
        return this.fieldConfig.getUniqueIndexName(this.tableName);
    }

    public Enum<?> getUnknownEnumVal() {
        return this.fieldConfig.getUnknownEnumValue();
    }

    public int getWidth() {
        return this.fieldConfig.getWidth();
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public boolean isAllowGeneratedIdInsert() {
        return this.fieldConfig.isAllowGeneratedIdInsert();
    }

    public boolean isArgumentHolderRequired() {
        return this.dataPersister.isArgumentHolderRequired();
    }

    public boolean isCanBeNull() {
        return this.fieldConfig.isCanBeNull();
    }

    public boolean isComparable() {
        if (this.fieldConfig.isForeignCollection()) {
            return false;
        }
        DataPersister dataPersister = this.dataPersister;
        if (dataPersister != null) {
            return dataPersister.isComparable();
        }
        throw new SQLException("Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: " + this);
    }

    public boolean isEscapedDefaultValue() {
        return this.dataPersister.isEscapedDefaultValue();
    }

    public boolean isEscapedValue() {
        return this.dataPersister.isEscapedValue();
    }

    public boolean isForeign() {
        return this.fieldConfig.isForeign();
    }

    public boolean isForeignAutoCreate() {
        return this.fieldConfig.isForeignAutoCreate();
    }

    public boolean isForeignCollection() {
        return this.fieldConfig.isForeignCollection();
    }

    public boolean isGeneratedId() {
        return this.isGeneratedId;
    }

    public boolean isGeneratedIdSequence() {
        return this.generatedIdSequence != null;
    }

    public boolean isId() {
        return this.isId;
    }

    public boolean isObjectsFieldValueDefault(Object obj) {
        return isFieldValueDefault(extractJavaFieldValue(obj));
    }

    public boolean isReadOnly() {
        return this.fieldConfig.isReadOnly();
    }

    public boolean isSelfGeneratedId() {
        return this.dataPersister.isSelfGeneratedId();
    }

    public boolean isUnique() {
        return this.fieldConfig.isUnique();
    }

    public boolean isUniqueCombo() {
        return this.fieldConfig.isUniqueCombo();
    }

    public boolean isVersion() {
        return this.fieldConfig.isVersion();
    }

    public Object moveToNextValue(Object obj) {
        DataPersister dataPersister = this.dataPersister;
        if (dataPersister == null) {
            return null;
        }
        return dataPersister.moveToNextValue(obj);
    }

    public <T> T resultToJava(DatabaseResults databaseResults, Map<String, Integer> map) {
        Integer num = map.get(this.columnName);
        if (num == null) {
            num = Integer.valueOf(databaseResults.findColumn(this.columnName));
            map.put(this.columnName, num);
        }
        T t = (T) this.fieldConverter.resultToJava(this, databaseResults, num.intValue());
        if (this.fieldConfig.isForeign()) {
            if (databaseResults.wasNull(num.intValue())) {
                return null;
            }
        } else if (this.dataPersister.isPrimitive()) {
            if (this.fieldConfig.isThrowIfNull() && databaseResults.wasNull(num.intValue())) {
                throw new SQLException("Results value for primitive field '" + this.field.getName() + "' was an invalid null value");
            }
        } else if (!this.fieldConverter.isStreamType() && databaseResults.wasNull(num.intValue())) {
            return null;
        }
        return t;
    }

    public String toString() {
        return FieldType.class.getSimpleName() + ":name=" + this.field.getName() + ",class=" + this.field.getDeclaringClass().getSimpleName();
    }
}
