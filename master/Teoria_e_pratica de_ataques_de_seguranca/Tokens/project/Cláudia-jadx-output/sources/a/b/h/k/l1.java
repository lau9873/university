package a.b.h.k;

import a.b.g.b.g.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1821a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f1822b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f1823c;

    public l1(Context context, TypedArray typedArray) {
        this.f1821a = context;
        this.f1822b = typedArray;
    }

    public static l1 a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new l1(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i2) {
        int resourceId;
        if (this.f1822b.hasValue(i2) && (resourceId = this.f1822b.getResourceId(i2, 0)) != 0) {
            return a.b.h.d.a.a.c(this.f1821a, resourceId);
        }
        return this.f1822b.getDrawable(i2);
    }

    public Drawable c(int i2) {
        int resourceId;
        if (!this.f1822b.hasValue(i2) || (resourceId = this.f1822b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return k.a().a(this.f1821a, resourceId, true);
    }

    public String d(int i2) {
        return this.f1822b.getString(i2);
    }

    public CharSequence e(int i2) {
        return this.f1822b.getText(i2);
    }

    public int f(int i2, int i3) {
        return this.f1822b.getLayoutDimension(i2, i3);
    }

    public int g(int i2, int i3) {
        return this.f1822b.getResourceId(i2, i3);
    }

    public static l1 a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new l1(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public int d(int i2, int i3) {
        return this.f1822b.getInt(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f1822b.getInteger(i2, i3);
    }

    public CharSequence[] f(int i2) {
        return this.f1822b.getTextArray(i2);
    }

    public boolean g(int i2) {
        return this.f1822b.hasValue(i2);
    }

    public static l1 a(Context context, int i2, int[] iArr) {
        return new l1(context, context.obtainStyledAttributes(i2, iArr));
    }

    public int c(int i2, int i3) {
        return this.f1822b.getDimensionPixelSize(i2, i3);
    }

    public Typeface a(int i2, int i3, f.a aVar) {
        int resourceId = this.f1822b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1823c == null) {
            this.f1823c = new TypedValue();
        }
        return a.b.g.b.g.f.a(this.f1821a, resourceId, this.f1823c, i3, aVar);
    }

    public float b(int i2, float f2) {
        return this.f1822b.getFloat(i2, f2);
    }

    public int b(int i2, int i3) {
        return this.f1822b.getDimensionPixelOffset(i2, i3);
    }

    public boolean a(int i2, boolean z) {
        return this.f1822b.getBoolean(i2, z);
    }

    public int a(int i2, int i3) {
        return this.f1822b.getColor(i2, i3);
    }

    public ColorStateList a(int i2) {
        int resourceId;
        ColorStateList b2;
        return (!this.f1822b.hasValue(i2) || (resourceId = this.f1822b.getResourceId(i2, 0)) == 0 || (b2 = a.b.h.d.a.a.b(this.f1821a, resourceId)) == null) ? this.f1822b.getColorStateList(i2) : b2;
    }

    public float a(int i2, float f2) {
        return this.f1822b.getDimension(i2, f2);
    }

    public void a() {
        this.f1822b.recycle();
    }
}
