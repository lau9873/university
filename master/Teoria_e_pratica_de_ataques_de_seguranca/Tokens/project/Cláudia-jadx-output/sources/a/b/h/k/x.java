package a.b.h.k;

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
/* compiled from: AppCompatSpinner.java */
/* loaded from: classes.dex */
public class x extends Spinner implements a.b.g.k.t {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f1978i = {16843505};

    /* renamed from: a  reason: collision with root package name */
    public final f f1979a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1980b;

    /* renamed from: c  reason: collision with root package name */
    public o0 f1981c;

    /* renamed from: d  reason: collision with root package name */
    public SpinnerAdapter f1982d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1983e;

    /* renamed from: f  reason: collision with root package name */
    public c f1984f;

    /* renamed from: g  reason: collision with root package name */
    public int f1985g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f1986h;

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public class a extends o0 {
        public final /* synthetic */ c j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, c cVar) {
            super(view);
            this.j = cVar;
        }

        @Override // a.b.h.k.o0
        public a.b.h.j.j.t b() {
            return this.j;
        }

        @Override // a.b.h.k.o0
        public boolean c() {
            if (x.this.f1984f.f()) {
                return true;
            }
            x.this.f1984f.d();
            return true;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public SpinnerAdapter f1987a;

        /* renamed from: b  reason: collision with root package name */
        public ListAdapter f1988b;

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1987a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1988b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof h1) {
                    h1 h1Var = (h1) spinnerAdapter;
                    if (h1Var.getDropDownViewTheme() == null) {
                        h1Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1988b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f1988b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1987a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public class c extends s0 {
        public CharSequence J;
        public ListAdapter K;
        public final Rect L;

        /* compiled from: AppCompatSpinner.java */
        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemClickListener {
            public a(x xVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                x.this.setSelection(i2);
                if (x.this.getOnItemClickListener() != null) {
                    c cVar = c.this;
                    x.this.performItemClick(view, i2, cVar.K.getItemId(i2));
                }
                c.this.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* loaded from: classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                c cVar = c.this;
                if (!cVar.b(x.this)) {
                    c.this.dismiss();
                    return;
                }
                c.this.n();
                c.super.d();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: a.b.h.k.x$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0044c implements PopupWindow.OnDismissListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1991a;

            public C0044c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1991a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = x.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1991a);
                }
            }
        }

        public c(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.L = new Rect();
            a(x.this);
            a(true);
            f(0);
            a(new a(x.this));
        }

        public boolean b(View view) {
            return a.b.g.k.u.w(view) && view.getGlobalVisibleRect(this.L);
        }

        @Override // a.b.h.k.s0, a.b.h.j.j.t
        public void d() {
            ViewTreeObserver viewTreeObserver;
            boolean f2 = f();
            n();
            e(2);
            super.d();
            e().setChoiceMode(1);
            g(x.this.getSelectedItemPosition());
            if (f2 || (viewTreeObserver = x.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            a(new C0044c(bVar));
        }

        public void n() {
            Drawable g2 = g();
            int i2 = 0;
            if (g2 != null) {
                g2.getPadding(x.this.f1986h);
                i2 = t1.a(x.this) ? x.this.f1986h.right : -x.this.f1986h.left;
            } else {
                Rect rect = x.this.f1986h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = x.this.getPaddingLeft();
            int paddingRight = x.this.getPaddingRight();
            int width = x.this.getWidth();
            x xVar = x.this;
            int i3 = xVar.f1985g;
            if (i3 == -2) {
                int a2 = xVar.a((SpinnerAdapter) this.K, g());
                int i4 = x.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = x.this.f1986h;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                b(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                b((width - paddingLeft) - paddingRight);
            } else {
                b(i3);
            }
            d(t1.a(x.this) ? i2 + ((width - paddingRight) - j()) : i2 + paddingLeft);
        }

        public CharSequence o() {
            return this.J;
        }

        @Override // a.b.h.k.s0
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.K = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.J = charSequence;
        }
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.spinnerStyle);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f1986h);
            Rect rect = this.f1986h;
            return i3 + rect.left + rect.right;
        }
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1979a;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        c cVar = this.f1984f;
        if (cVar != null) {
            return cVar.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        c cVar = this.f1984f;
        if (cVar != null) {
            return cVar.i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1984f != null) {
            return this.f1985g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        c cVar = this.f1984f;
        if (cVar != null) {
            return cVar.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.f1984f != null) {
            return this.f1980b;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        c cVar = this.f1984f;
        return cVar != null ? cVar.o() : super.getPrompt();
    }

    @Override // a.b.g.k.t
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1979a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // a.b.g.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1979a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f1984f;
        if (cVar == null || !cVar.f()) {
            return;
        }
        this.f1984f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1984f == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        o0 o0Var = this.f1981c;
        if (o0Var == null || !o0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        c cVar = this.f1984f;
        if (cVar != null) {
            if (cVar.f()) {
                return true;
            }
            this.f1984f.d();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1979a;
        if (fVar != null) {
            fVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        f fVar = this.f1979a;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        c cVar = this.f1984f;
        if (cVar != null) {
            cVar.d(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        c cVar = this.f1984f;
        if (cVar != null) {
            cVar.h(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f1984f != null) {
            this.f1985g = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        c cVar = this.f1984f;
        if (cVar != null) {
            cVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(a.b.h.d.a.a.c(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        c cVar = this.f1984f;
        if (cVar != null) {
            cVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1979a;
        if (fVar != null) {
            fVar.b(colorStateList);
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1979a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    public x(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1983e) {
            this.f1982d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1984f != null) {
            Context context = this.f1980b;
            if (context == null) {
                context = getContext();
            }
            this.f1984f.a(new b(spinnerAdapter, context.getTheme()));
        }
    }

    public x(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
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
        To view partially-correct add '--show-bad-code' argument
    */
    public x(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.f1986h = r0
            int[] r0 = a.b.h.b.j.Spinner
            r1 = 0
            a.b.h.k.l1 r0 = a.b.h.k.l1.a(r8, r9, r0, r10, r1)
            a.b.h.k.f r2 = new a.b.h.k.f
            r2.<init>(r7)
            r7.f1979a = r2
            r2 = 0
            if (r12 == 0) goto L23
            a.b.h.j.d r3 = new a.b.h.j.d
            r3.<init>(r8, r12)
            r7.f1980b = r3
            goto L3e
        L23:
            int r12 = a.b.h.b.j.Spinner_popupTheme
            int r12 = r0.g(r12, r1)
            if (r12 == 0) goto L33
            a.b.h.j.d r3 = new a.b.h.j.d
            r3.<init>(r8, r12)
            r7.f1980b = r3
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
            r7.f1980b = r12
        L3e:
            android.content.Context r12 = r7.f1980b
            r3 = 1
            if (r12 == 0) goto Lac
            r12 = -1
            if (r11 != r12) goto L74
            int[] r12 = a.b.h.k.x.f1978i     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
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
            android.content.Context r12 = r7.f1980b
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.f1980b
            int[] r4 = a.b.h.b.j.Spinner
            a.b.h.k.l1 r12 = a.b.h.k.l1.a(r12, r9, r4, r10, r1)
            int r1 = a.b.h.b.j.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.f(r1, r4)
            r7.f1985g = r1
            int r1 = a.b.h.b.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.b(r1)
            r11.a(r1)
            int r1 = a.b.h.b.j.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r11.a(r1)
            r12.a()
            r7.f1984f = r11
            a.b.h.k.x$a r12 = new a.b.h.k.x$a
            r12.<init>(r7, r11)
            r7.f1981c = r12
        Lac:
            int r11 = a.b.h.b.j.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.f(r11)
            if (r11 == 0) goto Lc4
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = a.b.h.b.g.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter(r12)
        Lc4:
            r0.a()
            r7.f1983e = r3
            android.widget.SpinnerAdapter r8 = r7.f1982d
            if (r8 == 0) goto Ld2
            r7.setAdapter(r8)
            r7.f1982d = r2
        Ld2:
            a.b.h.k.f r8 = r7.f1979a
            r8.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.k.x.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
