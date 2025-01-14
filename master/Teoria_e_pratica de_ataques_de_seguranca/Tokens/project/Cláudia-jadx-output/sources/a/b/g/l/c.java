package a.b.g.l;

import a.b.g.k.u;
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
/* compiled from: CircleImageView.java */
/* loaded from: classes.dex */
public class c extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Animation.AnimationListener f1204a;

    /* renamed from: b  reason: collision with root package name */
    public int f1205b;

    /* compiled from: CircleImageView.java */
    /* loaded from: classes.dex */
    public class a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        public RadialGradient f1206a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f1207b = new Paint();

        public a(int i2) {
            c.this.f1205b = i2;
            a((int) rect().width());
        }

        public final void a(int i2) {
            float f2 = i2 / 2;
            this.f1206a = new RadialGradient(f2, f2, c.this.f1205b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f1207b.setShader(this.f1206a);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = c.this.getWidth() / 2;
            float height = c.this.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.f1207b);
            canvas.drawCircle(width2, height, width - c.this.f1205b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    public c(Context context, int i2) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f1205b = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            u.a(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this.f1205b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f1205b, i4, i3, 503316480);
            int i5 = this.f1205b;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        u.a(this, shapeDrawable);
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f1204a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f1204a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f1205b * 2), getMeasuredHeight() + (this.f1205b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f1204a = animationListener;
    }
}
