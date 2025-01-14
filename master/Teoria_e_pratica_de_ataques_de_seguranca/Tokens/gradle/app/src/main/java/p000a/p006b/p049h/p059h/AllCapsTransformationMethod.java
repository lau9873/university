package p000a.p006b.p049h.p059h;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: a.b.h.h.a */
/* loaded from: classes.dex */
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: a */
    public Locale f2199a;

    public AllCapsTransformationMethod(Context context) {
        this.f2199a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f2199a);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
