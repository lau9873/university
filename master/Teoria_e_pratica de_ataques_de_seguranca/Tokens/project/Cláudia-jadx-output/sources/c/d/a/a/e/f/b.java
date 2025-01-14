package c.d.a.a.e.f;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<c1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c1 createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        c.d.a.a.e.k[] kVarArr = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = c.d.a.a.h.b.e(parcel, readInt);
                    break;
                case 2:
                    i3 = c.d.a.a.h.b.e(parcel, readInt);
                    break;
                case 3:
                    i4 = c.d.a.a.h.b.e(parcel, readInt);
                    break;
                case 4:
                    str = c.d.a.a.h.b.h(parcel, readInt);
                    break;
                case 5:
                    iBinder = c.d.a.a.h.b.i(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) c.d.a.a.h.b.b(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = c.d.a.a.h.b.j(parcel, readInt);
                    break;
                case 8:
                    account = (Account) c.d.a.a.h.b.a(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    c.d.a.a.h.b.c(parcel, readInt);
                    break;
                case 10:
                    kVarArr = (c.d.a.a.e.k[]) c.d.a.a.h.b.b(parcel, readInt, c.d.a.a.e.k.CREATOR);
                    break;
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new c1(i2, i3, i4, str, iBinder, scopeArr, bundle, account, kVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c1[] newArray(int i2) {
        return new c1[i2];
    }
}
