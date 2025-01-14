package c.d.b.v.n;

import c.d.b.o;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class f extends c.d.b.x.c {
    public static final Writer p = new a();
    public static final o q = new o("closed");
    public final List<c.d.b.l> m;
    public String n;
    public c.d.b.l o;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes.dex */
    public static class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public f() {
        super(p);
        this.m = new ArrayList();
        this.o = c.d.b.m.f3733a;
    }

    public final void a(c.d.b.l lVar) {
        if (this.n != null) {
            if (!lVar.r() || p()) {
                ((c.d.b.n) u()).a(this.n, lVar);
            }
            this.n = null;
        } else if (this.m.isEmpty()) {
            this.o = lVar;
        } else {
            c.d.b.l u = u();
            if (u instanceof c.d.b.i) {
                ((c.d.b.i) u).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c b(String str) {
        if (!this.m.isEmpty() && this.n == null) {
            if (u() instanceof c.d.b.n) {
                this.n = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // c.d.b.x.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.m.isEmpty()) {
            this.m.add(q);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c d(boolean z) {
        a(new o(Boolean.valueOf(z)));
        return this;
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c e(String str) {
        if (str == null) {
            t();
            return this;
        }
        a(new o(str));
        return this;
    }

    @Override // c.d.b.x.c, java.io.Flushable
    public void flush() {
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c g(long j) {
        a(new o(Long.valueOf(j)));
        return this;
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c l() {
        c.d.b.i iVar = new c.d.b.i();
        a(iVar);
        this.m.add(iVar);
        return this;
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c m() {
        c.d.b.n nVar = new c.d.b.n();
        a(nVar);
        this.m.add(nVar);
        return this;
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c n() {
        if (!this.m.isEmpty() && this.n == null) {
            if (u() instanceof c.d.b.i) {
                List<c.d.b.l> list = this.m;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c o() {
        if (!this.m.isEmpty() && this.n == null) {
            if (u() instanceof c.d.b.n) {
                List<c.d.b.l> list = this.m;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c t() {
        a(c.d.b.m.f3733a);
        return this;
    }

    @Override // c.d.b.x.c
    public final c.d.b.l u() {
        List<c.d.b.l> list = this.m;
        return list.get(list.size() - 1);
    }

    public c.d.b.l w() {
        if (this.m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.m);
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c a(Boolean bool) {
        if (bool == null) {
            t();
            return this;
        }
        a(new o(bool));
        return this;
    }

    @Override // c.d.b.x.c
    public c.d.b.x.c a(Number number) {
        if (number == null) {
            t();
            return this;
        }
        if (!r()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new o(number));
        return this;
    }
}
