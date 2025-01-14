package com.futuremind.recyclerviewfastscroll;

import a.b.g.l.p;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.c.a.f;
import c.c.a.g;
import c.c.a.h;
import c.c.a.i;
import c.c.a.j.c;
/* loaded from: classes.dex */
public class FastScroller extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final g f4039a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f4040b;

    /* renamed from: c  reason: collision with root package name */
    public View f4041c;

    /* renamed from: d  reason: collision with root package name */
    public View f4042d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4043e;

    /* renamed from: f  reason: collision with root package name */
    public int f4044f;

    /* renamed from: g  reason: collision with root package name */
    public int f4045g;

    /* renamed from: h  reason: collision with root package name */
    public int f4046h;

    /* renamed from: i  reason: collision with root package name */
    public int f4047i;
    public int j;
    public int k;
    public boolean m;
    public c n;
    public h o;

    /* loaded from: classes.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            FastScroller.this.c();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            FastScroller.this.c();
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FastScroller.this.requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                if (FastScroller.this.o != null && motionEvent.getAction() == 0) {
                    FastScroller.this.n.f();
                }
                FastScroller.this.m = true;
                float a2 = FastScroller.this.a(motionEvent);
                FastScroller.this.setScrollerPosition(a2);
                FastScroller.this.setRecyclerViewPosition(a2);
                return true;
            } else if (motionEvent.getAction() == 1) {
                FastScroller.this.m = false;
                if (FastScroller.this.o != null) {
                    FastScroller.this.n.g();
                }
                return true;
            } else {
                return false;
            }
        }
    }

    public FastScroller(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecyclerViewPosition(float f2) {
        TextView textView;
        RecyclerView recyclerView = this.f4040b;
        if (recyclerView == null) {
            return;
        }
        int a2 = recyclerView.getAdapter().a();
        int a3 = (int) i.a(0.0f, a2 - 1, (int) (f2 * a2));
        this.f4040b.h(a3);
        h hVar = this.o;
        if (hVar == null || (textView = this.f4043e) == null) {
            return;
        }
        textView.setText(hVar.a(a3));
    }

    public final boolean d() {
        return e() ? this.f4040b.getChildAt(0).getHeight() * this.f4040b.getAdapter().a() <= this.f4040b.getHeight() : this.f4040b.getChildAt(0).getWidth() * this.f4040b.getAdapter().a() <= this.f4040b.getWidth();
    }

    public boolean e() {
        return this.j == 1;
    }

    public boolean f() {
        return (this.f4042d == null || this.m || this.f4040b.getChildCount() <= 0) ? false : true;
    }

    public c getViewProvider() {
        return this.n;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b();
        this.f4044f = this.n.b();
        a();
        this.f4039a.a(this.f4040b);
    }

    public void setBubbleColor(int i2) {
        this.f4046h = i2;
        invalidate();
    }

    public void setBubbleTextAppearance(int i2) {
        this.f4047i = i2;
        invalidate();
    }

    public void setHandleColor(int i2) {
        this.f4045g = i2;
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        this.j = i2;
        super.setOrientation(i2 == 0 ? 1 : 0);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.f4040b = recyclerView;
        if (recyclerView.getAdapter() instanceof h) {
            this.o = (h) recyclerView.getAdapter();
        }
        recyclerView.a(this.f4039a);
        c();
        recyclerView.setOnHierarchyChangeListener(new a());
    }

    public void setScrollerPosition(float f2) {
        if (e()) {
            this.f4041c.setY(i.a(0.0f, getHeight() - this.f4041c.getHeight(), ((getHeight() - this.f4042d.getHeight()) * f2) + this.f4044f));
            this.f4042d.setY(i.a(0.0f, getHeight() - this.f4042d.getHeight(), f2 * (getHeight() - this.f4042d.getHeight())));
            return;
        }
        this.f4041c.setX(i.a(0.0f, getWidth() - this.f4041c.getWidth(), ((getWidth() - this.f4042d.getWidth()) * f2) + this.f4044f));
        this.f4042d.setX(i.a(0.0f, getWidth() - this.f4042d.getWidth(), f2 * (getWidth() - this.f4042d.getWidth())));
    }

    public void setViewProvider(c cVar) {
        removeAllViews();
        this.n = cVar;
        cVar.a(this);
        this.f4041c = cVar.a((ViewGroup) this);
        this.f4042d = cVar.b(this);
        this.f4043e = cVar.k();
        addView(this.f4041c);
        addView(this.f4042d);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        this.k = i2;
        c();
    }

    public FastScroller(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b() {
        this.f4042d.setOnTouchListener(new b());
    }

    public final void c() {
        if (this.f4040b.getAdapter() != null && this.f4040b.getAdapter().a() != 0 && this.f4040b.getChildAt(0) != null && !d() && this.k == 0) {
            super.setVisibility(0);
        } else {
            super.setVisibility(4);
        }
    }

    public FastScroller(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4039a = new g(this);
        setClipChildren(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.fastscroll__fastScroller, c.c.a.b.fastscroll__style, 0);
        try {
            this.f4046h = obtainStyledAttributes.getColor(f.fastscroll__fastScroller_fastscroll__bubbleColor, -1);
            this.f4045g = obtainStyledAttributes.getColor(f.fastscroll__fastScroller_fastscroll__handleColor, -1);
            this.f4047i = obtainStyledAttributes.getResourceId(f.fastscroll__fastScroller_fastscroll__bubbleTextAppearance, -1);
            obtainStyledAttributes.recycle();
            this.k = getVisibility();
            setViewProvider(new c.c.a.j.b());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void a() {
        int i2 = this.f4046h;
        if (i2 != -1) {
            a(this.f4043e, i2);
        }
        int i3 = this.f4045g;
        if (i3 != -1) {
            a(this.f4042d, i3);
        }
        int i4 = this.f4047i;
        if (i4 != -1) {
            p.d(this.f4043e, i4);
        }
    }

    public final void a(View view, int i2) {
        Drawable i3 = a.b.g.c.j.a.i(view.getBackground());
        if (i3 == null) {
            return;
        }
        a.b.g.c.j.a.b(i3.mutate(), i2);
        i.a(view, i3);
    }

    public final float a(MotionEvent motionEvent) {
        float rawX;
        int width;
        int width2;
        if (e()) {
            rawX = motionEvent.getRawY() - i.b(this.f4042d);
            width = getHeight();
            width2 = this.f4042d.getHeight();
        } else {
            rawX = motionEvent.getRawX() - i.a(this.f4042d);
            width = getWidth();
            width2 = this.f4042d.getWidth();
        }
        return rawX / (width - width2);
    }
}
