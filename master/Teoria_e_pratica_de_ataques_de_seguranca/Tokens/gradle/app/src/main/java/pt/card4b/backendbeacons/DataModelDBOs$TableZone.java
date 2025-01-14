package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "IntermodalZones")
/* loaded from: classes.dex */
public class DataModelDBOs$TableZone {
    @DatabaseField
    public String name;
    @DatabaseField(m4257id = true)
    public int ref;

    public DataModelDBOs$TableZone(DataModelDTOs$IntermodalZoneDTO dataModelDTOs$IntermodalZoneDTO) {
        this.ref = dataModelDTOs$IntermodalZoneDTO.getZoneRef();
        this.name = dataModelDTOs$IntermodalZoneDTO.getName();
    }

    /* renamed from: a */
    public String m282a() {
        return this.name;
    }

    /* renamed from: b */
    public int m281b() {
        return this.ref;
    }

    /* renamed from: c */
    public DataModels.C2709r m280c() {
        return new DataModels.C2709r(m281b(), m282a());
    }

    public DataModelDBOs$TableZone() {
    }
}
