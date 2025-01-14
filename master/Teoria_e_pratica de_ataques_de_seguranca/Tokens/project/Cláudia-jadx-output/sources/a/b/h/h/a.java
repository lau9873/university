package a.b.h.h;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;
/* compiled from: AllCapsTransformationMethod.java */
/* loaded from: classes.dex */
public class a implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    public Locale f1449a;

    public a(Context context) {
        this.f1449a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f1449a);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i2, Rect rect) {
    }
}
