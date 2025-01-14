package i.q.a;

import c.d.b.f;
import c.d.b.s;
import e.e0;
import i.e;
/* compiled from: GsonResponseBodyConverter.java */
/* loaded from: classes.dex */
public final class c<T> implements e<e0, T> {

    /* renamed from: a  reason: collision with root package name */
    public final f f7560a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f7561b;

    public c(f fVar, s<T> sVar) {
        this.f7560a = fVar;
        this.f7561b = sVar;
    }

    @Override // i.e
    public T a(e0 e0Var) {
        try {
            return this.f7561b.a(this.f7560a.a(e0Var.j()));
        } finally {
            e0Var.close();
        }
    }
}
