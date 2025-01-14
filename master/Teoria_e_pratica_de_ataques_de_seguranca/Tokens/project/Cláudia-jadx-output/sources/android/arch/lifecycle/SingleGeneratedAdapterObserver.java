package android.arch.lifecycle;

import a.a.b.b;
import a.a.b.c;
import a.a.b.e;
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final b f2041a;

    public SingleGeneratedAdapterObserver(b bVar) {
        this.f2041a = bVar;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, c.a aVar) {
        this.f2041a.a(eVar, aVar, false, null);
        this.f2041a.a(eVar, aVar, true, null);
    }
}
