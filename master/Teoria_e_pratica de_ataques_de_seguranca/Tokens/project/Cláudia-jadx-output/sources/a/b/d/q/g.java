package a.b.d.q;

import a.b.d.k;
import a.b.h.k.l1;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* compiled from: ThemeEnforcement.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f286a = {a.b.d.b.colorPrimary};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f287b = {a.b.d.b.colorSecondary};

    public static void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ThemeEnforcement, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(k.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            b(context);
        }
        a(context);
    }

    public static boolean b(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int i4 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i4, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray c(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        a(context, attributeSet, i2, i3);
        a(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static l1 d(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        a(context, attributeSet, i2, i3);
        a(context, attributeSet, iArr, i2, i3, iArr2);
        return l1.a(context, attributeSet, iArr, i2, i3);
    }

    public static void b(Context context) {
        a(context, f287b, "Theme.MaterialComponents");
    }

    public static void a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ThemeEnforcement, i2, i3);
        if (!obtainStyledAttributes.getBoolean(k.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z = b(context, attributeSet, iArr, i2, i3, iArr2);
        } else {
            z = obtainStyledAttributes.getResourceId(k.ThemeEnforcement_android_textAppearance, -1) != -1;
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void a(Context context) {
        a(context, f286a, "Theme.AppCompat");
    }

    public static boolean a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    public static void a(Context context, int[] iArr, String str) {
        if (a(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }
}
