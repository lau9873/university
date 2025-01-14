package p070c.p084d.p085a.p086a.p102h;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c.d.a.a.h.o1 */
/* loaded from: classes.dex */
public class C1178o1 {
    static {
        C1178o1.class.getClassLoader();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m5023a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m5024a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    /* renamed from: a */
    public static void m5022a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static void m5021a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static boolean m5025a(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
