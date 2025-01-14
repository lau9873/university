package a.b.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.view.View;
/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public class e extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f73a;

    /* renamed from: b  reason: collision with root package name */
    public View f74b;

    /* renamed from: c  reason: collision with root package name */
    public int f75c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f74b == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f74b.getLayoutParams();
        aVar2.k0.o(0);
        aVar.k0.p(aVar2.k0.t());
        aVar.k0.h(aVar2.k0.j());
        aVar2.k0.o(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f73a == -1 && !isInEditMode()) {
            setVisibility(this.f75c);
        }
        this.f74b = constraintLayout.findViewById(this.f73a);
        View view = this.f74b;
        if (view != null) {
            ((ConstraintLayout.a) view.getLayoutParams()).Z = true;
            this.f74b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f74b;
    }

    public int getEmptyVisibility() {
        return this.f75c;
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

    public void setContentId(int i2) {
        View findViewById;
        if (this.f73a == i2) {
            return;
        }
        View view = this.f74b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f74b.getLayoutParams()).Z = false;
            this.f74b = null;
        }
        this.f73a = i2;
        if (i2 == -1 || (findViewById = ((View) getParent()).findViewById(i2)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i2) {
        this.f75c = i2;
    }
}
