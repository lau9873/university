package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.e.l.w2 */
/* loaded from: classes.dex */
public final class C1025w2 implements InterfaceC1031y0 {

    /* renamed from: a */
    public /* synthetic */ C1017u2 f5353a;

    public C1025w2(C1017u2 c1017u2) {
        this.f5353a = c1017u2;
    }

    public /* synthetic */ C1025w2(C1017u2 c1017u2, RunnableC1021v2 runnableC1021v2) {
        this(c1017u2);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5320a(int i, boolean z) {
        C1017u2.m5361a(this.f5353a).lock();
        try {
            if (!C1017u2.m5352c(this.f5353a) && C1017u2.m5351d(this.f5353a) != null && C1017u2.m5351d(this.f5353a).m5641f()) {
                C1017u2.m5357a(this.f5353a, true);
                C1017u2.m5349e(this.f5353a).onConnectionSuspended(i);
            }
            C1017u2.m5357a(this.f5353a, false);
            C1017u2.m5360a(this.f5353a, i, z);
        } finally {
            C1017u2.m5361a(this.f5353a).unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5319a(Bundle bundle) {
        C1017u2.m5361a(this.f5353a).lock();
        try {
            C1017u2.m5359a(this.f5353a, bundle);
            C1017u2.m5358a(this.f5353a, C0900a.f5050e);
            C1017u2.m5354b(this.f5353a);
        } finally {
            C1017u2.m5361a(this.f5353a).unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5318a(C0900a c0900a) {
        C1017u2.m5361a(this.f5353a).lock();
        try {
            C1017u2.m5358a(this.f5353a, c0900a);
            C1017u2.m5354b(this.f5353a);
        } finally {
            C1017u2.m5361a(this.f5353a).unlock();
        }
    }
}
