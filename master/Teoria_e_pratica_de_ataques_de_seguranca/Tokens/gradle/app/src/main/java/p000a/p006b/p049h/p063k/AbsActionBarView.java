package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.p067v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.a */
/* loaded from: classes.dex */
public abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: a */
    public final C0438a f2493a;

    /* renamed from: b */
    public final Context f2494b;

    /* renamed from: c */
    public ActionMenuView f2495c;

    /* renamed from: d */
    public ActionMenuPresenter f2496d;

    /* renamed from: e */
    public int f2497e;

    /* renamed from: f */
    public ViewPropertyAnimatorCompat f2498f;

    /* renamed from: g */
    public boolean f2499g;

    /* renamed from: h */
    public boolean f2500h;

    public AbsActionBarView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static int m8568a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int getAnimatedVisibility() {
        if (this.f2498f != null) {
            return this.f2493a.f2502b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f2497e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0363j.ActionBar, C0354a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0363j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f2496d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m8504a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2500h = false;
        }
        if (!this.f2500h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2500h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2500h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2499g = false;
        }
        if (!this.f2499g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2499g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2499g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f2498f;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.m9337a();
            }
            super.setVisibility(i);
        }
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: a.b.h.k.a$a */
    /* loaded from: classes.dex */
    public class C0438a implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        public boolean f2501a = false;

        /* renamed from: b */
        public int f2502b;

        public C0438a() {
        }

        /* renamed from: a */
        public C0438a m8562a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            AbsActionBarView.this.f2498f = viewPropertyAnimatorCompat;
            this.f2502b = i;
            return this;
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            if (this.f2501a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f2498f = null;
            AbsActionBarView.super.setVisibility(this.f2502b);
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: c */
        public void mo8183c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f2501a = false;
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: a */
        public void mo8185a(View view) {
            this.f2501a = true;
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat m8567a(int i, long j) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f2498f;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.m9337a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat m9459a = ViewCompat.m9459a(this);
            m9459a.m9336a(1.0f);
            m9459a.m9335a(j);
            C0438a c0438a = this.f2493a;
            c0438a.m8562a(m9459a, i);
            m9459a.m9334a(c0438a);
            return m9459a;
        }
        ViewPropertyAnimatorCompat m9459a2 = ViewCompat.m9459a(this);
        m9459a2.m9336a(0.0f);
        m9459a2.m9335a(j);
        C0438a c0438a2 = this.f2493a;
        c0438a2.m8562a(m9459a2, i);
        m9459a2.m9334a(c0438a2);
        return m9459a2;
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.f2493a = new C0438a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C0354a.actionBarPopupTheme, typedValue, true) && (i2 = typedValue.resourceId) != 0) {
            this.f2494b = new ContextThemeWrapper(context, i2);
        } else {
            this.f2494b = context;
        }
    }

    /* renamed from: a */
    public int m8565a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* renamed from: a */
    public int m8564a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
