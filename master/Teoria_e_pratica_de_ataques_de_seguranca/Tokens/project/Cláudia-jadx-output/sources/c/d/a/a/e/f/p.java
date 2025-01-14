package c.d.a.a.e.f;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import c.d.a.a.h.m1;
import c.d.a.a.h.o1;
/* loaded from: classes.dex */
public final class p extends m1 implements n {
    public p(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // c.d.a.a.e.f.n
    public final Account b() {
        Parcel a2 = a(2, h());
        Account account = (Account) o1.a(a2, Account.CREATOR);
        a2.recycle();
        return account;
    }
}
