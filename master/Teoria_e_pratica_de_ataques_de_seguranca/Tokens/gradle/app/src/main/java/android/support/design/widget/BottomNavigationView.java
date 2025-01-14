package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0041c;
import p000a.p006b.p012d.C0042d;
import p000a.p006b.p012d.C0048j;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p019q.BottomNavigationMenu;
import p000a.p006b.p012d.p019q.BottomNavigationMenuView;
import p000a.p006b.p012d.p019q.BottomNavigationPresenter;
import p000a.p006b.p012d.p019q.ThemeEnforcement;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p061j.SupportMenuInflater;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: a */
    public final MenuBuilder f3259a;

    /* renamed from: b */
    public final BottomNavigationMenuView f3260b;

    /* renamed from: c */
    public final BottomNavigationPresenter f3261c;

    /* renamed from: d */
    public MenuInflater f3262d;

    /* renamed from: e */
    public InterfaceC0564c f3263e;

    /* renamed from: f */
    public InterfaceC0563b f3264f;

    /* renamed from: android.support.design.widget.BottomNavigationView$a */
    /* loaded from: classes.dex */
    public class C0562a implements MenuBuilder.InterfaceC0425a {
        public C0562a() {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public void mo7078a(MenuBuilder menuBuilder) {
        }

        @Override // p000a.p006b.p049h.p061j.p062j.MenuBuilder.InterfaceC0425a
        /* renamed from: a */
        public boolean mo7077a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (BottomNavigationView.this.f3264f == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.f3263e == null || BottomNavigationView.this.f3263e.mo735a(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f3264f.m7773a(menuItem);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0563b {
        /* renamed from: a */
        void m7773a(MenuItem menuItem);
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0564c {
        /* renamed from: a */
        boolean mo735a(MenuItem menuItem);
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$d */
    /* loaded from: classes.dex */
    public static class C0565d extends AbsSavedState {
        public static final Parcelable.Creator<C0565d> CREATOR = new C0566a();

        /* renamed from: c */
        public Bundle f3266c;

        /* renamed from: android.support.design.widget.BottomNavigationView$d$a */
        /* loaded from: classes.dex */
        public static class C0566a implements Parcelable.ClassLoaderCreator<C0565d> {
            @Override // android.os.Parcelable.Creator
            public C0565d[] newArray(int i) {
                return new C0565d[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0565d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0565d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0565d createFromParcel(Parcel parcel) {
                return new C0565d(parcel, null);
            }
        }

        public C0565d(Parcelable parcelable) {
            super(parcelable);
        }

        /* renamed from: a */
        public final void m7772a(Parcel parcel, ClassLoader classLoader) {
            this.f3266c = parcel.readBundle(classLoader);
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f3266c);
        }

        public C0565d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m7772a(parcel, classLoader);
        }
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f3262d == null) {
            this.f3262d = new SupportMenuInflater(getContext());
        }
        return this.f3262d;
    }

    public Drawable getItemBackground() {
        return this.f3260b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f3260b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f3260b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f3260b.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.f3260b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f3260b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f3260b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f3260b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f3259a;
    }

    public int getSelectedItemId() {
        return this.f3260b.getSelectedItemId();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0565d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0565d c0565d = (C0565d) parcelable;
        super.onRestoreInstanceState(c0565d.m9588a());
        this.f3259a.m8667d(c0565d.f3266c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0565d c0565d = new C0565d(super.onSaveInstanceState());
        c0565d.f3266c = new Bundle();
        this.f3259a.m8659f(c0565d.f3266c);
        return c0565d;
    }

    public void setItemBackground(Drawable drawable) {
        this.f3260b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.f3260b.setItemBackgroundRes(i);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f3260b.m10876b() != z) {
            this.f3260b.setItemHorizontalTranslationEnabled(z);
            this.f3261c.mo6278a(false);
        }
    }

    public void setItemIconSize(int i) {
        this.f3260b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f3260b.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.f3260b.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f3260b.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f3260b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f3260b.getLabelVisibilityMode() != i) {
            this.f3260b.setLabelVisibilityMode(i);
            this.f3261c.mo6278a(false);
        }
    }

    public void setOnNavigationItemReselectedListener(InterfaceC0563b interfaceC0563b) {
        this.f3264f = interfaceC0563b;
    }

    public void setOnNavigationItemSelectedListener(InterfaceC0564c interfaceC0564c) {
        this.f3263e = interfaceC0564c;
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.f3259a.findItem(i);
        if (findItem == null || this.f3259a.m8685a(findItem, this.f3261c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0040b.bottomNavigationStyle);
    }

    /* renamed from: a */
    public void m7777a(int i) {
        this.f3261c.m10870b(true);
        getMenuInflater().inflate(i, this.f3259a);
        this.f3261c.m10870b(false);
        this.f3261c.mo6278a(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3261c = new BottomNavigationPresenter();
        this.f3259a = new BottomNavigationMenu(context);
        this.f3260b = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f3260b.setLayoutParams(layoutParams);
        this.f3261c.m10871a(this.f3260b);
        this.f3261c.m10872a(1);
        this.f3260b.setPresenter(this.f3261c);
        this.f3259a.m8692a(this.f3261c);
        this.f3261c.mo6280a(getContext(), this.f3259a);
        TintTypedArray m10860d = ThemeEnforcement.m10860d(context, attributeSet, C0049k.BottomNavigationView, i, C0048j.Widget_Design_BottomNavigationView, C0049k.BottomNavigationView_itemTextAppearanceInactive, C0049k.BottomNavigationView_itemTextAppearanceActive);
        if (m10860d.m8245g(C0049k.BottomNavigationView_itemIconTint)) {
            this.f3260b.setIconTintList(m10860d.m8264a(C0049k.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.f3260b;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.m10879a(16842808));
        }
        setItemIconSize(m10860d.m8252c(C0049k.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(C0042d.design_bottom_navigation_icon_size)));
        if (m10860d.m8245g(C0049k.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(m10860d.m8244g(C0049k.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (m10860d.m8245g(C0049k.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(m10860d.m8244g(C0049k.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (m10860d.m8245g(C0049k.BottomNavigationView_itemTextColor)) {
            setItemTextColor(m10860d.m8264a(C0049k.BottomNavigationView_itemTextColor));
        }
        if (m10860d.m8245g(C0049k.BottomNavigationView_elevation)) {
            ViewCompat.m9458a(this, m10860d.m8252c(C0049k.BottomNavigationView_elevation, 0));
        }
        setLabelVisibilityMode(m10860d.m8248e(C0049k.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(m10860d.m8260a(C0049k.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        this.f3260b.setItemBackgroundRes(m10860d.m8244g(C0049k.BottomNavigationView_itemBackground, 0));
        if (m10860d.m8245g(C0049k.BottomNavigationView_menu)) {
            m7777a(m10860d.m8244g(C0049k.BottomNavigationView_menu, 0));
        }
        m10860d.m8265a();
        addView(this.f3260b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            m7776a(context);
        }
        this.f3259a.mo8579a(new C0562a());
    }

    /* renamed from: a */
    public final void m7776a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.m10022a(context, C0041c.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C0042d.design_bottom_navigation_shadow_height)));
        addView(view);
    }
}
