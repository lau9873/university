package a.b.d.l;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* compiled from: AnimationUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f210a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f211b = new a.b.g.k.f0.b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f212c = new a.b.g.k.f0.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f213d = new a.b.g.k.f0.c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f214e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }
}
