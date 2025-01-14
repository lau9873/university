package android.support.design.widget;

import a.b.d.j;
import a.b.d.k;
import a.b.g.k.u;
import a.b.h.j.g;
import a.b.h.j.j.h;
import a.b.h.k.l1;
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
/* loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final h f2149a;

    /* renamed from: b  reason: collision with root package name */
    public final a.b.d.q.c f2150b;

    /* renamed from: c  reason: collision with root package name */
    public final a.b.d.q.d f2151c;

    /* renamed from: d  reason: collision with root package name */
    public MenuInflater f2152d;

    /* renamed from: e  reason: collision with root package name */
    public c f2153e;

    /* renamed from: f  reason: collision with root package name */
    public b f2154f;

    /* loaded from: classes.dex */
    public class a implements h.a {
        public a() {
        }

        @Override // a.b.h.j.j.h.a
        public void a(h hVar) {
        }

        @Override // a.b.h.j.j.h.a
        public boolean a(h hVar, MenuItem menuItem) {
            if (BottomNavigationView.this.f2154f == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.f2153e == null || BottomNavigationView.this.f2153e.a(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f2154f.a(menuItem);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class d extends a.b.g.k.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public Bundle f2156c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<d> {
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i2) {
                return new d[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public final void a(Parcel parcel, ClassLoader classLoader) {
            this.f2156c = parcel.readBundle(classLoader);
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f2156c);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f2152d == null) {
            this.f2152d = new g(getContext());
        }
        return this.f2152d;
    }

    public Drawable getItemBackground() {
        return this.f2150b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f2150b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f2150b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f2150b.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.f2150b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f2150b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f2150b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f2150b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f2149a;
    }

    public int getSelectedItemId() {
        return this.f2150b.getSelectedItemId();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        this.f2149a.d(dVar.f2156c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f2156c = new Bundle();
        this.f2149a.f(dVar.f2156c);
        return dVar;
    }

    public void setItemBackground(Drawable drawable) {
        this.f2150b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        this.f2150b.setItemBackgroundRes(i2);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f2150b.b() != z) {
            this.f2150b.setItemHorizontalTranslationEnabled(z);
            this.f2151c.a(false);
        }
    }

    public void setItemIconSize(int i2) {
        this.f2150b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f2150b.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f2150b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f2150b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f2150b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f2150b.getLabelVisibilityMode() != i2) {
            this.f2150b.setLabelVisibilityMode(i2);
            this.f2151c.a(false);
        }
    }

    public void setOnNavigationItemReselectedListener(b bVar) {
        this.f2154f = bVar;
    }

    public void setOnNavigationItemSelectedListener(c cVar) {
        this.f2153e = cVar;
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.f2149a.findItem(i2);
        if (findItem == null || this.f2149a.a(findItem, this.f2151c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.d.b.bottomNavigationStyle);
    }

    public void a(int i2) {
        this.f2151c.b(true);
        getMenuInflater().inflate(i2, this.f2149a);
        this.f2151c.b(false);
        this.f2151c.a(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2151c = new a.b.d.q.d();
        this.f2149a = new a.b.d.q.b(context);
        this.f2150b = new a.b.d.q.c(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f2150b.setLayoutParams(layoutParams);
        this.f2151c.a(this.f2150b);
        this.f2151c.a(1);
        this.f2150b.setPresenter(this.f2151c);
        this.f2149a.a(this.f2151c);
        this.f2151c.a(getContext(), this.f2149a);
        l1 d2 = a.b.d.q.g.d(context, attributeSet, k.BottomNavigationView, i2, j.Widget_Design_BottomNavigationView, k.BottomNavigationView_itemTextAppearanceInactive, k.BottomNavigationView_itemTextAppearanceActive);
        if (d2.g(k.BottomNavigationView_itemIconTint)) {
            this.f2150b.setIconTintList(d2.a(k.BottomNavigationView_itemIconTint));
        } else {
            a.b.d.q.c cVar = this.f2150b;
            cVar.setIconTintList(cVar.a(16842808));
        }
        setItemIconSize(d2.c(k.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(a.b.d.d.design_bottom_navigation_icon_size)));
        if (d2.g(k.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(d2.g(k.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (d2.g(k.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(d2.g(k.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (d2.g(k.BottomNavigationView_itemTextColor)) {
            setItemTextColor(d2.a(k.BottomNavigationView_itemTextColor));
        }
        if (d2.g(k.BottomNavigationView_elevation)) {
            u.a(this, d2.c(k.BottomNavigationView_elevation, 0));
        }
        setLabelVisibilityMode(d2.e(k.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(d2.a(k.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        this.f2150b.setItemBackgroundRes(d2.g(k.BottomNavigationView_itemBackground, 0));
        if (d2.g(k.BottomNavigationView_menu)) {
            a(d2.g(k.BottomNavigationView_menu, 0));
        }
        d2.a();
        addView(this.f2150b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            a(context);
        }
        this.f2149a.a(new a());
    }

    public final void a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(a.b.g.b.b.a(context, a.b.d.c.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(a.b.d.d.design_bottom_navigation_shadow_height)));
        addView(view);
    }
}
