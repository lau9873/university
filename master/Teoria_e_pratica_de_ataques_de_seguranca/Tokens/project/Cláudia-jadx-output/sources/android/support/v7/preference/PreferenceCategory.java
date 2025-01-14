package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.g.k.e0.c;
import a.b.h.f.l;
import a.b.h.f.m;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // android.support.v7.preference.Preference
    public boolean G() {
        return !super.u();
    }

    @Override // android.support.v7.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        if (Build.VERSION.SDK_INT >= 28) {
            lVar.f2580a.setAccessibilityHeading(true);
        }
    }

    @Override // android.support.v7.preference.Preference
    public boolean u() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.preferenceCategoryStyle, 16842892));
    }

    @Override // android.support.v7.preference.Preference
    public void a(c cVar) {
        c.b c2;
        super.a(cVar);
        if (Build.VERSION.SDK_INT >= 28 || (c2 = cVar.c()) == null) {
            return;
        }
        cVar.b(c.b.a(c2.c(), c2.d(), c2.a(), c2.b(), true, c2.e()));
    }
}
