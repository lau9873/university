package e;

import java.io.File;
/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class c0 {

    /* compiled from: RequestBody.java */
    /* loaded from: classes.dex */
    public class a extends c0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f5482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f.f f5483b;

        public a(w wVar, f.f fVar) {
            this.f5482a = wVar;
            this.f5483b = fVar;
        }

        @Override // e.c0
        public long a() {
            return this.f5483b.f();
        }

        @Override // e.c0
        public w b() {
            return this.f5482a;
        }

        @Override // e.c0
        public void a(f.d dVar) {
            dVar.a(this.f5483b);
        }
    }

    /* compiled from: RequestBody.java */
    /* loaded from: classes.dex */
    public class b extends c0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f5484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5485b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f5486c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f5487d;

        public b(w wVar, int i2, byte[] bArr, int i3) {
            this.f5484a = wVar;
            this.f5485b = i2;
            this.f5486c = bArr;
            this.f5487d = i3;
        }

        @Override // e.c0
        public long a() {
            return this.f5485b;
        }

        @Override // e.c0
        public w b() {
            return this.f5484a;
        }

        @Override // e.c0
        public void a(f.d dVar) {
            dVar.write(this.f5486c, this.f5487d, this.f5485b);
        }
    }

    /* compiled from: RequestBody.java */
    /* loaded from: classes.dex */
    public class c extends c0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f5488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f5489b;

        public c(w wVar, File file) {
            this.f5488a = wVar;
            this.f5489b = file;
        }

        @Override // e.c0
        public long a() {
            return this.f5489b.length();
        }

        @Override // e.c0
        public w b() {
            return this.f5488a;
        }

        @Override // e.c0
        public void a(f.d dVar) {
            f.r rVar = null;
            try {
                rVar = f.k.a(this.f5489b);
                dVar.a(rVar);
            } finally {
                e.i0.c.a(rVar);
            }
        }
    }

    public static c0 a(w wVar, f.f fVar) {
        return new a(wVar, fVar);
    }

    public long a() {
        return -1L;
    }

    public abstract void a(f.d dVar);

    public abstract w b();

    public static c0 a(w wVar, byte[] bArr) {
        return a(wVar, bArr, 0, bArr.length);
    }

    public static c0 a(w wVar, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            e.i0.c.a(bArr.length, i2, i3);
            return new b(wVar, i3, bArr, i2);
        }
        throw new NullPointerException("content == null");
    }

    public static c0 a(w wVar, File file) {
        if (file != null) {
            return new c(wVar, file);
        }
        throw new NullPointerException("content == null");
    }
}
