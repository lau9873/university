package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;
import p000a.p006b.p030g.p039f.AudioAttributesImplApi21;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f1455a = (AudioAttributes) versionedParcel.m6270a((VersionedParcel) audioAttributesImplApi21.f1455a, 1);
        audioAttributesImplApi21.f1456b = versionedParcel.m6271a(audioAttributesImplApi21.f1456b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.m6263a(false, false);
        versionedParcel.m6260b(audioAttributesImplApi21.f1455a, 1);
        versionedParcel.m6261b(audioAttributesImplApi21.f1456b, 2);
    }
}
