package p000a.p006b.p030g.p048l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.g.l.c */
/* loaded from: classes.dex */
public class CircleImageView extends ImageView {

    /* renamed from: a */
    public Animation.AnimationListener f1776a;

    /* renamed from: b */
    public int f1777b;

    /* compiled from: CircleImageView.java */
    /* renamed from: a.b.g.l.c$a */
    /* loaded from: classes.dex */
    public class C0310a extends OvalShape {

        /* renamed from: a */
        public RadialGradient f1778a;

        /* renamed from: b */
        public Paint f1779b = new Paint();

        public C0310a(int i) {
            CircleImageView.this.f1777b = i;
            m9292a((int) rect().width());
        }

        /* renamed from: a */
        public final void m9292a(int i) {
            float f = i / 2;
            this.f1778a = new RadialGradient(f, f, CircleImageView.this.f1777b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f1779b.setShader(this.f1778a);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.f1779b);
            canvas.drawCircle(width2, height, width - CircleImageView.this.f1777b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            m9292a((int) f);
        }
    }

    public CircleImageView(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f1777b = (int) (3.5f * f);
        if (m9294a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.m9458a(this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0310a(this.f1777b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f1777b, i3, i2, 503316480);
            int i4 = this.f1777b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.m9447a(this, shapeDrawable);
    }

    /* renamed from: a */
    public final boolean m9294a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f1776a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f1776a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (m9294a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f1777b * 2), getMeasuredHeight() + (this.f1777b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    /* renamed from: a */
    public void m9293a(Animation.AnimationListener animationListener) {
        this.f1776a = animationListener;
    }
}
