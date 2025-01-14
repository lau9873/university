package a.b.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;
/* compiled from: AnimatorUtils.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: AnimatorUtils.java */
    /* renamed from: a.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0011a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    public static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                Animator.AnimatorListener animatorListener = listeners.get(i2);
                if (animatorListener instanceof InterfaceC0011a) {
                    ((InterfaceC0011a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }

    public static void a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                Animator.AnimatorListener animatorListener = listeners.get(i2);
                if (animatorListener instanceof InterfaceC0011a) {
                    ((InterfaceC0011a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }
}
