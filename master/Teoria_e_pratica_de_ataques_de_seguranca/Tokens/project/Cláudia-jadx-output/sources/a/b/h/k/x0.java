package a.b.h.k;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class x0 extends a.b.g.k.b {

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f1993c;

    /* renamed from: d  reason: collision with root package name */
    public final a.b.g.k.b f1994d = new a(this);

    public x0(RecyclerView recyclerView) {
        this.f1993c = recyclerView;
    }

    @Override // a.b.g.k.b
    public boolean a(View view, int i2, Bundle bundle) {
        if (super.a(view, i2, bundle)) {
            return true;
        }
        if (c() || this.f1993c.getLayoutManager() == null) {
            return false;
        }
        return this.f1993c.getLayoutManager().a(i2, bundle);
    }

    @Override // a.b.g.k.b
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }

    public boolean c() {
        return this.f1993c.p();
    }

    @Override // a.b.g.k.b
    public void a(View view, a.b.g.k.e0.c cVar) {
        super.a(view, cVar);
        cVar.a((CharSequence) RecyclerView.class.getName());
        if (c() || this.f1993c.getLayoutManager() == null) {
            return;
        }
        this.f1993c.getLayoutManager().a(cVar);
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public static class a extends a.b.g.k.b {

        /* renamed from: c  reason: collision with root package name */
        public final x0 f1995c;

        public a(x0 x0Var) {
            this.f1995c = x0Var;
        }

        @Override // a.b.g.k.b
        public void a(View view, a.b.g.k.e0.c cVar) {
            super.a(view, cVar);
            if (this.f1995c.c() || this.f1995c.f1993c.getLayoutManager() == null) {
                return;
            }
            this.f1995c.f1993c.getLayoutManager().a(view, cVar);
        }

        @Override // a.b.g.k.b
        public boolean a(View view, int i2, Bundle bundle) {
            if (super.a(view, i2, bundle)) {
                return true;
            }
            if (this.f1995c.c() || this.f1995c.f1993c.getLayoutManager() == null) {
                return false;
            }
            return this.f1995c.f1993c.getLayoutManager().a(view, i2, bundle);
        }
    }

    public a.b.g.k.b b() {
        return this.f1994d;
    }
}
