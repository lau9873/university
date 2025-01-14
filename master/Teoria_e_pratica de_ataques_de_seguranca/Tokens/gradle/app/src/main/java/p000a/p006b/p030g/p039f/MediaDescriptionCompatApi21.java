package p000a.p006b.p030g.p039f;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* renamed from: a.b.g.f.g */
/* loaded from: classes.dex */
public class MediaDescriptionCompatApi21 {

    /* compiled from: MediaDescriptionCompatApi21.java */
    /* renamed from: a.b.g.f.g$a */
    /* loaded from: classes.dex */
    public static class C0225a {
        /* renamed from: a */
        public static Object m9809a() {
            return new MediaDescription.Builder();
        }

        /* renamed from: b */
        public static void m9802b(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        /* renamed from: c */
        public static void m9801c(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }

        /* renamed from: a */
        public static void m9803a(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        /* renamed from: a */
        public static void m9804a(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        /* renamed from: a */
        public static void m9807a(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        /* renamed from: a */
        public static void m9806a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        /* renamed from: a */
        public static void m9805a(Object obj, Bundle bundle) {
            ((MediaDescription.Builder) obj).setExtras(bundle);
        }

        /* renamed from: a */
        public static Object m9808a(Object obj) {
            return ((MediaDescription.Builder) obj).build();
        }
    }

    /* renamed from: a */
    public static CharSequence m9817a(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    /* renamed from: b */
    public static Bundle m9815b(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    /* renamed from: c */
    public static Bitmap m9814c(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    /* renamed from: d */
    public static Uri m9813d(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    /* renamed from: e */
    public static String m9812e(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    /* renamed from: f */
    public static CharSequence m9811f(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    /* renamed from: g */
    public static CharSequence m9810g(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    /* renamed from: a */
    public static void m9816a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    /* renamed from: a */
    public static Object m9818a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
