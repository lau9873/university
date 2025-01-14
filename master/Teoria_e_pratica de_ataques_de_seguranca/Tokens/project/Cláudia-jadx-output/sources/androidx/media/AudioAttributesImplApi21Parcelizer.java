package androidx.media;

import a.b.g.f.b;
import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;
/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static b read(VersionedParcel versionedParcel) {
        b bVar = new b();
        bVar.f945a = (AudioAttributes) versionedParcel.a((VersionedParcel) bVar.f945a, 1);
        bVar.f946b = versionedParcel.a(bVar.f946b, 2);
        return bVar;
    }

    public static void write(b bVar, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(bVar.f945a, 1);
        versionedParcel.b(bVar.f946b, 2);
    }
}
