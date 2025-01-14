package p000a.p006b.p049h.p063k;

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
import p000a.p006b.p049h.p050a.ActionBar;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p061j.ActionBarPolicy;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;

/* renamed from: a.b.h.k.d1 */
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    public Runnable f2587a;

    /* renamed from: b */
    public View$OnClickListenerC0455c f2588b;

    /* renamed from: c */
    public LinearLayoutCompat f2589c;

    /* renamed from: d */
    public Spinner f2590d;

    /* renamed from: e */
    public boolean f2591e;

    /* renamed from: f */
    public int f2592f;

    /* renamed from: g */
    public int f2593g;

    /* renamed from: h */
    public int f2594h;

    /* renamed from: i */
    public int f2595i;

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: a.b.h.k.d1$a */
    /* loaded from: classes.dex */
    public class RunnableC0453a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f2596a;

        public RunnableC0453a(View view) {
            this.f2596a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f2596a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f2596a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f2587a = null;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: a.b.h.k.d1$b */
    /* loaded from: classes.dex */
    public class C0454b extends BaseAdapter {
        public C0454b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f2589c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((C0456d) ScrollingTabContainerView.this.f2589c.getChildAt(i)).m8443a();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m8447a((ActionBar.AbstractC0324c) getItem(i), true);
            }
            ((C0456d) view).m8442a((ActionBar.AbstractC0324c) getItem(i));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: a.b.h.k.d1$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0455c implements View.OnClickListener {
        public View$OnClickListenerC0455c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((C0456d) view).m8443a().m9150e();
            int childCount = ScrollingTabContainerView.this.f2589c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f2589c.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    /* renamed from: a */
    public final Spinner m8449a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C0354a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.C0492a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    /* renamed from: b */
    public final boolean m8446b() {
        Spinner spinner = this.f2590d;
        return spinner != null && spinner.getParent() == this;
    }

    /* renamed from: c */
    public final void m8445c() {
        if (m8446b()) {
            return;
        }
        if (this.f2590d == null) {
            this.f2590d = m8449a();
        }
        removeView(this.f2589c);
        addView(this.f2590d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f2590d.getAdapter() == null) {
            this.f2590d.setAdapter((SpinnerAdapter) new C0454b());
        }
        Runnable runnable = this.f2587a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2587a = null;
        }
        this.f2590d.setSelection(this.f2595i);
    }

    /* renamed from: d */
    public final boolean m8444d() {
        if (m8446b()) {
            removeView(this.f2590d);
            addView(this.f2589c, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f2590d.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2587a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy m8781a = ActionBarPolicy.m8781a(getContext());
        setContentHeight(m8781a.m8777e());
        this.f2593g = m8781a.m8778d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2587a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0456d) view).m8443a().m9150e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f2589c.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f2592f = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f2592f = View.MeasureSpec.getSize(i) / 2;
            }
            this.f2592f = Math.min(this.f2592f, this.f2593g);
        } else {
            this.f2592f = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2594h, 1073741824);
        if ((z2 || !this.f2591e) ? false : false) {
            this.f2589c.measure(0, makeMeasureSpec);
            if (this.f2589c.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m8445c();
            } else {
                m8444d();
            }
        } else {
            m8444d();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f2595i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2591e = z;
    }

    public void setContentHeight(int i) {
        this.f2594h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2595i = i;
        int childCount = this.f2589c.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2589c.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m8448a(i);
            }
            i2++;
        }
        Spinner spinner = this.f2590d;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: a.b.h.k.d1$d */
    /* loaded from: classes.dex */
    public class C0456d extends LinearLayout {

        /* renamed from: a */
        public final int[] f2600a;

        /* renamed from: b */
        public ActionBar.AbstractC0324c f2601b;

        /* renamed from: c */
        public TextView f2602c;

        /* renamed from: d */
        public ImageView f2603d;

        /* renamed from: e */
        public View f2604e;

        public C0456d(Context context, ActionBar.AbstractC0324c abstractC0324c, boolean z) {
            super(context, null, C0354a.actionBarTabStyle);
            this.f2600a = new int[]{16842964};
            this.f2601b = abstractC0324c;
            TintTypedArray m8257a = TintTypedArray.m8257a(context, null, this.f2600a, C0354a.actionBarTabStyle, 0);
            if (m8257a.m8245g(0)) {
                setBackgroundDrawable(m8257a.m8256b(0));
            }
            m8257a.m8265a();
            if (z) {
                setGravity(8388627);
            }
            m8441b();
        }

        /* renamed from: a */
        public void m8442a(ActionBar.AbstractC0324c abstractC0324c) {
            this.f2601b = abstractC0324c;
            m8441b();
        }

        /* renamed from: b */
        public void m8441b() {
            ActionBar.AbstractC0324c abstractC0324c = this.f2601b;
            View m9153b = abstractC0324c.m9153b();
            if (m9153b != null) {
                ViewParent parent = m9153b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(m9153b);
                    }
                    addView(m9153b);
                }
                this.f2604e = m9153b;
                TextView textView = this.f2602c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2603d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2603d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2604e;
            if (view != null) {
                removeView(view);
                this.f2604e = null;
            }
            Drawable m9152c = abstractC0324c.m9152c();
            CharSequence m9151d = abstractC0324c.m9151d();
            if (m9152c != null) {
                if (this.f2603d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2603d = appCompatImageView;
                }
                this.f2603d.setImageDrawable(m9152c);
                this.f2603d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2603d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2603d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(m9151d);
            if (z) {
                if (this.f2602c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, C0354a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2602c = appCompatTextView;
                }
                this.f2602c.setText(m9151d);
                this.f2602c.setVisibility(0);
            } else {
                TextView textView2 = this.f2602c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2602c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f2603d;
            if (imageView3 != null) {
                imageView3.setContentDescription(abstractC0324c.m9154a());
            }
            TooltipCompat.m8181a(this, z ? null : abstractC0324c.m9154a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.AbstractC0324c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.AbstractC0324c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f2592f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = ScrollingTabContainerView.this.f2592f;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
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

        /* renamed from: a */
        public ActionBar.AbstractC0324c m8443a() {
            return this.f2601b;
        }
    }

    /* renamed from: a */
    public void m8448a(int i) {
        View childAt = this.f2589c.getChildAt(i);
        Runnable runnable = this.f2587a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f2587a = new RunnableC0453a(childAt);
        post(this.f2587a);
    }

    /* renamed from: a */
    public C0456d m8447a(ActionBar.AbstractC0324c abstractC0324c, boolean z) {
        C0456d c0456d = new C0456d(getContext(), abstractC0324c, z);
        if (z) {
            c0456d.setBackgroundDrawable(null);
            c0456d.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2594h));
        } else {
            c0456d.setFocusable(true);
            if (this.f2588b == null) {
                this.f2588b = new View$OnClickListenerC0455c();
            }
            c0456d.setOnClickListener(this.f2588b);
        }
        return c0456d;
    }
}
