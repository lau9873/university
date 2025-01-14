package c.b.a.d;

import c.b.a.d.o0.b.f;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: NativeCrashWriter.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final c.b.a.d.o0.b.e f3150a = new c.b.a.d.o0.b.e("", "", 0);

    /* renamed from: b  reason: collision with root package name */
    public static final j[] f3151b = new j[0];

    /* renamed from: c  reason: collision with root package name */
    public static final m[] f3152c = new m[0];

    /* renamed from: d  reason: collision with root package name */
    public static final g[] f3153d = new g[0];

    /* renamed from: e  reason: collision with root package name */
    public static final b[] f3154e = new b[0];

    /* renamed from: f  reason: collision with root package name */
    public static final c[] f3155f = new c[0];

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class a extends j {
        public a(f fVar, k kVar) {
            super(3, fVar, kVar);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class b extends j {

        /* renamed from: c  reason: collision with root package name */
        public final long f3156c;

        /* renamed from: d  reason: collision with root package name */
        public final long f3157d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3158e;

        /* renamed from: f  reason: collision with root package name */
        public final String f3159f;

        public b(c.b.a.d.o0.b.a aVar) {
            super(4, new j[0]);
            this.f3156c = aVar.f3091a;
            this.f3157d = aVar.f3092b;
            this.f3158e = aVar.f3093c;
            this.f3159f = aVar.f3094d;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            int b2 = c.b.a.d.e.b(1, this.f3156c);
            return c.b.a.d.e.b(3, c.b.a.d.b.a(this.f3158e)) + b2 + c.b.a.d.e.b(2, this.f3157d) + c.b.a.d.e.b(4, c.b.a.d.b.a(this.f3159f));
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, this.f3156c);
            eVar.a(2, this.f3157d);
            eVar.a(3, c.b.a.d.b.a(this.f3158e));
            eVar.a(4, c.b.a.d.b.a(this.f3159f));
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class c extends j {

        /* renamed from: c  reason: collision with root package name */
        public final String f3160c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3161d;

        public c(c.b.a.d.o0.b.b bVar) {
            super(2, new j[0]);
            this.f3160c = bVar.f3095a;
            this.f3161d = bVar.f3096b;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            int b2 = c.b.a.d.e.b(1, c.b.a.d.b.a(this.f3160c));
            String str = this.f3161d;
            if (str == null) {
                str = "";
            }
            return b2 + c.b.a.d.e.b(2, c.b.a.d.b.a(str));
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, c.b.a.d.b.a(this.f3160c));
            String str = this.f3161d;
            if (str == null) {
                str = "";
            }
            eVar.a(2, c.b.a.d.b.a(str));
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class d extends j {

        /* renamed from: c  reason: collision with root package name */
        public final float f3162c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3163d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3164e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3165f;

        /* renamed from: g  reason: collision with root package name */
        public final long f3166g;

        /* renamed from: h  reason: collision with root package name */
        public final long f3167h;

        public d(float f2, int i2, boolean z, int i3, long j, long j2) {
            super(5, new j[0]);
            this.f3162c = f2;
            this.f3163d = i2;
            this.f3164e = z;
            this.f3165f = i3;
            this.f3166g = j;
            this.f3167h = j2;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            return c.b.a.d.e.b(1, this.f3162c) + 0 + c.b.a.d.e.f(2, this.f3163d) + c.b.a.d.e.b(3, this.f3164e) + c.b.a.d.e.g(4, this.f3165f) + c.b.a.d.e.b(5, this.f3166g) + c.b.a.d.e.b(6, this.f3167h);
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, this.f3162c);
            eVar.b(2, this.f3163d);
            eVar.a(3, this.f3164e);
            eVar.d(4, this.f3165f);
            eVar.a(5, this.f3166g);
            eVar.a(6, this.f3167h);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class e extends j {

        /* renamed from: c  reason: collision with root package name */
        public final long f3168c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3169d;

        public e(long j, String str, j... jVarArr) {
            super(10, jVarArr);
            this.f3168c = j;
            this.f3169d = str;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            return c.b.a.d.e.b(1, this.f3168c) + c.b.a.d.e.b(2, c.b.a.d.b.a(this.f3169d));
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, this.f3168c);
            eVar.a(2, c.b.a.d.b.a(this.f3169d));
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class f extends j {
        public f(l lVar, k kVar, k kVar2) {
            super(1, kVar, lVar, kVar2);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class g extends j {

        /* renamed from: c  reason: collision with root package name */
        public final long f3170c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3171d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3172e;

        /* renamed from: f  reason: collision with root package name */
        public final long f3173f;

        /* renamed from: g  reason: collision with root package name */
        public final int f3174g;

        public g(f.a aVar) {
            super(3, new j[0]);
            this.f3170c = aVar.f3117a;
            this.f3171d = aVar.f3118b;
            this.f3172e = aVar.f3119c;
            this.f3173f = aVar.f3120d;
            this.f3174g = aVar.f3121e;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            return c.b.a.d.e.b(1, this.f3170c) + c.b.a.d.e.b(2, c.b.a.d.b.a(this.f3171d)) + c.b.a.d.e.b(3, c.b.a.d.b.a(this.f3172e)) + c.b.a.d.e.b(4, this.f3173f) + c.b.a.d.e.g(5, this.f3174g);
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, this.f3170c);
            eVar.a(2, c.b.a.d.b.a(this.f3171d));
            eVar.a(3, c.b.a.d.b.a(this.f3172e));
            eVar.a(4, this.f3173f);
            eVar.d(5, this.f3174g);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class h extends j {

        /* renamed from: c  reason: collision with root package name */
        public c.b.a.d.b f3175c;

        public h(c.b.a.d.b bVar) {
            super(6, new j[0]);
            this.f3175c = bVar;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            return c.b.a.d.e.b(1, this.f3175c);
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, this.f3175c);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class i extends j {
        public i() {
            super(0, new j[0]);
        }

        @Override // c.b.a.d.z.j
        public void a(c.b.a.d.e eVar) {
        }

        @Override // c.b.a.d.z.j
        public int b() {
            return 0;
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static abstract class j {

        /* renamed from: a  reason: collision with root package name */
        public final int f3176a;

        /* renamed from: b  reason: collision with root package name */
        public final j[] f3177b;

        public j(int i2, j... jVarArr) {
            this.f3176a = i2;
            this.f3177b = jVarArr == null ? z.f3151b : jVarArr;
        }

        public int a() {
            return 0;
        }

        public void a(c.b.a.d.e eVar) {
            eVar.c(this.f3176a, 2);
            eVar.e(c());
            b(eVar);
            for (j jVar : this.f3177b) {
                jVar.a(eVar);
            }
        }

        public int b() {
            int c2 = c();
            return c2 + c.b.a.d.e.j(c2) + c.b.a.d.e.l(this.f3176a);
        }

        public void b(c.b.a.d.e eVar) {
        }

        public int c() {
            int a2 = a();
            for (j jVar : this.f3177b) {
                a2 += jVar.b();
            }
            return a2;
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class k extends j {

        /* renamed from: c  reason: collision with root package name */
        public final j[] f3178c;

        public k(j... jVarArr) {
            super(0, new j[0]);
            this.f3178c = jVarArr;
        }

        @Override // c.b.a.d.z.j
        public void a(c.b.a.d.e eVar) {
            for (j jVar : this.f3178c) {
                jVar.a(eVar);
            }
        }

        @Override // c.b.a.d.z.j
        public int b() {
            int i2 = 0;
            for (j jVar : this.f3178c) {
                i2 += jVar.b();
            }
            return i2;
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class l extends j {

        /* renamed from: c  reason: collision with root package name */
        public final String f3179c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3180d;

        /* renamed from: e  reason: collision with root package name */
        public final long f3181e;

        public l(c.b.a.d.o0.b.e eVar) {
            super(3, new j[0]);
            this.f3179c = eVar.f3111a;
            this.f3180d = eVar.f3112b;
            this.f3181e = eVar.f3113c;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            return c.b.a.d.e.b(1, c.b.a.d.b.a(this.f3179c)) + c.b.a.d.e.b(2, c.b.a.d.b.a(this.f3180d)) + c.b.a.d.e.b(3, this.f3181e);
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            eVar.a(1, c.b.a.d.b.a(this.f3179c));
            eVar.a(2, c.b.a.d.b.a(this.f3180d));
            eVar.a(3, this.f3181e);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* loaded from: classes.dex */
    public static final class m extends j {

        /* renamed from: c  reason: collision with root package name */
        public final String f3182c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3183d;

        public m(c.b.a.d.o0.b.f fVar, k kVar) {
            super(1, kVar);
            this.f3182c = fVar.f3114a;
            this.f3183d = fVar.f3115b;
        }

        @Override // c.b.a.d.z.j
        public int a() {
            return c.b.a.d.e.g(2, this.f3183d) + (d() ? c.b.a.d.e.b(1, c.b.a.d.b.a(this.f3182c)) : 0);
        }

        @Override // c.b.a.d.z.j
        public void b(c.b.a.d.e eVar) {
            if (d()) {
                eVar.a(1, c.b.a.d.b.a(this.f3182c));
            }
            eVar.d(2, this.f3183d);
        }

        public final boolean d() {
            String str = this.f3182c;
            return str != null && str.length() > 0;
        }
    }

    public static e a(c.b.a.d.o0.b.d dVar, u uVar, Map<String, String> map) {
        c.b.a.d.o0.b.e eVar = dVar.f3106b;
        if (eVar == null) {
            eVar = f3150a;
        }
        a aVar = new a(new f(new l(eVar), a(dVar.f3107c), a(dVar.f3108d)), a(a(dVar.f3109e, map)));
        j a2 = a(dVar.f3110f);
        c.b.a.d.b b2 = uVar.b();
        if (b2 == null) {
            d.a.a.a.c.h().e("CrashlyticsCore", "No log data to include with this event.");
        }
        uVar.a();
        return new e(dVar.f3105a, "ndk-crash", aVar, a2, b2 != null ? new h(b2) : new i());
    }

    public static c.b.a.d.o0.b.b[] a(c.b.a.d.o0.b.b[] bVarArr, Map<String, String> map) {
        TreeMap treeMap = new TreeMap(map);
        if (bVarArr != null) {
            for (c.b.a.d.o0.b.b bVar : bVarArr) {
                treeMap.put(bVar.f3095a, bVar.f3096b);
            }
        }
        Map.Entry[] entryArr = (Map.Entry[]) treeMap.entrySet().toArray(new Map.Entry[treeMap.size()]);
        c.b.a.d.o0.b.b[] bVarArr2 = new c.b.a.d.o0.b.b[entryArr.length];
        for (int i2 = 0; i2 < bVarArr2.length; i2++) {
            bVarArr2[i2] = new c.b.a.d.o0.b.b((String) entryArr[i2].getKey(), (String) entryArr[i2].getValue());
        }
        return bVarArr2;
    }

    public static j a(c.b.a.d.o0.b.c cVar) {
        if (cVar == null) {
            return new i();
        }
        return new d(cVar.f3102f / 100.0f, cVar.f3103g, cVar.f3104h, cVar.f3097a, cVar.f3098b - cVar.f3100d, cVar.f3099c - cVar.f3101e);
    }

    public static k a(c.b.a.d.o0.b.f[] fVarArr) {
        m[] mVarArr = fVarArr != null ? new m[fVarArr.length] : f3152c;
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            c.b.a.d.o0.b.f fVar = fVarArr[i2];
            mVarArr[i2] = new m(fVar, a(fVar.f3116c));
        }
        return new k(mVarArr);
    }

    public static k a(f.a[] aVarArr) {
        g[] gVarArr = aVarArr != null ? new g[aVarArr.length] : f3153d;
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            gVarArr[i2] = new g(aVarArr[i2]);
        }
        return new k(gVarArr);
    }

    public static k a(c.b.a.d.o0.b.a[] aVarArr) {
        b[] bVarArr = aVarArr != null ? new b[aVarArr.length] : f3154e;
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr[i2] = new b(aVarArr[i2]);
        }
        return new k(bVarArr);
    }

    public static k a(c.b.a.d.o0.b.b[] bVarArr) {
        c[] cVarArr = bVarArr != null ? new c[bVarArr.length] : f3155f;
        for (int i2 = 0; i2 < cVarArr.length; i2++) {
            cVarArr[i2] = new c(bVarArr[i2]);
        }
        return new k(cVarArr);
    }

    public static void a(c.b.a.d.o0.b.d dVar, u uVar, Map<String, String> map, c.b.a.d.e eVar) {
        a(dVar, uVar, map).a(eVar);
    }
}
