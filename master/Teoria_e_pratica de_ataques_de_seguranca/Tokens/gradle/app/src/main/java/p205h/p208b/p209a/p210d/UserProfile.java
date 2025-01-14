package p205h.p208b.p209a.p210d;

import java.util.Date;
import java.util.List;
import p205h.p208b.p209a.p210d.Session;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.y */
/* loaded from: classes.dex */
public interface UserProfile {

    /* compiled from: UserProfile.java */
    /* renamed from: h.b.a.d.y$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2372a extends UserProfile {
        /* renamed from: a */
        void mo1235a(String str);

        /* renamed from: a */
        void mo1234a(DataModels.Country country);

        /* renamed from: b */
        void mo1233b(String str);

        /* renamed from: c */
        void mo1232c(String str);

        /* renamed from: d */
        void mo1231d(String str);

        /* renamed from: e */
        void mo1230e(String str);

        /* renamed from: f */
        void mo1229f(String str);

        /* renamed from: g */
        void mo1228g(String str);

        /* renamed from: h */
        void mo1227h(String str);

        /* renamed from: i */
        void mo1226i(String str);

        /* renamed from: j */
        void mo1225j(String str);
    }

    /* compiled from: UserProfile.java */
    /* renamed from: h.b.a.d.y$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2373b {

        /* compiled from: UserProfile.java */
        /* renamed from: h.b.a.d.y$b$a */
        /* loaded from: classes.dex */
        public enum EnumC2374a {
            UNKNOWN,
            ACTIVE,
            INHIBITED,
            CANCELLED,
            ACTIVATION_PENDING
        }

        /* compiled from: UserProfile.java */
        /* renamed from: h.b.a.d.y$b$b */
        /* loaded from: classes.dex */
        public enum EnumC2375b {
            LOW_VALUE,
            CREDIT_CARD
        }

        /* renamed from: a */
        String mo1224a();

        /* renamed from: b */
        String mo1223b();

        /* renamed from: c */
        String mo1222c();

        /* renamed from: d */
        String mo1221d();

        /* renamed from: e */
        EnumC2375b mo1220e();

        /* renamed from: f */
        String mo1219f();
    }

    /* compiled from: UserProfile.java */
    /* renamed from: h.b.a.d.y$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2376c {
        /* renamed from: a */
        String mo1218a();

        /* renamed from: b */
        Date mo1217b();

        /* renamed from: c */
        Date mo1216c();
    }

    /* compiled from: UserProfile.java */
    /* renamed from: h.b.a.d.y$d */
    /* loaded from: classes.dex */
    public interface InterfaceC2377d extends InterfaceC2372a {
        /* renamed from: a */
        AsyncResult<Session.AbstractC2369d> mo1215a(String str, String str2, String str3);

        /* renamed from: o */
        AsyncResult<Session.AbstractC2369d> mo1214o();
    }

    /* renamed from: a */
    String mo1248a();

    /* renamed from: b */
    String mo1247b();

    /* renamed from: c */
    String mo1246c();

    /* renamed from: d */
    List<InterfaceC2376c> mo1245d();

    /* renamed from: e */
    String mo1244e();

    InterfaceC2377d edit();

    /* renamed from: f */
    String mo1243f();

    /* renamed from: g */
    String mo1242g();

    /* renamed from: h */
    String mo1241h();

    /* renamed from: i */
    String mo1240i();

    /* renamed from: j */
    InterfaceC2373b mo1239j();

    /* renamed from: k */
    String mo1238k();

    /* renamed from: l */
    String mo1237l();

    /* renamed from: m */
    String mo1236m();
}
