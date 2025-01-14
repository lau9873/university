package c.d.a.a.e.e.l;

import java.util.Map;
/* loaded from: classes.dex */
public final class h implements c.d.a.a.j.a<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c.d.a.a.j.d f3303a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ f f3304b;

    public h(f fVar, c.d.a.a.j.d dVar) {
        this.f3304b = fVar;
        this.f3303a = dVar;
    }

    @Override // c.d.a.a.j.a
    public final void onComplete(c.d.a.a.j.c<TResult> cVar) {
        Map map;
        map = this.f3304b.f3284b;
        map.remove(this.f3303a);
    }
}
