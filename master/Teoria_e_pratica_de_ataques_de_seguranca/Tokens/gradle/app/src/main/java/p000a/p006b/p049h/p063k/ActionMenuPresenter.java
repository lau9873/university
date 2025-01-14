package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.view.menu.ActionMenuItemView;
import android.support.p067v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ActionProvider;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p061j.ActionBarPolicy;
import p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuPopupHelper;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p061j.p062j.ShowableListMenu;
import p000a.p006b.p049h.p061j.p062j.SubMenuBuilder;

/* renamed from: a.b.h.k.c */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.InterfaceC0279a {

    /* renamed from: A */
    public C0441a f2543A;

    /* renamed from: B */
    public RunnableC0443c f2544B;

    /* renamed from: C */
    public C0442b f2545C;

    /* renamed from: D */
    public final C0447f f2546D;

    /* renamed from: E */
    public int f2547E;

    /* renamed from: j */
    public C0444d f2548j;

    /* renamed from: k */
    public Drawable f2549k;

    /* renamed from: m */
    public boolean f2550m;

    /* renamed from: n */
    public boolean f2551n;

    /* renamed from: o */
    public boolean f2552o;

    /* renamed from: p */
    public int f2553p;

    /* renamed from: q */
    public int f2554q;

    /* renamed from: r */
    public int f2555r;

    /* renamed from: s */
    public boolean f2556s;

    /* renamed from: t */
    public boolean f2557t;

    /* renamed from: u */
    public boolean f2558u;

    /* renamed from: v */
    public boolean f2559v;

    /* renamed from: w */
    public int f2560w;

    /* renamed from: x */
    public final SparseBooleanArray f2561x;

    /* renamed from: y */
    public View f2562y;

    /* renamed from: z */
    public C0446e f2563z;

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$a */
    /* loaded from: classes.dex */
    public class C0441a extends MenuPopupHelper {
        public C0441a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0354a.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).m8629h()) {
                View view2 = ActionMenuPresenter.this.f2548j;
                m8600a(view2 == null ? (View) ActionMenuPresenter.this.f2323h : view2);
            }
            m8601a(ActionMenuPresenter.this.f2546D);
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPopupHelper
        /* renamed from: e */
        public void mo8484e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f2543A = null;
            actionMenuPresenter.f2547E = 0;
            super.mo8484e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$b */
    /* loaded from: classes.dex */
    public class C0442b extends ActionMenuItemView.AbstractC0679b {
        public C0442b() {
        }

        @Override // android.support.p067v7.view.menu.ActionMenuItemView.AbstractC0679b
        /* renamed from: a */
        public ShowableListMenu mo7139a() {
            C0441a c0441a = ActionMenuPresenter.this.f2543A;
            if (c0441a != null) {
                return c0441a.m8596c();
            }
            return null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$c */
    /* loaded from: classes.dex */
    public class RunnableC0443c implements Runnable {

        /* renamed from: a */
        public C0446e f2566a;

        public RunnableC0443c(C0446e c0446e) {
            this.f2566a = c0446e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f2318c != null) {
                ActionMenuPresenter.this.f2318c.m8700a();
            }
            View view = (View) ActionMenuPresenter.this.f2323h;
            if (view != null && view.getWindowToken() != null && this.f2566a.m8593g()) {
                ActionMenuPresenter.this.f2563z = this.f2566a;
            }
            ActionMenuPresenter.this.f2544B = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$d */
    /* loaded from: classes.dex */
    public class C0444d extends AppCompatImageView implements ActionMenuView.InterfaceC0686a {

        /* compiled from: ActionMenuPresenter.java */
        /* renamed from: a.b.h.k.c$d$a */
        /* loaded from: classes.dex */
        public class C0445a extends ForwardingListener {
            public C0445a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            @Override // p000a.p006b.p049h.p063k.ForwardingListener
            /* renamed from: b */
            public ShowableListMenu mo7141b() {
                C0446e c0446e = ActionMenuPresenter.this.f2563z;
                if (c0446e == null) {
                    return null;
                }
                return c0446e.m8596c();
            }

            @Override // p000a.p006b.p049h.p063k.ForwardingListener
            /* renamed from: c */
            public boolean mo7140c() {
                ActionMenuPresenter.this.m8485k();
                return true;
            }

            @Override // p000a.p006b.p049h.p063k.ForwardingListener
            /* renamed from: d */
            public boolean mo8164d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f2544B != null) {
                    return false;
                }
                actionMenuPresenter.m8489g();
                return true;
            }
        }

        public C0444d(Context context) {
            super(context, null, C0354a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.m8181a(this, getContentDescription());
            setOnTouchListener(new C0445a(this, ActionMenuPresenter.this));
        }

        @Override // android.support.p067v7.widget.ActionMenuView.InterfaceC0686a
        /* renamed from: b */
        public boolean mo7082b() {
            return false;
        }

        @Override // android.support.p067v7.widget.ActionMenuView.InterfaceC0686a
        /* renamed from: c */
        public boolean mo7081c() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.m8485k();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.m9862a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$e */
    /* loaded from: classes.dex */
    public class C0446e extends MenuPopupHelper {
        public C0446e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0354a.actionOverflowMenuStyle);
            m8604a(8388613);
            m8601a(ActionMenuPresenter.this.f2546D);
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPopupHelper
        /* renamed from: e */
        public void mo8484e() {
            if (ActionMenuPresenter.this.f2318c != null) {
                ActionMenuPresenter.this.f2318c.close();
            }
            ActionMenuPresenter.this.f2563z = null;
            super.mo8484e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$g */
    /* loaded from: classes.dex */
    public static class C0448g implements Parcelable {
        public static final Parcelable.Creator<C0448g> CREATOR = new C0449a();

        /* renamed from: a */
        public int f2572a;

        /* compiled from: ActionMenuPresenter.java */
        /* renamed from: a.b.h.k.c$g$a */
        /* loaded from: classes.dex */
        public static class C0449a implements Parcelable.Creator<C0448g> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0448g createFromParcel(Parcel parcel) {
                return new C0448g(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0448g[] newArray(int i) {
                return new C0448g[i];
            }
        }

        public C0448g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2572a);
        }

        public C0448g(Parcel parcel) {
            this.f2572a = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0360g.abc_action_menu_layout, C0360g.abc_action_menu_item_layout);
        this.f2561x = new SparseBooleanArray();
        this.f2546D = new C0447f();
    }

    /* renamed from: g */
    public boolean m8489g() {
        MenuView menuView;
        RunnableC0443c runnableC0443c = this.f2544B;
        if (runnableC0443c != null && (menuView = this.f2323h) != null) {
            ((View) menuView).removeCallbacks(runnableC0443c);
            this.f2544B = null;
            return true;
        }
        C0446e c0446e = this.f2563z;
        if (c0446e != null) {
            c0446e.m8597b();
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public boolean m8488h() {
        C0441a c0441a = this.f2543A;
        if (c0441a != null) {
            c0441a.m8597b();
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public boolean m8487i() {
        return this.f2544B != null || m8486j();
    }

    /* renamed from: j */
    public boolean m8486j() {
        C0446e c0446e = this.f2563z;
        return c0446e != null && c0446e.m8595d();
    }

    /* renamed from: k */
    public boolean m8485k() {
        MenuBuilder menuBuilder;
        if (!this.f2551n || m8486j() || (menuBuilder = this.f2318c) == null || this.f2323h == null || this.f2544B != null || menuBuilder.m8655j().isEmpty()) {
            return false;
        }
        this.f2544B = new RunnableC0443c(new C0446e(this.f2317b, this.f2318c, this.f2548j, true));
        ((View) this.f2323h).post(this.f2544B);
        super.mo6281a((SubMenuBuilder) null);
        return true;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter, p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6280a(Context context, MenuBuilder menuBuilder) {
        super.mo6280a(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy m8781a = ActionBarPolicy.m8781a(context);
        if (!this.f2552o) {
            this.f2551n = m8781a.m8775g();
        }
        if (!this.f2558u) {
            this.f2553p = m8781a.m8780b();
        }
        if (!this.f2556s) {
            this.f2555r = m8781a.m8779c();
        }
        int i = this.f2553p;
        if (this.f2551n) {
            if (this.f2548j == null) {
                this.f2548j = new C0444d(this.f2316a);
                if (this.f2550m) {
                    this.f2548j.setImageDrawable(this.f2549k);
                    this.f2549k = null;
                    this.f2550m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2548j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2548j.getMeasuredWidth();
        } else {
            this.f2548j = null;
        }
        this.f2554q = i;
        this.f2560w = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f2562y = null;
    }

    /* renamed from: b */
    public void m8497b(boolean z) {
        this.f2559v = z;
    }

    /* renamed from: c */
    public void m8495c(boolean z) {
        this.f2551n = z;
        this.f2552o = true;
    }

    /* renamed from: e */
    public boolean m8493e() {
        return m8489g() | m8488h();
    }

    /* renamed from: f */
    public Drawable m8491f() {
        C0444d c0444d = this.f2548j;
        if (c0444d != null) {
            return c0444d.getDrawable();
        }
        if (this.f2550m) {
            return this.f2549k;
        }
        return null;
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$f */
    /* loaded from: classes.dex */
    public class C0447f implements MenuPresenter.InterfaceC0434a {
        public C0447f() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public boolean mo7080a(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.f2547E = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.InterfaceC0434a m8722d = ActionMenuPresenter.this.m8722d();
            if (m8722d != null) {
                return m8722d.mo7080a(menuBuilder);
            }
            return false;
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
        /* renamed from: a */
        public void mo7079a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.mo8574m().m8680a(false);
            }
            MenuPresenter.InterfaceC0434a m8722d = ActionMenuPresenter.this.m8722d();
            if (m8722d != null) {
                m8722d.mo7079a(menuBuilder, z);
            }
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter
    /* renamed from: b */
    public MenuView mo8498b(ViewGroup viewGroup) {
        MenuView menuView = this.f2323h;
        MenuView mo8498b = super.mo8498b(viewGroup);
        if (menuView != mo8498b) {
            ((ActionMenuView) mo8498b).setPresenter(this);
        }
        return mo8498b;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: c */
    public Parcelable mo6275c() {
        C0448g c0448g = new C0448g();
        c0448g.f2572a = this.f2547E;
        return c0448g;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6277b() {
        ArrayList<MenuItemImpl> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f2318c;
        int i5 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.m8652n();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.f2555r;
        int i7 = actionMenuPresenter.f2554q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f2323h;
        int i8 = i6;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            MenuItemImpl menuItemImpl = arrayList.get(i11);
            if (menuItemImpl.m8626k()) {
                i9++;
            } else if (menuItemImpl.m8627j()) {
                i10++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.f2559v && menuItemImpl.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.f2551n && (z || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f2561x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f2557t) {
            int i13 = actionMenuPresenter.f2560w;
            i3 = i7 / i13;
            i2 = i13 + ((i7 % i13) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i15);
            if (menuItemImpl2.m8626k()) {
                View mo8506a = actionMenuPresenter.mo8506a(menuItemImpl2, actionMenuPresenter.f2562y, viewGroup);
                if (actionMenuPresenter.f2562y == null) {
                    actionMenuPresenter.f2562y = mo8506a;
                }
                if (actionMenuPresenter.f2557t) {
                    i3 -= ActionMenuView.m7093b(mo8506a, i2, i3, makeMeasureSpec, i5);
                } else {
                    mo8506a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = mo8506a.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.m8634d(true);
                i4 = i;
                i16 = measuredWidth;
            } else if (menuItemImpl2.m8627j()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i12 > 0 || z2) && i14 > 0 && (!actionMenuPresenter.f2557t || i3 > 0);
                boolean z4 = z3;
                if (z3) {
                    View mo8506a2 = actionMenuPresenter.mo8506a(menuItemImpl2, actionMenuPresenter.f2562y, viewGroup);
                    i4 = i;
                    if (actionMenuPresenter.f2562y == null) {
                        actionMenuPresenter.f2562y = mo8506a2;
                    }
                    if (actionMenuPresenter.f2557t) {
                        int m7093b = ActionMenuView.m7093b(mo8506a2, i2, i3, makeMeasureSpec, 0);
                        i3 -= m7093b;
                        if (m7093b == 0) {
                            z4 = false;
                        }
                    } else {
                        mo8506a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = mo8506a2.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z3 = z4 & (!actionMenuPresenter.f2557t ? i14 + i16 <= 0 : i14 < 0);
                } else {
                    i4 = i;
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i17);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.m8629h()) {
                                i12++;
                            }
                            menuItemImpl3.m8634d(false);
                        }
                    }
                }
                if (z3) {
                    i12--;
                }
                menuItemImpl2.m8634d(z3);
            } else {
                i4 = i;
                menuItemImpl2.m8634d(false);
                i15++;
                i5 = 0;
                actionMenuPresenter = this;
                i = i4;
            }
            i15++;
            i5 = 0;
            actionMenuPresenter = this;
            i = i4;
        }
        return true;
    }

    /* renamed from: a */
    public void m8504a(Configuration configuration) {
        if (!this.f2556s) {
            this.f2555r = ActionBarPolicy.m8781a(this.f2317b).m8779c();
        }
        MenuBuilder menuBuilder = this.f2318c;
        if (menuBuilder != null) {
            menuBuilder.m8670c(true);
        }
    }

    /* renamed from: a */
    public void m8503a(Drawable drawable) {
        C0444d c0444d = this.f2548j;
        if (c0444d != null) {
            c0444d.setImageDrawable(drawable);
            return;
        }
        this.f2550m = true;
        this.f2549k = drawable;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter
    /* renamed from: a */
    public View mo8506a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m8631f()) {
            actionView = super.mo8506a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter
    /* renamed from: a */
    public void mo8507a(MenuItemImpl menuItemImpl, MenuView.InterfaceC0435a interfaceC0435a) {
        interfaceC0435a.mo7137a(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) interfaceC0435a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f2323h);
        if (this.f2545C == null) {
            this.f2545C = new C0442b();
        }
        actionMenuItemView.setPopupCallback(this.f2545C);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter
    /* renamed from: a */
    public boolean mo8508a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.m8629h();
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter, p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6278a(boolean z) {
        super.mo6278a(z);
        ((View) this.f2323h).requestLayout();
        MenuBuilder menuBuilder = this.f2318c;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> m8674c = menuBuilder.m8674c();
            int size = m8674c.size();
            for (int i = 0; i < size; i++) {
                ActionProvider mo8647a = m8674c.get(i).mo8647a();
                if (mo8647a != null) {
                    mo8647a.m9581a(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f2318c;
        ArrayList<MenuItemImpl> m8655j = menuBuilder2 != null ? menuBuilder2.m8655j() : null;
        if (this.f2551n && m8655j != null) {
            int size2 = m8655j.size();
            if (size2 == 1) {
                z2 = !m8655j.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f2548j == null) {
                this.f2548j = new C0444d(this.f2316a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f2548j.getParent();
            if (viewGroup != this.f2323h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2548j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f2323h;
                actionMenuView.addView(this.f2548j, actionMenuView.m7090e());
            }
        } else {
            C0444d c0444d = this.f2548j;
            if (c0444d != null) {
                ViewParent parent = c0444d.getParent();
                MenuView menuView = this.f2323h;
                if (parent == menuView) {
                    ((ViewGroup) menuView).removeView(this.f2548j);
                }
            }
        }
        ((ActionMenuView) this.f2323h).setOverflowReserved(this.f2551n);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter
    /* renamed from: a */
    public boolean mo8500a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f2548j) {
            return false;
        }
        return super.mo8500a(viewGroup, i);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter, p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (subMenuBuilder.hasVisibleItems()) {
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            while (subMenuBuilder2.m8570t() != this.f2318c) {
                subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.m8570t();
            }
            View m8501a = m8501a(subMenuBuilder2.getItem());
            if (m8501a == null) {
                return false;
            }
            this.f2547E = subMenuBuilder.getItem().getItemId();
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            this.f2543A = new C0441a(this.f2317b, subMenuBuilder, m8501a);
            this.f2543A.m8598a(z);
            this.f2543A.m8594f();
            super.mo6281a(subMenuBuilder);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View m8501a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f2323h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.InterfaceC0435a) && ((MenuView.InterfaceC0435a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.BaseMenuPresenter, p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6282a(MenuBuilder menuBuilder, boolean z) {
        m8493e();
        super.mo6282a(menuBuilder, z);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6279a(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof C0448g) && (i = ((C0448g) parcelable).f2572a) > 0 && (findItem = this.f2318c.findItem(i)) != null) {
            mo6281a((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    /* renamed from: a */
    public void m8502a(ActionMenuView actionMenuView) {
        this.f2323h = actionMenuView;
        actionMenuView.mo7096a(this.f2318c);
    }
}
