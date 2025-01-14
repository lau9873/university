package h.b.a.e.d;

import a.b.h.a.c;
import android.animation.Animator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import h.b.a.d.b;
import h.b.a.d.f;
import h.b.a.d.o;
import h.b.a.e.d.g4;
import h.b.a.e.d.n3;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.activity.MainActivity;
/* compiled from: TripFragment.java */
/* loaded from: classes.dex */
public class g4 extends h3 implements SwipeRefreshLayout.j, o.c, h.b.a.d.n, h.b.a.d.f {
    public static Runnable w0;
    public h.b.a.c d0;
    public View e0;
    public RecyclerView f0;
    public RecyclerView g0;
    public n h0;
    public l i0;
    public i j0;
    public SwipeRefreshLayout k0;
    public Snackbar o0;
    public h.b.a.e.c.d t0;
    public h.b.a.e.c.d u0;
    public h.b.a.e.c.d v0;
    public int l0 = 0;
    public h.b.a.d.v m0 = null;
    public boolean n0 = false;
    public int p0 = 0;
    public final Runnable q0 = new a();
    public Runnable r0 = new c();
    public boolean s0 = false;

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g4.w0 != this) {
                return;
            }
            Runnable unused = g4.w0 = null;
            g4.this.d0.g();
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // android.support.v7.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2, int i3) {
            if (g4.this.d0.A()) {
                return;
            }
            g4.this.l0 += i3;
            if (g4.this.l0 < 0) {
                g4.this.l0 = 0;
            }
            g4 g4Var = g4.this;
            g4Var.d(g4Var.l0);
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* compiled from: TripFragment.java */
        /* loaded from: classes.dex */
        public class a extends Snackbar.b {
            public a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.design.widget.BaseTransientBottomBar.l
            public void a(Snackbar snackbar, int i2) {
                super.a(snackbar, i2);
                g4.this.s0().a(snackbar, i2);
                g4.this.o0 = null;
            }
        }

        public c() {
        }

        public /* synthetic */ void a(Snackbar snackbar) {
            g4.this.s0().a(snackbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g4.this.d0.A()) {
                return;
            }
            final Snackbar a2 = g4.this.d0.a(g4.this.b0.getString(2131755363), -2);
            g4.this.o0 = a2;
            a2.f(-12532481);
            a2.a(new a());
            a2.m();
            g4.this.e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.z1
                @Override // java.lang.Runnable
                public final void run() {
                    g4.c.this.a(a2);
                }
            }, 60L);
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public static class d implements Comparable<d>, Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        public final int f7168a;

        /* renamed from: b  reason: collision with root package name */
        public final f f7169b;

        /* renamed from: c  reason: collision with root package name */
        public final RecyclerView.d0 f7170c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f7171d;

        public d(f fVar, RecyclerView.d0 d0Var) {
            this.f7169b = fVar;
            this.f7170c = d0Var;
            View view = d0Var.f2580a;
            view.setScaleY(1.0f);
            this.f7168a = view.getTop();
        }

        public void a(Runnable runnable) {
            this.f7171d = runnable;
        }

        public ViewPropertyAnimator b() {
            return this.f7170c.f2580a.animate().setListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7169b.h(this.f7170c);
            Runnable runnable = this.f7171d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f7169b.i(this.f7170c);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.f7168a - dVar.f7168a;
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public static class e extends d {
        public e(f fVar, RecyclerView.d0 d0Var) {
            super(fVar, d0Var);
        }

        @Override // h.b.a.e.d.g4.d, java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return dVar.f7168a - this.f7168a;
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class h extends RecyclerView.d0 implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        public final TextView u;
        public final TextView v;
        public final ImageView w;
        public final h.b.a.e.c.c x;
        public h.b.a.d.m y;

        public h(View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131230971);
            this.v = (TextView) view.findViewById(2131230942);
            TextView textView = this.v;
            h.b.a.e.c.c cVar = new h.b.a.e.c.c();
            this.x = cVar;
            textView.setBackground(cVar);
            this.w = (ImageView) view.findViewById(2131231178);
            ((ViewGroup) view).getChildAt(0).setOnClickListener(this);
        }

        public void a(g gVar) {
            this.u.setText(gVar.f7179e);
            this.v.setText(gVar.f7178d);
            if (gVar.f7178d == null) {
                this.x.a(null, null);
            } else {
                this.x.a(gVar.f7176b);
            }
            this.w.setImageResource(gVar.f7177c);
            this.y = gVar.f7175a;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            g4.this.a(z, this.y);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f7182a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f7183b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f7184c;

        /* renamed from: d  reason: collision with root package name */
        public final h.b.a.e.c.c f7185d;

        /* renamed from: e  reason: collision with root package name */
        public h.b.a.d.m f7186e;

        public k(View view, h.b.a.d.m mVar, h.b.a.d.k kVar) {
            ViewGroup viewGroup = (ViewGroup) view;
            view.setOnClickListener(this);
            this.f7182a = (TextView) viewGroup.getChildAt(0);
            this.f7183b = (TextView) viewGroup.getChildAt(1);
            this.f7184c = (ImageView) viewGroup.getChildAt(2);
            TextView textView = this.f7182a;
            h.b.a.e.c.c cVar = new h.b.a.e.c.c();
            this.f7185d = cVar;
            textView.setBackground(cVar);
            a(mVar, kVar);
        }

        public void a(h.b.a.d.m mVar, h.b.a.d.k kVar) {
            this.f7186e = mVar;
            h.b.a.d.p b2 = kVar.b();
            if (b2 != null) {
                this.f7184c.setImageResource(b2.c());
                this.f7184c.setContentDescription(b2.a());
            } else {
                this.f7184c.setImageDrawable(null);
                this.f7184c.setContentDescription(null);
            }
            this.f7184c.setVisibility(0);
            this.f7185d.a(kVar);
            this.f7182a.setText(kVar.c());
            this.f7183b.setText(kVar.e());
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g4.this.m0 = this.f7186e.d();
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class m extends o {
        public final ImageView A;
        public final h.b.a.e.c.c B;
        public final TextView z;

        public m(View view) {
            super(view);
            h.b.a.e.c.d dVar;
            this.z = (TextView) view.findViewById(2131230942);
            TextView textView = this.z;
            h.b.a.e.c.c cVar = new h.b.a.e.c.c();
            this.B = cVar;
            textView.setBackground(cVar);
            this.A = (ImageView) view.findViewById(2131230981);
            View view2 = this.u;
            if (g4.this.u0 != null) {
                dVar = g4.this.u0;
            } else {
                dVar = new h.b.a.e.c.d(g4.this.B(), true, false);
                g4.this.u0 = dVar;
            }
            view2.setBackground(dVar);
        }

        @Override // h.b.a.e.d.g4.o
        public void a(h.b.a.d.q qVar) {
            g4.this.u0.a(h() + 1 < g4.this.i0.a());
            h.b.a.d.v d2 = qVar.d();
            this.v.setText(d2.a());
            h.b.a.d.a0 e2 = d2.e();
            if (e2 == null) {
                c.b.a.a.a((Throwable) new InvalidParameterException("Zone was null"));
            } else {
                this.x.setText(e2.a());
            }
            TextView textView = this.w;
            Context context = g4.this.b0;
            textView.setText(context.getString(2131755362, DateFormat.getTimeFormat(context).format(Long.valueOf(qVar.a()))));
            h.b.a.d.w b2 = g4.this.d0.m().b();
            h.b.a.d.p b3 = b2.b();
            if (b3 != null) {
                this.A.setImageResource(b3.c());
                this.A.setContentDescription(b3.a());
            }
            h.b.a.d.k h2 = b2.h();
            if (h2 != null && h2.c().length() != 0) {
                this.B.a(h2);
                this.z.setText(h2.c());
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class n extends RecyclerView.g<j> implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        public final List<h.b.a.d.m> f7190c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7191d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7192e = false;

        /* renamed from: f  reason: collision with root package name */
        public Snackbar f7193f;

        /* compiled from: TripFragment.java */
        /* loaded from: classes.dex */
        public class a extends Snackbar.b {
            public a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.design.widget.BaseTransientBottomBar.l
            public void a(Snackbar snackbar, int i2) {
                super.a(snackbar, i2);
                g4.this.s0().a(snackbar, i2);
                n.this.f7193f = null;
            }
        }

        public n() {
            this.f7190c = g4.this.d0.A() ? new ArrayList() : new ArrayList(g4.this.d0.l());
            f();
        }

        public static /* synthetic */ void a(View view) {
        }

        public void c(h.b.a.d.m mVar) {
            int b2;
            if (this.f7191d || (b2 = g4.b(this.f7190c, mVar)) == -1) {
                return;
            }
            d(b2);
        }

        public boolean e() {
            return false;
        }

        public final void f() {
            if (g4.this.d0.A() || !this.f7190c.isEmpty() || this.f7192e) {
                return;
            }
            this.f7192e = true;
            g4.this.e0.postDelayed(this, 100L);
        }

        public void g() {
            k();
            int size = this.f7190c.size();
            if (size > 0) {
                this.f7190c.clear();
                c(0, size);
            }
            f();
        }

        public void h() {
            g4.this.e0.removeCallbacks(this);
            this.f7192e = false;
        }

        public void i() {
            int size = this.f7190c.size();
            this.f7190c.clear();
            c(0, size);
        }

        public void j() {
            if (this.f7193f == null) {
                final Snackbar a2 = g4.this.d0.a(g4.this.b0.getString(2131755361), -2);
                this.f7193f = a2;
                a2.a(17039370, q2.f7310a);
                a2.f(-12532481);
                a2.a(new a());
                a2.m();
                g4.this.e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.r2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g4.n.this.a(a2);
                    }
                }, 60L);
            }
        }

        public void k() {
            g4.this.k0.setRefreshing(this.f7190c.size() == 0);
        }

        public void l() {
            int a2 = a();
            this.f7191d = true;
            this.f7190c.clear();
            if (g4.this.n0 || a2 == 0) {
                g4.this.n0 = false;
                g4.this.k0.setVisibility(8);
                return;
            }
            c(0, a2);
        }

        public void m() {
            this.f7191d = false;
            k();
            b(0, a());
            f();
        }

        public final void n() {
            g4.this.k0.setRefreshing(false);
            boolean A = g4.this.d0.A();
            if (this.f7190c.size() > 0 || A) {
                g4.this.v0();
            } else {
                g4 g4Var = g4.this;
                if (g4Var.Z != null) {
                    g4Var.H0();
                }
            }
            g4.this.S0();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7190c.size() == 0 && !this.f7191d) {
                g4 g4Var = g4.this;
                if (g4Var.b0 != null) {
                    g4Var.k0.setRefreshing(false);
                    if (g4.this.d0 != null) {
                        g4.this.d0.c();
                    }
                    g4 g4Var2 = g4.this;
                    if (g4Var2.Z != null) {
                        g4Var2.H0();
                    }
                }
            }
            this.f7192e = false;
        }

        public void a(h.b.a.d.m mVar) {
            if (this.f7191d) {
                return;
            }
            int size = this.f7190c.size();
            this.f7190c.add(mVar);
            e(size);
            n();
        }

        public void b(h.b.a.d.m mVar) {
            int b2 = g4.b(this.f7190c, mVar);
            if (b2 == -1) {
                return;
            }
            this.f7190c.remove(b2);
            f(b2);
            n();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(j jVar, int i2) {
            jVar.a(this.f7190c.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public j b(ViewGroup viewGroup, int i2) {
            return new j(LayoutInflater.from(g4.this.b0).inflate(2131427411, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            List<h.b.a.d.m> list = this.f7190c;
            if (list == null || this.f7191d) {
                return 0;
            }
            return list.size();
        }

        public /* synthetic */ void a(Snackbar snackbar) {
            g4.this.s0().a(snackbar);
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class o extends RecyclerView.d0 {
        public final View u;
        public final TextView v;
        public final TextView w;
        public final TextView x;

        public o(View view) {
            super(view);
            this.u = view.findViewById(2131230914);
            this.v = (TextView) view.findViewById(2131231092);
            this.w = (TextView) view.findViewById(2131231148);
            this.x = (TextView) view.findViewById(2131231189);
        }

        public void a(h.b.a.d.q qVar) {
            h.b.a.e.c.d dVar;
            h.b.a.e.c.d dVar2;
            if (h() + 1 == g4.this.i0.a()) {
                View view = this.u;
                if (g4.this.v0 != null) {
                    dVar2 = g4.this.v0;
                } else {
                    g4 g4Var = g4.this;
                    dVar2 = new h.b.a.e.c.d(g4Var.B(), false, false);
                    g4Var.v0 = dVar2;
                }
                view.setBackground(dVar2);
            } else {
                View view2 = this.u;
                if (g4.this.t0 != null) {
                    dVar = g4.this.t0;
                } else {
                    g4 g4Var2 = g4.this;
                    dVar = new h.b.a.e.c.d(g4Var2.B(), false, true);
                    g4Var2.t0 = dVar;
                }
                view2.setBackground(dVar);
            }
            h.b.a.d.v d2 = qVar.d();
            this.v.setText(d2.a());
            this.x.setText(d2.e().a());
            this.w.setText(g4.this.o0().format(Long.valueOf(qVar.a())));
        }
    }

    public final boolean A(final View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.z2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.q(view);
            }
        });
        return true;
    }

    public final void A0() {
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = null;
            Intent[] a2 = h.b.a.c.b(this.b0).a(this.b0);
            int length = a2.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Intent intent2 = a2[i2];
                if (this.b0.getPackageManager().resolveActivity(intent2, 65536) != null) {
                    intent = intent2;
                    break;
                }
                i2++;
            }
            if (intent != null) {
                this.b0.startActivity(intent);
                return;
            }
            try {
                this.b0.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                return;
            } catch (ActivityNotFoundException unused) {
                BackEnd.addToLog("openBatteryOptimizationSettings: thrown ActivityNotFoundException, opening Settings.ACTION_SETTINGS");
                this.b0.startActivity(new Intent("android.settings.SETTINGS"));
                return;
            }
        }
        BackEnd.addToLog(String.format(Locale.getDefault(), "openBatteryOptimizationSettings: SDK_INT %d does not support Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS", Integer.valueOf(Build.VERSION.SDK_INT)));
    }

    public final boolean B(final View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.n2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.r(view);
            }
        });
        return true;
    }

    public final void B0() {
        if (this.p0 == 0) {
            if (Build.VERSION.SDK_INT >= 29) {
                a(new String[]{"android.permission.ACTIVITY_RECOGNITION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE"}, 2);
            } else {
                a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE"}, 2);
            }
        } else {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", this.b0.getPackageName(), null));
            a(intent);
        }
        this.p0++;
    }

    public final void C0() {
        v0();
        ((TextView) this.e0.findViewById(2131230877)).setText(2131755364);
        ((TextView) this.e0.findViewById(2131230876)).setText(2131755365);
        this.e0.findViewById(2131230875).setOnClickListener(null);
    }

    public final boolean D0() {
        return s(this.e0.findViewById(2131230875));
    }

    public final boolean E0() {
        return t(this.e0.findViewById(2131230875));
    }

    public final boolean F0() {
        return u(this.e0.findViewById(2131230875));
    }

    public final boolean G0() {
        return c(this.e0.findViewById(2131230875), 2131755207, 2131755208);
    }

    public void H0() {
        if (this.d0.A()) {
            return;
        }
        final View findViewById = this.e0.findViewById(2131230875);
        f.a j2 = this.d0.j();
        if (u0()) {
            b(findViewById, 2131755227, 2131755228);
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.b0 != null && ((!a.b.g.a.a.a((Activity) this.Z, "android.permission.ACTIVITY_RECOGNITION") || !a.b.g.a.a.a((Activity) this.Z, "android.permission.ACCESS_FINE_LOCATION") || !a.b.g.a.a.a((Activity) this.Z, "android.permission.READ_PHONE_STATE")) && this.p0 == 0)) {
                    B0();
                }
            } else if (this.b0 != null && ((!a.b.g.a.a.a((Activity) this.Z, "android.permission.ACCESS_FINE_LOCATION") || !a.b.g.a.a.a((Activity) this.Z, "android.permission.READ_PHONE_STATE")) && this.p0 == 0)) {
                B0();
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.s2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g4.this.k(view);
                }
            });
        } else if (!h.b.a.c.X().q()) {
            b(findViewById, 2131755200, 2131755201);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.y1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g4.this.j(view);
                }
            });
        } else if (!this.d0.r()) {
            u(findViewById);
        } else if (!this.d0.y()) {
            y(findViewById);
        } else if (!this.d0.z()) {
            z(findViewById);
        } else if (!this.d0.B()) {
            if (this.d0.x()) {
                b(findViewById, 2131755236, 2131755237);
            } else {
                b(findViewById, 2131755215, 2131755216);
            }
            findViewById.setOnClickListener(null);
        } else if (this.d0.p()) {
            b(findViewById, 2131755215, 2131755216);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.c3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g4.this.a(findViewById, view);
                }
            });
        } else if (this.d0.v()) {
            b(findViewById, 2131755120, 2131755121);
            findViewById.setOnClickListener(null);
        } else if (j2 != null) {
            a(j2);
        } else {
            b(findViewById, 2131755364, 2131755365);
            findViewById.setOnClickListener(null);
        }
    }

    public final boolean I0() {
        return c(this.e0.findViewById(2131230875), 2131755209, 2131755210);
    }

    public final boolean J0() {
        return c(this.e0.findViewById(2131230875), 2131755212, 2131755211);
    }

    public final boolean K0() {
        return v(this.e0.findViewById(2131230875));
    }

    public final boolean L0() {
        return w(this.e0.findViewById(2131230875));
    }

    public final boolean M0() {
        return x(this.e0.findViewById(2131230875));
    }

    public final boolean N0() {
        return y(this.e0.findViewById(2131230875));
    }

    public final boolean O0() {
        return z(this.e0.findViewById(2131230875));
    }

    public final boolean P0() {
        return A(this.e0.findViewById(2131230875));
    }

    public final boolean Q0() {
        return B(this.e0.findViewById(2131230875));
    }

    public final void R0() {
        this.l0 = 0;
        l lVar = this.i0;
        if (lVar != null) {
            lVar.e();
        }
        this.h0.m();
        this.j0.g();
        S0();
        this.k0.setVisibility(0);
        this.k0.setEnabled(true);
        Snackbar snackbar = this.o0;
        if (snackbar != null) {
            snackbar.b();
        }
    }

    public final void S0() {
        n3.h s0 = s0();
        if (this.d0.A()) {
            if (this.d0.m().b().l() > 1) {
                s0.b();
                return;
            } else {
                s0.a(2131755351, 2131165571, -3790808, false);
                return;
            }
        }
        s0.b();
    }

    @Override // android.support.v4.app.Fragment
    public void U() {
        this.d0.b((o.c) this);
        this.d0.b((h.b.a.d.n) this);
        this.d0.b((h.b.a.d.f) this);
        super.U();
    }

    @Override // android.support.v4.app.Fragment
    public void Z() {
        super.Z();
        w0 = null;
        Log.d("Anda:GUI:TripFragment", "Resuming fragment and leaving power saving mode...");
        S0();
        this.h0.g();
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.c.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void b(h.b.a.d.o oVar) {
    }

    @Override // android.support.v4.app.Fragment
    public void b0() {
        super.b0();
        Runnable runnable = this.q0;
        w0 = runnable;
        this.e0.postDelayed(runnable, 20000L);
    }

    @Override // h.b.a.d.o.c
    public void c(h.b.a.d.o oVar) {
    }

    public /* synthetic */ void m(View view) {
        b(view, 2131755200, 2131755201);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g4.this.f(view2);
            }
        });
    }

    public /* synthetic */ void n(View view) {
        b(view, 2131755217, 2131755218);
        view.setOnClickListener(null);
    }

    public /* synthetic */ void o(View view) {
        a.b.g.a.g j2 = j();
        if (j2 == null || !(j2 instanceof MainActivity)) {
            return;
        }
        ((MainActivity) j2).r();
    }

    public /* synthetic */ void p(View view) {
        a.b.g.a.g j2 = j();
        if (j2 == null || !(j2 instanceof MainActivity)) {
            return;
        }
        ((MainActivity) j2).s();
    }

    @Override // h.b.a.e.d.h3
    public void p0() {
        c((View) this.k0);
        c((View) this.g0);
        ViewGroup.LayoutParams layoutParams = this.f0.getLayoutParams();
        layoutParams.height = q0();
        this.f0.setLayoutParams(layoutParams);
        n nVar = this.h0;
        d((nVar == null || nVar.a() == 0) ? 0 : this.l0);
    }

    public /* synthetic */ void q(View view) {
        b(view, 2131755225, 2131755226);
        view.setOnClickListener(null);
    }

    public /* synthetic */ void r(View view) {
        b(view, 2131755223, 2131755224);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g4.this.e(view2);
            }
        });
    }

    public final boolean s(final View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.o2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.g(view);
            }
        });
        return true;
    }

    public final boolean t(final View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.g2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.h(view);
            }
        });
        return true;
    }

    public void t0() {
        c.a aVar = new c.a(this.b0);
        aVar.b(2131755351);
        aVar.a(2131755352);
        aVar.b(2131755424, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.e2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                g4.this.a(dialogInterface, i2);
            }
        });
        aVar.a(2131755283, (DialogInterface.OnClickListener) null);
        aVar.c();
    }

    public final boolean u(View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        b(view, 2131755202, 2131755203);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g4.this.i(view2);
            }
        });
        return true;
    }

    public final boolean u0() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return (a.b.g.b.b.a(this.b0, "android.permission.ACTIVITY_RECOGNITION") == 0 && a.b.g.b.b.a(this.b0, "android.permission.ACCESS_FINE_LOCATION") == 0 && a.b.g.b.b.a(this.b0, "android.permission.READ_PHONE_STATE") == 0) ? false : true;
        } else if (i2 >= 23) {
            return (a.b.g.b.b.a(this.b0, "android.permission.ACCESS_FINE_LOCATION") == 0 && a.b.g.b.b.a(this.b0, "android.permission.READ_PHONE_STATE") == 0) ? false : true;
        } else {
            return false;
        }
    }

    public final boolean v(final View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        if (this.d0.r() && this.d0.y() && this.d0.z()) {
            this.e0.post(new Runnable() { // from class: h.b.a.e.d.t2
                @Override // java.lang.Runnable
                public final void run() {
                    g4.this.l(view);
                }
            });
            return true;
        }
        return true;
    }

    public final void v0() {
        this.e0.findViewById(2131230875).setVisibility(8);
        this.e0.findViewById(2131230807).setVisibility(8);
    }

    public final boolean w(final View view) {
        if (!c(view, 2131755206, 2131755211) && !this.d0.q()) {
            this.e0.post(new Runnable() { // from class: h.b.a.e.d.y2
                @Override // java.lang.Runnable
                public final void run() {
                    g4.this.m(view);
                }
            });
        }
        return true;
    }

    public /* synthetic */ void w0() {
        this.h0.i();
    }

    public final boolean x(final View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.c2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.n(view);
            }
        });
        return true;
    }

    public /* synthetic */ void x0() {
        C0();
        n nVar = this.h0;
        if (nVar != null) {
            nVar.n();
        }
    }

    public final boolean y(View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        b(view, 2131755219, 2131755220);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g4.this.o(view2);
            }
        });
        return true;
    }

    public /* synthetic */ void y0() {
        C0();
        n nVar = this.h0;
        if (nVar != null) {
            nVar.n();
        }
    }

    public final boolean z(View view) {
        if (this.d0.A() || this.d0.C()) {
            return false;
        }
        b(view, 2131755221, 2131755222);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g4.this.p(view2);
            }
        });
        return true;
    }

    public final void z0() {
        S0();
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class f extends RecyclerView.l {

        /* renamed from: g  reason: collision with root package name */
        public final RecyclerView f7172g;

        /* renamed from: h  reason: collision with root package name */
        public final SwipeRefreshLayout f7173h;
        public int l = 0;

        /* renamed from: i  reason: collision with root package name */
        public List<d> f7174i = new ArrayList();
        public List<d> j = new ArrayList();
        public List<d> k = new ArrayList();

        public f(RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
            this.f7172g = recyclerView;
            this.f7173h = swipeRefreshLayout;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
            View view = d0Var.f2580a;
            boolean A = g4.this.d0.A();
            if (Build.VERSION.SDK_INT >= 21) {
                view.setAlpha(0.0f);
            }
            view.setTranslationX(0.0f);
            view.setTranslationY(A ? (-this.f7172g.getHeight()) / 32 : this.f7172g.getHeight() / 8);
            this.f7174i.add(new d(this, d0Var));
            return true;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public void b() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public boolean b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
            this.j.add(g4.this.d0.A() ? new d(this, d0Var) : new e(this, d0Var));
            return true;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
            d0Var.f2580a.setTranslationY(cVar.f2600b - cVar2.f2600b);
            this.k.add(new e(this, d0Var));
            return true;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public void d(RecyclerView.d0 d0Var) {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public boolean g() {
            return this.l > 0;
        }

        public void h(RecyclerView.d0 d0Var) {
            this.l--;
            b(d0Var);
        }

        public void i(RecyclerView.d0 d0Var) {
            this.l++;
            c(d0Var);
        }

        public /* synthetic */ void j() {
            this.f7173h.setVisibility(8);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public void i() {
            boolean A = g4.this.d0.A();
            int height = this.f7172g.getHeight();
            int i2 = A ? (-height) / 16 : height / 2;
            a.b.g.k.f0.b bVar = h.b.a.e.b.b.f7085a;
            List<d> list = this.j;
            Collections.sort(list);
            int size = list.size();
            a.b.g.k.f0.a aVar = size == 0 ? null : new a.b.g.k.f0.a();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPropertyAnimator b2 = list.get(i3).b();
                if (A) {
                    b2.translationY(i2).setDuration(240L);
                } else {
                    b2.translationX(i2).setDuration(180L);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    b2.alpha(0.0f);
                }
                b2.setInterpolator(aVar).setStartDelay(i3 * 30);
                if (A) {
                    b2.scaleY(0.8f);
                }
                b2.start();
            }
            if (A && size > 0) {
                list.get(size - 1).a(new Runnable() { // from class: h.b.a.e.d.p2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g4.f.this.j();
                    }
                });
            }
            list.clear();
            List<d> list2 = this.f7174i;
            Collections.sort(list2);
            int i4 = size * 80;
            int size2 = list2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ViewPropertyAnimator b3 = list2.get(i5).b();
                if (Build.VERSION.SDK_INT >= 21) {
                    b3.alpha(1.0f);
                }
                b3.translationY(0.0f).setDuration(A ? 140L : 280L).setInterpolator(bVar).setStartDelay((i5 * 50) + i4).start();
            }
            list2.clear();
            List<d> list3 = this.k;
            Collections.sort(list3);
            int size3 = list3.size();
            for (int i6 = 0; i6 < size3; i6++) {
                list3.get(i6).b().translationY(0.0f).scaleY(1.0f).setInterpolator(bVar).setStartDelay(i6 * 45).start();
            }
            list3.clear();
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class i extends RecyclerView.g<h> implements b.a<List<h.b.a.d.m>> {

        /* renamed from: c  reason: collision with root package name */
        public List<g> f7180c;

        public i() {
            this.f7180c = new ArrayList();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h hVar) {
            int width = g4.this.f0.getWidth();
            hVar.f2580a.setMinimumWidth((int) ((width / 2) - (width * 0.2f)));
            hVar.f2580a.setMinimumWidth(g4.this.s0().a() * 2);
            super.b((i) hVar);
        }

        public void c(h.b.a.d.m mVar) {
            int i2 = 0;
            while (i2 < this.f7180c.size()) {
                if (this.f7180c.get(i2).f7175a == mVar) {
                    this.f7180c.remove(i2);
                    f(i2);
                    i2--;
                }
                i2++;
            }
        }

        public void d(h.b.a.d.m mVar) {
            boolean z;
            boolean z2;
            List<h.b.a.d.k> g2 = mVar.g();
            int i2 = 0;
            while (i2 < this.f7180c.size()) {
                g gVar = this.f7180c.get(i2);
                if (gVar.f7175a == mVar) {
                    Iterator<h.b.a.d.k> it = g2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (gVar.f7176b == it.next()) {
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        this.f7180c.remove(i2);
                        f(i2);
                        i2--;
                    }
                }
                i2++;
            }
            for (h.b.a.d.k kVar : g2) {
                Iterator<g> it2 = this.f7180c.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().f7176b == kVar) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    int a2 = a(kVar);
                    this.f7180c.add(0, new g(mVar, kVar, a2, kVar.c(), a2 == 2131165574 ? kVar.e() : mVar.d().a()));
                    e(0);
                }
            }
        }

        public void e() {
            int size = this.f7180c.size();
            if (size > 0) {
                this.f7180c.clear();
                c(0, size);
            }
        }

        public void f() {
            a(g4.this.d0.l());
        }

        public void g() {
            e();
        }

        public /* synthetic */ i(g4 g4Var, a aVar) {
            this();
        }

        public final int b(h.b.a.d.m mVar) {
            return mVar.b().c();
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<List<h.b.a.d.m>> bVar) {
            if (g4.this.d0.A()) {
                a(bVar.a());
            }
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public h b(ViewGroup viewGroup, int i2) {
            g4 g4Var = g4.this;
            return new h(LayoutInflater.from(g4Var.b0).inflate(2131427405, viewGroup, false));
        }

        public void a(List<h.b.a.d.m> list) {
            e();
            for (h.b.a.d.m mVar : list) {
                a(mVar, false);
            }
        }

        public final void a(h.b.a.d.m mVar, boolean z) {
            List<h.b.a.d.k> g2 = mVar.g();
            if (g2 != null && mVar.f()) {
                for (h.b.a.d.k kVar : g2) {
                    g gVar = new g(mVar, kVar, a(kVar), kVar.c(), kVar.e());
                    if (z) {
                        this.f7180c.add(0, gVar);
                        e(0);
                    } else {
                        this.f7180c.add(gVar);
                        e(this.f7180c.size() - 1);
                    }
                }
                return;
            }
            g gVar2 = new g(mVar, b(mVar), null, mVar.d().a());
            if (z) {
                this.f7180c.add(0, gVar2);
                e(0);
                return;
            }
            this.f7180c.add(gVar2);
            e(this.f7180c.size() - 1);
        }

        public final int a(h.b.a.d.k kVar) {
            return kVar.b().c();
        }

        public void a(h.b.a.d.m mVar) {
            a(mVar, true);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h hVar, int i2) {
            hVar.a(this.f7180c.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            return this.f7180c.size();
        }
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class l extends RecyclerView.g<o> {

        /* renamed from: c  reason: collision with root package name */
        public final List<h.b.a.d.q> f7188c;

        public l() {
            this.f7188c = new ArrayList();
        }

        public void a(h.b.a.d.w wVar) {
            int size = this.f7188c.size();
            this.f7188c.clear();
            c(0, size);
            int l = wVar.l();
            for (int i2 = 0; i2 < l; i2++) {
                this.f7188c.add(wVar.a(i2));
            }
            b(0, l);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int c(int i2) {
            return i2 == 0 ? 0 : 1;
        }

        public void e() {
            int size = this.f7188c.size();
            this.f7188c.clear();
            c(0, size);
        }

        public void f() {
            int size = this.f7188c.size();
            this.f7188c.clear();
            c(0, size);
        }

        public /* synthetic */ l(g4 g4Var, a aVar) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public o b(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new o(LayoutInflater.from(g4.this.b0).inflate(2131427412, viewGroup, false));
            }
            return new m(LayoutInflater.from(g4.this.b0).inflate(2131427413, viewGroup, false));
        }

        public void a(h.b.a.d.q qVar) {
            int size = this.f7188c.size();
            this.f7188c.add(qVar);
            d(size - 1);
            e(size);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(o oVar, int i2) {
            oVar.a(this.f7188c.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            return this.f7188c.size();
        }
    }

    @Override // h.b.a.d.o.c
    public void d(h.b.a.d.o oVar) {
        S0();
        e(this.d0.m());
        n nVar = this.h0;
        if (nVar != null) {
            nVar.l();
        }
        Snackbar snackbar = this.o0;
        if (snackbar != null) {
            snackbar.b();
        }
    }

    public final void e(h.b.a.d.o oVar) {
        this.i0.a(oVar.b());
        n nVar = this.h0;
        if (nVar != null) {
            if (nVar.e()) {
                this.j0.a(this.h0.f7190c);
            } else {
                this.j0.f();
                this.k0.setVisibility(8);
            }
        }
        v0();
        d(0);
        this.k0.setEnabled(false);
    }

    public /* synthetic */ void f(h.b.a.d.m mVar) {
        if (this.m0 == mVar.d()) {
            S0();
        }
        if (this.d0.A()) {
            this.j0.c(mVar);
        } else {
            this.h0.b(mVar);
        }
    }

    public /* synthetic */ void g(View view) {
        b(view, 2131755196, 2131755197);
        view.setOnClickListener(null);
    }

    public /* synthetic */ void h(View view) {
        b(view, 2131755198, 2131755199);
        view.setOnClickListener(null);
    }

    public /* synthetic */ void i(View view) {
        a.b.g.a.g j2 = j();
        if (j2 == null || !(j2 instanceof MainActivity)) {
            return;
        }
        ((MainActivity) j2).q();
    }

    public /* synthetic */ void j(View view) {
        A0();
    }

    public /* synthetic */ void k(View view) {
        B0();
    }

    public /* synthetic */ void l(View view) {
        b(view, 2131755206, 2131755213);
    }

    @Override // h.b.a.e.d.h3
    public void b(View view) {
        if (this.d0.A()) {
            if (this.m0 == null) {
                t0();
                return;
            }
            c.a aVar = new c.a(this.b0);
            aVar.b(2131755353);
            aVar.a(2131755354);
            aVar.b(2131755424, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.b3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    g4.this.b(dialogInterface, i2);
                }
            });
            aVar.a(2131755283, (DialogInterface.OnClickListener) null);
            aVar.c();
        } else if (this.m0 == null) {
            this.h0.j();
        }
    }

    @Override // h.b.a.e.d.h3, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        w0 = null;
        this.d0 = h.b.a.c.b(this.b0);
        this.d0.a((o.c) this);
        this.d0.a((h.b.a.d.n) this);
        this.d0.a((h.b.a.d.f) this);
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public h.b.a.d.m f7175a;

        /* renamed from: b  reason: collision with root package name */
        public h.b.a.d.k f7176b;

        /* renamed from: c  reason: collision with root package name */
        public int f7177c;

        /* renamed from: d  reason: collision with root package name */
        public String f7178d;

        /* renamed from: e  reason: collision with root package name */
        public String f7179e;

        public g(h.b.a.d.m mVar, int i2, String str, String str2) {
            this.f7175a = mVar;
            this.f7177c = i2;
            this.f7178d = str;
            this.f7179e = str2;
        }

        public g(h.b.a.d.m mVar, h.b.a.d.k kVar, int i2, String str, String str2) {
            this.f7175a = mVar;
            this.f7176b = kVar;
            this.f7177c = i2;
            this.f7178d = str;
            this.f7179e = str2;
        }
    }

    @Override // h.b.a.d.n
    public void f() {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.i2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.w0();
            }
        });
    }

    public /* synthetic */ void d(h.b.a.d.m mVar) {
        if (this.d0.A()) {
            this.j0.d(mVar);
        } else {
            this.h0.c(mVar);
        }
    }

    public /* synthetic */ void f(View view) {
        A0();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131427394, viewGroup, false);
        this.e0 = inflate;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(2131231014);
        this.k0 = swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeColors(-14664581, -15906911);
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131230947);
        recyclerView.a(new b());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.b0));
        n nVar = this.h0;
        if (nVar == null) {
            nVar = new n();
            this.h0 = nVar;
        }
        recyclerView.setAdapter(nVar);
        recyclerView.setItemAnimator(new f(recyclerView, swipeRefreshLayout));
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(2131231163);
        this.g0 = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.b0));
        l lVar = this.i0;
        if (lVar == null) {
            lVar = new l(this, null);
            this.i0 = lVar;
        }
        recyclerView2.setAdapter(lVar);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(2131231154);
        this.f0 = recyclerView3;
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.b0, 0, false));
        i iVar = this.j0;
        if (iVar == null) {
            iVar = new i(this, null);
            this.j0 = iVar;
        }
        recyclerView3.setAdapter(iVar);
        h.b.a.d.o m2 = this.d0.m();
        if (m2 != null) {
            e(m2);
            this.j0.f();
            swipeRefreshLayout.setVisibility(8);
            S0();
        } else {
            R0();
        }
        return inflate;
    }

    public final void c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (view == this.g0) {
            marginLayoutParams.topMargin = q0();
        }
        marginLayoutParams.bottomMargin = r0();
        view.setLayoutParams(marginLayoutParams);
    }

    public /* synthetic */ void d(View view) {
        h.b.a.c cVar = this.d0;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.j
    public void e() {
        this.d0.O();
        this.h0.g();
    }

    public /* synthetic */ void e(h.b.a.d.m mVar) {
        if (this.d0.A()) {
            this.j0.a(mVar);
        } else {
            this.h0.a(mVar);
        }
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        this.n0 = true;
    }

    @Override // h.b.a.d.n
    public void c(final h.b.a.d.m mVar) {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.d2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.f(mVar);
            }
        });
    }

    @Override // h.b.a.d.n
    public void b(final h.b.a.d.m mVar) {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.h2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.d(mVar);
            }
        });
    }

    public final boolean c(final View view, final int i2, final int i3) {
        if (this.d0.A() || this.d0.C()) {
            return true;
        }
        if (this.d0.q() && this.d0.r() && this.d0.y() && this.d0.z()) {
            this.e0.post(new Runnable() { // from class: h.b.a.e.d.f2
                @Override // java.lang.Runnable
                public final void run() {
                    g4.this.a(view, i2, i3);
                }
            });
            return true;
        }
        return false;
    }

    public /* synthetic */ void b(f.a aVar) {
        boolean G0;
        f.a.EnumC0164a b2 = aVar.b();
        if (b2 == f.a.EnumC0164a.bluetoothOff) {
            G0 = F0();
        } else if (b2 == f.a.EnumC0164a.locationOff) {
            G0 = N0();
        } else if (b2 == f.a.EnumC0164a.nfcOff) {
            G0 = O0();
        } else if (b2 == f.a.EnumC0164a.hceError) {
            G0 = J0();
        } else if (b2 == f.a.EnumC0164a.hceOff) {
            G0 = L0();
        } else if (b2 == f.a.EnumC0164a.hce_notAuthorized) {
            G0 = K0();
        } else if (b2 == f.a.EnumC0164a.paymentMethod_missing) {
            G0 = Q0();
        } else if (b2 == f.a.EnumC0164a.paymentMethod_invalid) {
            G0 = P0();
        } else if (b2 == f.a.EnumC0164a.invalidEquipment) {
            G0 = M0();
        } else if (b2 == f.a.EnumC0164a.account_notConfirmed) {
            G0 = E0();
        } else if (b2 == f.a.EnumC0164a.account_blackList) {
            G0 = D0();
        } else if (b2 == f.a.EnumC0164a.failed_to_enroll_card) {
            G0 = I0();
        } else if (b2 != f.a.EnumC0164a.card_not_enrolled) {
            return;
        } else {
            G0 = G0();
        }
        n nVar = this.h0;
        if (nVar != null) {
            nVar.h();
            this.k0.setRefreshing(false);
        }
        a.b.g.a.g j2 = j();
        if (G0 && j2 != null && (j2 instanceof MainActivity) && ((MainActivity) j2).o()) {
            aVar.e();
        }
    }

    public /* synthetic */ void e(View view) {
        BackEnd.getPaymentMethods(new h4(this));
    }

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class j extends RecyclerView.d0 implements CompoundButton.OnCheckedChangeListener {
        public final View u;
        public final TextView v;
        public final TextView w;
        public final ImageView x;
        public final ViewGroup y;
        public h.b.a.d.m z;

        public j(View view) {
            super(view);
            this.u = view.findViewById(2131230907);
            this.v = (TextView) view.findViewById(2131231090);
            this.w = (TextView) view.findViewById(2131231089);
            this.x = (ImageView) view.findViewById(2131231178);
            this.y = (ViewGroup) ((ViewGroup) view).getChildAt(0);
        }

        public final void C() {
            ViewGroup viewGroup = this.y;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
        }

        public void a(h.b.a.d.m mVar) {
            if (mVar == null) {
                return;
            }
            h.b.a.d.v d2 = mVar.d();
            String a2 = d2.a();
            String c2 = d2.c();
            this.v.setText(a2);
            TextView textView = this.w;
            if (mVar.b().d() || a2.equals(c2)) {
                c2 = null;
            }
            textView.setText(c2);
            this.z = mVar;
            if (mVar.f()) {
                this.x.setVisibility(8);
                this.u.setOnClickListener(null);
                this.u.setEnabled(false);
                a(mVar.g());
                return;
            }
            h.b.a.d.p b2 = mVar.b();
            if (b2 != null) {
                this.x.setImageResource(b2.c());
            } else {
                int type = d2.getType();
                if (type == 2) {
                    this.x.setImageResource(2131165616);
                } else if (type != 4) {
                    this.x.setImageResource(2131165574);
                } else {
                    this.x.setImageResource(2131165620);
                }
            }
            this.x.setVisibility(0);
            this.u.setEnabled(true);
            C();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            g4.this.a(z, this.z);
        }

        public final void a(List<h.b.a.d.k> list) {
            ViewGroup viewGroup = this.y;
            int size = list.size();
            int childCount = viewGroup.getChildCount() - 1;
            int i2 = 0;
            while (i2 < childCount) {
                int i3 = i2 + 1;
                View childAt = viewGroup.getChildAt(i3);
                if (i2 < size) {
                    childAt.setVisibility(0);
                    ((k) childAt.getTag()).a(this.z, list.get(i2));
                } else {
                    childAt.setVisibility(8);
                }
                i2 = i3;
            }
            while (i2 < size) {
                View inflate = LayoutInflater.from(g4.this.b0).inflate(2131427404, viewGroup, false);
                inflate.setTag(new k(inflate, this.z, list.get(i2)));
                viewGroup.addView(inflate);
                i2++;
            }
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        h.b.a.d.o m2 = this.d0.m();
        if (m2 != null) {
            m2.c();
        }
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, f.a aVar) {
        this.e0.removeCallbacks(this.r0);
        a(aVar);
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, h.b.a.d.q qVar) {
        this.i0.a(qVar);
        S0();
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.a aVar) {
        R0();
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar) {
        this.i0.f();
    }

    @Override // h.b.a.d.n
    public void a(final h.b.a.d.m mVar) {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.k2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.e(mVar);
            }
        });
    }

    public void a(boolean z, h.b.a.d.m mVar) {
        if (z) {
            this.m0 = mVar.d();
            this.s0 = true;
            this.s0 = false;
            z0();
        } else if (this.s0) {
        } else {
            S0();
        }
    }

    @Override // h.b.a.d.f
    public void a(final f.a aVar) {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.v2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.b(aVar);
            }
        });
    }

    @Override // h.b.a.d.f
    public void b(f.b bVar) {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.l2
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.y0();
            }
        });
    }

    public static int b(List<h.b.a.d.m> list, h.b.a.d.m mVar) {
        int indexOf = list.indexOf(mVar);
        if (indexOf != -1) {
            return indexOf;
        }
        try {
            String key = ((h.b.a.d.b0.e) mVar).h().getKey();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (key.equals(((h.b.a.d.b0.e) list.get(i2)).h().getKey())) {
                    return i2;
                }
            }
        } catch (ClassCastException unused) {
        }
        return -1;
    }

    @Override // h.b.a.d.f
    public void a(f.b bVar) {
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.a3
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.x0();
            }
        });
    }

    public /* synthetic */ void a(View view, View view2) {
        view.setOnClickListener(null);
        this.d0.N();
    }

    public /* synthetic */ void a(View view, int i2, int i3) {
        this.e0.findViewById(2131230807).setVisibility(0);
        b(view, i2, i3);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g4.this.d(view2);
            }
        });
    }

    public final void b(View view, int i2, int i3) {
        ((TextView) this.e0.findViewById(2131230877)).setText(i2);
        ((TextView) this.e0.findViewById(2131230876)).setText(Html.fromHtml(a(i3)));
        ((TextView) this.e0.findViewById(2131230876)).setMovementMethod(LinkMovementMethod.getInstance());
        view.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, int i3, Intent intent) {
        if (i2 != 101) {
            super.a(i2, i3, intent);
        } else if (i3 == -1) {
            this.h0.n();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, String[] strArr, int[] iArr) {
        if (i2 == 2) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (iArr.length == 3 && iArr[0] == 0 && iArr[1] == 0 && iArr[2] == 0) {
                    this.p0 = 0;
                    C0();
                    if (!this.d0.A()) {
                        this.d0.L();
                    }
                    this.h0.n();
                    return;
                }
                return;
            } else if (iArr.length == 2 && iArr[0] == 0 && iArr[1] == 0) {
                this.p0 = 0;
                C0();
                if (!this.d0.A()) {
                    this.d0.L();
                }
                this.h0.n();
                return;
            } else {
                return;
            }
        }
        super.a(i2, strArr, iArr);
    }
}
