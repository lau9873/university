package com.j256.ormlite.field;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedWriter;
import java.io.IOException;
/* loaded from: classes.dex */
public class DatabaseFieldConfigLoader {
    public static final String CONFIG_FILE_END_MARKER = "# --field-end--";
    public static final String CONFIG_FILE_START_MARKER = "# --field-start--";
    public static final DataPersister DEFAULT_DATA_PERSISTER = DatabaseFieldConfig.DEFAULT_DATA_TYPE.getDataPersister();
    public static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
    public static final String FIELD_NAME_ALLOW_GENERATED_ID_INSERT = "allowGeneratedIdInsert";
    public static final String FIELD_NAME_CAN_BE_NULL = "canBeNull";
    public static final String FIELD_NAME_COLUMN_DEFINITION = "columnDefinition";
    public static final String FIELD_NAME_COLUMN_NAME = "columnName";
    public static final String FIELD_NAME_DATA_PERSISTER = "dataPersister";
    public static final String FIELD_NAME_DEFAULT_VALUE = "defaultValue";
    public static final String FIELD_NAME_FIELD_NAME = "fieldName";
    public static final String FIELD_NAME_FOREIGN = "foreign";
    public static final String FIELD_NAME_FOREIGN_AUTO_CREATE = "foreignAutoCreate";
    public static final String FIELD_NAME_FOREIGN_AUTO_REFRESH = "foreignAutoRefresh";
    public static final String FIELD_NAME_FOREIGN_COLLECTION = "foreignCollection";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME = "foreignCollectionColumnName";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_EAGER = "foreignCollectionEager";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME = "foreignCollectionForeignFieldName";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD = "foreignCollectionForeignColumnName";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING = "foreignCollectionOrderAscending";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME = "foreignCollectionOrderColumnName";
    public static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD = "foreignCollectionOrderColumn";
    public static final String FIELD_NAME_FOREIGN_COLUMN_NAME = "foreignColumnName";
    public static final String FIELD_NAME_FORMAT = "format";
    public static final String FIELD_NAME_GENERATED_ID = "generatedId";
    public static final String FIELD_NAME_GENERATED_ID_SEQUENCE = "generatedIdSequence";
    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_INDEX = "index";
    public static final String FIELD_NAME_INDEX_NAME = "indexName";
    public static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = "foreignCollectionMaxEagerLevel";
    public static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD = "maxEagerForeignCollectionLevel";
    public static final String FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL = "maxForeignAutoRefreshLevel";
    public static final String FIELD_NAME_PERSISTER_CLASS = "persisterClass";
    public static final String FIELD_NAME_READ_ONLY = "readOnly";
    public static final String FIELD_NAME_THROW_IF_NULL = "throwIfNull";
    public static final String FIELD_NAME_UNIQUE = "unique";
    public static final String FIELD_NAME_UNIQUE_COMBO = "uniqueCombo";
    public static final String FIELD_NAME_UNIQUE_INDEX = "uniqueIndex";
    public static final String FIELD_NAME_UNIQUE_INDEX_NAME = "uniqueIndexName";
    public static final String FIELD_NAME_UNKNOWN_ENUM_VALUE = "unknownEnumValue";
    public static final String FIELD_NAME_USE_GET_SET = "useGetSet";
    public static final String FIELD_NAME_VERSION = "version";
    public static final String FIELD_NAME_WIDTH = "width";

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.j256.ormlite.field.DatabaseFieldConfig fromReader(java.io.BufferedReader r7) {
        /*
            com.j256.ormlite.field.DatabaseFieldConfig r0 = new com.j256.ormlite.field.DatabaseFieldConfig
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            java.lang.String r4 = r7.readLine()     // Catch: java.io.IOException -> L5e
            if (r4 != 0) goto Lf
            goto L17
        Lf:
            java.lang.String r5 = "# --field-end--"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L1c
        L17:
            if (r3 == 0) goto L1a
            return r0
        L1a:
            r7 = 0
            return r7
        L1c:
            int r5 = r4.length()
            if (r5 == 0) goto L8
            java.lang.String r5 = "#"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L8
            java.lang.String r5 = "# --field-start--"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L33
            goto L8
        L33:
            r3 = -2
            java.lang.String r5 = "="
            java.lang.String[] r3 = r4.split(r5, r3)
            int r5 = r3.length
            r6 = 2
            if (r5 != r6) goto L47
            r4 = r3[r2]
            r3 = r3[r1]
            readField(r0, r4, r3)
            r3 = 1
            goto L8
        L47:
            java.sql.SQLException r7 = new java.sql.SQLException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "DatabaseFieldConfig reading from stream cannot parse line: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L5e:
            r7 = move-exception
            java.lang.String r0 = "Could not read DatabaseFieldConfig from stream"
            java.sql.SQLException r7 = com.j256.ormlite.misc.SqlExceptionUtil.create(r0, r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.DatabaseFieldConfigLoader.fromReader(java.io.BufferedReader):com.j256.ormlite.field.DatabaseFieldConfig");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void readField(DatabaseFieldConfig databaseFieldConfig, String str, String str2) {
        Enum[] enumArr;
        if (str.equals(FIELD_NAME_FIELD_NAME)) {
            databaseFieldConfig.setFieldName(str2);
        } else if (str.equals(FIELD_NAME_COLUMN_NAME)) {
            databaseFieldConfig.setColumnName(str2);
        } else if (str.equals(FIELD_NAME_DATA_PERSISTER)) {
            databaseFieldConfig.setDataPersister(DataType.valueOf(str2).getDataPersister());
        } else if (str.equals(FIELD_NAME_DEFAULT_VALUE)) {
            databaseFieldConfig.setDefaultValue(str2);
        } else if (str.equals(FIELD_NAME_WIDTH)) {
            databaseFieldConfig.setWidth(Integer.parseInt(str2));
        } else if (str.equals(FIELD_NAME_CAN_BE_NULL)) {
            databaseFieldConfig.setCanBeNull(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_ID)) {
            databaseFieldConfig.setId(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_GENERATED_ID)) {
            databaseFieldConfig.setGeneratedId(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_GENERATED_ID_SEQUENCE)) {
            databaseFieldConfig.setGeneratedIdSequence(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN)) {
            databaseFieldConfig.setForeign(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_USE_GET_SET)) {
            databaseFieldConfig.setUseGetSet(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_UNKNOWN_ENUM_VALUE)) {
            String[] split = str2.split("#", -2);
            if (split.length == 2) {
                try {
                    Object[] enumConstants = Class.forName(split[0]).getEnumConstants();
                    if (enumConstants != null) {
                        boolean z = false;
                        for (Enum r5 : (Enum[]) enumConstants) {
                            if (r5.name().equals(split[1])) {
                                databaseFieldConfig.setUnknownEnumValue(r5);
                                z = true;
                            }
                        }
                        if (z) {
                            return;
                        }
                        throw new IllegalArgumentException("Invalid enum value name for unknownEnumvalue: " + str2);
                    }
                    throw new IllegalArgumentException("Invalid class is not an Enum for unknownEnumValue: " + str2);
                } catch (ClassNotFoundException unused) {
                    throw new IllegalArgumentException("Unknown class specified for unknownEnumValue: " + str2);
                }
            }
            throw new IllegalArgumentException("Invalid value for unknownEnumValue which should be in class#name format: " + str2);
        } else if (str.equals(FIELD_NAME_THROW_IF_NULL)) {
            databaseFieldConfig.setThrowIfNull(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_FORMAT)) {
            databaseFieldConfig.setFormat(str2);
        } else if (str.equals(FIELD_NAME_UNIQUE)) {
            databaseFieldConfig.setUnique(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_UNIQUE_COMBO)) {
            databaseFieldConfig.setUniqueCombo(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_INDEX)) {
            databaseFieldConfig.setIndex(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_INDEX_NAME)) {
            databaseFieldConfig.setIndex(true);
            databaseFieldConfig.setIndexName(str2);
        } else if (str.equals(FIELD_NAME_UNIQUE_INDEX)) {
            databaseFieldConfig.setUniqueIndex(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_UNIQUE_INDEX_NAME)) {
            databaseFieldConfig.setUniqueIndex(true);
            databaseFieldConfig.setUniqueIndexName(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_AUTO_REFRESH)) {
            databaseFieldConfig.setForeignAutoRefresh(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL)) {
            databaseFieldConfig.setMaxForeignAutoRefreshLevel(Integer.parseInt(str2));
        } else if (str.equals(FIELD_NAME_PERSISTER_CLASS)) {
            try {
                databaseFieldConfig.setPersisterClass(Class.forName(str2));
            } catch (ClassNotFoundException unused2) {
                throw new IllegalArgumentException("Could not find persisterClass: " + str2);
            }
        } else if (str.equals(FIELD_NAME_ALLOW_GENERATED_ID_INSERT)) {
            databaseFieldConfig.setAllowGeneratedIdInsert(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_COLUMN_DEFINITION)) {
            databaseFieldConfig.setColumnDefinition(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_AUTO_CREATE)) {
            databaseFieldConfig.setForeignAutoCreate(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_VERSION)) {
            databaseFieldConfig.setVersion(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_FOREIGN_COLUMN_NAME)) {
            databaseFieldConfig.setForeignColumnName(str2);
        } else if (str.equals(FIELD_NAME_READ_ONLY)) {
            databaseFieldConfig.setReadOnly(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION)) {
            databaseFieldConfig.setForeignCollection(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_EAGER)) {
            databaseFieldConfig.setForeignCollectionEager(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD)) {
            databaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(str2));
        } else if (str.equals(FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL)) {
            databaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(str2));
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME)) {
            databaseFieldConfig.setForeignCollectionColumnName(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD)) {
            databaseFieldConfig.setForeignCollectionOrderColumnName(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME)) {
            databaseFieldConfig.setForeignCollectionOrderColumnName(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING)) {
            databaseFieldConfig.setForeignCollectionOrderAscending(Boolean.parseBoolean(str2));
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD)) {
            databaseFieldConfig.setForeignCollectionForeignFieldName(str2);
        } else if (str.equals(FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME)) {
            databaseFieldConfig.setForeignCollectionForeignFieldName(str2);
        }
    }

    public static void write(BufferedWriter bufferedWriter, DatabaseFieldConfig databaseFieldConfig, String str) {
        try {
            writeConfig(bufferedWriter, databaseFieldConfig, str);
        } catch (IOException e2) {
            throw SqlExceptionUtil.create("Could not write config to writer", e2);
        }
    }

    public static void writeConfig(BufferedWriter bufferedWriter, DatabaseFieldConfig databaseFieldConfig, String str) {
        bufferedWriter.append(CONFIG_FILE_START_MARKER);
        bufferedWriter.newLine();
        if (databaseFieldConfig.getFieldName() != null) {
            bufferedWriter.append(FIELD_NAME_FIELD_NAME).append('=').append((CharSequence) databaseFieldConfig.getFieldName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getColumnName() != null) {
            bufferedWriter.append(FIELD_NAME_COLUMN_NAME).append('=').append((CharSequence) databaseFieldConfig.getColumnName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getDataPersister() != DEFAULT_DATA_PERSISTER) {
            DataType[] values = DataType.values();
            int length = values.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                DataType dataType = values[i2];
                if (dataType.getDataPersister() == databaseFieldConfig.getDataPersister()) {
                    bufferedWriter.append(FIELD_NAME_DATA_PERSISTER).append('=').append((CharSequence) dataType.name());
                    bufferedWriter.newLine();
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                throw new IllegalArgumentException("Unknown data persister field: " + databaseFieldConfig.getDataPersister());
            }
        }
        if (databaseFieldConfig.getDefaultValue() != null) {
            bufferedWriter.append(FIELD_NAME_DEFAULT_VALUE).append('=').append((CharSequence) databaseFieldConfig.getDefaultValue());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getWidth() != 0) {
            bufferedWriter.append(FIELD_NAME_WIDTH).append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getWidth()));
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isCanBeNull()) {
            bufferedWriter.append(FIELD_NAME_CAN_BE_NULL).append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isCanBeNull()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isId()) {
            bufferedWriter.append(FIELD_NAME_ID).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isGeneratedId()) {
            bufferedWriter.append(FIELD_NAME_GENERATED_ID).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getGeneratedIdSequence() != null) {
            bufferedWriter.append(FIELD_NAME_GENERATED_ID_SEQUENCE).append('=').append((CharSequence) databaseFieldConfig.getGeneratedIdSequence());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeign()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUseGetSet()) {
            bufferedWriter.append(FIELD_NAME_USE_GET_SET).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getUnknownEnumValue() != null) {
            bufferedWriter.append(FIELD_NAME_UNKNOWN_ENUM_VALUE).append('=').append((CharSequence) databaseFieldConfig.getUnknownEnumValue().getDeclaringClass().getName()).append('#').append((CharSequence) databaseFieldConfig.getUnknownEnumValue().name());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isThrowIfNull()) {
            bufferedWriter.append(FIELD_NAME_THROW_IF_NULL).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getFormat() != null) {
            bufferedWriter.append(FIELD_NAME_FORMAT).append('=').append((CharSequence) databaseFieldConfig.getFormat());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUnique()) {
            bufferedWriter.append(FIELD_NAME_UNIQUE).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isUniqueCombo()) {
            bufferedWriter.append(FIELD_NAME_UNIQUE_COMBO).append('=').append("true");
            bufferedWriter.newLine();
        }
        String indexName = databaseFieldConfig.getIndexName(str);
        if (indexName != null) {
            bufferedWriter.append(FIELD_NAME_INDEX_NAME).append('=').append((CharSequence) indexName);
            bufferedWriter.newLine();
        }
        String uniqueIndexName = databaseFieldConfig.getUniqueIndexName(str);
        if (uniqueIndexName != null) {
            bufferedWriter.append(FIELD_NAME_UNIQUE_INDEX_NAME).append('=').append((CharSequence) uniqueIndexName);
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignAutoRefresh()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_AUTO_REFRESH).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getMaxForeignAutoRefreshLevel() != -1) {
            bufferedWriter.append(FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL).append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getMaxForeignAutoRefreshLevel()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getPersisterClass() != DatabaseFieldConfig.DEFAULT_PERSISTER_CLASS) {
            bufferedWriter.append(FIELD_NAME_PERSISTER_CLASS).append('=').append((CharSequence) databaseFieldConfig.getPersisterClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isAllowGeneratedIdInsert()) {
            bufferedWriter.append(FIELD_NAME_ALLOW_GENERATED_ID_INSERT).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getColumnDefinition() != null) {
            bufferedWriter.append(FIELD_NAME_COLUMN_DEFINITION).append('=').append((CharSequence) databaseFieldConfig.getColumnDefinition());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignAutoCreate()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_AUTO_CREATE).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isVersion()) {
            bufferedWriter.append(FIELD_NAME_VERSION).append('=').append("true");
            bufferedWriter.newLine();
        }
        String foreignColumnName = databaseFieldConfig.getForeignColumnName();
        if (foreignColumnName != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLUMN_NAME).append('=').append((CharSequence) foreignColumnName);
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isReadOnly()) {
            bufferedWriter.append(FIELD_NAME_READ_ONLY).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignCollection()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.isForeignCollectionEager()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_EAGER).append('=').append("true");
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionMaxEagerLevel() != 1) {
            bufferedWriter.append(FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL).append('=').append((CharSequence) Integer.toString(databaseFieldConfig.getForeignCollectionMaxEagerLevel()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionColumnName() != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME).append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionColumnName());
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionOrderColumnName() != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME).append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionOrderColumnName());
            bufferedWriter.newLine();
        }
        if (!databaseFieldConfig.isForeignCollectionOrderAscending()) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING).append('=').append((CharSequence) Boolean.toString(databaseFieldConfig.isForeignCollectionOrderAscending()));
            bufferedWriter.newLine();
        }
        if (databaseFieldConfig.getForeignCollectionForeignFieldName() != null) {
            bufferedWriter.append(FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME).append('=').append((CharSequence) databaseFieldConfig.getForeignCollectionForeignFieldName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append(CONFIG_FILE_END_MARKER);
        bufferedWriter.newLine();
    }
}
