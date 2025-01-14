package a.b.h.k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;
/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
public class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f1661a;

    public b(ActionBarContainer actionBarContainer) {
        this.f1661a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1661a;
        if (actionBarContainer.f2479h) {
            Drawable drawable = actionBarContainer.f2478g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2476e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1661a;
        Drawable drawable3 = actionBarContainer2.f2477f;
        if (drawable3 == null || !actionBarContainer2.f2480i) {
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
        ActionBarContainer actionBarContainer = this.f1661a;
        if (actionBarContainer.f2479h) {
            Drawable drawable = actionBarContainer.f2478g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2476e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
