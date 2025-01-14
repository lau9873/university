package i;

import i.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes.dex */
public final class f extends c.a {

    /* renamed from: a  reason: collision with root package name */
    public static final c.a f7426a = new f();

    /* compiled from: DefaultCallAdapterFactory.java */
    /* loaded from: classes.dex */
    public class a implements c<Object, b<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Type f7427a;

        public a(f fVar, Type type) {
            this.f7427a = type;
        }

        @Override // i.c
        public b<?> a(b<Object> bVar) {
            return bVar;
        }

        @Override // i.c
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ b<?> a2(b<Object> bVar) {
            a(bVar);
            return bVar;
        }

        @Override // i.c
        public Type a() {
            return this.f7427a;
        }
    }

    @Override // i.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (c.a.a(type) != b.class) {
            return null;
        }
        return new a(this, o.b(type));
    }
}
