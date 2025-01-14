package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.d2 */
/* loaded from: classes.dex */
public final class C0948d2<TResult> extends AbstractC0933a {

    /* renamed from: a */
    public final AbstractC1016u1<C0905a.InterfaceC0913c, TResult> f5154a;

    /* renamed from: b */
    public final C1238d<TResult> f5155b;

    /* renamed from: c */
    public final InterfaceC1004r1 f5156c;

    public C0948d2(int i, AbstractC1016u1<C0905a.InterfaceC0913c, TResult> abstractC1016u1, C1238d<TResult> c1238d, InterfaceC1004r1 interfaceC1004r1) {
        super(i);
        this.f5155b = c1238d;
        this.f5154a = abstractC1016u1;
        this.f5156c = interfaceC1004r1;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5333a(C0953f c0953f, boolean z) {
        c0953f.m5535a(this.f5155b, z);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5311a(C0979l0<?> c0979l0) {
        Status m5582a;
        try {
            this.f5154a.mo4986a(c0979l0.m5451g(), this.f5155b);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            m5582a = AbstractC0933a.m5582a(e2);
            mo5310a(m5582a);
        } catch (RuntimeException e3) {
            this.f5155b.m4978b((Exception) e3);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5310a(Status status) {
        this.f5155b.m4978b(this.f5156c.mo5382a(status));
    }
}
