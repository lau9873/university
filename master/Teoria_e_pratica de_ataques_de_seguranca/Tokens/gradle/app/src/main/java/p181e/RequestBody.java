package p181e;

import java.io.File;
import p181e.p182i0.Util;
import p192f.BufferedSink;
import p192f.C1822f;
import p192f.Okio;
import p192f.Source;

/* renamed from: e.c0 */
/* loaded from: classes.dex */
public abstract class RequestBody {

    /* compiled from: RequestBody.java */
    /* renamed from: e.c0$a */
    /* loaded from: classes.dex */
    public class C1740a extends RequestBody {

        /* renamed from: a */
        public final /* synthetic */ MediaType f7834a;

        /* renamed from: b */
        public final /* synthetic */ C1822f f7835b;

        public C1740a(MediaType mediaType, C1822f c1822f) {
            this.f7834a = mediaType;
            this.f7835b = c1822f;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public long mo645a() {
            return this.f7835b.mo2535f();
        }

        @Override // p181e.RequestBody
        /* renamed from: b */
        public MediaType mo643b() {
            return this.f7834a;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public void mo644a(BufferedSink bufferedSink) {
            bufferedSink.mo2575a(this.f7835b);
        }
    }

    /* compiled from: RequestBody.java */
    /* renamed from: e.c0$b */
    /* loaded from: classes.dex */
    public class C1741b extends RequestBody {

        /* renamed from: a */
        public final /* synthetic */ MediaType f7836a;

        /* renamed from: b */
        public final /* synthetic */ int f7837b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f7838c;

        /* renamed from: d */
        public final /* synthetic */ int f7839d;

        public C1741b(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.f7836a = mediaType;
            this.f7837b = i;
            this.f7838c = bArr;
            this.f7839d = i2;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public long mo645a() {
            return this.f7837b;
        }

        @Override // p181e.RequestBody
        /* renamed from: b */
        public MediaType mo643b() {
            return this.f7836a;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public void mo644a(BufferedSink bufferedSink) {
            bufferedSink.write(this.f7838c, this.f7839d, this.f7837b);
        }
    }

    /* compiled from: RequestBody.java */
    /* renamed from: e.c0$c */
    /* loaded from: classes.dex */
    public class C1742c extends RequestBody {

        /* renamed from: a */
        public final /* synthetic */ MediaType f7840a;

        /* renamed from: b */
        public final /* synthetic */ File f7841b;

        public C1742c(MediaType mediaType, File file) {
            this.f7840a = mediaType;
            this.f7841b = file;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public long mo645a() {
            return this.f7841b.length();
        }

        @Override // p181e.RequestBody
        /* renamed from: b */
        public MediaType mo643b() {
            return this.f7840a;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public void mo644a(BufferedSink bufferedSink) {
            Source source = null;
            try {
                source = Okio.m2585a(this.f7841b);
                bufferedSink.mo2574a(source);
            } finally {
                Util.m3169a(source);
            }
        }
    }

    /* renamed from: a */
    public static RequestBody m3246a(MediaType mediaType, C1822f c1822f) {
        return new C1740a(mediaType, c1822f);
    }

    /* renamed from: a */
    public long mo645a() {
        return -1L;
    }

    /* renamed from: a */
    public abstract void mo644a(BufferedSink bufferedSink);

    /* renamed from: b */
    public abstract MediaType mo643b();

    /* renamed from: a */
    public static RequestBody m3244a(MediaType mediaType, byte[] bArr) {
        return m3243a(mediaType, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static RequestBody m3243a(MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Util.m3173a(bArr.length, i, i2);
            return new C1741b(mediaType, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    /* renamed from: a */
    public static RequestBody m3245a(MediaType mediaType, File file) {
        if (file != null) {
            return new C1742c(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
