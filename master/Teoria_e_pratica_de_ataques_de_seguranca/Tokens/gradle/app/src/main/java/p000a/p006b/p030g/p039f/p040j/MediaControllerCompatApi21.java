package p000a.p006b.p030g.p039f.p040j;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.p065v4.media.session.MediaSessionCompat;
import java.util.List;

/* renamed from: a.b.g.f.j.f */
/* loaded from: classes.dex */
public class MediaControllerCompatApi21 {

    /* compiled from: MediaControllerCompatApi21.java */
    /* renamed from: a.b.g.f.j.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0235a {
        /* renamed from: a */
        void mo9778a(int i, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        void mo9777a(Bundle bundle);

        /* renamed from: a */
        void mo9776a(CharSequence charSequence);

        /* renamed from: a */
        void mo9775a(Object obj);

        /* renamed from: a */
        void mo9774a(String str, Bundle bundle);

        /* renamed from: a */
        void mo9773a(List<?> list);

        /* renamed from: b */
        void mo9772b(Object obj);

        /* renamed from: c */
        void mo9771c();
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* renamed from: a.b.g.f.j.f$b */
    /* loaded from: classes.dex */
    public static class C0236b<T extends InterfaceC0235a> extends MediaController.Callback {

        /* renamed from: a */
        public final T f1466a;

        public C0236b(T t) {
            this.f1466a = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f1466a.mo9778a(playbackInfo.getPlaybackType(), C0237c.m9768b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.m7378a(bundle);
            this.f1466a.mo9777a(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f1466a.mo9775a(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f1466a.mo9772b(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f1466a.mo9773a(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f1466a.mo9776a(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f1466a.mo9771c();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.m7378a(bundle);
            this.f1466a.mo9774a(str, bundle);
        }
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* renamed from: a.b.g.f.j.f$c */
    /* loaded from: classes.dex */
    public static class C0237c {
        /* renamed from: a */
        public static AudioAttributes m9769a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        /* renamed from: b */
        public static int m9768b(Object obj) {
            return m9770a(m9769a(obj));
        }

        /* renamed from: a */
        public static int m9770a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: a */
    public static Object m9779a(InterfaceC0235a interfaceC0235a) {
        return new C0236b(interfaceC0235a);
    }
}
