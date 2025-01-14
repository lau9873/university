package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "BeaconsData")
/* loaded from: classes.dex */
public class DataModelDBOs$TableBeaconData {
    @DatabaseField
    public long firstTimeInRange;
    @DatabaseField
    public long firstTimeOffRange;
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public int inRangeCounter;
    @DatabaseField
    public long lastTimeInRange;
    @DatabaseField
    public long lastTimeOffRange;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableLine line;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableNewLineOrientation newOrientation;
    @DatabaseField
    public int offRangeCounter;
    @DatabaseField
    public boolean onTrip;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableOperator operator;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableLineOrientation orientation;
    @DatabaseField
    public int position;
    @DatabaseField
    public int rfu;
    @DatabaseField
    public int stageId;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableStop stop;
    @DatabaseField
    public int stopOrder;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableLineVariant variant;
    @DatabaseField
    public int vehicle;
    @DatabaseField
    public int version;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableZone zone;
}
