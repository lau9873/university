package c.d.a.a.e.e.l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class d2<TResult> extends a {

    /* renamed from: a  reason: collision with root package name */
    public final u1<a.c, TResult> f3279a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.a.a.j.d<TResult> f3280b;

    /* renamed from: c  reason: collision with root package name */
    public final r1 f3281c;

    public d2(int i2, u1<a.c, TResult> u1Var, c.d.a.a.j.d<TResult> dVar, r1 r1Var) {
        super(i2);
        this.f3280b = dVar;
        this.f3279a = u1Var;
        this.f3281c = r1Var;
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(f fVar, boolean z) {
        fVar.a(this.f3280b, z);
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(l0<?> l0Var) {
        Status a2;
        try {
            this.f3279a.a(l0Var.g(), this.f3280b);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a2 = a.a(e3);
            a(a2);
        } catch (RuntimeException e4) {
            this.f3280b.b((Exception) e4);
        }
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(Status status) {
        this.f3280b.b(this.f3281c.a(status));
    }
}
