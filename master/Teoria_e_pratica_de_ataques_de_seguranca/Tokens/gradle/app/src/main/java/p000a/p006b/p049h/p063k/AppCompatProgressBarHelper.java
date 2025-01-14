package p000a.p006b.p049h.p063k;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import p000a.p006b.p030g.p034c.p035j.WrappedDrawable;

/* renamed from: a.b.h.k.s */
/* loaded from: classes.dex */
public class AppCompatProgressBarHelper {

    /* renamed from: c */
    public static final int[] f2908c = {16843067, 16843068};

    /* renamed from: a */
    public final ProgressBar f2909a;

    /* renamed from: b */
    public Bitmap f2910b;

    public AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.f2909a = progressBar;
    }

    /* renamed from: a */
    public void mo8027a(AttributeSet attributeSet, int i) {
        TintTypedArray m8257a = TintTypedArray.m8257a(this.f2909a.getContext(), attributeSet, f2908c, i, 0);
        Drawable m8253c = m8257a.m8253c(0);
        if (m8253c != null) {
            this.f2909a.setIndeterminateDrawable(m8100a(m8253c));
        }
        Drawable m8253c2 = m8257a.m8253c(1);
        if (m8253c2 != null) {
            this.f2909a.setProgressDrawable(m8099a(m8253c2, false));
        }
        m8257a.m8265a();
    }

    /* renamed from: b */
    public Bitmap m8098b() {
        return this.f2910b;
    }

    /* renamed from: a */
    public final Drawable m8099a(Drawable drawable, boolean z) {
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable mo9839a = wrappedDrawable.mo9839a();
            if (mo9839a != null) {
                wrappedDrawable.mo9837a(m8099a(mo9839a, z));
                return drawable;
            }
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = m8099a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f2910b == null) {
                this.f2910b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(m8101a());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        } else {
            return drawable;
        }
    }

    /* renamed from: a */
    public final Drawable m8100a(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable m8099a = m8099a(animationDrawable.getFrame(i), true);
                m8099a.setLevel(10000);
                animationDrawable2.addFrame(m8099a, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* renamed from: a */
    public final Shape m8101a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }
}
