package h.b.a.e.d;

import a.b.g.a.y;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import h.b.a.d.b;
import h.b.a.d.f;
import h.b.a.d.o;
import h.b.a.e.d.i3;
import h.b.a.e.d.k3;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.activity.MainActivity;
/* compiled from: FaresFragment.java */
/* loaded from: classes.dex */
public class k3 extends i3 implements h.b.a.d.j {
    public a k0;
    public String l0;
    @SuppressLint({"SimpleDateFormat"})
    public final SimpleDateFormat m0 = new SimpleDateFormat("EE, dd");
    public DateFormat n0;

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public class a extends i3.b implements b.a<h.b.a.d.c> {

        /* renamed from: c  reason: collision with root package name */
        public final List<i3.a> f7230c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final List<i3.a> f7231d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public final float f7232e;

        public a() {
            this.f7231d.add(new i3.a());
            this.f7232e = TypedValue.applyDimension(1, 1.0f, k3.this.B().getDisplayMetrics());
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int c(int i2) {
            return this.f7231d.get(i2).f7216c;
        }

        @Override // h.b.a.e.d.i3.b
        public void d(int i2, int i3) {
            k3.this.e0.setRefreshing(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(i3, i2, 1, 0, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(2, 1);
            k3.this.d0.o().a(timeInMillis, calendar.getTimeInMillis()).a(this);
        }

        public final void e() {
            List<i3.a> list = this.f7231d;
            list.clear();
            boolean z = true;
            for (i3.a aVar : this.f7230c) {
                int i2 = aVar.f7216c;
                if (i2 == 1 || i2 == 4) {
                    list.add(aVar);
                    z = ((b) aVar).f7234f;
                } else if (z || (i2 != 2 && i2 != 5)) {
                    list.add(aVar);
                }
            }
        }

        public void g(int i2) {
            int i3;
            int i4;
            i3.a aVar = this.f7231d.get(i2);
            int i5 = aVar.f7216c;
            if (i5 == 1 || i5 == 4) {
                b bVar = (b) aVar;
                int i6 = 0;
                int i7 = i2 + 1;
                boolean z = bVar.f7234f;
                bVar.f7234f = !z;
                if (z) {
                    while (i7 < this.f7231d.size() && ((i4 = this.f7231d.get(i7).f7216c) == 2 || i4 == 5)) {
                        i6++;
                        this.f7231d.remove(i7);
                    }
                    d(i7 - 1);
                    c(i7, i6);
                    return;
                }
                int indexOf = this.f7230c.indexOf(aVar);
                while (true) {
                    indexOf++;
                    if (indexOf >= this.f7230c.size() || !((i3 = this.f7230c.get(indexOf).f7216c) == 2 || i3 == 5)) {
                        break;
                    }
                    i6++;
                    this.f7231d.add(i7, this.f7230c.get(indexOf));
                    i7++;
                }
                int i8 = i7 - i6;
                d(i8 - 1);
                b(i8, i6);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h.b.a.e.f.a aVar, int i2) {
            aVar.a(this.f7231d.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            return this.f7231d.size();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public h.b.a.e.f.a b(ViewGroup viewGroup, int i2) {
            if (i2 == 2) {
                k3 k3Var = k3.this;
                return new g(LayoutInflater.from(k3Var.b0).inflate(2131427402, viewGroup, false));
            } else if (i2 == 1) {
                k3 k3Var2 = k3.this;
                return new c(LayoutInflater.from(k3Var2.b0).inflate(2131427396, viewGroup, false), false);
            } else if (i2 == 0) {
                k3 k3Var3 = k3.this;
                return new i3.c(LayoutInflater.from(k3Var3.b0).inflate(2131427401, viewGroup, false));
            } else if (i2 == 3) {
                k3 k3Var4 = k3.this;
                return new i(LayoutInflater.from(k3Var4.b0).inflate(2131427395, viewGroup, false));
            } else if (i2 == 4) {
                k3 k3Var5 = k3.this;
                return new c(LayoutInflater.from(k3Var5.b0).inflate(2131427398, viewGroup, false), true);
            } else if (i2 == 5) {
                k3 k3Var6 = k3.this;
                return new e(LayoutInflater.from(k3Var6.b0).inflate(2131427397, viewGroup, false));
            } else {
                return null;
            }
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<h.b.a.d.c> bVar) {
            if (k3.this.j() == null || k3.this.b0 == null) {
                return;
            }
            if (bVar instanceof b.AbstractC0157b) {
                b.AbstractC0157b abstractC0157b = (b.AbstractC0157b) bVar;
                if (abstractC0157b.d() != null) {
                    k3.this.b(abstractC0157b.d().c());
                }
            }
            h.b.a.d.c a2 = bVar.a();
            final List<i3.a> list = this.f7230c;
            c(1, this.f7231d.size() - 1);
            list.clear();
            list.add(new i3.a());
            if (a2 == null) {
                e();
                k3.this.e0.setRefreshing(false);
                return;
            }
            double d2 = 0.0d;
            List<h.b.a.d.d> a3 = a2.a();
            List<h.b.a.d.i> b2 = a2.b();
            Collections.sort(a3, h.b.a.e.d.g.f7157a);
            Collections.sort(b2, h.b.a.e.d.f.f7136a);
            b bVar2 = null;
            boolean z = true;
            for (h.b.a.d.d dVar : a3) {
                if (bVar2 == null || !bVar2.f7217d.equals(dVar.a())) {
                    bVar2 = new b(dVar.a());
                    list.add(bVar2);
                    z = true;
                }
                double b3 = dVar.b();
                double d3 = d2 + b3;
                bVar2.a(b3);
                for (h.b.a.d.w wVar : dVar.c()) {
                    h.b.a.d.q c2 = wVar.c();
                    h.b.a.d.q f2 = wVar.f();
                    h.b.a.d.v d4 = f2.d();
                    h.b.a.d.v d5 = c2.d();
                    h.b.a.d.p b4 = wVar.b();
                    h.b.a.d.k h2 = wVar.h();
                    StringBuilder sb = new StringBuilder();
                    sb.append(d4.a());
                    double d6 = d3;
                    sb.append(d4.e() == null ? "" : " " + d4.e().a());
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(d5.a());
                    sb3.append(d5.e() != null ? " " + d5.e().a() : "");
                    f fVar = new f(b4, h2, sb2, sb3.toString(), c2.a(), f2.a(), z, wVar.g());
                    if (wVar.g()) {
                        h.b.a.d.q k = wVar.k();
                        h.b.a.d.q j = wVar.j();
                        h.b.a.d.v d7 = k.d();
                        h.b.a.d.v d8 = j.d();
                        fVar.a(d7.c());
                        fVar.b(d8.c());
                    }
                    list.add(fVar);
                    d3 = d6;
                }
                z = !z;
                d2 = d3;
            }
            list.add(new h(k3.this, 2131755075, (int) Math.round(d2 * 100.0d), 2131755076, 10));
            list.add(new b(4, 2131755073, b2.size(), true));
            if (b2.size() > 0) {
                for (h.b.a.d.i iVar : b2) {
                    list.add(new d(iVar.e(), iVar.c(), iVar.a(), iVar.b(), iVar.d(), true));
                }
            }
            e();
            b(1, a() - 1);
            k3.this.e0.setRefreshing(false);
            k3.this.e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.e
                @Override // java.lang.Runnable
                public final void run() {
                    k3.a.this.a(list);
                }
            }, 400L);
        }

        public static /* synthetic */ int a(h.b.a.d.d dVar, h.b.a.d.d dVar2) {
            String a2 = dVar.a();
            String a3 = dVar2.a();
            if (a2 == null) {
                return -1;
            }
            if (a3 == null) {
                return 1;
            }
            return a2.compareTo(a3);
        }

        public /* synthetic */ void a(List list) {
            if (list.size() == 4) {
                g(1);
            }
            g(3);
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public class c extends h.b.a.e.f.a implements View.OnClickListener {
        public final TextView u;
        public final TextView v;
        public final TextView w;
        public final ImageButton x;
        public final h.b.a.e.c.b y;

        public c(View view, boolean z) {
            super(view);
            this.u = (TextView) view.findViewById(2131231149);
            this.v = (TextView) view.findViewById(2131230855);
            this.w = (TextView) view.findViewById(2131231008);
            this.y = new h.b.a.e.c.b(k3.this.k0.f7232e);
            view.setBackground(this.y);
            this.x = (ImageButton) view.findViewById(2131230914);
            if (z) {
                this.y.f7088b = true;
            }
            ImageButton imageButton = this.x;
            if (imageButton != null) {
                imageButton.setOnClickListener(this);
                view.setOnClickListener(this);
            }
        }

        @Override // h.b.a.e.f.a
        @SuppressLint({"SetTextI18n"})
        public void a(i3.a aVar) {
            b bVar = (b) aVar;
            if (bVar.f7235g) {
                this.u.setText(String.format(Locale.getDefault(), "%s (%d)", k3.this.b0.getString(bVar.f7218e), Integer.valueOf(bVar.f7236h)));
            } else {
                this.u.setText(aVar.f7217d);
            }
            TextView textView = this.v;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(aVar.f7218e / 100.0f)));
            }
            if (this.x != null) {
                TextView textView2 = this.w;
                if (textView2 != null) {
                    textView2.setText(bVar.f7236h + "x");
                }
                this.x.setImageResource(bVar.f7234f ? 2131165590 : 2131165588);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int h2 = h();
            if (h2 != -1) {
                k3.this.k0.g(h2);
            }
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public static class d extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f7237f;

        /* renamed from: g  reason: collision with root package name */
        public final CharSequence f7238g;

        /* renamed from: h  reason: collision with root package name */
        public final CharSequence f7239h;

        /* renamed from: i  reason: collision with root package name */
        public final Date f7240i;
        public final float j;

        public d(CharSequence charSequence, CharSequence charSequence2, Date date, float f2, CharSequence charSequence3, boolean z) {
            super(5, charSequence, 0);
            this.f7237f = charSequence;
            this.f7238g = charSequence2;
            this.f7240i = date;
            this.j = f2;
            this.f7239h = charSequence3;
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public static class f extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f7241f;

        /* renamed from: g  reason: collision with root package name */
        public final CharSequence f7242g;

        /* renamed from: h  reason: collision with root package name */
        public final long f7243h;

        /* renamed from: i  reason: collision with root package name */
        public final long f7244i;
        public CharSequence j;
        public CharSequence k;
        public final boolean l;
        public final h.b.a.d.k m;
        public final boolean n;

        public f(h.b.a.d.p pVar, h.b.a.d.k kVar, CharSequence charSequence, CharSequence charSequence2, long j, long j2, boolean z, boolean z2) {
            super(2, kVar == null ? "" : kVar.c(), pVar == null ? 0 : pVar.c());
            this.m = kVar;
            this.f7241f = charSequence;
            this.f7242g = charSequence2;
            this.f7243h = j2;
            this.f7244i = j;
            this.n = z;
            this.l = z2;
        }

        public void a(CharSequence charSequence) {
            this.j = charSequence;
        }

        public void b(CharSequence charSequence) {
            this.k = charSequence;
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public class g extends h.b.a.e.f.a implements View.OnClickListener {
        public final ImageView A;
        public final h.b.a.e.c.c B;
        public f C;
        public final ImageView u;
        public final TextView v;
        public final TextView w;
        public final TextView x;
        public final TextView y;
        public final TextView z;

        public g(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(2131230914);
            this.B = new h.b.a.e.c.c();
            this.v = (TextView) view.findViewById(2131231149);
            this.v.setBackground(this.B);
            this.w = (TextView) view.findViewById(2131230898);
            this.x = (TextView) view.findViewById(2131230899);
            this.y = (TextView) view.findViewById(2131230870);
            this.z = (TextView) view.findViewById(2131231087);
            this.A = (ImageView) view.findViewById(2131231116);
            this.A.setOnClickListener(this);
        }

        @Override // h.b.a.e.f.a
        @SuppressLint({"SetTextI18n"})
        public void a(i3.a aVar) {
            f fVar = (f) aVar;
            this.C = fVar;
            this.u.setImageResource(fVar.f7218e);
            if (fVar.f7217d.length() == 0) {
                this.v.setVisibility(4);
            } else {
                this.v.setText(fVar.f7217d);
                this.B.a(fVar.m);
                this.v.setVisibility(0);
            }
            this.w.setText(fVar.f7241f);
            this.x.setText(fVar.f7242g);
            this.y.setText(k3.this.m0.format(Long.valueOf(fVar.f7244i)));
            TextView textView = this.z;
            textView.setText(k3.this.n0.format(Long.valueOf(fVar.f7244i)) + " • " + k3.this.n0.format(Long.valueOf(fVar.f7243h)));
            if (fVar.l) {
                if (this.A.getVisibility() == 8) {
                    this.A.setVisibility(0);
                }
            } else {
                this.A.setVisibility(8);
            }
            if (fVar.n) {
                this.f2580a.setBackground(null);
            } else {
                this.f2580a.setBackgroundColor(268435456);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == this.A.getId()) {
                if (this.C != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(k3.this.b0);
                    builder.setTitle(k3.this.b0.getString(2131755288));
                    builder.setMessage(String.format("%s %s %s %s", k3.this.b0.getString(2131755255), this.C.j, k3.this.b0.getString(2131755345), this.C.k));
                    builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
                    builder.show();
                    return;
                }
                Log.d("FaresFragment.class", "FaresTripItemView is null. It will not show the AlertDialog");
            }
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public class h extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final int f7245f;

        /* renamed from: g  reason: collision with root package name */
        public final int f7246g;

        /* renamed from: h  reason: collision with root package name */
        public final int f7247h;

        public h(k3 k3Var, int i2, int i3, int i4, int i5) {
            super(3, "", i3);
            this.f7245f = i4;
            this.f7246g = i2;
            this.f7247h = i5;
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public class i extends h.b.a.e.f.a {
        public final TextView u;
        public final TextView v;
        public final TextView w;
        public final TextView x;
        public final h.b.a.e.c.b y;

        public i(View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131231149);
            this.v = (TextView) view.findViewById(2131230855);
            this.w = (TextView) view.findViewById(2131230882);
            this.x = (TextView) view.findViewById(2131230881);
            this.y = new h.b.a.e.c.b(k3.this.k0.f7232e);
            h.b.a.e.c.b bVar = this.y;
            bVar.f7088b = true;
            view.setBackground(bVar);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            h hVar = (h) aVar;
            this.u.setText(k3.this.b0.getString(hVar.f7246g));
            this.w.setText(k3.this.b0.getString(hVar.f7245f));
            TextView textView = this.v;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(hVar.f7218e / 100.0f)));
            }
            TextView textView2 = this.x;
            if (textView2 != null) {
                textView2.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(hVar.f7247h / 100.0f)));
            }
        }
    }

    public k3() {
        h.b.a.c.b(this.b0).a((h.b.a.d.j) this);
    }

    @Override // android.support.v4.app.Fragment
    public void Z() {
        super.Z();
        this.n0 = o0();
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, f.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.c.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void b(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void c(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.e.d.i3
    public i3.b c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a aVar = new a();
        this.k0 = aVar;
        return aVar;
    }

    @Override // h.b.a.d.j
    public void a(long j, String str) {
        Context context = this.b0;
        y.c cVar = new y.c(context, context.getString(2131755063));
        cVar.b(this.b0.getString(2131755063));
        cVar.c(2131165597);
        cVar.a(-13615201);
        cVar.b(this.b0.getString(2131755063));
        cVar.d(1);
        cVar.b((CharSequence) this.b0.getString(2131755334));
        cVar.c((CharSequence) this.b0.getString(2131755334));
        cVar.c("pt.opt.anda.INVOICE_DOWNLOAD");
        cVar.a((CharSequence) new File(str).getName());
        Context context2 = this.b0;
        cVar.a(PendingIntent.getActivity(context2, 300, MainActivity.a(context2, str, "pt.opt.anda.InvoiceProvider"), 134217728));
        Notification a2 = cVar.a();
        a2.flags |= 16;
        NotificationManager notificationManager = (NotificationManager) this.b0.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify((int) j, a2);
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public static class b extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public boolean f7234f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7235g;

        /* renamed from: h  reason: collision with root package name */
        public int f7236h;

        public b(String str) {
            super(str == null ? "" : str, 0);
            this.f7234f = false;
            this.f7235g = false;
            this.f7236h = 0;
        }

        public void a(double d2) {
            this.f7218e = (int) (this.f7218e + Math.round(d2 * 100.0d));
            this.f7236h++;
        }

        public b(int i2, int i3, int i4, boolean z) {
            super(i2, "", i3);
            this.f7234f = false;
            this.f7235g = false;
            this.f7236h = i4;
            this.f7235g = z;
        }
    }

    /* compiled from: FaresFragment.java */
    /* loaded from: classes.dex */
    public class e extends h.b.a.e.f.a implements View.OnClickListener {
        public final ImageButton u;
        public final ImageButton v;
        public final TextView w;
        public final TextView x;
        public final TextView y;
        public final SimpleDateFormat z;

        public e(View view) {
            super(view);
            this.z = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            this.u = (ImageButton) view.findViewById(2131230865);
            this.v = (ImageButton) view.findViewById(2131231065);
            this.w = (TextView) view.findViewById(2131230971);
            this.x = (TextView) view.findViewById(2131230852);
            this.y = (TextView) view.findViewById(2131231001);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            final d dVar = (d) aVar;
            this.w.setText(dVar.f7237f);
            this.x.setText(this.z.format(dVar.f7240i));
            this.y.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(dVar.j)));
            this.v.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k3.e.this.a(dVar, view);
                }
            });
            this.u.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k3.e.this.b(dVar, view);
                }
            });
        }

        public /* synthetic */ void b(d dVar, View view) {
            if (a.b.g.b.b.a(k3.this.b0, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                k3.this.l0 = dVar.f7238g.toString();
                k3.this.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
                return;
            }
            h.b.a.c.b(k3.this.b0).a(dVar.f7238g.toString());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        public /* synthetic */ void a(d dVar, View view) {
            Toast.makeText(k3.this.b0, 2131755262, 0).show();
            BackEnd.sendInvoiceEmail(dVar.f7239h.toString(), new l3(this));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, String[] strArr, int[] iArr) {
        if (i2 == 3 && iArr.length > 0 && iArr[0] == 0) {
            h.b.a.c.b(this.b0).a(this.l0);
        }
    }
}
