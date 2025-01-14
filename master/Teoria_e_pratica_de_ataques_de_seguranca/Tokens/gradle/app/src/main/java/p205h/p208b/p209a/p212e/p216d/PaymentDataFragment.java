package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.hbb20.C1444R;
import com.hbb20.CountryCodePicker;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.CountriesListener;
import p205h.p208b.p209a.p210d.PaymentMethodsListener;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.RemoteUserResultListener;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p210d.UserProfile;
import p205h.p208b.p209a.p212e.p215c.GroupSeparatorDrawable;
import p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment;
import p205h.p208b.p209a.p212e.p216d.PaymentDataFragment;
import p205h.p208b.p209a.p212e.p218f.BaseItemView;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.s3 */
/* loaded from: classes.dex */
public class PaymentDataFragment extends AbstractFragment implements RemoteUserListener, TextView.OnEditorActionListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, CountriesListener {

    /* renamed from: s0 */
    public static final HashMap<String, Bitmap> f10192s0 = new HashMap<>(2);

    /* renamed from: c0 */
    public Anda f10193c0;

    /* renamed from: d0 */
    public Snackbar f10194d0;

    /* renamed from: e0 */
    public ViewGroup f10195e0;

    /* renamed from: f0 */
    public AlertDialog f10196f0;

    /* renamed from: g0 */
    public ProgressBar f10197g0;

    /* renamed from: h0 */
    public EditText f10198h0;

    /* renamed from: i0 */
    public AlertDialog f10199i0;

    /* renamed from: j0 */
    public UserProfile f10200j0;

    /* renamed from: k0 */
    public C2536b f10201k0;

    /* renamed from: m0 */
    public PaymentMethodsListener f10203m0;

    /* renamed from: o0 */
    public DataModels.Country f10205o0;

    /* renamed from: p0 */
    public AbstractTimeFramedListFragment.C2463a f10206p0;

    /* renamed from: l0 */
    public List<RemoteUserResultListener> f10202l0 = new ArrayList();

    /* renamed from: n0 */
    public HashMap<String, DataModels.Country> f10204n0 = new HashMap<>();

    /* renamed from: q0 */
    public final HashMap<String, RunnableC2546i> f10207q0 = new HashMap<>(2);

    /* renamed from: r0 */
    public AsyncResult.InterfaceC2279a<Session.AbstractC2369d> f10208r0 = new C2535a();

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$a */
    /* loaded from: classes.dex */
    public class C2535a implements AsyncResult.InterfaceC2279a<Session.AbstractC2369d> {
        public C2535a() {
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<Session.AbstractC2369d> asyncResult) {
            Session.AbstractC2369d mo1334a = asyncResult.mo1334a();
            if (PaymentDataFragment.this.m7540K()) {
                if (mo1334a.m1268c()) {
                    PaymentDataFragment.this.f10201k0.m813f();
                    PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                    paymentDataFragment.f10194d0 = paymentDataFragment.f10193c0.m1447a(PaymentDataFragment.this.f9860b0.getString(C1444R.string.profile_action_change_success), 0);
                    PaymentDataFragment.this.f10194d0.mo7619m();
                } else {
                    PaymentDataFragment paymentDataFragment2 = PaymentDataFragment.this;
                    paymentDataFragment2.f10194d0 = paymentDataFragment2.f10193c0.m1447a(mo1334a.mo1269b(), -1);
                    PaymentDataFragment.this.f10194d0.mo7619m();
                }
            }
            PaymentDataFragment.this.f10199i0 = null;
            PaymentDataFragment.this.f10198h0 = null;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$b */
    /* loaded from: classes.dex */
    public class C2536b extends RecyclerView.AbstractC0711g<BaseItemView> implements RemoteUserResultListener {

        /* renamed from: c */
        public final List<AbstractTimeFramedListFragment.C2463a> f10210c = new ArrayList();

        /* renamed from: d */
        public boolean f10211d = false;

        /* renamed from: e */
        public boolean f10212e = true;

        /* renamed from: f */
        public final List<AbstractTimeFramedListFragment.C2463a> f10213f = new ArrayList();

        /* renamed from: g */
        public final List<AbstractTimeFramedListFragment.C2463a> f10214g = new ArrayList();

        /* renamed from: h */
        public final List<AbstractTimeFramedListFragment.C2463a> f10215h = new ArrayList();

        /* renamed from: i */
        public final List<AbstractTimeFramedListFragment.C2463a> f10216i = new ArrayList();

        /* renamed from: j */
        public final List<Integer> f10217j = new ArrayList();

        /* renamed from: k */
        public final float f10218k;

        /* compiled from: PaymentDataFragment.java */
        /* renamed from: h.b.a.e.d.s3$b$a */
        /* loaded from: classes.dex */
        public class C2537a implements BackendListeners.PaymentMethodsRequestListener {

            /* compiled from: PaymentDataFragment.java */
            /* renamed from: h.b.a.e.d.s3$b$a$a */
            /* loaded from: classes.dex */
            public class C2538a implements PaymentMethodsListener {

                /* renamed from: a */
                public final /* synthetic */ List f10221a;

                public C2538a(List list) {
                    this.f10221a = list;
                }

                @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
                /* renamed from: a */
                public void mo810a() {
                    C2536b.this.m813f();
                }

                @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
                /* renamed from: b */
                public UserProfile mo809b() {
                    return PaymentDataFragment.this.f10200j0;
                }

                @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
                /* renamed from: c */
                public List<DataModels.PaymentMethod> mo808c() {
                    return this.f10221a;
                }

                @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
                /* renamed from: d */
                public View mo807d() {
                    return PaymentDataFragment.this.f10195e0;
                }

                @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
                /* renamed from: e */
                public boolean mo806e() {
                    return PaymentDataFragment.this.f10200j0.mo1239j() != null;
                }

                @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
                /* renamed from: f */
                public void mo805f() {
                    C2536b.this.f10211d = true;
                    C2536b.this.m813f();
                }
            }

            public C2537a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                paymentDataFragment.f10194d0 = paymentDataFragment.f10193c0.m1447a(error.getMessageToUser(), -1);
                PaymentDataFragment.this.f10194d0.mo7619m();
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.PaymentMethodsRequestListener
            public void onSuccess(List<DataModels.PaymentMethod> list) {
                C2536b.this.m819a(new C2538a(list));
            }
        }

        public C2536b() {
            this.f10218k = TypedValue.applyDimension(1, 1.0f, PaymentDataFragment.this.m7549B().getDisplayMetrics());
            PaymentDataFragment.this.m847a((RemoteUserResultListener) this);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: c */
        public int mo739c(int i) {
            return this.f10216i.get(i).f9967c;
        }

        /* renamed from: e */
        public final void m814e() {
            BackEnd.getPaymentMethods(new C2537a());
        }

        /* renamed from: f */
        public void m813f() {
            this.f10217j.clear();
            int size = this.f10216i.size();
            for (int i = 0; i < size; i++) {
                if (this.f10216i.get(i) instanceof C2541e) {
                    C2541e c2541e = (C2541e) this.f10216i.get(i);
                    if (c2541e.f10232f) {
                        this.f10217j.add(Integer.valueOf(c2541e.f10233g));
                    }
                }
            }
            if (this.f10212e) {
                this.f10216i.clear();
                m6752c(0, size);
            }
            Anda.m1467X().m1400o().mo1282a(PaymentDataFragment.this);
        }

        /* renamed from: g */
        public void m811g(int i) {
            int i2;
            int i3;
            AbstractTimeFramedListFragment.C2463a c2463a = this.f10216i.get(i);
            int i4 = c2463a.f9967c;
            if (i4 == 1 || i4 == 4) {
                C2541e c2541e = (C2541e) c2463a;
                int i5 = 0;
                int i6 = i + 1;
                boolean z = c2541e.f10232f;
                c2541e.f10232f = !z;
                if (z) {
                    while (i6 < this.f10216i.size() && ((i3 = this.f10216i.get(i6).f9967c) == 2 || i3 == 5 || i3 == 6 || i3 == 7 || i3 == 8)) {
                        i5++;
                        this.f10216i.remove(i6);
                    }
                    m6749d(i6 - 1);
                    m6752c(i6, i5);
                    return;
                }
                int indexOf = this.f10210c.indexOf(c2463a);
                while (true) {
                    indexOf++;
                    if (indexOf >= this.f10210c.size() || !((i2 = this.f10210c.get(indexOf).f9967c) == 2 || i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8)) {
                        break;
                    }
                    i5++;
                    this.f10216i.add(i6, this.f10210c.get(indexOf));
                    i6++;
                }
                int i7 = i6 - i5;
                m6749d(i7 - 1);
                m6756b(i7, i5);
            }
        }

        @Override // p205h.p208b.p209a.p210d.RemoteUserResultListener
        public void onError(DataModels.Error error) {
            PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
            paymentDataFragment.f10194d0 = paymentDataFragment.f10193c0.m1447a(String.format(Locale.getDefault(), "%s: %s", PaymentDataFragment.this.f9860b0.getString(C1444R.string.error), error.getMessageToUser()), -1);
            PaymentDataFragment.this.f10194d0.mo7619m();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public BaseItemView mo742b(ViewGroup viewGroup, int i) {
            if (i == 1) {
                PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                return new View$OnClickListenerC2545h(LayoutInflater.from(paymentDataFragment.f9860b0).inflate(C1444R.layout.item_fares_group, viewGroup, false));
            } else if (i == 2) {
                PaymentDataFragment paymentDataFragment2 = PaymentDataFragment.this;
                return new View$OnClickListenerC2543g(LayoutInflater.from(paymentDataFragment2.f9860b0).inflate(C1444R.layout.item_paymentmethod, viewGroup, false));
            } else if (i == 5) {
                PaymentDataFragment paymentDataFragment3 = PaymentDataFragment.this;
                return new C2540d(LayoutInflater.from(paymentDataFragment3.f9860b0).inflate(C1444R.layout.dialog_paymentdata, viewGroup, false));
            } else if (i == 7) {
                PaymentDataFragment paymentDataFragment4 = PaymentDataFragment.this;
                return new View$OnClickListenerC2551m(LayoutInflater.from(paymentDataFragment4.f9860b0).inflate(C1444R.layout.item_profile_field, viewGroup, false));
            } else if (i == 8) {
                PaymentDataFragment paymentDataFragment5 = PaymentDataFragment.this;
                return new C2548k(LayoutInflater.from(paymentDataFragment5.f9860b0).inflate(C1444R.layout.item_profileccp, viewGroup, false));
            } else {
                return null;
            }
        }

        /* renamed from: a */
        public final void m819a(PaymentMethodsListener paymentMethodsListener) {
            int i;
            List<AbstractTimeFramedListFragment.C2463a> list;
            C2542f c2542f;
            if (PaymentDataFragment.this.m7540K()) {
                SparseArray<AbstractTimeFramedListFragment.C2463a> sparseArray = new SparseArray<>();
                SparseArray<AbstractTimeFramedListFragment.C2463a> sparseArray2 = new SparseArray<>();
                List<AbstractTimeFramedListFragment.C2463a> list2 = this.f10210c;
                if (this.f10212e) {
                    list2.clear();
                }
                if (this.f10213f.isEmpty()) {
                    PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                    AbstractTimeFramedListFragment.C2463a c2541e = new C2541e(paymentDataFragment, paymentDataFragment.f9860b0.getString(C1444R.string.user_paymentMethods), 1);
                    this.f10213f.add(c2541e);
                    sparseArray.put(0, c2541e);
                }
                PaymentDataFragment.this.f10203m0 = paymentMethodsListener;
                UserProfile.InterfaceC2373b mo1239j = PaymentDataFragment.this.f10203m0.mo809b().mo1239j();
                String mo1222c = mo1239j != null ? mo1239j.mo1222c() : "";
                int i2 = 1;
                int i3 = 0;
                for (DataModels.PaymentMethod paymentMethod : PaymentDataFragment.this.f10203m0.mo808c()) {
                    int i4 = i2;
                    C2542f c2542f2 = new C2542f(paymentMethod.getName(), mo1222c.equals(paymentMethod.getCode()), paymentMethod.getThumbnailURL(), i3, paymentMethod);
                    if (c2542f2.f10236h.getName().contains("Pagamento SIBS")) {
                        c2542f = c2542f2;
                        c2542f.f9968d = "Cartão crédito/débito";
                        c2542f.f10236h.setName("Cartão crédito/débito");
                    } else {
                        c2542f = c2542f2;
                    }
                    int i5 = 1;
                    boolean z = false;
                    while (true) {
                        if (i5 >= this.f10213f.size()) {
                            break;
                        }
                        if (this.f10213f.get(i5) instanceof C2542f) {
                            C2542f c2542f3 = (C2542f) this.f10213f.get(i5);
                            if (!c2542f3.f10236h.getCode().equals(paymentMethod.getCode())) {
                                continue;
                            } else if (!c2542f3.equals(c2542f)) {
                                this.f10213f.set(i5, c2542f);
                                sparseArray2.put(i5, c2542f);
                                z = true;
                                break;
                            } else {
                                z = true;
                            }
                        }
                        i5++;
                    }
                    if (!z) {
                        this.f10213f.add(c2542f);
                        sparseArray.put(i4, c2542f);
                    }
                    i2 = i4 + 1;
                    i3++;
                }
                int i6 = i2;
                if (PaymentDataFragment.this.f10203m0.mo806e()) {
                    if (this.f10214g.isEmpty()) {
                        PaymentDataFragment paymentDataFragment2 = PaymentDataFragment.this;
                        AbstractTimeFramedListFragment.C2463a c2541e2 = new C2541e(paymentDataFragment2, paymentDataFragment2.f9860b0.getString(C1444R.string.user_paymentdata), 2);
                        sparseArray.put(i6, c2541e2);
                        this.f10214g.add(c2541e2);
                    }
                    int i7 = i6 + 1;
                    String mo1221d = (mo1239j == null || mo1239j.mo1220e() != UserProfile.InterfaceC2373b.EnumC2375b.LOW_VALUE) ? null : mo1239j.mo1221d();
                    UserProfile.InterfaceC2373b mo1239j2 = PaymentDataFragment.this.f10200j0.mo1239j();
                    AbstractTimeFramedListFragment.C2463a c2539c = new C2539c(mo1239j2.mo1224a(), mo1239j2.mo1223b(), 9999, mo1239j2.mo1219f(), mo1221d);
                    if (this.f10214g.size() == 1) {
                        sparseArray.put(i7, c2539c);
                        this.f10214g.add(c2539c);
                    } else if (!((C2539c) this.f10214g.get(1)).equals(c2539c)) {
                        this.f10214g.set(1, c2539c);
                        sparseArray2.put(i7, c2539c);
                    }
                    i = i7 + 1;
                } else {
                    i = i6;
                }
                String valueOf = (PaymentDataFragment.this.f10200j0.mo1244e() == null || PaymentDataFragment.this.f10200j0.mo1244e().equals("")) ? null : String.valueOf(PaymentDataFragment.this.f10200j0.mo1244e());
                AbstractTimeFramedListFragment.C2463a c2550l = new C2550l(0, PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_billingName), PaymentDataFragment.this.f10200j0.mo1240i(), true, null);
                AbstractTimeFramedListFragment.C2463a c2550l2 = new C2550l(1, PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_address), PaymentDataFragment.this.f10200j0.mo1238k(), true, null);
                AbstractTimeFramedListFragment.C2463a c2550l3 = new C2550l(2, PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_postalCode), PaymentDataFragment.this.f10200j0.mo1242g(), true, null);
                AbstractTimeFramedListFragment.C2463a c2550l4 = new C2550l(3, PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_fiscalNumber), valueOf, true, null);
                AbstractTimeFramedListFragment.C2463a c2550l5 = new C2550l(5, PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_city), PaymentDataFragment.this.f10200j0.mo1246c(), true, null);
                AbstractTimeFramedListFragment.C2463a c2547j = new C2547j(4, PaymentDataFragment.this.f10200j0.mo1237l(), null);
                AbstractTimeFramedListFragment.C2463a c2550l6 = new C2550l(6, PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_billing_email), PaymentDataFragment.this.f10200j0.mo1236m(), true, null);
                if (this.f10215h.isEmpty()) {
                    PaymentDataFragment paymentDataFragment3 = PaymentDataFragment.this;
                    list = list2;
                    AbstractTimeFramedListFragment.C2463a c2541e3 = new C2541e(paymentDataFragment3, paymentDataFragment3.f9860b0.getString(C1444R.string.user_billing_data), 3);
                    sparseArray.put(i, c2541e3);
                    this.f10215h.add(c2541e3);
                } else {
                    list = list2;
                }
                int i8 = i + 1;
                AbstractTimeFramedListFragment.C2463a[] c2463aArr = {c2550l, c2550l2, c2550l3, c2550l5, c2550l4, c2547j, c2550l6};
                if (this.f10215h.size() == 1) {
                    int i9 = 0;
                    while (i9 < c2463aArr.length) {
                        this.f10215h.add(c2463aArr[i9]);
                        sparseArray.put(i8, c2463aArr[i9]);
                        i9++;
                        i8++;
                    }
                } else {
                    for (int i10 = 1; i10 <= 7; i10++) {
                        AbstractTimeFramedListFragment.C2463a c2463a = c2463aArr[i10 - 1];
                        if (i10 == 6) {
                            if (!c2463a.equals((C2547j) this.f10215h.get(i10))) {
                                this.f10215h.set(i10, c2463a);
                                sparseArray2.put(i8, c2463a);
                            }
                        } else if (!c2463a.equals((C2550l) this.f10215h.get(i10))) {
                            this.f10215h.set(i10, c2463a);
                            sparseArray2.put(i8, c2463a);
                        }
                        i8++;
                    }
                }
                if (this.f10212e) {
                    for (int i11 = 0; i11 < i8; i11++) {
                        list.add(sparseArray.get(i11));
                    }
                    m812g();
                    int mo747a = mo747a();
                    m6756b(1, mo747a - (mo747a == 1 ? 0 : 1));
                    this.f10212e = false;
                    return;
                }
                List<AbstractTimeFramedListFragment.C2463a> list3 = list;
                for (int i12 = 0; i12 < sparseArray.size(); i12++) {
                    int keyAt = sparseArray.keyAt(i12);
                    list3.add(keyAt, sparseArray.get(keyAt));
                }
                SparseArray<AbstractTimeFramedListFragment.C2463a> m820a = m820a(sparseArray);
                for (int i13 = 0; i13 < m820a.size(); i13++) {
                    m6747e(m820a.keyAt(i13));
                }
                for (int i14 = 0; i14 < sparseArray2.size(); i14++) {
                    int keyAt2 = sparseArray2.keyAt(i14);
                    list3.set(keyAt2, sparseArray2.get(keyAt2));
                }
                SparseArray<AbstractTimeFramedListFragment.C2463a> m820a2 = m820a(sparseArray2);
                for (int i15 = 0; i15 < m820a2.size(); i15++) {
                    m6749d(m820a2.keyAt(i15));
                }
            }
        }

        @Override // p205h.p208b.p209a.p210d.RemoteUserResultListener
        /* renamed from: b */
        public void mo741b(AsyncResult<UserProfile> asyncResult) {
            PaymentDataFragment.this.f10200j0 = asyncResult.mo1334a();
            if (this.f10211d) {
                PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                if (paymentDataFragment.f9860b0 != null && paymentDataFragment.m7540K()) {
                    AlertDialog.C0325a c0325a = new AlertDialog.C0325a(PaymentDataFragment.this.f9860b0);
                    c0325a.m9131b(PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_paymentinstructions));
                    c0325a.m9140a(PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_paymentmb_profile_instructions));
                    c0325a.m9133b(17039370, (DialogInterface.OnClickListener) null);
                    c0325a.m9138a(false);
                    c0325a.m9129c();
                }
                this.f10211d = false;
            }
            m814e();
        }

        /* renamed from: g */
        public final void m812g() {
            List<AbstractTimeFramedListFragment.C2463a> list = this.f10216i;
            list.clear();
            boolean z = true;
            for (AbstractTimeFramedListFragment.C2463a c2463a : this.f10210c) {
                int i = c2463a.f9967c;
                if (i == 1 || i == 4) {
                    list.add(c2463a);
                    C2541e c2541e = (C2541e) c2463a;
                    if (this.f10217j.contains(Integer.valueOf(c2541e.f10233g))) {
                        c2541e.f10232f = true;
                    }
                    z = c2541e.f10232f;
                } else if (z || (i != 2 && i != 5 && i != 6 && i != 7 && i != 8)) {
                    list.add(c2463a);
                }
            }
        }

        /* renamed from: a */
        public final SparseArray<AbstractTimeFramedListFragment.C2463a> m820a(SparseArray<AbstractTimeFramedListFragment.C2463a> sparseArray) {
            List<AbstractTimeFramedListFragment.C2463a> list = this.f10216i;
            SparseArray<AbstractTimeFramedListFragment.C2463a> sparseArray2 = new SparseArray<>();
            list.clear();
            boolean z = true;
            int i = 0;
            for (int i2 = 0; i2 < this.f10210c.size(); i2++) {
                boolean z2 = sparseArray.indexOfKey(i2) >= 0;
                AbstractTimeFramedListFragment.C2463a c2463a = this.f10210c.get(i2);
                int i3 = c2463a.f9967c;
                if (i3 == 1 || i3 == 4) {
                    list.add(c2463a);
                    C2541e c2541e = (C2541e) c2463a;
                    if (z2) {
                        sparseArray2.put(i, c2463a);
                    }
                    if (this.f10217j.contains(Integer.valueOf(c2541e.f10233g))) {
                        c2541e.f10232f = true;
                    }
                    z = c2541e.f10232f;
                } else {
                    if (z || (i3 != 2 && i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8)) {
                        list.add(c2463a);
                        if (z2) {
                            sparseArray2.put(i, c2463a);
                        }
                    }
                }
                i++;
            }
            return sparseArray2;
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(BaseItemView baseItemView, int i) {
            baseItemView.mo692a(this.f10216i.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            return this.f10216i.size();
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$c */
    /* loaded from: classes.dex */
    public static class C2539c extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final CharSequence f10223f;

        /* renamed from: g */
        public final CharSequence f10224g;

        /* renamed from: h */
        public int f10225h;

        public C2539c(String str, String str2, int i, CharSequence charSequence, CharSequence charSequence2) {
            super(0, 5, str == null ? "" : str, 0);
            this.f9966b = str2;
            this.f10225h = i;
            this.f10223f = charSequence;
            this.f10224g = charSequence2;
        }

        public boolean equals(Object obj) {
            CharSequence charSequence;
            CharSequence charSequence2;
            if ((obj instanceof C2539c) && (charSequence = this.f10223f) != null) {
                C2539c c2539c = (C2539c) obj;
                if (charSequence.equals(c2539c.f10223f) && (charSequence2 = this.f10224g) != null && charSequence2.equals(c2539c.f10224g)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$d */
    /* loaded from: classes.dex */
    public class C2540d extends BaseItemView {

        /* renamed from: u */
        public ImageView f10226u;

        /* renamed from: v */
        public TextView f10227v;

        /* renamed from: w */
        public TextView f10228w;

        /* renamed from: x */
        public TextView f10229x;

        /* renamed from: y */
        public C2539c f10230y;

        public C2540d(View view) {
            super(view);
            this.f10226u = (ImageView) view.findViewById(C1444R.C1446id.logo);
            this.f10227v = (TextView) view.findViewById(C1444R.C1446id.methodName);
            this.f10228w = (TextView) view.findViewById(C1444R.C1446id.info);
            this.f10229x = (TextView) view.findViewById(C1444R.C1446id.tInstructions);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            this.f10230y = (C2539c) c2463a;
            this.f10227v.setText(this.f10230y.f9968d);
            this.f10228w.setText(this.f10230y.f10223f);
            if (this.f10230y.f10224g != null) {
                this.f10229x.setText(this.f10230y.f10224g);
            } else {
                this.f10229x.setVisibility(8);
            }
            String charSequence = this.f10230y.f9966b.toString();
            boolean z = false;
            if (PaymentDataFragment.f10192s0.containsKey(charSequence)) {
                if (PaymentDataFragment.this.f10207q0.get(charSequence) != null ? ((RunnableC2546i) PaymentDataFragment.this.f10207q0.get(charSequence)).m792a(this.f10230y.f10225h, charSequence, this.f10226u) : true) {
                    this.f10226u.setImageBitmap((Bitmap) PaymentDataFragment.f10192s0.get(charSequence));
                }
                z = true;
            }
            if (z) {
                return;
            }
            if (PaymentDataFragment.this.f10207q0.get(charSequence) != null ? ((RunnableC2546i) PaymentDataFragment.this.f10207q0.get(charSequence)).m792a(this.f10230y.f10225h, charSequence, this.f10226u) : true) {
                RunnableC2546i runnableC2546i = new RunnableC2546i(this.f10230y.f10225h, charSequence, this.f10226u);
                PaymentDataFragment.this.f10207q0.put(charSequence, runnableC2546i);
                Anda.m1467X().m1449a(runnableC2546i);
            }
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$e */
    /* loaded from: classes.dex */
    public class C2541e extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public boolean f10232f;

        /* renamed from: g */
        public int f10233g;

        public C2541e(PaymentDataFragment paymentDataFragment, String str, int i) {
            super(0, 1, str == null ? "" : str, 0);
            this.f10232f = false;
            this.f10233g = i;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$f */
    /* loaded from: classes.dex */
    public static class C2542f extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final boolean f10234f;

        /* renamed from: g */
        public final int f10235g;

        /* renamed from: h */
        public final DataModels.PaymentMethod f10236h;

        public C2542f(String str, boolean z, String str2, int i, DataModels.PaymentMethod paymentMethod) {
            super(0, 2, str == null ? "" : str, 0);
            this.f10234f = z;
            this.f9966b = str2;
            this.f10235g = i;
            this.f10236h = paymentMethod;
        }

        public boolean equals(Object obj) {
            DataModels.PaymentMethod paymentMethod;
            if ((obj instanceof C2542f) && (paymentMethod = this.f10236h) != null) {
                C2542f c2542f = (C2542f) obj;
                if (paymentMethod.getCode().equals(c2542f.f10236h.getCode()) && this.f10234f == c2542f.f10234f) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$h */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2545h extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public final TextView f10244u;

        /* renamed from: v */
        public final ImageButton f10245v;

        /* renamed from: w */
        public final GroupSeparatorDrawable f10246w;

        public View$OnClickListenerC2545h(View view) {
            super(view);
            this.f10244u = (TextView) view.findViewById(C1444R.C1446id.title);
            view.findViewById(C1444R.C1446id.bottomDivider);
            this.f10246w = new GroupSeparatorDrawable(PaymentDataFragment.this.f10201k0.f10218k);
            GroupSeparatorDrawable groupSeparatorDrawable = this.f10246w;
            groupSeparatorDrawable.f9743b = true;
            view.setBackground(groupSeparatorDrawable);
            this.f10245v = (ImageButton) view.findViewById(C1444R.C1446id.icon);
            view.setOnClickListener(this);
            this.f10245v.setOnClickListener(this);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2541e c2541e = (C2541e) c2463a;
            this.f10244u.setText(c2541e.f9968d);
            ImageButton imageButton = this.f10245v;
            if (imageButton != null) {
                imageButton.setImageResource(c2541e.f10232f ? C1444R.C1445drawable.ic_keyboard_arrow_up_black_24dp : C1444R.C1445drawable.ic_keyboard_arrow_down_black_24dp);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int m6807h = m6807h();
            if (m6807h != -1) {
                PaymentDataFragment.this.f10201k0.m811g(m6807h);
            }
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$j */
    /* loaded from: classes.dex */
    public static class C2547j extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final String f10252f;

        public /* synthetic */ C2547j(int i, CharSequence charSequence, C2535a c2535a) {
            this(i, charSequence);
        }

        public boolean equals(Object obj) {
            return (obj instanceof C2547j) && this.f10252f.equals(((C2547j) obj).f10252f);
        }

        public C2547j(int i, CharSequence charSequence) {
            super(i, 8, charSequence == null ? "" : charSequence, 0);
            this.f10252f = charSequence != null ? charSequence.toString() : "";
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$l */
    /* loaded from: classes.dex */
    public static class C2550l extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final boolean f10258f;

        /* renamed from: g */
        public final String f10259g;

        /* renamed from: h */
        public final String f10260h;

        public /* synthetic */ C2550l(int i, CharSequence charSequence, CharSequence charSequence2, boolean z, C2535a c2535a) {
            this(i, charSequence, charSequence2, z);
        }

        public boolean equals(Object obj) {
            String str;
            return (obj instanceof C2550l) && ((this.f10260h == null && ((C2550l) obj).f10260h == null) || ((str = ((C2550l) obj).f10260h) != null && str.equals(this.f10260h)));
        }

        public C2550l(int i, CharSequence charSequence, CharSequence charSequence2, boolean z) {
            super(i, 7, charSequence == null ? "" : charSequence, 0);
            this.f10259g = charSequence != null ? charSequence.toString() : "";
            this.f10260h = charSequence2 == null ? null : charSequence2.toString();
            this.f10258f = z;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$m */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2551m extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public TextView f10261u;

        /* renamed from: v */
        public TextView f10262v;

        /* renamed from: w */
        public C2550l f10263w;

        public View$OnClickListenerC2551m(View view) {
            super(view);
            this.f10261u = (TextView) view.findViewById(C1444R.C1446id.name);
            this.f10262v = (TextView) view.findViewById(C1444R.C1446id.value);
            view.setOnClickListener(this);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            this.f10263w = (C2550l) c2463a;
            this.f10261u.setText(this.f10263w.f10259g);
            if (this.f10263w.f10260h != null && !this.f10263w.f10260h.isEmpty()) {
                this.f10262v.setHint((CharSequence) null);
                this.f10262v.setText(this.f10263w.f10260h);
                return;
            }
            this.f10262v.setHint(C1444R.string.not_defined);
            this.f10262v.setText((CharSequence) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PaymentDataFragment.this.m845a(this.f10263w);
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$n */
    /* loaded from: classes.dex */
    public class C2552n {
        public C2552n(Context context) {
        }

        /* renamed from: a */
        public /* synthetic */ void m782a() {
            PaymentDataFragment.this.f10196f0.dismiss();
        }

        @JavascriptInterface
        public void closeWebView() {
            if (PaymentDataFragment.this.f10196f0 != null) {
                PaymentDataFragment.this.f10195e0.post(new Runnable() { // from class: h.b.a.e.d.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PaymentDataFragment.C2552n.this.m782a();
                    }
                });
            }
        }
    }

    @Override // p205h.p208b.p209a.p210d.CountriesListener
    /* renamed from: a */
    public void mo738a(List<DataModels.Language> list) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            m823p0();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ((InputMethodManager) Objects.requireNonNull(((Context) Objects.requireNonNull(this.f9860b0)).getSystemService("input_method"))).toggleSoftInput(1, 0);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.f10199i0.dismiss();
            m823p0();
            return true;
        }
        return false;
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onError(DataModels.Error error) {
        this.f10197g0.setVisibility(4);
        for (RemoteUserResultListener remoteUserResultListener : this.f10202l0) {
            remoteUserResultListener.onError(error);
        }
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        this.f10197g0.setVisibility(4);
        AsyncResult<UserProfile> mo1250a = Anda.m1467X().m1400o().mo1278b().mo1250a(userAccountInfo);
        for (RemoteUserResultListener remoteUserResultListener : this.f10202l0) {
            remoteUserResultListener.mo741b(mo1250a);
        }
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: p0 */
    public final void m823p0() {
        String str;
        UserProfile.InterfaceC2377d edit = this.f10200j0.edit();
        if (this.f10206p0.f9965a != 4) {
            EditText editText = this.f10198h0;
            if (editText == null) {
                return;
            }
            str = editText.getText().toString().trim();
        } else {
            str = "";
        }
        switch (this.f10206p0.f9965a) {
            case 0:
                edit.mo1228g(str);
                break;
            case 1:
                edit.mo1231d(str);
                break;
            case 2:
                edit.mo1229f(str);
                break;
            case 3:
                edit.mo1225j(str);
            case 4:
                DataModels.Country country = this.f10205o0;
                if (country == null) {
                    Log.w("PaymentDataFragment.class", "selectedCountry is null, it will not be updated");
                    break;
                } else {
                    edit.mo1234a(country);
                    break;
                }
            case 5:
                edit.mo1227h(str);
                break;
            case 6:
                edit.mo1235a(str);
                break;
        }
        this.f10194d0 = this.f10193c0.m1447a(this.f9860b0.getString(C1444R.string.profile_state_updating), -1);
        this.f10194d0.mo7619m();
        edit.mo1214o().m1375a(this.f10208r0);
    }

    /* renamed from: q0 */
    public /* synthetic */ void m822q0() {
        ((InputMethodManager) Objects.requireNonNull(this.f9860b0.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.f10198h0.selectAll();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10193c0 = Anda.m1443b(m7452q());
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$i */
    /* loaded from: classes.dex */
    public class RunnableC2546i implements Runnable {

        /* renamed from: a */
        public final int f10248a;

        /* renamed from: b */
        public final String f10249b;

        /* renamed from: c */
        public ImageView f10250c;

        public RunnableC2546i(int i, String str, ImageView imageView) {
            this.f10248a = i;
            this.f10249b = str;
            this.f10250c = imageView;
        }

        /* renamed from: a */
        public void m793a() {
        }

        /* renamed from: a */
        public boolean m792a(int i, String str, ImageView imageView) {
            if (this.f10248a == i && str.equals(this.f10249b)) {
                this.f10250c = imageView;
                return false;
            }
            m793a();
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Bitmap decodeStream = BitmapFactory.decodeStream(new URL(this.f10249b).openConnection().getInputStream());
                PaymentDataFragment.this.f10203m0.mo807d().post(new Runnable() { // from class: h.b.a.e.d.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PaymentDataFragment.RunnableC2546i.this.m791a(decodeStream);
                    }
                });
            } catch (IOException unused) {
            }
        }

        /* renamed from: a */
        public /* synthetic */ void m791a(Bitmap bitmap) {
            PaymentDataFragment.f10192s0.put(this.f10249b, bitmap);
            this.f10250c.setImageBitmap(bitmap);
            PaymentDataFragment.this.f10207q0.remove(this.f10249b);
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$k */
    /* loaded from: classes.dex */
    public class C2548k extends BaseItemView implements CountryCodePicker.OnCountryChangeListener {

        /* renamed from: u */
        public CountryCodePicker f10253u;

        /* renamed from: v */
        public boolean f10254v;

        /* compiled from: PaymentDataFragment.java */
        /* renamed from: h.b.a.e.d.s3$k$a */
        /* loaded from: classes.dex */
        public class C2549a implements CountryCodePicker.DialogEventsListener {

            /* renamed from: a */
            public final /* synthetic */ AbstractTimeFramedListFragment.C2463a f10256a;

            public C2549a(AbstractTimeFramedListFragment.C2463a c2463a) {
                this.f10256a = c2463a;
            }

            @Override // com.hbb20.CountryCodePicker.DialogEventsListener
            /* renamed from: a */
            public void mo788a(Dialog dialog) {
                PaymentDataFragment.this.f10206p0 = this.f10256a;
            }

            @Override // com.hbb20.CountryCodePicker.DialogEventsListener
            /* renamed from: a */
            public void mo787a(DialogInterface dialogInterface) {
            }

            @Override // com.hbb20.CountryCodePicker.DialogEventsListener
            /* renamed from: b */
            public void mo786b(DialogInterface dialogInterface) {
            }
        }

        public C2548k(View view) {
            super(view);
            this.f10254v = true;
            this.f10253u = (CountryCodePicker) view.findViewById(C1444R.C1446id.ccpPicker);
            this.f10253u.setOnCountryChangeListener(this);
            this.f10253u.setCountryPreference("pt");
            this.f10254v = false;
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            this.f10253u.setCountryForNameCode(((C2547j) c2463a).f10252f);
            this.f10253u.setDialogEventsListener(new C2549a(c2463a));
        }

        @Override // com.hbb20.CountryCodePicker.OnCountryChangeListener
        /* renamed from: a */
        public void mo789a() {
            if (this.f10254v) {
                return;
            }
            String selectedCountryNameCode = this.f10253u.getSelectedCountryNameCode();
            if (selectedCountryNameCode.equals(PaymentDataFragment.this.f10200j0.mo1237l()) || !PaymentDataFragment.this.f10204n0.containsKey(selectedCountryNameCode)) {
                return;
            }
            PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
            paymentDataFragment.f10205o0 = (DataModels.Country) paymentDataFragment.f10204n0.get(selectedCountryNameCode);
            PaymentDataFragment.this.m823p0();
        }
    }

    @Override // p205h.p208b.p209a.p210d.CountriesListener
    /* renamed from: b */
    public void mo737b(List<DataModels.Country> list) {
        if (!this.f10204n0.isEmpty()) {
            this.f10204n0.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            DataModels.Country country = list.get(i);
            this.f10204n0.put(country.getCode(), country);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1444R.layout.fragment_personal_data, viewGroup, false);
        this.f10195e0 = viewGroup2;
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(C1444R.C1446id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f9860b0));
        this.f10197g0 = (ProgressBar) viewGroup2.findViewById(C1444R.C1446id.progress);
        this.f10201k0 = new C2536b();
        recyclerView.setAdapter(this.f10201k0);
        Anda m1467X = Anda.m1467X();
        m1467X.m1400o().mo1282a(this);
        m1467X.m1456a(this);
        return viewGroup2;
    }

    /* compiled from: PaymentDataFragment.java */
    /* renamed from: h.b.a.e.d.s3$g */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2543g extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public ImageView f10237u;

        /* renamed from: v */
        public ImageView f10238v;

        /* renamed from: w */
        public TextView f10239w;

        /* renamed from: x */
        public TextView f10240x;

        /* renamed from: y */
        public C2542f f10241y;

        public View$OnClickListenerC2543g(View view) {
            super(view);
            this.f10237u = (ImageView) view.findViewById(C1444R.C1446id.check);
            this.f10238v = (ImageView) view.findViewById(C1444R.C1446id.logo);
            this.f10239w = (TextView) view.findViewById(C1444R.C1446id.methodName);
            this.f10240x = (TextView) view.findViewById(C1444R.C1446id.methodDescription);
            view.setOnClickListener(this);
        }

        /* renamed from: C */
        public final void m798C() {
            BackEnd.selectPaymentMethod(this.f10241y.f10236h, new C2544a());
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            DataModels.PaymentMethodMessage[] messages;
            this.f10241y = (C2542f) c2463a;
            if (this.f10241y.f10234f) {
                this.f10237u.setImageDrawable(ContextCompat.m10016c(PaymentDataFragment.this.f9860b0, C1444R.C1445drawable.ic_check_black_24dp));
            } else {
                this.f10237u.setImageDrawable(null);
            }
            this.f10239w.setText(this.f10241y.f9968d);
            boolean z = false;
            for (DataModels.PaymentMethodMessage paymentMethodMessage : this.f10241y.f10236h.getMessages()) {
                if (paymentMethodMessage.getCode().trim().equals("DELAY_INFO")) {
                    this.f10240x.setText(paymentMethodMessage.getValue());
                }
            }
            String charSequence = this.f10241y.f9966b.toString();
            if (PaymentDataFragment.f10192s0.containsKey(charSequence)) {
                if (PaymentDataFragment.this.f10207q0.get(charSequence) != null ? ((RunnableC2546i) PaymentDataFragment.this.f10207q0.get(charSequence)).m792a(this.f10241y.f10235g, charSequence, this.f10238v) : true) {
                    this.f10238v.setImageBitmap((Bitmap) PaymentDataFragment.f10192s0.get(charSequence));
                }
                z = true;
            }
            if (z) {
                return;
            }
            if (PaymentDataFragment.this.f10207q0.get(charSequence) != null ? ((RunnableC2546i) PaymentDataFragment.this.f10207q0.get(charSequence)).m792a(this.f10241y.f10235g, charSequence, this.f10238v) : true) {
                RunnableC2546i runnableC2546i = new RunnableC2546i(this.f10241y.f10235g, charSequence, this.f10238v);
                PaymentDataFragment.this.f10207q0.put(charSequence, runnableC2546i);
                Anda.m1467X().m1449a(runnableC2546i);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog.C0325a c0325a = new AlertDialog.C0325a(PaymentDataFragment.this.f9860b0);
            c0325a.m9131b(PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_payment));
            c0325a.m9140a(PaymentDataFragment.this.m846a(this.f10241y));
            c0325a.m9138a(false);
            c0325a.m9133b(C1444R.string.yes, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.t0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    PaymentDataFragment.View$OnClickListenerC2543g.this.m797a(dialogInterface, i);
                }
            });
            c0325a.m9146a(C1444R.string.f6337no, (DialogInterface.OnClickListener) null);
            c0325a.m9129c();
        }

        /* compiled from: PaymentDataFragment.java */
        /* renamed from: h.b.a.e.d.s3$g$a */
        /* loaded from: classes.dex */
        public class C2544a implements BackendListeners.SelectPaymentMethodRequestListener {
            public C2544a() {
            }

            /* renamed from: a */
            public static /* synthetic */ void m795a(DialogInterface dialogInterface, int i) {
            }

            /* renamed from: a */
            public /* synthetic */ void m794a(DataModels.PaymentInfo paymentInfo, DialogInterface dialogInterface, int i) {
                String procedureURL = paymentInfo.getProcedureURL();
                if (procedureURL != null) {
                    AlertDialog.C0325a c0325a = new AlertDialog.C0325a(PaymentDataFragment.this.f9860b0, 16973838);
                    LinearLayout linearLayout = new LinearLayout(PaymentDataFragment.this.f9860b0);
                    linearLayout.setOrientation(1);
                    EditText editText = new EditText(PaymentDataFragment.this.f9860b0);
                    WebView webView = new WebView(PaymentDataFragment.this.f9860b0);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.loadUrl(procedureURL);
                    PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                    webView.addJavascriptInterface(new C2552n(paymentDataFragment.f9860b0), "Android");
                    editText.setVisibility(8);
                    editText.requestFocus();
                    linearLayout.addView(webView);
                    linearLayout.addView(editText);
                    c0325a.m9132b(linearLayout);
                    AlertDialog m9148a = c0325a.m9148a();
                    webView.setWebViewClient(new C2557t3(this, m9148a));
                    PaymentDataFragment.this.f10196f0 = m9148a;
                    PaymentDataFragment.this.f10196f0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: h.b.a.e.d.s0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface2) {
                            PaymentDataFragment.View$OnClickListenerC2543g.C2544a.this.m796a(dialogInterface2);
                        }
                    });
                    m9148a.show();
                }
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.SelectPaymentMethodRequestListener
            @SuppressLint({"SetJavaScriptEnabled"})
            public void onSuccess(DataModels.PaymentAction paymentAction, final DataModels.PaymentInfo paymentInfo) {
                if (!paymentAction.name().equals(DataModels.PaymentAction.NO_ACTION_NEEDED.name())) {
                    DataModels.PaymentMethodMessage[] messages = View$OnClickListenerC2543g.this.f10241y.f10236h.getMessages();
                    if (messages == null) {
                        return;
                    }
                    String str = "";
                    for (int i = 0; i < messages.length; i++) {
                        if (messages[i].getCode().equals("PAYMENT_REDIRECTION")) {
                            str = messages[i].getValue();
                        }
                    }
                    AlertDialog.C0325a c0325a = new AlertDialog.C0325a(PaymentDataFragment.this.f9860b0);
                    c0325a.m9134b(C1444R.string.redirect_confirm);
                    c0325a.m9140a(str);
                    c0325a.m9138a(false);
                    c0325a.m9130b("OK", new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.r0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            PaymentDataFragment.View$OnClickListenerC2543g.C2544a.this.m794a(paymentInfo, dialogInterface, i2);
                        }
                    });
                    c0325a.m9146a(17039360, DialogInterface$OnClickListenerC2521q0.f10154a);
                    c0325a.m9129c();
                    return;
                }
                PaymentDataFragment paymentDataFragment = PaymentDataFragment.this;
                paymentDataFragment.f10194d0 = paymentDataFragment.f10193c0.m1447a(PaymentDataFragment.this.f9860b0.getString(C1444R.string.user_paymentdata_updated_success), -1);
                PaymentDataFragment.this.f10194d0.mo7619m();
                PaymentDataFragment.this.f10203m0.mo805f();
            }

            /* renamed from: a */
            public /* synthetic */ void m796a(DialogInterface dialogInterface) {
                PaymentDataFragment.this.f10203m0.mo810a();
                PaymentDataFragment.this.f10196f0 = null;
            }
        }

        /* renamed from: a */
        public /* synthetic */ void m797a(DialogInterface dialogInterface, int i) {
            m798C();
        }
    }

    /* renamed from: a */
    public final void m847a(RemoteUserResultListener remoteUserResultListener) {
        if (this.f10202l0.contains(remoteUserResultListener)) {
            return;
        }
        this.f10202l0.add(remoteUserResultListener);
    }

    /* renamed from: a */
    public final void m845a(C2550l c2550l) {
        if (!c2550l.f10258f) {
            Context context = this.f9860b0;
            Toast.makeText(context, context.getString(C1444R.string.edit_field_not_editable), 0).show();
            return;
        }
        this.f10206p0 = c2550l;
        final AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
        c0325a.m9131b(c2550l.f10259g);
        int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, m7549B().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(this.f9860b0);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(applyDimension, applyDimension / 4, applyDimension, 0);
        this.f10198h0 = new EditText(this.f9860b0);
        this.f10198h0.setSingleLine();
        this.f10198h0.setText(c2550l.f10260h);
        this.f10198h0.setImeOptions(6);
        linearLayout.addView(this.f10198h0);
        this.f10198h0.setOnEditorActionListener(this);
        c0325a.m9132b(linearLayout);
        c0325a.m9133b(C1444R.string.user_action_save, this);
        c0325a.m9146a(17039360, this);
        c0325a.m9145a(this);
        this.f10195e0.post(new Runnable() { // from class: h.b.a.e.d.x0
            @Override // java.lang.Runnable
            public final void run() {
                PaymentDataFragment.this.m848a(c0325a);
            }
        });
        this.f10198h0.post(new Runnable() { // from class: h.b.a.e.d.w0
            @Override // java.lang.Runnable
            public final void run() {
                PaymentDataFragment.this.m822q0();
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m848a(AlertDialog.C0325a c0325a) {
        this.f10199i0 = c0325a.m9129c();
    }

    /* renamed from: a */
    public final String m846a(C2542f c2542f) {
        if (this.f10200j0.mo1239j() == null || !c2542f.f10236h.getCode().equals(this.f10200j0.mo1239j().mo1222c())) {
            return this.f9860b0.getString(C1444R.string.payment_confirmation, c2542f.f10236h.getName());
        }
        if (c2542f.f10236h.getCode().equals("PBV")) {
            return this.f9860b0.getString(C1444R.string.mb_select_same_payment_method);
        }
        return this.f9860b0.getString(C1444R.string.card_select_same_payment_method);
    }
}
