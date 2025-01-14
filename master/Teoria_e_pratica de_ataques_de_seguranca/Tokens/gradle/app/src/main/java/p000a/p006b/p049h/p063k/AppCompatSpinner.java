package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import p000a.p006b.p030g.p045k.TintableBackgroundView;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p061j.p062j.ShowableListMenu;

/* renamed from: a.b.h.k.x */
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* renamed from: i */
    public static final int[] f2979i = {16843505};

    /* renamed from: a */
    public final AppCompatBackgroundHelper f2980a;

    /* renamed from: b */
    public final Context f2981b;

    /* renamed from: c */
    public ForwardingListener f2982c;

    /* renamed from: d */
    public SpinnerAdapter f2983d;

    /* renamed from: e */
    public final boolean f2984e;

    /* renamed from: f */
    public C0511c f2985f;

    /* renamed from: g */
    public int f2986g;

    /* renamed from: h */
    public final Rect f2987h;

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: a.b.h.k.x$a */
    /* loaded from: classes.dex */
    public class C0509a extends ForwardingListener {

        /* renamed from: j */
        public final /* synthetic */ C0511c f2988j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0509a(View view, C0511c c0511c) {
            super(view);
            this.f2988j = c0511c;
        }

        @Override // p000a.p006b.p049h.p063k.ForwardingListener
        /* renamed from: b */
        public ShowableListMenu mo7141b() {
            return this.f2988j;
        }

        @Override // p000a.p006b.p049h.p063k.ForwardingListener
        /* renamed from: c */
        public boolean mo7140c() {
            if (AppCompatSpinner.this.f2985f.mo8079f()) {
                return true;
            }
            AppCompatSpinner.this.f2985f.mo7998d();
            return true;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: a.b.h.k.x$b */
    /* loaded from: classes.dex */
    public static class C0510b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        public SpinnerAdapter f2990a;

        /* renamed from: b */
        public ListAdapter f2991b;

        public C0510b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f2990a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2991b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2991b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2991b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2990a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: a.b.h.k.x$c */
    /* loaded from: classes.dex */
    public class C0511c extends ListPopupWindow {

        /* renamed from: J */
        public CharSequence f2992J;

        /* renamed from: K */
        public ListAdapter f2993K;

        /* renamed from: L */
        public final Rect f2994L;

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: a.b.h.k.x$c$a */
        /* loaded from: classes.dex */
        public class C0512a implements AdapterView.OnItemClickListener {
            public C0512a(AppCompatSpinner appCompatSpinner) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    C0511c c0511c = C0511c.this;
                    AppCompatSpinner.this.performItemClick(view, i, c0511c.f2993K.getItemId(i));
                }
                C0511c.this.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: a.b.h.k.x$c$b */
        /* loaded from: classes.dex */
        public class ViewTreeObserver$OnGlobalLayoutListenerC0513b implements ViewTreeObserver.OnGlobalLayoutListener {
            public ViewTreeObserver$OnGlobalLayoutListenerC0513b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                C0511c c0511c = C0511c.this;
                if (!c0511c.m7999b(AppCompatSpinner.this)) {
                    C0511c.this.dismiss();
                    return;
                }
                C0511c.this.m7997n();
                C0511c.super.mo7998d();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: a.b.h.k.x$c$c */
        /* loaded from: classes.dex */
        public class C0514c implements PopupWindow.OnDismissListener {

            /* renamed from: a */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2998a;

            public C0514c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2998a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2998a);
                }
            }
        }

        public C0511c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2994L = new Rect();
            m8093a(AppCompatSpinner.this);
            m8089a(true);
            m8078f(0);
            m8091a(new C0512a(AppCompatSpinner.this));
        }

        /* renamed from: b */
        public boolean m7999b(View view) {
            return ViewCompat.m9410w(view) && view.getGlobalVisibleRect(this.f2994L);
        }

        @Override // p000a.p006b.p049h.p063k.ListPopupWindow, p000a.p006b.p049h.p061j.p062j.ShowableListMenu
        /* renamed from: d */
        public void mo7998d() {
            ViewTreeObserver viewTreeObserver;
            boolean mo8079f = mo8079f();
            m7997n();
            m8080e(2);
            super.mo7998d();
            mo8081e().setChoiceMode(1);
            m8076g(AppCompatSpinner.this.getSelectedItemPosition());
            if (mo8079f || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            ViewTreeObserver$OnGlobalLayoutListenerC0513b viewTreeObserver$OnGlobalLayoutListenerC0513b = new ViewTreeObserver$OnGlobalLayoutListenerC0513b();
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListenerC0513b);
            m8090a(new C0514c(viewTreeObserver$OnGlobalLayoutListenerC0513b));
        }

        /* renamed from: n */
        public void m7997n() {
            Drawable m8077g = m8077g();
            int i = 0;
            if (m8077g != null) {
                m8077g.getPadding(AppCompatSpinner.this.f2987h);
                i = C0504t1.m8047a(AppCompatSpinner.this) ? AppCompatSpinner.this.f2987h.right : -AppCompatSpinner.this.f2987h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f2987h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i2 = appCompatSpinner.f2986g;
            if (i2 == -2) {
                int m8003a = appCompatSpinner.m8003a((SpinnerAdapter) this.f2993K, m8077g());
                int i3 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f2987h;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (m8003a > i4) {
                    m8003a = i4;
                }
                m8087b(Math.max(m8003a, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                m8087b((width - paddingLeft) - paddingRight);
            } else {
                m8087b(i2);
            }
            m8082d(C0504t1.m8047a(AppCompatSpinner.this) ? i + ((width - paddingRight) - m8071j()) : i + paddingLeft);
        }

        /* renamed from: o */
        public CharSequence m7996o() {
            return this.f2992J;
        }

        @Override // p000a.p006b.p049h.p063k.ListPopupWindow
        /* renamed from: a */
        public void mo8001a(ListAdapter listAdapter) {
            super.mo8001a(listAdapter);
            this.f2993K = listAdapter;
        }

        /* renamed from: a */
        public void m8000a(CharSequence charSequence) {
            this.f2992J = charSequence;
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.spinnerStyle);
    }

    /* renamed from: a */
    public int m8003a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f2987h);
            Rect rect = this.f2987h;
            return i2 + rect.left + rect.right;
        }
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8424a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            return c0511c.m8075h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            return c0511c.m8073i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f2985f != null) {
            return this.f2986g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            return c0511c.m8077g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.f2985f != null) {
            return this.f2981b;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        C0511c c0511c = this.f2985f;
        return c0511c != null ? c0511c.m7996o() : super.getPrompt();
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8418b();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8415c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0511c c0511c = this.f2985f;
        if (c0511c == null || !c0511c.mo8079f()) {
            return;
        }
        this.f2985f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2985f == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m8003a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.f2982c;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            if (c0511c.mo8079f()) {
                return true;
            }
            this.f2985f.mo7998d();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8416b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8423a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            c0511c.m8082d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            c0511c.m8074h(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f2985f != null) {
            this.f2986g = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            c0511c.m8094a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(AppCompatResources.m8967c(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        C0511c c0511c = this.f2985f;
        if (c0511c != null) {
            c0511c.m8000a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8417b(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2980a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8421a(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2984e) {
            this.f2983d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2985f != null) {
            Context context = this.f2981b;
            if (context == null) {
                context = getContext();
            }
            this.f2985f.mo8001a(new C0510b(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r12 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
        r12.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r12 == null) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.f2987h = r0
            int[] r0 = p000a.p006b.p049h.p051b.C0363j.Spinner
            r1 = 0
            a.b.h.k.l1 r0 = p000a.p006b.p049h.p063k.TintTypedArray.m8257a(r8, r9, r0, r10, r1)
            a.b.h.k.f r2 = new a.b.h.k.f
            r2.<init>(r7)
            r7.f2980a = r2
            r2 = 0
            if (r12 == 0) goto L23
            a.b.h.j.d r3 = new a.b.h.j.d
            r3.<init>(r8, r12)
            r7.f2981b = r3
            goto L3e
        L23:
            int r12 = p000a.p006b.p049h.p051b.C0363j.Spinner_popupTheme
            int r12 = r0.m8244g(r12, r1)
            if (r12 == 0) goto L33
            a.b.h.j.d r3 = new a.b.h.j.d
            r3.<init>(r8, r12)
            r7.f2981b = r3
            goto L3e
        L33:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L3b
            r12 = r8
            goto L3c
        L3b:
            r12 = r2
        L3c:
            r7.f2981b = r12
        L3e:
            android.content.Context r12 = r7.f2981b
            r3 = 1
            if (r12 == 0) goto Lac
            r12 = -1
            if (r11 != r12) goto L74
            int[] r12 = p000a.p006b.p049h.p063k.AppCompatSpinner.f2979i     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            boolean r4 = r12.hasValue(r1)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L6d
            if (r4 == 0) goto L56
            int r11 = r12.getInt(r1, r1)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L6d
        L56:
            if (r12 == 0) goto L74
        L58:
            r12.recycle()
            goto L74
        L5c:
            r4 = move-exception
            goto L63
        L5e:
            r8 = move-exception
            r12 = r2
            goto L6e
        L61:
            r4 = move-exception
            r12 = r2
        L63:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch: java.lang.Throwable -> L6d
            if (r12 == 0) goto L74
            goto L58
        L6d:
            r8 = move-exception
        L6e:
            if (r12 == 0) goto L73
            r12.recycle()
        L73:
            throw r8
        L74:
            if (r11 != r3) goto Lac
            a.b.h.k.x$c r11 = new a.b.h.k.x$c
            android.content.Context r12 = r7.f2981b
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.f2981b
            int[] r4 = p000a.p006b.p049h.p051b.C0363j.Spinner
            a.b.h.k.l1 r12 = p000a.p006b.p049h.p063k.TintTypedArray.m8257a(r12, r9, r4, r10, r1)
            int r1 = p000a.p006b.p049h.p051b.C0363j.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.m8246f(r1, r4)
            r7.f2986g = r1
            int r1 = p000a.p006b.p049h.p051b.C0363j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.m8256b(r1)
            r11.m8094a(r1)
            int r1 = p000a.p006b.p049h.p051b.C0363j.Spinner_android_prompt
            java.lang.String r1 = r0.m8251d(r1)
            r11.m8000a(r1)
            r12.m8265a()
            r7.f2985f = r11
            a.b.h.k.x$a r12 = new a.b.h.k.x$a
            r12.<init>(r7, r11)
            r7.f2982c = r12
        Lac:
            int r11 = p000a.p006b.p049h.p051b.C0363j.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.m8247f(r11)
            if (r11 == 0) goto Lc4
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = p000a.p006b.p049h.p051b.C0360g.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter(r12)
        Lc4:
            r0.m8265a()
            r7.f2984e = r3
            android.widget.SpinnerAdapter r8 = r7.f2983d
            if (r8 == 0) goto Ld2
            r7.setAdapter(r8)
            r7.f2983d = r2
        Ld2:
            a.b.h.k.f r8 = r7.f2980a
            r8.m8419a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
