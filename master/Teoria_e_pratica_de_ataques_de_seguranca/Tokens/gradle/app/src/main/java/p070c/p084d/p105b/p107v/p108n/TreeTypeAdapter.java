package p070c.p084d.p105b.p107v.p108n;

import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.JsonDeserializationContext;
import p070c.p084d.p105b.JsonDeserializer;
import p070c.p084d.p105b.JsonElement;
import p070c.p084d.p105b.JsonSerializationContext;
import p070c.p084d.p105b.JsonSerializer;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p107v.C$Gson$Preconditions;
import p070c.p084d.p105b.p107v.Streams;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.l */
/* loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a */
    public final JsonSerializer<T> f5806a;

    /* renamed from: b */
    public final JsonDeserializer<T> f5807b;

    /* renamed from: c */
    public final Gson f5808c;

    /* renamed from: d */
    public final TypeToken<T> f5809d;

    /* renamed from: e */
    public final TypeAdapterFactory f5810e;

    /* renamed from: f */
    public final TreeTypeAdapter<T>.C1310b f5811f = new C1310b();

    /* renamed from: g */
    public TypeAdapter<T> f5812g;

    /* compiled from: TreeTypeAdapter.java */
    /* renamed from: c.d.b.v.n.l$b */
    /* loaded from: classes.dex */
    public final class C1310b implements JsonSerializationContext, JsonDeserializationContext {
        public C1310b(TreeTypeAdapter treeTypeAdapter) {
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    /* renamed from: c.d.b.v.n.l$c */
    /* loaded from: classes.dex */
    public static final class C1311c implements TypeAdapterFactory {

        /* renamed from: a */
        public final TypeToken<?> f5813a;

        /* renamed from: b */
        public final boolean f5814b;

        /* renamed from: c */
        public final Class<?> f5815c;

        /* renamed from: d */
        public final JsonSerializer<?> f5816d;

        /* renamed from: e */
        public final JsonDeserializer<?> f5817e;

        public C1311c(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            this.f5816d = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f5817e = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            C$Gson$Preconditions.m4885a((this.f5816d == null && this.f5817e == null) ? false : true);
            this.f5813a = typeToken;
            this.f5814b = z;
            this.f5815c = cls;
        }

        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            boolean isAssignableFrom;
            TypeToken<?> typeToken2 = this.f5813a;
            if (typeToken2 != null) {
                isAssignableFrom = typeToken2.equals(typeToken) || (this.f5814b && this.f5813a.getType() == typeToken.getRawType());
            } else {
                isAssignableFrom = this.f5815c.isAssignableFrom(typeToken.getRawType());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f5816d, this.f5817e, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f5806a = jsonSerializer;
        this.f5807b = jsonDeserializer;
        this.f5808c = gson;
        this.f5809d = typeToken;
        this.f5810e = typeAdapterFactory;
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public T mo4753a(JsonReader jsonReader) {
        if (this.f5807b == null) {
            return m4789b().mo4753a(jsonReader);
        }
        JsonElement m4820a = Streams.m4820a(jsonReader);
        if (m4820a.m4907r()) {
            return null;
        }
        return this.f5807b.deserialize(m4820a, this.f5809d.getType(), this.f5811f);
    }

    /* renamed from: b */
    public final TypeAdapter<T> m4789b() {
        TypeAdapter<T> typeAdapter = this.f5812g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> m4940a = this.f5808c.m4940a(this.f5810e, this.f5809d);
        this.f5812g = m4940a;
        return m4940a;
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public void mo4752a(JsonWriter jsonWriter, T t) {
        JsonSerializer<T> jsonSerializer = this.f5806a;
        if (jsonSerializer == null) {
            m4789b().mo4752a(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.mo4679t();
        } else {
            Streams.m4821a(jsonSerializer.m4889a(t, this.f5809d.getType(), this.f5811f), jsonWriter);
        }
    }

    /* renamed from: a */
    public static TypeAdapterFactory m4790a(TypeToken<?> typeToken, Object obj) {
        return new C1311c(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }
}
