package p070c.p084d.p105b;

import com.google.gson.JsonIOException;
import java.io.IOException;
import p070c.p084d.p105b.p107v.p108n.JsonTreeWriter;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.s */
/* loaded from: classes.dex */
public abstract class TypeAdapter<T> {
    /* renamed from: a */
    public final TypeAdapter<T> m4888a() {
        return new C1264a();
    }

    /* renamed from: a */
    public abstract T mo4753a(JsonReader jsonReader);

    /* renamed from: a */
    public abstract void mo4752a(JsonWriter jsonWriter, T t);

    /* compiled from: TypeAdapter.java */
    /* renamed from: c.d.b.s$a */
    /* loaded from: classes.dex */
    public class C1264a extends TypeAdapter<T> {
        public C1264a() {
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public void mo4752a(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.mo4679t();
            } else {
                TypeAdapter.this.mo4752a(jsonWriter, t);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public T mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return (T) TypeAdapter.this.mo4753a(jsonReader);
        }
    }

    /* renamed from: a */
    public final JsonElement m4887a(T t) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            mo4752a(jsonTreeWriter, t);
            return jsonTreeWriter.m4804w();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
