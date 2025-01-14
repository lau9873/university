package c.d.a.a.e.e;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.a.InterfaceC0057a;
import c.d.a.a.e.e.l.f2;
import c.d.a.a.e.e.l.g2;
import c.d.a.a.e.e.l.j0;
import c.d.a.a.e.e.l.l0;
import c.d.a.a.e.e.l.l2;
import c.d.a.a.e.e.l.n1;
import c.d.a.a.e.e.l.r1;
import c.d.a.a.e.e.l.t0;
import c.d.a.a.e.e.l.u1;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.v0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Collections;
/* loaded from: classes.dex */
public class c<O extends a.InterfaceC0057a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3227a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.a.a.e.e.a<O> f3228b;

    /* renamed from: c  reason: collision with root package name */
    public final O f3229c;

    /* renamed from: d  reason: collision with root package name */
    public final g2<O> f3230d;

    /* renamed from: e  reason: collision with root package name */
    public final Looper f3231e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3232f;

    /* renamed from: g  reason: collision with root package name */
    public final r1 f3233g;

    /* renamed from: h  reason: collision with root package name */
    public final j0 f3234h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final r1 f3235a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f3236b;

        static {
            new n().a();
        }

        public a(r1 r1Var, Account account, Looper looper) {
            this.f3235a = r1Var;
            this.f3236b = looper;
        }
    }

    public c(Context context, c.d.a.a.e.e.a<O> aVar, Looper looper) {
        c0.a(context, "Null context is not permitted.");
        c0.a(aVar, "Api must not be null.");
        c0.a(looper, "Looper must not be null.");
        this.f3227a = context.getApplicationContext();
        this.f3228b = aVar;
        this.f3229c = null;
        this.f3231e = looper;
        this.f3230d = g2.a(aVar);
        new t0(this);
        this.f3234h = j0.a(this.f3227a);
        this.f3232f = this.f3234h.b();
        this.f3233g = new f2();
    }

    public c(Context context, c.d.a.a.e.e.a<O> aVar, O o, a aVar2) {
        c0.a(context, "Null context is not permitted.");
        c0.a(aVar, "Api must not be null.");
        c0.a(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f3227a = context.getApplicationContext();
        this.f3228b = aVar;
        this.f3229c = o;
        this.f3231e = aVar2.f3236b;
        this.f3230d = g2.a(this.f3228b, this.f3229c);
        new t0(this);
        this.f3234h = j0.a(this.f3227a);
        this.f3232f = this.f3234h.b();
        this.f3233g = aVar2.f3235a;
        this.f3234h.a((c<?>) this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r2, c.d.a.a.e.e.a<O> r3, O r4, c.d.a.a.e.e.l.r1 r5) {
        /*
            r1 = this;
            c.d.a.a.e.e.n r0 = new c.d.a.a.e.e.n
            r0.<init>()
            r0.a(r5)
            c.d.a.a.e.e.c$a r5 = r0.a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.e.e.c.<init>(android.content.Context, c.d.a.a.e.e.a, c.d.a.a.e.e.a$a, c.d.a.a.e.e.l.r1):void");
    }

    public final int a() {
        return this.f3232f;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [c.d.a.a.e.e.a$f] */
    public a.f a(Looper looper, l0<O> l0Var) {
        v0 e2 = e();
        e2.a(this.f3227a.getPackageName());
        e2.b(this.f3227a.getClass().getName());
        return this.f3228b.c().a(this.f3227a, looper, e2.a(), this.f3229c, l0Var, l0Var);
    }

    public final <A extends a.c, T extends l2<? extends g, A>> T a(int i2, T t) {
        t.g();
        this.f3234h.a(this, i2, t);
        return t;
    }

    public final <A extends a.c, T extends l2<? extends g, A>> T a(T t) {
        a(1, (int) t);
        return t;
    }

    public n1 a(Context context, Handler handler) {
        return new n1(context, handler, e().a());
    }

    public final <TResult, A extends a.c> c.d.a.a.j.c<TResult> a(int i2, u1<A, TResult> u1Var) {
        c.d.a.a.j.d<TResult> dVar = new c.d.a.a.j.d<>();
        this.f3234h.a(this, i2, u1Var, dVar, this.f3233g);
        return dVar.a();
    }

    public final <TResult, A extends a.c> c.d.a.a.j.c<TResult> a(u1<A, TResult> u1Var) {
        return a(0, u1Var);
    }

    public final Looper b() {
        return this.f3231e;
    }

    public final c.d.a.a.e.e.a<O> c() {
        return this.f3228b;
    }

    public final g2<O> d() {
        return this.f3230d;
    }

    public final v0 e() {
        Account b2;
        GoogleSignInAccount a2;
        GoogleSignInAccount a3;
        v0 v0Var = new v0();
        O o = this.f3229c;
        if (!(o instanceof a.InterfaceC0057a.b) || (a3 = ((a.InterfaceC0057a.b) o).a()) == null) {
            O o2 = this.f3229c;
            b2 = o2 instanceof a.InterfaceC0057a.InterfaceC0058a ? ((a.InterfaceC0057a.InterfaceC0058a) o2).b() : null;
        } else {
            b2 = a3.b();
        }
        v0Var.a(b2);
        O o3 = this.f3229c;
        v0Var.a((!(o3 instanceof a.InterfaceC0057a.b) || (a2 = ((a.InterfaceC0057a.b) o3).a()) == null) ? Collections.emptySet() : a2.k());
        return v0Var;
    }
}
