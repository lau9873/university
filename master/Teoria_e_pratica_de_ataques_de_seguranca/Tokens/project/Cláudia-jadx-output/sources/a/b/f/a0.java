package a.b.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
public class a0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public a f479a;

    public a0(Context context, ViewGroup viewGroup, View view) {
        this.f479a = new a(context, viewGroup, view, this);
    }

    public static a0 c(View view) {
        ViewGroup d2 = d(view);
        if (d2 != null) {
            int childCount = d2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = d2.getChildAt(i2);
                if (childAt instanceof a) {
                    return ((a) childAt).f483d;
                }
            }
            return new u(d2.getContext(), d2, view);
        }
        return null;
    }

    public static ViewGroup d(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // a.b.f.c0
    public void a(Drawable drawable) {
        this.f479a.a(drawable);
    }

    @Override // a.b.f.c0
    public void b(Drawable drawable) {
        this.f479a.b(drawable);
    }

    /* compiled from: ViewOverlayApi14.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f480a;

        /* renamed from: b  reason: collision with root package name */
        public View f481b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Drawable> f482c;

        /* renamed from: d  reason: collision with root package name */
        public a0 f483d;

        static {
            try {
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public a(Context context, ViewGroup viewGroup, View view, a0 a0Var) {
            super(context);
            this.f482c = null;
            this.f480a = viewGroup;
            this.f481b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f483d = a0Var;
        }

        public void a(Drawable drawable) {
            if (this.f482c == null) {
                this.f482c = new ArrayList<>();
            }
            if (this.f482c.contains(drawable)) {
                return;
            }
            this.f482c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f482c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f480a.getLocationOnScreen(iArr);
            this.f481b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f481b.getWidth(), this.f481b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f482c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f482c.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f480a != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f480a instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f482c) != null && arrayList.contains(drawable));
        }

        public void b(View view) {
            super.removeView(view);
            if (a()) {
                this.f480a.removeView(this);
            }
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f480a && viewGroup.getParent() != null && a.b.g.k.u.w(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f480a.getLocationOnScreen(iArr2);
                    a.b.g.k.u.c(view, iArr[0] - iArr2[0]);
                    a.b.g.k.u.d(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public boolean a() {
            ArrayList<Drawable> arrayList;
            return getChildCount() == 0 && ((arrayList = this.f482c) == null || arrayList.size() == 0);
        }

        public final void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f480a.getLocationOnScreen(iArr2);
            this.f481b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }
}
