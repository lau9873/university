package p000a.p006b.p012d.p013l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* renamed from: a.b.d.l.i */
/* loaded from: classes.dex */
public class MotionTiming {

    /* renamed from: a */
    public long f435a;

    /* renamed from: b */
    public long f436b;

    /* renamed from: c */
    public TimeInterpolator f437c;

    /* renamed from: d */
    public int f438d;

    /* renamed from: e */
    public int f439e;

    public MotionTiming(long j, long j2) {
        this.f435a = 0L;
        this.f436b = 300L;
        this.f437c = null;
        this.f438d = 0;
        this.f439e = 1;
        this.f435a = j;
        this.f436b = j2;
    }

    /* renamed from: a */
    public void m10953a(Animator animator) {
        animator.setStartDelay(m10954a());
        animator.setDuration(m10951b());
        animator.setInterpolator(m10949c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(m10948d());
            valueAnimator.setRepeatMode(m10947e());
        }
    }

    /* renamed from: b */
    public long m10951b() {
        return this.f436b;
    }

    /* renamed from: c */
    public TimeInterpolator m10949c() {
        TimeInterpolator timeInterpolator = this.f437c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.f422b;
    }

    /* renamed from: d */
    public int m10948d() {
        return this.f438d;
    }

    /* renamed from: e */
    public int m10947e() {
        return this.f439e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionTiming.class != obj.getClass()) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (m10954a() == motionTiming.m10954a() && m10951b() == motionTiming.m10951b() && m10948d() == motionTiming.m10948d() && m10947e() == motionTiming.m10947e()) {
            return m10949c().getClass().equals(motionTiming.m10949c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (m10954a() ^ (m10954a() >>> 32))) * 31) + ((int) (m10951b() ^ (m10951b() >>> 32)))) * 31) + m10949c().getClass().hashCode()) * 31) + m10948d()) * 31) + m10947e();
    }

    public String toString() {
        return '\n' + MotionTiming.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + m10954a() + " duration: " + m10951b() + " interpolator: " + m10949c().getClass() + " repeatCount: " + m10948d() + " repeatMode: " + m10947e() + "}\n";
    }

    /* renamed from: b */
    public static TimeInterpolator m10950b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return AnimationUtils.f423c;
            }
            return interpolator instanceof DecelerateInterpolator ? AnimationUtils.f424d : interpolator;
        }
        return AnimationUtils.f422b;
    }

    /* renamed from: a */
    public long m10954a() {
        return this.f435a;
    }

    /* renamed from: a */
    public static MotionTiming m10952a(ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), m10950b(valueAnimator));
        motionTiming.f438d = valueAnimator.getRepeatCount();
        motionTiming.f439e = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    public MotionTiming(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f435a = 0L;
        this.f436b = 300L;
        this.f437c = null;
        this.f438d = 0;
        this.f439e = 1;
        this.f435a = j;
        this.f436b = j2;
        this.f437c = timeInterpolator;
    }
}
