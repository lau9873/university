package p000a.p006b.p049h.p063k;

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
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.a0 */
/* loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper {

    /* renamed from: k */
    public static final RectF f2504k = new RectF();

    /* renamed from: l */
    public static ConcurrentHashMap<String, Method> f2505l = new ConcurrentHashMap<>();

    /* renamed from: a */
    public int f2506a = 0;

    /* renamed from: b */
    public boolean f2507b = false;

    /* renamed from: c */
    public float f2508c = -1.0f;

    /* renamed from: d */
    public float f2509d = -1.0f;

    /* renamed from: e */
    public float f2510e = -1.0f;

    /* renamed from: f */
    public int[] f2511f = new int[0];

    /* renamed from: g */
    public boolean f2512g = false;

    /* renamed from: h */
    public TextPaint f2513h;

    /* renamed from: i */
    public final TextView f2514i;

    /* renamed from: j */
    public final Context f2515j;

    public AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.f2514i = textView;
        this.f2515j = this.f2514i.getContext();
    }

    /* renamed from: a */
    public void m8552a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f2515j.obtainStyledAttributes(attributeSet, C0363j.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTextView_autoSizeTextType)) {
            this.f2506a = obtainStyledAttributes.getInt(C0363j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(C0363j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(C0363j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(C0363j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(C0363j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(C0363j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(C0363j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(C0363j.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(C0363j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m8554a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (m8536k()) {
            if (this.f2506a == 1) {
                if (!this.f2512g) {
                    DisplayMetrics displayMetrics = this.f2515j.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    m8559a(dimension2, dimension3, dimension);
                }
                m8538i();
                return;
            }
            return;
        }
        this.f2506a = 0;
    }

    /* renamed from: b */
    public final void m8545b() {
        this.f2506a = 0;
        this.f2509d = -1.0f;
        this.f2510e = -1.0f;
        this.f2508c = -1.0f;
        this.f2511f = new int[0];
        this.f2507b = false;
    }

    /* renamed from: c */
    public int m8544c() {
        return Math.round(this.f2510e);
    }

    /* renamed from: d */
    public int m8543d() {
        return Math.round(this.f2509d);
    }

    /* renamed from: e */
    public int m8542e() {
        return Math.round(this.f2508c);
    }

    /* renamed from: f */
    public int[] m8541f() {
        return this.f2511f;
    }

    /* renamed from: g */
    public int m8540g() {
        return this.f2506a;
    }

    /* renamed from: h */
    public boolean m8539h() {
        return m8536k() && this.f2506a != 0;
    }

    /* renamed from: i */
    public final boolean m8538i() {
        if (m8536k() && this.f2506a == 1) {
            if (!this.f2512g || this.f2511f.length == 0) {
                float round = Math.round(this.f2509d);
                int i = 1;
                while (Math.round(this.f2508c + round) <= Math.round(this.f2510e)) {
                    i++;
                    round += this.f2508c;
                }
                int[] iArr = new int[i];
                float f = this.f2509d;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.f2508c;
                }
                this.f2511f = m8547a(iArr);
            }
            this.f2507b = true;
        } else {
            this.f2507b = false;
        }
        return this.f2507b;
    }

    /* renamed from: j */
    public final boolean m8537j() {
        int length = this.f2511f.length;
        this.f2512g = length > 0;
        if (this.f2512g) {
            this.f2506a = 1;
            int[] iArr = this.f2511f;
            this.f2509d = iArr[0];
            this.f2510e = iArr[length - 1];
            this.f2508c = -1.0f;
        }
        return this.f2512g;
    }

    /* renamed from: k */
    public final boolean m8536k() {
        return !(this.f2514i instanceof AppCompatEditText);
    }

    /* renamed from: a */
    public void m8558a(int i) {
        if (m8536k()) {
            if (i == 0) {
                m8545b();
            } else if (i == 1) {
                DisplayMetrics displayMetrics = this.f2515j.getResources().getDisplayMetrics();
                m8559a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (m8538i()) {
                    m8561a();
                }
            } else {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    /* renamed from: a */
    public void m8556a(int i, int i2, int i3, int i4) {
        if (m8536k()) {
            DisplayMetrics displayMetrics = this.f2515j.getResources().getDisplayMetrics();
            m8559a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m8538i()) {
                m8561a();
            }
        }
    }

    /* renamed from: a */
    public void m8546a(int[] iArr, int i) {
        if (m8536k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2515j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f2511f = m8547a(iArr2);
                if (!m8537j()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f2512g = false;
            }
            if (m8538i()) {
                m8561a();
            }
        }
    }

    /* renamed from: a */
    public final void m8554a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f2511f = m8547a(iArr);
            m8537j();
        }
    }

    /* renamed from: a */
    public final int[] m8547a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: a */
    public final void m8559a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f2506a = 1;
            this.f2509d = f;
            this.f2510e = f2;
            this.f2508c = f3;
            this.f2512g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }

    /* renamed from: a */
    public void m8561a() {
        if (m8539h()) {
            if (this.f2507b) {
                if (this.f2514i.getMeasuredHeight() <= 0 || this.f2514i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = ((Boolean) m8549a((Object) this.f2514i, "getHorizontallyScrolling", (String) false)).booleanValue() ? 1048576 : (this.f2514i.getMeasuredWidth() - this.f2514i.getTotalPaddingLeft()) - this.f2514i.getTotalPaddingRight();
                int height = (this.f2514i.getHeight() - this.f2514i.getCompoundPaddingBottom()) - this.f2514i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f2504k) {
                    f2504k.setEmpty();
                    f2504k.right = measuredWidth;
                    f2504k.bottom = height;
                    float m8553a = m8553a(f2504k);
                    if (m8553a != this.f2514i.getTextSize()) {
                        m8557a(0, m8553a);
                    }
                }
            }
            this.f2507b = true;
        }
    }

    /* renamed from: a */
    public void m8557a(int i, float f) {
        Resources resources;
        Context context = this.f2515j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        m8560a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    /* renamed from: a */
    public final void m8560a(float f) {
        if (f != this.f2514i.getPaint().getTextSize()) {
            this.f2514i.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f2514i.isInLayout() : false;
            if (this.f2514i.getLayout() != null) {
                this.f2507b = false;
                try {
                    Method m8548a = m8548a("nullLayouts");
                    if (m8548a != null) {
                        m8548a.invoke(this.f2514i, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.f2514i.requestLayout();
                } else {
                    this.f2514i.forceLayout();
                }
                this.f2514i.invalidate();
            }
        }
    }

    /* renamed from: a */
    public final int m8553a(RectF rectF) {
        int length = this.f2511f.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (m8555a(this.f2511f[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.f2511f[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* renamed from: a */
    public final boolean m8555a(int i, RectF rectF) {
        StaticLayout m8551a;
        CharSequence transformation;
        CharSequence text = this.f2514i.getText();
        TransformationMethod transformationMethod = this.f2514i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f2514i)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f2514i.getMaxLines() : -1;
        TextPaint textPaint = this.f2513h;
        if (textPaint == null) {
            this.f2513h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f2513h.set(this.f2514i.getPaint());
        this.f2513h.setTextSize(i);
        Layout.Alignment alignment = (Layout.Alignment) m8549a((Object) this.f2514i, "getLayoutAlignment", (String) Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23) {
            m8551a = m8550a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            m8551a = m8551a(text, alignment, Math.round(rectF.right));
        }
        return (maxLines == -1 || (m8551a.getLineCount() <= maxLines && m8551a.getLineEnd(m8551a.getLineCount() - 1) == text.length())) && ((float) m8551a.getHeight()) <= rectF.bottom;
    }

    /* renamed from: a */
    public final StaticLayout m8550a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m8549a((Object) this.f2514i, "getTextDirectionHeuristic", (String) TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f2513h, i).setAlignment(alignment).setLineSpacing(this.f2514i.getLineSpacingExtra(), this.f2514i.getLineSpacingMultiplier()).setIncludePad(this.f2514i.getIncludeFontPadding()).setBreakStrategy(this.f2514i.getBreakStrategy()).setHyphenationFrequency(this.f2514i.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* renamed from: a */
    public final StaticLayout m8551a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        float floatValue;
        float floatValue2;
        boolean booleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            floatValue = this.f2514i.getLineSpacingMultiplier();
            floatValue2 = this.f2514i.getLineSpacingExtra();
            booleanValue = this.f2514i.getIncludeFontPadding();
        } else {
            floatValue = ((Float) m8549a((Object) this.f2514i, "getLineSpacingMultiplier", (String) Float.valueOf(1.0f))).floatValue();
            floatValue2 = ((Float) m8549a((Object) this.f2514i, "getLineSpacingExtra", (String) Float.valueOf(0.0f))).floatValue();
            booleanValue = ((Boolean) m8549a((Object) this.f2514i, "getIncludeFontPadding", (String) true)).booleanValue();
        }
        return new StaticLayout(charSequence, this.f2513h, i, alignment, floatValue, floatValue2, booleanValue);
    }

    /* renamed from: a */
    public final <T> T m8549a(Object obj, String str, T t) {
        try {
            return (T) m8548a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* renamed from: a */
    public final Method m8548a(String str) {
        try {
            Method method = f2505l.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f2505l.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }
}
