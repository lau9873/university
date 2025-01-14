package a.b.d.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
/* compiled from: MaterialResources.java */
/* loaded from: classes.dex */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList b2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (b2 = a.b.h.d.a.a.b(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : b2;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable c2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (c2 = a.b.h.d.a.a.c(context, resourceId)) == null) ? typedArray.getDrawable(i2) : c2;
    }
}
