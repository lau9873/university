package a.b.h.k;

import android.os.Build;
import android.view.View;
/* compiled from: TooltipCompat.java */
/* loaded from: classes.dex */
public class n1 {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            o1.a(view, charSequence);
        }
    }
}
