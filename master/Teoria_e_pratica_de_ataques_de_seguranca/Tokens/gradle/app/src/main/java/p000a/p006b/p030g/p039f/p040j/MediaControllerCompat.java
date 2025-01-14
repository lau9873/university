package p000a.p006b.p030g.p039f.p040j;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.p065v4.media.MediaMetadataCompat;
import android.support.p065v4.media.session.MediaSessionCompat;
import android.support.p065v4.media.session.ParcelableVolumeInfo;
import android.support.p065v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;
import java.util.List;
import p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback;
import p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21;

/* renamed from: a.b.g.f.j.c */
/* loaded from: classes.dex */
public abstract class MediaControllerCompat implements IBinder.DeathRecipient {

    /* renamed from: a */
    public HandlerC0230a f1462a;

    /* renamed from: b */
    public IMediaControllerCallback f1463b;

    /* compiled from: MediaControllerCompat.java */
    /* renamed from: a.b.g.f.j.c$a */
    /* loaded from: classes.dex */
    public class HandlerC0230a extends Handler {
    }

    public MediaControllerCompat() {
        if (Build.VERSION.SDK_INT >= 21) {
            MediaControllerCompatApi21.m9779a(new C0231b(this));
        } else {
            this.f1463b = new BinderC0232c(this);
        }
    }

    /* renamed from: a */
    public void m9795a() {
    }

    /* renamed from: a */
    public void m9794a(int i, Object obj, Bundle bundle) {
        HandlerC0230a handlerC0230a = this.f1462a;
        if (handlerC0230a != null) {
            Message obtainMessage = handlerC0230a.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* renamed from: a */
    public void m9793a(C0234e c0234e) {
    }

    /* renamed from: a */
    public void m9792a(Bundle bundle) {
    }

    /* renamed from: a */
    public void m9791a(MediaMetadataCompat mediaMetadataCompat) {
    }

    /* renamed from: a */
    public void m9790a(PlaybackStateCompat playbackStateCompat) {
    }

    /* renamed from: a */
    public void m9789a(CharSequence charSequence) {
    }

    /* renamed from: a */
    public void m9788a(String str, Bundle bundle) {
    }

    /* renamed from: a */
    public void m9787a(List<MediaSessionCompat.QueueItem> list) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        m9794a(8, null, null);
    }

    /* compiled from: MediaControllerCompat.java */
    /* renamed from: a.b.g.f.j.c$c */
    /* loaded from: classes.dex */
    public static class BinderC0232c extends IMediaControllerCallback.AbstractBinderC0227a {

        /* renamed from: a */
        public final WeakReference<MediaControllerCompat> f1465a;

        public BinderC0232c(MediaControllerCompat mediaControllerCompat) {
            this.f1465a = new WeakReference<>(mediaControllerCompat);
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo9784a(String str, Bundle bundle) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(1, str, bundle);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo9783a(boolean z) {
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: b */
        public void mo9781b(boolean z) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(11, Boolean.valueOf(z), null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: c */
        public void mo7379c() {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(8, null, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: d */
        public void mo9780d() {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(13, null, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo9785a(PlaybackStateCompat playbackStateCompat) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(2, playbackStateCompat, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: b */
        public void mo9782b(int i) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(12, Integer.valueOf(i), null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7383a(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(3, mediaMetadataCompat, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7380a(List<MediaSessionCompat.QueueItem> list) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(5, list, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7381a(CharSequence charSequence) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(6, charSequence, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo9786a(int i) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(9, Integer.valueOf(i), null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7384a(Bundle bundle) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(7, bundle, null);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.IMediaControllerCallback
        /* renamed from: a */
        public void mo7382a(ParcelableVolumeInfo parcelableVolumeInfo) {
            MediaControllerCompat mediaControllerCompat = this.f1465a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9794a(4, parcelableVolumeInfo != null ? new C0234e(parcelableVolumeInfo.f3606a, parcelableVolumeInfo.f3607b, parcelableVolumeInfo.f3608c, parcelableVolumeInfo.f3609d, parcelableVolumeInfo.f3610e) : null, null);
            }
        }
    }

    /* compiled from: MediaControllerCompat.java */
    /* renamed from: a.b.g.f.j.c$b */
    /* loaded from: classes.dex */
    public static class C0231b implements MediaControllerCompatApi21.InterfaceC0235a {

        /* renamed from: a */
        public final WeakReference<MediaControllerCompat> f1464a;

        public C0231b(MediaControllerCompat mediaControllerCompat) {
            this.f1464a = new WeakReference<>(mediaControllerCompat);
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: a */
        public void mo9774a(String str, Bundle bundle) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                if (mediaControllerCompat.f1463b == null || Build.VERSION.SDK_INT >= 23) {
                    mediaControllerCompat.m9788a(str, bundle);
                }
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: b */
        public void mo9772b(Object obj) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat == null || mediaControllerCompat.f1463b != null) {
                return;
            }
            mediaControllerCompat.m9790a(PlaybackStateCompat.m7372a(obj));
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: c */
        public void mo9771c() {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9795a();
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: a */
        public void mo9775a(Object obj) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9791a(MediaMetadataCompat.m7386a(obj));
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: a */
        public void mo9773a(List<?> list) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9787a(MediaSessionCompat.QueueItem.m7376a(list));
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: a */
        public void mo9776a(CharSequence charSequence) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9789a(charSequence);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: a */
        public void mo9777a(Bundle bundle) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9792a(bundle);
            }
        }

        @Override // p000a.p006b.p030g.p039f.p040j.MediaControllerCompatApi21.InterfaceC0235a
        /* renamed from: a */
        public void mo9778a(int i, int i2, int i3, int i4, int i5) {
            MediaControllerCompat mediaControllerCompat = this.f1464a.get();
            if (mediaControllerCompat != null) {
                mediaControllerCompat.m9793a(new C0234e(i, i2, i3, i4, i5));
            }
        }
    }
}
