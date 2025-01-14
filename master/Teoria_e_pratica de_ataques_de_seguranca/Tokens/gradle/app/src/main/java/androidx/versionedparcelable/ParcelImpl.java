package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import p068b.p069a.VersionedParcelParcel;
import p068b.p069a.VersionedParcelable;

/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C0778a();

    /* renamed from: a */
    public final VersionedParcelable f4516a;

    /* renamed from: androidx.versionedparcelable.ParcelImpl$a */
    /* loaded from: classes.dex */
    public static class C0778a implements Parcelable.Creator<ParcelImpl> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(Parcel parcel) {
        this.f4516a = new VersionedParcelParcel(parcel).m6253h();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new VersionedParcelParcel(parcel).m6269a(this.f4516a);
    }
}
