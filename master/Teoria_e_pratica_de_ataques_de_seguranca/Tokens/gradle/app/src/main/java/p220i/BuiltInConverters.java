package p220i;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p181e.RequestBody;
import p181e.ResponseBody;
import p220i.Converter;
import p220i.p225r.Streaming;

/* renamed from: i.a */
/* loaded from: classes.dex */
public final class BuiltInConverters extends Converter.AbstractC2603a {

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i.a$a */
    /* loaded from: classes.dex */
    public static final class C2595a implements Converter<ResponseBody, ResponseBody> {

        /* renamed from: a */
        public static final C2595a f10375a = new C2595a();

        @Override // p220i.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public ResponseBody mo560a(ResponseBody responseBody) {
            try {
                return C2636o.m599a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i.a$b */
    /* loaded from: classes.dex */
    public static final class C2596b implements Converter<RequestBody, RequestBody> {

        /* renamed from: a */
        public static final C2596b f10376a = new C2596b();

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public RequestBody m689a(RequestBody requestBody) {
            return requestBody;
        }

        @Override // p220i.Converter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ RequestBody mo560a(RequestBody requestBody) {
            RequestBody requestBody2 = requestBody;
            m689a(requestBody2);
            return requestBody2;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i.a$c */
    /* loaded from: classes.dex */
    public static final class C2597c implements Converter<ResponseBody, ResponseBody> {

        /* renamed from: a */
        public static final C2597c f10377a = new C2597c();

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public ResponseBody m688a(ResponseBody responseBody) {
            return responseBody;
        }

        @Override // p220i.Converter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ ResponseBody mo560a(ResponseBody responseBody) {
            ResponseBody responseBody2 = responseBody;
            m688a(responseBody2);
            return responseBody2;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i.a$d */
    /* loaded from: classes.dex */
    public static final class C2598d implements Converter<Object, String> {

        /* renamed from: a */
        public static final C2598d f10378a = new C2598d();

        @Override // p220i.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public String mo560a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i.a$e */
    /* loaded from: classes.dex */
    public static final class C2599e implements Converter<ResponseBody, Void> {

        /* renamed from: a */
        public static final C2599e f10379a = new C2599e();

        @Override // p220i.Converter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Void mo560a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // p220i.Converter.AbstractC2603a
    /* renamed from: a */
    public Converter<ResponseBody, ?> mo563a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (C2636o.m587a(annotationArr, (Class<? extends Annotation>) Streaming.class)) {
                return C2597c.f10377a;
            }
            return C2595a.f10375a;
        } else if (type == Void.class) {
            return C2599e.f10379a;
        } else {
            return null;
        }
    }

    @Override // p220i.Converter.AbstractC2603a
    /* renamed from: a */
    public Converter<?, RequestBody> mo562a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(C2636o.m584c(type))) {
            return C2596b.f10376a;
        }
        return null;
    }
}
