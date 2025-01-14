package android.support.v4.media;

import a.b.g.f.e;
import a.b.g.g.g;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
/* loaded from: classes.dex */
public class MediaBrowserCompat$ItemReceiver extends g {

    /* renamed from: c  reason: collision with root package name */
    public final String f2295c;

    /* renamed from: d  reason: collision with root package name */
    public final e f2296d;

    @Override // a.b.g.g.g
    public void a(int i2, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i2 == 0 && bundle != null && bundle.containsKey("media_item")) {
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
                this.f2296d.a(this.f2295c);
                return;
            } else {
                this.f2296d.a((MediaBrowserCompat$MediaItem) parcelable);
                return;
            }
        }
        this.f2296d.a(this.f2295c);
    }
}
