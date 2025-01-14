package a.b.h.k;

import a.b.g.k.c;
import a.b.h.j.j.p;
import a.b.h.j.j.q;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
public class c extends a.b.h.j.j.b implements c.a {
    public a A;
    public RunnableC0043c B;
    public b C;
    public final f D;
    public int E;
    public d j;
    public Drawable k;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public final SparseBooleanArray x;
    public View y;
    public e z;

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class a extends a.b.h.j.j.o {
        public a(Context context, a.b.h.j.j.v vVar, View view) {
            super(context, vVar, view, false, a.b.h.b.a.actionOverflowMenuStyle);
            if (!((a.b.h.j.j.k) vVar.getItem()).h()) {
                View view2 = c.this.j;
                a(view2 == null ? (View) c.this.f1540h : view2);
            }
            a(c.this.D);
        }

        @Override // a.b.h.j.j.o
        public void e() {
            c cVar = c.this;
            cVar.A = null;
            cVar.E = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.b
        public a.b.h.j.j.t a() {
            a aVar = c.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: a.b.h.k.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0043c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public e f1671a;

        public RunnableC0043c(e eVar) {
            this.f1671a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f1535c != null) {
                c.this.f1535c.a();
            }
            View view = (View) c.this.f1540h;
            if (view != null && view.getWindowToken() != null && this.f1671a.g()) {
                c.this.z = this.f1671a;
            }
            c.this.B = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class d extends p implements ActionMenuView.a {

        /* compiled from: ActionMenuPresenter.java */
        /* loaded from: classes.dex */
        public class a extends o0 {
            public a(View view, c cVar) {
                super(view);
            }

            @Override // a.b.h.k.o0
            public a.b.h.j.j.t b() {
                e eVar = c.this.z;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // a.b.h.k.o0
            public boolean c() {
                c.this.k();
                return true;
            }

            @Override // a.b.h.k.o0
            public boolean d() {
                c cVar = c.this;
                if (cVar.B != null) {
                    return false;
                }
                cVar.g();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, a.b.h.b.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            n1.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.k();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                a.b.g.c.j.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class e extends a.b.h.j.j.o {
        public e(Context context, a.b.h.j.j.h hVar, View view, boolean z) {
            super(context, hVar, view, z, a.b.h.b.a.actionOverflowMenuStyle);
            a(8388613);
            a(c.this.D);
        }

        @Override // a.b.h.j.j.o
        public void e() {
            if (c.this.f1535c != null) {
                c.this.f1535c.close();
            }
            c.this.z = null;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f1675a;

        /* compiled from: ActionMenuPresenter.java */
        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<g> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1675a);
        }

        public g(Parcel parcel) {
            this.f1675a = parcel.readInt();
        }
    }

    public c(Context context) {
        super(context, a.b.h.b.g.abc_action_menu_layout, a.b.h.b.g.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.D = new f();
    }

    public boolean g() {
        a.b.h.j.j.q qVar;
        RunnableC0043c runnableC0043c = this.B;
        if (runnableC0043c != null && (qVar = this.f1540h) != null) {
            ((View) qVar).removeCallbacks(runnableC0043c);
            this.B = null;
            return true;
        }
        e eVar = this.z;
        if (eVar != null) {
            eVar.b();
            return true;
        }
        return false;
    }

    public boolean h() {
        a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.B != null || j();
    }

    public boolean j() {
        e eVar = this.z;
        return eVar != null && eVar.d();
    }

    public boolean k() {
        a.b.h.j.j.h hVar;
        if (!this.n || j() || (hVar = this.f1535c) == null || this.f1540h == null || this.B != null || hVar.j().isEmpty()) {
            return false;
        }
        this.B = new RunnableC0043c(new e(this.f1534b, this.f1535c, this.j, true));
        ((View) this.f1540h).post(this.B);
        super.a((a.b.h.j.j.v) null);
        return true;
    }

    @Override // a.b.h.j.j.b, a.b.h.j.j.p
    public void a(Context context, a.b.h.j.j.h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        a.b.h.j.a a2 = a.b.h.j.a.a(context);
        if (!this.o) {
            this.n = a2.g();
        }
        if (!this.u) {
            this.p = a2.b();
        }
        if (!this.s) {
            this.r = a2.c();
        }
        int i2 = this.p;
        if (this.n) {
            if (this.j == null) {
                this.j = new d(this.f1533a);
                if (this.m) {
                    this.j.setImageDrawable(this.k);
                    this.k = null;
                    this.m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.q = i2;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.y = null;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public void c(boolean z) {
        this.n = z;
        this.o = true;
    }

    public boolean e() {
        return g() | h();
    }

    public Drawable f() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.m) {
            return this.k;
        }
        return null;
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class f implements p.a {
        public f() {
        }

        @Override // a.b.h.j.j.p.a
        public boolean a(a.b.h.j.j.h hVar) {
            if (hVar == null) {
                return false;
            }
            c.this.E = ((a.b.h.j.j.v) hVar).getItem().getItemId();
            p.a d2 = c.this.d();
            if (d2 != null) {
                return d2.a(hVar);
            }
            return false;
        }

        @Override // a.b.h.j.j.p.a
        public void a(a.b.h.j.j.h hVar, boolean z) {
            if (hVar instanceof a.b.h.j.j.v) {
                hVar.m().a(false);
            }
            p.a d2 = c.this.d();
            if (d2 != null) {
                d2.a(hVar, z);
            }
        }
    }

    @Override // a.b.h.j.j.b
    public a.b.h.j.j.q b(ViewGroup viewGroup) {
        a.b.h.j.j.q qVar = this.f1540h;
        a.b.h.j.j.q b2 = super.b(viewGroup);
        if (qVar != b2) {
            ((ActionMenuView) b2).setPresenter(this);
        }
        return b2;
    }

    @Override // a.b.h.j.j.p
    public Parcelable c() {
        g gVar = new g();
        gVar.f1675a = this.E;
        return gVar;
    }

    @Override // a.b.h.j.j.p
    public boolean b() {
        ArrayList<a.b.h.j.j.k> arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        c cVar = this;
        a.b.h.j.j.h hVar = cVar.f1535c;
        int i6 = 0;
        if (hVar != null) {
            arrayList = hVar.n();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = cVar.r;
        int i8 = cVar.q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f1540h;
        int i9 = i7;
        boolean z = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12++) {
            a.b.h.j.j.k kVar = arrayList.get(i12);
            if (kVar.k()) {
                i10++;
            } else if (kVar.j()) {
                i11++;
            } else {
                z = true;
            }
            if (cVar.v && kVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (cVar.n && (z || i11 + i10 > i9)) {
            i9--;
        }
        int i13 = i9 - i10;
        SparseBooleanArray sparseBooleanArray = cVar.x;
        sparseBooleanArray.clear();
        if (cVar.t) {
            int i14 = cVar.w;
            i4 = i8 / i14;
            i3 = i14 + ((i8 % i14) / i4);
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i15 = i8;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i2) {
            a.b.h.j.j.k kVar2 = arrayList.get(i16);
            if (kVar2.k()) {
                View a2 = cVar.a(kVar2, cVar.y, viewGroup);
                if (cVar.y == null) {
                    cVar.y = a2;
                }
                if (cVar.t) {
                    i4 -= ActionMenuView.b(a2, i3, i4, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i17 != 0) {
                    measuredWidth = i17;
                }
                int groupId = kVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                kVar2.d(true);
                i5 = i2;
                i17 = measuredWidth;
            } else if (kVar2.j()) {
                int groupId2 = kVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i13 > 0 || z2) && i15 > 0 && (!cVar.t || i4 > 0);
                boolean z4 = z3;
                if (z3) {
                    View a3 = cVar.a(kVar2, cVar.y, viewGroup);
                    i5 = i2;
                    if (cVar.y == null) {
                        cVar.y = a3;
                    }
                    if (cVar.t) {
                        int b2 = ActionMenuView.b(a3, i3, i4, makeMeasureSpec, 0);
                        i4 -= b2;
                        if (b2 == 0) {
                            z4 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z3 = z4 & (!cVar.t ? i15 + i17 <= 0 : i15 < 0);
                } else {
                    i5 = i2;
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i18 = 0; i18 < i16; i18++) {
                        a.b.h.j.j.k kVar3 = arrayList.get(i18);
                        if (kVar3.getGroupId() == groupId2) {
                            if (kVar3.h()) {
                                i13++;
                            }
                            kVar3.d(false);
                        }
                    }
                }
                if (z3) {
                    i13--;
                }
                kVar2.d(z3);
            } else {
                i5 = i2;
                kVar2.d(false);
                i16++;
                i6 = 0;
                cVar = this;
                i2 = i5;
            }
            i16++;
            i6 = 0;
            cVar = this;
            i2 = i5;
        }
        return true;
    }

    public void a(Configuration configuration) {
        if (!this.s) {
            this.r = a.b.h.j.a.a(this.f1534b).c();
        }
        a.b.h.j.j.h hVar = this.f1535c;
        if (hVar != null) {
            hVar.c(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.m = true;
        this.k = drawable;
    }

    @Override // a.b.h.j.j.b
    public View a(a.b.h.j.j.k kVar, View view, ViewGroup viewGroup) {
        View actionView = kVar.getActionView();
        if (actionView == null || kVar.f()) {
            actionView = super.a(kVar, view, viewGroup);
        }
        actionView.setVisibility(kVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // a.b.h.j.j.b
    public void a(a.b.h.j.j.k kVar, q.a aVar) {
        aVar.a(kVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1540h);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    @Override // a.b.h.j.j.b
    public boolean a(int i2, a.b.h.j.j.k kVar) {
        return kVar.h();
    }

    @Override // a.b.h.j.j.b, a.b.h.j.j.p
    public void a(boolean z) {
        super.a(z);
        ((View) this.f1540h).requestLayout();
        a.b.h.j.j.h hVar = this.f1535c;
        boolean z2 = false;
        if (hVar != null) {
            ArrayList<a.b.h.j.j.k> c2 = hVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b.g.k.c a2 = c2.get(i2).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        a.b.h.j.j.h hVar2 = this.f1535c;
        ArrayList<a.b.h.j.j.k> j = hVar2 != null ? hVar2.j() : null;
        if (this.n && j != null) {
            int size2 = j.size();
            if (size2 == 1) {
                z2 = !j.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.j == null) {
                this.j = new d(this.f1533a);
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != this.f1540h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1540h;
                actionMenuView.addView(this.j, actionMenuView.e());
            }
        } else {
            d dVar = this.j;
            if (dVar != null) {
                ViewParent parent = dVar.getParent();
                a.b.h.j.j.q qVar = this.f1540h;
                if (parent == qVar) {
                    ((ViewGroup) qVar).removeView(this.j);
                }
            }
        }
        ((ActionMenuView) this.f1540h).setOverflowReserved(this.n);
    }

    @Override // a.b.h.j.j.b
    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.j) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    @Override // a.b.h.j.j.b, a.b.h.j.j.p
    public boolean a(a.b.h.j.j.v vVar) {
        boolean z = false;
        if (vVar.hasVisibleItems()) {
            a.b.h.j.j.v vVar2 = vVar;
            while (vVar2.t() != this.f1535c) {
                vVar2 = (a.b.h.j.j.v) vVar2.t();
            }
            View a2 = a(vVar2.getItem());
            if (a2 == null) {
                return false;
            }
            this.E = vVar.getItem().getItemId();
            int size = vVar.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item = vVar.getItem(i2);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.A = new a(this.f1534b, vVar, a2);
            this.A.a(z);
            this.A.f();
            super.a(vVar);
            return true;
        }
        return false;
    }

    public final View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1540h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof q.a) && ((q.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // a.b.h.j.j.b, a.b.h.j.j.p
    public void a(a.b.h.j.j.h hVar, boolean z) {
        e();
        super.a(hVar, z);
    }

    @Override // a.b.h.j.j.p
    public void a(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof g) && (i2 = ((g) parcelable).f1675a) > 0 && (findItem = this.f1535c.findItem(i2)) != null) {
            a((a.b.h.j.j.v) findItem.getSubMenu());
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f1540h = actionMenuView;
        actionMenuView.a(this.f1535c);
    }
}
