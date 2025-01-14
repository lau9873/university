package p220i.p223q.p224a;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.p112x.JsonWriter;
import p181e.MediaType;
import p181e.RequestBody;
import p192f.Buffer;
import p220i.Converter;

/* renamed from: i.q.a.b */
/* loaded from: classes.dex */
public final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /* renamed from: c */
    public static final MediaType f10531c = MediaType.m2692a("application/json; charset=UTF-8");

    /* renamed from: d */
    public static final Charset f10532d = Charset.forName("UTF-8");

    /* renamed from: a */
    public final Gson f10533a;

    /* renamed from: b */
    public final TypeAdapter<T> f10534b;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f10533a = gson;
        this.f10534b = typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p220i.Converter
    /* renamed from: a */
    public /* bridge */ /* synthetic */ RequestBody mo560a(Object obj) {
        return mo560a((GsonRequestBodyConverter<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p220i.Converter
    /* renamed from: a */
    public RequestBody mo560a(T t) {
        Buffer buffer = new Buffer();
        JsonWriter m4935a = this.f10533a.m4935a((Writer) new OutputStreamWriter(buffer.m2610n(), f10532d));
        this.f10534b.mo4752a(m4935a, t);
        m4935a.close();
        return RequestBody.m3246a(f10531c, buffer.m2608p());
    }
}
