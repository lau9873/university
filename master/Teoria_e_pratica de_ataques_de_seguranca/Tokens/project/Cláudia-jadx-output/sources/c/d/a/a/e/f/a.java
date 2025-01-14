package c.d.a.a.e.f;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
/* loaded from: classes.dex */
public final class a extends o {
    public static Account a(n nVar) {
        if (nVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return nVar.b();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
