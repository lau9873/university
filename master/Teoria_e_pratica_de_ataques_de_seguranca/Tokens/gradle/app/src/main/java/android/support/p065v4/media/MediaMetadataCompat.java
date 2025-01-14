package android.support.p065v4.media;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p065v4.media.session.MediaSessionCompat;
import p000a.p006b.p030g.p039f.MediaMetadataCompatApi21;
import p000a.p006b.p030g.p044j.ArrayMap;

/* renamed from: android.support.v4.media.MediaMetadataCompat */
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* renamed from: c */
    public static final ArrayMap<String, Integer> f3591c = new ArrayMap<>();

    /* renamed from: a */
    public final Bundle f3592a;

    /* renamed from: b */
    public Object f3593b;

    /* renamed from: android.support.v4.media.MediaMetadataCompat$a */
    /* loaded from: classes.dex */
    public static class C0616a implements Parcelable.Creator<MediaMetadataCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    static {
        f3591c.put("android.media.metadata.TITLE", 1);
        f3591c.put("android.media.metadata.ARTIST", 1);
        f3591c.put("android.media.metadata.DURATION", 0);
        f3591c.put("android.media.metadata.ALBUM", 1);
        f3591c.put("android.media.metadata.AUTHOR", 1);
        f3591c.put("android.media.metadata.WRITER", 1);
        f3591c.put("android.media.metadata.COMPOSER", 1);
        f3591c.put("android.media.metadata.COMPILATION", 1);
        f3591c.put("android.media.metadata.DATE", 1);
        f3591c.put("android.media.metadata.YEAR", 0);
        f3591c.put("android.media.metadata.GENRE", 1);
        f3591c.put("android.media.metadata.TRACK_NUMBER", 0);
        f3591c.put("android.media.metadata.NUM_TRACKS", 0);
        f3591c.put("android.media.metadata.DISC_NUMBER", 0);
        f3591c.put("android.media.metadata.ALBUM_ARTIST", 1);
        f3591c.put("android.media.metadata.ART", 2);
        f3591c.put("android.media.metadata.ART_URI", 1);
        f3591c.put("android.media.metadata.ALBUM_ART", 2);
        f3591c.put("android.media.metadata.ALBUM_ART_URI", 1);
        f3591c.put("android.media.metadata.USER_RATING", 3);
        f3591c.put("android.media.metadata.RATING", 3);
        f3591c.put("android.media.metadata.DISPLAY_TITLE", 1);
        f3591c.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        f3591c.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        f3591c.put("android.media.metadata.DISPLAY_ICON", 2);
        f3591c.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        f3591c.put("android.media.metadata.MEDIA_ID", 1);
        f3591c.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        f3591c.put("android.media.metadata.MEDIA_URI", 1);
        f3591c.put("android.media.metadata.ADVERTISEMENT", 0);
        f3591c.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new C0616a();
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f3592a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    /* renamed from: a */
    public static MediaMetadataCompat m7386a(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.m9798a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f3593b = obj;
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f3592a);
    }
}
