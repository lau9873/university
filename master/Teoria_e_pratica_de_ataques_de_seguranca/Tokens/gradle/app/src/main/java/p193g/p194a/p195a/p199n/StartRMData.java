package p193g.p194a.p195a.p199n;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import p193g.p194a.p195a.Region;

/* renamed from: g.a.a.n.p */
/* loaded from: classes.dex */
public class StartRMData implements Serializable, Parcelable {
    public static final Parcelable.Creator<StartRMData> CREATOR = new C1843a();

    /* renamed from: a */
    public Region f8633a;

    /* renamed from: b */
    public long f8634b;

    /* renamed from: c */
    public long f8635c;

    /* renamed from: d */
    public boolean f8636d;

    /* renamed from: e */
    public String f8637e;

    /* compiled from: StartRMData.java */
    /* renamed from: g.a.a.n.p$a */
    /* loaded from: classes.dex */
    public static class C1843a implements Parcelable.Creator<StartRMData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartRMData createFromParcel(Parcel parcel) {
            return new StartRMData(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartRMData[] newArray(int i) {
            return new StartRMData[i];
        }
    }

    public /* synthetic */ StartRMData(Parcel parcel, C1843a c1843a) {
        this(parcel);
    }

    /* renamed from: a */
    public boolean m2297a() {
        return this.f8636d;
    }

    /* renamed from: b */
    public long m2295b() {
        return this.f8635c;
    }

    /* renamed from: c */
    public String m2294c() {
        return this.f8637e;
    }

    /* renamed from: d */
    public Region m2293d() {
        return this.f8633a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public long m2292e() {
        return this.f8634b;
    }

    /* renamed from: f */
    public Bundle m2291f() {
        Bundle bundle = new Bundle();
        bundle.putLong("scanPeriod", this.f8634b);
        bundle.putLong("betweenScanPeriod", this.f8635c);
        bundle.putBoolean("backgroundFlag", this.f8636d);
        bundle.putString("callbackPackageName", this.f8637e);
        Region region = this.f8633a;
        if (region != null) {
            bundle.putSerializable("region", region);
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8633a, i);
        parcel.writeString(this.f8637e);
        parcel.writeLong(this.f8634b);
        parcel.writeLong(this.f8635c);
        parcel.writeByte(this.f8636d ? (byte) 1 : (byte) 0);
    }

    public StartRMData() {
    }

    /* renamed from: a */
    public static StartRMData m2296a(Bundle bundle) {
        boolean z;
        bundle.setClassLoader(Region.class.getClassLoader());
        StartRMData startRMData = new StartRMData();
        if (bundle.containsKey("region")) {
            startRMData.f8633a = (Region) bundle.getSerializable("region");
            z = true;
        } else {
            z = false;
        }
        if (bundle.containsKey("scanPeriod")) {
            startRMData.f8634b = ((Long) bundle.get("scanPeriod")).longValue();
            z = true;
        }
        if (bundle.containsKey("betweenScanPeriod")) {
            startRMData.f8635c = ((Long) bundle.get("betweenScanPeriod")).longValue();
        }
        if (bundle.containsKey("backgroundFlag")) {
            startRMData.f8636d = ((Boolean) bundle.get("backgroundFlag")).booleanValue();
        }
        if (bundle.containsKey("callbackPackageName")) {
            startRMData.f8637e = (String) bundle.get("callbackPackageName");
        }
        if (z) {
            return startRMData;
        }
        return null;
    }

    public StartRMData(long j, long j2, boolean z) {
        this.f8634b = j;
        this.f8635c = j2;
        this.f8636d = z;
    }

    public StartRMData(Region region, String str, long j, long j2, boolean z) {
        this.f8634b = j;
        this.f8635c = j2;
        this.f8633a = region;
        this.f8637e = str;
        this.f8636d = z;
    }

    public StartRMData(Parcel parcel) {
        this.f8633a = (Region) parcel.readParcelable(StartRMData.class.getClassLoader());
        this.f8637e = parcel.readString();
        this.f8634b = parcel.readLong();
        this.f8635c = parcel.readLong();
        this.f8636d = parcel.readByte() != 0;
    }
}
