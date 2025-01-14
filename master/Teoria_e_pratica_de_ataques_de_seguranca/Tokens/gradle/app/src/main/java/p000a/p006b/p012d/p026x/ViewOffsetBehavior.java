package p000a.p006b.p012d.p026x;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: a.b.d.x.q */
/* loaded from: classes.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.AbstractC0575c<V> {

    /* renamed from: a */
    public ViewOffsetHelper f741a;

    /* renamed from: b */
    public int f742b;

    /* renamed from: c */
    public int f743c;

    public ViewOffsetBehavior() {
        this.f742b = 0;
        this.f743c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7643a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo10656b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.f741a == null) {
            this.f741a = new ViewOffsetHelper(v);
        }
        this.f741a.m10653b();
        int i2 = this.f742b;
        if (i2 != 0) {
            this.f741a.m10652b(i2);
            this.f742b = 0;
        }
        int i3 = this.f743c;
        if (i3 != 0) {
            this.f741a.m10654a(i3);
            this.f743c = 0;
            return true;
        }
        return true;
    }

    /* renamed from: b */
    public void mo10656b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m7719d(v, i);
    }

    /* renamed from: b */
    public int m10657b() {
        ViewOffsetHelper viewOffsetHelper = this.f741a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.m10655a();
        }
        return 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f742b = 0;
        this.f743c = 0;
    }

    /* renamed from: a */
    public boolean m10658a(int i) {
        ViewOffsetHelper viewOffsetHelper = this.f741a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.m10652b(i);
        }
        this.f742b = i;
        return false;
    }
}
