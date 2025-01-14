package android.support.p065v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p065v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import p000a.p006b.p030g.p039f.AbstractC0224f;
import p000a.p006b.p030g.p041g.ResultReceiver;

/* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
/* loaded from: classes.dex */
public class MediaBrowserCompat$SearchResultReceiver extends ResultReceiver {

    /* renamed from: c */
    public final String f3571c;

    /* renamed from: d */
    public final Bundle f3572d;

    /* renamed from: e */
    public final AbstractC0224f f3573e;

    @Override // p000a.p006b.p030g.p041g.ResultReceiver
    /* renamed from: a */
    public void mo7398a(int i, Bundle bundle) {
        MediaSessionCompat.m7378a(bundle);
        if (i == 0 && bundle != null && bundle.containsKey("search_results")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
                }
            }
            this.f3573e.m9819a(this.f3571c, this.f3572d, arrayList);
            return;
        }
        this.f3573e.m9820a(this.f3571c, this.f3572d);
    }
}
