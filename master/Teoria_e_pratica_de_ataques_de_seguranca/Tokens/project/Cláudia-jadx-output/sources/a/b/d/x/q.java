package a.b.d.x;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes.dex */
public class q<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public r f399a;

    /* renamed from: b  reason: collision with root package name */
    public int f400b;

    /* renamed from: c  reason: collision with root package name */
    public int f401c;

    public q() {
        this.f400b = 0;
        this.f401c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        b(coordinatorLayout, (CoordinatorLayout) v, i2);
        if (this.f399a == null) {
            this.f399a = new r(v);
        }
        this.f399a.b();
        int i3 = this.f400b;
        if (i3 != 0) {
            this.f399a.b(i3);
            this.f400b = 0;
        }
        int i4 = this.f401c;
        if (i4 != 0) {
            this.f399a.a(i4);
            this.f401c = 0;
            return true;
        }
        return true;
    }

    public void b(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.d(v, i2);
    }

    public int b() {
        r rVar = this.f399a;
        if (rVar != null) {
            return rVar.a();
        }
        return 0;
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f400b = 0;
        this.f401c = 0;
    }

    public boolean a(int i2) {
        r rVar = this.f399a;
        if (rVar != null) {
            return rVar.b(i2);
        }
        this.f400b = i2;
        return false;
    }
}
