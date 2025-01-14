package android.support.p067v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.PreferenceManager;

/* renamed from: android.support.v7.preference.PreferenceScreen */
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: U */
    public boolean f3894U;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.preferenceScreenStyle, 16842891));
        this.f3894U = true;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: B */
    public void mo7161B() {
        PreferenceManager.InterfaceC0395b m8823c;
        if (m7213i() != null || m7215g() != null || m7187L() == 0 || (m8823c = m7207o().m8823c()) == null) {
            return;
        }
        m8823c.mo8815a(this);
    }

    @Override // android.support.p067v7.preference.PreferenceGroup
    /* renamed from: M */
    public boolean mo7174M() {
        return false;
    }

    /* renamed from: O */
    public boolean m7173O() {
        return this.f3894U;
    }
}
