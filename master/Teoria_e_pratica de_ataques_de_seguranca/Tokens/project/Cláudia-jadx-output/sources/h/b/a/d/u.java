package h.b.a.d;

import h.b.a.d.b;
import h.b.a.d.y;
/* compiled from: Session.java */
/* loaded from: classes.dex */
public interface u {

    /* compiled from: Session.java */
    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: b  reason: collision with root package name */
        public final String f7050b;

        /* renamed from: c  reason: collision with root package name */
        public final String f7051c;

        public a(boolean z, String str, String str2) {
            super(z);
            this.f7051c = str;
            this.f7050b = str2;
        }

        @Override // h.b.a.d.u.d
        public String b() {
            return this.f7050b;
        }

        public String d() {
            return this.f7051c;
        }
    }

    /* compiled from: Session.java */
    /* loaded from: classes.dex */
    public interface b extends y.a {
        h.b.a.d.b<c> n();

        void p();
    }

    /* compiled from: Session.java */
    /* loaded from: classes.dex */
    public static abstract class c extends d {
        public c(boolean z) {
            super(z);
        }
    }

    /* compiled from: Session.java */
    /* loaded from: classes.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7052a;

        public d(boolean z) {
            this.f7052a = z;
        }

        public String a() {
            return null;
        }

        public String b() {
            return null;
        }

        public boolean c() {
            return this.f7052a;
        }
    }

    /* compiled from: Session.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(x xVar);
    }

    b.AbstractC0157b<h.b.a.d.c> a(long j, long j2);

    h.b.a.d.b<a> a(String str, String str2);

    void a(s sVar);

    void a(e eVar);

    void a(Runnable runnable);

    boolean a();

    x b();

    void b(e eVar);

    void c();

    h d();

    b e();
}
