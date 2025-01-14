package androidx.media;

import android.support.p065v4.media.AudioAttributesCompat;
import androidx.versionedparcelable.VersionedParcel;
import p000a.p006b.p030g.p039f.AudioAttributesImpl;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3563a = (AudioAttributesImpl) versionedParcel.m6268a((VersionedParcel) audioAttributesCompat.f3563a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.m6263a(false, false);
        versionedParcel.m6258b(audioAttributesCompat.f3563a, 1);
    }
}
