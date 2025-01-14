package android.support.p065v4.media;

import android.os.Bundle;
import android.support.p065v4.media.session.MediaSessionCompat;
import android.util.Log;
import p000a.p006b.p030g.p039f.MediaBrowserCompat;
import p000a.p006b.p030g.p041g.ResultReceiver;

/* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
/* loaded from: classes.dex */
public class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver {

    /* renamed from: c */
    public final String f3564c;

    /* renamed from: d */
    public final Bundle f3565d;

    /* renamed from: e */
    public final MediaBrowserCompat f3566e;

    @Override // p000a.p006b.p030g.p041g.ResultReceiver
    /* renamed from: a */
    public void mo7398a(int i, Bundle bundle) {
        if (this.f3566e == null) {
            return;
        }
        MediaSessionCompat.m7378a(bundle);
        if (i == -1) {
            this.f3566e.m9825a(this.f3564c, this.f3565d, bundle);
        } else if (i == 0) {
            this.f3566e.m9823c(this.f3564c, this.f3565d, bundle);
        } else if (i != 1) {
            Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f3565d + ", resultData=" + bundle + ")");
        } else {
            this.f3566e.m9824b(this.f3564c, this.f3565d, bundle);
        }
    }
}
