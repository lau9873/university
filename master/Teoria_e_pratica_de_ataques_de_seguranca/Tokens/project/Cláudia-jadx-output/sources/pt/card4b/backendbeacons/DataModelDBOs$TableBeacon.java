package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "Beacons")
/* loaded from: classes.dex */
public class DataModelDBOs$TableBeacon {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableBeaconData beaconData;
    @DatabaseField
    public int distance;
    @DatabaseField
    public long firstTimeInRange;
    @DatabaseField
    public long firstTimeOffRange;
    @DatabaseField(id = true)
    public int id;
    @DatabaseField
    public int inRangeCounter;
    @DatabaseField
    public long lastTimeInRange;
    @DatabaseField
    public long lastTimeOffRange;
    @DatabaseField
    public String macAddress;
    @DatabaseField
    public int offRangeCounter;
    @DatabaseField
    public boolean onTrip;
    @DatabaseField
    public int rssi;
    @DatabaseField
    public int txPower;
    @DatabaseField
    public String uuid;
}
