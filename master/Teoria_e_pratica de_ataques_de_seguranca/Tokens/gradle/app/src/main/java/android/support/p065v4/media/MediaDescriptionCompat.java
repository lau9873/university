package android.support.p065v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21;
import p000a.p006b.p030g.p039f.MediaDescriptionCompatApi23;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C0614a();

    /* renamed from: a */
    public final String f3574a;

    /* renamed from: b */
    public final CharSequence f3575b;

    /* renamed from: c */
    public final CharSequence f3576c;

    /* renamed from: d */
    public final CharSequence f3577d;

    /* renamed from: e */
    public final Bitmap f3578e;

    /* renamed from: f */
    public final Uri f3579f;

    /* renamed from: g */
    public final Bundle f3580g;

    /* renamed from: h */
    public final Uri f3581h;

    /* renamed from: i */
    public Object f3582i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    /* loaded from: classes.dex */
    public static class C0614a implements Parcelable.Creator<MediaDescriptionCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m7396a(MediaDescriptionCompatApi21.m9818a(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$b */
    /* loaded from: classes.dex */
    public static final class C0615b {

        /* renamed from: a */
        public String f3583a;

        /* renamed from: b */
        public CharSequence f3584b;

        /* renamed from: c */
        public CharSequence f3585c;

        /* renamed from: d */
        public CharSequence f3586d;

        /* renamed from: e */
        public Bitmap f3587e;

        /* renamed from: f */
        public Uri f3588f;

        /* renamed from: g */
        public Bundle f3589g;

        /* renamed from: h */
        public Uri f3590h;

        /* renamed from: a */
        public C0615b m7390a(String str) {
            this.f3583a = str;
            return this;
        }

        /* renamed from: b */
        public C0615b m7388b(CharSequence charSequence) {
            this.f3585c = charSequence;
            return this;
        }

        /* renamed from: c */
        public C0615b m7387c(CharSequence charSequence) {
            this.f3584b = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0615b m7391a(CharSequence charSequence) {
            this.f3586d = charSequence;
            return this;
        }

        /* renamed from: b */
        public C0615b m7389b(Uri uri) {
            this.f3590h = uri;
            return this;
        }

        /* renamed from: a */
        public C0615b m7394a(Bitmap bitmap) {
            this.f3587e = bitmap;
            return this;
        }

        /* renamed from: a */
        public C0615b m7393a(Uri uri) {
            this.f3588f = uri;
            return this;
        }

        /* renamed from: a */
        public C0615b m7392a(Bundle bundle) {
            this.f3589g = bundle;
            return this;
        }

        /* renamed from: a */
        public MediaDescriptionCompat m7395a() {
            return new MediaDescriptionCompat(this.f3583a, this.f3584b, this.f3585c, this.f3586d, this.f3587e, this.f3588f, this.f3589g, this.f3590h);
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f3574a = str;
        this.f3575b = charSequence;
        this.f3576c = charSequence2;
        this.f3577d = charSequence3;
        this.f3578e = bitmap;
        this.f3579f = uri;
        this.f3580g = bundle;
        this.f3581h = uri2;
    }

    /* renamed from: a */
    public Object m7397a() {
        if (this.f3582i == null && Build.VERSION.SDK_INT >= 21) {
            Object m9809a = MediaDescriptionCompatApi21.C0225a.m9809a();
            MediaDescriptionCompatApi21.C0225a.m9803a(m9809a, this.f3574a);
            MediaDescriptionCompatApi21.C0225a.m9801c(m9809a, this.f3575b);
            MediaDescriptionCompatApi21.C0225a.m9802b(m9809a, this.f3576c);
            MediaDescriptionCompatApi21.C0225a.m9804a(m9809a, this.f3577d);
            MediaDescriptionCompatApi21.C0225a.m9807a(m9809a, this.f3578e);
            MediaDescriptionCompatApi21.C0225a.m9806a(m9809a, this.f3579f);
            Bundle bundle = this.f3580g;
            if (Build.VERSION.SDK_INT < 23 && this.f3581h != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f3581h);
            }
            MediaDescriptionCompatApi21.C0225a.m9805a(m9809a, bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                MediaDescriptionCompatApi23.C0226a.m9799a(m9809a, this.f3581h);
            }
            this.f3582i = MediaDescriptionCompatApi21.C0225a.m9808a(m9809a);
            return this.f3582i;
        }
        return this.f3582i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f3575b) + ", " + ((Object) this.f3576c) + ", " + ((Object) this.f3577d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f3574a);
            TextUtils.writeToParcel(this.f3575b, parcel, i);
            TextUtils.writeToParcel(this.f3576c, parcel, i);
            TextUtils.writeToParcel(this.f3577d, parcel, i);
            parcel.writeParcelable(this.f3578e, i);
            parcel.writeParcelable(this.f3579f, i);
            parcel.writeBundle(this.f3580g);
            parcel.writeParcelable(this.f3581h, i);
            return;
        }
        MediaDescriptionCompatApi21.m9816a(m7397a(), parcel, i);
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f3574a = parcel.readString();
        this.f3575b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3576c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3577d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f3578e = (Bitmap) parcel.readParcelable(classLoader);
        this.f3579f = (Uri) parcel.readParcelable(classLoader);
        this.f3580g = parcel.readBundle(classLoader);
        this.f3581h = (Uri) parcel.readParcelable(classLoader);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.support.p065v4.media.MediaDescriptionCompat m7396a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L80
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L80
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9812e(r8)
            r1.m7390a(r2)
            java.lang.CharSequence r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9810g(r8)
            r1.m7387c(r2)
            java.lang.CharSequence r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9811f(r8)
            r1.m7388b(r2)
            java.lang.CharSequence r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9817a(r8)
            r1.m7391a(r2)
            android.graphics.Bitmap r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9814c(r8)
            r1.m7394a(r2)
            android.net.Uri r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9813d(r8)
            r1.m7393a(r2)
            android.os.Bundle r2 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi21.m9815b(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L4a
            android.support.p065v4.media.session.MediaSessionCompat.m7378a(r2)
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
            r1.m7392a(r0)
            if (r4 == 0) goto L6d
            r1.m7389b(r4)
            goto L7a
        L6d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L7a
            android.net.Uri r0 = p000a.p006b.p030g.p039f.MediaDescriptionCompatApi23.m9800a(r8)
            r1.m7389b(r0)
        L7a:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.m7395a()
            r0.f3582i = r8
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p065v4.media.MediaDescriptionCompat.m7396a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }
}
