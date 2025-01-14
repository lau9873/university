package p070c.p084d.p105b.p107v;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import p070c.p084d.p105b.JsonElement;
import p070c.p084d.p105b.JsonNull;
import p070c.p084d.p105b.p107v.p108n.TypeAdapters;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.l */
/* loaded from: classes.dex */
public final class Streams {
    /* renamed from: a */
    public static JsonElement m4820a(JsonReader jsonReader) {
        boolean z;
        try {
            try {
                jsonReader.mo4738C();
                z = false;
                try {
                    return TypeAdapters.f5844X.mo4753a(jsonReader);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return JsonNull.f5685a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            } catch (NumberFormatException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
    }

    /* compiled from: Streams.java */
    /* renamed from: c.d.b.v.l$a */
    /* loaded from: classes.dex */
    public static final class C1290a extends Writer {

        /* renamed from: a */
        public final Appendable f5750a;

        /* renamed from: b */
        public final C1291a f5751b = new C1291a();

        /* compiled from: Streams.java */
        /* renamed from: c.d.b.v.l$a$a */
        /* loaded from: classes.dex */
        public static class C1291a implements CharSequence {

            /* renamed from: a */
            public char[] f5752a;

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f5752a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f5752a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f5752a, i, i2 - i);
            }
        }

        public C1290a(Appendable appendable) {
            this.f5750a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            C1291a c1291a = this.f5751b;
            c1291a.f5752a = cArr;
            this.f5750a.append(c1291a, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) {
            this.f5750a.append((char) i);
        }
    }

    /* renamed from: a */
    public static void m4821a(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.f5844X.mo4752a(jsonWriter, jsonElement);
    }

    /* renamed from: a */
    public static Writer m4819a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C1290a(appendable);
    }
}
