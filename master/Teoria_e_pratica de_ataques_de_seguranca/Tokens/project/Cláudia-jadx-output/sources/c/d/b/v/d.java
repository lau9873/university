package c.d.b.v;

import c.d.b.s;
import c.d.b.t;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class d implements t, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final d f3759g = new d();

    /* renamed from: d  reason: collision with root package name */
    public boolean f3763d;

    /* renamed from: a  reason: collision with root package name */
    public double f3760a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    public int f3761b = 136;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3762c = true;

    /* renamed from: e  reason: collision with root package name */
    public List<c.d.b.b> f3764e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    public List<c.d.b.b> f3765f = Collections.emptyList();

    @Override // c.d.b.t
    public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean a2 = a(rawType);
        boolean z = a2 || b(rawType, true);
        boolean z2 = a2 || b(rawType, false);
        if (z || z2) {
            return new a(z2, z, fVar, aVar);
        }
        return null;
    }

    public final boolean b(Class<?> cls, boolean z) {
        for (c.d.b.b bVar : z ? this.f3764e : this.f3765f) {
            if (bVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    public final boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* renamed from: clone */
    public d m7clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* compiled from: Excluder.java */
    /* loaded from: classes.dex */
    public class a extends s<T> {

        /* renamed from: a  reason: collision with root package name */
        public s<T> f3766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f3767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f3768c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.d.b.f f3769d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.d.b.w.a f3770e;

        public a(boolean z, boolean z2, c.d.b.f fVar, c.d.b.w.a aVar) {
            this.f3767b = z;
            this.f3768c = z2;
            this.f3769d = fVar;
            this.f3770e = aVar;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // c.d.b.s
        public T a(c.d.b.x.a aVar) {
            if (this.f3767b) {
                aVar.I();
                return null;
            }
            return b().a(aVar);
        }

        public final s<T> b() {
            s<T> sVar = this.f3766a;
            if (sVar != 0) {
                return sVar;
            }
            s<T> a2 = this.f3769d.a(d.this, this.f3770e);
            this.f3766a = a2;
            return a2;
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, T t) {
            if (this.f3768c) {
                cVar.t();
            } else {
                b().a(cVar, t);
            }
        }
    }

    public final boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public boolean a(Field field, boolean z) {
        c.d.b.u.a aVar;
        if ((this.f3761b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f3760a == -1.0d || a((c.d.b.u.d) field.getAnnotation(c.d.b.u.d.class), (c.d.b.u.e) field.getAnnotation(c.d.b.u.e.class))) && !field.isSynthetic()) {
            if (!this.f3763d || ((aVar = (c.d.b.u.a) field.getAnnotation(c.d.b.u.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.f3762c || !c(field.getType())) && !b(field.getType())) {
                    List<c.d.b.b> list = z ? this.f3764e : this.f3765f;
                    if (list.isEmpty()) {
                        return false;
                    }
                    c.d.b.c cVar = new c.d.b.c(field);
                    for (c.d.b.b bVar : list) {
                        if (bVar.a(cVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public final boolean a(Class<?> cls) {
        if (this.f3760a == -1.0d || a((c.d.b.u.d) cls.getAnnotation(c.d.b.u.d.class), (c.d.b.u.e) cls.getAnnotation(c.d.b.u.e.class))) {
            return (!this.f3762c && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    public final boolean a(c.d.b.u.d dVar, c.d.b.u.e eVar) {
        return a(dVar) && a(eVar);
    }

    public final boolean a(c.d.b.u.d dVar) {
        return dVar == null || dVar.value() <= this.f3760a;
    }

    public final boolean a(c.d.b.u.e eVar) {
        return eVar == null || eVar.value() > this.f3760a;
    }
}
