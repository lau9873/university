package a.b.g.f.j;

import a.b.g.f.j.a;
import a.b.g.f.j.f;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;
import java.util.List;
/* compiled from: MediaControllerCompat.java */
/* loaded from: classes.dex */
public abstract class c implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public a f952a;

    /* renamed from: b  reason: collision with root package name */
    public a.b.g.f.j.a f953b;

    /* compiled from: MediaControllerCompat.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 21) {
            f.a(new b(this));
        } else {
            this.f953b = new BinderC0025c(this);
        }
    }

    public void a() {
    }

    public void a(int i2, Object obj, Bundle bundle) {
        a aVar = this.f952a;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(i2, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void a(e eVar) {
    }

    public void a(Bundle bundle) {
    }

    public void a(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void a(PlaybackStateCompat playbackStateCompat) {
    }

    public void a(CharSequence charSequence) {
    }

    public void a(String str, Bundle bundle) {
    }

    public void a(List<MediaSessionCompat.QueueItem> list) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        a(8, null, null);
    }

    /* compiled from: MediaControllerCompat.java */
    /* renamed from: a.b.g.f.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class BinderC0025c extends a.AbstractBinderC0023a {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<c> f955a;

        public BinderC0025c(c cVar) {
            this.f955a = new WeakReference<>(cVar);
        }

        @Override // a.b.g.f.j.a
        public void a(String str, Bundle bundle) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(1, str, bundle);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(boolean z) {
        }

        @Override // a.b.g.f.j.a
        public void b(boolean z) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(11, Boolean.valueOf(z), null);
            }
        }

        @Override // a.b.g.f.j.a
        public void c() {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(8, null, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void d() {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(13, null, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(PlaybackStateCompat playbackStateCompat) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(2, playbackStateCompat, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void b(int i2) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(12, Integer.valueOf(i2), null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(MediaMetadataCompat mediaMetadataCompat) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(3, mediaMetadataCompat, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(List<MediaSessionCompat.QueueItem> list) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(5, list, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(CharSequence charSequence) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(6, charSequence, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(int i2) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(9, Integer.valueOf(i2), null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(Bundle bundle) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(7, bundle, null);
            }
        }

        @Override // a.b.g.f.j.a
        public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
            c cVar = this.f955a.get();
            if (cVar != null) {
                cVar.a(4, parcelableVolumeInfo != null ? new e(parcelableVolumeInfo.f2334a, parcelableVolumeInfo.f2335b, parcelableVolumeInfo.f2336c, parcelableVolumeInfo.f2337d, parcelableVolumeInfo.f2338e) : null, null);
            }
        }
    }

    /* compiled from: MediaControllerCompat.java */
    /* loaded from: classes.dex */
    public static class b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<c> f954a;

        public b(c cVar) {
            this.f954a = new WeakReference<>(cVar);
        }

        @Override // a.b.g.f.j.f.a
        public void a(String str, Bundle bundle) {
            c cVar = this.f954a.get();
            if (cVar != null) {
                if (cVar.f953b == null || Build.VERSION.SDK_INT >= 23) {
                    cVar.a(str, bundle);
                }
            }
        }

        @Override // a.b.g.f.j.f.a
        public void b(Object obj) {
            c cVar = this.f954a.get();
            if (cVar == null || cVar.f953b != null) {
                return;
            }
            cVar.a(PlaybackStateCompat.a(obj));
        }

        @Override // a.b.g.f.j.f.a
        public void c() {
            c cVar = this.f954a.get();
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // a.b.g.f.j.f.a
        public void a(Object obj) {
            c cVar = this.f954a.get();
            if (cVar != null) {
                cVar.a(MediaMetadataCompat.a(obj));
            }
        }

        @Override // a.b.g.f.j.f.a
        public void a(List<?> list) {
            c cVar = this.f954a.get();
            if (cVar != null) {
                cVar.a(MediaSessionCompat.QueueItem.a(list));
            }
        }

        @Override // a.b.g.f.j.f.a
        public void a(CharSequence charSequence) {
            c cVar = this.f954a.get();
            if (cVar != null) {
                cVar.a(charSequence);
            }
        }

        @Override // a.b.g.f.j.f.a
        public void a(Bundle bundle) {
            c cVar = this.f954a.get();
            if (cVar != null) {
                cVar.a(bundle);
            }
        }

        @Override // a.b.g.f.j.f.a
        public void a(int i2, int i3, int i4, int i5, int i6) {
            c cVar = this.f954a.get();
            if (cVar != null) {
                cVar.a(new e(i2, i3, i4, i5, i6));
            }
        }
    }
}
