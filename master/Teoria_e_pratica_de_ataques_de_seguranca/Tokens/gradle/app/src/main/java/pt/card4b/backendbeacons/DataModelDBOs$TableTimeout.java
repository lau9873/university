package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Timeouts")
/* loaded from: classes.dex */
public class DataModelDBOs$TableTimeout {
    @DatabaseField
    public String operatorId;
    @DatabaseField
    public int timeout;
}
