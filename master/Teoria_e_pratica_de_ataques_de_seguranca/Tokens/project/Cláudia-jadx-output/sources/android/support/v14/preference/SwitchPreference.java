package android.support.v14.preference;

import a.b.g.b.g.g;
import a.b.h.f.l;
import a.b.h.f.m;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.TwoStatePreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final a S;
    public CharSequence T;
    public CharSequence U;

    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.a(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreference.this.d(z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.S = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.SwitchPreference, i2, i3);
        d(g.b(obtainStyledAttributes, s.SwitchPreference_summaryOn, s.SwitchPreference_android_summaryOn));
        c((CharSequence) g.b(obtainStyledAttributes, s.SwitchPreference_summaryOff, s.SwitchPreference_android_summaryOff));
        f(g.b(obtainStyledAttributes, s.SwitchPreference_switchTextOn, s.SwitchPreference_android_switchTextOn));
        e(g.b(obtainStyledAttributes, s.SwitchPreference_switchTextOff, s.SwitchPreference_android_switchTextOff));
        e(g.a(obtainStyledAttributes, s.SwitchPreference_disableDependentsState, s.SwitchPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        c(lVar.c(16908352));
        b(lVar);
    }

    public final void c(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.P);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.T);
            r4.setTextOff(this.U);
            r4.setOnCheckedChangeListener(this.S);
        }
    }

    public final void d(View view) {
        if (((AccessibilityManager) d().getSystemService("accessibility")).isEnabled()) {
            c(view.findViewById(16908352));
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

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.switchPreferenceStyle, 16843629));
    }
}
