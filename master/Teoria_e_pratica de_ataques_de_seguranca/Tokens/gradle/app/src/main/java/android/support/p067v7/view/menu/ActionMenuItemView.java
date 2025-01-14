package android.support.p067v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p067v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuView;
import p000a.p006b.p049h.p061j.p062j.ShowableListMenu;
import p000a.p006b.p049h.p063k.AppCompatTextView;
import p000a.p006b.p049h.p063k.ForwardingListener;
import p000a.p006b.p049h.p063k.TooltipCompat;

/* renamed from: android.support.v7.view.menu.ActionMenuItemView */
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.InterfaceC0435a, View.OnClickListener, ActionMenuView.InterfaceC0686a {

    /* renamed from: d */
    public MenuItemImpl f3921d;

    /* renamed from: e */
    public CharSequence f3922e;

    /* renamed from: f */
    public Drawable f3923f;

    /* renamed from: g */
    public MenuBuilder.InterfaceC0426b f3924g;

    /* renamed from: h */
    public ForwardingListener f3925h;

    /* renamed from: i */
    public AbstractC0679b f3926i;

    /* renamed from: j */
    public boolean f3927j;

    /* renamed from: k */
    public boolean f3928k;

    /* renamed from: m */
    public int f3929m;

    /* renamed from: n */
    public int f3930n;

    /* renamed from: o */
    public int f3931o;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    /* loaded from: classes.dex */
    public class C0678a extends ForwardingListener {
        public C0678a() {
            super(ActionMenuItemView.this);
        }

        @Override // p000a.p006b.p049h.p063k.ForwardingListener
        /* renamed from: b */
        public ShowableListMenu mo7141b() {
            AbstractC0679b abstractC0679b = ActionMenuItemView.this.f3926i;
            if (abstractC0679b != null) {
                return abstractC0679b.mo7139a();
            }
            return null;
        }

        @Override // p000a.p006b.p049h.p063k.ForwardingListener
        /* renamed from: c */
        public boolean mo7140c() {
            ShowableListMenu mo7141b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.InterfaceC0426b interfaceC0426b = actionMenuItemView.f3924g;
            return interfaceC0426b != null && interfaceC0426b.mo7095a(actionMenuItemView.f3921d) && (mo7141b = mo7141b()) != null && mo7141b.mo8079f();
        }
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0679b {
        /* renamed from: a */
        public abstract ShowableListMenu mo7139a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public void mo7137a(MenuItemImpl menuItemImpl, int i) {
        this.f3921d = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.m8645a(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f3925h == null) {
            this.f3925h = new C0678a();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    /* renamed from: a */
    public boolean mo7138a() {
        return true;
    }

    @Override // android.support.p067v7.widget.ActionMenuView.InterfaceC0686a
    /* renamed from: b */
    public boolean mo7082b() {
        return m7144e();
    }

    @Override // android.support.p067v7.widget.ActionMenuView.InterfaceC0686a
    /* renamed from: c */
    public boolean mo7081c() {
        return m7144e() && this.f3921d.getIcon() == null;
    }

    /* renamed from: e */
    public boolean m7144e() {
        return !TextUtils.isEmpty(getText());
    }

    /* renamed from: f */
    public final boolean m7143f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* renamed from: g */
    public final void m7142g() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f3922e);
        if (this.f3923f != null && (!this.f3921d.m8623n() || (!this.f3927j && !this.f3928k))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f3922e : null);
        CharSequence contentDescription = this.f3921d.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f3921d.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f3921d.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.m8181a(this, z3 ? null : this.f3921d.getTitle());
        } else {
            TooltipCompat.m8181a(this, tooltipText);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuView.InterfaceC0435a
    public MenuItemImpl getItemData() {
        return this.f3921d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.InterfaceC0426b interfaceC0426b = this.f3924g;
        if (interfaceC0426b != null) {
            interfaceC0426b.mo7095a(this.f3921d);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3927j = m7143f();
        m7142g();
    }

    @Override // p000a.p006b.p049h.p063k.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean m7144e = m7144e();
        if (m7144e && (i3 = this.f3930n) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f3929m) : this.f3929m;
        if (mode != 1073741824 && this.f3929m > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (m7144e || this.f3923f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f3923f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.f3921d.hasSubMenu() && (forwardingListener = this.f3925h) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f3928k != z) {
            this.f3928k = z;
            MenuItemImpl menuItemImpl = this.f3921d;
            if (menuItemImpl != null) {
                menuItemImpl.m8639b();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3923f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f3931o;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            int i2 = this.f3931o;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m7142g();
    }

    public void setItemInvoker(MenuBuilder.InterfaceC0426b interfaceC0426b) {
        this.f3924g = interfaceC0426b;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f3930n = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(AbstractC0679b abstractC0679b) {
        this.f3926i = abstractC0679b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f3922e = charSequence;
        m7142g();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f3927j = m7143f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.ActionMenuItemView, i, 0);
        this.f3929m = obtainStyledAttributes.getDimensionPixelSize(C0363j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f3931o = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f3930n = -1;
        setSaveEnabled(false);
    }
}
