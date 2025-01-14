package p070c.p084d.p105b.p107v.p108n;

import java.lang.reflect.Type;
import java.util.Collection;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p107v.C$Gson$Types;
import p070c.p084d.p105b.p107v.ConstructorConstructor;
import p070c.p084d.p105b.p107v.ObjectConstructor;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.b */
/* loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f5761a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* renamed from: c.d.b.v.n.b$a */
    /* loaded from: classes.dex */
    public static final class C1297a<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a */
        public final TypeAdapter<E> f5762a;

        /* renamed from: b */
        public final ObjectConstructor<? extends Collection<E>> f5763b;

        public C1297a(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f5762a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f5763b = objectConstructor;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo4752a(JsonWriter jsonWriter, Object obj) {
            m4815a(jsonWriter, (Collection) ((Collection) obj));
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Collection<E> mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            Collection<E> mo4828a = this.f5763b.mo4828a();
            jsonReader.mo4722j();
            while (jsonReader.mo4714r()) {
                mo4828a.add(this.f5762a.mo4753a(jsonReader));
            }
            jsonReader.mo4717o();
            return mo4828a;
        }

        /* renamed from: a */
        public void m4815a(JsonWriter jsonWriter, Collection<E> collection) {
            if (collection == null) {
                jsonWriter.mo4679t();
                return;
            }
            jsonWriter.mo4687l();
            for (E e : collection) {
                this.f5762a.mo4752a(jsonWriter, e);
            }
            jsonWriter.mo4685n();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f5761a = constructorConstructor;
    }

    @Override // p070c.p084d.p105b.TypeAdapterFactory
    /* renamed from: a */
    public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (Collection.class.isAssignableFrom(rawType)) {
            Type m4881a = C$Gson$Types.m4881a(type, (Class<?>) rawType);
            return new C1297a(gson, m4881a, gson.m4939a((TypeToken) TypeToken.get(m4881a)), this.f5761a.m4863a(typeToken));
        }
        return null;
    }
}
