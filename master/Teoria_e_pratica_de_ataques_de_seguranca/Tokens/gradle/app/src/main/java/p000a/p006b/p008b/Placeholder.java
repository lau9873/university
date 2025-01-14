package p000a.p006b.p008b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.view.View;

/* renamed from: a.b.b.e */
/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a */
    public int f150a;

    /* renamed from: b */
    public View f151b;

    /* renamed from: c */
    public int f152c;

    /* renamed from: a */
    public void m11240a(ConstraintLayout constraintLayout) {
        if (this.f151b == null) {
            return;
        }
        ConstraintLayout.C0520a c0520a = (ConstraintLayout.C0520a) getLayoutParams();
        ConstraintLayout.C0520a c0520a2 = (ConstraintLayout.C0520a) this.f151b.getLayoutParams();
        c0520a2.f3117k0.m11066o(0);
        c0520a.f3117k0.m11064p(c0520a2.f3117k0.m11057t());
        c0520a.f3117k0.m11080h(c0520a2.f3117k0.m11077j());
        c0520a2.f3117k0.m11066o(8);
    }

    /* renamed from: b */
    public void m11239b(ConstraintLayout constraintLayout) {
        if (this.f150a == -1 && !isInEditMode()) {
            setVisibility(this.f152c);
        }
        this.f151b = constraintLayout.findViewById(this.f150a);
        View view = this.f151b;
        if (view != null) {
            ((ConstraintLayout.C0520a) view.getLayoutParams()).f3095Z = true;
            this.f151b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f151b;
    }

    public int getEmptyVisibility() {
        return this.f152c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f150a == i) {
            return;
        }
        View view = this.f151b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.C0520a) this.f151b.getLayoutParams()).f3095Z = false;
            this.f151b = null;
        }
        this.f150a = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.f152c = i;
    }
}
