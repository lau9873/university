package p070c.p084d.p085a.p086a.p093e.p096f;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: c.d.a.a.e.f.a */
/* loaded from: classes.dex */
public final class BinderC1042a extends AbstractBinderC1073o {
    /* renamed from: a */
    public static Account m5299a(InterfaceC1071n interfaceC1071n) {
        if (interfaceC1071n != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return interfaceC1071n.mo5189b();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
