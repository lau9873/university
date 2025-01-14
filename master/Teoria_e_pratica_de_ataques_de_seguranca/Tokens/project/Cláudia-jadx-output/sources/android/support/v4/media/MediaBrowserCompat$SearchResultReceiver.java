package android.support.v4.media;

import a.b.g.f.f;
import a.b.g.g.g;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MediaBrowserCompat$SearchResultReceiver extends g {

    /* renamed from: c  reason: collision with root package name */
    public final String f2299c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f2300d;

    /* renamed from: e  reason: collision with root package name */
    public final f f2301e;

    @Override // a.b.g.g.g
    public void a(int i2, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i2 == 0 && bundle != null && bundle.containsKey("search_results")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
                }
            }
            this.f2301e.a(this.f2299c, this.f2300d, arrayList);
            return;
        }
        this.f2301e.a(this.f2299c, this.f2300d);
    }
}
