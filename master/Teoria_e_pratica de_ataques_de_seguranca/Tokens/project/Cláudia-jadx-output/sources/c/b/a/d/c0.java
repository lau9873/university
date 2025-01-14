package c.b.a.d;

import d.a.a.a.m.b.q;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
/* compiled from: QueueFileLogStore.java */
/* loaded from: classes.dex */
public class c0 implements s {

    /* renamed from: a  reason: collision with root package name */
    public final File f2980a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2981b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.a.a.m.b.q f2982c;

    /* compiled from: QueueFileLogStore.java */
    /* loaded from: classes.dex */
    public class a implements q.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f2983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f2984b;

        public a(c0 c0Var, byte[] bArr, int[] iArr) {
            this.f2983a = bArr;
            this.f2984b = iArr;
        }

        @Override // d.a.a.a.m.b.q.d
        public void a(InputStream inputStream, int i2) {
            try {
                inputStream.read(this.f2983a, this.f2984b[0], i2);
                int[] iArr = this.f2984b;
                iArr[0] = iArr[0] + i2;
            } finally {
                inputStream.close();
            }
        }
    }

    public c0(File file, int i2) {
        this.f2980a = file;
        this.f2981b = i2;
    }

    @Override // c.b.a.d.s
    public void a(long j, String str) {
        d();
        b(j, str);
    }

    @Override // c.b.a.d.s
    public b b() {
        if (this.f2980a.exists()) {
            d();
            d.a.a.a.m.b.q qVar = this.f2982c;
            if (qVar == null) {
                return null;
            }
            int[] iArr = {0};
            byte[] bArr = new byte[qVar.o()];
            try {
                this.f2982c.a(new a(this, bArr, iArr));
            } catch (IOException e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e2);
            }
            return b.a(bArr, 0, iArr[0]);
        }
        return null;
    }

    @Override // c.b.a.d.s
    public void c() {
        a();
        this.f2980a.delete();
    }

    public final void d() {
        if (this.f2982c == null) {
            try {
                this.f2982c = new d.a.a.a.m.b.q(this.f2980a);
            } catch (IOException e2) {
                d.a.a.a.k h2 = d.a.a.a.c.h();
                h2.c("CrashlyticsCore", "Could not open log file: " + this.f2980a, e2);
            }
        }
    }

    @Override // c.b.a.d.s
    public void a() {
        d.a.a.a.m.b.i.a(this.f2982c, "There was a problem closing the Crashlytics log file.");
        this.f2982c = null;
    }

    public final void b(long j, String str) {
        int i2;
        if (this.f2982c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > this.f2981b / 4) {
                str = "..." + str.substring(str.length() - i2);
            }
            this.f2982c.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes("UTF-8"));
            while (!this.f2982c.k() && this.f2982c.o() > this.f2981b) {
                this.f2982c.n();
            }
        } catch (IOException e2) {
            d.a.a.a.c.h().c("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e2);
        }
    }
}
