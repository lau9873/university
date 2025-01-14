package a.b.g.f.j;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;
/* compiled from: MediaControllerCompatApi21.java */
/* loaded from: classes.dex */
public class f {

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, int i3, int i4, int i5, int i6);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b(Object obj);

        void c();
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    public static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final T f956a;

        public b(T t) {
            this.f956a = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f956a.a(playbackInfo.getPlaybackType(), c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f956a.a(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f956a.a(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f956a.b(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f956a.a(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f956a.a(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f956a.c();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f956a.a(str, bundle);
        }
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    public static class c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }

        public static int a(AudioAttributes audioAttributes) {
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

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
