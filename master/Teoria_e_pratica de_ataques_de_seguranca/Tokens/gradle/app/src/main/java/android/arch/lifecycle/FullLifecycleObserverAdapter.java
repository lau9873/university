package android.arch.lifecycle;

import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;

/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* renamed from: a */
    public final FullLifecycleObserver f3032a;

    /* renamed from: android.arch.lifecycle.FullLifecycleObserverAdapter$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0517a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f3033a = new int[Lifecycle.EnumC0011a.values().length];

        static {
            try {
                f3033a[Lifecycle.EnumC0011a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3033a[Lifecycle.EnumC0011a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3033a[Lifecycle.EnumC0011a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3033a[Lifecycle.EnumC0011a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3033a[Lifecycle.EnumC0011a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3033a[Lifecycle.EnumC0011a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3033a[Lifecycle.EnumC0011a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f3032a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* renamed from: a */
    public void mo7936a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a) {
        switch (C0517a.f3033a[enumC0011a.ordinal()]) {
            case 1:
                this.f3032a.m7956e(lifecycleOwner);
                return;
            case 2:
                this.f3032a.m7959b(lifecycleOwner);
                return;
            case 3:
                this.f3032a.m7955f(lifecycleOwner);
                return;
            case 4:
                this.f3032a.m7958c(lifecycleOwner);
                return;
            case 5:
                this.f3032a.m7960a(lifecycleOwner);
                return;
            case 6:
                this.f3032a.m7957d(lifecycleOwner);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
