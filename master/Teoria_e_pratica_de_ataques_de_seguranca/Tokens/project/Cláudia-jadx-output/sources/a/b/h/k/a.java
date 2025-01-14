package a.b.h.k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public final C0042a f1632a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1633b;

    /* renamed from: c  reason: collision with root package name */
    public ActionMenuView f1634c;

    /* renamed from: d  reason: collision with root package name */
    public c f1635d;

    /* renamed from: e  reason: collision with root package name */
    public int f1636e;

    /* renamed from: f  reason: collision with root package name */
    public a.b.g.k.z f1637f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1638g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1639h;

    public a(Context context) {
        this(context, null);
    }

    public static int a(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    public int getAnimatedVisibility() {
        if (this.f1637f != null) {
            return this.f1632a.f1641b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1636e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.b.h.b.j.ActionBar, a.b.h.b.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.b.h.b.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f1635d;
        if (cVar != null) {
            cVar.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1639h = false;
        }
        if (!this.f1639h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1639h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1639h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1638g = false;
        }
        if (!this.f1638g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1638g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1638g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            a.b.g.k.z zVar = this.f1637f;
            if (zVar != null) {
                zVar.a();
            }
            super.setVisibility(i2);
        }
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: a.b.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a implements a.b.g.k.a0 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1640a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1641b;

        public C0042a() {
        }

        public C0042a a(a.b.g.k.z zVar, int i2) {
            a.this.f1637f = zVar;
            this.f1641b = i2;
            return this;
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            if (this.f1640a) {
                return;
            }
            a aVar = a.this;
            aVar.f1637f = null;
            a.super.setVisibility(this.f1641b);
        }

        @Override // a.b.g.k.a0
        public void c(View view) {
            a.super.setVisibility(0);
            this.f1640a = false;
        }

        @Override // a.b.g.k.a0
        public void a(View view) {
            this.f1640a = true;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a.b.g.k.z a(int i2, long j) {
        a.b.g.k.z zVar = this.f1637f;
        if (zVar != null) {
            zVar.a();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a.b.g.k.z a2 = a.b.g.k.u.a(this);
            a2.a(1.0f);
            a2.a(j);
            C0042a c0042a = this.f1632a;
            c0042a.a(a2, i2);
            a2.a(c0042a);
            return a2;
        }
        a.b.g.k.z a3 = a.b.g.k.u.a(this);
        a3.a(0.0f);
        a3.a(j);
        C0042a c0042a2 = this.f1632a;
        c0042a2.a(a3, i2);
        a3.a(c0042a2);
        return a3;
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        this.f1632a = new C0042a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.b.h.b.a.actionBarPopupTheme, typedValue, true) && (i3 = typedValue.resourceId) != 0) {
            this.f1633b = new ContextThemeWrapper(context, i3);
        } else {
            this.f1633b = context;
        }
    }

    public int a(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    public int a(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
