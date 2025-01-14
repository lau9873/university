package p000a.p006b.p030g.p048l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* renamed from: a.b.g.l.r */
/* loaded from: classes.dex */
public interface TintableImageSourceView {
    ColorStateList getSupportImageTintList();

    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(PorterDuff.Mode mode);
}
