package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p030g.p048l.ListViewAutoScrollHelper;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p055e.p056a.DrawableWrapper;

/* renamed from: a.b.h.k.l0 */
/* loaded from: classes.dex */
public class DropDownListView extends ListView {

    /* renamed from: a */
    public final Rect f2737a;

    /* renamed from: b */
    public int f2738b;

    /* renamed from: c */
    public int f2739c;

    /* renamed from: d */
    public int f2740d;

    /* renamed from: e */
    public int f2741e;

    /* renamed from: f */
    public int f2742f;

    /* renamed from: g */
    public Field f2743g;

    /* renamed from: h */
    public C0476a f2744h;

    /* renamed from: i */
    public boolean f2745i;

    /* renamed from: j */
    public boolean f2746j;

    /* renamed from: k */
    public boolean f2747k;

    /* renamed from: m */
    public ViewPropertyAnimatorCompat f2748m;

    /* renamed from: n */
    public ListViewAutoScrollHelper f2749n;

    /* renamed from: o */
    public RunnableC0477b f2750o;

    /* compiled from: DropDownListView.java */
    /* renamed from: a.b.h.k.l0$a */
    /* loaded from: classes.dex */
    public static class C0476a extends DrawableWrapper {

        /* renamed from: b */
        public boolean f2751b;

        public C0476a(Drawable drawable) {
            super(drawable);
            this.f2751b = true;
        }

        /* renamed from: a */
        public void m8268a(boolean z) {
            this.f2751b = z;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f2751b) {
                super.draw(canvas);
            }
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f2751b) {
                super.setHotspot(f, f2);
            }
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2751b) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f2751b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f2751b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: a.b.h.k.l0$b */
    /* loaded from: classes.dex */
    public class RunnableC0477b implements Runnable {
        public RunnableC0477b() {
        }

        /* renamed from: a */
        public void m8267a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f2750o = null;
            dropDownListView.removeCallbacks(this);
        }

        /* renamed from: b */
        public void m8266b() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f2750o = null;
            dropDownListView.drawableStateChanged();
        }
    }

    public DropDownListView(Context context, boolean z) {
        super(context, null, C0354a.dropDownListViewStyle);
        this.f2737a = new Rect();
        this.f2738b = 0;
        this.f2739c = 0;
        this.f2740d = 0;
        this.f2741e = 0;
        this.f2746j = z;
        setCacheColorHint(0);
        try {
            this.f2743g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2743g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        C0476a c0476a = this.f2744h;
        if (c0476a != null) {
            c0476a.m8268a(z);
        }
    }

    /* renamed from: a */
    public int m8278a(int i, int i2, int i3, int i4, int i5) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        int i7 = i6;
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            if (i11 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i8 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i4) {
                return (i5 < 0 || i8 <= i5 || i10 <= 0 || i7 == i4) ? i4 : i10;
            }
            if (i5 >= 0 && i8 >= i5) {
                i10 = i7;
            }
            i8++;
        }
        return i7;
    }

    /* renamed from: b */
    public final void m8270b(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m8277a(i, view);
        if (z) {
            Rect rect = this.f2737a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.m9864a(selector, exactCenterX, exactCenterY);
        }
    }

    /* renamed from: c */
    public final void m8269c() {
        Drawable selector = getSelector();
        if (selector != null && m8271b() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        m8275a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f2750o != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m8269c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f2746j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f2746j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f2746j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f2746j && this.f2745i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f2750o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f2750o == null) {
            this.f2750o = new RunnableC0477b();
            this.f2750o.m8266b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m8269c();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2742f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC0477b runnableC0477b = this.f2750o;
        if (runnableC0477b != null) {
            runnableC0477b.m8267a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f2745i = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f2744h = drawable != null ? new C0476a(drawable) : null;
        super.setSelector(this.f2744h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2738b = rect.left;
        this.f2739c = rect.top;
        this.f2740d = rect.right;
        this.f2741e = rect.bottom;
    }

    /* renamed from: b */
    public final boolean m8271b() {
        return this.f2747k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r0 != 3) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m8274a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m8272a(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.m8273a(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.m8279a()
        L4d:
            if (r3 == 0) goto L65
            a.b.g.l.k r9 = r7.f2749n
            if (r9 != 0) goto L5a
            a.b.g.l.k r9 = new a.b.g.l.k
            r9.<init>(r7)
            r7.f2749n = r9
        L5a:
            a.b.g.l.k r9 = r7.f2749n
            r9.m9320a(r2)
            a.b.g.l.k r9 = r7.f2749n
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            a.b.g.l.k r8 = r7.f2749n
            if (r8 == 0) goto L6c
            r8.m9320a(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.DropDownListView.m8274a(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: a */
    public final void m8273a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* renamed from: a */
    public final void m8275a(Canvas canvas) {
        Drawable selector;
        if (this.f2737a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f2737a);
        selector.draw(canvas);
    }

    /* renamed from: a */
    public final void m8276a(int i, View view, float f, float f2) {
        m8270b(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        DrawableCompat.m9864a(selector, f, f2);
    }

    /* renamed from: a */
    public final void m8277a(int i, View view) {
        Rect rect = this.f2737a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2738b;
        rect.top -= this.f2739c;
        rect.right += this.f2740d;
        rect.bottom += this.f2741e;
        try {
            boolean z = this.f2743g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2743g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m8279a() {
        this.f2747k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f2742f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f2748m;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.m9337a();
            this.f2748m = null;
        }
    }

    /* renamed from: a */
    public final void m8272a(View view, int i, float f, float f2) {
        View childAt;
        this.f2747k = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.f2742f;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f2742f = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m8276a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }
}
