package p000a.p006b.p029f;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* renamed from: a.b.f.h0 */
/* loaded from: classes.dex */
public class ViewUtilsBase {
    /* renamed from: a */
    public void mo10521a(View view, float f) {
        Float f2 = (Float) view.getTag(C0119j.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    /* renamed from: b */
    public float mo10518b(View view) {
        Float f = (Float) view.getTag(C0119j.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    /* renamed from: c */
    public void mo10516c(View view) {
        if (view.getTag(C0119j.save_non_transition_alpha) == null) {
            view.setTag(C0119j.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    /* renamed from: a */
    public void mo10522a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(C0119j.save_non_transition_alpha, null);
        }
    }

    /* renamed from: b */
    public void mo10517b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo10517b(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    /* renamed from: a */
    public void mo10519a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo10519a(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    /* renamed from: a */
    public void mo10520a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
