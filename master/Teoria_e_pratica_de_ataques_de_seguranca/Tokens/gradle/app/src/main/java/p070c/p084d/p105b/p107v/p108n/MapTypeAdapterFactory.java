package p070c.p084d.p105b.p107v.p108n;

import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.JsonElement;
import p070c.p084d.p105b.JsonPrimitive;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p107v.C$Gson$Types;
import p070c.p084d.p105b.p107v.ConstructorConstructor;
import p070c.p084d.p105b.p107v.JsonReaderInternalAccess;
import p070c.p084d.p105b.p107v.ObjectConstructor;
import p070c.p084d.p105b.p107v.Streams;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.g */
/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f5777a;

    /* renamed from: b */
    public final boolean f5778b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* renamed from: c.d.b.v.n.g$a */
    /* loaded from: classes.dex */
    public final class C1301a<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a */
        public final TypeAdapter<K> f5779a;

        /* renamed from: b */
        public final TypeAdapter<V> f5780b;

        /* renamed from: c */
        public final ObjectConstructor<? extends Map<K, V>> f5781c;

        public C1301a(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f5779a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f5780b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f5781c = objectConstructor;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo4752a(JsonWriter jsonWriter, Object obj) {
            m4801a(jsonWriter, (Map) ((Map) obj));
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Map<K, V> mo4753a(JsonReader jsonReader) {
            JsonToken mo4738C = jsonReader.mo4738C();
            if (mo4738C == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            Map<K, V> mo4828a = this.f5781c.mo4828a();
            if (mo4738C == JsonToken.BEGIN_ARRAY) {
                jsonReader.mo4722j();
                while (jsonReader.mo4714r()) {
                    jsonReader.mo4722j();
                    K mo4753a = this.f5779a.mo4753a(jsonReader);
                    if (mo4828a.put(mo4753a, this.f5780b.mo4753a(jsonReader)) == null) {
                        jsonReader.mo4717o();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + mo4753a);
                    }
                }
                jsonReader.mo4717o();
            } else {
                jsonReader.mo4721k();
                while (jsonReader.mo4714r()) {
                    JsonReaderInternalAccess.f5725a.mo4705a(jsonReader);
                    K mo4753a2 = this.f5779a.mo4753a(jsonReader);
                    if (mo4828a.put(mo4753a2, this.f5780b.mo4753a(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + mo4753a2);
                    }
                }
                jsonReader.mo4716p();
            }
            return mo4828a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public void m4801a(JsonWriter jsonWriter, Map<K, V> map) {
            if (map == null) {
                jsonWriter.mo4679t();
            } else if (!MapTypeAdapterFactory.this.f5778b) {
                jsonWriter.mo4686m();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.mo4697b(String.valueOf(entry.getKey()));
                    this.f5780b.mo4752a(jsonWriter, entry.getValue());
                }
                jsonWriter.mo4684o();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement m4887a = this.f5779a.m4887a((TypeAdapter<K>) entry2.getKey());
                    arrayList.add(m4887a);
                    arrayList2.add(entry2.getValue());
                    z |= m4887a.m4908q() || m4887a.m4906s();
                }
                if (z) {
                    jsonWriter.mo4687l();
                    int size = arrayList.size();
                    while (i < size) {
                        jsonWriter.mo4687l();
                        Streams.m4821a((JsonElement) arrayList.get(i), jsonWriter);
                        this.f5780b.mo4752a(jsonWriter, arrayList2.get(i));
                        jsonWriter.mo4685n();
                        i++;
                    }
                    jsonWriter.mo4685n();
                    return;
                }
                jsonWriter.mo4686m();
                int size2 = arrayList.size();
                while (i < size2) {
                    jsonWriter.mo4697b(m4802a((JsonElement) arrayList.get(i)));
                    this.f5780b.mo4752a(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.mo4684o();
            }
        }

        /* renamed from: a */
        public final String m4802a(JsonElement jsonElement) {
            if (jsonElement.m4905t()) {
                JsonPrimitive m4909o = jsonElement.m4909o();
                if (m4909o.m4901B()) {
                    return String.valueOf(m4909o.m4890z());
                }
                if (m4909o.m4902A()) {
                    return Boolean.toString(m4909o.m4895u());
                }
                if (m4909o.m4900C()) {
                    return m4909o.mo4896p();
                }
                throw new AssertionError();
            } else if (jsonElement.m4907r()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.f5777a = constructorConstructor;
        this.f5778b = z;
    }

    @Override // p070c.p084d.p105b.TypeAdapterFactory
    /* renamed from: a */
    public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (Map.class.isAssignableFrom(typeToken.getRawType())) {
            Type[] m4871b = C$Gson$Types.m4871b(type, C$Gson$Types.m4867e(type));
            return new C1301a(gson, m4871b[0], m4803a(gson, m4871b[0]), m4871b[1], gson.m4939a((TypeToken) TypeToken.get(m4871b[1])), this.f5777a.m4863a(typeToken));
        }
        return null;
    }

    /* renamed from: a */
    public final TypeAdapter<?> m4803a(Gson gson, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return gson.m4939a((TypeToken) TypeToken.get(type));
        }
        return TypeAdapters.f5852f;
    }
}
