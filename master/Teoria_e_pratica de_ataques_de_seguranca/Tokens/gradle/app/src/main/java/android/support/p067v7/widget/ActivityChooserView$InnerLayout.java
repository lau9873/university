package android.support.p067v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: android.support.v7.widget.ActivityChooserView$InnerLayout */
/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: a */
    public static final int[] f4025a = {16842964};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray m8258a = TintTypedArray.m8258a(context, attributeSet, f4025a);
        setBackgroundDrawable(m8258a.m8256b(0));
        m8258a.m8265a();
    }
}
