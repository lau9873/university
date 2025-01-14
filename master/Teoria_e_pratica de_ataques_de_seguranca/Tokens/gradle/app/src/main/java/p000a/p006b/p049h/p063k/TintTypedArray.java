package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import p000a.p006b.p030g.p032b.p033g.ResourcesCompat;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.h.k.l1 */
/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: a */
    public final Context f2753a;

    /* renamed from: b */
    public final TypedArray f2754b;

    /* renamed from: c */
    public TypedValue f2755c;

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.f2753a = context;
        this.f2754b = typedArray;
    }

    /* renamed from: a */
    public static TintTypedArray m8258a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: b */
    public Drawable m8256b(int i) {
        int resourceId;
        if (this.f2754b.hasValue(i) && (resourceId = this.f2754b.getResourceId(i, 0)) != 0) {
            return AppCompatResources.m8967c(this.f2753a, resourceId);
        }
        return this.f2754b.getDrawable(i);
    }

    /* renamed from: c */
    public Drawable m8253c(int i) {
        int resourceId;
        if (!this.f2754b.hasValue(i) || (resourceId = this.f2754b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.m8318a().m8310a(this.f2753a, resourceId, true);
    }

    /* renamed from: d */
    public String m8251d(int i) {
        return this.f2754b.getString(i);
    }

    /* renamed from: e */
    public CharSequence m8249e(int i) {
        return this.f2754b.getText(i);
    }

    /* renamed from: f */
    public int m8246f(int i, int i2) {
        return this.f2754b.getLayoutDimension(i, i2);
    }

    /* renamed from: g */
    public int m8244g(int i, int i2) {
        return this.f2754b.getResourceId(i, i2);
    }

    /* renamed from: a */
    public static TintTypedArray m8257a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: d */
    public int m8250d(int i, int i2) {
        return this.f2754b.getInt(i, i2);
    }

    /* renamed from: e */
    public int m8248e(int i, int i2) {
        return this.f2754b.getInteger(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] m8247f(int i) {
        return this.f2754b.getTextArray(i);
    }

    /* renamed from: g */
    public boolean m8245g(int i) {
        return this.f2754b.hasValue(i);
    }

    /* renamed from: a */
    public static TintTypedArray m8259a(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    /* renamed from: c */
    public int m8252c(int i, int i2) {
        return this.f2754b.getDimensionPixelSize(i, i2);
    }

    /* renamed from: a */
    public Typeface m8261a(int i, int i2, ResourcesCompat.AbstractC0210a abstractC0210a) {
        int resourceId = this.f2754b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2755c == null) {
            this.f2755c = new TypedValue();
        }
        return ResourcesCompat.m9952a(this.f2753a, resourceId, this.f2755c, i2, abstractC0210a);
    }

    /* renamed from: b */
    public float m8255b(int i, float f) {
        return this.f2754b.getFloat(i, f);
    }

    /* renamed from: b */
    public int m8254b(int i, int i2) {
        return this.f2754b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: a */
    public boolean m8260a(int i, boolean z) {
        return this.f2754b.getBoolean(i, z);
    }

    /* renamed from: a */
    public int m8262a(int i, int i2) {
        return this.f2754b.getColor(i, i2);
    }

    /* renamed from: a */
    public ColorStateList m8264a(int i) {
        int resourceId;
        ColorStateList m8968b;
        return (!this.f2754b.hasValue(i) || (resourceId = this.f2754b.getResourceId(i, 0)) == 0 || (m8968b = AppCompatResources.m8968b(this.f2753a, resourceId)) == null) ? this.f2754b.getColorStateList(i) : m8968b;
    }

    /* renamed from: a */
    public float m8263a(int i, float f) {
        return this.f2754b.getDimension(i, f);
    }

    /* renamed from: a */
    public void m8265a() {
        this.f2754b.recycle();
    }
}
