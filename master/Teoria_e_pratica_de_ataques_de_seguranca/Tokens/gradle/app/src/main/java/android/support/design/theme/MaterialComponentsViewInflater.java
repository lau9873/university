package android.support.design.theme;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.p067v7.app.AppCompatViewInflater;
import android.util.AttributeSet;
import p000a.p006b.p012d.p015n.MaterialButton;
import p000a.p006b.p049h.p063k.AppCompatButton;

@Keep
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    @Override // android.support.p067v7.app.AppCompatViewInflater
    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }
}
