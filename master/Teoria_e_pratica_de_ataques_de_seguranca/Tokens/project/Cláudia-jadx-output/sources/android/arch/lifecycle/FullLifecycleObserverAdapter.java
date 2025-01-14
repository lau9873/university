package android.arch.lifecycle;

import a.a.b.c;
import a.a.b.e;
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final FullLifecycleObserver f2021a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2022a = new int[c.a.values().length];

        static {
            try {
                f2022a[c.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2022a[c.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2022a[c.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2022a[c.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2022a[c.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2022a[c.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2022a[c.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f2021a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, c.a aVar) {
        switch (a.f2022a[aVar.ordinal()]) {
            case 1:
                this.f2021a.e(eVar);
                return;
            case 2:
                this.f2021a.b(eVar);
                return;
            case 3:
                this.f2021a.f(eVar);
                return;
            case 4:
                this.f2021a.c(eVar);
                return;
            case 5:
                this.f2021a.a(eVar);
                return;
            case 6:
                this.f2021a.d(eVar);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
