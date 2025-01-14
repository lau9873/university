package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.p098h.C1102e;

/* renamed from: c.d.a.a.e.e.l.a */
/* loaded from: classes.dex */
public abstract class AbstractC0933a {
    public AbstractC0933a(int i) {
    }

    /* renamed from: a */
    public static Status m5582a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (C1102e.m5135c() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    /* renamed from: a */
    public abstract void mo5333a(C0953f c0953f, boolean z);

    /* renamed from: a */
    public abstract void mo5311a(C0979l0<?> c0979l0);

    /* renamed from: a */
    public abstract void mo5310a(Status status);
}
