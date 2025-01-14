package a.a.b;
/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final a f48a;

    /* renamed from: b  reason: collision with root package name */
    public final p f49b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface a {
        <T extends n> T a(Class<T> cls);
    }

    public o(p pVar, a aVar) {
        this.f48a = aVar;
        this.f49b = pVar;
    }

    public <T extends n> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends n> T a(String str, Class<T> cls) {
        T t = (T) this.f49b.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f48a.a(cls);
        this.f49b.a(str, t2);
        return t2;
    }
}
