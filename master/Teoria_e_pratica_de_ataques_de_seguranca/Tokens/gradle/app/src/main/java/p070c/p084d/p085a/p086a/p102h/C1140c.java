package p070c.p084d.p085a.p086a.p102h;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: c.d.a.a.h.c */
/* loaded from: classes.dex */
public final class C1140c {
    /* renamed from: a */
    public static int m5080a(Parcel parcel) {
        return m5079a(parcel, 20293);
    }

    /* renamed from: a */
    public static int m5079a(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: a */
    public static void m5078a(Parcel parcel, int i, float f) {
        m5077a(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m5077a(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
            return;
        }
        parcel.writeInt(i | (-65536));
        parcel.writeInt(i2);
    }

    /* renamed from: a */
    public static void m5076a(Parcel parcel, int i, long j) {
        m5077a(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m5075a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            return;
        }
        int m5079a = m5079a(parcel, i);
        parcel.writeBundle(bundle);
        m5067b(parcel, m5079a);
    }

    /* renamed from: a */
    public static void m5074a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            return;
        }
        int m5079a = m5079a(parcel, i);
        parcel.writeStrongBinder(iBinder);
        m5067b(parcel, m5079a);
    }

    /* renamed from: a */
    public static void m5073a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                m5077a(parcel, i, 0);
                return;
            }
            return;
        }
        int m5079a = m5079a(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        m5067b(parcel, m5079a);
    }

    /* renamed from: a */
    public static void m5072a(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                m5077a(parcel, i, 0);
                return;
            }
            return;
        }
        int m5079a = m5079a(parcel, i);
        parcel.writeString(str);
        m5067b(parcel, m5079a);
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m5071a(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                m5077a(parcel, i, 0);
                return;
            }
            return;
        }
        int m5079a = m5079a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m5068a(parcel, t, 0);
            }
        }
        m5067b(parcel, m5079a);
    }

    /* renamed from: a */
    public static void m5070a(Parcel parcel, int i, boolean z) {
        m5077a(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m5069a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            return;
        }
        int m5079a = m5079a(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m5068a(parcel, t, i2);
            }
        }
        m5067b(parcel, m5079a);
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m5068a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: b */
    public static void m5067b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: b */
    public static void m5066b(Parcel parcel, int i, int i2) {
        m5077a(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: c */
    public static void m5065c(Parcel parcel, int i) {
        m5067b(parcel, i);
    }
}
