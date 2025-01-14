package p000a.p006b.p029f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* renamed from: a.b.f.a */
/* loaded from: classes.dex */
public class AnimatorUtils {

    /* compiled from: AnimatorUtils.java */
    /* renamed from: a.b.f.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0094a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    /* renamed from: a */
    public static void m10575a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    /* renamed from: b */
    public static void m10574b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0094a) {
                    ((InterfaceC0094a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10576a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0094a) {
                    ((InterfaceC0094a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }
}
