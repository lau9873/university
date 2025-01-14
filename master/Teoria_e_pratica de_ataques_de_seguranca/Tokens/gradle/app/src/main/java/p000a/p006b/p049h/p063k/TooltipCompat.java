package p000a.p006b.p049h.p063k;

import android.os.Build;
import android.view.View;

/* renamed from: a.b.h.k.n1 */
/* loaded from: classes.dex */
public class TooltipCompat {
    /* renamed from: a */
    public static void m8181a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            TooltipCompatHandler.m8159a(view, charSequence);
        }
    }
}
