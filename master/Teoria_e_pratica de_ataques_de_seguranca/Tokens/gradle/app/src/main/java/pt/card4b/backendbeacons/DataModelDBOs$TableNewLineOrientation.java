package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "NewLineOrientations")
/* loaded from: classes.dex */
public class DataModelDBOs$TableNewLineOrientation {
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public int f10710id;
    @DatabaseField
    public int lineRef;
    @DatabaseField
    public String name;
    @DatabaseField
    public int operatorRef;
    @DatabaseField
    public int ref;
    @DatabaseField
    public int variantRef;
}
