package c.e;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.c.a.h;
import com.hbb20.CCPCountry;
import com.hbb20.CountryCodePicker;
import com.hbb20.R;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CountryCodeAdapter.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g<e> implements h {

    /* renamed from: c  reason: collision with root package name */
    public List<CCPCountry> f3918c;

    /* renamed from: d  reason: collision with root package name */
    public List<CCPCountry> f3919d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f3920e;

    /* renamed from: f  reason: collision with root package name */
    public CountryCodePicker f3921f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f3922g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f3923h;

    /* renamed from: i  reason: collision with root package name */
    public Dialog f3924i;
    public Context j;
    public RelativeLayout k;
    public ImageView m;
    public int n = 0;

    /* compiled from: CountryCodeAdapter.java */
    /* renamed from: c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0069a implements View.OnClickListener {
        public View$OnClickListenerC0069a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f3923h.setText("");
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* loaded from: classes.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            a.this.a(charSequence.toString());
            if (charSequence.toString().trim().equals("")) {
                a.this.m.setVisibility(8);
            } else {
                a.this.m.setVisibility(0);
            }
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* loaded from: classes.dex */
    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
                ((InputMethodManager) a.this.j.getSystemService("input_method")).hideSoftInputFromWindow(a.this.f3923h.getWindowToken(), 0);
                return true;
            }
            return false;
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3928a;

        public d(int i2) {
            this.f3928a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<CCPCountry> list;
            List<CCPCountry> list2 = a.this.f3918c;
            if (list2 != null) {
                int size = list2.size();
                int i2 = this.f3928a;
                if (size > i2) {
                    a aVar = a.this;
                    aVar.f3921f.a(aVar.f3918c.get(i2));
                }
            }
            if (view == null || (list = a.this.f3918c) == null) {
                return;
            }
            int size2 = list.size();
            int i3 = this.f3928a;
            if (size2 <= i3 || a.this.f3918c.get(i3) == null) {
                return;
            }
            ((InputMethodManager) a.this.j.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            a.this.f3924i.dismiss();
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.d0 {
        public RelativeLayout u;
        public TextView v;
        public TextView w;
        public ImageView x;
        public LinearLayout y;
        public View z;

        public e(View view) {
            super(view);
            this.u = (RelativeLayout) view;
            this.v = (TextView) this.u.findViewById(R.id.textView_countryName);
            this.w = (TextView) this.u.findViewById(R.id.textView_code);
            this.x = (ImageView) this.u.findViewById(R.id.image_flag);
            this.y = (LinearLayout) this.u.findViewById(R.id.linear_flag_holder);
            this.z = this.u.findViewById(R.id.preferenceDivider);
            if (a.this.f3921f.getDialogTextColor() != 0) {
                this.v.setTextColor(a.this.f3921f.getDialogTextColor());
                this.w.setTextColor(a.this.f3921f.getDialogTextColor());
                this.z.setBackgroundColor(a.this.f3921f.getDialogTextColor());
            }
            try {
                if (a.this.f3921f.getDialogTypeFace() != null) {
                    if (a.this.f3921f.getDialogTypeFaceStyle() != -99) {
                        this.w.setTypeface(a.this.f3921f.getDialogTypeFace(), a.this.f3921f.getDialogTypeFaceStyle());
                        this.v.setTypeface(a.this.f3921f.getDialogTypeFace(), a.this.f3921f.getDialogTypeFaceStyle());
                        return;
                    }
                    this.w.setTypeface(a.this.f3921f.getDialogTypeFace());
                    this.v.setTypeface(a.this.f3921f.getDialogTypeFace());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public RelativeLayout C() {
            return this.u;
        }

        public void a(CCPCountry cCPCountry) {
            if (cCPCountry != null) {
                this.z.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setVisibility(0);
                if (a.this.f3921f.d()) {
                    this.w.setVisibility(0);
                } else {
                    this.w.setVisibility(8);
                }
                this.y.setVisibility(0);
                if (a.this.f3921f.getCcpDialogShowNameCode()) {
                    TextView textView = this.v;
                    textView.setText(cCPCountry.d() + " (" + cCPCountry.e().toUpperCase() + ")");
                } else {
                    this.v.setText(cCPCountry.d());
                }
                TextView textView2 = this.w;
                textView2.setText("+" + cCPCountry.f());
                this.x.setImageResource(cCPCountry.c());
                return;
            }
            this.z.setVisibility(0);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.y.setVisibility(8);
        }
    }

    public a(Context context, List<CCPCountry> list, CountryCodePicker countryCodePicker, RelativeLayout relativeLayout, EditText editText, TextView textView, Dialog dialog, ImageView imageView) {
        this.f3918c = null;
        this.f3919d = null;
        this.j = context;
        this.f3919d = list;
        this.f3921f = countryCodePicker;
        this.f3924i = dialog;
        this.f3920e = textView;
        this.f3923h = editText;
        this.k = relativeLayout;
        this.m = imageView;
        this.f3922g = LayoutInflater.from(context);
        this.f3918c = b("");
        f();
    }

    public final void e() {
        this.m.setOnClickListener(new View$OnClickListenerC0069a());
    }

    public final void f() {
        if (this.f3921f.f()) {
            this.m.setVisibility(8);
            g();
            e();
            return;
        }
        this.k.setVisibility(8);
    }

    public final void g() {
        EditText editText = this.f3923h;
        if (editText != null) {
            editText.addTextChangedListener(new b());
            this.f3923h.setOnEditorActionListener(new c());
        }
    }

    public final void a(String str) {
        this.f3920e.setVisibility(8);
        String lowerCase = str.toLowerCase();
        if (lowerCase.length() > 0 && lowerCase.charAt(0) == '+') {
            lowerCase = lowerCase.substring(1);
        }
        this.f3918c = b(lowerCase);
        if (this.f3918c.size() == 0) {
            this.f3920e.setVisibility(0);
        }
        d();
    }

    public final List<CCPCountry> b(String str) {
        ArrayList arrayList = new ArrayList();
        this.n = 0;
        List<CCPCountry> list = this.f3921f.N;
        if (list != null && list.size() > 0) {
            for (CCPCountry cCPCountry : this.f3921f.N) {
                if (cCPCountry.a(str)) {
                    arrayList.add(cCPCountry);
                    this.n++;
                }
            }
            if (arrayList.size() > 0) {
                arrayList.add(null);
                this.n++;
            }
        }
        for (CCPCountry cCPCountry2 : this.f3919d) {
            if (cCPCountry2.a(str)) {
                arrayList.add(cCPCountry2);
            }
        }
        return arrayList;
    }

    @Override // android.support.v7.widget.RecyclerView.g
    /* renamed from: a */
    public void b(e eVar, int i2) {
        eVar.a(this.f3918c.get(i2));
        if (this.f3918c.size() > i2 && this.f3918c.get(i2) != null) {
            eVar.C().setOnClickListener(new d(i2));
        } else {
            eVar.C().setOnClickListener(null);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.g
    public int a() {
        return this.f3918c.size();
    }

    @Override // c.c.a.h
    public String a(int i2) {
        CCPCountry cCPCountry = this.f3918c.get(i2);
        return this.n > i2 ? "★" : cCPCountry != null ? cCPCountry.d().substring(0, 1) : "☺";
    }

    @Override // android.support.v7.widget.RecyclerView.g
    public e b(ViewGroup viewGroup, int i2) {
        return new e(this.f3922g.inflate(R.layout.layout_recycler_country_tile, viewGroup, false));
    }
}
