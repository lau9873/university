package c.d.a.a.e.e.l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class z<T> extends a {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.a.a.j.d<T> f3450a;

    public z(int i2, c.d.a.a.j.d<T> dVar) {
        super(i2);
        this.f3450a = dVar;
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(l0<?> l0Var) {
        Status a2;
        Status a3;
        try {
            b(l0Var);
        } catch (DeadObjectException e2) {
            a3 = a.a(e2);
            a(a3);
            throw e2;
        } catch (RemoteException e3) {
            a2 = a.a(e3);
            a(a2);
        } catch (RuntimeException e4) {
            a(e4);
        }
    }

    @Override // c.d.a.a.e.e.l.a
    public void a(Status status) {
        this.f3450a.b(new ApiException(status));
    }

    public void a(RuntimeException runtimeException) {
        this.f3450a.b(runtimeException);
    }

    public abstract void b(l0<?> l0Var);
}
