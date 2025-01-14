package p205h.p206a.p207a;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: h.a.a.u */
/* loaded from: classes.dex */
public final class ScanPeriodData implements Parcelable {
    public static final Parcelable.Creator<ScanPeriodData> CREATOR = new C2223a();

    /* renamed from: a */
    public final long f9416a;

    /* renamed from: b */
    public final long f9417b;

    public ScanPeriodData(long j, long j2) {
        if (Build.VERSION.SDK_INT < 24) {
            this.f9416a = j;
            this.f9417b = j2;
        } else if (j + j2 < 6000) {
            this.f9416a = j;
            this.f9417b = (6000 - j) - j2;
        } else {
            this.f9416a = j;
            this.f9417b = j2;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScanPeriodData.class != obj.getClass()) {
            return false;
        }
        ScanPeriodData scanPeriodData = (ScanPeriodData) obj;
        return this.f9416a == scanPeriodData.f9416a && this.f9417b == scanPeriodData.f9417b;
    }

    public int hashCode() {
        long j = this.f9416a;
        long j2 = this.f9417b;
        return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return Objects.m1573a(this).m1571a("scanPeriodMillis", this.f9416a).m1571a("waitTimeMillis", this.f9417b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9416a);
        parcel.writeLong(this.f9417b);
    }

    /* compiled from: ScanPeriodData.java */
    /* renamed from: h.a.a.u$a */
    /* loaded from: classes.dex */
    public class C2223a implements Parcelable.Creator<ScanPeriodData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ScanPeriodData createFromParcel(Parcel parcel) {
            return new ScanPeriodData(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ScanPeriodData[] newArray(int i) {
            return new ScanPeriodData[i];
        }
    }
}
