package i;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: CallAdapter.java */
/* loaded from: classes.dex */
public interface c<R, T> {

    /* compiled from: CallAdapter.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public static Type a(int i2, ParameterizedType parameterizedType) {
            return o.a(i2, parameterizedType);
        }

        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, m mVar);

        public static Class<?> a(Type type) {
            return o.c(type);
        }
    }

    T a(b<R> bVar);

    Type a();
}
