package a.b.d.q;

import a.b.f.m;
import a.b.f.s;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;
/* compiled from: TextScale.java */
/* loaded from: classes.dex */
public class f extends m {

    /* compiled from: TextScale.java */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f285a;

        public a(f fVar, TextView textView) {
            this.f285a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f285a.setScaleX(floatValue);
            this.f285a.setScaleY(floatValue);
        }
    }

    @Override // a.b.f.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // a.b.f.m
    public void c(s sVar) {
        d(sVar);
    }

    public final void d(s sVar) {
        View view = sVar.f587b;
        if (view instanceof TextView) {
            sVar.f586a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // a.b.f.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        if (sVar == null || sVar2 == null || !(sVar.f587b instanceof TextView)) {
            return null;
        }
        View view = sVar2.f587b;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Map<String, Object> map = sVar.f586a;
            Map<String, Object> map2 = sVar2.f586a;
            float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
            float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
            if (floatValue == floatValue2) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
            ofFloat.addUpdateListener(new a(this, textView));
            return ofFloat;
        }
        return null;
    }
}
