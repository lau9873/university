package a.b.h.k;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public class c1 {
    public static int a(RecyclerView.a0 a0Var, w0 w0Var, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        int max;
        if (oVar.e() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.l(view), oVar.l(view2));
        int max2 = Math.max(oVar.l(view), oVar.l(view2));
        if (z2) {
            max = Math.max(0, (a0Var.a() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (z) {
            return Math.round((max * (Math.abs(w0Var.a(view2) - w0Var.d(view)) / (Math.abs(oVar.l(view) - oVar.l(view2)) + 1))) + (w0Var.f() - w0Var.d(view)));
        }
        return max;
    }

    public static int b(RecyclerView.a0 a0Var, w0 w0Var, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.e() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.a();
        }
        return (int) (((w0Var.a(view2) - w0Var.d(view)) / (Math.abs(oVar.l(view) - oVar.l(view2)) + 1)) * a0Var.a());
    }

    public static int a(RecyclerView.a0 a0Var, w0 w0Var, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.e() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.l(view) - oVar.l(view2)) + 1;
        }
        return Math.min(w0Var.g(), w0Var.a(view2) - w0Var.d(view));
    }
}
