package i.p.a;

import d.c.j;
import d.c.l;
import d.c.o;
import d.c.t;
import d.c.u;
import i.c;
import i.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes.dex */
public final class g extends c.a {

    /* renamed from: a  reason: collision with root package name */
    public final t f7553a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7554b;

    public g(t tVar, boolean z) {
        this.f7553a = tVar;
        this.f7554b = z;
    }

    public static g a() {
        return new g(null, false);
    }

    @Override // i.c.a
    public i.c<?, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> a2 = c.a.a(type);
        if (a2 == d.c.b.class) {
            return new f(Void.class, this.f7553a, this.f7554b, false, true, false, false, false, true);
        }
        boolean z3 = a2 == j.class;
        boolean z4 = a2 == u.class;
        boolean z5 = a2 == l.class;
        if (a2 == o.class || z3 || z4 || z5) {
            if (!(type instanceof ParameterizedType)) {
                String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type a3 = c.a.a(0, (ParameterizedType) type);
            Class<?> a4 = c.a.a(a3);
            if (a4 == i.l.class) {
                if (a3 instanceof ParameterizedType) {
                    type2 = c.a.a(0, (ParameterizedType) a3);
                    z = false;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (a4 == d.class) {
                if (a3 instanceof ParameterizedType) {
                    type2 = c.a.a(0, (ParameterizedType) a3);
                    z = true;
                } else {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
            } else {
                type2 = a3;
                z = false;
                z2 = true;
                return new f(type2, this.f7553a, this.f7554b, z, z2, z3, z4, z5, false);
            }
            z2 = false;
            return new f(type2, this.f7553a, this.f7554b, z, z2, z3, z4, z5, false);
        }
        return null;
    }
}
