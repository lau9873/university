package g.a.a;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AltBeacon.java */
/* loaded from: classes.dex */
public class a extends c {
    public static final Parcelable.Creator<a> CREATOR = new C0123a();

    /* compiled from: AltBeacon.java */
    /* renamed from: g.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0123a implements Parcelable.Creator<a> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a() {
    }

    @Override // g.a.a.c, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // g.a.a.c, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public a(Parcel parcel) {
        super(parcel);
    }
}
