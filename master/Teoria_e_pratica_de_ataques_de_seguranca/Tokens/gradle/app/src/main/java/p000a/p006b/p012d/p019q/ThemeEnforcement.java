package p000a.p006b.p012d.p019q;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: a.b.d.q.g */
/* loaded from: classes.dex */
public final class ThemeEnforcement {

    /* renamed from: a */
    public static final int[] f540a = {C0040b.colorPrimary};

    /* renamed from: b */
    public static final int[] f541b = {C0040b.colorSecondary};

    /* renamed from: a */
    public static void m10867a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(C0049k.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            m10863b(context);
        }
        m10868a(context);
    }

    /* renamed from: b */
    public static boolean m10862b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i3, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    /* renamed from: c */
    public static TypedArray m10861c(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m10867a(context, attributeSet, i, i2);
        m10866a(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    /* renamed from: d */
    public static TintTypedArray m10860d(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m10867a(context, attributeSet, i, i2);
        m10866a(context, attributeSet, iArr, i, i2, iArr2);
        return TintTypedArray.m8257a(context, attributeSet, iArr, i, i2);
    }

    /* renamed from: b */
    public static void m10863b(Context context) {
        m10864a(context, f541b, "Theme.MaterialComponents");
    }

    /* renamed from: a */
    public static void m10866a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.ThemeEnforcement, i, i2);
        if (!obtainStyledAttributes.getBoolean(C0049k.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z = m10862b(context, attributeSet, iArr, i, i2, iArr2);
        } else {
            z = obtainStyledAttributes.getResourceId(C0049k.ThemeEnforcement_android_textAppearance, -1) != -1;
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    /* renamed from: a */
    public static void m10868a(Context context) {
        m10864a(context, f540a, "Theme.AppCompat");
    }

    /* renamed from: a */
    public static boolean m10865a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    /* renamed from: a */
    public static void m10864a(Context context, int[] iArr, String str) {
        if (m10865a(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }
}
