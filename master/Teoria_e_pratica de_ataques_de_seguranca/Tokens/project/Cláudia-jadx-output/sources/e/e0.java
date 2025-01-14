package e;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class e0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public Reader f5525a;

    /* compiled from: ResponseBody.java */
    /* loaded from: classes.dex */
    public class a extends e0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f5526b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f5527c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f.e f5528d;

        public a(w wVar, long j, f.e eVar) {
            this.f5526b = wVar;
            this.f5527c = j;
            this.f5528d = eVar;
        }

        @Override // e.e0
        public long l() {
            return this.f5527c;
        }

        @Override // e.e0
        public w m() {
            return this.f5526b;
        }

        @Override // e.e0
        public f.e n() {
            return this.f5528d;
        }
    }

    /* compiled from: ResponseBody.java */
    /* loaded from: classes.dex */
    public static final class b extends Reader {

        /* renamed from: a  reason: collision with root package name */
        public final f.e f5529a;

        /* renamed from: b  reason: collision with root package name */
        public final Charset f5530b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5531c;

        /* renamed from: d  reason: collision with root package name */
        public Reader f5532d;

        public b(f.e eVar, Charset charset) {
            this.f5529a = eVar;
            this.f5530b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f5531c = true;
            Reader reader = this.f5532d;
            if (reader != null) {
                reader.close();
            } else {
                this.f5529a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) {
            if (!this.f5531c) {
                Reader reader = this.f5532d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f5529a.h(), e.i0.c.a(this.f5529a, this.f5530b));
                    this.f5532d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    public static e0 a(w wVar, byte[] bArr) {
        f.c cVar = new f.c();
        cVar.write(bArr);
        return a(wVar, bArr.length, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e.i0.c.a(n());
    }

    public final Reader j() {
        Reader reader = this.f5525a;
        if (reader != null) {
            return reader;
        }
        b bVar = new b(n(), k());
        this.f5525a = bVar;
        return bVar;
    }

    public final Charset k() {
        w m = m();
        return m != null ? m.a(e.i0.c.f5570i) : e.i0.c.f5570i;
    }

    public abstract long l();

    public abstract w m();

    public abstract f.e n();

    public static e0 a(w wVar, long j, f.e eVar) {
        if (eVar != null) {
            return new a(wVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }
}
