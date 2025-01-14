package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0405s;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.CheckBoxPreference */
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: S */
    public final C0653a f3825S;

    /* renamed from: android.support.v7.preference.CheckBoxPreference$a */
    /* loaded from: classes.dex */
    public class C0653a implements CompoundButton.OnCheckedChangeListener {
        public C0653a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!CheckBoxPreference.this.m7240a(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                CheckBoxPreference.this.m7150d(z);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        super.mo7167a(preferenceViewHolder);
        m7278c(preferenceViewHolder.m8808c(16908289));
        m7155b(preferenceViewHolder);
    }

    /* renamed from: c */
    public final void m7278c(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3917P);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f3825S);
        }
    }

    /* renamed from: d */
    public final void m7277d(View view) {
        if (((AccessibilityManager) m7222d().getSystemService("accessibility")).isEnabled()) {
            m7278c(view.findViewById(16908289));
            m7154b(view.findViewById(16908304));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3825S = new C0653a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.CheckBoxPreference, i, i2);
        m7151d(TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.CheckBoxPreference_summaryOn, C0405s.CheckBoxPreference_android_summaryOn));
        m7152c((CharSequence) TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.CheckBoxPreference_summaryOff, C0405s.CheckBoxPreference_android_summaryOff));
        m7149e(TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.CheckBoxPreference_disableDependentsState, C0405s.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7166a(View view) {
        super.mo7166a(view);
        m7277d(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.checkBoxPreferenceStyle, 16842895));
    }
}
