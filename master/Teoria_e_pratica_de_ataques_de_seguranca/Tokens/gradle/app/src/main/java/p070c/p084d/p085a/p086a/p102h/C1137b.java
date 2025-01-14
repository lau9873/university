package p070c.p084d.p085a.p086a.p102h;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgn;
import java.util.ArrayList;

/* renamed from: c.d.a.a.h.b */
/* loaded from: classes.dex */
public final class C1137b {
    /* renamed from: a */
    public static int m5095a(Parcel parcel) {
        int readInt = parcel.readInt();
        int m5094a = m5094a(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new zzbgn(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = m5094a + dataPosition;
        if (i < dataPosition || i > parcel.dataSize()) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i);
            throw new zzbgn(sb.toString(), parcel);
        }
        return i;
    }

    /* renamed from: a */
    public static int m5094a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m5092a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int m5094a = m5094a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m5094a == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + m5094a);
        return createFromParcel;
    }

    /* renamed from: a */
    public static void m5093a(Parcel parcel, int i, int i2) {
        int m5094a = m5094a(parcel, i);
        if (m5094a == i2) {
            return;
        }
        String hexString = Integer.toHexString(m5094a);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(m5094a);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new zzbgn(sb.toString(), parcel);
    }

    /* renamed from: b */
    public static void m5091b(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new zzbgn(sb.toString(), parcel);
    }

    /* renamed from: b */
    public static <T> T[] m5090b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int m5094a = m5094a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m5094a == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + m5094a);
        return tArr;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m5088c(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int m5094a = m5094a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m5094a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + m5094a);
        return createTypedArrayList;
    }

    /* renamed from: c */
    public static void m5089c(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m5094a(parcel, i));
    }

    /* renamed from: d */
    public static boolean m5087d(Parcel parcel, int i) {
        m5093a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: e */
    public static int m5086e(Parcel parcel, int i) {
        m5093a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: f */
    public static long m5085f(Parcel parcel, int i) {
        m5093a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: g */
    public static float m5084g(Parcel parcel, int i) {
        m5093a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: h */
    public static String m5083h(Parcel parcel, int i) {
        int m5094a = m5094a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m5094a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + m5094a);
        return readString;
    }

    /* renamed from: i */
    public static IBinder m5082i(Parcel parcel, int i) {
        int m5094a = m5094a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m5094a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + m5094a);
        return readStrongBinder;
    }

    /* renamed from: j */
    public static Bundle m5081j(Parcel parcel, int i) {
        int m5094a = m5094a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m5094a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + m5094a);
        return readBundle;
    }
}
