package p070c.p113e;

import android.app.Dialog;
import android.content.Context;
import android.support.p067v7.widget.RecyclerView;
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
import com.hbb20.C1444R;
import com.hbb20.CCPCountry;
import com.hbb20.CountryCodePicker;
import java.util.ArrayList;
import java.util.List;
import p070c.p081c.p082a.SectionTitleProvider;

/* renamed from: c.e.a */
/* loaded from: classes.dex */
public class CountryCodeAdapter extends RecyclerView.AbstractC0711g<C1356e> implements SectionTitleProvider {

    /* renamed from: c */
    public List<CCPCountry> f5934c;

    /* renamed from: d */
    public List<CCPCountry> f5935d;

    /* renamed from: e */
    public TextView f5936e;

    /* renamed from: f */
    public CountryCodePicker f5937f;

    /* renamed from: g */
    public LayoutInflater f5938g;

    /* renamed from: h */
    public EditText f5939h;

    /* renamed from: i */
    public Dialog f5940i;

    /* renamed from: j */
    public Context f5941j;

    /* renamed from: k */
    public RelativeLayout f5942k;

    /* renamed from: m */
    public ImageView f5943m;

    /* renamed from: n */
    public int f5944n = 0;

    /* compiled from: CountryCodeAdapter.java */
    /* renamed from: c.e.a$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC1352a implements View.OnClickListener {
        public View$OnClickListenerC1352a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CountryCodeAdapter.this.f5939h.setText("");
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* renamed from: c.e.a$b */
    /* loaded from: classes.dex */
    public class C1353b implements TextWatcher {
        public C1353b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CountryCodeAdapter.this.m4673a(charSequence.toString());
            if (charSequence.toString().trim().equals("")) {
                CountryCodeAdapter.this.f5943m.setVisibility(8);
            } else {
                CountryCodeAdapter.this.f5943m.setVisibility(0);
            }
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* renamed from: c.e.a$c */
    /* loaded from: classes.dex */
    public class C1354c implements TextView.OnEditorActionListener {
        public C1354c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                ((InputMethodManager) CountryCodeAdapter.this.f5941j.getSystemService("input_method")).hideSoftInputFromWindow(CountryCodeAdapter.this.f5939h.getWindowToken(), 0);
                return true;
            }
            return false;
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* renamed from: c.e.a$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC1355d implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f5948a;

        public View$OnClickListenerC1355d(int i) {
            this.f5948a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<CCPCountry> list;
            List<CCPCountry> list2 = CountryCodeAdapter.this.f5934c;
            if (list2 != null) {
                int size = list2.size();
                int i = this.f5948a;
                if (size > i) {
                    CountryCodeAdapter countryCodeAdapter = CountryCodeAdapter.this;
                    countryCodeAdapter.f5937f.m4295a(countryCodeAdapter.f5934c.get(i));
                }
            }
            if (view == null || (list = CountryCodeAdapter.this.f5934c) == null) {
                return;
            }
            int size2 = list.size();
            int i2 = this.f5948a;
            if (size2 <= i2 || CountryCodeAdapter.this.f5934c.get(i2) == null) {
                return;
            }
            ((InputMethodManager) CountryCodeAdapter.this.f5941j.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            CountryCodeAdapter.this.f5940i.dismiss();
        }
    }

    /* compiled from: CountryCodeAdapter.java */
    /* renamed from: c.e.a$e */
    /* loaded from: classes.dex */
    public class C1356e extends RecyclerView.AbstractC0708d0 {

        /* renamed from: u */
        public RelativeLayout f5951u;

        /* renamed from: v */
        public TextView f5952v;

        /* renamed from: w */
        public TextView f5953w;

        /* renamed from: x */
        public ImageView f5954x;

        /* renamed from: y */
        public LinearLayout f5955y;

        /* renamed from: z */
        public View f5956z;

        public C1356e(View view) {
            super(view);
            this.f5951u = (RelativeLayout) view;
            this.f5952v = (TextView) this.f5951u.findViewById(C1444R.C1446id.textView_countryName);
            this.f5953w = (TextView) this.f5951u.findViewById(C1444R.C1446id.textView_code);
            this.f5954x = (ImageView) this.f5951u.findViewById(C1444R.C1446id.image_flag);
            this.f5955y = (LinearLayout) this.f5951u.findViewById(C1444R.C1446id.linear_flag_holder);
            this.f5956z = this.f5951u.findViewById(C1444R.C1446id.preferenceDivider);
            if (CountryCodeAdapter.this.f5937f.getDialogTextColor() != 0) {
                this.f5952v.setTextColor(CountryCodeAdapter.this.f5937f.getDialogTextColor());
                this.f5953w.setTextColor(CountryCodeAdapter.this.f5937f.getDialogTextColor());
                this.f5956z.setBackgroundColor(CountryCodeAdapter.this.f5937f.getDialogTextColor());
            }
            try {
                if (CountryCodeAdapter.this.f5937f.getDialogTypeFace() != null) {
                    if (CountryCodeAdapter.this.f5937f.getDialogTypeFaceStyle() != -99) {
                        this.f5953w.setTypeface(CountryCodeAdapter.this.f5937f.getDialogTypeFace(), CountryCodeAdapter.this.f5937f.getDialogTypeFaceStyle());
                        this.f5952v.setTypeface(CountryCodeAdapter.this.f5937f.getDialogTypeFace(), CountryCodeAdapter.this.f5937f.getDialogTypeFaceStyle());
                        return;
                    }
                    this.f5953w.setTypeface(CountryCodeAdapter.this.f5937f.getDialogTypeFace());
                    this.f5952v.setTypeface(CountryCodeAdapter.this.f5937f.getDialogTypeFace());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: C */
        public RelativeLayout m4668C() {
            return this.f5951u;
        }

        /* renamed from: a */
        public void m4667a(CCPCountry cCPCountry) {
            if (cCPCountry != null) {
                this.f5956z.setVisibility(8);
                this.f5952v.setVisibility(0);
                this.f5953w.setVisibility(0);
                if (CountryCodeAdapter.this.f5937f.m4282d()) {
                    this.f5953w.setVisibility(0);
                } else {
                    this.f5953w.setVisibility(8);
                }
                this.f5955y.setVisibility(0);
                if (CountryCodeAdapter.this.f5937f.getCcpDialogShowNameCode()) {
                    TextView textView = this.f5952v;
                    textView.setText(cCPCountry.m4311d() + " (" + cCPCountry.m4307e().toUpperCase() + ")");
                } else {
                    this.f5952v.setText(cCPCountry.m4311d());
                }
                TextView textView2 = this.f5953w;
                textView2.setText("+" + cCPCountry.m4304f());
                this.f5954x.setImageResource(cCPCountry.m4315c());
                return;
            }
            this.f5956z.setVisibility(0);
            this.f5952v.setVisibility(8);
            this.f5953w.setVisibility(8);
            this.f5955y.setVisibility(8);
        }
    }

    public CountryCodeAdapter(Context context, List<CCPCountry> list, CountryCodePicker countryCodePicker, RelativeLayout relativeLayout, EditText editText, TextView textView, Dialog dialog, ImageView imageView) {
        this.f5934c = null;
        this.f5935d = null;
        this.f5941j = context;
        this.f5935d = list;
        this.f5937f = countryCodePicker;
        this.f5940i = dialog;
        this.f5936e = textView;
        this.f5939h = editText;
        this.f5942k = relativeLayout;
        this.f5943m = imageView;
        this.f5938g = LayoutInflater.from(context);
        this.f5934c = m4672b("");
        m4670f();
    }

    /* renamed from: e */
    public final void m4671e() {
        this.f5943m.setOnClickListener(new View$OnClickListenerC1352a());
    }

    /* renamed from: f */
    public final void m4670f() {
        if (this.f5937f.m4279f()) {
            this.f5943m.setVisibility(8);
            m4669g();
            m4671e();
            return;
        }
        this.f5942k.setVisibility(8);
    }

    /* renamed from: g */
    public final void m4669g() {
        EditText editText = this.f5939h;
        if (editText != null) {
            editText.addTextChangedListener(new C1353b());
            this.f5939h.setOnEditorActionListener(new C1354c());
        }
    }

    /* renamed from: a */
    public final void m4673a(String str) {
        this.f5936e.setVisibility(8);
        String lowerCase = str.toLowerCase();
        if (lowerCase.length() > 0 && lowerCase.charAt(0) == '+') {
            lowerCase = lowerCase.substring(1);
        }
        this.f5934c = m4672b(lowerCase);
        if (this.f5934c.size() == 0) {
            this.f5936e.setVisibility(0);
        }
        m6750d();
    }

    /* renamed from: b */
    public final List<CCPCountry> m4672b(String str) {
        ArrayList arrayList = new ArrayList();
        this.f5944n = 0;
        List<CCPCountry> list = this.f5937f.f6206N;
        if (list != null && list.size() > 0) {
            for (CCPCountry cCPCountry : this.f5937f.f6206N) {
                if (cCPCountry.m4321a(str)) {
                    arrayList.add(cCPCountry);
                    this.f5944n++;
                }
            }
            if (arrayList.size() > 0) {
                arrayList.add(null);
                this.f5944n++;
            }
        }
        for (CCPCountry cCPCountry2 : this.f5935d) {
            if (cCPCountry2.m4321a(str)) {
                arrayList.add(cCPCountry2);
            }
        }
        return arrayList;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: a */
    public void mo743b(C1356e c1356e, int i) {
        c1356e.m4667a(this.f5934c.get(i));
        if (this.f5934c.size() > i && this.f5934c.get(i) != null) {
            c1356e.m4668C().setOnClickListener(new View$OnClickListenerC1355d(i));
        } else {
            c1356e.m4668C().setOnClickListener(null);
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: a */
    public int mo747a() {
        return this.f5934c.size();
    }

    @Override // p070c.p081c.p082a.SectionTitleProvider
    /* renamed from: a */
    public String mo4676a(int i) {
        CCPCountry cCPCountry = this.f5934c.get(i);
        return this.f5944n > i ? "★" : cCPCountry != null ? cCPCountry.m4311d().substring(0, 1) : "☺";
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public C1356e mo742b(ViewGroup viewGroup, int i) {
        return new C1356e(this.f5938g.inflate(C1444R.layout.layout_recycler_country_tile, viewGroup, false));
    }
}
