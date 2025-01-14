package p000a.p001a.p005b;

/* renamed from: a.a.b.o */
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: a */
    public final InterfaceC0016a f47a;

    /* renamed from: b */
    public final ViewModelStore f48b;

    /* compiled from: ViewModelProvider.java */
    /* renamed from: a.a.b.o$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0016a {
        /* renamed from: a */
        <T extends ViewModel> T mo7430a(Class<T> cls);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, InterfaceC0016a interfaceC0016a) {
        this.f47a = interfaceC0016a;
        this.f48b = viewModelStore;
    }

    /* renamed from: a */
    public <T extends ViewModel> T m11264a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) m11263a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends ViewModel> T m11263a(String str, Class<T> cls) {
        T t = (T) this.f48b.m11261a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f47a.mo7430a(cls);
        this.f48b.m11260a(str, t2);
        return t2;
    }
}
