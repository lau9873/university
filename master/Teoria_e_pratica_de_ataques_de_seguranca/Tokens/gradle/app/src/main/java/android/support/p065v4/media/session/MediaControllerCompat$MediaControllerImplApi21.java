package android.support.p065v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p065v4.media.MediaMetadataCompat;
import android.support.p065v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import p000a.p006b.p030g.p031a.BundleCompat;
import p000a.p006b.p030g.p039f.p040j.IMediaSession;
import p000a.p006b.p030g.p039f.p040j.InterfaceC0233d;
import p000a.p006b.p030g.p039f.p040j.MediaControllerCompat;

/* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
/* loaded from: classes.dex */
public class MediaControllerCompat$MediaControllerImplApi21 implements InterfaceC0233d {

    /* renamed from: a */
    public final Object f3596a;

    /* renamed from: b */
    public final List<MediaControllerCompat> f3597b;

    /* renamed from: c */
    public HashMap<MediaControllerCompat, BinderC0618a> f3598c;

    /* renamed from: d */
    public final MediaSessionCompat.Token f3599d;

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
    /* loaded from: classes.dex */
    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: a */
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> f3600a;

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f3600a.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.f3596a) {
                mediaControllerCompat$MediaControllerImplApi21.f3599d.m7374a(IMediaSession.AbstractBinderC0228a.m9797a(BundleCompat.m10352a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f3599d.m7373a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.m7385a();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
    /* loaded from: classes.dex */
    public static class BinderC0618a extends MediaControllerCompat.BinderC0232c {
        public BinderC0618a(MediaControllerCompat mediaControllerCompat) {
            super(mediaControllerCompat);
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompat.BinderC0232c, p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7383a(MediaMetadataCompat mediaMetadataCompat) {
            throw new AssertionError();
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompat.BinderC0232c, p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: c */
        public void mo7379c() {
            throw new AssertionError();
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompat.BinderC0232c, p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7380a(List<MediaSessionCompat.QueueItem> list) {
            throw new AssertionError();
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompat.BinderC0232c, p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7381a(CharSequence charSequence) {
            throw new AssertionError();
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompat.BinderC0232c, p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7384a(Bundle bundle) {
            throw new AssertionError();
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompat.BinderC0232c, p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7382a(ParcelableVolumeInfo parcelableVolumeInfo) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void m7385a() {
        if (this.f3599d.m7375a() == null) {
            return;
        }
        for (MediaControllerCompat mediaControllerCompat : this.f3597b) {
            BinderC0618a binderC0618a = new BinderC0618a(mediaControllerCompat);
            this.f3598c.put(mediaControllerCompat, binderC0618a);
            mediaControllerCompat.f1463b = binderC0618a;
            try {
                this.f3599d.m7375a().mo9796a(binderC0618a);
                mediaControllerCompat.m9794a(13, null, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        this.f3597b.clear();
    }
}
