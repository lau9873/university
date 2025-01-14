package a.b.d.p;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewParent;
/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final View f258a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f259b = false;

    /* renamed from: c  reason: collision with root package name */
    public int f260c = 0;

    public c(b bVar) {
        this.f258a = (View) bVar;
    }

    public void a(Bundle bundle) {
        this.f259b = bundle.getBoolean("expanded", false);
        this.f260c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f259b) {
            a();
        }
    }

    public int b() {
        return this.f260c;
    }

    public boolean c() {
        return this.f259b;
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f259b);
        bundle.putInt("expandedComponentIdHint", this.f260c);
        return bundle;
    }

    public void a(int i2) {
        this.f260c = i2;
    }

    public final void a() {
        ViewParent parent = this.f258a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).a(this.f258a);
        }
    }
}
