package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2281a = versionedParcel.a(iconCompat.f2281a, 1);
        iconCompat.f2283c = versionedParcel.a(iconCompat.f2283c, 2);
        iconCompat.f2284d = versionedParcel.a((VersionedParcel) iconCompat.f2284d, 3);
        iconCompat.f2285e = versionedParcel.a(iconCompat.f2285e, 4);
        iconCompat.f2286f = versionedParcel.a(iconCompat.f2286f, 5);
        iconCompat.f2287g = (ColorStateList) versionedParcel.a((VersionedParcel) iconCompat.f2287g, 6);
        iconCompat.f2289i = versionedParcel.a(iconCompat.f2289i, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(true, true);
        iconCompat.a(versionedParcel.c());
        versionedParcel.b(iconCompat.f2281a, 1);
        versionedParcel.b(iconCompat.f2283c, 2);
        versionedParcel.b(iconCompat.f2284d, 3);
        versionedParcel.b(iconCompat.f2285e, 4);
        versionedParcel.b(iconCompat.f2286f, 5);
        versionedParcel.b(iconCompat.f2287g, 6);
        versionedParcel.b(iconCompat.f2289i, 7);
    }
}
