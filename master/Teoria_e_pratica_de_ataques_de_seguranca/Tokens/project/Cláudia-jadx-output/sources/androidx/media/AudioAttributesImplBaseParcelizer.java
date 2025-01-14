package androidx.media;

import a.b.g.f.c;
import androidx.versionedparcelable.VersionedParcel;
/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static c read(VersionedParcel versionedParcel) {
        c cVar = new c();
        cVar.f947a = versionedParcel.a(cVar.f947a, 1);
        cVar.f948b = versionedParcel.a(cVar.f948b, 2);
        cVar.f949c = versionedParcel.a(cVar.f949c, 3);
        cVar.f950d = versionedParcel.a(cVar.f950d, 4);
        return cVar;
    }

    public static void write(c cVar, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(cVar.f947a, 1);
        versionedParcel.b(cVar.f948b, 2);
        versionedParcel.b(cVar.f949c, 3);
        versionedParcel.b(cVar.f950d, 4);
    }
}
