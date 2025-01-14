package android.support.p065v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new C0622a();

    /* renamed from: a */
    public int f3606a;

    /* renamed from: b */
    public int f3607b;

    /* renamed from: c */
    public int f3608c;

    /* renamed from: d */
    public int f3609d;

    /* renamed from: e */
    public int f3610e;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$a */
    /* loaded from: classes.dex */
    public static class C0622a implements Parcelable.Creator<ParcelableVolumeInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f3606a = parcel.readInt();
        this.f3608c = parcel.readInt();
        this.f3609d = parcel.readInt();
        this.f3610e = parcel.readInt();
        this.f3607b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3606a);
        parcel.writeInt(this.f3608c);
        parcel.writeInt(this.f3609d);
        parcel.writeInt(this.f3610e);
        parcel.writeInt(this.f3607b);
    }
}
