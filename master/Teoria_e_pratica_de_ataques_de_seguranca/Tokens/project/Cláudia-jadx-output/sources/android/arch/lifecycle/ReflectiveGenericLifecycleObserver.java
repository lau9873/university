package android.arch.lifecycle;

import a.a.b.a;
import a.a.b.c;
import a.a.b.e;
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2039a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C0002a f2040b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2039a = obj;
        this.f2040b = a.f21c.b(this.f2039a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, c.a aVar) {
        this.f2040b.a(eVar, aVar, this.f2039a);
    }
}
