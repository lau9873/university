package p205h.p208b.p209a.p212e.p216d;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p065v4.widget.SwipeRefreshLayout;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.hbb20.C1444R;
import java.util.Calendar;
import java.util.Locale;
import p193g.p194a.p195a.p199n.ScanJobScheduler;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment;
import p205h.p208b.p209a.p212e.p218f.BaseItemView;

/* renamed from: h.b.a.e.d.i3 */
/* loaded from: classes.dex */
public abstract class AbstractTimeFramedListFragment extends AbstractHomeFragment implements OngoingTrip.InterfaceC2364c, SwipeRefreshLayout.InterfaceC0638j {

    /* renamed from: d0 */
    public Anda f9958d0;

    /* renamed from: e0 */
    public SwipeRefreshLayout f9959e0;

    /* renamed from: f0 */
    public RecyclerView f9960f0;

    /* renamed from: g0 */
    public AbstractC2464b f9961g0;

    /* renamed from: h0 */
    public int f9962h0 = -1;

    /* renamed from: i0 */
    public int f9963i0;

    /* renamed from: j0 */
    public Snackbar f9964j0;

    /* compiled from: AbstractTimeFramedListFragment.java */
    /* renamed from: h.b.a.e.d.i3$a */
    /* loaded from: classes.dex */
    public static class C2463a {

        /* renamed from: a */
        public final int f9965a;

        /* renamed from: b */
        public CharSequence f9966b;

        /* renamed from: c */
        public final int f9967c;

        /* renamed from: d */
        public CharSequence f9968d;

        /* renamed from: e */
        public int f9969e;

        public C2463a() {
            this(0, 0, null, 0);
        }

        public C2463a(CharSequence charSequence, int i) {
            this(0, 1, charSequence, i);
        }

        public C2463a(int i, CharSequence charSequence, int i2) {
            this.f9965a = 0;
            this.f9967c = i;
            this.f9968d = charSequence;
            this.f9969e = i2;
        }

        public C2463a(int i, int i2, CharSequence charSequence, int i3) {
            this.f9965a = i;
            this.f9967c = i2;
            this.f9968d = charSequence;
            this.f9969e = i3;
        }
    }

    /* compiled from: AbstractTimeFramedListFragment.java */
    /* renamed from: h.b.a.e.d.i3$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2464b extends RecyclerView.AbstractC0711g<BaseItemView> {
        /* renamed from: d */
        public abstract void mo961d(int i, int i2);
    }

    /* compiled from: AbstractTimeFramedListFragment.java */
    /* renamed from: h.b.a.e.d.i3$c */
    /* loaded from: classes.dex */
    public class C2465c extends BaseItemView implements AdapterView.OnItemSelectedListener {

        /* renamed from: u */
        public final Spinner f9970u;

        /* renamed from: v */
        public final Spinner f9971v;

        /* renamed from: w */
        public boolean f9972w;

        public C2465c(View view) {
            super(view);
            this.f9972w = false;
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
            arrayAdapter.setDropDownViewResource(C1444R.layout.support_simple_spinner_dropdown_item);
            this.f9970u = (Spinner) view.findViewById(C1444R.C1446id.month);
            this.f9970u.setAdapter((SpinnerAdapter) arrayAdapter);
            this.f9970u.setSelection(AbstractTimeFramedListFragment.this.f9962h0);
            this.f9970u.setOnItemSelectedListener(this);
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, 17367048);
            int i = calendar.get(1);
            for (int i2 = 2017; i2 <= i; i2++) {
                arrayAdapter2.add(String.valueOf(i2));
            }
            arrayAdapter2.setDropDownViewResource(C1444R.layout.support_simple_spinner_dropdown_item);
            this.f9971v = (Spinner) view.findViewById(C1444R.C1446id.year);
            this.f9971v.setAdapter((SpinnerAdapter) arrayAdapter2);
            this.f9971v.setSelection(AbstractTimeFramedListFragment.this.f9963i0 - 2017);
            this.f9971v.setOnItemSelectedListener(this);
            view.post(new Runnable() { // from class: h.b.a.e.d.d
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractTimeFramedListFragment.C2465c.this.m988C();
                }
            });
        }

        /* renamed from: C */
        public /* synthetic */ void m988C() {
            this.f9972w = true;
            AbstractTimeFramedListFragment.this.f9960f0.post(new Runnable() { // from class: h.b.a.e.d.c
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractTimeFramedListFragment.C2465c.this.m987D();
                }
            });
        }

        /* renamed from: D */
        public /* synthetic */ void m987D() {
            if (AbstractTimeFramedListFragment.this.f9961g0.mo747a() == 1) {
                onItemSelected(null, null, -1, 0L);
            }
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(C2463a c2463a) {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f9972w) {
                int selectedItemPosition = this.f9970u.getSelectedItemPosition();
                int selectedItemPosition2 = this.f9971v.getSelectedItemPosition() + 2017;
                AbstractTimeFramedListFragment abstractTimeFramedListFragment = AbstractTimeFramedListFragment.this;
                if (selectedItemPosition == abstractTimeFramedListFragment.f9962h0 && selectedItemPosition2 == abstractTimeFramedListFragment.f9963i0 && (abstractTimeFramedListFragment.f9959e0.m7315d() || AbstractTimeFramedListFragment.this.f9961g0.mo747a() > 1)) {
                    return;
                }
                Snackbar snackbar = AbstractTimeFramedListFragment.this.f9964j0;
                if (snackbar != null && snackbar.mo7620i()) {
                    AbstractTimeFramedListFragment.this.f9964j0.mo7623b();
                }
                AbstractTimeFramedListFragment abstractTimeFramedListFragment2 = AbstractTimeFramedListFragment.this;
                abstractTimeFramedListFragment2.f9962h0 = selectedItemPosition;
                abstractTimeFramedListFragment2.f9963i0 = selectedItemPosition2;
                abstractTimeFramedListFragment2.f9961g0.mo961d(selectedItemPosition, selectedItemPosition2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: c */
    public static /* synthetic */ void m990c(View view) {
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: U */
    public void mo897U() {
        Snackbar snackbar = this.f9964j0;
        if (snackbar != null) {
            snackbar.mo7623b();
        }
        this.f9958d0.m1435b(this);
        super.mo897U();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context m7452q = m7452q();
        View inflate = layoutInflater.inflate(C1444R.layout.fragment_swipe_refresh_layout, viewGroup, false);
        if (this.f9962h0 == -1) {
            Calendar calendar = Calendar.getInstance();
            this.f9962h0 = calendar.get(2);
            this.f9963i0 = calendar.get(1);
        } else if (bundle != null) {
            this.f9962h0 = bundle.getInt(ScanJobScheduler.f8608d);
            this.f9963i0 = bundle.getInt("y");
        }
        this.f9959e0 = (SwipeRefreshLayout) inflate.findViewById(C1444R.C1446id.layout);
        this.f9959e0.setClipChildren(false);
        this.f9959e0.setClipToPadding(false);
        this.f9959e0.setColorSchemeColors(-14664581, -15906911);
        this.f9959e0.setOnRefreshListener(this);
        this.f9960f0 = (RecyclerView) inflate.findViewById(C1444R.C1446id.list);
        this.f9960f0.setClipChildren(false);
        this.f9960f0.setClipToPadding(false);
        this.f9960f0.setLayoutManager(new LinearLayoutManager(m7452q));
        RecyclerView recyclerView = this.f9960f0;
        AbstractC2464b abstractC2464b = this.f9961g0;
        if (abstractC2464b == null) {
            abstractC2464b = mo965c(layoutInflater, viewGroup, bundle);
            this.f9961g0 = abstractC2464b;
        }
        recyclerView.setAdapter(abstractC2464b);
        return inflate;
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
    }

    /* renamed from: b */
    public void m991b(String str) {
        Snackbar snackbar = this.f9964j0;
        if (snackbar != null) {
            snackbar.mo7623b();
        }
        Snackbar m7626a = Snackbar.m7626a(this.f9959e0, str, -2);
        m7626a.m7629a(17039370, View$OnClickListenerC2393b.f9763a);
        m7626a.m7621f(-12532481);
        this.f9964j0 = m7626a;
        this.f9964j0.mo7619m();
    }

    /* renamed from: c */
    public abstract AbstractC2464b mo965c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f9958d0 = Anda.m1467X();
        this.f9958d0.m1450a(this);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        bundle.putInt(ScanJobScheduler.f8608d, this.f9962h0);
        bundle.putInt("y", this.f9963i0);
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment
    /* renamed from: p0 */
    public void mo892p0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9959e0.getLayoutParams();
        marginLayoutParams.bottomMargin = m995r0();
        this.f9959e0.setLayoutParams(marginLayoutParams);
        m997d(-1);
        m994s0().mo898b();
    }

    @Override // android.support.p065v4.widget.SwipeRefreshLayout.InterfaceC0638j
    /* renamed from: e */
    public void mo989e() {
        this.f9961g0.mo961d(this.f9962h0, this.f9963i0);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        mo989e();
    }
}
