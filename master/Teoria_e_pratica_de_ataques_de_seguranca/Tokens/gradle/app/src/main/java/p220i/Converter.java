package p220i;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p181e.RequestBody;
import p181e.ResponseBody;

/* renamed from: i.e */
/* loaded from: classes.dex */
public interface Converter<F, T> {

    /* compiled from: Converter.java */
    /* renamed from: i.e$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2603a {
        /* renamed from: a */
        public Converter<ResponseBody, ?> mo563a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        /* renamed from: a */
        public Converter<?, RequestBody> mo562a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        /* renamed from: b */
        public Converter<?, String> m684b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    /* renamed from: a */
    T mo560a(F f);
}
