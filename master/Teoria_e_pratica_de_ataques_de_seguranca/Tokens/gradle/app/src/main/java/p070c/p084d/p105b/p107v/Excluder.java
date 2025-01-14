package p070c.p084d.p105b.p107v;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import p070c.p084d.p105b.ExclusionStrategy;
import p070c.p084d.p105b.FieldAttributes;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p106u.Expose;
import p070c.p084d.p105b.p106u.Since;
import p070c.p084d.p105b.p106u.Until;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.d */
/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* renamed from: g */
    public static final Excluder f5711g = new Excluder();

    /* renamed from: d */
    public boolean f5715d;

    /* renamed from: a */
    public double f5712a = -1.0d;

    /* renamed from: b */
    public int f5713b = 136;

    /* renamed from: c */
    public boolean f5714c = true;

    /* renamed from: e */
    public List<ExclusionStrategy> f5716e = Collections.emptyList();

    /* renamed from: f */
    public List<ExclusionStrategy> f5717f = Collections.emptyList();

    @Override // p070c.p084d.p105b.TypeAdapterFactory
    /* renamed from: a */
    public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean m4856a = m4856a(rawType);
        boolean z = m4856a || m4852b(rawType, true);
        boolean z2 = m4856a || m4852b(rawType, false);
        if (z || z2) {
            return new C1282a(z2, z, gson, typeToken);
        }
        return null;
    }

    /* renamed from: b */
    public final boolean m4852b(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.f5716e : this.f5717f) {
            if (exclusionStrategy.m4951a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final boolean m4851c(Class<?> cls) {
        return cls.isMemberClass() && !m4850d(cls);
    }

    /* renamed from: d */
    public final boolean m4850d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* renamed from: clone */
    public Excluder m11330clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* compiled from: Excluder.java */
    /* renamed from: c.d.b.v.d$a */
    /* loaded from: classes.dex */
    public class C1282a extends TypeAdapter<T> {

        /* renamed from: a */
        public TypeAdapter<T> f5718a;

        /* renamed from: b */
        public final /* synthetic */ boolean f5719b;

        /* renamed from: c */
        public final /* synthetic */ boolean f5720c;

        /* renamed from: d */
        public final /* synthetic */ Gson f5721d;

        /* renamed from: e */
        public final /* synthetic */ TypeToken f5722e;

        public C1282a(boolean z, boolean z2, Gson gson, TypeToken typeToken) {
            this.f5719b = z;
            this.f5720c = z2;
            this.f5721d = gson;
            this.f5722e = typeToken;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public T mo4753a(JsonReader jsonReader) {
            if (this.f5719b) {
                jsonReader.mo4732I();
                return null;
            }
            return m4849b().mo4753a(jsonReader);
        }

        /* renamed from: b */
        public final TypeAdapter<T> m4849b() {
            TypeAdapter<T> typeAdapter = this.f5718a;
            if (typeAdapter != 0) {
                return typeAdapter;
            }
            TypeAdapter<T> m4940a = this.f5721d.m4940a(Excluder.this, this.f5722e);
            this.f5718a = m4940a;
            return m4940a;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public void mo4752a(JsonWriter jsonWriter, T t) {
            if (this.f5720c) {
                jsonWriter.mo4679t();
            } else {
                m4849b().mo4752a(jsonWriter, t);
            }
        }
    }

    /* renamed from: b */
    public final boolean m4853b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: a */
    public boolean m4854a(Field field, boolean z) {
        Expose expose;
        if ((this.f5713b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f5712a == -1.0d || m4858a((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic()) {
            if (!this.f5715d || ((expose = (Expose) field.getAnnotation(Expose.class)) != null && (!z ? !expose.deserialize() : !expose.serialize()))) {
                if ((this.f5714c || !m4851c(field.getType())) && !m4853b(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.f5716e : this.f5717f;
                    if (list.isEmpty()) {
                        return false;
                    }
                    FieldAttributes fieldAttributes = new FieldAttributes(field);
                    for (ExclusionStrategy exclusionStrategy : list) {
                        if (exclusionStrategy.m4952a(fieldAttributes)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean m4856a(Class<?> cls) {
        if (this.f5712a == -1.0d || m4858a((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return (!this.f5714c && m4851c(cls)) || m4853b(cls);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m4855a(Class<?> cls, boolean z) {
        return m4856a(cls) || m4852b(cls, z);
    }

    /* renamed from: a */
    public final boolean m4858a(Since since, Until until) {
        return m4859a(since) && m4857a(until);
    }

    /* renamed from: a */
    public final boolean m4859a(Since since) {
        return since == null || since.value() <= this.f5712a;
    }

    /* renamed from: a */
    public final boolean m4857a(Until until) {
        return until == null || until.value() > this.f5712a;
    }
}
