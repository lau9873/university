package p000a.p006b.p012d.p026x;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: a.b.d.x.e */
/* loaded from: classes.dex */
public class DescendantOffsetUtils {

    /* renamed from: a */
    public static final ThreadLocal<Matrix> f617a = new ThreadLocal<>();

    /* renamed from: b */
    public static final ThreadLocal<RectF> f618b = new ThreadLocal<>();

    /* renamed from: a */
    public static void m10797a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m10795b(viewGroup, view, rect);
    }

    /* renamed from: b */
    public static void m10795b(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f617a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f617a.set(matrix);
        } else {
            matrix.reset();
        }
        m10796a(viewGroup, view, matrix);
        RectF rectF = f618b.get();
        if (rectF == null) {
            rectF = new RectF();
            f618b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    public static void m10796a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m10796a(viewParent, view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
