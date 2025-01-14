package android.support.v4.media;

import a.b.g.f.i;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* renamed from: c  reason: collision with root package name */
    public static final a.b.g.j.a<String, Integer> f2319c = new a.b.g.j.a<>();

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f2320a;

    /* renamed from: b  reason: collision with root package name */
    public Object f2321b;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<MediaMetadataCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaMetadataCompat[] newArray(int i2) {
            return new MediaMetadataCompat[i2];
        }
    }

    static {
        f2319c.put("android.media.metadata.TITLE", 1);
        f2319c.put("android.media.metadata.ARTIST", 1);
        f2319c.put("android.media.metadata.DURATION", 0);
        f2319c.put("android.media.metadata.ALBUM", 1);
        f2319c.put("android.media.metadata.AUTHOR", 1);
        f2319c.put("android.media.metadata.WRITER", 1);
        f2319c.put("android.media.metadata.COMPOSER", 1);
        f2319c.put("android.media.metadata.COMPILATION", 1);
        f2319c.put("android.media.metadata.DATE", 1);
        f2319c.put("android.media.metadata.YEAR", 0);
        f2319c.put("android.media.metadata.GENRE", 1);
        f2319c.put("android.media.metadata.TRACK_NUMBER", 0);
        f2319c.put("android.media.metadata.NUM_TRACKS", 0);
        f2319c.put("android.media.metadata.DISC_NUMBER", 0);
        f2319c.put("android.media.metadata.ALBUM_ARTIST", 1);
        f2319c.put("android.media.metadata.ART", 2);
        f2319c.put("android.media.metadata.ART_URI", 1);
        f2319c.put("android.media.metadata.ALBUM_ART", 2);
        f2319c.put("android.media.metadata.ALBUM_ART_URI", 1);
        f2319c.put("android.media.metadata.USER_RATING", 3);
        f2319c.put("android.media.metadata.RATING", 3);
        f2319c.put("android.media.metadata.DISPLAY_TITLE", 1);
        f2319c.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        f2319c.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        f2319c.put("android.media.metadata.DISPLAY_ICON", 2);
        f2319c.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        f2319c.put("android.media.metadata.MEDIA_ID", 1);
        f2319c.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        f2319c.put("android.media.metadata.MEDIA_URI", 1);
        f2319c.put("android.media.metadata.ADVERTISEMENT", 0);
        f2319c.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new a();
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f2320a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat a(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        i.a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f2321b = obj;
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f2320a);
    }
}
