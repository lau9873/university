package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.v.c f3809a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class a<E> extends s<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        public final s<E> f3810a;

        /* renamed from: b  reason: collision with root package name */
        public final c.d.b.v.i<? extends Collection<E>> f3811b;

        public a(c.d.b.f fVar, Type type, s<E> sVar, c.d.b.v.i<? extends Collection<E>> iVar) {
            this.f3810a = new m(fVar, sVar, type);
            this.f3811b = iVar;
        }

        @Override // c.d.b.s
        public /* bridge */ /* synthetic */ void a(c.d.b.x.c cVar, Object obj) {
            a(cVar, (Collection) ((Collection) obj));
        }

        @Override // c.d.b.s
        public Collection<E> a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            Collection<E> a2 = this.f3811b.a();
            aVar.j();
            while (aVar.r()) {
                a2.add(this.f3810a.a(aVar));
            }
            aVar.o();
            return a2;
        }

        public void a(c.d.b.x.c cVar, Collection<E> collection) {
            if (collection == null) {
                cVar.t();
                return;
            }
            cVar.l();
            for (E e2 : collection) {
                this.f3810a.a(cVar, e2);
            }
            cVar.n();
        }
    }

    public b(c.d.b.v.c cVar) {
        this.f3809a = cVar;
    }

    @Override // c.d.b.t
    public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (Collection.class.isAssignableFrom(rawType)) {
            Type a2 = c.d.b.v.b.a(type, (Class<?>) rawType);
            return new a(fVar, a2, fVar.a((c.d.b.w.a) c.d.b.w.a.get(a2)), this.f3809a.a(aVar));
        }
        return null;
    }
}
