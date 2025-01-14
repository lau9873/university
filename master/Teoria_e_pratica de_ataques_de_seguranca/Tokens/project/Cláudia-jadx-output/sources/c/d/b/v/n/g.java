package c.d.b.v.n;

import c.d.b.o;
import c.d.b.s;
import c.d.b.t;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class g implements t {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.v.c f3815a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3816b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public final class a<K, V> extends s<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public final s<K> f3817a;

        /* renamed from: b  reason: collision with root package name */
        public final s<V> f3818b;

        /* renamed from: c  reason: collision with root package name */
        public final c.d.b.v.i<? extends Map<K, V>> f3819c;

        public a(c.d.b.f fVar, Type type, s<K> sVar, Type type2, s<V> sVar2, c.d.b.v.i<? extends Map<K, V>> iVar) {
            this.f3817a = new m(fVar, sVar, type);
            this.f3818b = new m(fVar, sVar2, type2);
            this.f3819c = iVar;
        }

        @Override // c.d.b.s
        public /* bridge */ /* synthetic */ void a(c.d.b.x.c cVar, Object obj) {
            a(cVar, (Map) ((Map) obj));
        }

        @Override // c.d.b.s
        public Map<K, V> a(c.d.b.x.a aVar) {
            c.d.b.x.b C = aVar.C();
            if (C == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            Map<K, V> a2 = this.f3819c.a();
            if (C == c.d.b.x.b.BEGIN_ARRAY) {
                aVar.j();
                while (aVar.r()) {
                    aVar.j();
                    K a3 = this.f3817a.a(aVar);
                    if (a2.put(a3, this.f3818b.a(aVar)) == null) {
                        aVar.o();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + a3);
                    }
                }
                aVar.o();
            } else {
                aVar.k();
                while (aVar.r()) {
                    c.d.b.v.f.f3773a.a(aVar);
                    K a4 = this.f3817a.a(aVar);
                    if (a2.put(a4, this.f3818b.a(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + a4);
                    }
                }
                aVar.p();
            }
            return a2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(c.d.b.x.c cVar, Map<K, V> map) {
            if (map == null) {
                cVar.t();
            } else if (!g.this.f3816b) {
                cVar.m();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.b(String.valueOf(entry.getKey()));
                    this.f3818b.a(cVar, entry.getValue());
                }
                cVar.o();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    c.d.b.l a2 = this.f3817a.a((s<K>) entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= a2.q() || a2.s();
                }
                if (z) {
                    cVar.l();
                    int size = arrayList.size();
                    while (i2 < size) {
                        cVar.l();
                        c.d.b.v.l.a((c.d.b.l) arrayList.get(i2), cVar);
                        this.f3818b.a(cVar, arrayList2.get(i2));
                        cVar.n();
                        i2++;
                    }
                    cVar.n();
                    return;
                }
                cVar.m();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    cVar.b(a((c.d.b.l) arrayList.get(i2)));
                    this.f3818b.a(cVar, arrayList2.get(i2));
                    i2++;
                }
                cVar.o();
            }
        }

        public final String a(c.d.b.l lVar) {
            if (lVar.t()) {
                o o = lVar.o();
                if (o.B()) {
                    return String.valueOf(o.z());
                }
                if (o.A()) {
                    return Boolean.toString(o.u());
                }
                if (o.C()) {
                    return o.p();
                }
                throw new AssertionError();
            } else if (lVar.r()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public g(c.d.b.v.c cVar, boolean z) {
        this.f3815a = cVar;
        this.f3816b = z;
    }

    @Override // c.d.b.t
    public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
        Type type = aVar.getType();
        if (Map.class.isAssignableFrom(aVar.getRawType())) {
            Type[] b2 = c.d.b.v.b.b(type, c.d.b.v.b.e(type));
            return new a(fVar, b2[0], a(fVar, b2[0]), b2[1], fVar.a((c.d.b.w.a) c.d.b.w.a.get(b2[1])), this.f3815a.a(aVar));
        }
        return null;
    }

    public final s<?> a(c.d.b.f fVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return fVar.a((c.d.b.w.a) c.d.b.w.a.get(type));
        }
        return n.f3864f;
    }
}
