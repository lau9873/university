package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.BaseTransientBottomBar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0046h;
import p000a.p006b.p012d.p023u.ContentViewCallback;

/* loaded from: classes.dex */
public final class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* renamed from: o */
    public static final int[] f3368o = {C0040b.snackbarButtonStyle};

    /* renamed from: m */
    public final AccessibilityManager f3369m;

    /* renamed from: n */
    public boolean f3370n;

    /* loaded from: classes.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.C0560p {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* renamed from: android.support.design.widget.Snackbar$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0586a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ View.OnClickListener f3371a;

        public View$OnClickListenerC0586a(View.OnClickListener onClickListener) {
            this.f3371a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f3371a.onClick(view);
            Snackbar.this.m7800b(1);
        }
    }

    /* renamed from: android.support.design.widget.Snackbar$b */
    /* loaded from: classes.dex */
    public static class C0587b extends BaseTransientBottomBar.AbstractC0556l<Snackbar> {
        @Override // android.support.design.widget.BaseTransientBottomBar.AbstractC0556l
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo7617a(Snackbar snackbar) {
        }

        /* renamed from: a */
        public void mo906a(Snackbar snackbar, int i) {
        }
    }

    public Snackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
        this.f3369m = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    /* renamed from: a */
    public static Snackbar m7626a(View view, CharSequence charSequence, int i) {
        ViewGroup m7627a = m7627a(view);
        if (m7627a != null) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(m7627a.getContext()).inflate(m7628a(m7627a.getContext()) ? C0046h.mtrl_layout_snackbar_include : C0046h.design_layout_snackbar_include, m7627a, false);
            Snackbar snackbar = new Snackbar(m7627a, snackbarContentLayout, snackbarContentLayout);
            snackbar.m7625a(charSequence);
            snackbar.m7795e(i);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    /* renamed from: b */
    public void mo7623b() {
        super.mo7623b();
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    /* renamed from: d */
    public int mo7622d() {
        if (this.f3370n && this.f3369m.isTouchExplorationEnabled()) {
            return -2;
        }
        return super.mo7622d();
    }

    /* renamed from: f */
    public Snackbar m7621f(int i) {
        ((SnackbarContentLayout) this.f3231c.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    /* renamed from: i */
    public boolean mo7620i() {
        return super.mo7620i();
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    /* renamed from: m */
    public void mo7619m() {
        super.mo7619m();
    }

    /* renamed from: a */
    public static boolean m7628a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f3368o);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    /* renamed from: a */
    public static ViewGroup m7627a(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    /* renamed from: a */
    public Snackbar m7625a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f3231c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    /* renamed from: a */
    public Snackbar m7629a(int i, View.OnClickListener onClickListener) {
        m7624a(m7799c().getText(i), onClickListener);
        return this;
    }

    /* renamed from: a */
    public Snackbar m7624a(CharSequence charSequence, View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f3231c.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            this.f3370n = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View$OnClickListenerC0586a(onClickListener));
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.f3370n = false;
        }
        return this;
    }
}
