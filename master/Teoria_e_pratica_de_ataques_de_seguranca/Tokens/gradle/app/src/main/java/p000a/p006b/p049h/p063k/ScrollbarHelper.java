package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import android.view.View;

/* renamed from: a.b.h.k.c1 */
/* loaded from: classes.dex */
public class ScrollbarHelper {
    /* renamed from: a */
    public static int m8480a(RecyclerView.C0702a0 c0702a0, OrientationHelper orientationHelper, View view, View view2, RecyclerView.AbstractC0722o abstractC0722o, boolean z, boolean z2) {
        int max;
        if (abstractC0722o.m6644e() == 0 || c0702a0.m6846a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(abstractC0722o.m6626l(view), abstractC0722o.m6626l(view2));
        int max2 = Math.max(abstractC0722o.m6626l(view), abstractC0722o.m6626l(view2));
        if (z2) {
            max = Math.max(0, (c0702a0.m6846a() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (z) {
            return Math.round((max * (Math.abs(orientationHelper.mo8015a(view2) - orientationHelper.mo8009d(view)) / (Math.abs(abstractC0722o.m6626l(view) - abstractC0722o.m6626l(view2)) + 1))) + (orientationHelper.mo8006f() - orientationHelper.mo8009d(view)));
        }
        return max;
    }

    /* renamed from: b */
    public static int m8479b(RecyclerView.C0702a0 c0702a0, OrientationHelper orientationHelper, View view, View view2, RecyclerView.AbstractC0722o abstractC0722o, boolean z) {
        if (abstractC0722o.m6644e() == 0 || c0702a0.m6846a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0702a0.m6846a();
        }
        return (int) (((orientationHelper.mo8015a(view2) - orientationHelper.mo8009d(view)) / (Math.abs(abstractC0722o.m6626l(view) - abstractC0722o.m6626l(view2)) + 1)) * c0702a0.m6846a());
    }

    /* renamed from: a */
    public static int m8481a(RecyclerView.C0702a0 c0702a0, OrientationHelper orientationHelper, View view, View view2, RecyclerView.AbstractC0722o abstractC0722o, boolean z) {
        if (abstractC0722o.m6644e() == 0 || c0702a0.m6846a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(abstractC0722o.m6626l(view) - abstractC0722o.m6626l(view2)) + 1;
        }
        return Math.min(orientationHelper.mo8004g(), orientationHelper.mo8015a(view2) - orientationHelper.mo8009d(view));
    }
}
