package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0906a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.y2 */
/* loaded from: classes.dex */
public final class C1033y2<O extends C0905a.InterfaceC0906a> extends C0919c<O> {

    /* renamed from: i */
    public final C0905a.InterfaceC0916f f5362i;

    /* renamed from: j */
    public final C1009s2 f5363j;

    /* renamed from: k */
    public final C1086u0 f5364k;

    /* renamed from: l */
    public final C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5365l;

    public C1033y2(Context context, C0905a<O> c0905a, Looper looper, C0905a.InterfaceC0916f interfaceC0916f, C1009s2 c1009s2, C1086u0 c1086u0, C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> abstractC0912b) {
        super(context, c0905a, looper);
        this.f5362i = interfaceC0916f;
        this.f5363j = c1009s2;
        this.f5364k = c1086u0;
        this.f5365l = abstractC0912b;
        this.f5074h.m5499a(this);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.C0919c
    /* renamed from: a */
    public final C0905a.InterfaceC0916f mo5313a(Looper looper, C0979l0<O> c0979l0) {
        this.f5363j.m5372a(c0979l0);
        return this.f5362i;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.C0919c
    /* renamed from: a */
    public final BinderC0988n1 mo5314a(Context context, Handler handler) {
        return new BinderC0988n1(context, handler, this.f5364k, this.f5365l);
    }

    /* renamed from: f */
    public final C0905a.InterfaceC0916f m5312f() {
        return this.f5362i;
    }
}
