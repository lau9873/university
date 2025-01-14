package android.support.v7.view.menu;

import a.b.h.j.j.h;
import a.b.h.j.j.k;
import a.b.h.j.j.q;
import a.b.h.k.l1;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements h.b, q, AdapterView.OnItemClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f2460c = {16842964, 16843049};

    /* renamed from: a  reason: collision with root package name */
    public h f2461a;

    /* renamed from: b  reason: collision with root package name */
    public int f2462b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // a.b.h.j.j.q
    public void a(h hVar) {
        this.f2461a = hVar;
    }

    public int getWindowAnimations() {
        return this.f2462b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        a((k) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        l1 a2 = l1.a(context, attributeSet, f2460c, i2, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.b(0));
        }
        if (a2.g(1)) {
            setDivider(a2.b(1));
        }
        a2.a();
    }

    @Override // a.b.h.j.j.h.b
    public boolean a(k kVar) {
        return this.f2461a.a(kVar, 0);
    }
}
