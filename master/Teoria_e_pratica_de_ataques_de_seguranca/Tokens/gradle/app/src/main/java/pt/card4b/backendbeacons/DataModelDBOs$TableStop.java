package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "Stops")
/* loaded from: classes.dex */
public class DataModelDBOs$TableStop {
    @DatabaseField
    public boolean active;
    @DatabaseField
    public int beaconStopRef;
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10711id;
    @DatabaseField
    public int intermodalZoneRef;
    @DatabaseField
    public String name;
    @DatabaseField
    public int operatorRef;
    @DatabaseField
    public int ref;
    @DatabaseField
    public String stopCode;

    public DataModelDBOs$TableStop(DataModelDTOs$StopDTO dataModelDTOs$StopDTO) {
        this.f10711id = dataModelDTOs$StopDTO.getStopRef() + "|" + dataModelDTOs$StopDTO.getTransportOperatorRef();
        this.name = dataModelDTOs$StopDTO.getName();
        this.ref = dataModelDTOs$StopDTO.getStopRef();
        this.stopCode = dataModelDTOs$StopDTO.getStopCode();
        this.operatorRef = dataModelDTOs$StopDTO.getTransportOperatorRef();
        this.intermodalZoneRef = dataModelDTOs$StopDTO.getIntermodalZoneRef();
        this.active = true;
        this.beaconStopRef = dataModelDTOs$StopDTO.getBeaconStopRef();
    }

    /* renamed from: a */
    public int m291a() {
        return this.beaconStopRef;
    }

    /* renamed from: b */
    public String m290b() {
        return this.f10711id;
    }

    /* renamed from: c */
    public String m289c() {
        return this.name;
    }

    /* renamed from: d */
    public int m288d() {
        return this.operatorRef;
    }

    /* renamed from: e */
    public int m287e() {
        return this.ref;
    }

    /* renamed from: f */
    public String m286f() {
        return this.stopCode;
    }

    /* renamed from: g */
    public DataModels.C2708q m285g() {
        return new DataModels.C2708q(m290b(), m287e(), m289c(), m286f());
    }

    public DataModelDBOs$TableStop() {
    }
}
