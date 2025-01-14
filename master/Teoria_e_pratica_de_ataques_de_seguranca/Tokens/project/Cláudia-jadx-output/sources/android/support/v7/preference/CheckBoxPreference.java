package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.l;
import a.b.h.f.m;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final a S;

    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!CheckBoxPreference.this.a(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                CheckBoxPreference.this.d(z);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    @Override // android.support.v7.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        c(lVar.c(16908289));
        b(lVar);
    }

    public final void c(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.P);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.S);
        }
    }

    public final void d(View view) {
        if (((AccessibilityManager) d().getSystemService("accessibility")).isEnabled()) {
            c(view.findViewById(16908289));
            b(view.findViewById(16908304));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.S = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.CheckBoxPreference, i2, i3);
        d(g.b(obtainStyledAttributes, s.CheckBoxPreference_summaryOn, s.CheckBoxPreference_android_summaryOn));
        c((CharSequence) g.b(obtainStyledAttributes, s.CheckBoxPreference_summaryOff, s.CheckBoxPreference_android_summaryOff));
        e(g.a(obtainStyledAttributes, s.CheckBoxPreference_disableDependentsState, s.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public void a(View view) {
        super.a(view);
        d(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.checkBoxPreferenceStyle, 16842895));
    }
}
