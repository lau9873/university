package p220i.p223q.p224a;

import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p181e.ResponseBody;
import p220i.Converter;

/* renamed from: i.q.a.c */
/* loaded from: classes.dex */
public final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    /* renamed from: a */
    public final Gson f10535a;

    /* renamed from: b */
    public final TypeAdapter<T> f10536b;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f10535a = gson;
        this.f10536b = typeAdapter;
    }

    @Override // p220i.Converter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public T mo560a(ResponseBody responseBody) {
        try {
            return this.f10536b.mo4753a(this.f10535a.m4937a(responseBody.m3193j()));
        } finally {
            responseBody.close();
        }
    }
}
