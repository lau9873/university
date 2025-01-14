package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0357d;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p063k.MenuItemHoverListener;
import p000a.p006b.p049h.p063k.MenuPopupWindow;

/* renamed from: a.b.h.j.j.e */
/* loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: C */
    public static final int f2329C = C0360g.abc_cascading_menu_item_layout;

    /* renamed from: A */
    public PopupWindow.OnDismissListener f2330A;

    /* renamed from: B */
    public boolean f2331B;

    /* renamed from: b */
    public final Context f2332b;

    /* renamed from: c */
    public final int f2333c;

    /* renamed from: d */
    public final int f2334d;

    /* renamed from: e */
    public final int f2335e;

    /* renamed from: f */
    public final boolean f2336f;

    /* renamed from: g */
    public final Handler f2337g;

    /* renamed from: p */
    public View f2345p;

    /* renamed from: q */
    public View f2346q;

    /* renamed from: s */
    public boolean f2348s;

    /* renamed from: t */
    public boolean f2349t;

    /* renamed from: u */
    public int f2350u;

    /* renamed from: v */
    public int f2351v;

    /* renamed from: x */
    public boolean f2353x;

    /* renamed from: y */
    public MenuPresenter.InterfaceC0434a f2354y;

    /* renamed from: z */
    public ViewTreeObserver f2355z;

    /* renamed from: h */
    public final List<MenuBuilder> f2338h = new ArrayList();

    /* renamed from: i */
    public final List<C0423d> f2339i = new ArrayList();

    /* renamed from: j */
    public final ViewTreeObserver.OnGlobalLayoutListener f2340j = new ViewTreeObserver$OnGlobalLayoutListenerC0419a();

    /* renamed from: k */
    public final View.OnAttachStateChangeListener f2341k = new View$OnAttachStateChangeListenerC0420b();

    /* renamed from: m */
    public final MenuItemHoverListener f2342m = new C0421c();

    /* renamed from: n */
    public int f2343n = 0;

    /* renamed from: o */
    public int f2344o = 0;

    /* renamed from: w */
    public boolean f2352w = false;

    /* renamed from: r */
    public int f2347r = m8710j();

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: a.b.h.j.j.e$a */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0419a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0419a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.mo8079f() || CascadingMenuPopup.this.f2339i.size() <= 0 || CascadingMenuPopup.this.f2339i.get(0).f2363a.m8069l()) {
                return;
            }
            View view = CascadingMenuPopup.this.f2346q;
            if (view != null && view.isShown()) {
                for (C0423d c0423d : CascadingMenuPopup.this.f2339i) {
                    c0423d.f2363a.mo7998d();
                }
                return;
            }
            CascadingMenuPopup.this.dismiss();
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: a.b.h.j.j.e$b */
    /* loaded from: classes.dex */
    public class View$OnAttachStateChangeListenerC0420b implements View.OnAttachStateChangeListener {
        public View$OnAttachStateChangeListenerC0420b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f2355z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f2355z = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f2355z.removeGlobalOnLayoutListener(cascadingMenuPopup.f2340j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: a.b.h.j.j.e$c */
    /* loaded from: classes.dex */
    public class C0421c implements MenuItemHoverListener {

        /* compiled from: CascadingMenuPopup.java */
        /* renamed from: a.b.h.j.j.e$c$a */
        /* loaded from: classes.dex */
        public class RunnableC0422a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ C0423d f2359a;

            /* renamed from: b */
            public final /* synthetic */ MenuItem f2360b;

            /* renamed from: c */
            public final /* synthetic */ MenuBuilder f2361c;

            public RunnableC0422a(C0423d c0423d, MenuItem menuItem, MenuBuilder menuBuilder) {
                this.f2359a = c0423d;
                this.f2360b = menuItem;
                this.f2361c = menuBuilder;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0423d c0423d = this.f2359a;
                if (c0423d != null) {
                    CascadingMenuPopup.this.f2331B = true;
                    c0423d.f2364b.m8680a(false);
                    CascadingMenuPopup.this.f2331B = false;
                }
                if (this.f2360b.isEnabled() && this.f2360b.hasSubMenu()) {
                    this.f2361c.m8686a(this.f2360b, 4);
                }
            }
        }

        public C0421c() {
        }

        @Override // p000a.p006b.p049h.p063k.MenuItemHoverListener
        /* renamed from: a */
        public void mo8044a(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f2337g.removeCallbacksAndMessages(menuBuilder);
        }

        @Override // p000a.p006b.p049h.p063k.MenuItemHoverListener
        /* renamed from: b */
        public void mo8040b(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f2337g.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f2339i.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.f2339i.get(i).f2364b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            CascadingMenuPopup.this.f2337g.postAtTime(new RunnableC0422a(i2 < CascadingMenuPopup.this.f2339i.size() ? CascadingMenuPopup.this.f2339i.get(i2) : null, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: a.b.h.j.j.e$d */
    /* loaded from: classes.dex */
    public static class C0423d {

        /* renamed from: a */
        public final MenuPopupWindow f2363a;

        /* renamed from: b */
        public final MenuBuilder f2364b;

        /* renamed from: c */
        public final int f2365c;

        public C0423d(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f2363a = menuPopupWindow;
            this.f2364b = menuBuilder;
            this.f2365c = i;
        }

        /* renamed from: a */
        public ListView m8709a() {
            return this.f2363a.mo8081e();
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.f2332b = context;
        this.f2345p = view;
        this.f2334d = i;
        this.f2335e = i2;
        this.f2336f = z;
        Resources resources = context.getResources();
        this.f2333c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0357d.abc_config_prefDialogWidth));
        this.f2337g = new Handler();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8588a(MenuBuilder menuBuilder) {
        menuBuilder.m8691a(this, this.f2332b);
        if (mo8079f()) {
            m8712d(menuBuilder);
        } else {
            this.f2338h.add(menuBuilder);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6279a(Parcelable parcelable) {
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: b */
    public void mo8583b(boolean z) {
        this.f2352w = z;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6277b() {
        return false;
    }

    /* renamed from: c */
    public final int m8714c(MenuBuilder menuBuilder) {
        int size = this.f2339i.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.f2339i.get(i).f2364b) {
                return i;
            }
        }
        return -1;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: c */
    public Parcelable mo6275c() {
        return null;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: d */
    public void mo7998d() {
        if (mo8079f()) {
            return;
        }
        for (MenuBuilder menuBuilder : this.f2338h) {
            m8712d(menuBuilder);
        }
        this.f2338h.clear();
        this.f2346q = this.f2345p;
        if (this.f2346q != null) {
            boolean z = this.f2355z == null;
            this.f2355z = this.f2346q.getViewTreeObserver();
            if (z) {
                this.f2355z.addOnGlobalLayoutListener(this.f2340j);
            }
            this.f2346q.addOnAttachStateChangeListener(this.f2341k);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    public void dismiss() {
        int size = this.f2339i.size();
        if (size > 0) {
            C0423d[] c0423dArr = (C0423d[]) this.f2339i.toArray(new C0423d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0423d c0423d = c0423dArr[i];
                if (c0423d.f2363a.mo8079f()) {
                    c0423d.f2363a.dismiss();
                }
            }
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: e */
    public ListView mo8081e() {
        if (this.f2339i.isEmpty()) {
            return null;
        }
        List<C0423d> list = this.f2339i;
        return list.get(list.size() - 1).m8709a();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: f */
    public boolean mo8079f() {
        return this.f2339i.size() > 0 && this.f2339i.get(0).f2363a.mo8079f();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: g */
    public boolean mo8607g() {
        return false;
    }

    /* renamed from: i */
    public final MenuPopupWindow m8711i() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f2332b, null, this.f2334d, this.f2335e);
        menuPopupWindow.m8043a(this.f2342m);
        menuPopupWindow.m8091a((AdapterView.OnItemClickListener) this);
        menuPopupWindow.m8090a((PopupWindow.OnDismissListener) this);
        menuPopupWindow.m8093a(this.f2345p);
        menuPopupWindow.m8084c(this.f2344o);
        menuPopupWindow.m8089a(true);
        menuPopupWindow.m8080e(2);
        return menuPopupWindow;
    }

    /* renamed from: j */
    public final int m8710j() {
        return ViewCompat.m9422k(this.f2345p) == 1 ? 0 : 1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0423d c0423d;
        int size = this.f2339i.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0423d = null;
                break;
            }
            c0423d = this.f2339i.get(i);
            if (!c0423d.f2363a.mo8079f()) {
                break;
            }
            i++;
        }
        if (c0423d != null) {
            c0423d.f2364b.m8680a(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: b */
    public void mo8584b(int i) {
        this.f2348s = true;
        this.f2350u = i;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: c */
    public void mo8582c(int i) {
        this.f2349t = true;
        this.f2351v = i;
    }

    /* renamed from: a */
    public final MenuItem m8715a(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: c */
    public void mo8581c(boolean z) {
        this.f2353x = z;
    }

    /* renamed from: a */
    public final View m8716a(C0423d c0423d, MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int i;
        int firstVisiblePosition;
        MenuItem m8715a = m8715a(c0423d.f2364b, menuBuilder);
        if (m8715a == null) {
            return null;
        }
        ListView m8709a = c0423d.m8709a();
        ListAdapter adapter = m8709a.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (m8715a == menuAdapter.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - m8709a.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < m8709a.getChildCount()) {
            return m8709a.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* renamed from: d */
    public final int m8713d(int i) {
        List<C0423d> list = this.f2339i;
        ListView m8709a = list.get(list.size() - 1).m8709a();
        int[] iArr = new int[2];
        m8709a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f2346q.getWindowVisibleDisplayFrame(rect);
        return this.f2347r == 1 ? (iArr[0] + m8709a.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    /* renamed from: d */
    public final void m8712d(MenuBuilder menuBuilder) {
        C0423d c0423d;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f2332b);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f2336f, f2329C);
        if (!mo8079f() && this.f2352w) {
            menuAdapter.m8702a(true);
        } else if (mo8079f()) {
            menuAdapter.m8702a(MenuPopup.m8608b(menuBuilder));
        }
        int m8609a = MenuPopup.m8609a(menuAdapter, null, this.f2332b, this.f2333c);
        MenuPopupWindow m8711i = m8711i();
        m8711i.mo8001a((ListAdapter) menuAdapter);
        m8711i.m8087b(m8609a);
        m8711i.m8084c(this.f2344o);
        if (this.f2339i.size() > 0) {
            List<C0423d> list = this.f2339i;
            c0423d = list.get(list.size() - 1);
            view = m8716a(c0423d, menuBuilder);
        } else {
            c0423d = null;
            view = null;
        }
        if (view != null) {
            m8711i.m8038d(false);
            m8711i.m8041a((Object) null);
            int m8713d = m8713d(m8609a);
            boolean z = m8713d == 1;
            this.f2347r = m8713d;
            if (Build.VERSION.SDK_INT >= 26) {
                m8711i.m8093a(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f2345p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f2344o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f2345p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f2344o & 5) == 5) {
                if (!z) {
                    m8609a = view.getWidth();
                    i3 = i - m8609a;
                }
                i3 = i + m8609a;
            } else {
                if (z) {
                    m8609a = view.getWidth();
                    i3 = i + m8609a;
                }
                i3 = i - m8609a;
            }
            m8711i.m8082d(i3);
            m8711i.m8086b(true);
            m8711i.m8074h(i2);
        } else {
            if (this.f2348s) {
                m8711i.m8082d(this.f2350u);
            }
            if (this.f2349t) {
                m8711i.m8074h(this.f2351v);
            }
            m8711i.m8095a(m8606h());
        }
        this.f2339i.add(new C0423d(m8711i, menuBuilder, this.f2347r));
        m8711i.mo7998d();
        ListView mo8081e = m8711i.mo8081e();
        mo8081e.setOnKeyListener(this);
        if (c0423d == null && this.f2353x && menuBuilder.m8657h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0360g.abc_popup_menu_header_item_layout, (ViewGroup) mo8081e, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.m8657h());
            mo8081e.addHeaderView(frameLayout, null, false);
            m8711i.mo7998d();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6278a(boolean z) {
        for (C0423d c0423d : this.f2339i) {
            MenuPopup.m8610a(c0423d.m8709a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo8587a(MenuPresenter.InterfaceC0434a interfaceC0434a) {
        this.f2354y = interfaceC0434a;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
        for (C0423d c0423d : this.f2339i) {
            if (subMenuBuilder == c0423d.f2364b) {
                c0423d.m8709a().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            mo8588a((MenuBuilder) subMenuBuilder);
            MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2354y;
            if (interfaceC0434a != null) {
                interfaceC0434a.mo7080a(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6282a(MenuBuilder menuBuilder, boolean z) {
        int m8714c = m8714c(menuBuilder);
        if (m8714c < 0) {
            return;
        }
        int i = m8714c + 1;
        if (i < this.f2339i.size()) {
            this.f2339i.get(i).f2364b.m8680a(false);
        }
        C0423d remove = this.f2339i.remove(m8714c);
        remove.f2364b.m8677b(this);
        if (this.f2331B) {
            remove.f2363a.m8039b((Object) null);
            remove.f2363a.m8096a(0);
        }
        remove.f2363a.dismiss();
        int size = this.f2339i.size();
        if (size > 0) {
            this.f2347r = this.f2339i.get(size - 1).f2365c;
        } else {
            this.f2347r = m8710j();
        }
        if (size != 0) {
            if (z) {
                this.f2339i.get(0).f2364b.m8680a(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2354y;
        if (interfaceC0434a != null) {
            interfaceC0434a.mo7079a(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.f2355z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f2355z.removeGlobalOnLayoutListener(this.f2340j);
            }
            this.f2355z = null;
        }
        this.f2346q.removeOnAttachStateChangeListener(this.f2341k);
        this.f2330A.onDismiss();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8589a(int i) {
        if (this.f2343n != i) {
            this.f2343n = i;
            this.f2344o = GravityCompat.m9579a(i, ViewCompat.m9422k(this.f2345p));
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8586a(View view) {
        if (this.f2345p != view) {
            this.f2345p = view;
            this.f2344o = GravityCompat.m9579a(this.f2343n, ViewCompat.m9422k(this.f2345p));
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8585a(PopupWindow.OnDismissListener onDismissListener) {
        this.f2330A = onDismissListener;
    }
}
