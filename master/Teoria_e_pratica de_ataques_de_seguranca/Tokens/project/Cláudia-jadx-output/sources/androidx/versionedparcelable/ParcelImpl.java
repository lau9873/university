package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.b;
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final b f2726a;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<ParcelImpl> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }
    }

    public ParcelImpl(Parcel parcel) {
        this.f2726a = new b.a.a(parcel).h();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        new b.a.a(parcel).a(this.f2726a);
    }
}
