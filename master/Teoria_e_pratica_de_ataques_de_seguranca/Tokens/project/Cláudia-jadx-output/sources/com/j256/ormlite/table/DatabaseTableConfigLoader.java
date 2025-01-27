package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DatabaseTableConfigLoader {
    public static final String CONFIG_FILE_END_MARKER = "# --table-end--";
    public static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
    public static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
    public static final String CONFIG_FILE_START_MARKER = "# --table-start--";
    public static final String FIELD_NAME_DATA_CLASS = "dataClass";
    public static final String FIELD_NAME_TABLE_NAME = "tableName";

    public static <T> DatabaseTableConfig<T> fromReader(BufferedReader bufferedReader) {
        DatabaseTableConfig<T> databaseTableConfig = new DatabaseTableConfig<>();
        boolean z = false;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null && !readLine.equals(CONFIG_FILE_END_MARKER)) {
                    if (readLine.equals(CONFIG_FILE_FIELDS_START)) {
                        readFields(bufferedReader, databaseTableConfig);
                    } else if (readLine.length() != 0 && !readLine.startsWith("#") && !readLine.equals(CONFIG_FILE_START_MARKER)) {
                        String[] split = readLine.split(SimpleComparison.EQUAL_TO_OPERATION, -2);
                        if (split.length == 2) {
                            readTableField(databaseTableConfig, split[0], split[1]);
                            z = true;
                        } else {
                            throw new SQLException("DatabaseTableConfig reading from stream cannot parse line: " + readLine);
                        }
                    }
                }
            } catch (IOException e2) {
                throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", e2);
            }
        }
        if (z) {
            return databaseTableConfig;
        }
        return null;
    }

    public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader bufferedReader) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            DatabaseTableConfig fromReader = fromReader(bufferedReader);
            if (fromReader == null) {
                return arrayList;
            }
            arrayList.add(fromReader);
        }
    }

    public static <T> void readFields(BufferedReader bufferedReader, DatabaseTableConfig<T> databaseTableConfig) {
        DatabaseFieldConfig fromReader;
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals(CONFIG_FILE_FIELDS_END) || (fromReader = DatabaseFieldConfigLoader.fromReader(bufferedReader)) == null) {
                    break;
                }
                arrayList.add(fromReader);
            } catch (IOException e2) {
                throw SqlExceptionUtil.create("Could not read next field from config file", e2);
            }
        }
        databaseTableConfig.setFieldConfigs(arrayList);
    }

    public static <T> void readTableField(DatabaseTableConfig<T> databaseTableConfig, String str, String str2) {
        if (str.equals(FIELD_NAME_DATA_CLASS)) {
            try {
                databaseTableConfig.setDataClass(Class.forName(str2));
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("Unknown class specified for dataClass: " + str2);
            }
        } else if (str.equals(FIELD_NAME_TABLE_NAME)) {
            databaseTableConfig.setTableName(str2);
        }
    }

    public static <T> void write(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) {
        try {
            writeConfig(bufferedWriter, databaseTableConfig);
        } catch (IOException e2) {
            throw SqlExceptionUtil.create("Could not write config to writer", e2);
        }
    }

    public static <T> void writeConfig(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) {
        bufferedWriter.append(CONFIG_FILE_START_MARKER);
        bufferedWriter.newLine();
        if (databaseTableConfig.getDataClass() != null) {
            bufferedWriter.append(FIELD_NAME_DATA_CLASS).append('=').append((CharSequence) databaseTableConfig.getDataClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseTableConfig.getTableName() != null) {
            bufferedWriter.append(FIELD_NAME_TABLE_NAME).append('=').append((CharSequence) databaseTableConfig.getTableName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_START);
        bufferedWriter.newLine();
        if (databaseTableConfig.getFieldConfigs() != null) {
            for (DatabaseFieldConfig databaseFieldConfig : databaseTableConfig.getFieldConfigs()) {
                DatabaseFieldConfigLoader.write(bufferedWriter, databaseFieldConfig, databaseTableConfig.getTableName());
            }
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_END);
        bufferedWriter.newLine();
        bufferedWriter.append(CONFIG_FILE_END_MARKER);
        bufferedWriter.newLine();
    }
}
