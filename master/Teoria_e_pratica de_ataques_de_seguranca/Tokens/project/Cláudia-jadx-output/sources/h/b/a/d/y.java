package h.b.a.d;

import h.b.a.d.u;
import java.util.Date;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: UserProfile.java */
/* loaded from: classes.dex */
public interface y {

    /* compiled from: UserProfile.java */
    /* loaded from: classes.dex */
    public interface a extends y {
        void a(String str);

        void a(DataModels.Country country);

        void b(String str);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(String str);

        void g(String str);

        void h(String str);

        void i(String str);

        void j(String str);
    }

    /* compiled from: UserProfile.java */
    /* loaded from: classes.dex */
    public interface b {

        /* compiled from: UserProfile.java */
        /* loaded from: classes.dex */
        public enum a {
            UNKNOWN,
            ACTIVE,
            INHIBITED,
            CANCELLED,
            ACTIVATION_PENDING
        }

        /* compiled from: UserProfile.java */
        /* renamed from: h.b.a.d.y$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0165b {
            LOW_VALUE,
            CREDIT_CARD
        }

        String a();

        String b();

        String c();

        String d();

        EnumC0165b e();

        String f();
    }

    /* compiled from: UserProfile.java */
    /* loaded from: classes.dex */
    public interface c {
        String a();

        Date b();

        Date c();
    }

    /* compiled from: UserProfile.java */
    /* loaded from: classes.dex */
    public interface d extends a {
        h.b.a.d.b<u.d> a(String str, String str2, String str3);

        h.b.a.d.b<u.d> o();
    }

    String a();

    String b();

    String c();

    List<c> d();

    String e();

    d edit();

    String f();

    String g();

    String h();

    String i();

    b j();

    String k();

    String l();

    String m();
}
