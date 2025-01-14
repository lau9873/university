package h.b.a.e.d;

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
import com.hbb20.CountryCodePicker;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: RegisterFirstStepFragment.java */
/* loaded from: classes.dex */
public class z3 extends g3 {
    public TextInputLayout c0;
    public TextInputLayout d0;
    public TextInputLayout e0;
    public TextInputLayout f0;
    public TextInputLayout g0;
    public TextInputLayout h0;
    public LinearLayout i0;
    public CountryCodePicker j0;
    public Button k0;
    public CheckBox l0;
    public TextView m0;
    public h.b.a.e.e.a n0;
    public boolean o0 = true;
    public boolean p0 = false;

    /* compiled from: RegisterFirstStepFragment.java */
    /* loaded from: classes.dex */
    public class a implements BackendListeners.GetTermsAndConditionsListener {
        public a() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            z3.this.o0 = true;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetTermsAndConditionsListener
        public void onSuccess(String str) {
            z3.this.o0 = false;
            z3.this.m0.setText(Html.fromHtml(String.format("%s <a href='https://docs.google.com/gview?url=%s'>%s</a>", z3.this.b0.getString(2131755339), str, z3.this.b0.getString(2131755342))));
            z3.this.m0.setClickable(true);
            z3.this.m0.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public /* synthetic */ Void A0() {
        q0();
        return null;
    }

    public boolean B0() {
        return this.o0;
    }

    public /* synthetic */ void b(View view) {
        if (this.p0) {
            this.i0.requestFocus();
            this.p0 = false;
        }
    }

    public /* synthetic */ void c(View view) {
        this.n0.g();
    }

    public boolean p0() {
        return a(this.d0, this.e0, 2131755233);
    }

    public boolean q0() {
        return a(this.f0, this.g0, 2131755234);
    }

    public CountryCodePicker r0() {
        return this.j0;
    }

    public CheckBox s0() {
        return this.l0;
    }

    public TextInputLayout t0() {
        return this.d0;
    }

    public TextInputLayout u0() {
        return this.c0;
    }

    public TextInputLayout v0() {
        return this.f0;
    }

    public TextInputLayout w0() {
        return this.g0;
    }

    public TextInputLayout x0() {
        return this.h0;
    }

    public /* synthetic */ void y0() {
        this.l0.requestFocus();
    }

    public /* synthetic */ Void z0() {
        p0();
        return null;
    }

    public void a(h.b.a.e.e.a aVar) {
        this.n0 = aVar;
    }

    public final View.OnFocusChangeListener a(final TextInputLayout textInputLayout, final Callable<Void> callable) {
        return new View.OnFocusChangeListener() { // from class: h.b.a.e.d.p1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                z3.a(TextInputLayout.this, callable, view, z);
            }
        };
    }

    public static /* synthetic */ void a(TextInputLayout textInputLayout, Callable callable, View view, boolean z) {
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    @SuppressLint({"CheckResult"})
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(2131427388, viewGroup, false);
        final View findViewById = inflate.findViewById(2131231003);
        this.i0 = (LinearLayout) inflate.findViewById(2131230988);
        this.c0 = (TextInputLayout) inflate.findViewById(2131231112);
        this.d0 = (TextInputLayout) inflate.findViewById(2131231105);
        this.e0 = (TextInputLayout) inflate.findViewById(2131231106);
        this.f0 = (TextInputLayout) inflate.findViewById(2131231117);
        this.g0 = (TextInputLayout) inflate.findViewById(2131231118);
        this.j0 = (CountryCodePicker) inflate.findViewById(2131230825);
        this.h0 = (TextInputLayout) inflate.findViewById(2131231120);
        this.l0 = (CheckBox) inflate.findViewById(2131230823);
        this.m0 = (TextView) inflate.findViewById(2131231125);
        this.k0 = (Button) inflate.findViewById(2131230975);
        View.OnFocusChangeListener a2 = a(this.e0, new Callable() { // from class: h.b.a.e.d.n1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z3.this.z0();
            }
        });
        View.OnFocusChangeListener a3 = a(this.g0, new Callable() { // from class: h.b.a.e.d.k1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z3.this.A0();
            }
        });
        this.j0.a(this.h0.getEditText());
        ((EditText) Objects.requireNonNull(this.d0.getEditText())).setOnFocusChangeListener(a2);
        ((EditText) Objects.requireNonNull(this.e0.getEditText())).setOnFocusChangeListener(a2);
        ((EditText) Objects.requireNonNull(this.f0.getEditText())).setOnFocusChangeListener(a3);
        ((EditText) Objects.requireNonNull(this.g0.getEditText())).setOnFocusChangeListener(a3);
        this.l0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: h.b.a.e.d.q1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                z3.this.a(compoundButton, z);
            }
        });
        BackEnd.getTermsAndConditions(new a());
        ((TextInputEditText) inflate.findViewById(2131231121)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: h.b.a.e.d.o1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return z3.this.a(inflate, textView, i2, keyEvent);
            }
        });
        this.l0.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z3.this.b(view);
            }
        });
        this.l0.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: h.b.a.e.d.m1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                z3.this.a(view, z);
            }
        });
        if (bundle == null) {
            findViewById.setAlpha(0.0f);
            inflate.postDelayed(new Runnable() { // from class: h.b.a.e.d.j1
                @Override // java.lang.Runnable
                public final void run() {
                    z3.a(findViewById, h.b.a.e.b.b.f7085a, 20);
                }
            }, 500L);
        }
        return inflate;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.l0.setError(null);
        }
    }

    public /* synthetic */ boolean a(final View view, TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 6) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.b0.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
            }
            if (!this.l0.isChecked()) {
                this.p0 = true;
                this.l0.setFocusableInTouchMode(true);
                d.c.o.b(100L, TimeUnit.MILLISECONDS).a(d.c.b0.b.a.a()).a(new d.c.e0.f() { // from class: h.b.a.e.d.s1
                    @Override // d.c.e0.f
                    public final void accept(Object obj) {
                        z3.this.a(view, (Long) obj);
                    }
                });
            }
            return true;
        }
        return false;
    }

    public /* synthetic */ void a(View view, Long l) {
        view.post(new Runnable() { // from class: h.b.a.e.d.r1
            @Override // java.lang.Runnable
            public final void run() {
                z3.this.y0();
            }
        });
    }

    public /* synthetic */ void a(View view, boolean z) {
        if (this.p0 && this.l0.isFocusableInTouchMode()) {
            this.l0.setFocusableInTouchMode(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        this.k0.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z3.this.c(view2);
            }
        });
    }

    public final boolean a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, int i2) {
        if (((EditText) Objects.requireNonNull(textInputLayout.getEditText())).getText().toString().equals(((EditText) Objects.requireNonNull(textInputLayout2.getEditText())).getText().toString())) {
            textInputLayout2.setError(null);
            return true;
        }
        textInputLayout2.setError(this.b0.getString(i2));
        return false;
    }

    public static void a(View view, a.b.g.k.f0.b bVar, int i2) {
        view.setTranslationY(view.getHeight() / 4);
        view.animate().alpha(1.0f).translationY(0.0f).setInterpolator(bVar).setStartDelay(i2).setDuration(280L).start();
    }
}
