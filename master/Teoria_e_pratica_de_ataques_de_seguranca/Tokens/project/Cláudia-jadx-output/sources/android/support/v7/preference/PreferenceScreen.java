package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.j;
import a.b.h.f.m;
import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public boolean U;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, g.a(context, m.preferenceScreenStyle, 16842891));
        this.U = true;
    }

    @Override // android.support.v7.preference.Preference
    public void B() {
        j.b c2;
        if (i() != null || g() != null || L() == 0 || (c2 = o().c()) == null) {
            return;
        }
        c2.a(this);
    }

    @Override // android.support.v7.preference.PreferenceGroup
    public boolean M() {
        return false;
    }

    public boolean O() {
        return this.U;
    }
}
