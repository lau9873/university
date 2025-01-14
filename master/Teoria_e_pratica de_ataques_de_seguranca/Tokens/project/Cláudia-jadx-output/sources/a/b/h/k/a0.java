package a.b.h.k;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
public class a0 {
    public static final RectF k = new RectF();
    public static ConcurrentHashMap<String, Method> l = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public int f1643a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1644b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f1645c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f1646d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f1647e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f1648f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f1649g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f1650h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f1651i;
    public final Context j;

    public a0(TextView textView) {
        this.f1651i = textView;
        this.j = this.f1651i.getContext();
    }

    public void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.j.obtainStyledAttributes(attributeSet, a.b.h.b.j.AppCompatTextView, i2, 0);
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTextView_autoSizeTextType)) {
            this.f1643a = obtainStyledAttributes.getInt(a.b.h.b.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(a.b.h.b.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(a.b.h.b.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(a.b.h.b.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(a.b.h.b.j.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(a.b.h.b.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (k()) {
            if (this.f1643a == 1) {
                if (!this.f1649g) {
                    DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    a(dimension2, dimension3, dimension);
                }
                i();
                return;
            }
            return;
        }
        this.f1643a = 0;
    }

    public final void b() {
        this.f1643a = 0;
        this.f1646d = -1.0f;
        this.f1647e = -1.0f;
        this.f1645c = -1.0f;
        this.f1648f = new int[0];
        this.f1644b = false;
    }

    public int c() {
        return Math.round(this.f1647e);
    }

    public int d() {
        return Math.round(this.f1646d);
    }

    public int e() {
        return Math.round(this.f1645c);
    }

    public int[] f() {
        return this.f1648f;
    }

    public int g() {
        return this.f1643a;
    }

    public boolean h() {
        return k() && this.f1643a != 0;
    }

    public final boolean i() {
        if (k() && this.f1643a == 1) {
            if (!this.f1649g || this.f1648f.length == 0) {
                float round = Math.round(this.f1646d);
                int i2 = 1;
                while (Math.round(this.f1645c + round) <= Math.round(this.f1647e)) {
                    i2++;
                    round += this.f1645c;
                }
                int[] iArr = new int[i2];
                float f2 = this.f1646d;
                for (int i3 = 0; i3 < i2; i3++) {
                    iArr[i3] = Math.round(f2);
                    f2 += this.f1645c;
                }
                this.f1648f = a(iArr);
            }
            this.f1644b = true;
        } else {
            this.f1644b = false;
        }
        return this.f1644b;
    }

    public final boolean j() {
        int length = this.f1648f.length;
        this.f1649g = length > 0;
        if (this.f1649g) {
            this.f1643a = 1;
            int[] iArr = this.f1648f;
            this.f1646d = iArr[0];
            this.f1647e = iArr[length - 1];
            this.f1645c = -1.0f;
        }
        return this.f1649g;
    }

    public final boolean k() {
        return !(this.f1651i instanceof l);
    }

    public void a(int i2) {
        if (k()) {
            if (i2 == 0) {
                b();
            } else if (i2 == 1) {
                DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (i()) {
                    a();
                }
            } else {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (k()) {
            DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (i()) {
                a();
            }
        }
    }

    public void a(int[] iArr, int i2) {
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.f1648f = a(iArr2);
                if (!j()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1649g = false;
            }
            if (i()) {
                a();
            }
        }
    }

    public final void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f1648f = a(iArr);
            j();
        }
    }

    public final int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    public final void a(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f1643a = 1;
            this.f1646d = f2;
            this.f1647e = f3;
            this.f1645c = f4;
            this.f1649g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    public void a() {
        if (h()) {
            if (this.f1644b) {
                if (this.f1651i.getMeasuredHeight() <= 0 || this.f1651i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = ((Boolean) a((Object) this.f1651i, "getHorizontallyScrolling", (String) false)).booleanValue() ? 1048576 : (this.f1651i.getMeasuredWidth() - this.f1651i.getTotalPaddingLeft()) - this.f1651i.getTotalPaddingRight();
                int height = (this.f1651i.getHeight() - this.f1651i.getCompoundPaddingBottom()) - this.f1651i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (k) {
                    k.setEmpty();
                    k.right = measuredWidth;
                    k.bottom = height;
                    float a2 = a(k);
                    if (a2 != this.f1651i.getTextSize()) {
                        a(0, a2);
                    }
                }
            }
            this.f1644b = true;
        }
    }

    public void a(int i2, float f2) {
        Resources resources;
        Context context = this.j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    public final void a(float f2) {
        if (f2 != this.f1651i.getPaint().getTextSize()) {
            this.f1651i.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1651i.isInLayout() : false;
            if (this.f1651i.getLayout() != null) {
                this.f1644b = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.f1651i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f1651i.requestLayout();
                } else {
                    this.f1651i.forceLayout();
                }
                this.f1651i.invalidate();
            }
        }
    }

    public final int a(RectF rectF) {
        int length = this.f1648f.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                if (a(this.f1648f[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i3;
                    i3 = i6;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f1648f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final boolean a(int i2, RectF rectF) {
        StaticLayout a2;
        CharSequence transformation;
        CharSequence text = this.f1651i.getText();
        TransformationMethod transformationMethod = this.f1651i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1651i)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1651i.getMaxLines() : -1;
        TextPaint textPaint = this.f1650h;
        if (textPaint == null) {
            this.f1650h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1650h.set(this.f1651i.getPaint());
        this.f1650h.setTextSize(i2);
        Layout.Alignment alignment = (Layout.Alignment) a((Object) this.f1651i, "getLayoutAlignment", (String) Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23) {
            a2 = a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            a2 = a(text, alignment, Math.round(rectF.right));
        }
        return (maxLines == -1 || (a2.getLineCount() <= maxLines && a2.getLineEnd(a2.getLineCount() - 1) == text.length())) && ((float) a2.getHeight()) <= rectF.bottom;
    }

    public final StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) a((Object) this.f1651i, "getTextDirectionHeuristic", (String) TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1650h, i2).setAlignment(alignment).setLineSpacing(this.f1651i.getLineSpacingExtra(), this.f1651i.getLineSpacingMultiplier()).setIncludePad(this.f1651i.getIncludeFontPadding()).setBreakStrategy(this.f1651i.getBreakStrategy()).setHyphenationFrequency(this.f1651i.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i3).setTextDirection(textDirectionHeuristic).build();
    }

    public final StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        float floatValue;
        float floatValue2;
        boolean booleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            floatValue = this.f1651i.getLineSpacingMultiplier();
            floatValue2 = this.f1651i.getLineSpacingExtra();
            booleanValue = this.f1651i.getIncludeFontPadding();
        } else {
            floatValue = ((Float) a((Object) this.f1651i, "getLineSpacingMultiplier", (String) Float.valueOf(1.0f))).floatValue();
            floatValue2 = ((Float) a((Object) this.f1651i, "getLineSpacingExtra", (String) Float.valueOf(0.0f))).floatValue();
            booleanValue = ((Boolean) a((Object) this.f1651i, "getIncludeFontPadding", (String) true)).booleanValue();
        }
        return new StaticLayout(charSequence, this.f1650h, i2, alignment, floatValue, floatValue2, booleanValue);
    }

    public final <T> T a(Object obj, String str, T t) {
        try {
            return (T) a(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    public final Method a(String str) {
        try {
            Method method = l.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                l.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }
}
