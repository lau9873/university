package c.d.b.v.o;

import c.d.b.v.e;
import java.lang.reflect.AccessibleObject;
/* compiled from: ReflectionAccessor.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f3887a;

    static {
        f3887a = e.b() < 9 ? new a() : new c();
    }

    public static b a() {
        return f3887a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
