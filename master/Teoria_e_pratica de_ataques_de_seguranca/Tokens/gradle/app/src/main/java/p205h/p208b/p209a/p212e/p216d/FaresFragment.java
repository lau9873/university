package p205h.p208b.p209a.p212e.p216d;

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
import com.hbb20.C1444R;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import p000a.p006b.p030g.p031a.NotificationCompat;
import p000a.p006b.p030g.p032b.ContextCompat;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.Billing;
import p205h.p208b.p209a.p210d.BillingProduct;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.Invoice;
import p205h.p208b.p209a.p210d.InvoiceDownloadListener;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.Stop;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p212e.p215c.GroupSeparatorDrawable;
import p205h.p208b.p209a.p212e.p215c.LineDrawable;
import p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment;
import p205h.p208b.p209a.p212e.p216d.FaresFragment;
import p205h.p208b.p209a.p212e.p218f.BaseItemView;
import pt.card4b.backendbeacons.BackEnd;
import pt.opt.anda.gui.activity.MainActivity;

/* renamed from: h.b.a.e.d.k3 */
/* loaded from: classes.dex */
public class FaresFragment extends AbstractTimeFramedListFragment implements InvoiceDownloadListener {

    /* renamed from: k0 */
    public C2474a f9989k0;

    /* renamed from: l0 */
    public String f9990l0;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: m0 */
    public final SimpleDateFormat f9991m0 = new SimpleDateFormat("EE, dd");

    /* renamed from: n0 */
    public DateFormat f9992n0;

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$a */
    /* loaded from: classes.dex */
    public class C2474a extends AbstractTimeFramedListFragment.AbstractC2464b implements AsyncResult.InterfaceC2279a<Billing> {

        /* renamed from: c */
        public final List<AbstractTimeFramedListFragment.C2463a> f9993c = new ArrayList();

        /* renamed from: d */
        public final List<AbstractTimeFramedListFragment.C2463a> f9994d = new ArrayList();

        /* renamed from: e */
        public final float f9995e;

        public C2474a() {
            this.f9994d.add(new AbstractTimeFramedListFragment.C2463a());
            this.f9995e = TypedValue.applyDimension(1, 1.0f, FaresFragment.this.m7549B().getDisplayMetrics());
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: c */
        public int mo739c(int i) {
            return this.f9994d.get(i).f9967c;
        }

        @Override // p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment.AbstractC2464b
        /* renamed from: d */
        public void mo961d(int i, int i2) {
            FaresFragment.this.f9959e0.setRefreshing(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(i2, i, 1, 0, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(2, 1);
            FaresFragment.this.f9958d0.m1400o().mo1283a(timeInMillis, calendar.getTimeInMillis()).m1375a(this);
        }

        /* renamed from: e */
        public final void m976e() {
            List<AbstractTimeFramedListFragment.C2463a> list = this.f9994d;
            list.clear();
            boolean z = true;
            for (AbstractTimeFramedListFragment.C2463a c2463a : this.f9993c) {
                int i = c2463a.f9967c;
                if (i == 1 || i == 4) {
                    list.add(c2463a);
                    z = ((C2475b) c2463a).f9997f;
                } else if (z || (i != 2 && i != 5)) {
                    list.add(c2463a);
                }
            }
        }

        /* renamed from: g */
        public void m975g(int i) {
            int i2;
            int i3;
            AbstractTimeFramedListFragment.C2463a c2463a = this.f9994d.get(i);
            int i4 = c2463a.f9967c;
            if (i4 == 1 || i4 == 4) {
                C2475b c2475b = (C2475b) c2463a;
                int i5 = 0;
                int i6 = i + 1;
                boolean z = c2475b.f9997f;
                c2475b.f9997f = !z;
                if (z) {
                    while (i6 < this.f9994d.size() && ((i3 = this.f9994d.get(i6).f9967c) == 2 || i3 == 5)) {
                        i5++;
                        this.f9994d.remove(i6);
                    }
                    m6749d(i6 - 1);
                    m6752c(i6, i5);
                    return;
                }
                int indexOf = this.f9993c.indexOf(c2463a);
                while (true) {
                    indexOf++;
                    if (indexOf >= this.f9993c.size() || !((i2 = this.f9993c.get(indexOf).f9967c) == 2 || i2 == 5)) {
                        break;
                    }
                    i5++;
                    this.f9994d.add(i6, this.f9993c.get(indexOf));
                    i6++;
                }
                int i7 = i6 - i5;
                m6749d(i7 - 1);
                m6756b(i7, i5);
            }
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(BaseItemView baseItemView, int i) {
            baseItemView.mo692a(this.f9994d.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            return this.f9994d.size();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public BaseItemView mo742b(ViewGroup viewGroup, int i) {
            if (i == 2) {
                FaresFragment faresFragment = FaresFragment.this;
                return new View$OnClickListenerC2480g(LayoutInflater.from(faresFragment.f9860b0).inflate(C1444R.layout.item_history_trip, viewGroup, false));
            } else if (i == 1) {
                FaresFragment faresFragment2 = FaresFragment.this;
                return new View$OnClickListenerC2476c(LayoutInflater.from(faresFragment2.f9860b0).inflate(C1444R.layout.item_fares_group, viewGroup, false), false);
            } else if (i == 0) {
                FaresFragment faresFragment3 = FaresFragment.this;
                return new AbstractTimeFramedListFragment.C2465c(LayoutInflater.from(faresFragment3.f9860b0).inflate(C1444R.layout.item_history_header, viewGroup, false));
            } else if (i == 3) {
                FaresFragment faresFragment4 = FaresFragment.this;
                return new C2482i(LayoutInflater.from(faresFragment4.f9860b0).inflate(C1444R.layout.item_fares_footer, viewGroup, false));
            } else if (i == 4) {
                FaresFragment faresFragment5 = FaresFragment.this;
                return new View$OnClickListenerC2476c(LayoutInflater.from(faresFragment5.f9860b0).inflate(C1444R.layout.item_fares_invoices_header, viewGroup, false), true);
            } else if (i == 5) {
                FaresFragment faresFragment6 = FaresFragment.this;
                return new View$OnClickListenerC2478e(LayoutInflater.from(faresFragment6.f9860b0).inflate(C1444R.layout.item_fares_invoice, viewGroup, false));
            } else {
                return null;
            }
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<Billing> asyncResult) {
            if (FaresFragment.this.m7468j() == null || FaresFragment.this.f9860b0 == null) {
                return;
            }
            if (asyncResult instanceof AsyncResult.AbstractC2280b) {
                AsyncResult.AbstractC2280b abstractC2280b = (AsyncResult.AbstractC2280b) asyncResult;
                if (abstractC2280b.mo1349d() != null) {
                    FaresFragment.this.m991b(abstractC2280b.mo1349d().m1322c());
                }
            }
            Billing mo1334a = asyncResult.mo1334a();
            final List<AbstractTimeFramedListFragment.C2463a> list = this.f9993c;
            m6752c(1, this.f9994d.size() - 1);
            list.clear();
            list.add(new AbstractTimeFramedListFragment.C2463a());
            if (mo1334a == null) {
                m976e();
                FaresFragment.this.f9959e0.setRefreshing(false);
                return;
            }
            double d = 0.0d;
            List<BillingProduct> mo1330a = mo1334a.mo1330a();
            List<Invoice> mo1329b = mo1334a.mo1329b();
            Collections.sort(mo1330a, C2430g.f9851a);
            Collections.sort(mo1329b, C2418f.f9818a);
            C2475b c2475b = null;
            boolean z = true;
            for (BillingProduct billingProduct : mo1330a) {
                if (c2475b == null || !c2475b.f9968d.equals(billingProduct.mo1328a())) {
                    c2475b = new C2475b(billingProduct.mo1328a());
                    list.add(c2475b);
                    z = true;
                }
                double mo1327b = billingProduct.mo1327b();
                double d2 = d + mo1327b;
                c2475b.m974a(mo1327b);
                for (Trip trip : billingProduct.mo1326c()) {
                    Passing mo1262c = trip.mo1262c();
                    Passing mo1259f = trip.mo1259f();
                    Stop mo1285d = mo1259f.mo1285d();
                    Stop mo1285d2 = mo1262c.mo1285d();
                    Operator mo1263b = trip.mo1263b();
                    Line mo1257h = trip.mo1257h();
                    StringBuilder sb = new StringBuilder();
                    sb.append(mo1285d.mo1267a());
                    double d3 = d2;
                    sb.append(mo1285d.mo1265e() == null ? "" : " " + mo1285d.mo1265e().mo1331a());
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(mo1285d2.mo1267a());
                    sb3.append(mo1285d2.mo1265e() != null ? " " + mo1285d2.mo1265e().mo1331a() : "");
                    C2479f c2479f = new C2479f(mo1263b, mo1257h, sb2, sb3.toString(), mo1262c.mo1286a(), mo1259f.mo1286a(), z, trip.mo1258g());
                    if (trip.mo1258g()) {
                        Passing mo1254k = trip.mo1254k();
                        Passing mo1255j = trip.mo1255j();
                        Stop mo1285d3 = mo1254k.mo1285d();
                        Stop mo1285d4 = mo1255j.mo1285d();
                        c2479f.m970a(mo1285d3.mo1266c());
                        c2479f.m968b(mo1285d4.mo1266c());
                    }
                    list.add(c2479f);
                    d2 = d3;
                }
                z = !z;
                d = d2;
            }
            list.add(new C2481h(FaresFragment.this, C1444R.string.bill_total, (int) Math.round(d * 100.0d), C1444R.string.bill_virtual_card, 10));
            list.add(new C2475b(4, C1444R.string.bill_invoices, mo1329b.size(), true));
            if (mo1329b.size() > 0) {
                for (Invoice invoice : mo1329b) {
                    list.add(new C2477d(invoice.mo1314e(), invoice.mo1316c(), invoice.mo1318a(), invoice.mo1317b(), invoice.mo1315d(), true));
                }
            }
            m976e();
            m6756b(1, mo747a() - 1);
            FaresFragment.this.f9959e0.setRefreshing(false);
            FaresFragment.this.f9959e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.e
                @Override // java.lang.Runnable
                public final void run() {
                    FaresFragment.C2474a.this.m977a(list);
                }
            }, 400L);
        }

        /* renamed from: a */
        public static /* synthetic */ int m981a(BillingProduct billingProduct, BillingProduct billingProduct2) {
            String mo1328a = billingProduct.mo1328a();
            String mo1328a2 = billingProduct2.mo1328a();
            if (mo1328a == null) {
                return -1;
            }
            if (mo1328a2 == null) {
                return 1;
            }
            return mo1328a.compareTo(mo1328a2);
        }

        /* renamed from: a */
        public /* synthetic */ void m977a(List list) {
            if (list.size() == 4) {
                m975g(1);
            }
            m975g(3);
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2476c extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public final TextView f10000u;

        /* renamed from: v */
        public final TextView f10001v;

        /* renamed from: w */
        public final TextView f10002w;

        /* renamed from: x */
        public final ImageButton f10003x;

        /* renamed from: y */
        public final GroupSeparatorDrawable f10004y;

        public View$OnClickListenerC2476c(View view, boolean z) {
            super(view);
            this.f10000u = (TextView) view.findViewById(C1444R.C1446id.title);
            this.f10001v = (TextView) view.findViewById(C1444R.C1446id.description);
            this.f10002w = (TextView) view.findViewById(C1444R.C1446id.quantity);
            this.f10004y = new GroupSeparatorDrawable(FaresFragment.this.f9989k0.f9995e);
            view.setBackground(this.f10004y);
            this.f10003x = (ImageButton) view.findViewById(C1444R.C1446id.icon);
            if (z) {
                this.f10004y.f9743b = true;
            }
            ImageButton imageButton = this.f10003x;
            if (imageButton != null) {
                imageButton.setOnClickListener(this);
                view.setOnClickListener(this);
            }
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        @SuppressLint({"SetTextI18n"})
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2475b c2475b = (C2475b) c2463a;
            if (c2475b.f9998g) {
                this.f10000u.setText(String.format(Locale.getDefault(), "%s (%d)", FaresFragment.this.f9860b0.getString(c2475b.f9969e), Integer.valueOf(c2475b.f9999h)));
            } else {
                this.f10000u.setText(c2463a.f9968d);
            }
            TextView textView = this.f10001v;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(c2463a.f9969e / 100.0f)));
            }
            if (this.f10003x != null) {
                TextView textView2 = this.f10002w;
                if (textView2 != null) {
                    textView2.setText(c2475b.f9999h + "x");
                }
                this.f10003x.setImageResource(c2475b.f9997f ? C1444R.C1445drawable.ic_keyboard_arrow_up_black_24dp : C1444R.C1445drawable.ic_keyboard_arrow_down_black_24dp);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int m6807h = m6807h();
            if (m6807h != -1) {
                FaresFragment.this.f9989k0.m975g(m6807h);
            }
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$d */
    /* loaded from: classes.dex */
    public static class C2477d extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final CharSequence f10006f;

        /* renamed from: g */
        public final CharSequence f10007g;

        /* renamed from: h */
        public final CharSequence f10008h;

        /* renamed from: i */
        public final Date f10009i;

        /* renamed from: j */
        public final float f10010j;

        public C2477d(CharSequence charSequence, CharSequence charSequence2, Date date, float f, CharSequence charSequence3, boolean z) {
            super(5, charSequence, 0);
            this.f10006f = charSequence;
            this.f10007g = charSequence2;
            this.f10009i = date;
            this.f10010j = f;
            this.f10008h = charSequence3;
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$f */
    /* loaded from: classes.dex */
    public static class C2479f extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final CharSequence f10018f;

        /* renamed from: g */
        public final CharSequence f10019g;

        /* renamed from: h */
        public final long f10020h;

        /* renamed from: i */
        public final long f10021i;

        /* renamed from: j */
        public CharSequence f10022j;

        /* renamed from: k */
        public CharSequence f10023k;

        /* renamed from: l */
        public final boolean f10024l;

        /* renamed from: m */
        public final Line f10025m;

        /* renamed from: n */
        public final boolean f10026n;

        public C2479f(Operator operator, Line line, CharSequence charSequence, CharSequence charSequence2, long j, long j2, boolean z, boolean z2) {
            super(2, line == null ? "" : line.mo1311c(), operator == null ? 0 : operator.mo1289c());
            this.f10025m = line;
            this.f10018f = charSequence;
            this.f10019g = charSequence2;
            this.f10020h = j2;
            this.f10021i = j;
            this.f10026n = z;
            this.f10024l = z2;
        }

        /* renamed from: a */
        public void m970a(CharSequence charSequence) {
            this.f10022j = charSequence;
        }

        /* renamed from: b */
        public void m968b(CharSequence charSequence) {
            this.f10023k = charSequence;
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$g */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2480g extends BaseItemView implements View.OnClickListener {

        /* renamed from: A */
        public final ImageView f10027A;

        /* renamed from: B */
        public final LineDrawable f10028B;

        /* renamed from: C */
        public C2479f f10029C;

        /* renamed from: u */
        public final ImageView f10031u;

        /* renamed from: v */
        public final TextView f10032v;

        /* renamed from: w */
        public final TextView f10033w;

        /* renamed from: x */
        public final TextView f10034x;

        /* renamed from: y */
        public final TextView f10035y;

        /* renamed from: z */
        public final TextView f10036z;

        public View$OnClickListenerC2480g(View view) {
            super(view);
            this.f10031u = (ImageView) view.findViewById(C1444R.C1446id.icon);
            this.f10028B = new LineDrawable();
            this.f10032v = (TextView) view.findViewById(C1444R.C1446id.title);
            this.f10032v.setBackground(this.f10028B);
            this.f10033w = (TextView) view.findViewById(C1444R.C1446id.gotOff);
            this.f10034x = (TextView) view.findViewById(C1444R.C1446id.gotOn);
            this.f10035y = (TextView) view.findViewById(C1444R.C1446id.end);
            this.f10036z = (TextView) view.findViewById(C1444R.C1446id.start);
            this.f10027A = (ImageView) view.findViewById(C1444R.C1446id.tPartialStage);
            this.f10027A.setOnClickListener(this);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        @SuppressLint({"SetTextI18n"})
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2479f c2479f = (C2479f) c2463a;
            this.f10029C = c2479f;
            this.f10031u.setImageResource(c2479f.f9969e);
            if (c2479f.f9968d.length() == 0) {
                this.f10032v.setVisibility(4);
            } else {
                this.f10032v.setText(c2479f.f9968d);
                this.f10028B.m1208a(c2479f.f10025m);
                this.f10032v.setVisibility(0);
            }
            this.f10033w.setText(c2479f.f10018f);
            this.f10034x.setText(c2479f.f10019g);
            this.f10035y.setText(FaresFragment.this.f9991m0.format(Long.valueOf(c2479f.f10021i)));
            TextView textView = this.f10036z;
            textView.setText(FaresFragment.this.f9992n0.format(Long.valueOf(c2479f.f10021i)) + " • " + FaresFragment.this.f9992n0.format(Long.valueOf(c2479f.f10020h)));
            if (c2479f.f10024l) {
                if (this.f10027A.getVisibility() == 8) {
                    this.f10027A.setVisibility(0);
                }
            } else {
                this.f10027A.setVisibility(8);
            }
            if (c2479f.f10026n) {
                this.f4213a.setBackground(null);
            } else {
                this.f4213a.setBackgroundColor(268435456);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == this.f10027A.getId()) {
                if (this.f10029C != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FaresFragment.this.f9860b0);
                    builder.setTitle(FaresFragment.this.f9860b0.getString(C1444R.string.part_of_trip));
                    builder.setMessage(String.format("%s %s %s %s", FaresFragment.this.f9860b0.getString(C1444R.string.from), this.f10029C.f10022j, FaresFragment.this.f9860b0.getString(C1444R.string.f6338to), this.f10029C.f10023k));
                    builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
                    builder.show();
                    return;
                }
                Log.d("FaresFragment.class", "FaresTripItemView is null. It will not show the AlertDialog");
            }
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$h */
    /* loaded from: classes.dex */
    public class C2481h extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final int f10037f;

        /* renamed from: g */
        public final int f10038g;

        /* renamed from: h */
        public final int f10039h;

        public C2481h(FaresFragment faresFragment, int i, int i2, int i3, int i4) {
            super(3, "", i2);
            this.f10037f = i3;
            this.f10038g = i;
            this.f10039h = i4;
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$i */
    /* loaded from: classes.dex */
    public class C2482i extends BaseItemView {

        /* renamed from: u */
        public final TextView f10040u;

        /* renamed from: v */
        public final TextView f10041v;

        /* renamed from: w */
        public final TextView f10042w;

        /* renamed from: x */
        public final TextView f10043x;

        /* renamed from: y */
        public final GroupSeparatorDrawable f10044y;

        public C2482i(View view) {
            super(view);
            this.f10040u = (TextView) view.findViewById(C1444R.C1446id.title);
            this.f10041v = (TextView) view.findViewById(C1444R.C1446id.description);
            this.f10042w = (TextView) view.findViewById(C1444R.C1446id.extraTitle);
            this.f10043x = (TextView) view.findViewById(C1444R.C1446id.extraDescription);
            this.f10044y = new GroupSeparatorDrawable(FaresFragment.this.f9989k0.f9995e);
            GroupSeparatorDrawable groupSeparatorDrawable = this.f10044y;
            groupSeparatorDrawable.f9743b = true;
            view.setBackground(groupSeparatorDrawable);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2481h c2481h = (C2481h) c2463a;
            this.f10040u.setText(FaresFragment.this.f9860b0.getString(c2481h.f10038g));
            this.f10042w.setText(FaresFragment.this.f9860b0.getString(c2481h.f10037f));
            TextView textView = this.f10041v;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(c2481h.f9969e / 100.0f)));
            }
            TextView textView2 = this.f10043x;
            if (textView2 != null) {
                textView2.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(c2481h.f10039h / 100.0f)));
            }
        }
    }

    public FaresFragment() {
        Anda.m1443b(this.f9860b0).m1452a((InvoiceDownloadListener) this);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public void mo873Z() {
        super.mo873Z();
        this.f9992n0 = m1150o0();
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

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment
    /* renamed from: c */
    public AbstractTimeFramedListFragment.AbstractC2464b mo965c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2474a c2474a = new C2474a();
        this.f9989k0 = c2474a;
        return c2474a;
    }

    @Override // p205h.p208b.p209a.p210d.InvoiceDownloadListener
    /* renamed from: a */
    public void mo986a(long j, String str) {
        Context context = this.f9860b0;
        NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(context, context.getString(C1444R.string.anda_notificationChannel));
        c0189c.m10043b(this.f9860b0.getString(C1444R.string.anda_notificationChannel));
        c0189c.m10041c(C1444R.C1445drawable.ic_notification);
        c0189c.m10056a(-13615201);
        c0189c.m10043b(this.f9860b0.getString(C1444R.string.anda_notificationChannel));
        c0189c.m10038d(1);
        c0189c.m10044b((CharSequence) this.f9860b0.getString(C1444R.string.state_downloadCompleted));
        c0189c.m10040c((CharSequence) this.f9860b0.getString(C1444R.string.state_downloadCompleted));
        c0189c.m10039c("pt.opt.anda.INVOICE_DOWNLOAD");
        c0189c.m10050a((CharSequence) new File(str).getName());
        Context context2 = this.f9860b0;
        c0189c.m10051a(PendingIntent.getActivity(context2, 300, MainActivity.m36a(context2, str, "pt.opt.anda.InvoiceProvider"), 134217728));
        Notification m10057a = c0189c.m10057a();
        m10057a.flags |= 16;
        NotificationManager notificationManager = (NotificationManager) this.f9860b0.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify((int) j, m10057a);
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$b */
    /* loaded from: classes.dex */
    public static class C2475b extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public boolean f9997f;

        /* renamed from: g */
        public boolean f9998g;

        /* renamed from: h */
        public int f9999h;

        public C2475b(String str) {
            super(str == null ? "" : str, 0);
            this.f9997f = false;
            this.f9998g = false;
            this.f9999h = 0;
        }

        /* renamed from: a */
        public void m974a(double d) {
            this.f9969e = (int) (this.f9969e + Math.round(d * 100.0d));
            this.f9999h++;
        }

        public C2475b(int i, int i2, int i3, boolean z) {
            super(i, "", i2);
            this.f9997f = false;
            this.f9998g = false;
            this.f9999h = i3;
            this.f9998g = z;
        }
    }

    /* compiled from: FaresFragment.java */
    /* renamed from: h.b.a.e.d.k3$e */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2478e extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public final ImageButton f10012u;

        /* renamed from: v */
        public final ImageButton f10013v;

        /* renamed from: w */
        public final TextView f10014w;

        /* renamed from: x */
        public final TextView f10015x;

        /* renamed from: y */
        public final TextView f10016y;

        /* renamed from: z */
        public final SimpleDateFormat f10017z;

        public View$OnClickListenerC2478e(View view) {
            super(view);
            this.f10017z = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            this.f10012u = (ImageButton) view.findViewById(C1444R.C1446id.download_icon);
            this.f10013v = (ImageButton) view.findViewById(C1444R.C1446id.send_email);
            this.f10014w = (TextView) view.findViewById(C1444R.C1446id.name);
            this.f10015x = (TextView) view.findViewById(C1444R.C1446id.date);
            this.f10016y = (TextView) view.findViewById(C1444R.C1446id.price);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            final C2477d c2477d = (C2477d) c2463a;
            this.f10014w.setText(c2477d.f10006f);
            this.f10015x.setText(this.f10017z.format(c2477d.f10009i));
            this.f10016y.setText(String.format(Locale.getDefault(), "%.2f€", Float.valueOf(c2477d.f10010j)));
            this.f10013v.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaresFragment.View$OnClickListenerC2478e.this.m973a(c2477d, view);
                }
            });
            this.f10012u.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaresFragment.View$OnClickListenerC2478e.this.m972b(c2477d, view);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m972b(C2477d c2477d, View view) {
            if (ContextCompat.m10021a(FaresFragment.this.f9860b0, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                FaresFragment.this.f9990l0 = c2477d.f10007g.toString();
                FaresFragment.this.m7506a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
                return;
            }
            Anda.m1443b(FaresFragment.this.f9860b0).m1448a(c2477d.f10007g.toString());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        /* renamed from: a */
        public /* synthetic */ void m973a(C2477d c2477d, View view) {
            Toast.makeText(FaresFragment.this.f9860b0, (int) C1444R.string.invoice_sending, 0).show();
            BackEnd.sendInvoiceEmail(c2477d.f10008h.toString(), new C2487l3(this));
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo872a(int i, String[] strArr, int[] iArr) {
        if (i == 3 && iArr.length > 0 && iArr[0] == 0) {
            Anda.m1443b(this.f9860b0).m1448a(this.f9990l0);
        }
    }
}
