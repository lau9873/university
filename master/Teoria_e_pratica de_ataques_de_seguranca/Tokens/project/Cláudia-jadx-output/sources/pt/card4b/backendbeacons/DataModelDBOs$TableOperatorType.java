package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "OperatorTypes")
/* loaded from: classes.dex */
public class DataModelDBOs$TableOperatorType {
    @DatabaseField
    public String name;
    @DatabaseField(id = true)
    public int ref;
}
