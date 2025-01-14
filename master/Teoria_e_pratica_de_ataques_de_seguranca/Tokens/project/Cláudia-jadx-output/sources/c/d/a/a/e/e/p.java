package c.d.a.a.e.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i3 != 2) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                str = c.d.a.a.h.b.h(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new Scope(i2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i2) {
        return new Scope[i2];
    }
}
