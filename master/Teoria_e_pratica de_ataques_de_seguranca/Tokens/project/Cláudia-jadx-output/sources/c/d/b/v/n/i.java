package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class i implements t {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.v.c f3824a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e f3825b;

    /* renamed from: c  reason: collision with root package name */
    public final c.d.b.v.d f3826c;

    /* renamed from: d  reason: collision with root package name */
    public final d f3827d;

    /* renamed from: e  reason: collision with root package name */
    public final c.d.b.v.o.b f3828e = c.d.b.v.o.b.a();

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f3837a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3838b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3839c;

        public c(String str, boolean z, boolean z2) {
            this.f3837a = str;
            this.f3838b = z;
            this.f3839c = z2;
        }

        public abstract void a(c.d.b.x.a aVar, Object obj);

        public abstract void a(c.d.b.x.c cVar, Object obj);

        public abstract boolean a(Object obj);
    }

    public i(c.d.b.v.c cVar, c.d.b.e eVar, c.d.b.v.d dVar, d dVar2) {
        this.f3824a = cVar;
        this.f3825b = eVar;
        this.f3826c = dVar;
        this.f3827d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f3826c);
    }

    public static boolean a(Field field, boolean z, c.d.b.v.d dVar) {
        return (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true;
    }

    public final List<String> a(Field field) {
        c.d.b.u.c cVar = (c.d.b.u.c) field.getAnnotation(c.d.b.u.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f3825b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Field f3829d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f3830e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s f3831f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d.b.f f3832g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.d.b.w.a f3833h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f3834i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, String str, boolean z, boolean z2, Field field, boolean z3, s sVar, c.d.b.f fVar, c.d.b.w.a aVar, boolean z4) {
            super(str, z, z2);
            this.f3829d = field;
            this.f3830e = z3;
            this.f3831f = sVar;
            this.f3832g = fVar;
            this.f3833h = aVar;
            this.f3834i = z4;
        }

        @Override // c.d.b.v.n.i.c
        public void a(c.d.b.x.c cVar, Object obj) {
            (this.f3830e ? this.f3831f : new m(this.f3832g, this.f3831f, this.f3833h.getType())).a(cVar, this.f3829d.get(obj));
        }

        @Override // c.d.b.v.n.i.c
        public void a(c.d.b.x.a aVar, Object obj) {
            Object a2 = this.f3831f.a(aVar);
            if (a2 == null && this.f3834i) {
                return;
            }
            this.f3829d.set(obj, a2);
        }

        @Override // c.d.b.v.n.i.c
        public boolean a(Object obj) {
            return this.f3838b && this.f3829d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends s<T> {

        /* renamed from: a  reason: collision with root package name */
        public final c.d.b.v.i<T> f3835a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, c> f3836b;

        public b(c.d.b.v.i<T> iVar, Map<String, c> map) {
            this.f3835a = iVar;
            this.f3836b = map;
        }

        @Override // c.d.b.s
        public T a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            T a2 = this.f3835a.a();
            try {
                aVar.k();
                while (aVar.r()) {
                    c cVar = this.f3836b.get(aVar.y());
                    if (cVar != null && cVar.f3839c) {
                        cVar.a(aVar, a2);
                    }
                    aVar.I();
                }
                aVar.p();
                return a2;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, T t) {
            if (t == null) {
                cVar.t();
                return;
            }
            cVar.m();
            try {
                for (c cVar2 : this.f3836b.values()) {
                    if (cVar2.a(t)) {
                        cVar.b(cVar2.f3837a);
                        cVar2.a(cVar, t);
                    }
                }
                cVar.o();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // c.d.b.t
    public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.f3824a.a(aVar), a(fVar, (c.d.b.w.a<?>) aVar, (Class<?>) rawType));
        }
        return null;
    }

    public final c a(c.d.b.f fVar, Field field, String str, c.d.b.w.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = c.d.b.v.k.a((Type) aVar.getRawType());
        c.d.b.u.b bVar = (c.d.b.u.b) field.getAnnotation(c.d.b.u.b.class);
        s<?> a3 = bVar != null ? this.f3827d.a(this.f3824a, fVar, aVar, bVar) : null;
        boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = fVar.a((c.d.b.w.a) aVar);
        }
        return new a(this, str, z, z2, field, z3, a3, fVar, aVar, a2);
    }

    public final Map<String, c> a(c.d.b.f fVar, c.d.b.w.a<?> aVar, Class<?> cls) {
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        c.d.b.w.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    this.f3828e.a(field);
                    Type a4 = c.d.b.v.b.a(aVar2.getType(), cls2, field.getGenericType());
                    List<String> a5 = a(field);
                    int size = a5.size();
                    c cVar2 = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = a5.get(i3);
                        boolean z2 = i3 != 0 ? false : a2;
                        c cVar3 = cVar2;
                        int i4 = i3;
                        int i5 = size;
                        List<String> list = a5;
                        Field field2 = field;
                        cVar2 = cVar3 == null ? (c) linkedHashMap.put(str, a(fVar, field, str, c.d.b.w.a.get(a4), z2, a3)) : cVar3;
                        i3 = i4 + 1;
                        a2 = z2;
                        a5 = list;
                        size = i5;
                        field = field2;
                    }
                    if (cVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar.f3837a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = c.d.b.w.a.get(c.d.b.v.b.a(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }
}
