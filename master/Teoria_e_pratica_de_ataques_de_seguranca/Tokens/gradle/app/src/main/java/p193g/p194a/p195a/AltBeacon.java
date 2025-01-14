package p193g.p194a.p195a;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: g.a.a.a */
/* loaded from: classes.dex */
public class AltBeacon extends Beacon {
    public static final Parcelable.Creator<AltBeacon> CREATOR = new C1829a();

    /* compiled from: AltBeacon.java */
    /* renamed from: g.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C1829a implements Parcelable.Creator<AltBeacon> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AltBeacon createFromParcel(Parcel parcel) {
            return new AltBeacon(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AltBeacon[] newArray(int i) {
            return new AltBeacon[i];
        }
    }

    public AltBeacon() {
    }

    @Override // p193g.p194a.p195a.Beacon, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // p193g.p194a.p195a.Beacon, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public AltBeacon(Parcel parcel) {
        super(parcel);
    }
}
