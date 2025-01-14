package p000a.p006b.p029f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.f.a0 */
/* loaded from: classes.dex */
public class ViewOverlayApi14 implements ViewOverlayImpl {

    /* renamed from: a */
    public C0095a f847a;

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f847a = new C0095a(context, viewGroup, view, this);
    }

    /* renamed from: c */
    public static ViewOverlayApi14 m10573c(View view) {
        ViewGroup m10572d = m10572d(view);
        if (m10572d != null) {
            int childCount = m10572d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = m10572d.getChildAt(i);
                if (childAt instanceof C0095a) {
                    return ((C0095a) childAt).f851d;
                }
            }
            return new ViewGroupOverlayApi14(m10572d.getContext(), m10572d, view);
        }
        return null;
    }

    /* renamed from: d */
    public static ViewGroup m10572d(View view) {
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

    @Override // p000a.p006b.p029f.ViewOverlayImpl
    /* renamed from: a */
    public void mo10427a(Drawable drawable) {
        this.f847a.m10570a(drawable);
    }

    @Override // p000a.p006b.p029f.ViewOverlayImpl
    /* renamed from: b */
    public void mo10426b(Drawable drawable) {
        this.f847a.m10567b(drawable);
    }

    /* compiled from: ViewOverlayApi14.java */
    /* renamed from: a.b.f.a0$a */
    /* loaded from: classes.dex */
    public static class C0095a extends ViewGroup {

        /* renamed from: a */
        public ViewGroup f848a;

        /* renamed from: b */
        public View f849b;

        /* renamed from: c */
        public ArrayList<Drawable> f850c;

        /* renamed from: d */
        public ViewOverlayApi14 f851d;

        static {
            try {
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public C0095a(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.f850c = null;
            this.f848a = viewGroup;
            this.f849b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f851d = viewOverlayApi14;
        }

        /* renamed from: a */
        public void m10570a(Drawable drawable) {
            if (this.f850c == null) {
                this.f850c = new ArrayList<>();
            }
            if (this.f850c.contains(drawable)) {
                return;
            }
            this.f850c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        /* renamed from: b */
        public void m10567b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f850c;
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
            this.f848a.getLocationOnScreen(iArr);
            this.f849b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f849b.getWidth(), this.f849b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f850c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f850c.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f848a != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f848a instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    m10568a(iArr2);
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
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f850c) != null && arrayList.contains(drawable));
        }

        /* renamed from: b */
        public void m10566b(View view) {
            super.removeView(view);
            if (m10571a()) {
                this.f848a.removeView(this);
            }
        }

        /* renamed from: a */
        public void m10569a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f848a && viewGroup.getParent() != null && ViewCompat.m9410w(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f848a.getLocationOnScreen(iArr2);
                    ViewCompat.m9435c(view, iArr[0] - iArr2[0]);
                    ViewCompat.m9433d(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        /* renamed from: a */
        public boolean m10571a() {
            ArrayList<Drawable> arrayList;
            return getChildCount() == 0 && ((arrayList = this.f850c) == null || arrayList.size() == 0);
        }

        /* renamed from: a */
        public final void m10568a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f848a.getLocationOnScreen(iArr2);
            this.f849b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }
}
