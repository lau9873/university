package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f2297a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaDescriptionCompat f2298b;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<MediaBrowserCompat$MediaItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem[] newArray(int i2) {
            return new MediaBrowserCompat$MediaItem[i2];
        }
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f2297a = parcel.readInt();
        this.f2298b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{mFlags=" + this.f2297a + ", mDescription=" + this.f2298b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2297a);
        this.f2298b.writeToParcel(parcel, i2);
    }
}
