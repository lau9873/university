package c.d.b.v;

import c.d.b.v.n.n;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class l {
    public static c.d.b.l a(c.d.b.x.a aVar) {
        boolean z;
        try {
            try {
                aVar.C();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return n.X.a(aVar);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return c.d.b.m.f3733a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    /* compiled from: Streams.java */
    /* loaded from: classes.dex */
    public static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        public final Appendable f3798a;

        /* renamed from: b  reason: collision with root package name */
        public final C0065a f3799b = new C0065a();

        /* compiled from: Streams.java */
        /* renamed from: c.d.b.v.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0065a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            public char[] f3800a;

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f3800a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f3800a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f3800a, i2, i3 - i2);
            }
        }

        public a(Appendable appendable) {
            this.f3798a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            C0065a c0065a = this.f3799b;
            c0065a.f3800a = cArr;
            this.f3798a.append(c0065a, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) {
            this.f3798a.append((char) i2);
        }
    }

    public static void a(c.d.b.l lVar, c.d.b.x.c cVar) {
        n.X.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
