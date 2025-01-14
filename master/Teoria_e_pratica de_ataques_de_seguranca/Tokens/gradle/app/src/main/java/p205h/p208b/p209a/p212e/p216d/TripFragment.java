package p205h.p208b.p209a.p212e.p216d;

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
import android.support.p065v4.widget.SwipeRefreshLayout;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
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
import com.hbb20.C1444R;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p000a.p006b.p030g.p031a.ActivityCompat;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.p047f0.FastOutLinearInInterpolator;
import p000a.p006b.p030g.p045k.p047f0.FastOutSlowInInterpolator;
import p000a.p006b.p049h.p050a.AlertDialog;
import p070c.p074b.p075a.Crashlytics;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.NearbyStation;
import p205h.p208b.p209a.p210d.NearbyStationListener;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.Stop;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p210d.Zone;
import p205h.p208b.p209a.p210d.p211b0.TipNearbyStation;
import p205h.p208b.p209a.p212e.p214b.Interpolators;
import p205h.p208b.p209a.p212e.p215c.LineDrawable;
import p205h.p208b.p209a.p212e.p215c.StopConnector;
import p205h.p208b.p209a.p212e.p216d.HomeFragment;
import p205h.p208b.p209a.p212e.p216d.TripFragment;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.activity.MainActivity;

/* renamed from: h.b.a.e.d.g4 */
/* loaded from: classes.dex */
public class TripFragment extends AbstractHomeFragment implements SwipeRefreshLayout.InterfaceC0638j, OngoingTrip.InterfaceC2364c, NearbyStationListener, ErrorListener {

    /* renamed from: w0 */
    public static Runnable f9861w0;

    /* renamed from: d0 */
    public Anda f9862d0;

    /* renamed from: e0 */
    public View f9863e0;

    /* renamed from: f0 */
    public RecyclerView f9864f0;

    /* renamed from: g0 */
    public RecyclerView f9865g0;

    /* renamed from: h0 */
    public RunnableC2448n f9866h0;

    /* renamed from: i0 */
    public C2446l f9867i0;

    /* renamed from: j0 */
    public C2443i f9868j0;

    /* renamed from: k0 */
    public SwipeRefreshLayout f9869k0;

    /* renamed from: o0 */
    public Snackbar f9873o0;

    /* renamed from: t0 */
    public StopConnector f9878t0;

    /* renamed from: u0 */
    public StopConnector f9879u0;

    /* renamed from: v0 */
    public StopConnector f9880v0;

    /* renamed from: l0 */
    public int f9870l0 = 0;

    /* renamed from: m0 */
    public Stop f9871m0 = null;

    /* renamed from: n0 */
    public boolean f9872n0 = false;

    /* renamed from: p0 */
    public int f9874p0 = 0;

    /* renamed from: q0 */
    public final Runnable f9875q0 = new RunnableC2434a();

    /* renamed from: r0 */
    public Runnable f9876r0 = new RunnableC2436c();

    /* renamed from: s0 */
    public boolean f9877s0 = false;

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$a */
    /* loaded from: classes.dex */
    public class RunnableC2434a implements Runnable {
        public RunnableC2434a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TripFragment.f9861w0 != this) {
                return;
            }
            Runnable unused = TripFragment.f9861w0 = null;
            TripFragment.this.f9862d0.m1421g();
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$b */
    /* loaded from: classes.dex */
    public class C2435b extends RecyclerView.AbstractC0731t {
        public C2435b() {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0731t
        /* renamed from: a */
        public void mo1057a(RecyclerView recyclerView, int i, int i2) {
            if (TripFragment.this.f9862d0.m1492A()) {
                return;
            }
            TripFragment.this.f9870l0 += i2;
            if (TripFragment.this.f9870l0 < 0) {
                TripFragment.this.f9870l0 = 0;
            }
            TripFragment tripFragment = TripFragment.this;
            tripFragment.m997d(tripFragment.f9870l0);
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$c */
    /* loaded from: classes.dex */
    public class RunnableC2436c implements Runnable {

        /* compiled from: TripFragment.java */
        /* renamed from: h.b.a.e.d.g4$c$a */
        /* loaded from: classes.dex */
        public class C2437a extends Snackbar.C0587b {
            public C2437a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.design.widget.BaseTransientBottomBar.AbstractC0556l
            /* renamed from: a */
            public void mo905a(Snackbar snackbar, int i) {
                super.mo906a(snackbar, i);
                TripFragment.this.m994s0().mo899a(snackbar, i);
                TripFragment.this.f9873o0 = null;
            }
        }

        public RunnableC2436c() {
        }

        /* renamed from: a */
        public /* synthetic */ void m1056a(Snackbar snackbar) {
            TripFragment.this.m994s0().mo900a(snackbar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TripFragment.this.f9862d0.m1492A()) {
                return;
            }
            final Snackbar m1447a = TripFragment.this.f9862d0.m1447a(TripFragment.this.f9860b0.getString(C1444R.string.trip_state_starting), -2);
            TripFragment.this.f9873o0 = m1447a;
            m1447a.m7621f(-12532481);
            m1447a.m7802a(new C2437a());
            m1447a.mo7619m();
            TripFragment.this.f9863e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.z1
                @Override // java.lang.Runnable
                public final void run() {
                    TripFragment.RunnableC2436c.this.m1056a(m1447a);
                }
            }, 60L);
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$d */
    /* loaded from: classes.dex */
    public static class C2438d implements Comparable<C2438d>, Animator.AnimatorListener {

        /* renamed from: a */
        public final int f9885a;

        /* renamed from: b */
        public final C2440f f9886b;

        /* renamed from: c */
        public final RecyclerView.AbstractC0708d0 f9887c;

        /* renamed from: d */
        public Runnable f9888d;

        public C2438d(C2440f c2440f, RecyclerView.AbstractC0708d0 abstractC0708d0) {
            this.f9886b = c2440f;
            this.f9887c = abstractC0708d0;
            View view = abstractC0708d0.f4213a;
            view.setScaleY(1.0f);
            this.f9885a = view.getTop();
        }

        /* renamed from: a */
        public void m1055a(Runnable runnable) {
            this.f9888d = runnable;
        }

        /* renamed from: b */
        public ViewPropertyAnimator m1054b() {
            return this.f9887c.f4213a.animate().setListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9886b.m1045h(this.f9887c);
            Runnable runnable = this.f9888d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f9886b.m1043i(this.f9887c);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C2438d c2438d) {
            return this.f9885a - c2438d.f9885a;
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$e */
    /* loaded from: classes.dex */
    public static class C2439e extends C2438d {
        public C2439e(C2440f c2440f, RecyclerView.AbstractC0708d0 abstractC0708d0) {
            super(c2440f, abstractC0708d0);
        }

        @Override // p205h.p208b.p209a.p212e.p216d.TripFragment.C2438d, java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C2438d c2438d) {
            return c2438d.f9885a - this.f9885a;
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$h */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2442h extends RecyclerView.AbstractC0708d0 implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /* renamed from: u */
        public final TextView f9901u;

        /* renamed from: v */
        public final TextView f9902v;

        /* renamed from: w */
        public final ImageView f9903w;

        /* renamed from: x */
        public final LineDrawable f9904x;

        /* renamed from: y */
        public NearbyStation f9905y;

        public View$OnClickListenerC2442h(View view) {
            super(view);
            this.f9901u = (TextView) view.findViewById(C1444R.C1446id.name);
            this.f9902v = (TextView) view.findViewById(C1444R.C1446id.line);
            TextView textView = this.f9902v;
            LineDrawable lineDrawable = new LineDrawable();
            this.f9904x = lineDrawable;
            textView.setBackground(lineDrawable);
            this.f9903w = (ImageView) view.findViewById(C1444R.C1446id.vehicleType);
            ((ViewGroup) view).getChildAt(0).setOnClickListener(this);
        }

        /* renamed from: a */
        public void m1041a(C2441g c2441g) {
            this.f9901u.setText(c2441g.f9900e);
            this.f9902v.setText(c2441g.f9899d);
            if (c2441g.f9899d == null) {
                this.f9904x.m1207a(null, null);
            } else {
                this.f9904x.m1208a(c2441g.f9897b);
            }
            this.f9903w.setImageResource(c2441g.f9898c);
            this.f9905y = c2441g.f9896a;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            TripFragment.this.m1114a(z, this.f9905y);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$k */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2445k implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        public final TextView f9916a;

        /* renamed from: b */
        public final TextView f9917b;

        /* renamed from: c */
        public final ImageView f9918c;

        /* renamed from: d */
        public final LineDrawable f9919d;

        /* renamed from: e */
        public NearbyStation f9920e;

        public View$OnClickListenerC2445k(View view, NearbyStation nearbyStation, Line line) {
            ViewGroup viewGroup = (ViewGroup) view;
            view.setOnClickListener(this);
            this.f9916a = (TextView) viewGroup.getChildAt(0);
            this.f9917b = (TextView) viewGroup.getChildAt(1);
            this.f9918c = (ImageView) viewGroup.getChildAt(2);
            TextView textView = this.f9916a;
            LineDrawable lineDrawable = new LineDrawable();
            this.f9919d = lineDrawable;
            textView.setBackground(lineDrawable);
            m1024a(nearbyStation, line);
        }

        /* renamed from: a */
        public void m1024a(NearbyStation nearbyStation, Line line) {
            this.f9920e = nearbyStation;
            Operator mo1312b = line.mo1312b();
            if (mo1312b != null) {
                this.f9918c.setImageResource(mo1312b.mo1289c());
                this.f9918c.setContentDescription(mo1312b.mo1290a());
            } else {
                this.f9918c.setImageDrawable(null);
                this.f9918c.setContentDescription(null);
            }
            this.f9918c.setVisibility(0);
            this.f9919d.m1208a(line);
            this.f9916a.setText(line.mo1311c());
            this.f9917b.setText(line.mo1309e());
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TripFragment.this.f9871m0 = this.f9920e.mo1304d();
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$m */
    /* loaded from: classes.dex */
    public class C2447m extends C2450o {

        /* renamed from: A */
        public final ImageView f9924A;

        /* renamed from: B */
        public final LineDrawable f9925B;

        /* renamed from: z */
        public final TextView f9927z;

        public C2447m(View view) {
            super(view);
            StopConnector stopConnector;
            this.f9927z = (TextView) view.findViewById(C1444R.C1446id.line);
            TextView textView = this.f9927z;
            LineDrawable lineDrawable = new LineDrawable();
            this.f9925B = lineDrawable;
            textView.setBackground(lineDrawable);
            this.f9924A = (ImageView) view.findViewById(C1444R.C1446id.operator);
            View view2 = this.f9934u;
            if (TripFragment.this.f9879u0 != null) {
                stopConnector = TripFragment.this.f9879u0;
            } else {
                stopConnector = new StopConnector(TripFragment.this.m7549B(), true, false);
                TripFragment.this.f9879u0 = stopConnector;
            }
            view2.setBackground(stopConnector);
        }

        @Override // p205h.p208b.p209a.p212e.p216d.TripFragment.C2450o
        /* renamed from: a */
        public void mo999a(Passing passing) {
            TripFragment.this.f9879u0.m1206a(m6807h() + 1 < TripFragment.this.f9867i0.mo747a());
            Stop mo1285d = passing.mo1285d();
            this.f9935v.setText(mo1285d.mo1267a());
            Zone mo1265e = mo1285d.mo1265e();
            if (mo1265e == null) {
                Crashlytics.m6081a((Throwable) new InvalidParameterException("Zone was null"));
            } else {
                this.f9937x.setText(mo1265e.mo1331a());
            }
            TextView textView = this.f9936w;
            Context context = TripFragment.this.f9860b0;
            textView.setText(context.getString(C1444R.string.trip_info_startX, DateFormat.getTimeFormat(context).format(Long.valueOf(passing.mo1286a()))));
            Trip mo1300b = TripFragment.this.f9862d0.m1404m().mo1300b();
            Operator mo1263b = mo1300b.mo1263b();
            if (mo1263b != null) {
                this.f9924A.setImageResource(mo1263b.mo1289c());
                this.f9924A.setContentDescription(mo1263b.mo1290a());
            }
            Line mo1257h = mo1300b.mo1257h();
            if (mo1257h != null && mo1257h.mo1311c().length() != 0) {
                this.f9925B.m1208a(mo1257h);
                this.f9927z.setText(mo1257h.mo1311c());
                this.f9927z.setVisibility(0);
                return;
            }
            this.f9927z.setVisibility(8);
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$n */
    /* loaded from: classes.dex */
    public class RunnableC2448n extends RecyclerView.AbstractC0711g<C2444j> implements Runnable {

        /* renamed from: c */
        public final List<NearbyStation> f9928c;

        /* renamed from: d */
        public boolean f9929d = false;

        /* renamed from: e */
        public boolean f9930e = false;

        /* renamed from: f */
        public Snackbar f9931f;

        /* compiled from: TripFragment.java */
        /* renamed from: h.b.a.e.d.g4$n$a */
        /* loaded from: classes.dex */
        public class C2449a extends Snackbar.C0587b {
            public C2449a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.design.widget.BaseTransientBottomBar.AbstractC0556l
            /* renamed from: a */
            public void mo905a(Snackbar snackbar, int i) {
                super.mo906a(snackbar, i);
                TripFragment.this.m994s0().mo899a(snackbar, i);
                RunnableC2448n.this.f9931f = null;
            }
        }

        public RunnableC2448n() {
            this.f9928c = TripFragment.this.f9862d0.m1492A() ? new ArrayList() : new ArrayList(TripFragment.this.f9862d0.m1406l());
            m1008f();
        }

        /* renamed from: a */
        public static /* synthetic */ void m1017a(View view) {
        }

        /* renamed from: c */
        public void m1010c(NearbyStation nearbyStation) {
            int m1107b;
            if (this.f9929d || (m1107b = TripFragment.m1107b(this.f9928c, nearbyStation)) == -1) {
                return;
            }
            m6749d(m1107b);
        }

        /* renamed from: e */
        public boolean m1009e() {
            return false;
        }

        /* renamed from: f */
        public final void m1008f() {
            if (TripFragment.this.f9862d0.m1492A() || !this.f9928c.isEmpty() || this.f9930e) {
                return;
            }
            this.f9930e = true;
            TripFragment.this.f9863e0.postDelayed(this, 100L);
        }

        /* renamed from: g */
        public void m1007g() {
            m1003k();
            int size = this.f9928c.size();
            if (size > 0) {
                this.f9928c.clear();
                m6752c(0, size);
            }
            m1008f();
        }

        /* renamed from: h */
        public void m1006h() {
            TripFragment.this.f9863e0.removeCallbacks(this);
            this.f9930e = false;
        }

        /* renamed from: i */
        public void m1005i() {
            int size = this.f9928c.size();
            this.f9928c.clear();
            m6752c(0, size);
        }

        /* renamed from: j */
        public void m1004j() {
            if (this.f9931f == null) {
                final Snackbar m1447a = TripFragment.this.f9862d0.m1447a(TripFragment.this.f9860b0.getString(C1444R.string.trip_hint), -2);
                this.f9931f = m1447a;
                m1447a.m7629a(17039370, View$OnClickListenerC2523q2.f10156a);
                m1447a.m7621f(-12532481);
                m1447a.m7802a(new C2449a());
                m1447a.mo7619m();
                TripFragment.this.f9863e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.r2
                    @Override // java.lang.Runnable
                    public final void run() {
                        TripFragment.RunnableC2448n.this.m1018a(m1447a);
                    }
                }, 60L);
            }
        }

        /* renamed from: k */
        public void m1003k() {
            TripFragment.this.f9869k0.setRefreshing(this.f9928c.size() == 0);
        }

        /* renamed from: l */
        public void m1002l() {
            int mo747a = mo747a();
            this.f9929d = true;
            this.f9928c.clear();
            if (TripFragment.this.f9872n0 || mo747a == 0) {
                TripFragment.this.f9872n0 = false;
                TripFragment.this.f9869k0.setVisibility(8);
                return;
            }
            m6752c(0, mo747a);
        }

        /* renamed from: m */
        public void m1001m() {
            this.f9929d = false;
            m1003k();
            m6756b(0, mo747a());
            m1008f();
        }

        /* renamed from: n */
        public final void m1000n() {
            TripFragment.this.f9869k0.setRefreshing(false);
            boolean m1492A = TripFragment.this.f9862d0.m1492A();
            if (this.f9928c.size() > 0 || m1492A) {
                TripFragment.this.m1066v0();
            } else {
                TripFragment tripFragment = TripFragment.this;
                if (tripFragment.f9858Z != null) {
                    tripFragment.m1140H0();
                }
            }
            TripFragment.this.m1129S0();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9928c.size() == 0 && !this.f9929d) {
                TripFragment tripFragment = TripFragment.this;
                if (tripFragment.f9860b0 != null) {
                    tripFragment.f9869k0.setRefreshing(false);
                    if (TripFragment.this.f9862d0 != null) {
                        TripFragment.this.f9862d0.m1434c();
                    }
                    TripFragment tripFragment2 = TripFragment.this;
                    if (tripFragment2.f9858Z != null) {
                        tripFragment2.m1140H0();
                    }
                }
            }
            this.f9930e = false;
        }

        /* renamed from: a */
        public void m1016a(NearbyStation nearbyStation) {
            if (this.f9929d) {
                return;
            }
            int size = this.f9928c.size();
            this.f9928c.add(nearbyStation);
            m6747e(size);
            m1000n();
        }

        /* renamed from: b */
        public void m1012b(NearbyStation nearbyStation) {
            int m1107b = TripFragment.m1107b(this.f9928c, nearbyStation);
            if (m1107b == -1) {
                return;
            }
            this.f9928c.remove(m1107b);
            m6746f(m1107b);
            m1000n();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(C2444j c2444j, int i) {
            c2444j.m1026a(this.f9928c.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public C2444j mo742b(ViewGroup viewGroup, int i) {
            return new C2444j(LayoutInflater.from(TripFragment.this.f9860b0).inflate(C1444R.layout.item_station, viewGroup, false));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            List<NearbyStation> list = this.f9928c;
            if (list == null || this.f9929d) {
                return 0;
            }
            return list.size();
        }

        /* renamed from: a */
        public /* synthetic */ void m1018a(Snackbar snackbar) {
            TripFragment.this.m994s0().mo900a(snackbar);
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$o */
    /* loaded from: classes.dex */
    public class C2450o extends RecyclerView.AbstractC0708d0 {

        /* renamed from: u */
        public final View f9934u;

        /* renamed from: v */
        public final TextView f9935v;

        /* renamed from: w */
        public final TextView f9936w;

        /* renamed from: x */
        public final TextView f9937x;

        public C2450o(View view) {
            super(view);
            this.f9934u = view.findViewById(C1444R.C1446id.icon);
            this.f9935v = (TextView) view.findViewById(C1444R.C1446id.stop);
            this.f9936w = (TextView) view.findViewById(C1444R.C1446id.time);
            this.f9937x = (TextView) view.findViewById(C1444R.C1446id.zone);
        }

        /* renamed from: a */
        public void mo999a(Passing passing) {
            StopConnector stopConnector;
            StopConnector stopConnector2;
            if (m6807h() + 1 == TripFragment.this.f9867i0.mo747a()) {
                View view = this.f9934u;
                if (TripFragment.this.f9880v0 != null) {
                    stopConnector2 = TripFragment.this.f9880v0;
                } else {
                    TripFragment tripFragment = TripFragment.this;
                    stopConnector2 = new StopConnector(tripFragment.m7549B(), false, false);
                    tripFragment.f9880v0 = stopConnector2;
                }
                view.setBackground(stopConnector2);
            } else {
                View view2 = this.f9934u;
                if (TripFragment.this.f9878t0 != null) {
                    stopConnector = TripFragment.this.f9878t0;
                } else {
                    TripFragment tripFragment2 = TripFragment.this;
                    stopConnector = new StopConnector(tripFragment2.m7549B(), false, true);
                    tripFragment2.f9878t0 = stopConnector;
                }
                view2.setBackground(stopConnector);
            }
            Stop mo1285d = passing.mo1285d();
            this.f9935v.setText(mo1285d.mo1267a());
            this.f9937x.setText(mo1285d.mo1265e().mo1331a());
            this.f9936w.setText(TripFragment.this.m1150o0().format(Long.valueOf(passing.mo1286a())));
        }
    }

    /* renamed from: A */
    public final boolean m1149A(final View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.z2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1074q(view);
            }
        });
        return true;
    }

    /* renamed from: A0 */
    public final void m1148A0() {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = null;
            Intent[] m1464a = Anda.m1443b(this.f9860b0).m1464a(this.f9860b0);
            int length = m1464a.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Intent intent2 = m1464a[i];
                if (this.f9860b0.getPackageManager().resolveActivity(intent2, 65536) != null) {
                    intent = intent2;
                    break;
                }
                i++;
            }
            if (intent != null) {
                this.f9860b0.startActivity(intent);
                return;
            }
            try {
                this.f9860b0.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                return;
            } catch (ActivityNotFoundException unused) {
                BackEnd.addToLog("openBatteryOptimizationSettings: thrown ActivityNotFoundException, opening Settings.ACTION_SETTINGS");
                this.f9860b0.startActivity(new Intent("android.settings.SETTINGS"));
                return;
            }
        }
        BackEnd.addToLog(String.format(Locale.getDefault(), "openBatteryOptimizationSettings: SDK_INT %d does not support Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS", Integer.valueOf(Build.VERSION.SDK_INT)));
    }

    /* renamed from: B */
    public final boolean m1147B(final View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.n2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1073r(view);
            }
        });
        return true;
    }

    /* renamed from: B0 */
    public final void m1146B0() {
        if (this.f9874p0 == 0) {
            if (Build.VERSION.SDK_INT >= 29) {
                m7506a(new String[]{"android.permission.ACTIVITY_RECOGNITION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE"}, 2);
            } else {
                m7506a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE"}, 2);
            }
        } else {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", this.f9860b0.getPackageName(), null));
            m7518a(intent);
        }
        this.f9874p0++;
    }

    /* renamed from: C0 */
    public final void m1145C0() {
        m1066v0();
        ((TextView) this.f9863e0.findViewById(C1444R.C1446id.errorTitle)).setText(C1444R.string.trip_validate_to_start);
        ((TextView) this.f9863e0.findViewById(C1444R.C1446id.errorDescription)).setText(C1444R.string.trip_validate_to_start_hint);
        this.f9863e0.findViewById(C1444R.C1446id.error).setOnClickListener(null);
    }

    /* renamed from: D0 */
    public final boolean m1144D0() {
        return m1072s(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: E0 */
    public final boolean m1143E0() {
        return m1071t(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: F0 */
    public final boolean m1142F0() {
        return m1069u(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: G0 */
    public final boolean m1141G0() {
        return m1105c(this.f9863e0.findViewById(C1444R.C1446id.error), C1444R.string.error_hce_card_not_enrolled, C1444R.string.error_hce_card_not_enrolled_hint);
    }

    /* renamed from: H0 */
    public void m1140H0() {
        if (this.f9862d0.m1492A()) {
            return;
        }
        final View findViewById = this.f9863e0.findViewById(C1444R.C1446id.error);
        ErrorListener.C2358a m1412j = this.f9862d0.m1412j();
        if (m1068u0()) {
            m1112b(findViewById, C1444R.string.error_permission_location, C1444R.string.error_permission_location_hint);
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.f9860b0 != null && ((!ActivityCompat.m10414a((Activity) this.f9858Z, "android.permission.ACTIVITY_RECOGNITION") || !ActivityCompat.m10414a((Activity) this.f9858Z, "android.permission.ACCESS_FINE_LOCATION") || !ActivityCompat.m10414a((Activity) this.f9858Z, "android.permission.READ_PHONE_STATE")) && this.f9874p0 == 0)) {
                    m1146B0();
                }
            } else if (this.f9860b0 != null && ((!ActivityCompat.m10414a((Activity) this.f9858Z, "android.permission.ACCESS_FINE_LOCATION") || !ActivityCompat.m10414a((Activity) this.f9858Z, "android.permission.READ_PHONE_STATE")) && this.f9874p0 == 0)) {
                m1146B0();
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.s2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TripFragment.this.m1082k(view);
                }
            });
        } else if (!Anda.m1467X().m1396q()) {
            m1112b(findViewById, C1444R.string.error_battery_optimizations, C1444R.string.error_battery_optimizations_hint);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.y1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TripFragment.this.m1084j(view);
                }
            });
        } else if (!this.f9862d0.m1394r()) {
            m1069u(findViewById);
        } else if (!this.f9862d0.m1380y()) {
            m1061y(findViewById);
        } else if (!this.f9862d0.m1378z()) {
            m1059z(findViewById);
        } else if (!this.f9862d0.m1490B()) {
            if (this.f9862d0.m1382x()) {
                m1112b(findViewById, C1444R.string.error_syncing, C1444R.string.error_syncing_hint);
            } else {
                m1112b(findViewById, C1444R.string.error_invalidData, C1444R.string.error_invalidData_hint);
            }
            findViewById.setOnClickListener(null);
        } else if (this.f9862d0.m1398p()) {
            m1112b(findViewById, C1444R.string.error_invalidData, C1444R.string.error_invalidData_hint);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.c3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TripFragment.this.m1124a(findViewById, view);
                }
            });
        } else if (this.f9862d0.m1386v()) {
            m1112b(findViewById, C1444R.string.enabling_hce, C1444R.string.enabling_hce_hint);
            findViewById.setOnClickListener(null);
        } else if (m1412j != null) {
            mo32a(m1412j);
        } else {
            m1112b(findViewById, C1444R.string.trip_validate_to_start, C1444R.string.trip_validate_to_start_hint);
            findViewById.setOnClickListener(null);
        }
    }

    /* renamed from: I0 */
    public final boolean m1139I0() {
        return m1105c(this.f9863e0.findViewById(C1444R.C1446id.error), C1444R.string.error_hce_enroll_failed, C1444R.string.error_hce_enroll_failed_hint);
    }

    /* renamed from: J0 */
    public final boolean m1138J0() {
        return m1105c(this.f9863e0.findViewById(C1444R.C1446id.error), C1444R.string.error_hce_lib, C1444R.string.error_hce_hint);
    }

    /* renamed from: K0 */
    public final boolean m1137K0() {
        return m1067v(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: L0 */
    public final boolean m1136L0() {
        return m1065w(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: M0 */
    public final boolean m1135M0() {
        return m1063x(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: N0 */
    public final boolean m1134N0() {
        return m1061y(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: O0 */
    public final boolean m1133O0() {
        return m1059z(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: P0 */
    public final boolean m1132P0() {
        return m1149A(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: Q0 */
    public final boolean m1131Q0() {
        return m1147B(this.f9863e0.findViewById(C1444R.C1446id.error));
    }

    /* renamed from: R0 */
    public final void m1130R0() {
        this.f9870l0 = 0;
        C2446l c2446l = this.f9867i0;
        if (c2446l != null) {
            c2446l.m1020e();
        }
        this.f9866h0.m1001m();
        this.f9868j0.m1028g();
        m1129S0();
        this.f9869k0.setVisibility(0);
        this.f9869k0.setEnabled(true);
        Snackbar snackbar = this.f9873o0;
        if (snackbar != null) {
            snackbar.mo7623b();
        }
    }

    /* renamed from: S0 */
    public final void m1129S0() {
        HomeFragment.InterfaceC2508h m994s0 = m994s0();
        if (this.f9862d0.m1492A()) {
            if (this.f9862d0.m1404m().mo1300b().mo1253l() > 1) {
                m994s0.mo898b();
                return;
            } else {
                m994s0.mo901a(C1444R.string.trip_action_end, C1444R.C1445drawable.ic_close_white_24dp, -3790808, false);
                return;
            }
        }
        m994s0.mo898b();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: U */
    public void mo897U() {
        this.f9862d0.m1435b((OngoingTrip.InterfaceC2364c) this);
        this.f9862d0.m1436b((NearbyStationListener) this);
        this.f9862d0.m1437b((ErrorListener) this);
        super.mo897U();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public void mo873Z() {
        super.mo873Z();
        f9861w0 = null;
        Log.d("Anda:GUI:TripFragment", "Resuming fragment and leaving power saving mode...");
        m1129S0();
        this.f9866h0.m1007g();
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: b0 */
    public void mo883b0() {
        super.mo883b0();
        Runnable runnable = this.f9875q0;
        f9861w0 = runnable;
        this.f9863e0.postDelayed(runnable, 20000L);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
    }

    /* renamed from: m */
    public /* synthetic */ void m1078m(View view) {
        m1112b(view, C1444R.string.error_battery_optimizations, C1444R.string.error_battery_optimizations_hint);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripFragment.this.m1093f(view2);
            }
        });
    }

    /* renamed from: n */
    public /* synthetic */ void m1077n(View view) {
        m1112b(view, C1444R.string.error_invalid_equipment, C1444R.string.error_invalid_equipment_hint);
        view.setOnClickListener(null);
    }

    /* renamed from: o */
    public /* synthetic */ void m1076o(View view) {
        FragmentActivity m7468j = m7468j();
        if (m7468j == null || !(m7468j instanceof MainActivity)) {
            return;
        }
        ((MainActivity) m7468j).m6r();
    }

    /* renamed from: p */
    public /* synthetic */ void m1075p(View view) {
        FragmentActivity m7468j = m7468j();
        if (m7468j == null || !(m7468j instanceof MainActivity)) {
            return;
        }
        ((MainActivity) m7468j).m5s();
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment
    /* renamed from: p0 */
    public void mo892p0() {
        m1106c((View) this.f9869k0);
        m1106c((View) this.f9865g0);
        ViewGroup.LayoutParams layoutParams = this.f9864f0.getLayoutParams();
        layoutParams.height = m996q0();
        this.f9864f0.setLayoutParams(layoutParams);
        RunnableC2448n runnableC2448n = this.f9866h0;
        m997d((runnableC2448n == null || runnableC2448n.mo747a() == 0) ? 0 : this.f9870l0);
    }

    /* renamed from: q */
    public /* synthetic */ void m1074q(View view) {
        m1112b(view, C1444R.string.error_paymentdata_invalid, C1444R.string.error_paymentdata_invalid_hint);
        view.setOnClickListener(null);
    }

    /* renamed from: r */
    public /* synthetic */ void m1073r(View view) {
        m1112b(view, C1444R.string.error_paymentdata, C1444R.string.error_paymentdata_hint);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripFragment.this.m1098e(view2);
            }
        });
    }

    /* renamed from: s */
    public final boolean m1072s(final View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.o2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1090g(view);
            }
        });
        return true;
    }

    /* renamed from: t */
    public final boolean m1071t(final View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.g2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1088h(view);
            }
        });
        return true;
    }

    /* renamed from: t0 */
    public void m1070t0() {
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
        c0325a.m9134b(C1444R.string.trip_action_end);
        c0325a.m9147a(C1444R.string.trip_action_end_message);
        c0325a.m9133b(C1444R.string.yes, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.e2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                TripFragment.this.m1126a(dialogInterface, i);
            }
        });
        c0325a.m9146a(C1444R.string.f6337no, (DialogInterface.OnClickListener) null);
        c0325a.m9129c();
    }

    /* renamed from: u */
    public final boolean m1069u(View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        m1112b(view, C1444R.string.error_bluetooth, C1444R.string.error_bluetooth_hint);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripFragment.this.m1086i(view2);
            }
        });
        return true;
    }

    /* renamed from: u0 */
    public final boolean m1068u0() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return (ContextCompat.m10021a(this.f9860b0, "android.permission.ACTIVITY_RECOGNITION") == 0 && ContextCompat.m10021a(this.f9860b0, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.m10021a(this.f9860b0, "android.permission.READ_PHONE_STATE") == 0) ? false : true;
        } else if (i >= 23) {
            return (ContextCompat.m10021a(this.f9860b0, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.m10021a(this.f9860b0, "android.permission.READ_PHONE_STATE") == 0) ? false : true;
        } else {
            return false;
        }
    }

    /* renamed from: v */
    public final boolean m1067v(final View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        if (this.f9862d0.m1394r() && this.f9862d0.m1380y() && this.f9862d0.m1378z()) {
            this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.t2
                @Override // java.lang.Runnable
                public final void run() {
                    TripFragment.this.m1080l(view);
                }
            });
            return true;
        }
        return true;
    }

    /* renamed from: v0 */
    public final void m1066v0() {
        this.f9863e0.findViewById(C1444R.C1446id.error).setVisibility(8);
        this.f9863e0.findViewById(C1444R.C1446id.attentionLayout).setVisibility(8);
    }

    /* renamed from: w */
    public final boolean m1065w(final View view) {
        if (!m1105c(view, C1444R.string.error_hce, C1444R.string.error_hce_hint) && !this.f9862d0.m1396q()) {
            this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.y2
                @Override // java.lang.Runnable
                public final void run() {
                    TripFragment.this.m1078m(view);
                }
            });
        }
        return true;
    }

    /* renamed from: w0 */
    public /* synthetic */ void m1064w0() {
        this.f9866h0.m1005i();
    }

    /* renamed from: x */
    public final boolean m1063x(final View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.c2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1077n(view);
            }
        });
        return true;
    }

    /* renamed from: x0 */
    public /* synthetic */ void m1062x0() {
        m1145C0();
        RunnableC2448n runnableC2448n = this.f9866h0;
        if (runnableC2448n != null) {
            runnableC2448n.m1000n();
        }
    }

    /* renamed from: y */
    public final boolean m1061y(View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        m1112b(view, C1444R.string.error_location, C1444R.string.error_location_hint);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripFragment.this.m1076o(view2);
            }
        });
        return true;
    }

    /* renamed from: y0 */
    public /* synthetic */ void m1060y0() {
        m1145C0();
        RunnableC2448n runnableC2448n = this.f9866h0;
        if (runnableC2448n != null) {
            runnableC2448n.m1000n();
        }
    }

    /* renamed from: z */
    public final boolean m1059z(View view) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return false;
        }
        m1112b(view, C1444R.string.error_nfc, C1444R.string.error_nfc_hint);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripFragment.this.m1075p(view2);
            }
        });
        return true;
    }

    /* renamed from: z0 */
    public final void m1058z0() {
        m1129S0();
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$f */
    /* loaded from: classes.dex */
    public class C2440f extends RecyclerView.AbstractC0716l {

        /* renamed from: g */
        public final RecyclerView f9889g;

        /* renamed from: h */
        public final SwipeRefreshLayout f9890h;

        /* renamed from: l */
        public int f9894l = 0;

        /* renamed from: i */
        public List<C2438d> f9891i = new ArrayList();

        /* renamed from: j */
        public List<C2438d> f9892j = new ArrayList();

        /* renamed from: k */
        public List<C2438d> f9893k = new ArrayList();

        public C2440f(RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
            this.f9889g = recyclerView;
            this.f9890h = swipeRefreshLayout;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: a */
        public boolean mo1052a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0708d0 abstractC0708d02, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
            return false;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: a */
        public boolean mo1051a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
            View view = abstractC0708d0.f4213a;
            boolean m1492A = TripFragment.this.f9862d0.m1492A();
            if (Build.VERSION.SDK_INT >= 21) {
                view.setAlpha(0.0f);
            }
            view.setTranslationX(0.0f);
            view.setTranslationY(m1492A ? (-this.f9889g.getHeight()) / 32 : this.f9889g.getHeight() / 8);
            this.f9891i.add(new C2438d(this, abstractC0708d0));
            return true;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: b */
        public void mo1050b() {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: b */
        public boolean mo1049b(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
            this.f9892j.add(TripFragment.this.f9862d0.m1492A() ? new C2438d(this, abstractC0708d0) : new C2439e(this, abstractC0708d0));
            return true;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: c */
        public boolean mo1048c(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0716l.C0719c c0719c, RecyclerView.AbstractC0716l.C0719c c0719c2) {
            abstractC0708d0.f4213a.setTranslationY(c0719c.f4242b - c0719c2.f4242b);
            this.f9893k.add(new C2439e(this, abstractC0708d0));
            return true;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: d */
        public void mo1047d(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: g */
        public boolean mo1046g() {
            return this.f9894l > 0;
        }

        /* renamed from: h */
        public void m1045h(RecyclerView.AbstractC0708d0 abstractC0708d0) {
            this.f9894l--;
            m6729b(abstractC0708d0);
        }

        /* renamed from: i */
        public void m1043i(RecyclerView.AbstractC0708d0 abstractC0708d0) {
            this.f9894l++;
            m6727c(abstractC0708d0);
        }

        /* renamed from: j */
        public /* synthetic */ void m1042j() {
            this.f9890h.setVisibility(8);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
        /* renamed from: i */
        public void mo1044i() {
            boolean m1492A = TripFragment.this.f9862d0.m1492A();
            int height = this.f9889g.getHeight();
            int i = m1492A ? (-height) / 16 : height / 2;
            FastOutSlowInInterpolator fastOutSlowInInterpolator = Interpolators.f9740a;
            List<C2438d> list = this.f9892j;
            Collections.sort(list);
            int size = list.size();
            FastOutLinearInInterpolator fastOutLinearInInterpolator = size == 0 ? null : new FastOutLinearInInterpolator();
            for (int i2 = 0; i2 < size; i2++) {
                ViewPropertyAnimator m1054b = list.get(i2).m1054b();
                if (m1492A) {
                    m1054b.translationY(i).setDuration(240L);
                } else {
                    m1054b.translationX(i).setDuration(180L);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    m1054b.alpha(0.0f);
                }
                m1054b.setInterpolator(fastOutLinearInInterpolator).setStartDelay(i2 * 30);
                if (m1492A) {
                    m1054b.scaleY(0.8f);
                }
                m1054b.start();
            }
            if (m1492A && size > 0) {
                list.get(size - 1).m1055a(new Runnable() { // from class: h.b.a.e.d.p2
                    @Override // java.lang.Runnable
                    public final void run() {
                        TripFragment.C2440f.this.m1042j();
                    }
                });
            }
            list.clear();
            List<C2438d> list2 = this.f9891i;
            Collections.sort(list2);
            int i3 = size * 80;
            int size2 = list2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ViewPropertyAnimator m1054b2 = list2.get(i4).m1054b();
                if (Build.VERSION.SDK_INT >= 21) {
                    m1054b2.alpha(1.0f);
                }
                m1054b2.translationY(0.0f).setDuration(m1492A ? 140L : 280L).setInterpolator(fastOutSlowInInterpolator).setStartDelay((i4 * 50) + i3).start();
            }
            list2.clear();
            List<C2438d> list3 = this.f9893k;
            Collections.sort(list3);
            int size3 = list3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                list3.get(i5).m1054b().translationY(0.0f).scaleY(1.0f).setInterpolator(fastOutSlowInInterpolator).setStartDelay(i5 * 45).start();
            }
            list3.clear();
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$i */
    /* loaded from: classes.dex */
    public class C2443i extends RecyclerView.AbstractC0711g<View$OnClickListenerC2442h> implements AsyncResult.InterfaceC2279a<List<NearbyStation>> {

        /* renamed from: c */
        public List<C2441g> f9907c;

        public C2443i() {
            this.f9907c = new ArrayList();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo1034b(View$OnClickListenerC2442h view$OnClickListenerC2442h) {
            int width = TripFragment.this.f9864f0.getWidth();
            view$OnClickListenerC2442h.f4213a.setMinimumWidth((int) ((width / 2) - (width * 0.2f)));
            view$OnClickListenerC2442h.f4213a.setMinimumWidth(TripFragment.this.m994s0().mo902a() * 2);
            super.mo1034b((C2443i) view$OnClickListenerC2442h);
        }

        /* renamed from: c */
        public void m1032c(NearbyStation nearbyStation) {
            int i = 0;
            while (i < this.f9907c.size()) {
                if (this.f9907c.get(i).f9896a == nearbyStation) {
                    this.f9907c.remove(i);
                    m6746f(i);
                    i--;
                }
                i++;
            }
        }

        /* renamed from: d */
        public void m1031d(NearbyStation nearbyStation) {
            boolean z;
            boolean z2;
            List<Line> mo1302g = nearbyStation.mo1302g();
            int i = 0;
            while (i < this.f9907c.size()) {
                C2441g c2441g = this.f9907c.get(i);
                if (c2441g.f9896a == nearbyStation) {
                    Iterator<Line> it = mo1302g.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (c2441g.f9897b == it.next()) {
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        this.f9907c.remove(i);
                        m6746f(i);
                        i--;
                    }
                }
                i++;
            }
            for (Line line : mo1302g) {
                Iterator<C2441g> it2 = this.f9907c.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().f9897b == line) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    int m1040a = m1040a(line);
                    this.f9907c.add(0, new C2441g(nearbyStation, line, m1040a, line.mo1311c(), m1040a == C1444R.C1445drawable.ic_directions_bus_black_24dp ? line.mo1309e() : nearbyStation.mo1304d().mo1267a()));
                    m6747e(0);
                }
            }
        }

        /* renamed from: e */
        public void m1030e() {
            int size = this.f9907c.size();
            if (size > 0) {
                this.f9907c.clear();
                m6752c(0, size);
            }
        }

        /* renamed from: f */
        public void m1029f() {
            m1035a(TripFragment.this.f9862d0.m1406l());
        }

        /* renamed from: g */
        public void m1028g() {
            m1030e();
        }

        public /* synthetic */ C2443i(TripFragment tripFragment, RunnableC2434a runnableC2434a) {
            this();
        }

        /* renamed from: b */
        public final int m1033b(NearbyStation nearbyStation) {
            return nearbyStation.mo1305b().mo1289c();
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<List<NearbyStation>> asyncResult) {
            if (TripFragment.this.f9862d0.m1492A()) {
                m1035a(asyncResult.mo1334a());
            }
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public View$OnClickListenerC2442h mo742b(ViewGroup viewGroup, int i) {
            TripFragment tripFragment = TripFragment.this;
            return new View$OnClickListenerC2442h(LayoutInflater.from(tripFragment.f9860b0).inflate(C1444R.layout.item_line_or_station_alternative, viewGroup, false));
        }

        /* renamed from: a */
        public void m1035a(List<NearbyStation> list) {
            m1030e();
            for (NearbyStation nearbyStation : list) {
                m1038a(nearbyStation, false);
            }
        }

        /* renamed from: a */
        public final void m1038a(NearbyStation nearbyStation, boolean z) {
            List<Line> mo1302g = nearbyStation.mo1302g();
            if (mo1302g != null && nearbyStation.mo1303f()) {
                for (Line line : mo1302g) {
                    C2441g c2441g = new C2441g(nearbyStation, line, m1040a(line), line.mo1311c(), line.mo1309e());
                    if (z) {
                        this.f9907c.add(0, c2441g);
                        m6747e(0);
                    } else {
                        this.f9907c.add(c2441g);
                        m6747e(this.f9907c.size() - 1);
                    }
                }
                return;
            }
            C2441g c2441g2 = new C2441g(nearbyStation, m1033b(nearbyStation), null, nearbyStation.mo1304d().mo1267a());
            if (z) {
                this.f9907c.add(0, c2441g2);
                m6747e(0);
                return;
            }
            this.f9907c.add(c2441g2);
            m6747e(this.f9907c.size() - 1);
        }

        /* renamed from: a */
        public final int m1040a(Line line) {
            return line.mo1312b().mo1289c();
        }

        /* renamed from: a */
        public void m1039a(NearbyStation nearbyStation) {
            m1038a(nearbyStation, true);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(View$OnClickListenerC2442h view$OnClickListenerC2442h, int i) {
            view$OnClickListenerC2442h.m1041a(this.f9907c.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            return this.f9907c.size();
        }
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$l */
    /* loaded from: classes.dex */
    public class C2446l extends RecyclerView.AbstractC0711g<C2450o> {

        /* renamed from: c */
        public final List<Passing> f9922c;

        public C2446l() {
            this.f9922c = new ArrayList();
        }

        /* renamed from: a */
        public void m1022a(Trip trip) {
            int size = this.f9922c.size();
            this.f9922c.clear();
            m6752c(0, size);
            int mo1253l = trip.mo1253l();
            for (int i = 0; i < mo1253l; i++) {
                this.f9922c.add(trip.mo1264a(i));
            }
            m6756b(0, mo1253l);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: c */
        public int mo739c(int i) {
            return i == 0 ? 0 : 1;
        }

        /* renamed from: e */
        public void m1020e() {
            int size = this.f9922c.size();
            this.f9922c.clear();
            m6752c(0, size);
        }

        /* renamed from: f */
        public void m1019f() {
            int size = this.f9922c.size();
            this.f9922c.clear();
            m6752c(0, size);
        }

        public /* synthetic */ C2446l(TripFragment tripFragment, RunnableC2434a runnableC2434a) {
            this();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public C2450o mo742b(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new C2450o(LayoutInflater.from(TripFragment.this.f9860b0).inflate(C1444R.layout.item_stop, viewGroup, false));
            }
            return new C2447m(LayoutInflater.from(TripFragment.this.f9860b0).inflate(C1444R.layout.item_trip_start, viewGroup, false));
        }

        /* renamed from: a */
        public void m1023a(Passing passing) {
            int size = this.f9922c.size();
            this.f9922c.add(passing);
            m6749d(size - 1);
            m6747e(size);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(C2450o c2450o, int i) {
            c2450o.mo999a(this.f9922c.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            return this.f9922c.size();
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
        m1129S0();
        m1096e(this.f9862d0.m1404m());
        RunnableC2448n runnableC2448n = this.f9866h0;
        if (runnableC2448n != null) {
            runnableC2448n.m1002l();
        }
        Snackbar snackbar = this.f9873o0;
        if (snackbar != null) {
            snackbar.mo7623b();
        }
    }

    /* renamed from: e */
    public final void m1096e(OngoingTrip ongoingTrip) {
        this.f9867i0.m1022a(ongoingTrip.mo1300b());
        RunnableC2448n runnableC2448n = this.f9866h0;
        if (runnableC2448n != null) {
            if (runnableC2448n.m1009e()) {
                this.f9868j0.m1035a(this.f9866h0.f9928c);
            } else {
                this.f9868j0.m1029f();
                this.f9869k0.setVisibility(8);
            }
        }
        m1066v0();
        m997d(0);
        this.f9869k0.setEnabled(false);
    }

    /* renamed from: f */
    public /* synthetic */ void m1092f(NearbyStation nearbyStation) {
        if (this.f9871m0 == nearbyStation.mo1304d()) {
            m1129S0();
        }
        if (this.f9862d0.m1492A()) {
            this.f9868j0.m1032c(nearbyStation);
        } else {
            this.f9866h0.m1012b(nearbyStation);
        }
    }

    /* renamed from: g */
    public /* synthetic */ void m1090g(View view) {
        m1112b(view, C1444R.string.error_account_blacklist, C1444R.string.error_account_blacklist_hint);
        view.setOnClickListener(null);
    }

    /* renamed from: h */
    public /* synthetic */ void m1088h(View view) {
        m1112b(view, C1444R.string.error_account_notconfirmed, C1444R.string.error_account_notconfirmed_hint);
        view.setOnClickListener(null);
    }

    /* renamed from: i */
    public /* synthetic */ void m1086i(View view) {
        FragmentActivity m7468j = m7468j();
        if (m7468j == null || !(m7468j instanceof MainActivity)) {
            return;
        }
        ((MainActivity) m7468j).m7q();
    }

    /* renamed from: j */
    public /* synthetic */ void m1084j(View view) {
        m1148A0();
    }

    /* renamed from: k */
    public /* synthetic */ void m1082k(View view) {
        m1146B0();
    }

    /* renamed from: l */
    public /* synthetic */ void m1080l(View view) {
        m1112b(view, C1444R.string.error_hce, C1444R.string.error_hce_not_authorized_hint);
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment
    /* renamed from: b */
    public void mo998b(View view) {
        if (this.f9862d0.m1492A()) {
            if (this.f9871m0 == null) {
                m1070t0();
                return;
            }
            AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
            c0325a.m9134b(C1444R.string.trip_action_newTrip);
            c0325a.m9147a(C1444R.string.trip_action_newTrip_message);
            c0325a.m9133b(C1444R.string.yes, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.b3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TripFragment.this.m1113b(dialogInterface, i);
                }
            });
            c0325a.m9146a(C1444R.string.f6337no, (DialogInterface.OnClickListener) null);
            c0325a.m9129c();
        } else if (this.f9871m0 == null) {
            this.f9866h0.m1004j();
        }
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        f9861w0 = null;
        this.f9862d0 = Anda.m1443b(this.f9860b0);
        this.f9862d0.m1450a((OngoingTrip.InterfaceC2364c) this);
        this.f9862d0.m1451a((NearbyStationListener) this);
        this.f9862d0.m1454a((ErrorListener) this);
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$g */
    /* loaded from: classes.dex */
    public static class C2441g {

        /* renamed from: a */
        public NearbyStation f9896a;

        /* renamed from: b */
        public Line f9897b;

        /* renamed from: c */
        public int f9898c;

        /* renamed from: d */
        public String f9899d;

        /* renamed from: e */
        public String f9900e;

        public C2441g(NearbyStation nearbyStation, int i, String str, String str2) {
            this.f9896a = nearbyStation;
            this.f9898c = i;
            this.f9899d = str;
            this.f9900e = str2;
        }

        public C2441g(NearbyStation nearbyStation, Line line, int i, String str, String str2) {
            this.f9896a = nearbyStation;
            this.f9897b = line;
            this.f9898c = i;
            this.f9899d = str;
            this.f9900e = str2;
        }
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStationListener
    /* renamed from: f */
    public void mo1094f() {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.i2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1064w0();
            }
        });
    }

    /* renamed from: d */
    public /* synthetic */ void m1100d(NearbyStation nearbyStation) {
        if (this.f9862d0.m1492A()) {
            this.f9868j0.m1031d(nearbyStation);
        } else {
            this.f9866h0.m1010c(nearbyStation);
        }
    }

    /* renamed from: f */
    public /* synthetic */ void m1093f(View view) {
        m1148A0();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1444R.layout.fragment_trip_alternative2, viewGroup, false);
        this.f9863e0 = inflate;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(C1444R.C1446id.refresher);
        this.f9869k0 = swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeColors(-14664581, -15906911);
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(C1444R.C1446id.list);
        recyclerView.m6926a(new C2435b());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f9860b0));
        RunnableC2448n runnableC2448n = this.f9866h0;
        if (runnableC2448n == null) {
            runnableC2448n = new RunnableC2448n();
            this.f9866h0 = runnableC2448n;
        }
        recyclerView.setAdapter(runnableC2448n);
        recyclerView.setItemAnimator(new C2440f(recyclerView, swipeRefreshLayout));
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(C1444R.C1446id.trip);
        this.f9865g0 = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.f9860b0));
        C2446l c2446l = this.f9867i0;
        if (c2446l == null) {
            c2446l = new C2446l(this, null);
            this.f9867i0 = c2446l;
        }
        recyclerView2.setAdapter(c2446l);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(C1444R.C1446id.topList);
        this.f9864f0 = recyclerView3;
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.f9860b0, 0, false));
        C2443i c2443i = this.f9868j0;
        if (c2443i == null) {
            c2443i = new C2443i(this, null);
            this.f9868j0 = c2443i;
        }
        recyclerView3.setAdapter(c2443i);
        OngoingTrip m1404m = this.f9862d0.m1404m();
        if (m1404m != null) {
            m1096e(m1404m);
            this.f9868j0.m1029f();
            swipeRefreshLayout.setVisibility(8);
            m1129S0();
        } else {
            m1130R0();
        }
        return inflate;
    }

    /* renamed from: c */
    public final void m1106c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (view == this.f9865g0) {
            marginLayoutParams.topMargin = m996q0();
        }
        marginLayoutParams.bottomMargin = m995r0();
        view.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: d */
    public /* synthetic */ void m1101d(View view) {
        Anda anda = this.f9862d0;
        if (anda != null) {
            anda.m1434c();
        }
    }

    @Override // android.support.p065v4.widget.SwipeRefreshLayout.InterfaceC0638j
    /* renamed from: e */
    public void mo989e() {
        this.f9862d0.m1476O();
        this.f9866h0.m1007g();
    }

    /* renamed from: e */
    public /* synthetic */ void m1097e(NearbyStation nearbyStation) {
        if (this.f9862d0.m1492A()) {
            this.f9868j0.m1039a(nearbyStation);
        } else {
            this.f9866h0.m1016a(nearbyStation);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m1113b(DialogInterface dialogInterface, int i) {
        this.f9872n0 = true;
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStationListener
    /* renamed from: c */
    public void mo1104c(final NearbyStation nearbyStation) {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.d2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1092f(nearbyStation);
            }
        });
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStationListener
    /* renamed from: b */
    public void mo1110b(final NearbyStation nearbyStation) {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.h2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1100d(nearbyStation);
            }
        });
    }

    /* renamed from: c */
    public final boolean m1105c(final View view, final int i, final int i2) {
        if (this.f9862d0.m1492A() || this.f9862d0.m1488C()) {
            return true;
        }
        if (this.f9862d0.m1396q() && this.f9862d0.m1394r() && this.f9862d0.m1380y() && this.f9862d0.m1378z()) {
            this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.f2
                @Override // java.lang.Runnable
                public final void run() {
                    TripFragment.this.m1125a(view, i, i2);
                }
            });
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public /* synthetic */ void m1111b(ErrorListener.C2358a c2358a) {
        boolean m1141G0;
        ErrorListener.C2358a.EnumC2359a m1323b = c2358a.m1323b();
        if (m1323b == ErrorListener.C2358a.EnumC2359a.bluetoothOff) {
            m1141G0 = m1142F0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.locationOff) {
            m1141G0 = m1134N0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.nfcOff) {
            m1141G0 = m1133O0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.hceError) {
            m1141G0 = m1138J0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.hceOff) {
            m1141G0 = m1136L0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.hce_notAuthorized) {
            m1141G0 = m1137K0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.paymentMethod_missing) {
            m1141G0 = m1131Q0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.paymentMethod_invalid) {
            m1141G0 = m1132P0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.invalidEquipment) {
            m1141G0 = m1135M0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.account_notConfirmed) {
            m1141G0 = m1143E0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.account_blackList) {
            m1141G0 = m1144D0();
        } else if (m1323b == ErrorListener.C2358a.EnumC2359a.failed_to_enroll_card) {
            m1141G0 = m1139I0();
        } else if (m1323b != ErrorListener.C2358a.EnumC2359a.card_not_enrolled) {
            return;
        } else {
            m1141G0 = m1141G0();
        }
        RunnableC2448n runnableC2448n = this.f9866h0;
        if (runnableC2448n != null) {
            runnableC2448n.m1006h();
            this.f9869k0.setRefreshing(false);
        }
        FragmentActivity m7468j = m7468j();
        if (m1141G0 && m7468j != null && (m7468j instanceof MainActivity) && ((MainActivity) m7468j).m9o()) {
            c2358a.m1320e();
        }
    }

    /* renamed from: e */
    public /* synthetic */ void m1098e(View view) {
        BackEnd.getPaymentMethods(new C2455h4(this));
    }

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.g4$j */
    /* loaded from: classes.dex */
    public class C2444j extends RecyclerView.AbstractC0708d0 implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: u */
        public final View f9910u;

        /* renamed from: v */
        public final TextView f9911v;

        /* renamed from: w */
        public final TextView f9912w;

        /* renamed from: x */
        public final ImageView f9913x;

        /* renamed from: y */
        public final ViewGroup f9914y;

        /* renamed from: z */
        public NearbyStation f9915z;

        public C2444j(View view) {
            super(view);
            this.f9910u = view.findViewById(C1444R.C1446id.header);
            this.f9911v = (TextView) view.findViewById(C1444R.C1446id.stationName);
            this.f9912w = (TextView) view.findViewById(C1444R.C1446id.stationCode);
            this.f9913x = (ImageView) view.findViewById(C1444R.C1446id.vehicleType);
            this.f9914y = (ViewGroup) ((ViewGroup) view).getChildAt(0);
        }

        /* renamed from: C */
        public final void m1027C() {
            ViewGroup viewGroup = this.f9914y;
            int childCount = viewGroup.getChildCount();
            for (int i = 1; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
        }

        /* renamed from: a */
        public void m1026a(NearbyStation nearbyStation) {
            if (nearbyStation == null) {
                return;
            }
            Stop mo1304d = nearbyStation.mo1304d();
            String mo1267a = mo1304d.mo1267a();
            String mo1266c = mo1304d.mo1266c();
            this.f9911v.setText(mo1267a);
            TextView textView = this.f9912w;
            if (nearbyStation.mo1305b().mo1288d() || mo1267a.equals(mo1266c)) {
                mo1266c = null;
            }
            textView.setText(mo1266c);
            this.f9915z = nearbyStation;
            if (nearbyStation.mo1303f()) {
                this.f9913x.setVisibility(8);
                this.f9910u.setOnClickListener(null);
                this.f9910u.setEnabled(false);
                m1025a(nearbyStation.mo1302g());
                return;
            }
            Operator mo1305b = nearbyStation.mo1305b();
            if (mo1305b != null) {
                this.f9913x.setImageResource(mo1305b.mo1289c());
            } else {
                int type = mo1304d.getType();
                if (type == 2) {
                    this.f9913x.setImageResource(C1444R.C1445drawable.ic_subway_black_24dp);
                } else if (type != 4) {
                    this.f9913x.setImageResource(C1444R.C1445drawable.ic_directions_bus_black_24dp);
                } else {
                    this.f9913x.setImageResource(C1444R.C1445drawable.ic_train_black_24dp);
                }
            }
            this.f9913x.setVisibility(0);
            this.f9910u.setEnabled(true);
            m1027C();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            TripFragment.this.m1114a(z, this.f9915z);
        }

        /* renamed from: a */
        public final void m1025a(List<Line> list) {
            ViewGroup viewGroup = this.f9914y;
            int size = list.size();
            int childCount = viewGroup.getChildCount() - 1;
            int i = 0;
            while (i < childCount) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i2);
                if (i < size) {
                    childAt.setVisibility(0);
                    ((View$OnClickListenerC2445k) childAt.getTag()).m1024a(this.f9915z, list.get(i));
                } else {
                    childAt.setVisibility(8);
                }
                i = i2;
            }
            while (i < size) {
                View inflate = LayoutInflater.from(TripFragment.this.f9860b0).inflate(C1444R.layout.item_line, viewGroup, false);
                inflate.setTag(new View$OnClickListenerC2445k(inflate, this.f9915z, list.get(i)));
                viewGroup.addView(inflate);
                i++;
            }
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m1126a(DialogInterface dialogInterface, int i) {
        OngoingTrip m1404m = this.f9862d0.m1404m();
        if (m1404m != null) {
            m1404m.mo1299c();
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
        this.f9863e0.removeCallbacks(this.f9876r0);
        mo32a(c2358a);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
        this.f9867i0.m1023a(passing);
        m1129S0();
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        m1130R0();
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
        this.f9867i0.m1019f();
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStationListener
    /* renamed from: a */
    public void mo1123a(final NearbyStation nearbyStation) {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.k2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1097e(nearbyStation);
            }
        });
    }

    /* renamed from: a */
    public void m1114a(boolean z, NearbyStation nearbyStation) {
        if (z) {
            this.f9871m0 = nearbyStation.mo1304d();
            this.f9877s0 = true;
            this.f9877s0 = false;
            m1058z0();
        } else if (this.f9877s0) {
        } else {
            m1129S0();
        }
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo32a(final ErrorListener.C2358a c2358a) {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.v2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1111b(c2358a);
            }
        });
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: b */
    public void mo17b(ErrorListener.EnumC2360b enumC2360b) {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.l2
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1060y0();
            }
        });
    }

    /* renamed from: b */
    public static int m1107b(List<NearbyStation> list, NearbyStation nearbyStation) {
        int indexOf = list.indexOf(nearbyStation);
        if (indexOf != -1) {
            return indexOf;
        }
        try {
            String key = ((TipNearbyStation) nearbyStation).m1332h().getKey();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (key.equals(((TipNearbyStation) list.get(i)).m1332h().getKey())) {
                    return i;
                }
            }
        } catch (ClassCastException unused) {
        }
        return -1;
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo31a(ErrorListener.EnumC2360b enumC2360b) {
        this.f9863e0.post(new Runnable() { // from class: h.b.a.e.d.a3
            @Override // java.lang.Runnable
            public final void run() {
                TripFragment.this.m1062x0();
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m1124a(View view, View view2) {
        view.setOnClickListener(null);
        this.f9862d0.m1477N();
    }

    /* renamed from: a */
    public /* synthetic */ void m1125a(View view, int i, int i2) {
        this.f9863e0.findViewById(C1444R.C1446id.attentionLayout).setVisibility(0);
        m1112b(view, i, i2);
        view.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TripFragment.this.m1101d(view2);
            }
        });
    }

    /* renamed from: b */
    public final void m1112b(View view, int i, int i2) {
        ((TextView) this.f9863e0.findViewById(C1444R.C1446id.errorTitle)).setText(i);
        ((TextView) this.f9863e0.findViewById(C1444R.C1446id.errorDescription)).setText(Html.fromHtml(m7528a(i2)));
        ((TextView) this.f9863e0.findViewById(C1444R.C1446id.errorDescription)).setMovementMethod(LinkMovementMethod.getInstance());
        view.setVisibility(0);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo1127a(int i, int i2, Intent intent) {
        if (i != 101) {
            super.mo1127a(i, i2, intent);
        } else if (i2 == -1) {
            this.f9866h0.m1000n();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo872a(int i, String[] strArr, int[] iArr) {
        if (i == 2) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (iArr.length == 3 && iArr[0] == 0 && iArr[1] == 0 && iArr[2] == 0) {
                    this.f9874p0 = 0;
                    m1145C0();
                    if (!this.f9862d0.m1492A()) {
                        this.f9862d0.m1479L();
                    }
                    this.f9866h0.m1000n();
                    return;
                }
                return;
            } else if (iArr.length == 2 && iArr[0] == 0 && iArr[1] == 0) {
                this.f9874p0 = 0;
                m1145C0();
                if (!this.f9862d0.m1492A()) {
                    this.f9862d0.m1479L();
                }
                this.f9866h0.m1000n();
                return;
            } else {
                return;
            }
        }
        super.mo872a(i, strArr, iArr);
    }
}
