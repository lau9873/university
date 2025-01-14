package android.support.p065v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p065v4.media.session.MediaSessionCompat;
import p000a.p006b.p030g.p039f.AbstractC0223e;
import p000a.p006b.p030g.p041g.ResultReceiver;

/* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
/* loaded from: classes.dex */
public class MediaBrowserCompat$ItemReceiver extends ResultReceiver {

    /* renamed from: c */
    public final String f3567c;

    /* renamed from: d */
    public final AbstractC0223e f3568d;

    @Override // p000a.p006b.p030g.p041g.ResultReceiver
    /* renamed from: a */
    public void mo7398a(int i, Bundle bundle) {
        MediaSessionCompat.m7378a(bundle);
        if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
                this.f3568d.m9821a(this.f3567c);
                return;
            } else {
                this.f3568d.m9822a((MediaBrowserCompat$MediaItem) parcelable);
                return;
            }
        }
        this.f3568d.m9821a(this.f3567c);
    }
}
