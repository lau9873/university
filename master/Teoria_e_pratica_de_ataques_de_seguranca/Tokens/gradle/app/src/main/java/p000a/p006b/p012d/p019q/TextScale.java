package p000a.p006b.p012d.p019q;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;
import p000a.p006b.p029f.Transition;
import p000a.p006b.p029f.TransitionValues;

/* renamed from: a.b.d.q.f */
/* loaded from: classes.dex */
public class TextScale extends Transition {

    /* compiled from: TextScale.java */
    /* renamed from: a.b.d.q.f$a */
    /* loaded from: classes.dex */
    public class C0060a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ TextView f539a;

        public C0060a(TextScale textScale, TextView textView) {
            this.f539a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f539a.setScaleX(floatValue);
            this.f539a.setScaleY(floatValue);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10449a(TransitionValues transitionValues) {
        m10869d(transitionValues);
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: c */
    public void mo10440c(TransitionValues transitionValues) {
        m10869d(transitionValues);
    }

    /* renamed from: d */
    public final void m10869d(TransitionValues transitionValues) {
        View view = transitionValues.f1000b;
        if (view instanceof TextView) {
            transitionValues.f999a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public Animator mo10488a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.f1000b instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.f1000b;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Map<String, Object> map = transitionValues.f999a;
            Map<String, Object> map2 = transitionValues2.f999a;
            float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
            float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
            if (floatValue == floatValue2) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
            ofFloat.addUpdateListener(new C0060a(this, textView));
            return ofFloat;
        }
        return null;
    }
}
