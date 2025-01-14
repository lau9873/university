package i;

import e.c0;
import e.e0;
import i.e;
import i.r.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
/* compiled from: BuiltInConverters.java */
/* loaded from: classes.dex */
public final class a extends e.a {

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0169a implements i.e<e0, e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0169a f7421a = new C0169a();

        @Override // i.e
        public e0 a(e0 e0Var) {
            try {
                return o.a(e0Var);
            } finally {
                e0Var.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes.dex */
    public static final class b implements i.e<c0, c0> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f7422a = new b();

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public c0 a2(c0 c0Var) {
            return c0Var;
        }

        @Override // i.e
        public /* bridge */ /* synthetic */ c0 a(c0 c0Var) {
            c0 c0Var2 = c0Var;
            a2(c0Var2);
            return c0Var2;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes.dex */
    public static final class c implements i.e<e0, e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7423a = new c();

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public e0 a2(e0 e0Var) {
            return e0Var;
        }

        @Override // i.e
        public /* bridge */ /* synthetic */ e0 a(e0 e0Var) {
            e0 e0Var2 = e0Var;
            a2(e0Var2);
            return e0Var2;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes.dex */
    public static final class d implements i.e<Object, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f7424a = new d();

        @Override // i.e
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes.dex */
    public static final class e implements i.e<e0, Void> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f7425a = new e();

        @Override // i.e
        public Void a(e0 e0Var) {
            e0Var.close();
            return null;
        }
    }

    @Override // i.e.a
    public i.e<e0, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (type == e0.class) {
            if (o.a(annotationArr, (Class<? extends Annotation>) u.class)) {
                return c.f7423a;
            }
            return C0169a.f7421a;
        } else if (type == Void.class) {
            return e.f7425a;
        } else {
            return null;
        }
    }

    @Override // i.e.a
    public i.e<?, c0> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        if (c0.class.isAssignableFrom(o.c(type))) {
            return b.f7422a;
        }
        return null;
    }
}
