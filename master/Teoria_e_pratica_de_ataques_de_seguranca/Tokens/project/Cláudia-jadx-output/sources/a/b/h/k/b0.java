package a.b.h.k;

import a.b.h.k.a1;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
/* compiled from: CardViewApi17Impl.java */
/* loaded from: classes.dex */
public class b0 extends d0 {

    /* compiled from: CardViewApi17Impl.java */
    /* loaded from: classes.dex */
    public class a implements a1.a {
        public a(b0 b0Var) {
        }

        @Override // a.b.h.k.a1.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    @Override // a.b.h.k.d0, a.b.h.k.f0
    public void a() {
        a1.r = new a(this);
    }
}
