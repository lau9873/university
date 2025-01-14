package a.b.h.k;

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
/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
public class l0 extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f1810a;

    /* renamed from: b  reason: collision with root package name */
    public int f1811b;

    /* renamed from: c  reason: collision with root package name */
    public int f1812c;

    /* renamed from: d  reason: collision with root package name */
    public int f1813d;

    /* renamed from: e  reason: collision with root package name */
    public int f1814e;

    /* renamed from: f  reason: collision with root package name */
    public int f1815f;

    /* renamed from: g  reason: collision with root package name */
    public Field f1816g;

    /* renamed from: h  reason: collision with root package name */
    public a f1817h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1818i;
    public boolean j;
    public boolean k;
    public a.b.g.k.z m;
    public a.b.g.l.k n;
    public b o;

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public static class a extends a.b.h.e.a.c {

        /* renamed from: b  reason: collision with root package name */
        public boolean f1819b;

        public a(Drawable drawable) {
            super(drawable);
            this.f1819b = true;
        }

        public void a(boolean z) {
            this.f1819b = z;
        }

        @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1819b) {
                super.draw(canvas);
            }
        }

        @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f1819b) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f1819b) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1819b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // a.b.h.e.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1819b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        public void a() {
            l0 l0Var = l0.this;
            l0Var.o = null;
            l0Var.removeCallbacks(this);
        }

        public void b() {
            l0.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            l0 l0Var = l0.this;
            l0Var.o = null;
            l0Var.drawableStateChanged();
        }
    }

    public l0(Context context, boolean z) {
        super(context, null, a.b.h.b.a.dropDownListViewStyle);
        this.f1810a = new Rect();
        this.f1811b = 0;
        this.f1812c = 0;
        this.f1813d = 0;
        this.f1814e = 0;
        this.j = z;
        setCacheColorHint(0);
        try {
            this.f1816g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1816g.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.f1817h;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
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
        int i7 = listPaddingTop + listPaddingBottom;
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        int i8 = i7;
        View view = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            if (i12 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i2, makeMeasureSpec);
            view.forceLayout();
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i5) {
                return (i6 < 0 || i9 <= i6 || i11 <= 0 || i8 == i5) ? i5 : i11;
            }
            if (i6 >= 0 && i9 >= i6) {
                i11 = i8;
            }
            i9++;
        }
        return i8;
    }

    public final void b(int i2, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i2 == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        a(i2, view);
        if (z) {
            Rect rect = this.f1810a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            a.b.g.c.j.a.a(selector, exactCenterX, exactCenterY);
        }
    }

    public final void c() {
        Drawable selector = getSelector();
        if (selector != null && b() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.o != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.j && this.f1818i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.o == null) {
            this.o = new b();
            this.o.b();
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
                c();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1815f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.o;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f1818i = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f1817h = drawable != null ? new a(drawable) : null;
        super.setSelector(this.f1817h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1811b = rect.left;
        this.f1812c = rect.top;
        this.f1813d = rect.right;
        this.f1814e = rect.bottom;
    }

    public final boolean b() {
        return this.k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r0 != 3) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.MotionEvent r8, int r9) {
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
            r7.a(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.a(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            a.b.g.l.k r9 = r7.n
            if (r9 != 0) goto L5a
            a.b.g.l.k r9 = new a.b.g.l.k
            r9.<init>(r7)
            r7.n = r9
        L5a:
            a.b.g.l.k r9 = r7.n
            r9.a(r2)
            a.b.g.l.k r9 = r7.n
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            a.b.g.l.k r8 = r7.n
            if (r8 == 0) goto L6c
            r8.a(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.k.l0.a(android.view.MotionEvent, int):boolean");
    }

    public final void a(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    public final void a(Canvas canvas) {
        Drawable selector;
        if (this.f1810a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1810a);
        selector.draw(canvas);
    }

    public final void a(int i2, View view, float f2, float f3) {
        b(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        a.b.g.c.j.a.a(selector, f2, f3);
    }

    public final void a(int i2, View view) {
        Rect rect = this.f1810a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1811b;
        rect.top -= this.f1812c;
        rect.right += this.f1813d;
        rect.bottom += this.f1814e;
        try {
            boolean z = this.f1816g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1816g.set(this, Boolean.valueOf(!z));
                if (i2 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        this.k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1815f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        a.b.g.k.z zVar = this.m;
        if (zVar != null) {
            zVar.a();
            this.m = null;
        }
    }

    public final void a(View view, int i2, float f2, float f3) {
        View childAt;
        this.k = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f1815f;
        if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1815f = i2;
        float left = f2 - view.getLeft();
        float top = f3 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }
}
