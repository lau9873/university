package com.futuremind.recyclerviewfastscroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p067v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p070c.p081c.p082a.C0883b;
import p070c.p081c.p082a.C0887f;
import p070c.p081c.p082a.C0889i;
import p070c.p081c.p082a.RecyclerViewScrollListener;
import p070c.p081c.p082a.SectionTitleProvider;
import p070c.p081c.p082a.p083j.DefaultScrollerViewProvider;
import p070c.p081c.p082a.p083j.ScrollerViewProvider;

/* loaded from: classes.dex */
public class FastScroller extends LinearLayout {

    /* renamed from: a */
    public final RecyclerViewScrollListener f6068a;

    /* renamed from: b */
    public RecyclerView f6069b;

    /* renamed from: c */
    public View f6070c;

    /* renamed from: d */
    public View f6071d;

    /* renamed from: e */
    public TextView f6072e;

    /* renamed from: f */
    public int f6073f;

    /* renamed from: g */
    public int f6074g;

    /* renamed from: h */
    public int f6075h;

    /* renamed from: i */
    public int f6076i;

    /* renamed from: j */
    public int f6077j;

    /* renamed from: k */
    public int f6078k;

    /* renamed from: m */
    public boolean f6079m;

    /* renamed from: n */
    public ScrollerViewProvider f6080n;

    /* renamed from: o */
    public SectionTitleProvider f6081o;

    /* renamed from: com.futuremind.recyclerviewfastscroll.FastScroller$a */
    /* loaded from: classes.dex */
    public class ViewGroup$OnHierarchyChangeListenerC1435a implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup$OnHierarchyChangeListenerC1435a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            FastScroller.this.m4396c();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            FastScroller.this.m4396c();
        }
    }

    /* renamed from: com.futuremind.recyclerviewfastscroll.FastScroller$b */
    /* loaded from: classes.dex */
    public class View$OnTouchListenerC1436b implements View.OnTouchListener {
        public View$OnTouchListenerC1436b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FastScroller.this.requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                if (FastScroller.this.f6081o != null && motionEvent.getAction() == 0) {
                    FastScroller.this.f6080n.m5671f();
                }
                FastScroller.this.f6079m = true;
                float m4404a = FastScroller.this.m4404a(motionEvent);
                FastScroller.this.setScrollerPosition(m4404a);
                FastScroller.this.setRecyclerViewPosition(m4404a);
                return true;
            } else if (motionEvent.getAction() == 1) {
                FastScroller.this.f6079m = false;
                if (FastScroller.this.f6081o != null) {
                    FastScroller.this.f6080n.m5670g();
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
    public void setRecyclerViewPosition(float f) {
        TextView textView;
        RecyclerView recyclerView = this.f6069b;
        if (recyclerView == null) {
            return;
        }
        int mo747a = recyclerView.getAdapter().mo747a();
        int m5683a = (int) C0889i.m5683a(0.0f, mo747a - 1, (int) (f * mo747a));
        this.f6069b.m6875h(m5683a);
        SectionTitleProvider sectionTitleProvider = this.f6081o;
        if (sectionTitleProvider == null || (textView = this.f6072e) == null) {
            return;
        }
        textView.setText(sectionTitleProvider.mo4676a(m5683a));
    }

    /* renamed from: d */
    public final boolean m4394d() {
        return m4393e() ? this.f6069b.getChildAt(0).getHeight() * this.f6069b.getAdapter().mo747a() <= this.f6069b.getHeight() : this.f6069b.getChildAt(0).getWidth() * this.f6069b.getAdapter().mo747a() <= this.f6069b.getWidth();
    }

    /* renamed from: e */
    public boolean m4393e() {
        return this.f6077j == 1;
    }

    /* renamed from: f */
    public boolean m4392f() {
        return (this.f6071d == null || this.f6079m || this.f6069b.getChildCount() <= 0) ? false : true;
    }

    public ScrollerViewProvider getViewProvider() {
        return this.f6080n;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m4398b();
        this.f6073f = this.f6080n.mo5676b();
        m4405a();
        this.f6068a.m5686a(this.f6069b);
    }

    public void setBubbleColor(int i) {
        this.f6075h = i;
        invalidate();
    }

    public void setBubbleTextAppearance(int i) {
        this.f6076i = i;
        invalidate();
    }

    public void setHandleColor(int i) {
        this.f6074g = i;
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        this.f6077j = i;
        super.setOrientation(i == 0 ? 1 : 0);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.f6069b = recyclerView;
        if (recyclerView.getAdapter() instanceof SectionTitleProvider) {
            this.f6081o = (SectionTitleProvider) recyclerView.getAdapter();
        }
        recyclerView.m6926a(this.f6068a);
        m4396c();
        recyclerView.setOnHierarchyChangeListener(new ViewGroup$OnHierarchyChangeListenerC1435a());
    }

    public void setScrollerPosition(float f) {
        if (m4393e()) {
            this.f6070c.setY(C0889i.m5683a(0.0f, getHeight() - this.f6070c.getHeight(), ((getHeight() - this.f6071d.getHeight()) * f) + this.f6073f));
            this.f6071d.setY(C0889i.m5683a(0.0f, getHeight() - this.f6071d.getHeight(), f * (getHeight() - this.f6071d.getHeight())));
            return;
        }
        this.f6070c.setX(C0889i.m5683a(0.0f, getWidth() - this.f6070c.getWidth(), ((getWidth() - this.f6071d.getWidth()) * f) + this.f6073f));
        this.f6071d.setX(C0889i.m5683a(0.0f, getWidth() - this.f6071d.getWidth(), f * (getWidth() - this.f6071d.getWidth())));
    }

    public void setViewProvider(ScrollerViewProvider scrollerViewProvider) {
        removeAllViews();
        this.f6080n = scrollerViewProvider;
        scrollerViewProvider.m5677a(this);
        this.f6070c = scrollerViewProvider.mo5678a((ViewGroup) this);
        this.f6071d = scrollerViewProvider.mo5675b(this);
        this.f6072e = scrollerViewProvider.mo5666k();
        addView(this.f6070c);
        addView(this.f6071d);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        this.f6078k = i;
        m4396c();
    }

    public FastScroller(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    public final void m4398b() {
        this.f6071d.setOnTouchListener(new View$OnTouchListenerC1436b());
    }

    /* renamed from: c */
    public final void m4396c() {
        if (this.f6069b.getAdapter() != null && this.f6069b.getAdapter().mo747a() != 0 && this.f6069b.getChildAt(0) != null && !m4394d() && this.f6078k == 0) {
            super.setVisibility(0);
        } else {
            super.setVisibility(4);
        }
    }

    public FastScroller(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6068a = new RecyclerViewScrollListener(this);
        setClipChildren(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0887f.fastscroll__fastScroller, C0883b.fastscroll__style, 0);
        try {
            this.f6075h = obtainStyledAttributes.getColor(C0887f.fastscroll__fastScroller_fastscroll__bubbleColor, -1);
            this.f6074g = obtainStyledAttributes.getColor(C0887f.fastscroll__fastScroller_fastscroll__handleColor, -1);
            this.f6076i = obtainStyledAttributes.getResourceId(C0887f.fastscroll__fastScroller_fastscroll__bubbleTextAppearance, -1);
            obtainStyledAttributes.recycle();
            this.f6078k = getVisibility();
            setViewProvider(new DefaultScrollerViewProvider());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    public final void m4405a() {
        int i = this.f6075h;
        if (i != -1) {
            m4403a(this.f6072e, i);
        }
        int i2 = this.f6074g;
        if (i2 != -1) {
            m4403a(this.f6071d, i2);
        }
        int i3 = this.f6076i;
        if (i3 != -1) {
            TextViewCompat.m9205d(this.f6072e, i3);
        }
    }

    /* renamed from: a */
    public final void m4403a(View view, int i) {
        Drawable m9848i = DrawableCompat.m9848i(view.getBackground());
        if (m9848i == null) {
            return;
        }
        DrawableCompat.m9855b(m9848i.mutate(), i);
        C0889i.m5681a(view, m9848i);
    }

    /* renamed from: a */
    public final float m4404a(MotionEvent motionEvent) {
        float rawX;
        int width;
        int width2;
        if (m4393e()) {
            rawX = motionEvent.getRawY() - C0889i.m5680b(this.f6071d);
            width = getHeight();
            width2 = this.f6071d.getHeight();
        } else {
            rawX = motionEvent.getRawX() - C0889i.m5682a(this.f6071d);
            width = getWidth();
            width2 = this.f6071d.getWidth();
        }
        return rawX / (width - width2);
    }
}
