package p220i;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: i.c */
/* loaded from: classes.dex */
public interface CallAdapter<R, T> {

    /* compiled from: CallAdapter.java */
    /* renamed from: i.c$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2601a {
        /* renamed from: a */
        public static Type m686a(int i, ParameterizedType parameterizedType) {
            return C2636o.m600a(i, parameterizedType);
        }

        /* renamed from: a */
        public abstract CallAdapter<?, ?> mo565a(Type type, Annotation[] annotationArr, Retrofit retrofit);

        /* renamed from: a */
        public static Class<?> m685a(Type type) {
            return C2636o.m584c(type);
        }
    }

    /* renamed from: a */
    T mo567a(InterfaceC2600b<R> interfaceC2600b);

    /* renamed from: a */
    Type mo568a();
}
