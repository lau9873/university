package a.b.d.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* compiled from: MotionTiming.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public long f224a;

    /* renamed from: b  reason: collision with root package name */
    public long f225b;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f226c;

    /* renamed from: d  reason: collision with root package name */
    public int f227d;

    /* renamed from: e  reason: collision with root package name */
    public int f228e;

    public i(long j, long j2) {
        this.f224a = 0L;
        this.f225b = 300L;
        this.f226c = null;
        this.f227d = 0;
        this.f228e = 1;
        this.f224a = j;
        this.f225b = j2;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.f225b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f226c;
        return timeInterpolator != null ? timeInterpolator : a.f211b;
    }

    public int d() {
        return this.f227d;
    }

    public int e() {
        return this.f228e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }

    public static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return a.f212c;
            }
            return interpolator instanceof DecelerateInterpolator ? a.f213d : interpolator;
        }
        return a.f211b;
    }

    public long a() {
        return this.f224a;
    }

    public static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f227d = valueAnimator.getRepeatCount();
        iVar.f228e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f224a = 0L;
        this.f225b = 300L;
        this.f226c = null;
        this.f227d = 0;
        this.f228e = 1;
        this.f224a = j;
        this.f225b = j2;
        this.f226c = timeInterpolator;
    }
}
