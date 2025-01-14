package p205h.p208b.p209a.p210d;

import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.UserProfile;

/* renamed from: h.b.a.d.u */
/* loaded from: classes.dex */
public interface Session {

    /* compiled from: Session.java */
    /* renamed from: h.b.a.d.u$a */
    /* loaded from: classes.dex */
    public static class C2366a extends AbstractC2369d {

        /* renamed from: b */
        public final String f9705b;

        /* renamed from: c */
        public final String f9706c;

        public C2366a(boolean z, String str, String str2) {
            super(z);
            this.f9706c = str;
            this.f9705b = str2;
        }

        @Override // p205h.p208b.p209a.p210d.Session.AbstractC2369d
        /* renamed from: b */
        public String mo1269b() {
            return this.f9705b;
        }

        /* renamed from: d */
        public String m1273d() {
            return this.f9706c;
        }
    }

    /* compiled from: Session.java */
    /* renamed from: h.b.a.d.u$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2367b extends UserProfile.InterfaceC2372a {
        /* renamed from: n */
        AsyncResult<AbstractC2368c> mo1272n();

        /* renamed from: p */
        void mo1271p();
    }

    /* compiled from: Session.java */
    /* renamed from: h.b.a.d.u$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2368c extends AbstractC2369d {
        public AbstractC2368c(boolean z) {
            super(z);
        }
    }

    /* compiled from: Session.java */
    /* renamed from: h.b.a.d.u$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2369d {

        /* renamed from: a */
        public boolean f9707a;

        public AbstractC2369d(boolean z) {
            this.f9707a = z;
        }

        /* renamed from: a */
        public String mo1270a() {
            return null;
        }

        /* renamed from: b */
        public String mo1269b() {
            return null;
        }

        /* renamed from: c */
        public boolean m1268c() {
            return this.f9707a;
        }
    }

    /* compiled from: Session.java */
    /* renamed from: h.b.a.d.u$e */
    /* loaded from: classes.dex */
    public interface InterfaceC2370e {
        /* renamed from: a */
        void mo943a(User user);
    }

    /* renamed from: a */
    AsyncResult.AbstractC2280b<Billing> mo1283a(long j, long j2);

    /* renamed from: a */
    AsyncResult<C2366a> mo1279a(String str, String str2);

    /* renamed from: a */
    void mo1282a(RemoteUserListener remoteUserListener);

    /* renamed from: a */
    void mo1281a(InterfaceC2370e interfaceC2370e);

    /* renamed from: a */
    void mo1280a(Runnable runnable);

    /* renamed from: a */
    boolean mo1284a();

    /* renamed from: b */
    User mo1278b();

    /* renamed from: b */
    void mo1277b(InterfaceC2370e interfaceC2370e);

    /* renamed from: c */
    void mo1276c();

    /* renamed from: d */
    History mo1275d();

    /* renamed from: e */
    InterfaceC2367b mo1274e();
}
