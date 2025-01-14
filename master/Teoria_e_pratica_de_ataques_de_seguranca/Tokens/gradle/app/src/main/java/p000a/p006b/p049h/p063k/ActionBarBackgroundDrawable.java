package p000a.p006b.p049h.p063k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.p067v7.widget.ActionBarContainer;

/* renamed from: a.b.h.k.b */
/* loaded from: classes.dex */
public class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a */
    public final ActionBarContainer f2534a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f2534a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f2534a;
        if (actionBarContainer.f3960h) {
            Drawable drawable = actionBarContainer.f3959g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f3957e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f2534a;
        Drawable drawable3 = actionBarContainer2.f3958f;
        if (drawable3 == null || !actionBarContainer2.f3961i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f2534a;
        if (actionBarContainer.f3960h) {
            Drawable drawable = actionBarContainer.f3959g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f3957e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
