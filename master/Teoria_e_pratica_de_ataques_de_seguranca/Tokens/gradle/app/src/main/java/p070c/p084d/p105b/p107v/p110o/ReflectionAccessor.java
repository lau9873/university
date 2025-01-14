package p070c.p084d.p105b.p107v.p110o;

import java.lang.reflect.AccessibleObject;
import p070c.p084d.p105b.p107v.JavaVersion;

/* renamed from: c.d.b.v.o.b */
/* loaded from: classes.dex */
public abstract class ReflectionAccessor {

    /* renamed from: a */
    public static final ReflectionAccessor f5892a;

    static {
        f5892a = JavaVersion.m4846b() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    /* renamed from: a */
    public static ReflectionAccessor m4745a() {
        return f5892a;
    }

    /* renamed from: a */
    public abstract void mo4744a(AccessibleObject accessibleObject);
}
