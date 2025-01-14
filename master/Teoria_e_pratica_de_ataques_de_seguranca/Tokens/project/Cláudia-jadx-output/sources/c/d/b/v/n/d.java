package c.d.b.v.n;

import c.d.b.q;
import c.d.b.s;
import c.d.b.t;
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class d implements t {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.v.c f3814a;

    public d(c.d.b.v.c cVar) {
        this.f3814a = cVar;
    }

    @Override // c.d.b.t
    public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
        c.d.b.u.b bVar = (c.d.b.u.b) aVar.getRawType().getAnnotation(c.d.b.u.b.class);
        if (bVar == null) {
            return null;
        }
        return (s<T>) a(this.f3814a, fVar, aVar, bVar);
    }

    public s<?> a(c.d.b.v.c cVar, c.d.b.f fVar, c.d.b.w.a<?> aVar, c.d.b.u.b bVar) {
        s<?> lVar;
        Object a2 = cVar.a(c.d.b.w.a.get((Class) bVar.value())).a();
        if (a2 instanceof s) {
            lVar = (s) a2;
        } else if (a2 instanceof t) {
            lVar = ((t) a2).a(fVar, aVar);
        } else {
            boolean z = a2 instanceof q;
            if (!z && !(a2 instanceof c.d.b.k)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z ? (q) a2 : null, a2 instanceof c.d.b.k ? (c.d.b.k) a2 : null, fVar, aVar, null);
        }
        return (lVar == null || !bVar.nullSafe()) ? lVar : lVar.a();
    }
}
