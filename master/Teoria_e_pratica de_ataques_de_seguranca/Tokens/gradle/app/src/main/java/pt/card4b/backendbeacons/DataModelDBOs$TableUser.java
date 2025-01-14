package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Users")
/* loaded from: classes.dex */
public class DataModelDBOs$TableUser {
    @DatabaseField
    public boolean active;
    @DatabaseField
    public String email;
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10713id;
    @DatabaseField
    public String name;
    @DatabaseField
    public String phonenumber;
}
