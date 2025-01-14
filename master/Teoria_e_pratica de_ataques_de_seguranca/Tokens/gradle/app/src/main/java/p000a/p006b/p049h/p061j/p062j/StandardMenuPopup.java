package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0357d;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p063k.MenuPopupWindow;

/* renamed from: a.b.h.j.j.u */
/* loaded from: classes.dex */
public final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {

    /* renamed from: w */
    public static final int f2468w = C0360g.abc_popup_menu_item_layout;

    /* renamed from: b */
    public final Context f2469b;

    /* renamed from: c */
    public final MenuBuilder f2470c;

    /* renamed from: d */
    public final MenuAdapter f2471d;

    /* renamed from: e */
    public final boolean f2472e;

    /* renamed from: f */
    public final int f2473f;

    /* renamed from: g */
    public final int f2474g;

    /* renamed from: h */
    public final int f2475h;

    /* renamed from: i */
    public final MenuPopupWindow f2476i;

    /* renamed from: m */
    public PopupWindow.OnDismissListener f2479m;

    /* renamed from: n */
    public View f2480n;

    /* renamed from: o */
    public View f2481o;

    /* renamed from: p */
    public MenuPresenter.InterfaceC0434a f2482p;

    /* renamed from: q */
    public ViewTreeObserver f2483q;

    /* renamed from: r */
    public boolean f2484r;

    /* renamed from: s */
    public boolean f2485s;

    /* renamed from: t */
    public int f2486t;

    /* renamed from: v */
    public boolean f2488v;

    /* renamed from: j */
    public final ViewTreeObserver.OnGlobalLayoutListener f2477j = new ViewTreeObserver$OnGlobalLayoutListenerC0436a();

    /* renamed from: k */
    public final View.OnAttachStateChangeListener f2478k = new View$OnAttachStateChangeListenerC0437b();

    /* renamed from: u */
    public int f2487u = 0;

    /* compiled from: StandardMenuPopup.java */
    /* renamed from: a.b.h.j.j.u$a */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0436a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0436a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.mo8079f() || StandardMenuPopup.this.f2476i.m8069l()) {
                return;
            }
            View view = StandardMenuPopup.this.f2481o;
            if (view != null && view.isShown()) {
                StandardMenuPopup.this.f2476i.mo7998d();
            } else {
                StandardMenuPopup.this.dismiss();
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    /* renamed from: a.b.h.j.j.u$b */
    /* loaded from: classes.dex */
    public class View$OnAttachStateChangeListenerC0437b implements View.OnAttachStateChangeListener {
        public View$OnAttachStateChangeListenerC0437b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.f2483q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.f2483q = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.f2483q.removeGlobalOnLayoutListener(standardMenuPopup.f2477j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f2469b = context;
        this.f2470c = menuBuilder;
        this.f2472e = z;
        this.f2471d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.f2472e, f2468w);
        this.f2474g = i;
        this.f2475h = i2;
        Resources resources = context.getResources();
        this.f2473f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0357d.abc_config_prefDialogWidth));
        this.f2480n = view;
        this.f2476i = new MenuPopupWindow(this.f2469b, null, this.f2474g, this.f2475h);
        menuBuilder.m8691a(this, context);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8589a(int i) {
        this.f2487u = i;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8588a(MenuBuilder menuBuilder) {
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6279a(Parcelable parcelable) {
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: b */
    public void mo8583b(boolean z) {
        this.f2471d.m8702a(z);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6277b() {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: c */
    public Parcelable mo6275c() {
        return null;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: c */
    public void mo8582c(int i) {
        this.f2476i.m8074h(i);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: d */
    public void mo7998d() {
        if (!m8580i()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    public void dismiss() {
        if (mo8079f()) {
            this.f2476i.dismiss();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: e */
    public ListView mo8081e() {
        return this.f2476i.mo8081e();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: f */
    public boolean mo8079f() {
        return !this.f2484r && this.f2476i.mo8079f();
    }

    /* renamed from: i */
    public final boolean m8580i() {
        View view;
        if (mo8079f()) {
            return true;
        }
        if (this.f2484r || (view = this.f2480n) == null) {
            return false;
        }
        this.f2481o = view;
        this.f2476i.m8090a((PopupWindow.OnDismissListener) this);
        this.f2476i.m8091a((AdapterView.OnItemClickListener) this);
        this.f2476i.m8089a(true);
        View view2 = this.f2481o;
        boolean z = this.f2483q == null;
        this.f2483q = view2.getViewTreeObserver();
        if (z) {
            this.f2483q.addOnGlobalLayoutListener(this.f2477j);
        }
        view2.addOnAttachStateChangeListener(this.f2478k);
        this.f2476i.m8093a(view2);
        this.f2476i.m8084c(this.f2487u);
        if (!this.f2485s) {
            this.f2486t = MenuPopup.m8609a(this.f2471d, null, this.f2469b, this.f2473f);
            this.f2485s = true;
        }
        this.f2476i.m8087b(this.f2486t);
        this.f2476i.m8080e(2);
        this.f2476i.m8095a(m8606h());
        this.f2476i.mo7998d();
        ListView mo8081e = this.f2476i.mo8081e();
        mo8081e.setOnKeyListener(this);
        if (this.f2488v && this.f2470c.m8657h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f2469b).inflate(C0360g.abc_popup_menu_header_item_layout, (ViewGroup) mo8081e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f2470c.m8657h());
            }
            frameLayout.setEnabled(false);
            mo8081e.addHeaderView(frameLayout, null, false);
        }
        this.f2476i.mo8001a((ListAdapter) this.f2471d);
        this.f2476i.mo7998d();
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f2484r = true;
        this.f2470c.close();
        ViewTreeObserver viewTreeObserver = this.f2483q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2483q = this.f2481o.getViewTreeObserver();
            }
            this.f2483q.removeGlobalOnLayoutListener(this.f2477j);
            this.f2483q = null;
        }
        this.f2481o.removeOnAttachStateChangeListener(this.f2478k);
        PopupWindow.OnDismissListener onDismissListener = this.f2479m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6278a(boolean z) {
        this.f2485s = false;
        MenuAdapter menuAdapter = this.f2471d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: b */
    public void mo8584b(int i) {
        this.f2476i.m8082d(i);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: c */
    public void mo8581c(boolean z) {
        this.f2488v = z;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo8587a(MenuPresenter.InterfaceC0434a interfaceC0434a) {
        this.f2482p = interfaceC0434a;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f2469b, subMenuBuilder, this.f2481o, this.f2472e, this.f2474g, this.f2475h);
            menuPopupHelper.m8601a(this.f2482p);
            menuPopupHelper.m8598a(MenuPopup.m8608b(subMenuBuilder));
            menuPopupHelper.m8599a(this.f2479m);
            this.f2479m = null;
            this.f2470c.m8680a(false);
            int m8075h = this.f2476i.m8075h();
            int m8073i = this.f2476i.m8073i();
            if ((Gravity.getAbsoluteGravity(this.f2487u, ViewCompat.m9422k(this.f2480n)) & 7) == 5) {
                m8075h += this.f2480n.getWidth();
            }
            if (menuPopupHelper.m8603a(m8075h, m8073i)) {
                MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2482p;
                if (interfaceC0434a != null) {
                    interfaceC0434a.mo7080a(subMenuBuilder);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6282a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f2470c) {
            return;
        }
        dismiss();
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2482p;
        if (interfaceC0434a != null) {
            interfaceC0434a.mo7079a(menuBuilder, z);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8586a(View view) {
        this.f2480n = view;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPopup
    /* renamed from: a */
    public void mo8585a(PopupWindow.OnDismissListener onDismissListener) {
        this.f2479m = onDismissListener;
    }
}
