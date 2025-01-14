package a.b.h.f;

import a.b.h.k.x0;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class k extends x0 {

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f1445e;

    /* renamed from: f  reason: collision with root package name */
    public final a.b.g.k.b f1446f;

    /* renamed from: g  reason: collision with root package name */
    public final a.b.g.k.b f1447g;

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f1446f = super.b();
        this.f1447g = new a();
        this.f1445e = recyclerView;
    }

    @Override // a.b.h.k.x0
    public a.b.g.k.b b() {
        return this.f1447g;
    }

    /* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public class a extends a.b.g.k.b {
        public a() {
        }

        @Override // a.b.g.k.b
        public void a(View view, a.b.g.k.e0.c cVar) {
            Preference g2;
            k.this.f1446f.a(view, cVar);
            int e2 = k.this.f1445e.e(view);
            RecyclerView.g adapter = k.this.f1445e.getAdapter();
            if ((adapter instanceof h) && (g2 = ((h) adapter).g(e2)) != null) {
                g2.a(cVar);
            }
        }

        @Override // a.b.g.k.b
        public boolean a(View view, int i2, Bundle bundle) {
            return k.this.f1446f.a(view, i2, bundle);
        }
    }
}
