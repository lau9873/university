package p220i.p221p.p222a;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import p136d.p153c.Completable;
import p136d.p153c.Flowable;
import p136d.p153c.Maybe;
import p136d.p153c.Observable;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p220i.C2632l;
import p220i.CallAdapter;
import p220i.Retrofit;

/* renamed from: i.p.a.g */
/* loaded from: classes.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.AbstractC2601a {

    /* renamed from: a */
    public final Scheduler f10528a;

    /* renamed from: b */
    public final boolean f10529b;

    public RxJava2CallAdapterFactory(Scheduler scheduler, boolean z) {
        this.f10528a = scheduler;
        this.f10529b = z;
    }

    /* renamed from: a */
    public static RxJava2CallAdapterFactory m566a() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    @Override // p220i.CallAdapter.AbstractC2601a
    /* renamed from: a */
    public CallAdapter<?, ?> mo565a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> m685a = CallAdapter.AbstractC2601a.m685a(type);
        if (m685a == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.f10528a, this.f10529b, false, true, false, false, false, true);
        }
        boolean z3 = m685a == Flowable.class;
        boolean z4 = m685a == Single.class;
        boolean z5 = m685a == Maybe.class;
        if (m685a == Observable.class || z3 || z4 || z5) {
            if (!(type instanceof ParameterizedType)) {
                String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type m686a = CallAdapter.AbstractC2601a.m686a(0, (ParameterizedType) type);
            Class<?> m685a2 = CallAdapter.AbstractC2601a.m685a(m686a);
            if (m685a2 == C2632l.class) {
                if (m686a instanceof ParameterizedType) {
                    type2 = CallAdapter.AbstractC2601a.m686a(0, (ParameterizedType) m686a);
                    z = false;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (m685a2 == Result.class) {
                if (m686a instanceof ParameterizedType) {
                    type2 = CallAdapter.AbstractC2601a.m686a(0, (ParameterizedType) m686a);
                    z = true;
                } else {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
            } else {
                type2 = m686a;
                z = false;
                z2 = true;
                return new RxJava2CallAdapter(type2, this.f10528a, this.f10529b, z, z2, z3, z4, z5, false);
            }
            z2 = false;
            return new RxJava2CallAdapter(type2, this.f10528a, this.f10529b, z, z2, z3, z4, z5, false);
        }
        return null;
    }
}
