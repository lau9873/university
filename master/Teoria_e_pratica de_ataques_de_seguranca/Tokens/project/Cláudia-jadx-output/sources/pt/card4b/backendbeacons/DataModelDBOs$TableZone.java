package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "IntermodalZones")
/* loaded from: classes.dex */
public class DataModelDBOs$TableZone {
    @DatabaseField
    public String name;
    @DatabaseField(id = true)
    public int ref;

    public DataModelDBOs$TableZone(DataModelDTOs$IntermodalZoneDTO dataModelDTOs$IntermodalZoneDTO) {
        this.ref = dataModelDTOs$IntermodalZoneDTO.getZoneRef();
        this.name = dataModelDTOs$IntermodalZoneDTO.getName();
    }

    public String a() {
        return this.name;
    }

    public int b() {
        return this.ref;
    }

    public DataModels.r c() {
        return new DataModels.r(b(), a());
    }

    public DataModelDBOs$TableZone() {
    }
}
