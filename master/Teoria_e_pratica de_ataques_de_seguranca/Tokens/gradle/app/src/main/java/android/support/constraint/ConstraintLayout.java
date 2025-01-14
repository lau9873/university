package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import p000a.p006b.p008b.C0023g;
import p000a.p006b.p008b.ConstraintHelper;
import p000a.p006b.p008b.ConstraintSet;
import p000a.p006b.p008b.Placeholder;
import p000a.p006b.p008b.p009h.Metrics;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidget;
import p000a.p006b.p008b.p009h.p010j.ConstraintWidgetContainer;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a */
    public SparseArray<View> f3054a;

    /* renamed from: b */
    public ArrayList<ConstraintHelper> f3055b;

    /* renamed from: c */
    public final ArrayList<ConstraintWidget> f3056c;

    /* renamed from: d */
    public ConstraintWidgetContainer f3057d;

    /* renamed from: e */
    public int f3058e;

    /* renamed from: f */
    public int f3059f;

    /* renamed from: g */
    public int f3060g;

    /* renamed from: h */
    public int f3061h;

    /* renamed from: i */
    public boolean f3062i;

    /* renamed from: j */
    public int f3063j;

    /* renamed from: k */
    public ConstraintSet f3064k;

    /* renamed from: m */
    public int f3065m;

    /* renamed from: n */
    public HashMap<String, Integer> f3066n;

    /* renamed from: o */
    public int f3067o;

    /* renamed from: p */
    public int f3068p;

    /* renamed from: q */
    public Metrics f3069q;

    public ConstraintLayout(Context context) {
        super(context);
        this.f3054a = new SparseArray<>();
        this.f3055b = new ArrayList<>(4);
        this.f3056c = new ArrayList<>(100);
        this.f3057d = new ConstraintWidgetContainer();
        this.f3058e = 0;
        this.f3059f = 0;
        this.f3060g = Integer.MAX_VALUE;
        this.f3061h = Integer.MAX_VALUE;
        this.f3062i = true;
        this.f3063j = 7;
        this.f3064k = null;
        this.f3065m = -1;
        this.f3066n = new HashMap<>();
        this.f3067o = -1;
        this.f3068p = -1;
        m7930a((AttributeSet) null);
    }

    /* renamed from: a */
    public void m7931a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f3066n == null) {
                this.f3066n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f3066n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* renamed from: b */
    public final void m7927b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.f3056c.clear();
            m7935a();
        }
    }

    /* renamed from: c */
    public final void m7924c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).m11240a(this);
            }
        }
        int size = this.f3055b.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f3055b.get(i2).m11255b(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0520a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((parseInt / 1080.0f) * width);
                        int i3 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i2;
                        float f2 = i3;
                        float f3 = i2 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i3 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public int getMaxHeight() {
        return this.f3061h;
    }

    public int getMaxWidth() {
        return this.f3060g;
    }

    public int getMinHeight() {
        return this.f3059f;
    }

    public int getMinWidth() {
        return this.f3058e;
    }

    public int getOptimizationLevel() {
        return this.f3057d.m11049N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0520a c0520a = (C0520a) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = c0520a.f3117k0;
            if ((childAt.getVisibility() != 8 || c0520a.f3093X || c0520a.f3094Y || isInEditMode) && !c0520a.f3095Z) {
                int m11081h = constraintWidget.m11081h();
                int m11079i = constraintWidget.m11079i();
                int m11057t = constraintWidget.m11057t() + m11081h;
                int m11077j = constraintWidget.m11077j() + m11079i;
                childAt.layout(m11081h, m11079i, m11057t, m11077j);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(m11081h, m11079i, m11057t, m11077j);
                }
            }
        }
        int size = this.f3055b.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.f3055b.get(i6).m11258a(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget m7929a = m7929a(view);
        if ((view instanceof Guideline) && !(m7929a instanceof p000a.p006b.p008b.p009h.p010j.Guideline)) {
            C0520a c0520a = (C0520a) view.getLayoutParams();
            c0520a.f3117k0 = new p000a.p006b.p008b.p009h.p010j.Guideline();
            c0520a.f3093X = true;
            ((p000a.p006b.p008b.p009h.p010j.Guideline) c0520a.f3117k0).m11013w(c0520a.f3087R);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.m11259a();
            ((C0520a) view.getLayoutParams()).f3094Y = true;
            if (!this.f3055b.contains(constraintHelper)) {
                this.f3055b.add(constraintHelper);
            }
        }
        this.f3054a.put(view.getId(), view);
        this.f3062i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f3054a.remove(view.getId());
        ConstraintWidget m7929a = m7929a(view);
        this.f3057d.m10974c(m7929a);
        this.f3055b.remove(view);
        this.f3056c.remove(m7929a);
        this.f3062i = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f3062i = true;
        this.f3067o = -1;
        this.f3068p = -1;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f3064k = constraintSet;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f3054a.remove(getId());
        super.setId(i);
        this.f3054a.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f3061h) {
            return;
        }
        this.f3061h = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f3060g) {
            return;
        }
        this.f3060g = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f3059f) {
            return;
        }
        this.f3059f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f3058e) {
            return;
        }
        this.f3058e = i;
        requestLayout();
    }

    public void setOptimizationLevel(int i) {
        this.f3057d.m11031v(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public C0520a generateDefaultLayoutParams() {
        return new C0520a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public C0520a generateLayoutParams(AttributeSet attributeSet) {
        return new C0520a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0520a(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02ca A[ADDED_TO_REGION] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7925b(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.m7925b(int, int):void");
    }

    /* renamed from: c */
    public final void m7923c(int i, int i2) {
        int i3;
        ConstraintWidget.EnumC0033b enumC0033b;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.EnumC0033b enumC0033b2 = ConstraintWidget.EnumC0033b.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                enumC0033b = ConstraintWidget.EnumC0033b.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                enumC0033b = enumC0033b2;
            } else {
                i3 = Math.min(this.f3060g, size) - paddingLeft;
                enumC0033b = enumC0033b2;
            }
            i3 = 0;
        } else {
            i3 = size;
            enumC0033b = ConstraintWidget.EnumC0033b.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                enumC0033b2 = ConstraintWidget.EnumC0033b.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f3061h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            enumC0033b2 = ConstraintWidget.EnumC0033b.WRAP_CONTENT;
        }
        this.f3057d.m11070m(0);
        this.f3057d.m11072l(0);
        this.f3057d.m11109a(enumC0033b);
        this.f3057d.m11064p(i3);
        this.f3057d.m11098b(enumC0033b2);
        this.f3057d.m11080h(size2);
        this.f3057d.m11070m((this.f3058e - getPaddingLeft()) - getPaddingRight());
        this.f3057d.m11072l((this.f3059f - getPaddingTop()) - getPaddingBottom());
    }

    /* renamed from: a */
    public Object m7932a(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.f3066n;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.f3066n.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public final void m7930a(AttributeSet attributeSet) {
        this.f3057d.m11106a(this);
        this.f3054a.put(getId(), this);
        this.f3064k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0023g.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0023g.ConstraintLayout_Layout_android_minWidth) {
                    this.f3058e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3058e);
                } else if (index == C0023g.ConstraintLayout_Layout_android_minHeight) {
                    this.f3059f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3059f);
                } else if (index == C0023g.ConstraintLayout_Layout_android_maxWidth) {
                    this.f3060g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3060g);
                } else if (index == C0023g.ConstraintLayout_Layout_android_maxHeight) {
                    this.f3061h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3061h);
                } else if (index == C0023g.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f3063j = obtainStyledAttributes.getInt(index, this.f3063j);
                } else if (index == C0023g.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f3064k = new ConstraintSet();
                        this.f3064k.m11251a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f3064k = null;
                    }
                    this.f3065m = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f3057d.m11031v(this.f3063j);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3054a = new SparseArray<>();
        this.f3055b = new ArrayList<>(4);
        this.f3056c = new ArrayList<>(100);
        this.f3057d = new ConstraintWidgetContainer();
        this.f3058e = 0;
        this.f3059f = 0;
        this.f3060g = Integer.MAX_VALUE;
        this.f3061h = Integer.MAX_VALUE;
        this.f3062i = true;
        this.f3063j = 7;
        this.f3064k = null;
        this.f3065m = -1;
        this.f3066n = new HashMap<>();
        this.f3067o = -1;
        this.f3068p = -1;
        m7930a(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3054a = new SparseArray<>();
        this.f3055b = new ArrayList<>(4);
        this.f3056c = new ArrayList<>(100);
        this.f3057d = new ConstraintWidgetContainer();
        this.f3058e = 0;
        this.f3059f = 0;
        this.f3060g = Integer.MAX_VALUE;
        this.f3061h = Integer.MAX_VALUE;
        this.f3062i = true;
        this.f3063j = 7;
        this.f3064k = null;
        this.f3065m = -1;
        this.f3066n = new HashMap<>();
        this.f3067o = -1;
        this.f3068p = -1;
        m7930a(attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01d6, code lost:
        if (r11 != (-1)) goto L231;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03b4  */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.support.constraint.ConstraintLayout, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7935a() {
        /*
            Method dump skipped, instructions count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.m7935a():void");
    }

    /* renamed from: b */
    public View m7926b(int i) {
        return this.f3054a.get(i);
    }

    /* renamed from: android.support.constraint.ConstraintLayout$a */
    /* loaded from: classes.dex */
    public static class C0520a extends ViewGroup.MarginLayoutParams {

        /* renamed from: A */
        public float f3070A;

        /* renamed from: B */
        public String f3071B;

        /* renamed from: C */
        public int f3072C;

        /* renamed from: D */
        public float f3073D;

        /* renamed from: E */
        public float f3074E;

        /* renamed from: F */
        public int f3075F;

        /* renamed from: G */
        public int f3076G;

        /* renamed from: H */
        public int f3077H;

        /* renamed from: I */
        public int f3078I;

        /* renamed from: J */
        public int f3079J;

        /* renamed from: K */
        public int f3080K;

        /* renamed from: L */
        public int f3081L;

        /* renamed from: M */
        public int f3082M;

        /* renamed from: N */
        public float f3083N;

        /* renamed from: O */
        public float f3084O;

        /* renamed from: P */
        public int f3085P;

        /* renamed from: Q */
        public int f3086Q;

        /* renamed from: R */
        public int f3087R;

        /* renamed from: S */
        public boolean f3088S;

        /* renamed from: T */
        public boolean f3089T;

        /* renamed from: U */
        public boolean f3090U;

        /* renamed from: V */
        public boolean f3091V;

        /* renamed from: W */
        public boolean f3092W;

        /* renamed from: X */
        public boolean f3093X;

        /* renamed from: Y */
        public boolean f3094Y;

        /* renamed from: Z */
        public boolean f3095Z;

        /* renamed from: a */
        public int f3096a;

        /* renamed from: a0 */
        public int f3097a0;

        /* renamed from: b */
        public int f3098b;

        /* renamed from: b0 */
        public int f3099b0;

        /* renamed from: c */
        public float f3100c;

        /* renamed from: c0 */
        public int f3101c0;

        /* renamed from: d */
        public int f3102d;

        /* renamed from: d0 */
        public int f3103d0;

        /* renamed from: e */
        public int f3104e;

        /* renamed from: e0 */
        public int f3105e0;

        /* renamed from: f */
        public int f3106f;

        /* renamed from: f0 */
        public int f3107f0;

        /* renamed from: g */
        public int f3108g;

        /* renamed from: g0 */
        public float f3109g0;

        /* renamed from: h */
        public int f3110h;

        /* renamed from: h0 */
        public int f3111h0;

        /* renamed from: i */
        public int f3112i;

        /* renamed from: i0 */
        public int f3113i0;

        /* renamed from: j */
        public int f3114j;

        /* renamed from: j0 */
        public float f3115j0;

        /* renamed from: k */
        public int f3116k;

        /* renamed from: k0 */
        public ConstraintWidget f3117k0;

        /* renamed from: l */
        public int f3118l;

        /* renamed from: l0 */
        public boolean f3119l0;

        /* renamed from: m */
        public int f3120m;

        /* renamed from: n */
        public int f3121n;

        /* renamed from: o */
        public float f3122o;

        /* renamed from: p */
        public int f3123p;

        /* renamed from: q */
        public int f3124q;

        /* renamed from: r */
        public int f3125r;

        /* renamed from: s */
        public int f3126s;

        /* renamed from: t */
        public int f3127t;

        /* renamed from: u */
        public int f3128u;

        /* renamed from: v */
        public int f3129v;

        /* renamed from: w */
        public int f3130w;

        /* renamed from: x */
        public int f3131x;

        /* renamed from: y */
        public int f3132y;

        /* renamed from: z */
        public float f3133z;

        /* renamed from: android.support.constraint.ConstraintLayout$a$a */
        /* loaded from: classes.dex */
        public static class C0521a {

            /* renamed from: a */
            public static final SparseIntArray f3134a = new SparseIntArray();

            static {
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f3134a.append(C0023g.ConstraintLayout_Layout_android_orientation, 1);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f3134a.append(C0023g.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public C0520a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            this.f3096a = -1;
            this.f3098b = -1;
            this.f3100c = -1.0f;
            this.f3102d = -1;
            this.f3104e = -1;
            this.f3106f = -1;
            this.f3108g = -1;
            this.f3110h = -1;
            this.f3112i = -1;
            this.f3114j = -1;
            this.f3116k = -1;
            this.f3118l = -1;
            this.f3120m = -1;
            this.f3121n = 0;
            this.f3122o = 0.0f;
            this.f3123p = -1;
            this.f3124q = -1;
            this.f3125r = -1;
            this.f3126s = -1;
            this.f3127t = -1;
            this.f3128u = -1;
            this.f3129v = -1;
            this.f3130w = -1;
            this.f3131x = -1;
            this.f3132y = -1;
            this.f3133z = 0.5f;
            this.f3070A = 0.5f;
            this.f3071B = null;
            this.f3072C = 1;
            this.f3073D = -1.0f;
            this.f3074E = -1.0f;
            this.f3075F = 0;
            this.f3076G = 0;
            this.f3077H = 0;
            this.f3078I = 0;
            this.f3079J = 0;
            this.f3080K = 0;
            this.f3081L = 0;
            this.f3082M = 0;
            this.f3083N = 1.0f;
            this.f3084O = 1.0f;
            this.f3085P = -1;
            this.f3086Q = -1;
            this.f3087R = -1;
            this.f3088S = false;
            this.f3089T = false;
            this.f3090U = true;
            this.f3091V = true;
            this.f3092W = false;
            this.f3093X = false;
            this.f3094Y = false;
            this.f3095Z = false;
            this.f3097a0 = -1;
            this.f3099b0 = -1;
            this.f3101c0 = -1;
            this.f3103d0 = -1;
            this.f3105e0 = -1;
            this.f3107f0 = -1;
            this.f3109g0 = 0.5f;
            this.f3117k0 = new ConstraintWidget();
            this.f3119l0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0023g.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (C0521a.f3134a.get(index)) {
                    case 1:
                        this.f3087R = obtainStyledAttributes.getInt(index, this.f3087R);
                        break;
                    case 2:
                        this.f3120m = obtainStyledAttributes.getResourceId(index, this.f3120m);
                        if (this.f3120m == -1) {
                            this.f3120m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f3121n = obtainStyledAttributes.getDimensionPixelSize(index, this.f3121n);
                        break;
                    case 4:
                        this.f3122o = obtainStyledAttributes.getFloat(index, this.f3122o) % 360.0f;
                        float f = this.f3122o;
                        if (f < 0.0f) {
                            this.f3122o = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f3096a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3096a);
                        break;
                    case 6:
                        this.f3098b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3098b);
                        break;
                    case 7:
                        this.f3100c = obtainStyledAttributes.getFloat(index, this.f3100c);
                        break;
                    case 8:
                        this.f3102d = obtainStyledAttributes.getResourceId(index, this.f3102d);
                        if (this.f3102d == -1) {
                            this.f3102d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.f3104e = obtainStyledAttributes.getResourceId(index, this.f3104e);
                        if (this.f3104e == -1) {
                            this.f3104e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        this.f3106f = obtainStyledAttributes.getResourceId(index, this.f3106f);
                        if (this.f3106f == -1) {
                            this.f3106f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        this.f3108g = obtainStyledAttributes.getResourceId(index, this.f3108g);
                        if (this.f3108g == -1) {
                            this.f3108g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.f3110h = obtainStyledAttributes.getResourceId(index, this.f3110h);
                        if (this.f3110h == -1) {
                            this.f3110h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        this.f3112i = obtainStyledAttributes.getResourceId(index, this.f3112i);
                        if (this.f3112i == -1) {
                            this.f3112i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        this.f3114j = obtainStyledAttributes.getResourceId(index, this.f3114j);
                        if (this.f3114j == -1) {
                            this.f3114j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        this.f3116k = obtainStyledAttributes.getResourceId(index, this.f3116k);
                        if (this.f3116k == -1) {
                            this.f3116k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        this.f3118l = obtainStyledAttributes.getResourceId(index, this.f3118l);
                        if (this.f3118l == -1) {
                            this.f3118l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        this.f3123p = obtainStyledAttributes.getResourceId(index, this.f3123p);
                        if (this.f3123p == -1) {
                            this.f3123p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        this.f3124q = obtainStyledAttributes.getResourceId(index, this.f3124q);
                        if (this.f3124q == -1) {
                            this.f3124q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        this.f3125r = obtainStyledAttributes.getResourceId(index, this.f3125r);
                        if (this.f3125r == -1) {
                            this.f3125r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        this.f3126s = obtainStyledAttributes.getResourceId(index, this.f3126s);
                        if (this.f3126s == -1) {
                            this.f3126s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f3127t = obtainStyledAttributes.getDimensionPixelSize(index, this.f3127t);
                        break;
                    case 22:
                        this.f3128u = obtainStyledAttributes.getDimensionPixelSize(index, this.f3128u);
                        break;
                    case 23:
                        this.f3129v = obtainStyledAttributes.getDimensionPixelSize(index, this.f3129v);
                        break;
                    case 24:
                        this.f3130w = obtainStyledAttributes.getDimensionPixelSize(index, this.f3130w);
                        break;
                    case 25:
                        this.f3131x = obtainStyledAttributes.getDimensionPixelSize(index, this.f3131x);
                        break;
                    case 26:
                        this.f3132y = obtainStyledAttributes.getDimensionPixelSize(index, this.f3132y);
                        break;
                    case 27:
                        this.f3088S = obtainStyledAttributes.getBoolean(index, this.f3088S);
                        break;
                    case 28:
                        this.f3089T = obtainStyledAttributes.getBoolean(index, this.f3089T);
                        break;
                    case 29:
                        this.f3133z = obtainStyledAttributes.getFloat(index, this.f3133z);
                        break;
                    case 30:
                        this.f3070A = obtainStyledAttributes.getFloat(index, this.f3070A);
                        break;
                    case 31:
                        this.f3077H = obtainStyledAttributes.getInt(index, 0);
                        if (this.f3077H == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        this.f3078I = obtainStyledAttributes.getInt(index, 0);
                        if (this.f3078I == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f3079J = obtainStyledAttributes.getDimensionPixelSize(index, this.f3079J);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.f3079J) == -2) {
                                this.f3079J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f3081L = obtainStyledAttributes.getDimensionPixelSize(index, this.f3081L);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.f3081L) == -2) {
                                this.f3081L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f3083N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f3083N));
                        break;
                    case 36:
                        try {
                            this.f3080K = obtainStyledAttributes.getDimensionPixelSize(index, this.f3080K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.f3080K) == -2) {
                                this.f3080K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f3082M = obtainStyledAttributes.getDimensionPixelSize(index, this.f3082M);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.f3082M) == -2) {
                                this.f3082M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f3084O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f3084O));
                        break;
                    case 44:
                        this.f3071B = obtainStyledAttributes.getString(index);
                        this.f3072C = -1;
                        String str = this.f3071B;
                        if (str != null) {
                            int length = str.length();
                            int indexOf = this.f3071B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i = 0;
                            } else {
                                String substring = this.f3071B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.f3072C = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.f3072C = 1;
                                }
                                i = indexOf + 1;
                            }
                            int indexOf2 = this.f3071B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.f3071B.substring(i, indexOf2);
                                String substring3 = this.f3071B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.f3072C == 1) {
                                                Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            } else {
                                                Math.abs(parseFloat / parseFloat2);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.f3071B.substring(i);
                                if (substring4.length() > 0) {
                                    Float.parseFloat(substring4);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 45:
                        this.f3073D = obtainStyledAttributes.getFloat(index, this.f3073D);
                        break;
                    case 46:
                        this.f3074E = obtainStyledAttributes.getFloat(index, this.f3074E);
                        break;
                    case 47:
                        this.f3075F = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.f3076G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.f3085P = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3085P);
                        break;
                    case 50:
                        this.f3086Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3086Q);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            m7922a();
        }

        /* renamed from: a */
        public void m7922a() {
            this.f3093X = false;
            this.f3090U = true;
            this.f3091V = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.f3088S) {
                this.f3090U = false;
                this.f3077H = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.f3089T) {
                this.f3091V = false;
                this.f3078I = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).width == 0 || ((ViewGroup.MarginLayoutParams) this).width == -1) {
                this.f3090U = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.f3077H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f3088S = true;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == 0 || ((ViewGroup.MarginLayoutParams) this).height == -1) {
                this.f3091V = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.f3078I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f3089T = true;
                }
            }
            if (this.f3100c == -1.0f && this.f3096a == -1 && this.f3098b == -1) {
                return;
            }
            this.f3093X = true;
            this.f3090U = true;
            this.f3091V = true;
            if (!(this.f3117k0 instanceof p000a.p006b.p008b.p009h.p010j.Guideline)) {
                this.f3117k0 = new p000a.p006b.p008b.p009h.p010j.Guideline();
            }
            ((p000a.p006b.p008b.p009h.p010j.Guideline) this.f3117k0).m11013w(this.f3087R);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.C0520a.resolveLayoutDirection(int):void");
        }

        public C0520a(int i, int i2) {
            super(i, i2);
            this.f3096a = -1;
            this.f3098b = -1;
            this.f3100c = -1.0f;
            this.f3102d = -1;
            this.f3104e = -1;
            this.f3106f = -1;
            this.f3108g = -1;
            this.f3110h = -1;
            this.f3112i = -1;
            this.f3114j = -1;
            this.f3116k = -1;
            this.f3118l = -1;
            this.f3120m = -1;
            this.f3121n = 0;
            this.f3122o = 0.0f;
            this.f3123p = -1;
            this.f3124q = -1;
            this.f3125r = -1;
            this.f3126s = -1;
            this.f3127t = -1;
            this.f3128u = -1;
            this.f3129v = -1;
            this.f3130w = -1;
            this.f3131x = -1;
            this.f3132y = -1;
            this.f3133z = 0.5f;
            this.f3070A = 0.5f;
            this.f3071B = null;
            this.f3072C = 1;
            this.f3073D = -1.0f;
            this.f3074E = -1.0f;
            this.f3075F = 0;
            this.f3076G = 0;
            this.f3077H = 0;
            this.f3078I = 0;
            this.f3079J = 0;
            this.f3080K = 0;
            this.f3081L = 0;
            this.f3082M = 0;
            this.f3083N = 1.0f;
            this.f3084O = 1.0f;
            this.f3085P = -1;
            this.f3086Q = -1;
            this.f3087R = -1;
            this.f3088S = false;
            this.f3089T = false;
            this.f3090U = true;
            this.f3091V = true;
            this.f3092W = false;
            this.f3093X = false;
            this.f3094Y = false;
            this.f3095Z = false;
            this.f3097a0 = -1;
            this.f3099b0 = -1;
            this.f3101c0 = -1;
            this.f3103d0 = -1;
            this.f3105e0 = -1;
            this.f3107f0 = -1;
            this.f3109g0 = 0.5f;
            this.f3117k0 = new ConstraintWidget();
            this.f3119l0 = false;
        }

        public C0520a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3096a = -1;
            this.f3098b = -1;
            this.f3100c = -1.0f;
            this.f3102d = -1;
            this.f3104e = -1;
            this.f3106f = -1;
            this.f3108g = -1;
            this.f3110h = -1;
            this.f3112i = -1;
            this.f3114j = -1;
            this.f3116k = -1;
            this.f3118l = -1;
            this.f3120m = -1;
            this.f3121n = 0;
            this.f3122o = 0.0f;
            this.f3123p = -1;
            this.f3124q = -1;
            this.f3125r = -1;
            this.f3126s = -1;
            this.f3127t = -1;
            this.f3128u = -1;
            this.f3129v = -1;
            this.f3130w = -1;
            this.f3131x = -1;
            this.f3132y = -1;
            this.f3133z = 0.5f;
            this.f3070A = 0.5f;
            this.f3071B = null;
            this.f3072C = 1;
            this.f3073D = -1.0f;
            this.f3074E = -1.0f;
            this.f3075F = 0;
            this.f3076G = 0;
            this.f3077H = 0;
            this.f3078I = 0;
            this.f3079J = 0;
            this.f3080K = 0;
            this.f3081L = 0;
            this.f3082M = 0;
            this.f3083N = 1.0f;
            this.f3084O = 1.0f;
            this.f3085P = -1;
            this.f3086Q = -1;
            this.f3087R = -1;
            this.f3088S = false;
            this.f3089T = false;
            this.f3090U = true;
            this.f3091V = true;
            this.f3092W = false;
            this.f3093X = false;
            this.f3094Y = false;
            this.f3095Z = false;
            this.f3097a0 = -1;
            this.f3099b0 = -1;
            this.f3101c0 = -1;
            this.f3103d0 = -1;
            this.f3105e0 = -1;
            this.f3107f0 = -1;
            this.f3109g0 = 0.5f;
            this.f3117k0 = new ConstraintWidget();
            this.f3119l0 = false;
        }
    }

    /* renamed from: a */
    public final ConstraintWidget m7934a(int i) {
        if (i == 0) {
            return this.f3057d;
        }
        View view = this.f3054a.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f3057d;
        }
        if (view == null) {
            return null;
        }
        return ((C0520a) view.getLayoutParams()).f3117k0;
    }

    /* renamed from: a */
    public final ConstraintWidget m7929a(View view) {
        if (view == this) {
            return this.f3057d;
        }
        if (view == null) {
            return null;
        }
        return ((C0520a) view.getLayoutParams()).f3117k0;
    }

    /* renamed from: a */
    public final void m7933a(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0520a c0520a = (C0520a) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = c0520a.f3117k0;
                if (!c0520a.f3093X && !c0520a.f3094Y) {
                    constraintWidget.m11066o(childAt.getVisibility());
                    int i4 = ((ViewGroup.MarginLayoutParams) c0520a).width;
                    int i5 = ((ViewGroup.MarginLayoutParams) c0520a).height;
                    boolean z3 = c0520a.f3090U;
                    if (z3 || c0520a.f3091V || (!z3 && c0520a.f3077H == 1) || ((ViewGroup.MarginLayoutParams) c0520a).width == -1 || (!c0520a.f3091V && (c0520a.f3078I == 1 || ((ViewGroup.MarginLayoutParams) c0520a).height == -1))) {
                        if (i4 == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -2);
                            z = true;
                        } else if (i4 == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -1);
                            z = false;
                        } else {
                            z = i4 == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, i4);
                        }
                        if (i5 == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
                            z2 = true;
                        } else if (i5 == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = i5 == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        Metrics metrics = this.f3069q;
                        if (metrics != null) {
                            metrics.f190a++;
                        }
                        constraintWidget.m11096b(i4 == -2);
                        constraintWidget.m11104a(i5 == -2);
                        i4 = childAt.getMeasuredWidth();
                        i5 = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    constraintWidget.m11064p(i4);
                    constraintWidget.m11080h(i5);
                    if (z) {
                        constraintWidget.m11060r(i4);
                    }
                    if (z2) {
                        constraintWidget.m11062q(i5);
                    }
                    if (c0520a.f3092W && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.m11082g(baseline);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m7928a(String str) {
        this.f3057d.mo10979L();
        Metrics metrics = this.f3069q;
        if (metrics != null) {
            metrics.f192c++;
        }
    }
}
