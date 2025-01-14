package p000a.p006b.p012d.p020r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.d.r.a */
/* loaded from: classes.dex */
public class MaterialResources {
    /* renamed from: a */
    public static ColorStateList m10857a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList m8968b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (m8968b = AppCompatResources.m8968b(context, resourceId)) == null) ? typedArray.getColorStateList(i) : m8968b;
    }

    /* renamed from: b */
    public static Drawable m10856b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable m8967c;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (m8967c = AppCompatResources.m8967c(context, resourceId)) == null) ? typedArray.getDrawable(i) : m8967c;
    }
}
