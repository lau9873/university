package h.b.a.e.d;

import a.b.h.a.c;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.hbb20.CountryCodePicker;
import h.b.a.d.b;
import h.b.a.d.u;
import h.b.a.d.y;
import h.b.a.e.d.i3;
import h.b.a.e.d.s3;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: PaymentDataFragment.java */
/* loaded from: classes.dex */
public class s3 extends g3 implements h.b.a.d.s, TextView.OnEditorActionListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, h.b.a.d.e {
    public static final HashMap<String, Bitmap> s0 = new HashMap<>(2);
    public h.b.a.c c0;
    public Snackbar d0;
    public ViewGroup e0;
    public a.b.h.a.c f0;
    public ProgressBar g0;
    public EditText h0;
    public a.b.h.a.c i0;
    public h.b.a.d.y j0;
    public b k0;
    public h.b.a.d.r m0;
    public DataModels.Country o0;
    public i3.a p0;
    public List<h.b.a.d.t> l0 = new ArrayList();
    public HashMap<String, DataModels.Country> n0 = new HashMap<>();
    public final HashMap<String, i> q0 = new HashMap<>(2);
    public b.a<u.d> r0 = new a();

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class a implements b.a<u.d> {
        public a() {
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<u.d> bVar) {
            u.d a2 = bVar.a();
            if (s3.this.K()) {
                if (a2.c()) {
                    s3.this.k0.f();
                    s3 s3Var = s3.this;
                    s3Var.d0 = s3Var.c0.a(s3.this.b0.getString(2131755304), 0);
                    s3.this.d0.m();
                } else {
                    s3 s3Var2 = s3.this;
                    s3Var2.d0 = s3Var2.c0.a(a2.b(), -1);
                    s3.this.d0.m();
                }
            }
            s3.this.i0 = null;
            s3.this.h0 = null;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.g<h.b.a.e.f.a> implements h.b.a.d.t {

        /* renamed from: c  reason: collision with root package name */
        public final List<i3.a> f7329c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public boolean f7330d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7331e = true;

        /* renamed from: f  reason: collision with root package name */
        public final List<i3.a> f7332f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public final List<i3.a> f7333g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public final List<i3.a> f7334h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public final List<i3.a> f7335i = new ArrayList();
        public final List<Integer> j = new ArrayList();
        public final float k;

        /* compiled from: PaymentDataFragment.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.PaymentMethodsRequestListener {

            /* compiled from: PaymentDataFragment.java */
            /* renamed from: h.b.a.e.d.s3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0168a implements h.b.a.d.r {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ List f7337a;

                public C0168a(List list) {
                    this.f7337a = list;
                }

                @Override // h.b.a.d.r
                public void a() {
                    b.this.f();
                }

                @Override // h.b.a.d.r
                public h.b.a.d.y b() {
                    return s3.this.j0;
                }

                @Override // h.b.a.d.r
                public List<DataModels.PaymentMethod> c() {
                    return this.f7337a;
                }

                @Override // h.b.a.d.r
                public View d() {
                    return s3.this.e0;
                }

                @Override // h.b.a.d.r
                public boolean e() {
                    return s3.this.j0.j() != null;
                }

                @Override // h.b.a.d.r
                public void f() {
                    b.this.f7330d = true;
                    b.this.f();
                }
            }

            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                s3 s3Var = s3.this;
                s3Var.d0 = s3Var.c0.a(error.getMessageToUser(), -1);
                s3.this.d0.m();
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.PaymentMethodsRequestListener
            public void onSuccess(List<DataModels.PaymentMethod> list) {
                b.this.a(new C0168a(list));
            }
        }

        public b() {
            this.k = TypedValue.applyDimension(1, 1.0f, s3.this.B().getDisplayMetrics());
            s3.this.a((h.b.a.d.t) this);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int c(int i2) {
            return this.f7335i.get(i2).f7216c;
        }

        public final void e() {
            BackEnd.getPaymentMethods(new a());
        }

        public void f() {
            this.j.clear();
            int size = this.f7335i.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f7335i.get(i2) instanceof e) {
                    e eVar = (e) this.f7335i.get(i2);
                    if (eVar.f7342f) {
                        this.j.add(Integer.valueOf(eVar.f7343g));
                    }
                }
            }
            if (this.f7331e) {
                this.f7335i.clear();
                c(0, size);
            }
            h.b.a.c.X().o().a(s3.this);
        }

        public void g(int i2) {
            int i3;
            int i4;
            i3.a aVar = this.f7335i.get(i2);
            int i5 = aVar.f7216c;
            if (i5 == 1 || i5 == 4) {
                e eVar = (e) aVar;
                int i6 = 0;
                int i7 = i2 + 1;
                boolean z = eVar.f7342f;
                eVar.f7342f = !z;
                if (z) {
                    while (i7 < this.f7335i.size() && ((i4 = this.f7335i.get(i7).f7216c) == 2 || i4 == 5 || i4 == 6 || i4 == 7 || i4 == 8)) {
                        i6++;
                        this.f7335i.remove(i7);
                    }
                    d(i7 - 1);
                    c(i7, i6);
                    return;
                }
                int indexOf = this.f7329c.indexOf(aVar);
                while (true) {
                    indexOf++;
                    if (indexOf >= this.f7329c.size() || !((i3 = this.f7329c.get(indexOf).f7216c) == 2 || i3 == 5 || i3 == 6 || i3 == 7 || i3 == 8)) {
                        break;
                    }
                    i6++;
                    this.f7335i.add(i7, this.f7329c.get(indexOf));
                    i7++;
                }
                int i8 = i7 - i6;
                d(i8 - 1);
                b(i8, i6);
            }
        }

        @Override // h.b.a.d.t
        public void onError(DataModels.Error error) {
            s3 s3Var = s3.this;
            s3Var.d0 = s3Var.c0.a(String.format(Locale.getDefault(), "%s: %s", s3.this.b0.getString(2131755195), error.getMessageToUser()), -1);
            s3.this.d0.m();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public h.b.a.e.f.a b(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                s3 s3Var = s3.this;
                return new h(LayoutInflater.from(s3Var.b0).inflate(2131427396, viewGroup, false));
            } else if (i2 == 2) {
                s3 s3Var2 = s3.this;
                return new g(LayoutInflater.from(s3Var2.b0).inflate(2131427407, viewGroup, false));
            } else if (i2 == 5) {
                s3 s3Var3 = s3.this;
                return new d(LayoutInflater.from(s3Var3.b0).inflate(2131427372, viewGroup, false));
            } else if (i2 == 7) {
                s3 s3Var4 = s3.this;
                return new m(LayoutInflater.from(s3Var4.b0).inflate(2131427408, viewGroup, false));
            } else if (i2 == 8) {
                s3 s3Var5 = s3.this;
                return new k(LayoutInflater.from(s3Var5.b0).inflate(2131427409, viewGroup, false));
            } else {
                return null;
            }
        }

        public final void a(h.b.a.d.r rVar) {
            int i2;
            List<i3.a> list;
            f fVar;
            if (s3.this.K()) {
                SparseArray<i3.a> sparseArray = new SparseArray<>();
                SparseArray<i3.a> sparseArray2 = new SparseArray<>();
                List<i3.a> list2 = this.f7329c;
                if (this.f7331e) {
                    list2.clear();
                }
                if (this.f7332f.isEmpty()) {
                    s3 s3Var = s3.this;
                    i3.a eVar = new e(s3Var, s3Var.b0.getString(2131755401), 1);
                    this.f7332f.add(eVar);
                    sparseArray.put(0, eVar);
                }
                s3.this.m0 = rVar;
                y.b j = s3.this.m0.b().j();
                String c2 = j != null ? j.c() : "";
                int i3 = 1;
                int i4 = 0;
                for (DataModels.PaymentMethod paymentMethod : s3.this.m0.c()) {
                    int i5 = i3;
                    f fVar2 = new f(paymentMethod.getName(), c2.equals(paymentMethod.getCode()), paymentMethod.getThumbnailURL(), i4, paymentMethod);
                    if (fVar2.f7346h.getName().contains("Pagamento SIBS")) {
                        fVar = fVar2;
                        fVar.f7217d = "Cartão crédito/débito";
                        fVar.f7346h.setName("Cartão crédito/débito");
                    } else {
                        fVar = fVar2;
                    }
                    int i6 = 1;
                    boolean z = false;
                    while (true) {
                        if (i6 >= this.f7332f.size()) {
                            break;
                        }
                        if (this.f7332f.get(i6) instanceof f) {
                            f fVar3 = (f) this.f7332f.get(i6);
                            if (!fVar3.f7346h.getCode().equals(paymentMethod.getCode())) {
                                continue;
                            } else if (!fVar3.equals(fVar)) {
                                this.f7332f.set(i6, fVar);
                                sparseArray2.put(i6, fVar);
                                z = true;
                                break;
                            } else {
                                z = true;
                            }
                        }
                        i6++;
                    }
                    if (!z) {
                        this.f7332f.add(fVar);
                        sparseArray.put(i5, fVar);
                    }
                    i3 = i5 + 1;
                    i4++;
                }
                int i7 = i3;
                if (s3.this.m0.e()) {
                    if (this.f7333g.isEmpty()) {
                        s3 s3Var2 = s3.this;
                        i3.a eVar2 = new e(s3Var2, s3Var2.b0.getString(2131755404), 2);
                        sparseArray.put(i7, eVar2);
                        this.f7333g.add(eVar2);
                    }
                    int i8 = i7 + 1;
                    String d2 = (j == null || j.e() != y.b.EnumC0165b.LOW_VALUE) ? null : j.d();
                    y.b j2 = s3.this.j0.j();
                    i3.a cVar = new c(j2.a(), j2.b(), 9999, j2.f(), d2);
                    if (this.f7333g.size() == 1) {
                        sparseArray.put(i8, cVar);
                        this.f7333g.add(cVar);
                    } else if (!((c) this.f7333g.get(1)).equals(cVar)) {
                        this.f7333g.set(1, cVar);
                        sparseArray2.put(i8, cVar);
                    }
                    i2 = i8 + 1;
                } else {
                    i2 = i7;
                }
                String valueOf = (s3.this.j0.e() == null || s3.this.j0.e().equals("")) ? null : String.valueOf(s3.this.j0.e());
                i3.a lVar = new l(0, s3.this.b0.getString(2131755382), s3.this.j0.i(), true, null);
                i3.a lVar2 = new l(1, s3.this.b0.getString(2131755381), s3.this.j0.k(), true, null);
                i3.a lVar3 = new l(2, s3.this.b0.getString(2131755411), s3.this.j0.g(), true, null);
                i3.a lVar4 = new l(3, s3.this.b0.getString(2131755389), valueOf, true, null);
                i3.a lVar5 = new l(5, s3.this.b0.getString(2131755385), s3.this.j0.c(), true, null);
                i3.a jVar = new j(4, s3.this.j0.l(), null);
                i3.a lVar6 = new l(6, s3.this.b0.getString(2131755384), s3.this.j0.m(), true, null);
                if (this.f7334h.isEmpty()) {
                    s3 s3Var3 = s3.this;
                    list = list2;
                    i3.a eVar3 = new e(s3Var3, s3Var3.b0.getString(2131755383), 3);
                    sparseArray.put(i2, eVar3);
                    this.f7334h.add(eVar3);
                } else {
                    list = list2;
                }
                int i9 = i2 + 1;
                i3.a[] aVarArr = {lVar, lVar2, lVar3, lVar5, lVar4, jVar, lVar6};
                if (this.f7334h.size() == 1) {
                    int i10 = 0;
                    while (i10 < aVarArr.length) {
                        this.f7334h.add(aVarArr[i10]);
                        sparseArray.put(i9, aVarArr[i10]);
                        i10++;
                        i9++;
                    }
                } else {
                    for (int i11 = 1; i11 <= 7; i11++) {
                        i3.a aVar = aVarArr[i11 - 1];
                        if (i11 == 6) {
                            if (!aVar.equals((j) this.f7334h.get(i11))) {
                                this.f7334h.set(i11, aVar);
                                sparseArray2.put(i9, aVar);
                            }
                        } else if (!aVar.equals((l) this.f7334h.get(i11))) {
                            this.f7334h.set(i11, aVar);
                            sparseArray2.put(i9, aVar);
                        }
                        i9++;
                    }
                }
                if (this.f7331e) {
                    for (int i12 = 0; i12 < i9; i12++) {
                        list.add(sparseArray.get(i12));
                    }
                    g();
                    int a2 = a();
                    b(1, a2 - (a2 == 1 ? 0 : 1));
                    this.f7331e = false;
                    return;
                }
                List<i3.a> list3 = list;
                for (int i13 = 0; i13 < sparseArray.size(); i13++) {
                    int keyAt = sparseArray.keyAt(i13);
                    list3.add(keyAt, sparseArray.get(keyAt));
                }
                SparseArray<i3.a> a3 = a(sparseArray);
                for (int i14 = 0; i14 < a3.size(); i14++) {
                    e(a3.keyAt(i14));
                }
                for (int i15 = 0; i15 < sparseArray2.size(); i15++) {
                    int keyAt2 = sparseArray2.keyAt(i15);
                    list3.set(keyAt2, sparseArray2.get(keyAt2));
                }
                SparseArray<i3.a> a4 = a(sparseArray2);
                for (int i16 = 0; i16 < a4.size(); i16++) {
                    d(a4.keyAt(i16));
                }
            }
        }

        @Override // h.b.a.d.t
        public void b(h.b.a.d.b<h.b.a.d.y> bVar) {
            s3.this.j0 = bVar.a();
            if (this.f7330d) {
                s3 s3Var = s3.this;
                if (s3Var.b0 != null && s3Var.K()) {
                    c.a aVar = new c.a(s3.this.b0);
                    aVar.b(s3.this.b0.getString(2131755406));
                    aVar.a(s3.this.b0.getString(2131755408));
                    aVar.b(17039370, (DialogInterface.OnClickListener) null);
                    aVar.a(false);
                    aVar.c();
                }
                this.f7330d = false;
            }
            e();
        }

        public final void g() {
            List<i3.a> list = this.f7335i;
            list.clear();
            boolean z = true;
            for (i3.a aVar : this.f7329c) {
                int i2 = aVar.f7216c;
                if (i2 == 1 || i2 == 4) {
                    list.add(aVar);
                    e eVar = (e) aVar;
                    if (this.j.contains(Integer.valueOf(eVar.f7343g))) {
                        eVar.f7342f = true;
                    }
                    z = eVar.f7342f;
                } else if (z || (i2 != 2 && i2 != 5 && i2 != 6 && i2 != 7 && i2 != 8)) {
                    list.add(aVar);
                }
            }
        }

        public final SparseArray<i3.a> a(SparseArray<i3.a> sparseArray) {
            List<i3.a> list = this.f7335i;
            SparseArray<i3.a> sparseArray2 = new SparseArray<>();
            list.clear();
            boolean z = true;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f7329c.size(); i3++) {
                boolean z2 = sparseArray.indexOfKey(i3) >= 0;
                i3.a aVar = this.f7329c.get(i3);
                int i4 = aVar.f7216c;
                if (i4 == 1 || i4 == 4) {
                    list.add(aVar);
                    e eVar = (e) aVar;
                    if (z2) {
                        sparseArray2.put(i2, aVar);
                    }
                    if (this.j.contains(Integer.valueOf(eVar.f7343g))) {
                        eVar.f7342f = true;
                    }
                    z = eVar.f7342f;
                } else {
                    if (z || (i4 != 2 && i4 != 5 && i4 != 6 && i4 != 7 && i4 != 8)) {
                        list.add(aVar);
                        if (z2) {
                            sparseArray2.put(i2, aVar);
                        }
                    }
                }
                i2++;
            }
            return sparseArray2;
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h.b.a.e.f.a aVar, int i2) {
            aVar.a(this.f7335i.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            return this.f7335i.size();
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public static class c extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f7339f;

        /* renamed from: g  reason: collision with root package name */
        public final CharSequence f7340g;

        /* renamed from: h  reason: collision with root package name */
        public int f7341h;

        public c(String str, String str2, int i2, CharSequence charSequence, CharSequence charSequence2) {
            super(0, 5, str == null ? "" : str, 0);
            this.f7215b = str2;
            this.f7341h = i2;
            this.f7339f = charSequence;
            this.f7340g = charSequence2;
        }

        public boolean equals(Object obj) {
            CharSequence charSequence;
            CharSequence charSequence2;
            if ((obj instanceof c) && (charSequence = this.f7339f) != null) {
                c cVar = (c) obj;
                if (charSequence.equals(cVar.f7339f) && (charSequence2 = this.f7340g) != null && charSequence2.equals(cVar.f7340g)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class d extends h.b.a.e.f.a {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public c y;

        public d(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(2131230952);
            this.v = (TextView) view.findViewById(2131230963);
            this.w = (TextView) view.findViewById(2131230924);
            this.x = (TextView) view.findViewById(2131231110);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            this.y = (c) aVar;
            this.v.setText(this.y.f7217d);
            this.w.setText(this.y.f7339f);
            if (this.y.f7340g != null) {
                this.x.setText(this.y.f7340g);
            } else {
                this.x.setVisibility(8);
            }
            String charSequence = this.y.f7215b.toString();
            boolean z = false;
            if (s3.s0.containsKey(charSequence)) {
                if (s3.this.q0.get(charSequence) != null ? ((i) s3.this.q0.get(charSequence)).a(this.y.f7341h, charSequence, this.u) : true) {
                    this.u.setImageBitmap((Bitmap) s3.s0.get(charSequence));
                }
                z = true;
            }
            if (z) {
                return;
            }
            if (s3.this.q0.get(charSequence) != null ? ((i) s3.this.q0.get(charSequence)).a(this.y.f7341h, charSequence, this.u) : true) {
                i iVar = new i(this.y.f7341h, charSequence, this.u);
                s3.this.q0.put(charSequence, iVar);
                h.b.a.c.X().a(iVar);
            }
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class e extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public boolean f7342f;

        /* renamed from: g  reason: collision with root package name */
        public int f7343g;

        public e(s3 s3Var, String str, int i2) {
            super(0, 1, str == null ? "" : str, 0);
            this.f7342f = false;
            this.f7343g = i2;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public static class f extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final boolean f7344f;

        /* renamed from: g  reason: collision with root package name */
        public final int f7345g;

        /* renamed from: h  reason: collision with root package name */
        public final DataModels.PaymentMethod f7346h;

        public f(String str, boolean z, String str2, int i2, DataModels.PaymentMethod paymentMethod) {
            super(0, 2, str == null ? "" : str, 0);
            this.f7344f = z;
            this.f7215b = str2;
            this.f7345g = i2;
            this.f7346h = paymentMethod;
        }

        public boolean equals(Object obj) {
            DataModels.PaymentMethod paymentMethod;
            if ((obj instanceof f) && (paymentMethod = this.f7346h) != null) {
                f fVar = (f) obj;
                if (paymentMethod.getCode().equals(fVar.f7346h.getCode()) && this.f7344f == fVar.f7344f) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class h extends h.b.a.e.f.a implements View.OnClickListener {
        public final TextView u;
        public final ImageButton v;
        public final h.b.a.e.c.b w;

        public h(View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131231149);
            view.findViewById(2131230819);
            this.w = new h.b.a.e.c.b(s3.this.k0.k);
            h.b.a.e.c.b bVar = this.w;
            bVar.f7088b = true;
            view.setBackground(bVar);
            this.v = (ImageButton) view.findViewById(2131230914);
            view.setOnClickListener(this);
            this.v.setOnClickListener(this);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            e eVar = (e) aVar;
            this.u.setText(eVar.f7217d);
            ImageButton imageButton = this.v;
            if (imageButton != null) {
                imageButton.setImageResource(eVar.f7342f ? 2131165590 : 2131165588);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int h2 = h();
            if (h2 != -1) {
                s3.this.k0.g(h2);
            }
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public static class j extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final String f7352f;

        public /* synthetic */ j(int i2, CharSequence charSequence, a aVar) {
            this(i2, charSequence);
        }

        public boolean equals(Object obj) {
            return (obj instanceof j) && this.f7352f.equals(((j) obj).f7352f);
        }

        public j(int i2, CharSequence charSequence) {
            super(i2, 8, charSequence == null ? "" : charSequence, 0);
            this.f7352f = charSequence != null ? charSequence.toString() : "";
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public static class l extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final boolean f7355f;

        /* renamed from: g  reason: collision with root package name */
        public final String f7356g;

        /* renamed from: h  reason: collision with root package name */
        public final String f7357h;

        public /* synthetic */ l(int i2, CharSequence charSequence, CharSequence charSequence2, boolean z, a aVar) {
            this(i2, charSequence, charSequence2, z);
        }

        public boolean equals(Object obj) {
            String str;
            return (obj instanceof l) && ((this.f7357h == null && ((l) obj).f7357h == null) || ((str = ((l) obj).f7357h) != null && str.equals(this.f7357h)));
        }

        public l(int i2, CharSequence charSequence, CharSequence charSequence2, boolean z) {
            super(i2, 7, charSequence == null ? "" : charSequence, 0);
            this.f7356g = charSequence != null ? charSequence.toString() : "";
            this.f7357h = charSequence2 == null ? null : charSequence2.toString();
            this.f7355f = z;
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class m extends h.b.a.e.f.a implements View.OnClickListener {
        public TextView u;
        public TextView v;
        public l w;

        public m(View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131230971);
            this.v = (TextView) view.findViewById(2131231176);
            view.setOnClickListener(this);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            this.w = (l) aVar;
            this.u.setText(this.w.f7356g);
            if (this.w.f7357h != null && !this.w.f7357h.isEmpty()) {
                this.v.setHint((CharSequence) null);
                this.v.setText(this.w.f7357h);
                return;
            }
            this.v.setHint(2131755286);
            this.v.setText((CharSequence) null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s3.this.a(this.w);
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class n {
        public n(Context context) {
        }

        public /* synthetic */ void a() {
            s3.this.f0.dismiss();
        }

        @JavascriptInterface
        public void closeWebView() {
            if (s3.this.f0 != null) {
                s3.this.e0.post(new Runnable() { // from class: h.b.a.e.d.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        s3.n.this.a();
                    }
                });
            }
        }
    }

    @Override // h.b.a.d.e
    public void a(List<DataModels.Language> list) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            p0();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ((InputMethodManager) Objects.requireNonNull(((Context) Objects.requireNonNull(this.b0)).getSystemService("input_method"))).toggleSoftInput(1, 0);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 6) {
            this.i0.dismiss();
            p0();
            return true;
        }
        return false;
    }

    @Override // h.b.a.d.s
    public void onError(DataModels.Error error) {
        this.g0.setVisibility(4);
        for (h.b.a.d.t tVar : this.l0) {
            tVar.onError(error);
        }
    }

    @Override // h.b.a.d.s
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        this.g0.setVisibility(4);
        h.b.a.d.b<h.b.a.d.y> a2 = h.b.a.c.X().o().b().a(userAccountInfo);
        for (h.b.a.d.t tVar : this.l0) {
            tVar.b(a2);
        }
    }

    @SuppressLint({"LongLogTag"})
    public final void p0() {
        String str;
        y.d edit = this.j0.edit();
        if (this.p0.f7214a != 4) {
            EditText editText = this.h0;
            if (editText == null) {
                return;
            }
            str = editText.getText().toString().trim();
        } else {
            str = "";
        }
        switch (this.p0.f7214a) {
            case 0:
                edit.g(str);
                break;
            case 1:
                edit.d(str);
                break;
            case 2:
                edit.f(str);
                break;
            case 3:
                edit.j(str);
            case 4:
                DataModels.Country country = this.o0;
                if (country == null) {
                    Log.w("PaymentDataFragment.class", "selectedCountry is null, it will not be updated");
                    break;
                } else {
                    edit.a(country);
                    break;
                }
            case 5:
                edit.h(str);
                break;
            case 6:
                edit.a(str);
                break;
        }
        this.d0 = this.c0.a(this.b0.getString(2131755307), -1);
        this.d0.m();
        edit.o().a(this.r0);
    }

    public /* synthetic */ void q0() {
        ((InputMethodManager) Objects.requireNonNull(this.b0.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.h0.selectAll();
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = h.b.a.c.b(q());
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f7348a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7349b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f7350c;

        public i(int i2, String str, ImageView imageView) {
            this.f7348a = i2;
            this.f7349b = str;
            this.f7350c = imageView;
        }

        public void a() {
        }

        public boolean a(int i2, String str, ImageView imageView) {
            if (this.f7348a == i2 && str.equals(this.f7349b)) {
                this.f7350c = imageView;
                return false;
            }
            a();
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Bitmap decodeStream = BitmapFactory.decodeStream(new URL(this.f7349b).openConnection().getInputStream());
                s3.this.m0.d().post(new Runnable() { // from class: h.b.a.e.d.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        s3.i.this.a(decodeStream);
                    }
                });
            } catch (IOException unused) {
            }
        }

        public /* synthetic */ void a(Bitmap bitmap) {
            s3.s0.put(this.f7349b, bitmap);
            this.f7350c.setImageBitmap(bitmap);
            s3.this.q0.remove(this.f7349b);
        }
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class k extends h.b.a.e.f.a implements CountryCodePicker.OnCountryChangeListener {
        public CountryCodePicker u;
        public boolean v;

        /* compiled from: PaymentDataFragment.java */
        /* loaded from: classes.dex */
        public class a implements CountryCodePicker.DialogEventsListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i3.a f7353a;

            public a(i3.a aVar) {
                this.f7353a = aVar;
            }

            @Override // com.hbb20.CountryCodePicker.DialogEventsListener
            public void a(Dialog dialog) {
                s3.this.p0 = this.f7353a;
            }

            @Override // com.hbb20.CountryCodePicker.DialogEventsListener
            public void a(DialogInterface dialogInterface) {
            }

            @Override // com.hbb20.CountryCodePicker.DialogEventsListener
            public void b(DialogInterface dialogInterface) {
            }
        }

        public k(View view) {
            super(view);
            this.v = true;
            this.u = (CountryCodePicker) view.findViewById(2131230826);
            this.u.setOnCountryChangeListener(this);
            this.u.setCountryPreference("pt");
            this.v = false;
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            this.u.setCountryForNameCode(((j) aVar).f7352f);
            this.u.setDialogEventsListener(new a(aVar));
        }

        @Override // com.hbb20.CountryCodePicker.OnCountryChangeListener
        public void a() {
            if (this.v) {
                return;
            }
            String selectedCountryNameCode = this.u.getSelectedCountryNameCode();
            if (selectedCountryNameCode.equals(s3.this.j0.l()) || !s3.this.n0.containsKey(selectedCountryNameCode)) {
                return;
            }
            s3 s3Var = s3.this;
            s3Var.o0 = (DataModels.Country) s3Var.n0.get(selectedCountryNameCode);
            s3.this.p0();
        }
    }

    @Override // h.b.a.d.e
    public void b(List<DataModels.Country> list) {
        if (!this.n0.isEmpty()) {
            this.n0.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            DataModels.Country country = list.get(i2);
            this.n0.put(country.getCode(), country);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2131427384, viewGroup, false);
        this.e0 = viewGroup2;
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(2131230947);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.b0));
        this.g0 = (ProgressBar) viewGroup2.findViewById(2131231005);
        this.k0 = new b();
        recyclerView.setAdapter(this.k0);
        h.b.a.c X = h.b.a.c.X();
        X.o().a(this);
        X.a(this);
        return viewGroup2;
    }

    /* compiled from: PaymentDataFragment.java */
    /* loaded from: classes.dex */
    public class g extends h.b.a.e.f.a implements View.OnClickListener {
        public ImageView u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public f y;

        public g(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(2131230831);
            this.v = (ImageView) view.findViewById(2131230952);
            this.w = (TextView) view.findViewById(2131230963);
            this.x = (TextView) view.findViewById(2131230962);
            view.setOnClickListener(this);
        }

        public final void C() {
            BackEnd.selectPaymentMethod(this.y.f7346h, new a());
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            DataModels.PaymentMethodMessage[] messages;
            this.y = (f) aVar;
            if (this.y.f7344f) {
                this.u.setImageDrawable(a.b.g.b.b.c(s3.this.b0, 2131165567));
            } else {
                this.u.setImageDrawable(null);
            }
            this.w.setText(this.y.f7217d);
            boolean z = false;
            for (DataModels.PaymentMethodMessage paymentMethodMessage : this.y.f7346h.getMessages()) {
                if (paymentMethodMessage.getCode().trim().equals("DELAY_INFO")) {
                    this.x.setText(paymentMethodMessage.getValue());
                }
            }
            String charSequence = this.y.f7215b.toString();
            if (s3.s0.containsKey(charSequence)) {
                if (s3.this.q0.get(charSequence) != null ? ((i) s3.this.q0.get(charSequence)).a(this.y.f7345g, charSequence, this.v) : true) {
                    this.v.setImageBitmap((Bitmap) s3.s0.get(charSequence));
                }
                z = true;
            }
            if (z) {
                return;
            }
            if (s3.this.q0.get(charSequence) != null ? ((i) s3.this.q0.get(charSequence)).a(this.y.f7345g, charSequence, this.v) : true) {
                i iVar = new i(this.y.f7345g, charSequence, this.v);
                s3.this.q0.put(charSequence, iVar);
                h.b.a.c.X().a(iVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a aVar = new c.a(s3.this.b0);
            aVar.b(s3.this.b0.getString(2131755400));
            aVar.a(s3.this.a(this.y));
            aVar.a(false);
            aVar.b(2131755424, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.t0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    s3.g.this.a(dialogInterface, i2);
                }
            });
            aVar.a(2131755283, (DialogInterface.OnClickListener) null);
            aVar.c();
        }

        /* compiled from: PaymentDataFragment.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.SelectPaymentMethodRequestListener {
            public a() {
            }

            public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
            }

            public /* synthetic */ void a(DataModels.PaymentInfo paymentInfo, DialogInterface dialogInterface, int i2) {
                String procedureURL = paymentInfo.getProcedureURL();
                if (procedureURL != null) {
                    c.a aVar = new c.a(s3.this.b0, 16973838);
                    LinearLayout linearLayout = new LinearLayout(s3.this.b0);
                    linearLayout.setOrientation(1);
                    EditText editText = new EditText(s3.this.b0);
                    WebView webView = new WebView(s3.this.b0);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.loadUrl(procedureURL);
                    s3 s3Var = s3.this;
                    webView.addJavascriptInterface(new n(s3Var.b0), "Android");
                    editText.setVisibility(8);
                    editText.requestFocus();
                    linearLayout.addView(webView);
                    linearLayout.addView(editText);
                    aVar.b(linearLayout);
                    a.b.h.a.c a2 = aVar.a();
                    webView.setWebViewClient(new t3(this, a2));
                    s3.this.f0 = a2;
                    s3.this.f0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: h.b.a.e.d.s0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface2) {
                            s3.g.a.this.a(dialogInterface2);
                        }
                    });
                    a2.show();
                }
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.SelectPaymentMethodRequestListener
            @SuppressLint({"SetJavaScriptEnabled"})
            public void onSuccess(DataModels.PaymentAction paymentAction, final DataModels.PaymentInfo paymentInfo) {
                if (!paymentAction.name().equals(DataModels.PaymentAction.NO_ACTION_NEEDED.name())) {
                    DataModels.PaymentMethodMessage[] messages = g.this.y.f7346h.getMessages();
                    if (messages == null) {
                        return;
                    }
                    String str = "";
                    for (int i2 = 0; i2 < messages.length; i2++) {
                        if (messages[i2].getCode().equals("PAYMENT_REDIRECTION")) {
                            str = messages[i2].getValue();
                        }
                    }
                    c.a aVar = new c.a(s3.this.b0);
                    aVar.b(2131755310);
                    aVar.a(str);
                    aVar.a(false);
                    aVar.b("OK", new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.r0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            s3.g.a.this.a(paymentInfo, dialogInterface, i3);
                        }
                    });
                    aVar.a(17039360, q0.f7308a);
                    aVar.c();
                    return;
                }
                s3 s3Var = s3.this;
                s3Var.d0 = s3Var.c0.a(s3.this.b0.getString(2131755405), -1);
                s3.this.d0.m();
                s3.this.m0.f();
            }

            public /* synthetic */ void a(DialogInterface dialogInterface) {
                s3.this.m0.a();
                s3.this.f0 = null;
            }
        }

        public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
            C();
        }
    }

    public final void a(h.b.a.d.t tVar) {
        if (this.l0.contains(tVar)) {
            return;
        }
        this.l0.add(tVar);
    }

    public final void a(l lVar) {
        if (!lVar.f7355f) {
            Context context = this.b0;
            Toast.makeText(context, context.getString(2131755117), 0).show();
            return;
        }
        this.p0 = lVar;
        final c.a aVar = new c.a(this.b0);
        aVar.b(lVar.f7356g);
        int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, B().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(this.b0);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(applyDimension, applyDimension / 4, applyDimension, 0);
        this.h0 = new EditText(this.b0);
        this.h0.setSingleLine();
        this.h0.setText(lVar.f7357h);
        this.h0.setImeOptions(6);
        linearLayout.addView(this.h0);
        this.h0.setOnEditorActionListener(this);
        aVar.b(linearLayout);
        aVar.b(2131755378, this);
        aVar.a(17039360, this);
        aVar.a(this);
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.x0
            @Override // java.lang.Runnable
            public final void run() {
                s3.this.a(aVar);
            }
        });
        this.h0.post(new Runnable() { // from class: h.b.a.e.d.w0
            @Override // java.lang.Runnable
            public final void run() {
                s3.this.q0();
            }
        });
    }

    public /* synthetic */ void a(c.a aVar) {
        this.i0 = aVar.c();
    }

    public final String a(f fVar) {
        if (this.j0.j() == null || !fVar.f7346h.getCode().equals(this.j0.j().c())) {
            return this.b0.getString(2131755295, fVar.f7346h.getName());
        }
        if (fVar.f7346h.getCode().equals("PBV")) {
            return this.b0.getString(2131755270);
        }
        return this.b0.getString(2131755079);
    }
}
