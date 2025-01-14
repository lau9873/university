package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.p065v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3553a = versionedParcel.m6271a(iconCompat.f3553a, 1);
        iconCompat.f3555c = versionedParcel.m6262a(iconCompat.f3555c, 2);
        iconCompat.f3556d = versionedParcel.m6270a((VersionedParcel) iconCompat.f3556d, 3);
        iconCompat.f3557e = versionedParcel.m6271a(iconCompat.f3557e, 4);
        iconCompat.f3558f = versionedParcel.m6271a(iconCompat.f3558f, 5);
        iconCompat.f3559g = (ColorStateList) versionedParcel.m6270a((VersionedParcel) iconCompat.f3559g, 6);
        iconCompat.f3561i = versionedParcel.m6265a(iconCompat.f3561i, 7);
        iconCompat.m7401c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.m6263a(true, true);
        iconCompat.m7404a(versionedParcel.m6255c());
        versionedParcel.m6261b(iconCompat.f3553a, 1);
        versionedParcel.m6256b(iconCompat.f3555c, 2);
        versionedParcel.m6260b(iconCompat.f3556d, 3);
        versionedParcel.m6261b(iconCompat.f3557e, 4);
        versionedParcel.m6261b(iconCompat.f3558f, 5);
        versionedParcel.m6260b(iconCompat.f3559g, 6);
        versionedParcel.m6257b(iconCompat.f3561i, 7);
    }
}
