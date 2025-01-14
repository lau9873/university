package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends s<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final t f3806c = new C0066a();

    /* renamed from: a  reason: collision with root package name */
    public final Class<E> f3807a;

    /* renamed from: b  reason: collision with root package name */
    public final s<E> f3808b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: c.d.b.v.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a implements t {
        @Override // c.d.b.t
        public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            Type type = aVar.getType();
            if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                Type d2 = c.d.b.v.b.d(type);
                return new a(fVar, fVar.a((c.d.b.w.a) c.d.b.w.a.get(d2)), c.d.b.v.b.e(d2));
            }
            return null;
        }
    }

    public a(c.d.b.f fVar, s<E> sVar, Class<E> cls) {
        this.f3808b = new m(fVar, sVar, cls);
        this.f3807a = cls;
    }

    @Override // c.d.b.s
    public Object a(c.d.b.x.a aVar) {
        if (aVar.C() == c.d.b.x.b.NULL) {
            aVar.z();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.j();
        while (aVar.r()) {
            arrayList.add(this.f3808b.a(aVar));
        }
        aVar.o();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f3807a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.d.b.s
    public void a(c.d.b.x.c cVar, Object obj) {
        if (obj == null) {
            cVar.t();
            return;
        }
        cVar.l();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f3808b.a(cVar, Array.get(obj, i2));
        }
        cVar.n();
    }
}
