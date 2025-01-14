package android.arch.lifecycle;

import p000a.p001a.p005b.GeneratedAdapter;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;

/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    public final GeneratedAdapter f3053a;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f3053a = generatedAdapter;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo7936a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a) {
        this.f3053a.m11300a(lifecycleOwner, enumC0011a, false, null);
        this.f3053a.m11300a(lifecycleOwner, enumC0011a, true, null);
    }
}
