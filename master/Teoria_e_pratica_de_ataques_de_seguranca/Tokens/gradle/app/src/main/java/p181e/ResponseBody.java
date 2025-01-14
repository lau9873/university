package p181e;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import p181e.p182i0.Util;
import p192f.Buffer;
import p192f.BufferedSource;

/* renamed from: e.e0 */
/* loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {

    /* renamed from: a */
    public Reader f7888a;

    /* compiled from: ResponseBody.java */
    /* renamed from: e.e0$a */
    /* loaded from: classes.dex */
    public class C1747a extends ResponseBody {

        /* renamed from: b */
        public final /* synthetic */ MediaType f7889b;

        /* renamed from: c */
        public final /* synthetic */ long f7890c;

        /* renamed from: d */
        public final /* synthetic */ BufferedSource f7891d;

        public C1747a(MediaType mediaType, long j, BufferedSource bufferedSource) {
            this.f7889b = mediaType;
            this.f7890c = j;
            this.f7891d = bufferedSource;
        }

        @Override // p181e.ResponseBody
        /* renamed from: l */
        public long mo672l() {
            return this.f7890c;
        }

        @Override // p181e.ResponseBody
        /* renamed from: m */
        public MediaType mo671m() {
            return this.f7889b;
        }

        @Override // p181e.ResponseBody
        /* renamed from: n */
        public BufferedSource mo670n() {
            return this.f7891d;
        }
    }

    /* compiled from: ResponseBody.java */
    /* renamed from: e.e0$b */
    /* loaded from: classes.dex */
    public static final class C1748b extends Reader {

        /* renamed from: a */
        public final BufferedSource f7892a;

        /* renamed from: b */
        public final Charset f7893b;

        /* renamed from: c */
        public boolean f7894c;

        /* renamed from: d */
        public Reader f7895d;

        public C1748b(BufferedSource bufferedSource, Charset charset) {
            this.f7892a = bufferedSource;
            this.f7893b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f7894c = true;
            Reader reader = this.f7895d;
            if (reader != null) {
                reader.close();
            } else {
                this.f7892a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            if (!this.f7894c) {
                Reader reader = this.f7895d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f7892a.mo2553h(), Util.m3171a(this.f7892a, this.f7893b));
                    this.f7895d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    /* renamed from: a */
    public static ResponseBody m3194a(MediaType mediaType, byte[] bArr) {
        Buffer buffer = new Buffer();
        buffer.write(bArr);
        return m3195a(mediaType, bArr.length, buffer);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.m3169a(mo670n());
    }

    /* renamed from: j */
    public final Reader m3193j() {
        Reader reader = this.f7888a;
        if (reader != null) {
            return reader;
        }
        C1748b c1748b = new C1748b(mo670n(), m3192k());
        this.f7888a = c1748b;
        return c1748b;
    }

    /* renamed from: k */
    public final Charset m3192k() {
        MediaType mo671m = mo671m();
        return mo671m != null ? mo671m.m2691a(Util.f7942i) : Util.f7942i;
    }

    /* renamed from: l */
    public abstract long mo672l();

    /* renamed from: m */
    public abstract MediaType mo671m();

    /* renamed from: n */
    public abstract BufferedSource mo670n();

    /* renamed from: a */
    public static ResponseBody m3195a(MediaType mediaType, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new C1747a(mediaType, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
