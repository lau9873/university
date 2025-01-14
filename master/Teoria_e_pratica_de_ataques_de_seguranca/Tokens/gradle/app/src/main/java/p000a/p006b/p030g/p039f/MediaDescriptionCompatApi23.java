package p000a.p006b.p030g.p039f;

import android.media.MediaDescription;
import android.net.Uri;

/* renamed from: a.b.g.f.h */
/* loaded from: classes.dex */
public class MediaDescriptionCompatApi23 {

    /* compiled from: MediaDescriptionCompatApi23.java */
    /* renamed from: a.b.g.f.h$a */
    /* loaded from: classes.dex */
    public static class C0226a {
        /* renamed from: a */
        public static void m9799a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    /* renamed from: a */
    public static Uri m9800a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
