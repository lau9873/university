package android.support.v4.media.session;

import a.b.g.a.e;
import a.b.g.f.j.b;
import a.b.g.f.j.c;
import a.b.g.f.j.d;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class MediaControllerCompat$MediaControllerImplApi21 implements d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2324a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f2325b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<c, a> f2326c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaSessionCompat.Token f2327d;

    /* loaded from: classes.dex */
    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> f2328a;

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i2, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f2328a.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.f2324a) {
                mediaControllerCompat$MediaControllerImplApi21.f2327d.a(b.a.a(e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f2327d.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends c.BinderC0025c {
        public a(c cVar) {
            super(cVar);
        }

        @Override // a.b.g.f.j.c.BinderC0025c, a.b.g.f.j.a
        public void a(MediaMetadataCompat mediaMetadataCompat) {
            throw new AssertionError();
        }

        @Override // a.b.g.f.j.c.BinderC0025c, a.b.g.f.j.a
        public void c() {
            throw new AssertionError();
        }

        @Override // a.b.g.f.j.c.BinderC0025c, a.b.g.f.j.a
        public void a(List<MediaSessionCompat.QueueItem> list) {
            throw new AssertionError();
        }

        @Override // a.b.g.f.j.c.BinderC0025c, a.b.g.f.j.a
        public void a(CharSequence charSequence) {
            throw new AssertionError();
        }

        @Override // a.b.g.f.j.c.BinderC0025c, a.b.g.f.j.a
        public void a(Bundle bundle) {
            throw new AssertionError();
        }

        @Override // a.b.g.f.j.c.BinderC0025c, a.b.g.f.j.a
        public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
            throw new AssertionError();
        }
    }

    public void a() {
        if (this.f2327d.a() == null) {
            return;
        }
        for (c cVar : this.f2325b) {
            a aVar = new a(cVar);
            this.f2326c.put(cVar, aVar);
            cVar.f953b = aVar;
            try {
                this.f2327d.a().a(aVar);
                cVar.a(13, null, null);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
            }
        }
        this.f2325b.clear();
    }
}
