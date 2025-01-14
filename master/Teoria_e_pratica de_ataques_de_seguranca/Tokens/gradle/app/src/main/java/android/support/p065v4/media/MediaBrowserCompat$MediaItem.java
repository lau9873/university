package android.support.p065v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
/* loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new C0613a();

    /* renamed from: a */
    public final int f3569a;

    /* renamed from: b */
    public final MediaDescriptionCompat f3570b;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$a */
    /* loaded from: classes.dex */
    public static class C0613a implements Parcelable.Creator<MediaBrowserCompat$MediaItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem[] newArray(int i) {
            return new MediaBrowserCompat$MediaItem[i];
        }
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f3569a = parcel.readInt();
        this.f3570b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{mFlags=" + this.f3569a + ", mDescription=" + this.f3570b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3569a);
        this.f3570b.writeToParcel(parcel, i);
    }
}
