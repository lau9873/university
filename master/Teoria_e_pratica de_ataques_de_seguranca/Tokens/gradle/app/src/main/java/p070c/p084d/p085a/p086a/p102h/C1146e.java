package p070c.p084d.p085a.p086a.p102h;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.h.e */
/* loaded from: classes.dex */
public final class C1146e {
    /* renamed from: a */
    public static <T extends InterfaceC1143d> T m5058a(byte[] bArr, Parcelable.Creator<T> creator) {
        C1049c0.m5294a(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T extends InterfaceC1143d> ArrayList<T> m5059a(Intent intent, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(m5058a((byte[]) obj, creator));
        }
        return arrayList2;
    }
}
