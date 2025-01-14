package android.arch.lifecycle;

import p000a.p001a.p005b.GeneratedAdapter;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;
import p000a.p001a.p005b.MethodCallsLogger;

/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    public final GeneratedAdapter[] f3031a;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.f3031a = generatedAdapterArr;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo7936a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter generatedAdapter : this.f3031a) {
            generatedAdapter.m11300a(lifecycleOwner, enumC0011a, false, methodCallsLogger);
        }
        for (GeneratedAdapter generatedAdapter2 : this.f3031a) {
            generatedAdapter2.m11300a(lifecycleOwner, enumC0011a, true, methodCallsLogger);
        }
    }
}
