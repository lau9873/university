package p000a.p006b.p030g.p048l;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtils.java */
/* renamed from: a.b.g.l.t */
/* loaded from: classes.dex */
public class C0321t {

    /* renamed from: a */
    public static final ThreadLocal<Matrix> f1870a = new ThreadLocal<>();

    /* renamed from: b */
    public static final ThreadLocal<RectF> f1871b = new ThreadLocal<>();

    /* renamed from: a */
    public static void m9158a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m9156b(viewGroup, view, rect);
    }

    /* renamed from: b */
    public static void m9156b(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f1870a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f1870a.set(matrix);
        } else {
            matrix.reset();
        }
        m9157a(viewGroup, view, matrix);
        RectF rectF = f1871b.get();
        if (rectF == null) {
            rectF = new RectF();
            f1871b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    public static void m9157a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m9157a(viewParent, view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
