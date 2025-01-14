package g.a.a.n;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* compiled from: StartRMData.java */
/* loaded from: classes.dex */
public class p implements Serializable, Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public g.a.a.j f6166a;

    /* renamed from: b  reason: collision with root package name */
    public long f6167b;

    /* renamed from: c  reason: collision with root package name */
    public long f6168c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6169d;

    /* renamed from: e  reason: collision with root package name */
    public String f6170e;

    /* compiled from: StartRMData.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<p> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public p createFromParcel(Parcel parcel) {
            return new p(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public p[] newArray(int i2) {
            return new p[i2];
        }
    }

    public /* synthetic */ p(Parcel parcel, a aVar) {
        this(parcel);
    }

    public boolean a() {
        return this.f6169d;
    }

    public long b() {
        return this.f6168c;
    }

    public String c() {
        return this.f6170e;
    }

    public g.a.a.j d() {
        return this.f6166a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f6167b;
    }

    public Bundle f() {
        Bundle bundle = new Bundle();
        bundle.putLong("scanPeriod", this.f6167b);
        bundle.putLong("betweenScanPeriod", this.f6168c);
        bundle.putBoolean("backgroundFlag", this.f6169d);
        bundle.putString("callbackPackageName", this.f6170e);
        g.a.a.j jVar = this.f6166a;
        if (jVar != null) {
            bundle.putSerializable("region", jVar);
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f6166a, i2);
        parcel.writeString(this.f6170e);
        parcel.writeLong(this.f6167b);
        parcel.writeLong(this.f6168c);
        parcel.writeByte(this.f6169d ? (byte) 1 : (byte) 0);
    }

    public p() {
    }

    public static p a(Bundle bundle) {
        boolean z;
        bundle.setClassLoader(g.a.a.j.class.getClassLoader());
        p pVar = new p();
        if (bundle.containsKey("region")) {
            pVar.f6166a = (g.a.a.j) bundle.getSerializable("region");
            z = true;
        } else {
            z = false;
        }
        if (bundle.containsKey("scanPeriod")) {
            pVar.f6167b = ((Long) bundle.get("scanPeriod")).longValue();
            z = true;
        }
        if (bundle.containsKey("betweenScanPeriod")) {
            pVar.f6168c = ((Long) bundle.get("betweenScanPeriod")).longValue();
        }
        if (bundle.containsKey("backgroundFlag")) {
            pVar.f6169d = ((Boolean) bundle.get("backgroundFlag")).booleanValue();
        }
        if (bundle.containsKey("callbackPackageName")) {
            pVar.f6170e = (String) bundle.get("callbackPackageName");
        }
        if (z) {
            return pVar;
        }
        return null;
    }

    public p(long j, long j2, boolean z) {
        this.f6167b = j;
        this.f6168c = j2;
        this.f6169d = z;
    }

    public p(g.a.a.j jVar, String str, long j, long j2, boolean z) {
        this.f6167b = j;
        this.f6168c = j2;
        this.f6166a = jVar;
        this.f6170e = str;
        this.f6169d = z;
    }

    public p(Parcel parcel) {
        this.f6166a = (g.a.a.j) parcel.readParcelable(p.class.getClassLoader());
        this.f6170e = parcel.readString();
        this.f6167b = parcel.readLong();
        this.f6168c = parcel.readLong();
        this.f6169d = parcel.readByte() != 0;
    }
}
