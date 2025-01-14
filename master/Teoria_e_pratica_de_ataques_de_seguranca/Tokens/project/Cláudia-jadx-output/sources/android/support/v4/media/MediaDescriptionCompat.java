package android.support.v4.media;

import a.b.g.f.g;
import a.b.g.f.h;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f2302a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f2303b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f2304c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f2305d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap f2306e;

    /* renamed from: f  reason: collision with root package name */
    public final Uri f2307f;

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f2308g;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f2309h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2310i;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(g.a(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f2311a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f2312b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f2313c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f2314d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap f2315e;

        /* renamed from: f  reason: collision with root package name */
        public Uri f2316f;

        /* renamed from: g  reason: collision with root package name */
        public Bundle f2317g;

        /* renamed from: h  reason: collision with root package name */
        public Uri f2318h;

        public b a(String str) {
            this.f2311a = str;
            return this;
        }

        public b b(CharSequence charSequence) {
            this.f2313c = charSequence;
            return this;
        }

        public b c(CharSequence charSequence) {
            this.f2312b = charSequence;
            return this;
        }

        public b a(CharSequence charSequence) {
            this.f2314d = charSequence;
            return this;
        }

        public b b(Uri uri) {
            this.f2318h = uri;
            return this;
        }

        public b a(Bitmap bitmap) {
            this.f2315e = bitmap;
            return this;
        }

        public b a(Uri uri) {
            this.f2316f = uri;
            return this;
        }

        public b a(Bundle bundle) {
            this.f2317g = bundle;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f2311a, this.f2312b, this.f2313c, this.f2314d, this.f2315e, this.f2316f, this.f2317g, this.f2318h);
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f2302a = str;
        this.f2303b = charSequence;
        this.f2304c = charSequence2;
        this.f2305d = charSequence3;
        this.f2306e = bitmap;
        this.f2307f = uri;
        this.f2308g = bundle;
        this.f2309h = uri2;
    }

    public Object a() {
        if (this.f2310i == null && Build.VERSION.SDK_INT >= 21) {
            Object a2 = g.a.a();
            g.a.a(a2, this.f2302a);
            g.a.c(a2, this.f2303b);
            g.a.b(a2, this.f2304c);
            g.a.a(a2, this.f2305d);
            g.a.a(a2, this.f2306e);
            g.a.a(a2, this.f2307f);
            Bundle bundle = this.f2308g;
            if (Build.VERSION.SDK_INT < 23 && this.f2309h != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f2309h);
            }
            g.a.a(a2, bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                h.a.a(a2, this.f2309h);
            }
            this.f2310i = g.a.a(a2);
            return this.f2310i;
        }
        return this.f2310i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f2303b) + ", " + ((Object) this.f2304c) + ", " + ((Object) this.f2305d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f2302a);
            TextUtils.writeToParcel(this.f2303b, parcel, i2);
            TextUtils.writeToParcel(this.f2304c, parcel, i2);
            TextUtils.writeToParcel(this.f2305d, parcel, i2);
            parcel.writeParcelable(this.f2306e, i2);
            parcel.writeParcelable(this.f2307f, i2);
            parcel.writeBundle(this.f2308g);
            parcel.writeParcelable(this.f2309h, i2);
            return;
        }
        g.a(a(), parcel, i2);
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f2302a = parcel.readString();
        this.f2303b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2304c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2305d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f2306e = (Bitmap) parcel.readParcelable(classLoader);
        this.f2307f = (Uri) parcel.readParcelable(classLoader);
        this.f2308g = parcel.readBundle(classLoader);
        this.f2309h = (Uri) parcel.readParcelable(classLoader);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L80
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L80
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = a.b.g.f.g.e(r8)
            r1.a(r2)
            java.lang.CharSequence r2 = a.b.g.f.g.g(r8)
            r1.c(r2)
            java.lang.CharSequence r2 = a.b.g.f.g.f(r8)
            r1.b(r2)
            java.lang.CharSequence r2 = a.b.g.f.g.a(r8)
            r1.a(r2)
            android.graphics.Bitmap r2 = a.b.g.f.g.c(r8)
            r1.a(r2)
            android.net.Uri r2 = a.b.g.f.g.d(r8)
            r1.a(r2)
            android.os.Bundle r2 = a.b.g.f.g.b(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L4a
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L4b
        L4a:
            r4 = r0
        L4b:
            if (r4 == 0) goto L63
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L5d
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L5d
            goto L64
        L5d:
            r2.remove(r3)
            r2.remove(r5)
        L63:
            r0 = r2
        L64:
            r1.a(r0)
            if (r4 == 0) goto L6d
            r1.b(r4)
            goto L7a
        L6d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L7a
            android.net.Uri r0 = a.b.g.f.h.a(r8)
            r1.b(r0)
        L7a:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.f2310i = r8
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }
}
