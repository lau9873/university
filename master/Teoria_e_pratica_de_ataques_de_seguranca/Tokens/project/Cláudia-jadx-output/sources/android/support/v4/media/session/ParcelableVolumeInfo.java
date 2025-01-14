package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f2334a;

    /* renamed from: b  reason: collision with root package name */
    public int f2335b;

    /* renamed from: c  reason: collision with root package name */
    public int f2336c;

    /* renamed from: d  reason: collision with root package name */
    public int f2337d;

    /* renamed from: e  reason: collision with root package name */
    public int f2338e;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f2334a = parcel.readInt();
        this.f2336c = parcel.readInt();
        this.f2337d = parcel.readInt();
        this.f2338e = parcel.readInt();
        this.f2335b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2334a);
        parcel.writeInt(this.f2336c);
        parcel.writeInt(this.f2337d);
        parcel.writeInt(this.f2338e);
        parcel.writeInt(this.f2335b);
    }
}
