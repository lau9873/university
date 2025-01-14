package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import p000a.p006b.p030g.p039f.AudioAttributesImplBase;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1457a = versionedParcel.m6271a(audioAttributesImplBase.f1457a, 1);
        audioAttributesImplBase.f1458b = versionedParcel.m6271a(audioAttributesImplBase.f1458b, 2);
        audioAttributesImplBase.f1459c = versionedParcel.m6271a(audioAttributesImplBase.f1459c, 3);
        audioAttributesImplBase.f1460d = versionedParcel.m6271a(audioAttributesImplBase.f1460d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.m6263a(false, false);
        versionedParcel.m6261b(audioAttributesImplBase.f1457a, 1);
        versionedParcel.m6261b(audioAttributesImplBase.f1458b, 2);
        versionedParcel.m6261b(audioAttributesImplBase.f1459c, 3);
        versionedParcel.m6261b(audioAttributesImplBase.f1460d, 4);
    }
}
