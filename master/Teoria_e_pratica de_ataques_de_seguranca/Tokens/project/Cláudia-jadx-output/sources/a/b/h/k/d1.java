package a.b.h.k;

import a.b.h.a.a;
import a.b.h.k.r0;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class d1 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f1690a;

    /* renamed from: b  reason: collision with root package name */
    public c f1691b;

    /* renamed from: c  reason: collision with root package name */
    public r0 f1692c;

    /* renamed from: d  reason: collision with root package name */
    public Spinner f1693d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1694e;

    /* renamed from: f  reason: collision with root package name */
    public int f1695f;

    /* renamed from: g  reason: collision with root package name */
    public int f1696g;

    /* renamed from: h  reason: collision with root package name */
    public int f1697h;

    /* renamed from: i  reason: collision with root package name */
    public int f1698i;

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1699a;

        public a(View view) {
            this.f1699a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.this.smoothScrollTo(this.f1699a.getLeft() - ((d1.this.getWidth() - this.f1699a.getWidth()) / 2), 0);
            d1.this.f1690a = null;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return d1.this.f1692c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((d) d1.this.f1692c.getChildAt(i2)).a();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return d1.this.a((a.c) getItem(i2), true);
            }
            ((d) view).a((a.c) getItem(i2));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).a().e();
            int childCount = d1.this.f1692c.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = d1.this.f1692c.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public final Spinner a() {
        x xVar = new x(getContext(), null, a.b.h.b.a.actionDropDownStyle);
        xVar.setLayoutParams(new r0.a(-2, -1));
        xVar.setOnItemSelectedListener(this);
        return xVar;
    }

    public final boolean b() {
        Spinner spinner = this.f1693d;
        return spinner != null && spinner.getParent() == this;
    }

    public final void c() {
        if (b()) {
            return;
        }
        if (this.f1693d == null) {
            this.f1693d = a();
        }
        removeView(this.f1692c);
        addView(this.f1693d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1693d.getAdapter() == null) {
            this.f1693d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f1690a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1690a = null;
        }
        this.f1693d.setSelection(this.f1698i);
    }

    public final boolean d() {
        if (b()) {
            removeView(this.f1693d);
            addView(this.f1692c, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1693d.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1690a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a.b.h.j.a a2 = a.b.h.j.a.a(getContext());
        setContentHeight(a2.e());
        this.f1696g = a2.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1690a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
        ((d) view).a().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f1692c.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f1695f = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f1695f = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f1695f = Math.min(this.f1695f, this.f1696g);
        } else {
            this.f1695f = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1697h, 1073741824);
        if ((z2 || !this.f1694e) ? false : false) {
            this.f1692c.measure(0, makeMeasureSpec);
            if (this.f1692c.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                c();
            } else {
                d();
            }
        } else {
            d();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1698i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f1694e = z;
    }

    public void setContentHeight(int i2) {
        this.f1697h = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f1698i = i2;
        int childCount = this.f1692c.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f1692c.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f1693d;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f1703a;

        /* renamed from: b  reason: collision with root package name */
        public a.c f1704b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f1705c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f1706d;

        /* renamed from: e  reason: collision with root package name */
        public View f1707e;

        public d(Context context, a.c cVar, boolean z) {
            super(context, null, a.b.h.b.a.actionBarTabStyle);
            this.f1703a = new int[]{16842964};
            this.f1704b = cVar;
            l1 a2 = l1.a(context, null, this.f1703a, a.b.h.b.a.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(a.c cVar) {
            this.f1704b = cVar;
            b();
        }

        public void b() {
            a.c cVar = this.f1704b;
            View b2 = cVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f1707e = b2;
                TextView textView = this.f1705c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1706d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1706d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1707e;
            if (view != null) {
                removeView(view);
                this.f1707e = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f1706d == null) {
                    p pVar = new p(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    pVar.setLayoutParams(layoutParams);
                    addView(pVar, 0);
                    this.f1706d = pVar;
                }
                this.f1706d.setImageDrawable(c2);
                this.f1706d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1706d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1706d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f1705c == null) {
                    z zVar = new z(getContext(), null, a.b.h.b.a.actionBarTabTextStyle);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.f1705c = zVar;
                }
                this.f1705c.setText(d2);
                this.f1705c.setVisibility(0);
            } else {
                TextView textView2 = this.f1705c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1705c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1706d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            n1.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (d1.this.f1695f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = d1.this.f1695f;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public a.c a() {
            return this.f1704b;
        }
    }

    public void a(int i2) {
        View childAt = this.f1692c.getChildAt(i2);
        Runnable runnable = this.f1690a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f1690a = new a(childAt);
        post(this.f1690a);
    }

    public d a(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1697h));
        } else {
            dVar.setFocusable(true);
            if (this.f1691b == null) {
                this.f1691b = new c();
            }
            dVar.setOnClickListener(this.f1691b);
        }
        return dVar;
    }
}
