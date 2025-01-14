package android.support.design.widget;

import a.b.d.h;
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
/* loaded from: classes.dex */
public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] o = {a.b.d.b.snackbarButtonStyle};
    public final AccessibilityManager m;
    public boolean n;

    /* loaded from: classes.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.p {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f2210a;

        public a(View.OnClickListener onClickListener) {
            this.f2210a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2210a.onClick(view);
            Snackbar.this.b(1);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends BaseTransientBottomBar.l<Snackbar> {
        @Override // android.support.design.widget.BaseTransientBottomBar.l
        public void a(Snackbar snackbar) {
        }

        public void a(Snackbar snackbar, int i2) {
        }
    }

    public Snackbar(ViewGroup viewGroup, View view, a.b.d.u.a aVar) {
        super(viewGroup, view, aVar);
        this.m = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static Snackbar a(View view, CharSequence charSequence, int i2) {
        ViewGroup a2 = a(view);
        if (a2 != null) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(a2.getContext()).inflate(a(a2.getContext()) ? h.mtrl_layout_snackbar_include : h.design_layout_snackbar_include, a2, false);
            Snackbar snackbar = new Snackbar(a2, snackbarContentLayout, snackbarContentLayout);
            snackbar.a(charSequence);
            snackbar.e(i2);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    public void b() {
        super.b();
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    public int d() {
        if (this.n && this.m.isTouchExplorationEnabled()) {
            return -2;
        }
        return super.d();
    }

    public Snackbar f(int i2) {
        ((SnackbarContentLayout) this.f2122c.getChildAt(0)).getActionView().setTextColor(i2);
        return this;
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    public boolean i() {
        return super.i();
    }

    @Override // android.support.design.widget.BaseTransientBottomBar
    public void m() {
        super.m();
    }

    public static boolean a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(o);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public static ViewGroup a(View view) {
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

    public Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f2122c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar a(int i2, View.OnClickListener onClickListener) {
        a(c().getText(i2), onClickListener);
        return this;
    }

    public Snackbar a(CharSequence charSequence, View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f2122c.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            this.n = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.n = false;
        }
        return this;
    }
}
