package p000a.p006b.p012d.p013l;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p044j.SimpleArrayMap;

/* renamed from: a.b.d.l.h */
/* loaded from: classes.dex */
public class MotionSpec {

    /* renamed from: a */
    public final SimpleArrayMap<String, MotionTiming> f434a = new SimpleArrayMap<>();

    /* renamed from: a */
    public MotionTiming m10958a(String str) {
        if (m10955b(str)) {
            return this.f434a.get(str);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public boolean m10955b(String str) {
        return this.f434a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionSpec.class != obj.getClass()) {
            return false;
        }
        return this.f434a.equals(((MotionSpec) obj).f434a);
    }

    public int hashCode() {
        return this.f434a.hashCode();
    }

    public String toString() {
        return '\n' + MotionSpec.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f434a + "}\n";
    }

    /* renamed from: a */
    public void m10957a(String str, MotionTiming motionTiming) {
        this.f434a.put(str, motionTiming);
    }

    /* renamed from: a */
    public long m10962a() {
        int size = this.f434a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            MotionTiming m9607e = this.f434a.m9607e(i);
            j = Math.max(j, m9607e.m10954a() + m9607e.m10951b());
        }
        return j;
    }

    /* renamed from: a */
    public static MotionSpec m10959a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return m10960a(context, resourceId);
    }

    /* renamed from: a */
    public static MotionSpec m10960a(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return m10956a(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return m10956a(arrayList);
            }
            return null;
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    /* renamed from: a */
    public static MotionSpec m10956a(List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m10961a(motionSpec, list.get(i));
        }
        return motionSpec;
    }

    /* renamed from: a */
    public static void m10961a(MotionSpec motionSpec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.m10957a(objectAnimator.getPropertyName(), MotionTiming.m10952a((ValueAnimator) objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }
}
