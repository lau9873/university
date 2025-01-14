package android.support.v7.view.menu;

import a.b.h.b.j;
import a.b.h.j.j.h;
import a.b.h.j.j.k;
import a.b.h.j.j.q;
import a.b.h.j.j.t;
import a.b.h.k.n1;
import a.b.h.k.o0;
import a.b.h.k.z;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ActionMenuItemView extends z implements q.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: d  reason: collision with root package name */
    public k f2454d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f2455e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f2456f;

    /* renamed from: g  reason: collision with root package name */
    public h.b f2457g;

    /* renamed from: h  reason: collision with root package name */
    public o0 f2458h;

    /* renamed from: i  reason: collision with root package name */
    public b f2459i;
    public boolean j;
    public boolean k;
    public int m;
    public int n;
    public int o;

    /* loaded from: classes.dex */
    public class a extends o0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // a.b.h.k.o0
        public t b() {
            b bVar = ActionMenuItemView.this.f2459i;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // a.b.h.k.o0
        public boolean c() {
            t b2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            h.b bVar = actionMenuItemView.f2457g;
            return bVar != null && bVar.a(actionMenuItemView.f2454d) && (b2 = b()) != null && b2.f();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract t a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // a.b.h.j.j.q.a
    public void a(k kVar, int i2) {
        this.f2454d = kVar;
        setIcon(kVar.getIcon());
        setTitle(kVar.a(this));
        setId(kVar.getItemId());
        setVisibility(kVar.isVisible() ? 0 : 8);
        setEnabled(kVar.isEnabled());
        if (kVar.hasSubMenu() && this.f2458h == null) {
            this.f2458h = new a();
        }
    }

    @Override // a.b.h.j.j.q.a
    public boolean a() {
        return true;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean b() {
        return e();
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean c() {
        return e() && this.f2454d.getIcon() == null;
    }

    public boolean e() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void g() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f2455e);
        if (this.f2456f != null && (!this.f2454d.n() || (!this.j && !this.k))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f2455e : null);
        CharSequence contentDescription = this.f2454d.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f2454d.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f2454d.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            n1.a(this, z3 ? null : this.f2454d.getTitle());
        } else {
            n1.a(this, tooltipText);
        }
    }

    @Override // a.b.h.j.j.q.a
    public k getItemData() {
        return this.f2454d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar = this.f2457g;
        if (bVar != null) {
            bVar.a(this.f2454d);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j = f();
        g();
    }

    @Override // a.b.h.k.z, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean e2 = e();
        if (e2 && (i4 = this.n) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.m) : this.m;
        if (mode != 1073741824 && this.m > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (e2 || this.f2456f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2456f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        o0 o0Var;
        if (this.f2454d.hasSubMenu() && (o0Var = this.f2458h) != null && o0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.k != z) {
            this.k = z;
            k kVar = this.f2454d;
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2456f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.o;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            int i3 = this.o;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(h.b bVar) {
        this.f2457g = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.n = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f2459i = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2455e = charSequence;
        g();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.j = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMenuItemView, i2, 0);
        this.m = obtainStyledAttributes.getDimensionPixelSize(j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.o = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.n = -1;
        setSaveEnabled(false);
    }
}
