package h.b.a.e.d;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import h.b.a.d.o;
import h.b.a.e.d.i3;
import java.util.Calendar;
import java.util.Locale;
/* compiled from: AbstractTimeFramedListFragment.java */
/* loaded from: classes.dex */
public abstract class i3 extends h3 implements o.c, SwipeRefreshLayout.j {
    public h.b.a.c d0;
    public SwipeRefreshLayout e0;
    public RecyclerView f0;
    public b g0;
    public int h0 = -1;
    public int i0;
    public Snackbar j0;

    /* compiled from: AbstractTimeFramedListFragment.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7214a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f7215b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7216c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f7217d;

        /* renamed from: e  reason: collision with root package name */
        public int f7218e;

        public a() {
            this(0, 0, null, 0);
        }

        public a(CharSequence charSequence, int i2) {
            this(0, 1, charSequence, i2);
        }

        public a(int i2, CharSequence charSequence, int i3) {
            this.f7214a = 0;
            this.f7216c = i2;
            this.f7217d = charSequence;
            this.f7218e = i3;
        }

        public a(int i2, int i3, CharSequence charSequence, int i4) {
            this.f7214a = i2;
            this.f7216c = i3;
            this.f7217d = charSequence;
            this.f7218e = i4;
        }
    }

    /* compiled from: AbstractTimeFramedListFragment.java */
    /* loaded from: classes.dex */
    public static abstract class b extends RecyclerView.g<h.b.a.e.f.a> {
        public abstract void d(int i2, int i3);
    }

    /* compiled from: AbstractTimeFramedListFragment.java */
    /* loaded from: classes.dex */
    public class c extends h.b.a.e.f.a implements AdapterView.OnItemSelectedListener {
        public final Spinner u;
        public final Spinner v;
        public boolean w;

        public c(View view) {
            super(view);
            this.w = false;
            Context context = view.getContext();
            Calendar calendar = Calendar.getInstance();
            Locale locale = Locale.getDefault();
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048);
            int maximum = calendar.getMaximum(2);
            calendar.set(5, 1);
            for (int minimum = calendar.getMinimum(2); minimum <= maximum; minimum++) {
                calendar.set(2, minimum);
                arrayAdapter.add(calendar.getDisplayName(2, 2, locale));
            }
            arrayAdapter.setDropDownViewResource(2131427454);
            this.u = (Spinner) view.findViewById(2131230967);
            this.u.setAdapter((SpinnerAdapter) arrayAdapter);
            this.u.setSelection(i3.this.h0);
            this.u.setOnItemSelectedListener(this);
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, 17367048);
            int i2 = calendar.get(1);
            for (int i3 = 2017; i3 <= i2; i3++) {
                arrayAdapter2.add(String.valueOf(i3));
            }
            arrayAdapter2.setDropDownViewResource(2131427454);
            this.v = (Spinner) view.findViewById(2131231188);
            this.v.setAdapter((SpinnerAdapter) arrayAdapter2);
            this.v.setSelection(i3.this.i0 - 2017);
            this.v.setOnItemSelectedListener(this);
            view.post(new Runnable() { // from class: h.b.a.e.d.d
                @Override // java.lang.Runnable
                public final void run() {
                    i3.c.this.C();
                }
            });
        }

        public /* synthetic */ void C() {
            this.w = true;
            i3.this.f0.post(new Runnable() { // from class: h.b.a.e.d.c
                @Override // java.lang.Runnable
                public final void run() {
                    i3.c.this.D();
                }
            });
        }

        public /* synthetic */ void D() {
            if (i3.this.g0.a() == 1) {
                onItemSelected(null, null, -1, 0L);
            }
        }

        @Override // h.b.a.e.f.a
        public void a(a aVar) {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            if (this.w) {
                int selectedItemPosition = this.u.getSelectedItemPosition();
                int selectedItemPosition2 = this.v.getSelectedItemPosition() + 2017;
                i3 i3Var = i3.this;
                if (selectedItemPosition == i3Var.h0 && selectedItemPosition2 == i3Var.i0 && (i3Var.e0.d() || i3.this.g0.a() > 1)) {
                    return;
                }
                Snackbar snackbar = i3.this.j0;
                if (snackbar != null && snackbar.i()) {
                    i3.this.j0.b();
                }
                i3 i3Var2 = i3.this;
                i3Var2.h0 = selectedItemPosition;
                i3Var2.i0 = selectedItemPosition2;
                i3Var2.g0.d(selectedItemPosition, selectedItemPosition2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static /* synthetic */ void c(View view) {
    }

    @Override // android.support.v4.app.Fragment
    public void U() {
        Snackbar snackbar = this.j0;
        if (snackbar != null) {
            snackbar.b();
        }
        this.d0.b(this);
        super.U();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context q = q();
        View inflate = layoutInflater.inflate(2131427391, viewGroup, false);
        if (this.h0 == -1) {
            Calendar calendar = Calendar.getInstance();
            this.h0 = calendar.get(2);
            this.i0 = calendar.get(1);
        } else if (bundle != null) {
            this.h0 = bundle.getInt(g.a.a.n.m.f6144d);
            this.i0 = bundle.getInt("y");
        }
        this.e0 = (SwipeRefreshLayout) inflate.findViewById(2131230938);
        this.e0.setClipChildren(false);
        this.e0.setClipToPadding(false);
        this.e0.setColorSchemeColors(-14664581, -15906911);
        this.e0.setOnRefreshListener(this);
        this.f0 = (RecyclerView) inflate.findViewById(2131230947);
        this.f0.setClipChildren(false);
        this.f0.setClipToPadding(false);
        this.f0.setLayoutManager(new LinearLayoutManager(q));
        RecyclerView recyclerView = this.f0;
        b bVar = this.g0;
        if (bVar == null) {
            bVar = c(layoutInflater, viewGroup, bundle);
            this.g0 = bVar;
        }
        recyclerView.setAdapter(bVar);
        return inflate;
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, h.b.a.d.q qVar) {
    }

    public void b(String str) {
        Snackbar snackbar = this.j0;
        if (snackbar != null) {
            snackbar.b();
        }
        Snackbar a2 = Snackbar.a(this.e0, str, -2);
        a2.a(17039370, h.b.a.e.d.b.f7103a);
        a2.f(-12532481);
        this.j0 = a2;
        this.j0.m();
    }

    public abstract b c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    @Override // h.b.a.e.d.h3, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.d0 = h.b.a.c.X();
        this.d0.a(this);
    }

    @Override // h.b.a.d.o.c
    public void d(h.b.a.d.o oVar) {
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt(g.a.a.n.m.f6144d, this.h0);
        bundle.putInt("y", this.i0);
    }

    @Override // h.b.a.e.d.h3
    public void p0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e0.getLayoutParams();
        marginLayoutParams.bottomMargin = r0();
        this.e0.setLayoutParams(marginLayoutParams);
        d(-1);
        s0().b();
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.j
    public void e() {
        this.g0.d(this.h0, this.i0);
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.a aVar) {
        e();
    }
}
