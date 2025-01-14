package a.b.g.a;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public o[] f735a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f736b;

    /* renamed from: c  reason: collision with root package name */
    public d[] f737c;

    /* renamed from: d  reason: collision with root package name */
    public int f738d;

    /* renamed from: e  reason: collision with root package name */
    public int f739e;

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<n> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public n[] newArray(int i2) {
            return new n[i2];
        }
    }

    public n() {
        this.f738d = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.f735a, i2);
        parcel.writeIntArray(this.f736b);
        parcel.writeTypedArray(this.f737c, i2);
        parcel.writeInt(this.f738d);
        parcel.writeInt(this.f739e);
    }

    public n(Parcel parcel) {
        this.f738d = -1;
        this.f735a = (o[]) parcel.createTypedArray(o.CREATOR);
        this.f736b = parcel.createIntArray();
        this.f737c = (d[]) parcel.createTypedArray(d.CREATOR);
        this.f738d = parcel.readInt();
        this.f739e = parcel.readInt();
    }
}
