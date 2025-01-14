package p220i.p223q.p224a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.p111w.TypeToken;
import p181e.RequestBody;
import p181e.ResponseBody;
import p220i.Converter;
import p220i.Retrofit;

/* renamed from: i.q.a.a */
/* loaded from: classes.dex */
public final class GsonConverterFactory extends Converter.AbstractC2603a {

    /* renamed from: a */
    public final Gson f10530a;

    public GsonConverterFactory(Gson gson) {
        this.f10530a = gson;
    }

    /* renamed from: a */
    public static GsonConverterFactory m564a(Gson gson) {
        if (gson != null) {
            return new GsonConverterFactory(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // p220i.Converter.AbstractC2603a
    /* renamed from: a */
    public Converter<ResponseBody, ?> mo563a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.f10530a, this.f10530a.m4939a((TypeToken) TypeToken.get(type)));
    }

    @Override // p220i.Converter.AbstractC2603a
    /* renamed from: a */
    public Converter<?, RequestBody> mo562a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.f10530a, this.f10530a.m4939a((TypeToken) TypeToken.get(type)));
    }
}
