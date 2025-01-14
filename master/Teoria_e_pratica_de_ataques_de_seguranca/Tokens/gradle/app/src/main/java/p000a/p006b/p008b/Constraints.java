package p000a.p006b.p008b;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: a.b.b.d */
/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a */
    public ConstraintSet f136a;

    public ConstraintSet getConstraintSet() {
        if (this.f136a == null) {
            this.f136a = new ConstraintSet();
        }
        this.f136a.m11252a(this);
        return this.f136a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public C0021a generateDefaultLayoutParams() {
        return new C0021a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public C0021a generateLayoutParams(AttributeSet attributeSet) {
        return new C0021a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.C0520a(layoutParams);
    }

    /* compiled from: Constraints.java */
    /* renamed from: a.b.b.d$a */
    /* loaded from: classes.dex */
    public static class C0021a extends ConstraintLayout.C0520a {

        /* renamed from: m0 */
        public float f137m0;

        /* renamed from: n0 */
        public boolean f138n0;

        /* renamed from: o0 */
        public float f139o0;

        /* renamed from: p0 */
        public float f140p0;

        /* renamed from: q0 */
        public float f141q0;

        /* renamed from: r0 */
        public float f142r0;

        /* renamed from: s0 */
        public float f143s0;

        /* renamed from: t0 */
        public float f144t0;

        /* renamed from: u0 */
        public float f145u0;

        /* renamed from: v0 */
        public float f146v0;

        /* renamed from: w0 */
        public float f147w0;

        /* renamed from: x0 */
        public float f148x0;

        /* renamed from: y0 */
        public float f149y0;

        public C0021a(int i, int i2) {
            super(i, i2);
            this.f137m0 = 1.0f;
            this.f138n0 = false;
            this.f139o0 = 0.0f;
            this.f140p0 = 0.0f;
            this.f141q0 = 0.0f;
            this.f142r0 = 0.0f;
            this.f143s0 = 1.0f;
            this.f144t0 = 1.0f;
            this.f145u0 = 0.0f;
            this.f146v0 = 0.0f;
            this.f147w0 = 0.0f;
            this.f148x0 = 0.0f;
            this.f149y0 = 0.0f;
        }

        public C0021a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f137m0 = 1.0f;
            this.f138n0 = false;
            this.f139o0 = 0.0f;
            this.f140p0 = 0.0f;
            this.f141q0 = 0.0f;
            this.f142r0 = 0.0f;
            this.f143s0 = 1.0f;
            this.f144t0 = 1.0f;
            this.f145u0 = 0.0f;
            this.f146v0 = 0.0f;
            this.f147w0 = 0.0f;
            this.f148x0 = 0.0f;
            this.f149y0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0023g.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0023g.ConstraintSet_android_alpha) {
                    this.f137m0 = obtainStyledAttributes.getFloat(index, this.f137m0);
                } else if (index == C0023g.ConstraintSet_android_elevation) {
                    this.f139o0 = obtainStyledAttributes.getFloat(index, this.f139o0);
                    this.f138n0 = true;
                } else if (index == C0023g.ConstraintSet_android_rotationX) {
                    this.f141q0 = obtainStyledAttributes.getFloat(index, this.f141q0);
                } else if (index == C0023g.ConstraintSet_android_rotationY) {
                    this.f142r0 = obtainStyledAttributes.getFloat(index, this.f142r0);
                } else if (index == C0023g.ConstraintSet_android_rotation) {
                    this.f140p0 = obtainStyledAttributes.getFloat(index, this.f140p0);
                } else if (index == C0023g.ConstraintSet_android_scaleX) {
                    this.f143s0 = obtainStyledAttributes.getFloat(index, this.f143s0);
                } else if (index == C0023g.ConstraintSet_android_scaleY) {
                    this.f144t0 = obtainStyledAttributes.getFloat(index, this.f144t0);
                } else if (index == C0023g.ConstraintSet_android_transformPivotX) {
                    this.f145u0 = obtainStyledAttributes.getFloat(index, this.f145u0);
                } else if (index == C0023g.ConstraintSet_android_transformPivotY) {
                    this.f146v0 = obtainStyledAttributes.getFloat(index, this.f146v0);
                } else if (index == C0023g.ConstraintSet_android_translationX) {
                    this.f147w0 = obtainStyledAttributes.getFloat(index, this.f147w0);
                } else if (index == C0023g.ConstraintSet_android_translationY) {
                    this.f148x0 = obtainStyledAttributes.getFloat(index, this.f148x0);
                } else if (index == C0023g.ConstraintSet_android_translationZ) {
                    this.f147w0 = obtainStyledAttributes.getFloat(index, this.f149y0);
                }
            }
        }
    }
}
