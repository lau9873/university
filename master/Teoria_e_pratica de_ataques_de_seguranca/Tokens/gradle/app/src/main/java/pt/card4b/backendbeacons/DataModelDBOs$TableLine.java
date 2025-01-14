package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "Lines")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLine {
    @DatabaseField
    public boolean active;
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10708id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int operatorRef;
    @DatabaseField
    public int ownerOperatorRef;
    @DatabaseField
    public int ref;

    public DataModelDBOs$TableLine(DataModelDTOs$LineDTO dataModelDTOs$LineDTO) {
        this.f10708id = dataModelDTOs$LineDTO.getLineRef() + "|" + dataModelDTOs$LineDTO.getTransportOperatorRef();
        this.ref = dataModelDTOs$LineDTO.getLineRef();
        this.name = dataModelDTOs$LineDTO.getName();
        this.operatorRef = dataModelDTOs$LineDTO.getTransportOperatorRef();
        this.ownerOperatorRef = dataModelDTOs$LineDTO.getTransportOperatorOwnerRef();
        this.active = true;
    }

    /* renamed from: a */
    public String m309a() {
        return this.f10708id;
    }

    /* renamed from: b */
    public String m308b() {
        return this.name;
    }

    /* renamed from: c */
    public int m307c() {
        return this.operatorRef;
    }

    /* renamed from: d */
    public int m306d() {
        return this.ownerOperatorRef;
    }

    /* renamed from: e */
    public int m305e() {
        return this.ref;
    }

    /* renamed from: f */
    public DataModels.C2701j m304f() {
        return new DataModels.C2701j(m309a(), m305e(), m308b(), m307c(), m306d());
    }

    public DataModelDBOs$TableLine() {
    }
}
