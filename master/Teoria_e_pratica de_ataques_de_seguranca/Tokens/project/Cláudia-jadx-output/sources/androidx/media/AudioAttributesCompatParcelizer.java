package androidx.media;

import a.b.g.f.a;
import android.support.v4.media.AudioAttributesCompat;
import androidx.versionedparcelable.VersionedParcel;
/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f2291a = (a) versionedParcel.a((VersionedParcel) audioAttributesCompat.f2291a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(audioAttributesCompat.f2291a, 1);
    }
}
