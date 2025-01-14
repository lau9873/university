package android.support.p067v7.preference.internal;

import android.content.Context;
import android.support.p067v7.preference.DialogPreference;
import android.util.AttributeSet;
import java.util.Set;

/* renamed from: android.support.v7.preference.internal.AbstractMultiSelectListPreference */
/* loaded from: classes.dex */
public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: P */
    public abstract CharSequence[] mo7148P();

    /* renamed from: Q */
    public abstract CharSequence[] mo7147Q();

    /* renamed from: R */
    public abstract Set<String> mo7146R();

    /* renamed from: c */
    public abstract void mo7145c(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
