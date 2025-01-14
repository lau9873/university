package p070c.p084d.p105b.p107v.p108n;

import java.util.ArrayList;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p107v.LinkedTreeMap;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.h */
/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: b */
    public static final TypeAdapterFactory f5783b = new C1302a();

    /* renamed from: a */
    public final Gson f5784a;

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: c.d.b.v.n.h$a */
    /* loaded from: classes.dex */
    public static class C1302a implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: c.d.b.v.n.h$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1303b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5785a = new int[JsonToken.values().length];

        static {
            try {
                f5785a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5785a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5785a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5785a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5785a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5785a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ObjectTypeAdapter(Gson gson) {
        this.f5784a = gson;
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public Object mo4753a(JsonReader jsonReader) {
        switch (C1303b.f5785a[jsonReader.mo4738C().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.mo4722j();
                while (jsonReader.mo4714r()) {
                    arrayList.add(mo4753a(jsonReader));
                }
                jsonReader.mo4717o();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.mo4721k();
                while (jsonReader.mo4714r()) {
                    linkedTreeMap.put(jsonReader.mo4707y(), mo4753a(jsonReader));
                }
                jsonReader.mo4716p();
                return linkedTreeMap;
            case 3:
                return jsonReader.mo4740A();
            case 4:
                return Double.valueOf(jsonReader.mo4710v());
            case 5:
                return Boolean.valueOf(jsonReader.mo4711u());
            case 6:
                jsonReader.mo4706z();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a */
    public void mo4752a(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.mo4679t();
            return;
        }
        TypeAdapter m4934a = this.f5784a.m4934a((Class) obj.getClass());
        if (m4934a instanceof ObjectTypeAdapter) {
            jsonWriter.mo4686m();
            jsonWriter.mo4684o();
            return;
        }
        m4934a.mo4752a(jsonWriter, obj);
    }
}
