package android.support.p067v7.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.PreferenceCategory */
/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: G */
    public boolean mo7159G() {
        return !super.mo7192u();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        super.mo7167a(preferenceViewHolder);
        if (Build.VERSION.SDK_INT >= 28) {
            preferenceViewHolder.f4213a.setAccessibilityHeading(true);
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: u */
    public boolean mo7192u() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.preferenceCategoryStyle, 16842892));
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7193a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat.C0285b m9545c;
        super.mo7193a(accessibilityNodeInfoCompat);
        if (Build.VERSION.SDK_INT >= 28 || (m9545c = accessibilityNodeInfoCompat.m9545c()) == null) {
            return;
        }
        accessibilityNodeInfoCompat.m9547b(AccessibilityNodeInfoCompat.C0285b.m9520a(m9545c.m9518c(), m9545c.m9517d(), m9545c.m9521a(), m9545c.m9519b(), true, m9545c.m9516e()));
    }
}
