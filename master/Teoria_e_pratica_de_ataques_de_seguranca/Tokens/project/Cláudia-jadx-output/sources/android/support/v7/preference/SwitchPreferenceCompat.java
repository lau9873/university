package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.l;
import a.b.h.f.m;
import a.b.h.f.o;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a S;
    public CharSequence T;
    public CharSequence U;

    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreferenceCompat.this.a(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.d(z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.S = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.SwitchPreferenceCompat, i2, i3);
        d(g.b(obtainStyledAttributes, s.SwitchPreferenceCompat_summaryOn, s.SwitchPreferenceCompat_android_summaryOn));
        c((CharSequence) g.b(obtainStyledAttributes, s.SwitchPreferenceCompat_summaryOff, s.SwitchPreferenceCompat_android_summaryOff));
        f(g.b(obtainStyledAttributes, s.SwitchPreferenceCompat_switchTextOn, s.SwitchPreferenceCompat_android_switchTextOn));
        e(g.b(obtainStyledAttributes, s.SwitchPreferenceCompat_switchTextOff, s.SwitchPreferenceCompat_android_switchTextOff));
        e(g.a(obtainStyledAttributes, s.SwitchPreferenceCompat_disableDependentsState, s.SwitchPreferenceCompat_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        c(lVar.c(o.switchWidget));
        b(lVar);
    }

    public final void c(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.P);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.T);
            switchCompat.setTextOff(this.U);
            switchCompat.setOnCheckedChangeListener(this.S);
        }
    }

    public final void d(View view) {
        if (((AccessibilityManager) d().getSystemService("accessibility")).isEnabled()) {
            c(view.findViewById(o.switchWidget));
            b(view.findViewById(16908304));
        }
    }

    public void e(CharSequence charSequence) {
        this.U = charSequence;
        y();
    }

    public void f(CharSequence charSequence) {
        this.T = charSequence;
        y();
    }

    @Override // android.support.v7.preference.Preference
    public void a(View view) {
        super.a(view);
        d(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.switchPreferenceCompatStyle);
    }
}
