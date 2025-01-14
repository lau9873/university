package p000a.p006b.p030g.p045k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* renamed from: a.b.g.k.t */
/* loaded from: classes.dex */
public interface TintableBackgroundView {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
