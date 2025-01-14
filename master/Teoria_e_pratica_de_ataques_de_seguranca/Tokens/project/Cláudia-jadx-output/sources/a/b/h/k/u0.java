package a.b.h.k;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
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
/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class u0 extends s0 implements t0 {
    public static Method K;
    public t0 J;

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class a extends l0 {
        public final int p;
        public final int q;
        public t0 r;
        public MenuItem s;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.p = 21;
                this.q = 22;
                return;
            }
            this.p = 22;
            this.q = 21;
        }

        @Override // a.b.h.k.l0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            a.b.h.j.j.g gVar;
            int pointToPosition;
            int i3;
            if (this.r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    gVar = (a.b.h.j.j.g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    gVar = (a.b.h.j.j.g) adapter;
                }
                a.b.h.j.j.k kVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < gVar.getCount()) {
                    kVar = gVar.getItem(i3);
                }
                MenuItem menuItem = this.s;
                if (menuItem != kVar) {
                    a.b.h.j.j.h b2 = gVar.b();
                    if (menuItem != null) {
                        this.r.a(b2, menuItem);
                    }
                    this.s = kVar;
                    if (kVar != null) {
                        this.r.b(b2, kVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i2 == this.q) {
                setSelection(-1);
                ((a.b.h.j.j.g) getAdapter()).b().a(false);
                return true;
            } else {
                return super.onKeyDown(i2, keyEvent);
            }
        }

        public void setHoverListener(t0 t0Var) {
            this.r = t0Var;
        }

        @Override // a.b.h.k.l0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public u0(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // a.b.h.k.s0
    public l0 a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.F.setExitTransition((Transition) obj);
        }
    }

    public void d(boolean z) {
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.F.setEnterTransition((Transition) obj);
        }
    }

    @Override // a.b.h.k.t0
    public void b(a.b.h.j.j.h hVar, MenuItem menuItem) {
        t0 t0Var = this.J;
        if (t0Var != null) {
            t0Var.b(hVar, menuItem);
        }
    }

    public void a(t0 t0Var) {
        this.J = t0Var;
    }

    @Override // a.b.h.k.t0
    public void a(a.b.h.j.j.h hVar, MenuItem menuItem) {
        t0 t0Var = this.J;
        if (t0Var != null) {
            t0Var.a(hVar, menuItem);
        }
    }
}
