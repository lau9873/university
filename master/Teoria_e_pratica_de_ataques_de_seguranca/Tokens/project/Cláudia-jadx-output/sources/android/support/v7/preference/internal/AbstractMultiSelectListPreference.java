package android.support.v7.preference.internal;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public abstract CharSequence[] P();

    public abstract CharSequence[] Q();

    public abstract Set<String> R();

    public abstract void c(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
