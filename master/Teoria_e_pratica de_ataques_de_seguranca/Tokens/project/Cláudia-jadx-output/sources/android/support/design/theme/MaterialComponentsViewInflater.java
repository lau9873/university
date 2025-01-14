package android.support.design.theme;

import a.b.d.n.a;
import a.b.h.k.g;
import android.content.Context;
import android.support.annotation.Keep;
import android.support.v7.app.AppCompatViewInflater;
import android.util.AttributeSet;
@Keep
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    @Override // android.support.v7.app.AppCompatViewInflater
    public g createButton(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}
