package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p067v7.preference.TwoStatePreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0405s;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: S */
    public final C0599a f3458S;

    /* renamed from: T */
    public CharSequence f3459T;

    /* renamed from: U */
    public CharSequence f3460U;

    /* renamed from: android.support.v14.preference.SwitchPreference$a */
    /* loaded from: classes.dex */
    public class C0599a implements CompoundButton.OnCheckedChangeListener {
        public C0599a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.m7240a(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreference.this.m7150d(z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3458S = new C0599a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.SwitchPreference, i, i2);
        m7151d(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreference_summaryOn, C0405s.SwitchPreference_android_summaryOn));
        m7152c((CharSequence) TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreference_summaryOff, C0405s.SwitchPreference_android_summaryOff));
        m7553f(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreference_switchTextOn, C0405s.SwitchPreference_android_switchTextOn));
        m7554e(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreference_switchTextOff, C0405s.SwitchPreference_android_switchTextOff));
        m7149e(TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.SwitchPreference_disableDependentsState, C0405s.SwitchPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        super.mo7167a(preferenceViewHolder);
        m7556c(preferenceViewHolder.m8808c(16908352));
        m7155b(preferenceViewHolder);
    }

    /* renamed from: c */
    public final void m7556c(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3917P);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.f3459T);
            r4.setTextOff(this.f3460U);
            r4.setOnCheckedChangeListener(this.f3458S);
        }
    }

    /* renamed from: d */
    public final void m7555d(View view) {
        if (((AccessibilityManager) m7222d().getSystemService("accessibility")).isEnabled()) {
            m7556c(view.findViewById(16908352));
            m7154b(view.findViewById(16908304));
        }
    }

    /* renamed from: e */
    public void m7554e(CharSequence charSequence) {
        this.f3460U = charSequence;
        mo7198y();
    }

    /* renamed from: f */
    public void m7553f(CharSequence charSequence) {
        this.f3459T = charSequence;
        mo7198y();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7166a(View view) {
        super.mo7166a(view);
        m7555d(view);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.switchPreferenceStyle, 16843629));
    }
}
