package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Looper;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0906a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;

/* renamed from: c.d.a.a.e.e.l.t0 */
/* loaded from: classes.dex */
public final class C1011t0<O extends C0905a.InterfaceC0906a> extends C0970j {

    /* renamed from: c */
    public final C0919c<O> f5320c;

    public C1011t0(C0919c<O> c0919c) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f5320c = c0919c;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5371a(T t) {
        this.f5320c.m5599a((C0919c<O>) t);
        return t;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: a */
    public final void mo5370a(C1020v1 c1020v1) {
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d
    /* renamed from: c */
    public final Looper mo5369c() {
        return this.f5320c.m5597b();
    }
}
