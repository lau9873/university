package p070c.p084d.p105b;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p070c.p084d.p105b.p107v.C$Gson$Preconditions;
import p070c.p084d.p105b.p107v.Excluder;
import p070c.p084d.p105b.p107v.p108n.TreeTypeAdapter;
import p070c.p084d.p105b.p107v.p108n.TypeAdapters;
import p070c.p084d.p105b.p111w.TypeToken;

/* renamed from: c.d.b.g */
/* loaded from: classes.dex */
public final class GsonBuilder {

    /* renamed from: h */
    public String f5675h;

    /* renamed from: a */
    public Excluder f5668a = Excluder.f5711g;

    /* renamed from: b */
    public LongSerializationPolicy f5669b = LongSerializationPolicy.f5689a;

    /* renamed from: c */
    public FieldNamingStrategy f5670c = FieldNamingPolicy.f5647a;

    /* renamed from: d */
    public final Map<Type, InstanceCreator<?>> f5671d = new HashMap();

    /* renamed from: e */
    public final List<TypeAdapterFactory> f5672e = new ArrayList();

    /* renamed from: f */
    public final List<TypeAdapterFactory> f5673f = new ArrayList();

    /* renamed from: g */
    public boolean f5674g = false;

    /* renamed from: i */
    public int f5676i = 2;

    /* renamed from: j */
    public int f5677j = 2;

    /* renamed from: k */
    public boolean f5678k = false;

    /* renamed from: l */
    public boolean f5679l = false;

    /* renamed from: m */
    public boolean f5680m = true;

    /* renamed from: n */
    public boolean f5681n = false;

    /* renamed from: o */
    public boolean f5682o = false;

    /* renamed from: p */
    public boolean f5683p = false;

    /* renamed from: a */
    public GsonBuilder m4916a(String str) {
        this.f5675h = str;
        return this;
    }

    /* renamed from: a */
    public GsonBuilder m4914a(Type type, Object obj) {
        boolean z = obj instanceof JsonSerializer;
        C$Gson$Preconditions.m4885a(z || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.f5671d.put(type, (InstanceCreator) obj);
        }
        if (z || (obj instanceof JsonDeserializer)) {
            this.f5672e.add(TreeTypeAdapter.m4790a(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f5672e.add(TypeAdapters.m4787a(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    /* renamed from: a */
    public Gson m4917a() {
        List<TypeAdapterFactory> arrayList = new ArrayList<>(this.f5672e.size() + this.f5673f.size() + 3);
        arrayList.addAll(this.f5672e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f5673f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        m4915a(this.f5675h, this.f5676i, this.f5677j, arrayList);
        return new Gson(this.f5668a, this.f5670c, this.f5671d, this.f5674g, this.f5678k, this.f5682o, this.f5680m, this.f5681n, this.f5683p, this.f5679l, this.f5669b, this.f5675h, this.f5676i, this.f5677j, this.f5672e, this.f5673f, arrayList);
    }

    /* renamed from: a */
    public final void m4915a(String str, int i, int i2, List<TypeAdapterFactory> list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        DefaultDateTypeAdapter defaultDateTypeAdapter2;
        DefaultDateTypeAdapter defaultDateTypeAdapter3;
        if (str != null && !"".equals(str.trim())) {
            DefaultDateTypeAdapter defaultDateTypeAdapter4 = new DefaultDateTypeAdapter(Date.class, str);
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, str);
            defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
            defaultDateTypeAdapter = defaultDateTypeAdapter4;
        } else if (i == 2 || i2 == 2) {
            return;
        } else {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter5 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter6 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            defaultDateTypeAdapter2 = defaultDateTypeAdapter5;
            defaultDateTypeAdapter3 = defaultDateTypeAdapter6;
        }
        list.add(TypeAdapters.m4786a(Date.class, defaultDateTypeAdapter));
        list.add(TypeAdapters.m4786a(Timestamp.class, defaultDateTypeAdapter2));
        list.add(TypeAdapters.m4786a(java.sql.Date.class, defaultDateTypeAdapter3));
    }
}
