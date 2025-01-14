package p070c.p084d.p105b.p107v.p108n;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.p107v.p108n.ReflectiveTypeAdapterFactory;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.m */
/* loaded from: classes.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a */
    public final Gson f5818a;

    /* renamed from: b */
    public final TypeAdapter<T> f5819b;

    /* renamed from: c */
    public final Type f5820c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f5818a = gson;
        this.f5819b = typeAdapter;
        this.f5820c = type;
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public T mo4753a(JsonReader jsonReader) {
        return this.f5819b.mo4753a(jsonReader);
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public void mo4752a(JsonWriter jsonWriter, T t) {
        TypeAdapter<T> typeAdapter = this.f5819b;
        Type m4788a = m4788a(this.f5820c, t);
        if (m4788a != this.f5820c) {
            typeAdapter = this.f5818a.m4939a((TypeToken) TypeToken.get(m4788a));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.C1305b) {
                TypeAdapter<T> typeAdapter2 = this.f5819b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.C1305b)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.mo4752a(jsonWriter, t);
    }

    /* renamed from: a */
    public final Type m4788a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
