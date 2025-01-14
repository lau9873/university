package p205h.p208b.p209a.p212e.p216d;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbb20.C1444R;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.LineFormatter;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p212e.p215c.LineDrawable;
import p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment;
import p205h.p208b.p209a.p212e.p216d.HistoryFragment;
import p205h.p208b.p209a.p212e.p218f.BaseItemView;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.m3 */
/* loaded from: classes.dex */
public class HistoryFragment extends AbstractTimeFramedListFragment {

    /* renamed from: k0 */
    public DateFormat f10056k0;

    /* renamed from: l0 */
    public RunnableC2492a f10057l0;

    /* compiled from: HistoryFragment.java */
    /* renamed from: h.b.a.e.d.m3$b */
    /* loaded from: classes.dex */
    public static class C2493b extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final long f10062f;

        /* renamed from: g */
        public boolean f10063g;

        public C2493b(long j, int i) {
            super(1, "", i);
            this.f10063g = false;
            this.f10062f = j;
        }
    }

    /* compiled from: HistoryFragment.java */
    /* renamed from: h.b.a.e.d.m3$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2494c extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public final TextView f10064u;

        /* renamed from: v */
        public final TextView f10065v;

        /* renamed from: w */
        public final ImageButton f10066w;

        public View$OnClickListenerC2494c(View view) {
            super(view);
            this.f10064u = (TextView) view.findViewById(C1444R.C1446id.title);
            this.f10065v = (TextView) view.findViewById(C1444R.C1446id.description);
            this.f10066w = (ImageButton) view.findViewById(C1444R.C1446id.icon);
            this.f10066w.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2493b c2493b = (C2493b) c2463a;
            this.f10064u.setText(DateUtils.formatDateTime(this.f4213a.getContext(), c2493b.f10062f, 18));
            TextView textView = this.f10065v;
            Resources resources = textView.getResources();
            int i = c2463a.f9969e;
            textView.setText(resources.getQuantityString(C1444R.plurals.tripX, i, Integer.valueOf(i)));
            this.f10066w.setImageResource(c2493b.f10063g ? C1444R.C1445drawable.ic_keyboard_arrow_up_black_24dp : C1444R.C1445drawable.ic_keyboard_arrow_down_black_24dp);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int m6807h = m6807h();
            if (m6807h != -1) {
                HistoryFragment.this.f10057l0.m959g(m6807h);
            }
        }
    }

    /* compiled from: HistoryFragment.java */
    /* renamed from: h.b.a.e.d.m3$d */
    /* loaded from: classes.dex */
    public static class C2495d extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final CharSequence f10068f;

        /* renamed from: g */
        public final CharSequence f10069g;

        /* renamed from: h */
        public final long f10070h;

        /* renamed from: i */
        public final long f10071i;

        /* renamed from: j */
        public final Line f10072j;

        /* renamed from: k */
        public final LineFormatter f10073k;

        public C2495d(int i, LineFormatter lineFormatter, Line line, CharSequence charSequence, CharSequence charSequence2, long j, CharSequence charSequence3, long j2) {
            super(2, charSequence, i);
            this.f10073k = lineFormatter;
            this.f10072j = line;
            this.f10069g = charSequence2;
            this.f10071i = j;
            this.f10068f = charSequence3;
            this.f10070h = j2;
        }
    }

    /* compiled from: HistoryFragment.java */
    /* renamed from: h.b.a.e.d.m3$e */
    /* loaded from: classes.dex */
    public class C2496e extends BaseItemView {

        /* renamed from: A */
        public final TextView f10074A;

        /* renamed from: B */
        public final TextView f10075B;

        /* renamed from: C */
        public final LineDrawable f10076C;

        /* renamed from: u */
        public final ImageView f10078u;

        /* renamed from: v */
        public final TextView f10079v;

        /* renamed from: w */
        public final TextView f10080w;

        /* renamed from: x */
        public final TextView f10081x;

        /* renamed from: y */
        public final TextView f10082y;

        /* renamed from: z */
        public final TextView f10083z;

        public C2496e(View view) {
            super(view);
            this.f10078u = (ImageView) view.findViewById(C1444R.C1446id.icon);
            this.f10076C = new LineDrawable();
            this.f10079v = (TextView) view.findViewById(C1444R.C1446id.title);
            this.f10079v.setBackground(this.f10076C);
            this.f10080w = (TextView) view.findViewById(C1444R.C1446id.gotOff);
            this.f10081x = (TextView) view.findViewById(C1444R.C1446id.gotOn);
            this.f10082y = (TextView) view.findViewById(C1444R.C1446id.end);
            this.f10083z = (TextView) view.findViewById(C1444R.C1446id.start);
            this.f10074A = (TextView) view.findViewById(C1444R.C1446id.start_zone);
            this.f10075B = (TextView) view.findViewById(C1444R.C1446id.end_zone);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2495d c2495d = (C2495d) c2463a;
            DataModels.StageInfo mo1310d = c2495d.f10072j.mo1310d();
            this.f10078u.setImageResource(c2495d.f9969e);
            Line line = c2495d.f10072j;
            if (line != null && line.mo1313a().length() != 0) {
                this.f10079v.setText(c2495d.f9968d);
                this.f10076C.m1207a(c2495d.f10073k, c2495d.f10072j);
                this.f10079v.setVisibility(0);
            } else {
                this.f10079v.setVisibility(4);
            }
            this.f10080w.setText(c2495d.f10068f);
            this.f10081x.setText(c2495d.f10069g);
            this.f10082y.setText(HistoryFragment.this.f10056k0.format(Long.valueOf(c2495d.f10070h)));
            this.f10083z.setText(HistoryFragment.this.f10056k0.format(Long.valueOf(c2495d.f10071i)));
            this.f10074A.setText(mo1310d.getStartZoneName());
            this.f10075B.setText(mo1310d.getFinishZoneName());
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public void mo873Z() {
        super.mo873Z();
        this.f10056k0 = m1150o0();
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment
    /* renamed from: c */
    public AbstractTimeFramedListFragment.AbstractC2464b mo965c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RunnableC2492a runnableC2492a = new RunnableC2492a();
        this.f10057l0 = runnableC2492a;
        return runnableC2492a;
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
    }

    /* compiled from: HistoryFragment.java */
    /* renamed from: h.b.a.e.d.m3$a */
    /* loaded from: classes.dex */
    public class RunnableC2492a extends AbstractTimeFramedListFragment.AbstractC2464b implements AsyncResult.InterfaceC2279a<List<Trip>>, Runnable {

        /* renamed from: c */
        public final List<AbstractTimeFramedListFragment.C2463a> f10058c = new ArrayList();

        /* renamed from: d */
        public final List<AbstractTimeFramedListFragment.C2463a> f10059d = new ArrayList();

        /* renamed from: e */
        public List<Trip> f10060e;

        public RunnableC2492a() {
            this.f10058c.add(new AbstractTimeFramedListFragment.C2463a());
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<List<Trip>> asyncResult) {
            if (HistoryFragment.this.m7468j() == null) {
                return;
            }
            if (asyncResult instanceof AsyncResult.AbstractC2280b) {
                AsyncResult.AbstractC2280b abstractC2280b = (AsyncResult.AbstractC2280b) asyncResult;
                if (abstractC2280b.mo1349d() != null) {
                    HistoryFragment.this.m991b(abstractC2280b.mo1349d().m1322c());
                }
            }
            this.f10060e = asyncResult.mo1334a();
            Collections.sort(this.f10060e, C2466j.f9974a);
            HistoryFragment.this.f9959e0.post(this);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: c */
        public int mo739c(int i) {
            return this.f10058c.get(i).f9967c;
        }

        @Override // p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment.AbstractC2464b
        /* renamed from: d */
        public void mo961d(int i, int i2) {
            HistoryFragment.this.f9959e0.setRefreshing(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(i2, i, 1, 0, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(2, 1);
            HistoryFragment.this.f9958d0.m1400o().mo1275d().mo1319a(timeInMillis, calendar.getTimeInMillis()).m1375a(this);
        }

        /* renamed from: e */
        public final void m960e() {
            List<AbstractTimeFramedListFragment.C2463a> list = this.f10058c;
            list.clear();
            boolean z = true;
            for (AbstractTimeFramedListFragment.C2463a c2463a : this.f10059d) {
                if (c2463a.f9967c == 1) {
                    list.add(c2463a);
                    z = ((C2493b) c2463a).f10063g;
                } else if (z) {
                    list.add(c2463a);
                }
            }
        }

        /* renamed from: g */
        public void m959g(int i) {
            AbstractTimeFramedListFragment.C2463a c2463a = this.f10058c.get(i);
            if (c2463a.f9967c == 1) {
                C2493b c2493b = (C2493b) c2463a;
                int i2 = i + 1;
                c2493b.f10063g = !c2493b.f10063g;
                int i3 = 0;
                if (!c2493b.f10063g) {
                    while (i2 < this.f10058c.size() && this.f10058c.get(i2).f9967c == 2) {
                        this.f10058c.remove(i2);
                        i3++;
                    }
                    m6749d(i2 - 1);
                    m6752c(i2, i3);
                    return;
                }
                int indexOf = this.f10059d.indexOf(c2463a);
                while (true) {
                    indexOf++;
                    if (indexOf >= this.f10059d.size() || this.f10059d.get(indexOf).f9967c != 2) {
                        break;
                    }
                    this.f10058c.add(i2, this.f10059d.get(indexOf));
                    i3++;
                    i2++;
                }
                int i4 = i2 - i3;
                m6749d(i4 - 1);
                m6756b(i4, i3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            HistoryFragment.this.f9959e0.setRefreshing(false);
            final List<AbstractTimeFramedListFragment.C2463a> list = this.f10059d;
            m6752c(1, this.f10058c.size() - 1);
            list.clear();
            List<Trip> list2 = this.f10060e;
            this.f10060e = null;
            Calendar calendar = Calendar.getInstance();
            list.add(this.f10058c.get(0));
            int size = list2.size() - 1;
            int i2 = -1;
            C2493b c2493b = null;
            while (size >= 0) {
                Trip trip = list2.get(size);
                long mo1260e = trip.mo1260e();
                calendar.setTimeInMillis(mo1260e);
                if (i2 != calendar.get(5)) {
                    C2493b c2493b2 = new C2493b(mo1260e, i);
                    list.add(c2493b2);
                    c2493b = c2493b2;
                    i2 = calendar.get(5);
                }
                Line mo1257h = trip.mo1257h();
                Passing mo1259f = trip.mo1259f();
                Operator mo1263b = trip.mo1263b();
                list.add(new C2495d(mo1263b == null ? 0 : mo1263b.mo1289c(), mo1263b == null ? new LineFormatter.C2361a() : mo1263b.mo1287e(), mo1257h, mo1257h == null ? null : mo1257h.mo1311c(), trip.mo1262c().mo1285d().mo1267a(), mo1260e, mo1259f.mo1285d().mo1267a(), mo1259f.mo1286a()));
                if (c2493b != null) {
                    c2493b.f9969e++;
                }
                size--;
                i = 0;
            }
            m960e();
            m6756b(1, mo747a() - 1);
            HistoryFragment.this.f9959e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.k
                @Override // java.lang.Runnable
                public final void run() {
                    HistoryFragment.RunnableC2492a.this.m962a(list);
                }
            }, 300L);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public BaseItemView mo742b(ViewGroup viewGroup, int i) {
            if (i == 2) {
                HistoryFragment historyFragment = HistoryFragment.this;
                return new C2496e(LayoutInflater.from(historyFragment.f9860b0).inflate(C1444R.layout.item_history_trip, viewGroup, false));
            } else if (i == 1) {
                HistoryFragment historyFragment2 = HistoryFragment.this;
                return new View$OnClickListenerC2494c(LayoutInflater.from(historyFragment2.f9860b0).inflate(C1444R.layout.item_history_day, viewGroup, false));
            } else if (i == 0) {
                HistoryFragment historyFragment3 = HistoryFragment.this;
                return new AbstractTimeFramedListFragment.C2465c(LayoutInflater.from(historyFragment3.f9860b0).inflate(C1444R.layout.item_history_header, viewGroup, false));
            } else {
                return null;
            }
        }

        /* renamed from: a */
        public static /* synthetic */ int m964a(Trip trip, Trip trip2) {
            return (int) (trip.mo1260e() - trip2.mo1260e());
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(BaseItemView baseItemView, int i) {
            baseItemView.mo692a(this.f10058c.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            return this.f10058c.size();
        }

        /* renamed from: a */
        public /* synthetic */ void m962a(List list) {
            if (list.size() > 2) {
                HistoryFragment.this.f10057l0.m959g(1);
            }
        }
    }
}
