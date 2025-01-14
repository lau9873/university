package h.a.a;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ScanPeriodData.java */
/* loaded from: classes.dex */
public final class u implements Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final long f6861a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6862b;

    public u(long j, long j2) {
        if (Build.VERSION.SDK_INT < 24) {
            this.f6861a = j;
            this.f6862b = j2;
        } else if (j + j2 < 6000) {
            this.f6861a = j;
            this.f6862b = (6000 - j) - j2;
        } else {
            this.f6861a = j;
            this.f6862b = j2;
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
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f6861a == uVar.f6861a && this.f6862b == uVar.f6862b;
    }

    public int hashCode() {
        long j = this.f6861a;
        long j2 = this.f6862b;
        return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return s.a(this).a("scanPeriodMillis", this.f6861a).a("waitTimeMillis", this.f6862b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f6861a);
        parcel.writeLong(this.f6862b);
    }

    /* compiled from: ScanPeriodData.java */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<u> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public u createFromParcel(Parcel parcel) {
            return new u(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public u[] newArray(int i2) {
            return new u[i2];
        }
    }
}
