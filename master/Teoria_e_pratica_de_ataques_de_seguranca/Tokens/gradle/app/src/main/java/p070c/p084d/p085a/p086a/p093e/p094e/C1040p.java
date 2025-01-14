package p070c.p084d.p085a.p086a.p093e.p094e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.e.p */
/* loaded from: classes.dex */
public final class C1040p implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 != 2) {
                C1137b.m5089c(parcel, readInt);
            } else {
                str = C1137b.m5083h(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new Scope(i, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}
