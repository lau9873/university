package a.b.h.k;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class s0 implements a.b.h.j.j.t {
    public static Method G;
    public static Method H;
    public static Method I;
    public final c A;
    public final Handler B;
    public final Rect C;
    public Rect D;
    public boolean E;
    public PopupWindow F;

    /* renamed from: a  reason: collision with root package name */
    public Context f1941a;

    /* renamed from: b  reason: collision with root package name */
    public ListAdapter f1942b;

    /* renamed from: c  reason: collision with root package name */
    public l0 f1943c;

    /* renamed from: d  reason: collision with root package name */
    public int f1944d;

    /* renamed from: e  reason: collision with root package name */
    public int f1945e;

    /* renamed from: f  reason: collision with root package name */
    public int f1946f;

    /* renamed from: g  reason: collision with root package name */
    public int f1947g;

    /* renamed from: h  reason: collision with root package name */
    public int f1948h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1949i;
    public boolean j;
    public boolean k;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public View q;
    public int r;
    public DataSetObserver s;
    public View t;
    public Drawable u;
    public AdapterView.OnItemClickListener v;
    public AdapterView.OnItemSelectedListener w;
    public final g x;
    public final f y;
    public final e z;

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View c2 = s0.this.c();
            if (c2 == null || c2.getWindowToken() == null) {
                return;
            }
            s0.this.d();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            l0 l0Var;
            if (i2 == -1 || (l0Var = s0.this.f1943c) == null) {
                return;
            }
            l0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0.this.b();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (s0.this.f()) {
                s0.this.d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            s0.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || s0.this.k() || s0.this.F.getContentView() == null) {
                return;
            }
            s0 s0Var = s0.this;
            s0Var.B.removeCallbacks(s0Var.x);
            s0.this.x.run();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = s0.this.F) != null && popupWindow.isShowing() && x >= 0 && x < s0.this.F.getWidth() && y >= 0 && y < s0.this.F.getHeight()) {
                s0 s0Var = s0.this;
                s0Var.B.postDelayed(s0Var.x, 250L);
                return false;
            } else if (action == 1) {
                s0 s0Var2 = s0.this;
                s0Var2.B.removeCallbacks(s0Var2.x);
                return false;
            } else {
                return false;
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0 l0Var = s0.this.f1943c;
            if (l0Var == null || !a.b.g.k.u.w(l0Var) || s0.this.f1943c.getCount() <= s0.this.f1943c.getChildCount()) {
                return;
            }
            int childCount = s0.this.f1943c.getChildCount();
            s0 s0Var = s0.this;
            if (childCount <= s0Var.p) {
                s0Var.F.setInputMethodMode(2);
                s0.this.d();
            }
        }
    }

    static {
        try {
            G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public s0(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.s;
        if (dataSetObserver == null) {
            this.s = new d();
        } else {
            ListAdapter listAdapter2 = this.f1942b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1942b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        l0 l0Var = this.f1943c;
        if (l0Var != null) {
            l0Var.setAdapter(this.f1942b);
        }
    }

    public void b(int i2) {
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            this.f1945e = rect.left + rect.right + i2;
            return;
        }
        i(i2);
    }

    public View c() {
        return this.t;
    }

    public void d(int i2) {
        this.f1946f = i2;
    }

    @Override // a.b.h.j.j.t
    public void dismiss() {
        this.F.dismiss();
        m();
        this.F.setContentView(null);
        this.f1943c = null;
        this.B.removeCallbacks(this.x);
    }

    public void e(int i2) {
        this.F.setInputMethodMode(i2);
    }

    public void f(int i2) {
        this.r = i2;
    }

    public Drawable g() {
        return this.F.getBackground();
    }

    public int h() {
        return this.f1946f;
    }

    public int i() {
        if (this.f1949i) {
            return this.f1947g;
        }
        return 0;
    }

    public int j() {
        return this.f1945e;
    }

    public boolean k() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean l() {
        return this.E;
    }

    public final void m() {
        View view = this.q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.q);
            }
        }
    }

    public s0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1944d = -2;
        this.f1945e = -2;
        this.f1948h = 1002;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = Integer.MAX_VALUE;
        this.r = 0;
        this.x = new g();
        this.y = new f();
        this.z = new e();
        this.A = new c();
        this.C = new Rect();
        this.f1941a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.h.b.j.ListPopupWindow, i2, i3);
        this.f1946f = obtainStyledAttributes.getDimensionPixelOffset(a.b.h.b.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1947g = obtainStyledAttributes.getDimensionPixelOffset(a.b.h.b.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1947g != 0) {
            this.f1949i = true;
        }
        obtainStyledAttributes.recycle();
        this.F = new r(context, attributeSet, i2, i3);
        this.F.setInputMethodMode(1);
    }

    public void c(int i2) {
        this.m = i2;
    }

    @Override // a.b.h.j.j.t
    public void d() {
        int a2 = a();
        boolean k = k();
        a.b.g.l.m.a(this.F, this.f1948h);
        boolean z = true;
        if (this.F.isShowing()) {
            if (a.b.g.k.u.w(c())) {
                int i2 = this.f1945e;
                if (i2 == -1) {
                    i2 = -1;
                } else if (i2 == -2) {
                    i2 = c().getWidth();
                }
                int i3 = this.f1944d;
                if (i3 == -1) {
                    if (!k) {
                        a2 = -1;
                    }
                    if (k) {
                        this.F.setWidth(this.f1945e == -1 ? -1 : 0);
                        this.F.setHeight(0);
                    } else {
                        this.F.setWidth(this.f1945e == -1 ? -1 : 0);
                        this.F.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    a2 = i3;
                }
                this.F.setOutsideTouchable((this.o || this.n) ? false : false);
                this.F.update(c(), this.f1946f, this.f1947g, i2 < 0 ? -1 : i2, a2 < 0 ? -1 : a2);
                return;
            }
            return;
        }
        int i4 = this.f1945e;
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = c().getWidth();
        }
        int i5 = this.f1944d;
        if (i5 == -1) {
            a2 = -1;
        } else if (i5 != -2) {
            a2 = i5;
        }
        this.F.setWidth(i4);
        this.F.setHeight(a2);
        c(true);
        this.F.setOutsideTouchable((this.o || this.n) ? false : true);
        this.F.setTouchInterceptor(this.y);
        if (this.k) {
            a.b.g.l.m.a(this.F, this.j);
        }
        Method method = I;
        if (method != null) {
            try {
                method.invoke(this.F, this.D);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        a.b.g.l.m.a(this.F, c(), this.f1946f, this.f1947g, this.m);
        this.f1943c.setSelection(-1);
        if (!this.E || this.f1943c.isInTouchMode()) {
            b();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.A);
    }

    @Override // a.b.h.j.j.t
    public ListView e() {
        return this.f1943c;
    }

    @Override // a.b.h.j.j.t
    public boolean f() {
        return this.F.isShowing();
    }

    public void g(int i2) {
        l0 l0Var = this.f1943c;
        if (!f() || l0Var == null) {
            return;
        }
        l0Var.setListSelectionHidden(false);
        l0Var.setSelection(i2);
        if (l0Var.getChoiceMode() != 0) {
            l0Var.setItemChecked(i2, true);
        }
    }

    public void h(int i2) {
        this.f1947g = i2;
        this.f1949i = true;
    }

    public final void c(boolean z) {
        Method method = G;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void i(int i2) {
        this.f1945e = i2;
    }

    public void b() {
        l0 l0Var = this.f1943c;
        if (l0Var != null) {
            l0Var.setListSelectionHidden(true);
            l0Var.requestLayout();
        }
    }

    public void b(boolean z) {
        this.k = true;
        this.j = z;
    }

    public void a(boolean z) {
        this.E = z;
        this.F.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public void a(int i2) {
        this.F.setAnimationStyle(i2);
    }

    public void a(View view) {
        this.t = view;
    }

    public void a(Rect rect) {
        this.D = rect;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public l0 a(Context context, boolean z) {
        return new l0(context, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a() {
        int i2;
        int i3;
        int makeMeasureSpec;
        int i4;
        if (this.f1943c == null) {
            Context context = this.f1941a;
            new a();
            this.f1943c = a(context, !this.E);
            Drawable drawable = this.u;
            if (drawable != null) {
                this.f1943c.setSelector(drawable);
            }
            this.f1943c.setAdapter(this.f1942b);
            this.f1943c.setOnItemClickListener(this.v);
            this.f1943c.setFocusable(true);
            this.f1943c.setFocusableInTouchMode(true);
            this.f1943c.setOnItemSelectedListener(new b());
            this.f1943c.setOnScrollListener(this.z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.w;
            if (onItemSelectedListener != null) {
                this.f1943c.setOnItemSelectedListener(onItemSelectedListener);
            }
            l0 l0Var = this.f1943c;
            View view = this.q;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.r;
                if (i5 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(l0Var, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.r);
                } else {
                    linearLayout.addView(l0Var, layoutParams);
                    linearLayout.addView(view);
                }
                int i6 = this.f1945e;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i2 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                l0Var = linearLayout;
            } else {
                i2 = 0;
            }
            this.F.setContentView(l0Var);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.F.getContentView();
            View view2 = this.q;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.f1949i) {
                this.f1947g = -i7;
            }
        } else {
            this.C.setEmpty();
            i3 = 0;
        }
        int a2 = a(c(), this.f1947g, this.F.getInputMethodMode() == 2);
        if (this.n || this.f1944d == -1) {
            return a2 + i3;
        }
        int i8 = this.f1945e;
        if (i8 == -2) {
            int i9 = this.f1941a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f1941a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int a3 = this.f1943c.a(makeMeasureSpec, 0, -1, a2 - i2, -1);
        if (a3 > 0) {
            i2 += i3 + this.f1943c.getPaddingTop() + this.f1943c.getPaddingBottom();
        }
        return a3 + i2;
    }

    public final int a(View view, int i2, boolean z) {
        Method method = H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.F, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.F.getMaxAvailableHeight(view, i2);
    }
}
