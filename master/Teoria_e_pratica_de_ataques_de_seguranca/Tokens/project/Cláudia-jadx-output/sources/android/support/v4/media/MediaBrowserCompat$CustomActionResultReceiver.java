package android.support.v4.media;

import a.b.g.f.d;
import a.b.g.g.g;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
/* loaded from: classes.dex */
public class MediaBrowserCompat$CustomActionResultReceiver extends g {

    /* renamed from: c  reason: collision with root package name */
    public final String f2292c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f2293d;

    /* renamed from: e  reason: collision with root package name */
    public final d f2294e;

    @Override // a.b.g.g.g
    public void a(int i2, Bundle bundle) {
        if (this.f2294e == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i2 == -1) {
            this.f2294e.a(this.f2292c, this.f2293d, bundle);
        } else if (i2 == 0) {
            this.f2294e.c(this.f2292c, this.f2293d, bundle);
        } else if (i2 != 1) {
            Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f2293d + ", resultData=" + bundle + ")");
        } else {
            this.f2294e.b(this.f2292c, this.f2293d, bundle);
        }
    }
}
