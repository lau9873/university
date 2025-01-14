package p000a.p006b.p049h.p063k;

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
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.PopupWindowCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.p062j.ShowableListMenu;

/* renamed from: a.b.h.k.s0 */
/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {

    /* renamed from: G */
    public static Method f2911G;

    /* renamed from: H */
    public static Method f2912H;

    /* renamed from: I */
    public static Method f2913I;

    /* renamed from: A */
    public final RunnableC0497c f2914A;

    /* renamed from: B */
    public final Handler f2915B;

    /* renamed from: C */
    public final Rect f2916C;

    /* renamed from: D */
    public Rect f2917D;

    /* renamed from: E */
    public boolean f2918E;

    /* renamed from: F */
    public PopupWindow f2919F;

    /* renamed from: a */
    public Context f2920a;

    /* renamed from: b */
    public ListAdapter f2921b;

    /* renamed from: c */
    public DropDownListView f2922c;

    /* renamed from: d */
    public int f2923d;

    /* renamed from: e */
    public int f2924e;

    /* renamed from: f */
    public int f2925f;

    /* renamed from: g */
    public int f2926g;

    /* renamed from: h */
    public int f2927h;

    /* renamed from: i */
    public boolean f2928i;

    /* renamed from: j */
    public boolean f2929j;

    /* renamed from: k */
    public boolean f2930k;

    /* renamed from: m */
    public int f2931m;

    /* renamed from: n */
    public boolean f2932n;

    /* renamed from: o */
    public boolean f2933o;

    /* renamed from: p */
    public int f2934p;

    /* renamed from: q */
    public View f2935q;

    /* renamed from: r */
    public int f2936r;

    /* renamed from: s */
    public DataSetObserver f2937s;

    /* renamed from: t */
    public View f2938t;

    /* renamed from: u */
    public Drawable f2939u;

    /* renamed from: v */
    public AdapterView.OnItemClickListener f2940v;

    /* renamed from: w */
    public AdapterView.OnItemSelectedListener f2941w;

    /* renamed from: x */
    public final RunnableC0501g f2942x;

    /* renamed from: y */
    public final View$OnTouchListenerC0500f f2943y;

    /* renamed from: z */
    public final C0499e f2944z;

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$a */
    /* loaded from: classes.dex */
    public class RunnableC0495a implements Runnable {
        public RunnableC0495a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View m8085c = ListPopupWindow.this.m8085c();
            if (m8085c == null || m8085c.getWindowToken() == null) {
                return;
            }
            ListPopupWindow.this.mo7998d();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$b */
    /* loaded from: classes.dex */
    public class C0496b implements AdapterView.OnItemSelectedListener {
        public C0496b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            DropDownListView dropDownListView;
            if (i == -1 || (dropDownListView = ListPopupWindow.this.f2922c) == null) {
                return;
            }
            dropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$c */
    /* loaded from: classes.dex */
    public class RunnableC0497c implements Runnable {
        public RunnableC0497c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.m8088b();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$d */
    /* loaded from: classes.dex */
    public class C0498d extends DataSetObserver {
        public C0498d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.mo8079f()) {
                ListPopupWindow.this.mo7998d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$e */
    /* loaded from: classes.dex */
    public class C0499e implements AbsListView.OnScrollListener {
        public C0499e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.m8070k() || ListPopupWindow.this.f2919F.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.f2915B.removeCallbacks(listPopupWindow.f2942x);
            ListPopupWindow.this.f2942x.run();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$f */
    /* loaded from: classes.dex */
    public class View$OnTouchListenerC0500f implements View.OnTouchListener {
        public View$OnTouchListenerC0500f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f2919F) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.f2919F.getWidth() && y >= 0 && y < ListPopupWindow.this.f2919F.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f2915B.postDelayed(listPopupWindow.f2942x, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.f2915B.removeCallbacks(listPopupWindow2.f2942x);
                return false;
            } else {
                return false;
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: a.b.h.k.s0$g */
    /* loaded from: classes.dex */
    public class RunnableC0501g implements Runnable {
        public RunnableC0501g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f2922c;
            if (dropDownListView == null || !ViewCompat.m9410w(dropDownListView) || ListPopupWindow.this.f2922c.getCount() <= ListPopupWindow.this.f2922c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f2922c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.f2934p) {
                listPopupWindow.f2919F.setInputMethodMode(2);
                ListPopupWindow.this.mo7998d();
            }
        }
    }

    static {
        try {
            f2911G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2912H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f2913I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* renamed from: a */
    public void mo8001a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2937s;
        if (dataSetObserver == null) {
            this.f2937s = new C0498d();
        } else {
            ListAdapter listAdapter2 = this.f2921b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2921b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2937s);
        }
        DropDownListView dropDownListView = this.f2922c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f2921b);
        }
    }

    /* renamed from: b */
    public void m8087b(int i) {
        Drawable background = this.f2919F.getBackground();
        if (background != null) {
            background.getPadding(this.f2916C);
            Rect rect = this.f2916C;
            this.f2924e = rect.left + rect.right + i;
            return;
        }
        m8072i(i);
    }

    /* renamed from: c */
    public View m8085c() {
        return this.f2938t;
    }

    /* renamed from: d */
    public void m8082d(int i) {
        this.f2925f = i;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    public void dismiss() {
        this.f2919F.dismiss();
        m8068m();
        this.f2919F.setContentView(null);
        this.f2922c = null;
        this.f2915B.removeCallbacks(this.f2942x);
    }

    /* renamed from: e */
    public void m8080e(int i) {
        this.f2919F.setInputMethodMode(i);
    }

    /* renamed from: f */
    public void m8078f(int i) {
        this.f2936r = i;
    }

    /* renamed from: g */
    public Drawable m8077g() {
        return this.f2919F.getBackground();
    }

    /* renamed from: h */
    public int m8075h() {
        return this.f2925f;
    }

    /* renamed from: i */
    public int m8073i() {
        if (this.f2928i) {
            return this.f2926g;
        }
        return 0;
    }

    /* renamed from: j */
    public int m8071j() {
        return this.f2924e;
    }

    /* renamed from: k */
    public boolean m8070k() {
        return this.f2919F.getInputMethodMode() == 2;
    }

    /* renamed from: l */
    public boolean m8069l() {
        return this.f2918E;
    }

    /* renamed from: m */
    public final void m8068m() {
        View view = this.f2935q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2935q);
            }
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2923d = -2;
        this.f2924e = -2;
        this.f2927h = 1002;
        this.f2931m = 0;
        this.f2932n = false;
        this.f2933o = false;
        this.f2934p = Integer.MAX_VALUE;
        this.f2936r = 0;
        this.f2942x = new RunnableC0501g();
        this.f2943y = new View$OnTouchListenerC0500f();
        this.f2944z = new C0499e();
        this.f2914A = new RunnableC0497c();
        this.f2916C = new Rect();
        this.f2920a = context;
        this.f2915B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.ListPopupWindow, i, i2);
        this.f2925f = obtainStyledAttributes.getDimensionPixelOffset(C0363j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2926g = obtainStyledAttributes.getDimensionPixelOffset(C0363j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2926g != 0) {
            this.f2928i = true;
        }
        obtainStyledAttributes.recycle();
        this.f2919F = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f2919F.setInputMethodMode(1);
    }

    /* renamed from: c */
    public void m8084c(int i) {
        this.f2931m = i;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: d */
    public void mo7998d() {
        int m8097a = m8097a();
        boolean m8070k = m8070k();
        PopupWindowCompat.m9222a(this.f2919F, this.f2927h);
        boolean z = true;
        if (this.f2919F.isShowing()) {
            if (ViewCompat.m9410w(m8085c())) {
                int i = this.f2924e;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = m8085c().getWidth();
                }
                int i2 = this.f2923d;
                if (i2 == -1) {
                    if (!m8070k) {
                        m8097a = -1;
                    }
                    if (m8070k) {
                        this.f2919F.setWidth(this.f2924e == -1 ? -1 : 0);
                        this.f2919F.setHeight(0);
                    } else {
                        this.f2919F.setWidth(this.f2924e == -1 ? -1 : 0);
                        this.f2919F.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    m8097a = i2;
                }
                this.f2919F.setOutsideTouchable((this.f2933o || this.f2932n) ? false : false);
                this.f2919F.update(m8085c(), this.f2925f, this.f2926g, i < 0 ? -1 : i, m8097a < 0 ? -1 : m8097a);
                return;
            }
            return;
        }
        int i3 = this.f2924e;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = m8085c().getWidth();
        }
        int i4 = this.f2923d;
        if (i4 == -1) {
            m8097a = -1;
        } else if (i4 != -2) {
            m8097a = i4;
        }
        this.f2919F.setWidth(i3);
        this.f2919F.setHeight(m8097a);
        m8083c(true);
        this.f2919F.setOutsideTouchable((this.f2933o || this.f2932n) ? false : true);
        this.f2919F.setTouchInterceptor(this.f2943y);
        if (this.f2930k) {
            PopupWindowCompat.m9220a(this.f2919F, this.f2929j);
        }
        Method method = f2913I;
        if (method != null) {
            try {
                method.invoke(this.f2919F, this.f2917D);
            } catch (Exception e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        PopupWindowCompat.m9221a(this.f2919F, m8085c(), this.f2925f, this.f2926g, this.f2931m);
        this.f2922c.setSelection(-1);
        if (!this.f2918E || this.f2922c.isInTouchMode()) {
            m8088b();
        }
        if (this.f2918E) {
            return;
        }
        this.f2915B.post(this.f2914A);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: e */
    public ListView mo8081e() {
        return this.f2922c;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.ShowableListMenu
    /* renamed from: f */
    public boolean mo8079f() {
        return this.f2919F.isShowing();
    }

    /* renamed from: g */
    public void m8076g(int i) {
        DropDownListView dropDownListView = this.f2922c;
        if (!mo8079f() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i, true);
        }
    }

    /* renamed from: h */
    public void m8074h(int i) {
        this.f2926g = i;
        this.f2928i = true;
    }

    /* renamed from: c */
    public final void m8083c(boolean z) {
        Method method = f2911G;
        if (method != null) {
            try {
                method.invoke(this.f2919F, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: i */
    public void m8072i(int i) {
        this.f2924e = i;
    }

    /* renamed from: b */
    public void m8088b() {
        DropDownListView dropDownListView = this.f2922c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    /* renamed from: b */
    public void m8086b(boolean z) {
        this.f2930k = true;
        this.f2929j = z;
    }

    /* renamed from: a */
    public void m8089a(boolean z) {
        this.f2918E = z;
        this.f2919F.setFocusable(z);
    }

    /* renamed from: a */
    public void m8094a(Drawable drawable) {
        this.f2919F.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void m8096a(int i) {
        this.f2919F.setAnimationStyle(i);
    }

    /* renamed from: a */
    public void m8093a(View view) {
        this.f2938t = view;
    }

    /* renamed from: a */
    public void m8095a(Rect rect) {
        this.f2917D = rect;
    }

    /* renamed from: a */
    public void m8091a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2940v = onItemClickListener;
    }

    /* renamed from: a */
    public void m8090a(PopupWindow.OnDismissListener onDismissListener) {
        this.f2919F.setOnDismissListener(onDismissListener);
    }

    /* renamed from: a */
    public DropDownListView mo8042a(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final int m8097a() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.f2922c == null) {
            Context context = this.f2920a;
            new RunnableC0495a();
            this.f2922c = mo8042a(context, !this.f2918E);
            Drawable drawable = this.f2939u;
            if (drawable != null) {
                this.f2922c.setSelector(drawable);
            }
            this.f2922c.setAdapter(this.f2921b);
            this.f2922c.setOnItemClickListener(this.f2940v);
            this.f2922c.setFocusable(true);
            this.f2922c.setFocusableInTouchMode(true);
            this.f2922c.setOnItemSelectedListener(new C0496b());
            this.f2922c.setOnScrollListener(this.f2944z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2941w;
            if (onItemSelectedListener != null) {
                this.f2922c.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.f2922c;
            View view = this.f2935q;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.f2936r;
                if (i4 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(dropDownListView, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f2936r);
                } else {
                    linearLayout.addView(dropDownListView, layoutParams);
                    linearLayout.addView(view);
                }
                int i5 = this.f2924e;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                dropDownListView = linearLayout;
            } else {
                i = 0;
            }
            this.f2919F.setContentView(dropDownListView);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2919F.getContentView();
            View view2 = this.f2935q;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.f2919F.getBackground();
        if (background != null) {
            background.getPadding(this.f2916C);
            Rect rect = this.f2916C;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.f2928i) {
                this.f2926g = -i6;
            }
        } else {
            this.f2916C.setEmpty();
            i2 = 0;
        }
        int m8092a = m8092a(m8085c(), this.f2926g, this.f2919F.getInputMethodMode() == 2);
        if (this.f2932n || this.f2923d == -1) {
            return m8092a + i2;
        }
        int i7 = this.f2924e;
        if (i7 == -2) {
            int i8 = this.f2920a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f2916C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.f2920a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f2916C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int m8278a = this.f2922c.m8278a(makeMeasureSpec, 0, -1, m8092a - i, -1);
        if (m8278a > 0) {
            i += i2 + this.f2922c.getPaddingTop() + this.f2922c.getPaddingBottom();
        }
        return m8278a + i;
    }

    /* renamed from: a */
    public final int m8092a(View view, int i, boolean z) {
        Method method = f2912H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f2919F, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2919F.getMaxAvailableHeight(view, i);
    }
}
