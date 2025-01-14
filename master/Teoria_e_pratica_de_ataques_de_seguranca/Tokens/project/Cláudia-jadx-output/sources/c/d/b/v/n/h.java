package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class h extends s<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final t f3821b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.f f3822a;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    public static class a implements t {
        @Override // c.d.b.t
        public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3823a = new int[c.d.b.x.b.values().length];

        static {
            try {
                f3823a[c.d.b.x.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3823a[c.d.b.x.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3823a[c.d.b.x.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3823a[c.d.b.x.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3823a[c.d.b.x.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3823a[c.d.b.x.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public h(c.d.b.f fVar) {
        this.f3822a = fVar;
    }

    @Override // c.d.b.s
    public Object a(c.d.b.x.a aVar) {
        switch (b.f3823a[aVar.C().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.j();
                while (aVar.r()) {
                    arrayList.add(a(aVar));
                }
                aVar.o();
                return arrayList;
            case 2:
                c.d.b.v.h hVar = new c.d.b.v.h();
                aVar.k();
                while (aVar.r()) {
                    hVar.put(aVar.y(), a(aVar));
                }
                aVar.p();
                return hVar;
            case 3:
                return aVar.A();
            case 4:
                return Double.valueOf(aVar.v());
            case 5:
                return Boolean.valueOf(aVar.u());
            case 6:
                aVar.z();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // c.d.b.s
    public void a(c.d.b.x.c cVar, Object obj) {
        if (obj == null) {
            cVar.t();
            return;
        }
        s a2 = this.f3822a.a((Class) obj.getClass());
        if (a2 instanceof h) {
            cVar.m();
            cVar.o();
            return;
        }
        a2.a(cVar, obj);
    }
}
