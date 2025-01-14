package i.q.a;

import c.d.b.f;
import e.c0;
import e.e0;
import i.e;
import i.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
/* compiled from: GsonConverterFactory.java */
/* loaded from: classes.dex */
public final class a extends e.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f7555a;

    public a(f fVar) {
        this.f7555a = fVar;
    }

    public static a a(f fVar) {
        if (fVar != null) {
            return new a(fVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // i.e.a
    public e<e0, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        return new c(this.f7555a, this.f7555a.a((c.d.b.w.a) c.d.b.w.a.get(type)));
    }

    @Override // i.e.a
    public e<?, c0> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        return new b(this.f7555a, this.f7555a.a((c.d.b.w.a) c.d.b.w.a.get(type)));
    }
}
