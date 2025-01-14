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
    @DatabaseField(id = true)
    public String id;
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
        this.id = dataModelDTOs$StopDTO.getStopRef() + "|" + dataModelDTOs$StopDTO.getTransportOperatorRef();
        this.name = dataModelDTOs$StopDTO.getName();
        this.ref = dataModelDTOs$StopDTO.getStopRef();
        this.stopCode = dataModelDTOs$StopDTO.getStopCode();
        this.operatorRef = dataModelDTOs$StopDTO.getTransportOperatorRef();
        this.intermodalZoneRef = dataModelDTOs$StopDTO.getIntermodalZoneRef();
        this.active = true;
        this.beaconStopRef = dataModelDTOs$StopDTO.getBeaconStopRef();
    }

    public int a() {
        return this.beaconStopRef;
    }

    public String b() {
        return this.id;
    }

    public String c() {
        return this.name;
    }

    public int d() {
        return this.operatorRef;
    }

    public int e() {
        return this.ref;
    }

    public String f() {
        return this.stopCode;
    }

    public DataModels.q g() {
        return new DataModels.q(b(), e(), c(), f());
    }

    public DataModelDBOs$TableStop() {
    }
}
