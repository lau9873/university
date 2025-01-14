package android.support.p067v7.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: android.support.v7.view.menu.ExpandedMenuView */
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.InterfaceC0426b, MenuView, AdapterView.OnItemClickListener {

    /* renamed from: c */
    public static final int[] f3933c = {16842964, 16843049};

    /* renamed from: a */
    public MenuBuilder f3934a;

    /* renamed from: b */
    public int f3935b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView
    /* renamed from: a */
    public void mo7096a(MenuBuilder menuBuilder) {
        this.f3934a = menuBuilder;
    }

    public int getWindowAnimations() {
        return this.f3935b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo7095a((MenuItemImpl) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, f3933c, i, 0);
        if (m8257a.m8245g(0)) {
            setBackgroundDrawable(m8257a.m8256b(0));
        }
        if (m8257a.m8245g(1)) {
            setDivider(m8257a.m8256b(1));
        }
        m8257a.m8265a();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0426b
    /* renamed from: a */
    public boolean mo7095a(MenuItemImpl menuItemImpl) {
        return this.f3934a.m8686a(menuItemImpl, 0);
    }
}
