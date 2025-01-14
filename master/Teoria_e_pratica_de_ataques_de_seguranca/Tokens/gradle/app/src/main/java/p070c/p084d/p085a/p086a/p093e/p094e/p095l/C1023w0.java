package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0981l2;

/* renamed from: c.d.a.a.e.e.l.w0 */
/* loaded from: classes.dex */
public final class C1023w0<A extends AbstractC0981l2<? extends InterfaceC0928g, C0905a.InterfaceC0913c>> extends AbstractC0933a {

    /* renamed from: a */
    public A f5350a;

    public C1023w0(int i, A a) {
        super(i);
        this.f5350a = a;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5333a(C0953f c0953f, boolean z) {
        c0953f.m5534a(this.f5350a, z);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5311a(C0979l0<?> c0979l0) {
        try {
            this.f5350a.m5437b(c0979l0.m5451g());
        } catch (RuntimeException e) {
            String simpleName = e.getClass().getSimpleName();
            String localizedMessage = e.getLocalizedMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
            sb.append(simpleName);
            sb.append(": ");
            sb.append(localizedMessage);
            this.f5350a.m5436c(new Status(10, sb.toString()));
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5310a(Status status) {
        this.f5350a.m5436c(status);
    }
}
