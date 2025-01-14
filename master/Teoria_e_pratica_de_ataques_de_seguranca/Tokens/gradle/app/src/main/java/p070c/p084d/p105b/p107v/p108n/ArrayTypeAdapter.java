package p070c.p084d.p105b.p107v.p108n;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p107v.C$Gson$Types;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.a */
/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: c */
    public static final TypeAdapterFactory f5758c = new C1296a();

    /* renamed from: a */
    public final Class<E> f5759a;

    /* renamed from: b */
    public final TypeAdapter<E> f5760b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: c.d.b.v.n.a$a */
    /* loaded from: classes.dex */
    public static class C1296a implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                Type m4868d = C$Gson$Types.m4868d(type);
                return new ArrayTypeAdapter(gson, gson.m4939a((TypeToken) TypeToken.get(m4868d)), C$Gson$Types.m4867e(m4868d));
            }
            return null;
        }
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f5760b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f5759a = cls;
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public Object mo4753a(JsonReader jsonReader) {
        if (jsonReader.mo4738C() == JsonToken.NULL) {
            jsonReader.mo4706z();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.mo4722j();
        while (jsonReader.mo4714r()) {
            arrayList.add(this.f5760b.mo4753a(jsonReader));
        }
        jsonReader.mo4717o();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f5759a, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public void mo4752a(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.mo4679t();
            return;
        }
        jsonWriter.mo4687l();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f5760b.mo4752a(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.mo4685n();
    }
}
