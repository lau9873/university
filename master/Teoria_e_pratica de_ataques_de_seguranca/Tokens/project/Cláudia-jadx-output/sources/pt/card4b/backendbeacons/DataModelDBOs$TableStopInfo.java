package pt.card4b.backendbeacons;

import android.os.Parcel;
import android.os.Parcelable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.text.SimpleDateFormat;
import java.util.Locale;
@DatabaseTable(tableName = "StopInfos")
/* loaded from: classes.dex */
public class DataModelDBOs$TableStopInfo implements Parcelable {
    @DatabaseField
    public int beaconDataId;
    @DatabaseField
    public long datetime;
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableLine line;
    @DatabaseField
    public boolean onTrip;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableOperator operator;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableLineOrientation orientation;
    @DatabaseField
    public String orientationName;
    @DatabaseField
    public int stageId;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableStop stop;
    @DatabaseField
    public int stopOrder;
    @DatabaseField
    public String tariff;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableLineVariant variant;
    @DatabaseField
    public int vehicle;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public DataModelDBOs$TableZone zone;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<DataModelDBOs$TableStopInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DataModelDBOs$TableStopInfo createFromParcel(Parcel parcel) {
            return new DataModelDBOs$TableStopInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DataModelDBOs$TableStopInfo[] newArray(int i2) {
            return new DataModelDBOs$TableStopInfo[i2];
        }
    }

    static {
        new a();
    }

    public DataModelDBOs$TableStopInfo(Parcel parcel) {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        this.id = parcel.readInt();
        this.stageId = parcel.readInt();
        this.beaconDataId = parcel.readInt();
        this.stopOrder = parcel.readInt();
        this.vehicle = parcel.readInt();
        this.tariff = parcel.readString();
        this.datetime = parcel.readLong();
        this.onTrip = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.stageId);
        parcel.writeInt(this.beaconDataId);
        parcel.writeInt(this.stopOrder);
        parcel.writeInt(this.vehicle);
        parcel.writeString(this.tariff);
        parcel.writeLong(this.datetime);
        parcel.writeByte(this.onTrip ? (byte) 1 : (byte) 0);
    }

    public DataModelDBOs$TableStopInfo() {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }
}
