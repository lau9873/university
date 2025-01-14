package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbb20.C1444R;
import com.hbb20.CountryCodePicker;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p000a.p006b.p030g.p045k.p047f0.FastOutSlowInInterpolator;
import p136d.p153c.Observable;
import p136d.p153c.p154b0.p156b.AndroidSchedulers;
import p136d.p153c.p159e0.Consumer;
import p205h.p208b.p209a.p212e.p214b.Interpolators;
import p205h.p208b.p209a.p212e.p217e.RegisterListener;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.z3 */
/* loaded from: classes.dex */
public class RegisterFirstStepFragment extends AbstractFragment {

    /* renamed from: c0 */
    public TextInputLayout f10360c0;

    /* renamed from: d0 */
    public TextInputLayout f10361d0;

    /* renamed from: e0 */
    public TextInputLayout f10362e0;

    /* renamed from: f0 */
    public TextInputLayout f10363f0;

    /* renamed from: g0 */
    public TextInputLayout f10364g0;

    /* renamed from: h0 */
    public TextInputLayout f10365h0;

    /* renamed from: i0 */
    public LinearLayout f10366i0;

    /* renamed from: j0 */
    public CountryCodePicker f10367j0;

    /* renamed from: k0 */
    public Button f10368k0;

    /* renamed from: l0 */
    public CheckBox f10369l0;

    /* renamed from: m0 */
    public TextView f10370m0;

    /* renamed from: n0 */
    public RegisterListener f10371n0;

    /* renamed from: o0 */
    public boolean f10372o0 = true;

    /* renamed from: p0 */
    public boolean f10373p0 = false;

    /* compiled from: RegisterFirstStepFragment.java */
    /* renamed from: h.b.a.e.d.z3$a */
    /* loaded from: classes.dex */
    public class C2594a implements BackendListeners.GetTermsAndConditionsListener {
        public C2594a() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            RegisterFirstStepFragment.this.f10372o0 = true;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetTermsAndConditionsListener
        public void onSuccess(String str) {
            RegisterFirstStepFragment.this.f10372o0 = false;
            RegisterFirstStepFragment.this.f10370m0.setText(Html.fromHtml(String.format("%s <a href='https://docs.google.com/gview?url=%s'>%s</a>", RegisterFirstStepFragment.this.f9860b0.getString(C1444R.string.terms_and_conditions_first), str, RegisterFirstStepFragment.this.f9860b0.getString(C1444R.string.terms_and_conditions_second))));
            RegisterFirstStepFragment.this.f10370m0.setClickable(true);
            RegisterFirstStepFragment.this.f10370m0.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* renamed from: A0 */
    public /* synthetic */ Void m722A0() {
        m703q0();
        return null;
    }

    /* renamed from: B0 */
    public boolean m721B0() {
        return this.f10372o0;
    }

    /* renamed from: b */
    public /* synthetic */ void m707b(View view) {
        if (this.f10373p0) {
            this.f10366i0.requestFocus();
            this.f10373p0 = false;
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m706c(View view) {
        this.f10371n0.mo693g();
    }

    /* renamed from: p0 */
    public boolean m704p0() {
        return m720a(this.f10361d0, this.f10362e0, C1444R.string.error_register_wrongEmail);
    }

    /* renamed from: q0 */
    public boolean m703q0() {
        return m720a(this.f10363f0, this.f10364g0, C1444R.string.error_register_wrongPassword);
    }

    /* renamed from: r0 */
    public CountryCodePicker m702r0() {
        return this.f10367j0;
    }

    /* renamed from: s0 */
    public CheckBox m701s0() {
        return this.f10369l0;
    }

    /* renamed from: t0 */
    public TextInputLayout m700t0() {
        return this.f10361d0;
    }

    /* renamed from: u0 */
    public TextInputLayout m699u0() {
        return this.f10360c0;
    }

    /* renamed from: v0 */
    public TextInputLayout m698v0() {
        return this.f10363f0;
    }

    /* renamed from: w0 */
    public TextInputLayout m697w0() {
        return this.f10364g0;
    }

    /* renamed from: x0 */
    public TextInputLayout m696x0() {
        return this.f10365h0;
    }

    /* renamed from: y0 */
    public /* synthetic */ void m695y0() {
        this.f10369l0.requestFocus();
    }

    /* renamed from: z0 */
    public /* synthetic */ Void m694z0() {
        m704p0();
        return null;
    }

    /* renamed from: a */
    public void m708a(RegisterListener registerListener) {
        this.f10371n0 = registerListener;
    }

    /* renamed from: a */
    public final View.OnFocusChangeListener m719a(final TextInputLayout textInputLayout, final Callable<Void> callable) {
        return new View.OnFocusChangeListener() { // from class: h.b.a.e.d.p1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                RegisterFirstStepFragment.m718a(TextInputLayout.this, callable, view, z);
            }
        };
    }

    /* renamed from: a */
    public static /* synthetic */ void m718a(TextInputLayout textInputLayout, Callable callable, View view, boolean z) {
        Editable text = ((EditText) Objects.requireNonNull(textInputLayout.getEditText())).getText();
        if (z || text.length() <= 0) {
            if (z) {
                textInputLayout.setError(null);
                return;
            }
            return;
        }
        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(C1444R.layout.fragment_register_firststep, viewGroup, false);
        final View findViewById = inflate.findViewById(C1444R.C1446id.profile);
        this.f10366i0 = (LinearLayout) inflate.findViewById(C1444R.C1446id.parentLayout);
        this.f10360c0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tName);
        this.f10361d0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tEmail);
        this.f10362e0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tEmailConfirmation);
        this.f10363f0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tPassword);
        this.f10364g0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tPasswordConfirmation);
        this.f10367j0 = (CountryCodePicker) inflate.findViewById(C1444R.C1446id.ccp);
        this.f10365h0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.tPhone);
        this.f10369l0 = (CheckBox) inflate.findViewById(C1444R.C1446id.cTermsAndConditions);
        this.f10370m0 = (TextView) inflate.findViewById(C1444R.C1446id.tTermsAndConditions);
        this.f10368k0 = (Button) inflate.findViewById(C1444R.C1446id.nextStep);
        View.OnFocusChangeListener m719a = m719a(this.f10362e0, new Callable() { // from class: h.b.a.e.d.n1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RegisterFirstStepFragment.this.m694z0();
            }
        });
        View.OnFocusChangeListener m719a2 = m719a(this.f10364g0, new Callable() { // from class: h.b.a.e.d.k1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RegisterFirstStepFragment.this.m722A0();
            }
        });
        this.f10367j0.m4296a(this.f10365h0.getEditText());
        ((EditText) Objects.requireNonNull(this.f10361d0.getEditText())).setOnFocusChangeListener(m719a);
        ((EditText) Objects.requireNonNull(this.f10362e0.getEditText())).setOnFocusChangeListener(m719a);
        ((EditText) Objects.requireNonNull(this.f10363f0.getEditText())).setOnFocusChangeListener(m719a2);
        ((EditText) Objects.requireNonNull(this.f10364g0.getEditText())).setOnFocusChangeListener(m719a2);
        this.f10369l0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: h.b.a.e.d.q1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RegisterFirstStepFragment.this.m711a(compoundButton, z);
            }
        });
        BackEnd.getTermsAndConditions(new C2594a());
        ((TextInputEditText) inflate.findViewById(C1444R.C1446id.tPhoneEditText)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: h.b.a.e.d.o1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return RegisterFirstStepFragment.this.m714a(inflate, textView, i, keyEvent);
            }
        });
        this.f10369l0.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterFirstStepFragment.this.m707b(view);
            }
        });
        this.f10369l0.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: h.b.a.e.d.m1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                RegisterFirstStepFragment.this.m712a(view, z);
            }
        });
        if (bundle == null) {
            findViewById.setAlpha(0.0f);
            inflate.postDelayed(new Runnable() { // from class: h.b.a.e.d.j1
                @Override // java.lang.Runnable
                public final void run() {
                    RegisterFirstStepFragment.m716a(findViewById, Interpolators.f9740a, 20);
                }
            }, 500L);
        }
        return inflate;
    }

    /* renamed from: a */
    public /* synthetic */ void m711a(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f10369l0.setError(null);
        }
    }

    /* renamed from: a */
    public /* synthetic */ boolean m714a(final View view, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f9860b0.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
            }
            if (!this.f10369l0.isChecked()) {
                this.f10373p0 = true;
                this.f10369l0.setFocusableInTouchMode(true);
                Observable.m3300b(100L, TimeUnit.MILLISECONDS).m3305a(AndroidSchedulers.m3671a()).m3316a(new Consumer() { // from class: h.b.a.e.d.s1
                    @Override // p136d.p153c.p159e0.Consumer
                    public final void accept(Object obj) {
                        RegisterFirstStepFragment.this.m713a(view, (Long) obj);
                    }
                });
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public /* synthetic */ void m713a(View view, Long l) {
        view.post(new Runnable() { // from class: h.b.a.e.d.r1
            @Override // java.lang.Runnable
            public final void run() {
                RegisterFirstStepFragment.this.m695y0();
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m712a(View view, boolean z) {
        if (this.f10373p0 && this.f10369l0.isFocusableInTouchMode()) {
            this.f10369l0.setFocusableInTouchMode(false);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo715a(View view, Bundle bundle) {
        this.f10368k0.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegisterFirstStepFragment.this.m706c(view2);
            }
        });
    }

    /* renamed from: a */
    public final boolean m720a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, int i) {
        if (((EditText) Objects.requireNonNull(textInputLayout.getEditText())).getText().toString().equals(((EditText) Objects.requireNonNull(textInputLayout2.getEditText())).getText().toString())) {
            textInputLayout2.setError(null);
            return true;
        }
        textInputLayout2.setError(this.f9860b0.getString(i));
        return false;
    }

    /* renamed from: a */
    public static void m716a(View view, FastOutSlowInInterpolator fastOutSlowInInterpolator, int i) {
        view.setTranslationY(view.getHeight() / 4);
        view.animate().alpha(1.0f).translationY(0.0f).setInterpolator(fastOutSlowInInterpolator).setStartDelay(i).setDuration(280L).start();
    }
}
