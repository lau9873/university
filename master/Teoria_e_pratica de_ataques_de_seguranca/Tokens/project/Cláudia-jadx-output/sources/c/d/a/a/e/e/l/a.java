package c.d.a.a.e.e.l;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class a {
    public a(int i2) {
    }

    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (c.d.a.a.e.h.e.c() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(f fVar, boolean z);

    public abstract void a(l0<?> l0Var);

    public abstract void a(Status status);
}
