package android.arch.lifecycle;

import a.a.b.b;
import a.a.b.c;
import a.a.b.e;
import a.a.b.i;
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final b[] f2020a;

    public CompositeGeneratedAdaptersObserver(b[] bVarArr) {
        this.f2020a = bVarArr;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, c.a aVar) {
        i iVar = new i();
        for (b bVar : this.f2020a) {
            bVar.a(eVar, aVar, false, iVar);
        }
        for (b bVar2 : this.f2020a) {
            bVar2.a(eVar, aVar, true, iVar);
        }
    }
}
