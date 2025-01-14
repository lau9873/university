package c.d.a.a.h;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    public static int a(Parcel parcel) {
        return a(parcel, 20293);
    }

    public static int a(Parcel parcel, int i2) {
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i2, float f2) {
        a(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int i2, int i3) {
        if (i3 < 65535) {
            parcel.writeInt(i2 | (i3 << 16));
            return;
        }
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(i3);
    }

    public static void a(Parcel parcel, int i2, long j) {
        a(parcel, i2, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle == null) {
            return;
        }
        int a2 = a(parcel, i2);
        parcel.writeBundle(bundle);
        b(parcel, a2);
    }

    public static void a(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            return;
        }
        int a2 = a(parcel, i2);
        parcel.writeStrongBinder(iBinder);
        b(parcel, a2);
    }

    public static void a(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                a(parcel, i2, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        b(parcel, a2);
    }

    public static void a(Parcel parcel, int i2, String str, boolean z) {
        if (str == null) {
            if (z) {
                a(parcel, i2, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i2);
        parcel.writeString(str);
        b(parcel, a2);
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i2, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, 0);
            }
        }
        b(parcel, a2);
    }

    public static void a(Parcel parcel, int i2, boolean z) {
        a(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr == null) {
            return;
        }
        int a2 = a(parcel, i2);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, i3);
            }
        }
        b(parcel, a2);
    }

    public static <T extends Parcelable> void a(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void b(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void b(Parcel parcel, int i2, int i3) {
        a(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void c(Parcel parcel, int i2) {
        b(parcel, i2);
    }
}
