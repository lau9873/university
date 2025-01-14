package c.d.a.a.e.e.l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.a.c;
import c.d.a.a.e.e.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
/* loaded from: classes.dex */
public abstract class l2<R extends c.d.a.a.e.e.g, A extends a.c> extends BasePendingResult<R> implements m2<R> {
    public final a.d<A> q;
    public final c.d.a.a.e.e.a<?> r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(c.d.a.a.e.e.a<?> aVar, c.d.a.a.e.e.d dVar) {
        super(dVar);
        c.d.a.a.e.f.c0.a(dVar, "GoogleApiClient must not be null");
        c.d.a.a.e.f.c0.a(aVar, "Api must not be null");
        this.q = (a.d<A>) aVar.d();
        this.r = aVar;
    }

    public final void a(RemoteException remoteException) {
        c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public abstract void a(A a2);

    public final void b(A a2) {
        try {
            a((l2<R, A>) a2);
        } catch (DeadObjectException e2) {
            a(e2);
            throw e2;
        } catch (RemoteException e3) {
            a(e3);
        }
    }

    public final void c(Status status) {
        c.d.a.a.e.f.c0.a(!status.e(), "Failed result must not be success");
        a(status);
        a((l2<R, A>) status);
    }

    public final a.d<A> h() {
        return this.q;
    }

    public final c.d.a.a.e.e.a<?> i() {
        return this.r;
    }
}
