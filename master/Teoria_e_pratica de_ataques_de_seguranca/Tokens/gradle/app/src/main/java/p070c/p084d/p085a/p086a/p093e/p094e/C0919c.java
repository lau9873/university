package p070c.p084d.p085a.p086a.p093e.p094e;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Collections;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0906a;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0981l2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC1016u1;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.BinderC0988n1;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0956f2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0960g2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0971j0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0979l0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1011t0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1004r1;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1088v0;
import p070c.p084d.p085a.p086a.p104j.AbstractC1237c;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.c */
/* loaded from: classes.dex */
public class C0919c<O extends C0905a.InterfaceC0906a> {

    /* renamed from: a */
    public final Context f5067a;

    /* renamed from: b */
    public final C0905a<O> f5068b;

    /* renamed from: c */
    public final O f5069c;

    /* renamed from: d */
    public final C0960g2<O> f5070d;

    /* renamed from: e */
    public final Looper f5071e;

    /* renamed from: f */
    public final int f5072f;

    /* renamed from: g */
    public final InterfaceC1004r1 f5073g;

    /* renamed from: h */
    public final C0971j0 f5074h;

    /* renamed from: c.d.a.a.e.e.c$a */
    /* loaded from: classes.dex */
    public static class C0920a {

        /* renamed from: a */
        public final InterfaceC1004r1 f5075a;

        /* renamed from: b */
        public final Looper f5076b;

        static {
            new C1038n().m5302a();
        }

        public C0920a(InterfaceC1004r1 interfaceC1004r1, Account account, Looper looper) {
            this.f5075a = interfaceC1004r1;
            this.f5076b = looper;
        }
    }

    public C0919c(Context context, C0905a<O> c0905a, Looper looper) {
        C1049c0.m5293a(context, "Null context is not permitted.");
        C1049c0.m5293a(c0905a, "Api must not be null.");
        C1049c0.m5293a(looper, "Looper must not be null.");
        this.f5067a = context.getApplicationContext();
        this.f5068b = c0905a;
        this.f5069c = null;
        this.f5071e = looper;
        this.f5070d = C0960g2.m5519a(c0905a);
        new C1011t0(this);
        this.f5074h = C0971j0.m5501a(this.f5067a);
        this.f5072f = this.f5074h.m5492b();
        this.f5073g = new C0956f2();
    }

    public C0919c(Context context, C0905a<O> c0905a, O o, C0920a c0920a) {
        C1049c0.m5293a(context, "Null context is not permitted.");
        C1049c0.m5293a(c0905a, "Api must not be null.");
        C1049c0.m5293a(c0920a, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f5067a = context.getApplicationContext();
        this.f5068b = c0905a;
        this.f5069c = o;
        this.f5071e = c0920a.f5076b;
        this.f5070d = C0960g2.m5518a(this.f5068b, this.f5069c);
        new C1011t0(this);
        this.f5074h = C0971j0.m5501a(this.f5067a);
        this.f5072f = this.f5074h.m5492b();
        this.f5073g = c0920a.f5075a;
        this.f5074h.m5499a((C0919c<?>) this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0919c(android.content.Context r2, p070c.p084d.p085a.p086a.p093e.p094e.C0905a<O> r3, O r4, p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1004r1 r5) {
        /*
            r1 = this;
            c.d.a.a.e.e.n r0 = new c.d.a.a.e.e.n
            r0.<init>()
            r0.m5301a(r5)
            c.d.a.a.e.e.c$a r5 = r0.m5302a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p085a.p086a.p093e.p094e.C0919c.<init>(android.content.Context, c.d.a.a.e.e.a, c.d.a.a.e.e.a$a, c.d.a.a.e.e.l.r1):void");
    }

    /* renamed from: a */
    public final int m5602a() {
        return this.f5072f;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [c.d.a.a.e.e.a$f] */
    /* renamed from: a */
    public C0905a.InterfaceC0916f mo5313a(Looper looper, C0979l0<O> c0979l0) {
        C1088v0 m5594e = m5594e();
        m5594e.m5169a(this.f5067a.getPackageName());
        m5594e.m5167b(this.f5067a.getClass().getName());
        return this.f5068b.m5620c().mo4987a(this.f5067a, looper, m5594e.m5171a(), this.f5069c, c0979l0, c0979l0);
    }

    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T m5601a(int i, T t) {
        t.m4353g();
        this.f5074h.m5498a(this, i, t);
        return t;
    }

    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T m5599a(T t) {
        m5601a(1, (int) t);
        return t;
    }

    /* renamed from: a */
    public BinderC0988n1 mo5314a(Context context, Handler handler) {
        return new BinderC0988n1(context, handler, m5594e().m5171a());
    }

    /* renamed from: a */
    public final <TResult, A extends C0905a.InterfaceC0913c> AbstractC1237c<TResult> m5600a(int i, AbstractC1016u1<A, TResult> abstractC1016u1) {
        C1238d<TResult> c1238d = new C1238d<>();
        this.f5074h.m5497a(this, i, abstractC1016u1, c1238d, this.f5073g);
        return c1238d.m4981a();
    }

    /* renamed from: a */
    public final <TResult, A extends C0905a.InterfaceC0913c> AbstractC1237c<TResult> m5598a(AbstractC1016u1<A, TResult> abstractC1016u1) {
        return m5600a(0, abstractC1016u1);
    }

    /* renamed from: b */
    public final Looper m5597b() {
        return this.f5071e;
    }

    /* renamed from: c */
    public final C0905a<O> m5596c() {
        return this.f5068b;
    }

    /* renamed from: d */
    public final C0960g2<O> m5595d() {
        return this.f5070d;
    }

    /* renamed from: e */
    public final C1088v0 m5594e() {
        Account m5618b;
        GoogleSignInAccount m5617a;
        GoogleSignInAccount m5617a2;
        C1088v0 c1088v0 = new C1088v0();
        O o = this.f5069c;
        if (!(o instanceof C0905a.InterfaceC0906a.InterfaceC0908b) || (m5617a2 = ((C0905a.InterfaceC0906a.InterfaceC0908b) o).m5617a()) == null) {
            O o2 = this.f5069c;
            m5618b = o2 instanceof C0905a.InterfaceC0906a.InterfaceC0907a ? ((C0905a.InterfaceC0906a.InterfaceC0907a) o2).m5618b() : null;
        } else {
            m5618b = m5617a2.m4388b();
        }
        c1088v0.m5170a(m5618b);
        O o3 = this.f5069c;
        c1088v0.m5168a((!(o3 instanceof C0905a.InterfaceC0906a.InterfaceC0908b) || (m5617a = ((C0905a.InterfaceC0906a.InterfaceC0908b) o3).m5617a()) == null) ? Collections.emptySet() : m5617a.m4379k());
        return c1088v0;
    }
}
