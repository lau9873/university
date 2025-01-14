package p070c.p084d.p105b.p107v.p108n;

import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p070c.p084d.p105b.FieldNamingStrategy;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p106u.JsonAdapter;
import p070c.p084d.p105b.p106u.SerializedName;
import p070c.p084d.p105b.p107v.C$Gson$Types;
import p070c.p084d.p105b.p107v.ConstructorConstructor;
import p070c.p084d.p105b.p107v.Excluder;
import p070c.p084d.p105b.p107v.ObjectConstructor;
import p070c.p084d.p105b.p107v.Primitives;
import p070c.p084d.p105b.p107v.p110o.ReflectionAccessor;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.i */
/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f5786a;

    /* renamed from: b */
    public final FieldNamingStrategy f5787b;

    /* renamed from: c */
    public final Excluder f5788c;

    /* renamed from: d */
    public final JsonAdapterAnnotationTypeAdapterFactory f5789d;

    /* renamed from: e */
    public final ReflectionAccessor f5790e = ReflectionAccessor.m4745a();

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: c.d.b.v.n.i$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1306c {

        /* renamed from: a */
        public final String f5799a;

        /* renamed from: b */
        public final boolean f5800b;

        /* renamed from: c */
        public final boolean f5801c;

        public AbstractC1306c(String str, boolean z, boolean z2) {
            this.f5799a = str;
            this.f5800b = z;
            this.f5801c = z2;
        }

        /* renamed from: a */
        public abstract void mo4795a(JsonReader jsonReader, Object obj);

        /* renamed from: a */
        public abstract void mo4794a(JsonWriter jsonWriter, Object obj);

        /* renamed from: a */
        public abstract boolean mo4793a(Object obj);
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f5786a = constructorConstructor;
        this.f5787b = fieldNamingStrategy;
        this.f5788c = excluder;
        this.f5789d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* renamed from: a */
    public boolean m4797a(Field field, boolean z) {
        return m4796a(field, z, this.f5788c);
    }

    /* renamed from: a */
    public static boolean m4796a(Field field, boolean z, Excluder excluder) {
        return (excluder.m4855a(field.getType(), z) || excluder.m4854a(field, z)) ? false : true;
    }

    /* renamed from: a */
    public final List<String> m4798a(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f5787b.mo4947a(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: c.d.b.v.n.i$a */
    /* loaded from: classes.dex */
    public class C1304a extends AbstractC1306c {

        /* renamed from: d */
        public final /* synthetic */ Field f5791d;

        /* renamed from: e */
        public final /* synthetic */ boolean f5792e;

        /* renamed from: f */
        public final /* synthetic */ TypeAdapter f5793f;

        /* renamed from: g */
        public final /* synthetic */ Gson f5794g;

        /* renamed from: h */
        public final /* synthetic */ TypeToken f5795h;

        /* renamed from: i */
        public final /* synthetic */ boolean f5796i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1304a(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z4) {
            super(str, z, z2);
            this.f5791d = field;
            this.f5792e = z3;
            this.f5793f = typeAdapter;
            this.f5794g = gson;
            this.f5795h = typeToken;
            this.f5796i = z4;
        }

        @Override // p070c.p084d.p105b.p107v.p108n.ReflectiveTypeAdapterFactory.AbstractC1306c
        /* renamed from: a */
        public void mo4794a(JsonWriter jsonWriter, Object obj) {
            (this.f5792e ? this.f5793f : new TypeAdapterRuntimeTypeWrapper(this.f5794g, this.f5793f, this.f5795h.getType())).mo4752a(jsonWriter, this.f5791d.get(obj));
        }

        @Override // p070c.p084d.p105b.p107v.p108n.ReflectiveTypeAdapterFactory.AbstractC1306c
        /* renamed from: a */
        public void mo4795a(JsonReader jsonReader, Object obj) {
            Object mo4753a = this.f5793f.mo4753a(jsonReader);
            if (mo4753a == null && this.f5796i) {
                return;
            }
            this.f5791d.set(obj, mo4753a);
        }

        @Override // p070c.p084d.p105b.p107v.p108n.ReflectiveTypeAdapterFactory.AbstractC1306c
        /* renamed from: a */
        public boolean mo4793a(Object obj) {
            return this.f5800b && this.f5791d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: c.d.b.v.n.i$b */
    /* loaded from: classes.dex */
    public static final class C1305b<T> extends TypeAdapter<T> {

        /* renamed from: a */
        public final ObjectConstructor<T> f5797a;

        /* renamed from: b */
        public final Map<String, AbstractC1306c> f5798b;

        public C1305b(ObjectConstructor<T> objectConstructor, Map<String, AbstractC1306c> map) {
            this.f5797a = objectConstructor;
            this.f5798b = map;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public T mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            T mo4828a = this.f5797a.mo4828a();
            try {
                jsonReader.mo4721k();
                while (jsonReader.mo4714r()) {
                    AbstractC1306c abstractC1306c = this.f5798b.get(jsonReader.mo4707y());
                    if (abstractC1306c != null && abstractC1306c.f5801c) {
                        abstractC1306c.mo4795a(jsonReader, mo4828a);
                    }
                    jsonReader.mo4732I();
                }
                jsonReader.mo4716p();
                return mo4828a;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public void mo4752a(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.mo4679t();
                return;
            }
            jsonWriter.mo4686m();
            try {
                for (AbstractC1306c abstractC1306c : this.f5798b.values()) {
                    if (abstractC1306c.mo4793a(t)) {
                        jsonWriter.mo4697b(abstractC1306c.f5799a);
                        abstractC1306c.mo4794a(jsonWriter, t);
                    }
                }
                jsonWriter.mo4684o();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapterFactory
    /* renamed from: a */
    public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new C1305b(this.f5786a.m4863a(typeToken), m4800a(gson, (TypeToken<?>) typeToken, (Class<?>) rawType));
        }
        return null;
    }

    /* renamed from: a */
    public final AbstractC1306c m4799a(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        boolean m4823a = Primitives.m4823a((Type) typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> m4812a = jsonAdapter != null ? this.f5789d.m4812a(this.f5786a, gson, typeToken, jsonAdapter) : null;
        boolean z3 = m4812a != null;
        if (m4812a == null) {
            m4812a = gson.m4939a((TypeToken) typeToken);
        }
        return new C1304a(this, str, z, z2, field, z3, m4812a, gson, typeToken, m4823a);
    }

    /* renamed from: a */
    public final Map<String, AbstractC1306c> m4800a(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        AbstractC1306c abstractC1306c;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean m4797a = m4797a(field, true);
                boolean m4797a2 = m4797a(field, z);
                if (m4797a || m4797a2) {
                    this.f5790e.mo4744a(field);
                    Type m4879a = C$Gson$Types.m4879a(typeToken2.getType(), cls2, field.getGenericType());
                    List<String> m4798a = m4798a(field);
                    int size = m4798a.size();
                    AbstractC1306c abstractC1306c2 = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = m4798a.get(i2);
                        boolean z2 = i2 != 0 ? false : m4797a;
                        AbstractC1306c abstractC1306c3 = abstractC1306c2;
                        int i3 = i2;
                        int i4 = size;
                        List<String> list = m4798a;
                        Field field2 = field;
                        abstractC1306c2 = abstractC1306c3 == null ? (AbstractC1306c) linkedHashMap.put(str, m4799a(gson, field, str, TypeToken.get(m4879a), z2, m4797a2)) : abstractC1306c3;
                        i2 = i3 + 1;
                        m4797a = z2;
                        m4798a = list;
                        size = i4;
                        field = field2;
                    }
                    if (abstractC1306c2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + abstractC1306c.f5799a);
                    }
                }
                i++;
                z = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.m4879a(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
        }
        return linkedHashMap;
    }
}
