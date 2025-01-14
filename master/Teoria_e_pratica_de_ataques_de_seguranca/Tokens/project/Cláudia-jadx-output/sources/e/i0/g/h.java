package e.i0.g;

import e.e0;
import e.t;
import e.w;
/* compiled from: RealResponseBody.java */
/* loaded from: classes.dex */
public final class h extends e0 {

    /* renamed from: b  reason: collision with root package name */
    public final t f5634b;

    /* renamed from: c  reason: collision with root package name */
    public final f.e f5635c;

    public h(t tVar, f.e eVar) {
        this.f5634b = tVar;
        this.f5635c = eVar;
    }

    @Override // e.e0
    public long l() {
        return e.a(this.f5634b);
    }

    @Override // e.e0
    public w m() {
        String a2 = this.f5634b.a("Content-Type");
        if (a2 != null) {
            return w.a(a2);
        }
        return null;
    }

    @Override // e.e0
    public f.e n() {
        return this.f5635c;
    }
}
