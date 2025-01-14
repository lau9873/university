package android.arch.lifecycle;

import p000a.p001a.p005b.ClassesInfoCache;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;

/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    public final Object f3051a;

    /* renamed from: b */
    public final ClassesInfoCache.C0009a f3052b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3051a = obj;
        this.f3052b = ClassesInfoCache.f20c.m11305b(this.f3051a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo7936a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a) {
        this.f3052b.m11303a(lifecycleOwner, enumC0011a, this.f3051a);
    }
}
