package p000a.p006b.p049h.p055e.p056a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import p000a.p006b.p049h.p055e.p056a.DrawableContainer;

/* renamed from: a.b.h.e.a.d */
/* loaded from: classes.dex */
public class StateListDrawable extends DrawableContainer {

    /* renamed from: n */
    public C0380a f2112n;

    /* renamed from: o */
    public boolean f2113o;

    /* compiled from: StateListDrawable.java */
    /* renamed from: a.b.h.e.a.d$a */
    /* loaded from: classes.dex */
    public static class C0380a extends DrawableContainer.AbstractC0379c {

        /* renamed from: J */
        public int[][] f2114J;

        public C0380a(C0380a c0380a, StateListDrawable stateListDrawable, Resources resources) {
            super(c0380a, stateListDrawable, resources);
            if (c0380a != null) {
                this.f2114J = c0380a.f2114J;
            } else {
                this.f2114J = new int[m8920d()];
            }
        }

        /* renamed from: a */
        public int m8903a(int[] iArr, Drawable drawable) {
            int m8929a = m8929a(drawable);
            this.f2114J[m8929a] = iArr;
            return m8929a;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer.AbstractC0379c
        /* renamed from: n */
        public void mo8902n() {
            int[][] iArr = this.f2114J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f2114J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f2114J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }

        /* renamed from: a */
        public int m8904a(int[] iArr) {
            int[][] iArr2 = this.f2114J;
            int m8919e = m8919e();
            for (int i = 0; i < m8919e; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer.AbstractC0379c
        /* renamed from: a */
        public void mo8905a(int i, int i2) {
            super.mo8905a(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.f2114J, 0, iArr, 0, i);
            this.f2114J = iArr;
        }
    }

    public StateListDrawable(C0380a c0380a, Resources resources) {
        mo8907a(new C0380a(c0380a, this, resources));
        onStateChange(getState());
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2113o) {
            super.mutate();
            if (this == this) {
                this.f2112n.mo8902n();
                this.f2113o = true;
            }
        }
        return this;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int m8904a = this.f2112n.m8904a(iArr);
        if (m8904a < 0) {
            m8904a = this.f2112n.m8904a(StateSet.WILD_CARD);
        }
        return m8942a(m8904a) || onStateChange;
    }

    /* renamed from: a */
    public int[] m8906a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public StateListDrawable(C0380a c0380a) {
        if (c0380a != null) {
            mo8907a(c0380a);
        }
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer
    /* renamed from: a */
    public C0380a mo8908a() {
        return new C0380a(this.f2112n, this, null);
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer
    /* renamed from: a */
    public void mo8907a(DrawableContainer.AbstractC0379c abstractC0379c) {
        super.mo8907a(abstractC0379c);
        if (abstractC0379c instanceof C0380a) {
            this.f2112n = (C0380a) abstractC0379c;
        }
    }
}
