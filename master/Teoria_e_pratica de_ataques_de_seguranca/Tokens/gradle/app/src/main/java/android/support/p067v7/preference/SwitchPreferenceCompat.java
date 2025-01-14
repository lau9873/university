package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p067v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0401o;
import p000a.p006b.p049h.p057f.C0405s;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.SwitchPreferenceCompat */
/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: S */
    public final C0675a f3911S;

    /* renamed from: T */
    public CharSequence f3912T;

    /* renamed from: U */
    public CharSequence f3913U;

    /* renamed from: android.support.v7.preference.SwitchPreferenceCompat$a */
    /* loaded from: classes.dex */
    public class C0675a implements CompoundButton.OnCheckedChangeListener {
        public C0675a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreferenceCompat.this.m7240a(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.m7150d(z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3911S = new C0675a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.SwitchPreferenceCompat, i, i2);
        m7151d(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreferenceCompat_summaryOn, C0405s.SwitchPreferenceCompat_android_summaryOn));
        m7152c((CharSequence) TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreferenceCompat_summaryOff, C0405s.SwitchPreferenceCompat_android_summaryOff));
        m7162f(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreferenceCompat_switchTextOn, C0405s.SwitchPreferenceCompat_android_switchTextOn));
        m7163e(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.SwitchPreferenceCompat_switchTextOff, C0405s.SwitchPreferenceCompat_android_switchTextOff));
        m7149e(TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.SwitchPreferenceCompat_disableDependentsState, C0405s.SwitchPreferenceCompat_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        super.mo7167a(preferenceViewHolder);
        m7165c(preferenceViewHolder.m8808c(C0401o.switchWidget));
        m7155b(preferenceViewHolder);
    }

    /* renamed from: c */
    public final void m7165c(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3917P);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f3912T);
            switchCompat.setTextOff(this.f3913U);
            switchCompat.setOnCheckedChangeListener(this.f3911S);
        }
    }

    /* renamed from: d */
    public final void m7164d(View view) {
        if (((AccessibilityManager) m7222d().getSystemService("accessibility")).isEnabled()) {
            m7165c(view.findViewById(C0401o.switchWidget));
            m7154b(view.findViewById(16908304));
        }
    }

    /* renamed from: e */
    public void m7163e(CharSequence charSequence) {
        this.f3913U = charSequence;
        mo7198y();
    }

    /* renamed from: f */
    public void m7162f(CharSequence charSequence) {
        this.f3912T = charSequence;
        mo7198y();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7166a(View view) {
        super.mo7166a(view);
        m7164d(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0399m.switchPreferenceCompatStyle);
    }
}
