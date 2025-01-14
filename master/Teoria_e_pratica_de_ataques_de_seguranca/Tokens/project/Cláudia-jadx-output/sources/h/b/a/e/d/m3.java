package h.b.a.e.d;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import h.b.a.d.b;
import h.b.a.d.f;
import h.b.a.d.l;
import h.b.a.d.o;
import h.b.a.e.d.i3;
import h.b.a.e.d.m3;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: HistoryFragment.java */
/* loaded from: classes.dex */
public class m3 extends i3 {
    public DateFormat k0;
    public a l0;

    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public static class b extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final long f7262f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7263g;

        public b(long j, int i2) {
            super(1, "", i2);
            this.f7263g = false;
            this.f7262f = j;
        }
    }

    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class c extends h.b.a.e.f.a implements View.OnClickListener {
        public final TextView u;
        public final TextView v;
        public final ImageButton w;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131231149);
            this.v = (TextView) view.findViewById(2131230855);
            this.w = (ImageButton) view.findViewById(2131230914);
            this.w.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            b bVar = (b) aVar;
            this.u.setText(DateUtils.formatDateTime(this.f2580a.getContext(), bVar.f7262f, 18));
            TextView textView = this.v;
            Resources resources = textView.getResources();
            int i2 = aVar.f7218e;
            textView.setText(resources.getQuantityString(2131623936, i2, Integer.valueOf(i2)));
            this.w.setImageResource(bVar.f7263g ? 2131165590 : 2131165588);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int h2 = h();
            if (h2 != -1) {
                m3.this.l0.g(h2);
            }
        }
    }

    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public static class d extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f7264f;

        /* renamed from: g  reason: collision with root package name */
        public final CharSequence f7265g;

        /* renamed from: h  reason: collision with root package name */
        public final long f7266h;

        /* renamed from: i  reason: collision with root package name */
        public final long f7267i;
        public final h.b.a.d.k j;
        public final h.b.a.d.l k;

        public d(int i2, h.b.a.d.l lVar, h.b.a.d.k kVar, CharSequence charSequence, CharSequence charSequence2, long j, CharSequence charSequence3, long j2) {
            super(2, charSequence, i2);
            this.k = lVar;
            this.j = kVar;
            this.f7265g = charSequence2;
            this.f7267i = j;
            this.f7264f = charSequence3;
            this.f7266h = j2;
        }
    }

    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class e extends h.b.a.e.f.a {
        public final TextView A;
        public final TextView B;
        public final h.b.a.e.c.c C;
        public final ImageView u;
        public final TextView v;
        public final TextView w;
        public final TextView x;
        public final TextView y;
        public final TextView z;

        public e(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(2131230914);
            this.C = new h.b.a.e.c.c();
            this.v = (TextView) view.findViewById(2131231149);
            this.v.setBackground(this.C);
            this.w = (TextView) view.findViewById(2131230898);
            this.x = (TextView) view.findViewById(2131230899);
            this.y = (TextView) view.findViewById(2131230870);
            this.z = (TextView) view.findViewById(2131231087);
            this.A = (TextView) view.findViewById(2131231088);
            this.B = (TextView) view.findViewById(2131230872);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            d dVar = (d) aVar;
            DataModels.StageInfo d2 = dVar.j.d();
            this.u.setImageResource(dVar.f7218e);
            h.b.a.d.k kVar = dVar.j;
            if (kVar != null && kVar.a().length() != 0) {
                this.v.setText(dVar.f7217d);
                this.C.a(dVar.k, dVar.j);
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(4);
            }
            this.w.setText(dVar.f7264f);
            this.x.setText(dVar.f7265g);
            this.y.setText(m3.this.k0.format(Long.valueOf(dVar.f7266h)));
            this.z.setText(m3.this.k0.format(Long.valueOf(dVar.f7267i)));
            this.A.setText(d2.getStartZoneName());
            this.B.setText(d2.getFinishZoneName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void Z() {
        super.Z();
        this.k0 = o0();
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

    @Override // h.b.a.e.d.i3
    public i3.b c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a aVar = new a();
        this.l0 = aVar;
        return aVar;
    }

    @Override // h.b.a.d.o.c
    public void c(h.b.a.d.o oVar) {
    }

    /* compiled from: HistoryFragment.java */
    /* loaded from: classes.dex */
    public class a extends i3.b implements b.a<List<h.b.a.d.w>>, Runnable {

        /* renamed from: c  reason: collision with root package name */
        public final List<i3.a> f7258c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final List<i3.a> f7259d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public List<h.b.a.d.w> f7260e;

        public a() {
            this.f7258c.add(new i3.a());
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<List<h.b.a.d.w>> bVar) {
            if (m3.this.j() == null) {
                return;
            }
            if (bVar instanceof b.AbstractC0157b) {
                b.AbstractC0157b abstractC0157b = (b.AbstractC0157b) bVar;
                if (abstractC0157b.d() != null) {
                    m3.this.b(abstractC0157b.d().c());
                }
            }
            this.f7260e = bVar.a();
            Collections.sort(this.f7260e, j.f7219a);
            m3.this.e0.post(this);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int c(int i2) {
            return this.f7258c.get(i2).f7216c;
        }

        @Override // h.b.a.e.d.i3.b
        public void d(int i2, int i3) {
            m3.this.e0.setRefreshing(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(i3, i2, 1, 0, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(2, 1);
            m3.this.d0.o().d().a(timeInMillis, calendar.getTimeInMillis()).a(this);
        }

        public final void e() {
            List<i3.a> list = this.f7258c;
            list.clear();
            boolean z = true;
            for (i3.a aVar : this.f7259d) {
                if (aVar.f7216c == 1) {
                    list.add(aVar);
                    z = ((b) aVar).f7263g;
                } else if (z) {
                    list.add(aVar);
                }
            }
        }

        public void g(int i2) {
            i3.a aVar = this.f7258c.get(i2);
            if (aVar.f7216c == 1) {
                b bVar = (b) aVar;
                int i3 = i2 + 1;
                bVar.f7263g = !bVar.f7263g;
                int i4 = 0;
                if (!bVar.f7263g) {
                    while (i3 < this.f7258c.size() && this.f7258c.get(i3).f7216c == 2) {
                        this.f7258c.remove(i3);
                        i4++;
                    }
                    d(i3 - 1);
                    c(i3, i4);
                    return;
                }
                int indexOf = this.f7259d.indexOf(aVar);
                while (true) {
                    indexOf++;
                    if (indexOf >= this.f7259d.size() || this.f7259d.get(indexOf).f7216c != 2) {
                        break;
                    }
                    this.f7258c.add(i3, this.f7259d.get(indexOf));
                    i4++;
                    i3++;
                }
                int i5 = i3 - i4;
                d(i5 - 1);
                b(i5, i4);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = 0;
            m3.this.e0.setRefreshing(false);
            final List<i3.a> list = this.f7259d;
            c(1, this.f7258c.size() - 1);
            list.clear();
            List<h.b.a.d.w> list2 = this.f7260e;
            this.f7260e = null;
            Calendar calendar = Calendar.getInstance();
            list.add(this.f7258c.get(0));
            int size = list2.size() - 1;
            int i3 = -1;
            b bVar = null;
            while (size >= 0) {
                h.b.a.d.w wVar = list2.get(size);
                long e2 = wVar.e();
                calendar.setTimeInMillis(e2);
                if (i3 != calendar.get(5)) {
                    b bVar2 = new b(e2, i2);
                    list.add(bVar2);
                    bVar = bVar2;
                    i3 = calendar.get(5);
                }
                h.b.a.d.k h2 = wVar.h();
                h.b.a.d.q f2 = wVar.f();
                h.b.a.d.p b2 = wVar.b();
                list.add(new d(b2 == null ? 0 : b2.c(), b2 == null ? new l.a() : b2.e(), h2, h2 == null ? null : h2.c(), wVar.c().d().a(), e2, f2.d().a(), f2.a()));
                if (bVar != null) {
                    bVar.f7218e++;
                }
                size--;
                i2 = 0;
            }
            e();
            b(1, a() - 1);
            m3.this.e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.k
                @Override // java.lang.Runnable
                public final void run() {
                    m3.a.this.a(list);
                }
            }, 300L);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public h.b.a.e.f.a b(ViewGroup viewGroup, int i2) {
            if (i2 == 2) {
                m3 m3Var = m3.this;
                return new e(LayoutInflater.from(m3Var.b0).inflate(2131427402, viewGroup, false));
            } else if (i2 == 1) {
                m3 m3Var2 = m3.this;
                return new c(LayoutInflater.from(m3Var2.b0).inflate(2131427400, viewGroup, false));
            } else if (i2 == 0) {
                m3 m3Var3 = m3.this;
                return new i3.c(LayoutInflater.from(m3Var3.b0).inflate(2131427401, viewGroup, false));
            } else {
                return null;
            }
        }

        public static /* synthetic */ int a(h.b.a.d.w wVar, h.b.a.d.w wVar2) {
            return (int) (wVar.e() - wVar2.e());
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h.b.a.e.f.a aVar, int i2) {
            aVar.a(this.f7258c.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            return this.f7258c.size();
        }

        public /* synthetic */ void a(List list) {
            if (list.size() > 2) {
                m3.this.l0.g(1);
            }
        }
    }
}
