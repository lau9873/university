package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import p070c.p084d.p085a.p086a.p093e.C1107k;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.f.b */
/* loaded from: classes.dex */
public final class C1045b implements Parcelable.Creator<C1050c1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1050c1 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        C1107k[] c1107kArr = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = C1137b.m5086e(parcel, readInt);
                    break;
                case 2:
                    i2 = C1137b.m5086e(parcel, readInt);
                    break;
                case 3:
                    i3 = C1137b.m5086e(parcel, readInt);
                    break;
                case 4:
                    str = C1137b.m5083h(parcel, readInt);
                    break;
                case 5:
                    iBinder = C1137b.m5082i(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) C1137b.m5090b(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C1137b.m5081j(parcel, readInt);
                    break;
                case 8:
                    account = (Account) C1137b.m5092a(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    C1137b.m5089c(parcel, readInt);
                    break;
                case 10:
                    c1107kArr = (C1107k[]) C1137b.m5090b(parcel, readInt, C1107k.CREATOR);
                    break;
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1050c1(i, i2, i3, str, iBinder, scopeArr, bundle, account, c1107kArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1050c1[] newArray(int i) {
        return new C1050c1[i];
    }
}
