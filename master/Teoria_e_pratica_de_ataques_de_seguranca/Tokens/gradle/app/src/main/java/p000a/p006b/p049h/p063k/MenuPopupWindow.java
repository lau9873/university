package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p067v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p000a.p006b.p049h.p061j.p062j.MenuAdapter;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;

/* renamed from: a.b.h.k.u0 */
/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {

    /* renamed from: K */
    public static Method f2962K;

    /* renamed from: J */
    public MenuItemHoverListener f2963J;

    /* compiled from: MenuPopupWindow.java */
    /* renamed from: a.b.h.k.u0$a */
    /* loaded from: classes.dex */
    public static class C0505a extends DropDownListView {

        /* renamed from: p */
        public final int f2964p;

        /* renamed from: q */
        public final int f2965q;

        /* renamed from: r */
        public MenuItemHoverListener f2966r;

        /* renamed from: s */
        public MenuItem f2967s;

        public C0505a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f2964p = 21;
                this.f2965q = 22;
                return;
            }
            this.f2964p = 22;
            this.f2965q = 21;
        }

        @Override // p000a.p006b.p049h.p063k.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            MenuAdapter menuAdapter;
            int pointToPosition;
            int i2;
            if (this.f2966r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                MenuItemImpl menuItemImpl = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < menuAdapter.getCount()) {
                    menuItemImpl = menuAdapter.getItem(i2);
                }
                MenuItem menuItem = this.f2967s;
                if (menuItem != menuItemImpl) {
                    MenuBuilder m8701b = menuAdapter.m8701b();
                    if (menuItem != null) {
                        this.f2966r.mo8044a(m8701b, menuItem);
                    }
                    this.f2967s = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.f2966r.mo8040b(m8701b, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f2964p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.f2965q) {
                setSelection(-1);
                ((MenuAdapter) getAdapter()).m8701b().m8680a(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.f2966r = menuItemHoverListener;
        }

        @Override // p000a.p006b.p049h.p063k.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            f2962K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // p000a.p006b.p049h.p063k.ListPopupWindow
    /* renamed from: a */
    public DropDownListView mo8042a(Context context, boolean z) {
        C0505a c0505a = new C0505a(context, z);
        c0505a.setHoverListener(this);
        return c0505a;
    }

    /* renamed from: b */
    public void m8039b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f2919F.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: d */
    public void m8038d(boolean z) {
        Method method = f2962K;
        if (method != null) {
            try {
                method.invoke(this.f2919F, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: a */
    public void m8041a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f2919F.setEnterTransition((Transition) obj);
        }
    }

    @Override // p000a.p006b.p049h.p063k.MenuItemHoverListener
    /* renamed from: b */
    public void mo8040b(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.f2963J;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.mo8040b(menuBuilder, menuItem);
        }
    }

    /* renamed from: a */
    public void m8043a(MenuItemHoverListener menuItemHoverListener) {
        this.f2963J = menuItemHoverListener;
    }

    @Override // p000a.p006b.p049h.p063k.MenuItemHoverListener
    /* renamed from: a */
    public void mo8044a(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.f2963J;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.mo8044a(menuBuilder, menuItem);
        }
    }
}
