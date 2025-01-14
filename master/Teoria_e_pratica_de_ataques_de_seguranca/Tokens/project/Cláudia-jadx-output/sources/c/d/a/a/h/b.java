package c.d.a.a.h;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgn;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {
    public static int a(Parcel parcel) {
        int readInt = parcel.readInt();
        int a2 = a(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new zzbgn(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = a2 + dataPosition;
        if (i2 < dataPosition || i2 > parcel.dataSize()) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i2);
            throw new zzbgn(sb.toString(), parcel);
        }
        return i2;
    }

    public static int a(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + a2);
        return createFromParcel;
    }

    public static void a(Parcel parcel, int i2, int i3) {
        int a2 = a(parcel, i2);
        if (a2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(a2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(a2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new zzbgn(sb.toString(), parcel);
    }

    public static void b(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new zzbgn(sb.toString(), parcel);
    }

    public static <T> T[] b(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + a2);
        return tArr;
    }

    public static <T> ArrayList<T> c(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + a2);
        return createTypedArrayList;
    }

    public static void c(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + a(parcel, i2));
    }

    public static boolean d(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static int e(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long f(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readLong();
    }

    public static float g(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static String h(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + a2);
        return readString;
    }

    public static IBinder i(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + a2);
        return readStrongBinder;
    }

    public static Bundle j(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + a2);
        return readBundle;
    }
}
