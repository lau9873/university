package c.d.a.a.e.e.l;

import c.d.a.a.e.e.a;
import c.d.a.a.e.e.l.l2;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class w0<A extends l2<? extends c.d.a.a.e.e.g, a.c>> extends a {

    /* renamed from: a  reason: collision with root package name */
    public A f3437a;

    public w0(int i2, A a2) {
        super(i2);
        this.f3437a = a2;
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(f fVar, boolean z) {
        fVar.a(this.f3437a, z);
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(l0<?> l0Var) {
        try {
            this.f3437a.b(l0Var.g());
        } catch (RuntimeException e2) {
            String simpleName = e2.getClass().getSimpleName();
            String localizedMessage = e2.getLocalizedMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
            sb.append(simpleName);
            sb.append(": ");
            sb.append(localizedMessage);
            this.f3437a.c(new Status(10, sb.toString()));
        }
    }

    @Override // c.d.a.a.e.e.l.a
    public final void a(Status status) {
        this.f3437a.c(status);
    }
}
